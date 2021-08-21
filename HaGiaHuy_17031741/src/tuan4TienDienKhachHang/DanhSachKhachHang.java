/**
 * 
 */
package tuan4TienDienKhachHang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachKhachHang {
	ArrayList<KhachHang> qLKH;

	public DanhSachKhachHang() {
		qLKH = new ArrayList<KhachHang>();
	}

	public ArrayList<KhachHang> getAllKH() {
		return qLKH;
	}

	public boolean themKH(KhachHang kh) throws Exception {
		if (qLKH.contains(kh))
			throw new Exception("Trùng mã khách hàng!");
		else {
			qLKH.add(kh);
			return true;
		}

	}

	public KhachHang timKH(String maKH) {
		for (KhachHang x : qLKH) {
			if (x.getMaKH().equalsIgnoreCase(maKH)) {
				return x;
			}
		}
		return null;
	}

	public void sua(KhachHang s) {
		int vitri = qLKH.indexOf(s);
		qLKH.set(vitri, s);
	}

	public boolean xoaKH(String makH) {
		KhachHang x = timKH(makH);
		if (x != null) {
			qLKH.remove(x);
			return true;
		} else
			return false;
	}

	public int tongSoLuongKHVN() {
		int dem = 0;
		for (KhachHang x : qLKH) {
			if (x instanceof KhachHangVN)
				++dem;
		}
		return dem;
	}

	public int tongSoLuongKHNgoai() {
		int dem = 0;
		for (KhachHang x : qLKH) {
			if (x instanceof KhachHangNuocNgoai)
				++dem;
		}
		return dem;
	}

	public double trungBinhKHNuocNgoai() {
		double s = 0;
		int dem = 0;
		for (KhachHang x : qLKH) {
			if (x instanceof KhachHangNuocNgoai) {
				++dem;
				s += x.thanhTien();
			}
		}
		return s / dem;
	}

	public void sapXepTheoThanhTien() {
		Collections.sort(qLKH, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang kh1, KhachHang kh2) {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				Double tt1 = new Double(kh1.thanhTien());
				@SuppressWarnings("deprecation")
				Double tt2 = new Double(kh2.thanhTien());
				return tt1.compareTo(tt2);
			}
		});
	}

	public ArrayList<KhachHang> lay2013KHNgoai() {
		ArrayList<KhachHang> temp = new ArrayList<KhachHang>();
		for (KhachHang x : qLKH) {
			if (x.getNgayLapHD().getTime().getYear() + 1900 == 2013 && x.getNgayLapHD().getTime().getMonth() == 10
					&& x instanceof KhachHangNuocNgoai) {
				temp.add(x);
			}
		}
		return temp;
	}

	public ArrayList<KhachHang> lay2013KHVN() {
		ArrayList<KhachHang> temp = new ArrayList<KhachHang>();
		for (KhachHang x : qLKH) {
			if (x.getNgayLapHD().getTime().getYear() + 1900 == 2013 && x.getNgayLapHD().getTime().getMonth() == 10
					&& x instanceof KhachHangVN) {
				temp.add(x);
			}
		}
		return temp;
	}
}
