/**
 * 
 */
package tuan6VeTau;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyVeKH implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Queue<KhachHang> dsKHDoiVe;
	public Queue<KhachHang> dsKHDaMuaVe = new ArrayDeque<KhachHang>();

	public QuanLyVeKH() {
		dsKHDoiVe = new ArrayDeque<KhachHang>();
	}

	public Queue<KhachHang> getdsKHDoiVe() {
		return dsKHDoiVe;
	}

	public Queue<KhachHang> getDsKHDaMuaVe() {
		return dsKHDaMuaVe;
	}

	public KhachHang themKH(KhachHang x) throws Exception {
		// TODO Auto-generated method stub
		if (dsKHDoiVe.contains(x)) {
			throw new Exception("Khách hàng đã tồn tại!");
		} else {
			dsKHDoiVe.add(x);
			return x;
		}
	}

	public KhachHang banVeKHPhaiDau() {
		if (dsKHDoiVe.size() == 0)
			return null;
		KhachHang kh = dsKHDoiVe.peek();
		dsKHDaMuaVe.add(kh);
		return kh;

	}

	public double tongTienVeDaBan() {
		double s = 0;
		for (KhachHang khachHang : dsKHDaMuaVe) {
			s += khachHang.getGiaTien();
		}
		return s;
	}

	public boolean xoaKH(String cmnd) {
		// TODO Auto-generated method stub
		KhachHang kh = timKH(cmnd);
		if (kh != null) {
			dsKHDoiVe.remove(kh);
			return true;
		} else
			return false;
	}

	public KhachHang timKH(String cmnd) {
		// TODO Auto-generated method stub
		for (KhachHang x : dsKHDoiVe) {
			if (x.getCmnd().equalsIgnoreCase(cmnd))
				return x;
		}
		return null;
	}

	public Map<String, Integer> thongKeSoVeTungGa() {
		Map<String, Integer> bangThongKe = new TreeMap<String, Integer>();
		for (KhachHang kh : dsKHDaMuaVe) {
			String ga = kh.getGaDen();
			if (bangThongKe.containsKey(ga))
				bangThongKe.put(ga, bangThongKe.get(ga) + 1);
			else
				bangThongKe.put(ga, 1);
		}
		return bangThongKe;
	}

	public Queue<KhachHang> docDuLieuTuFile() throws Exception {
		return DocGhiFile.docFile();
	}

}
