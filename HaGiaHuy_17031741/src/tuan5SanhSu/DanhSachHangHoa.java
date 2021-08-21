/**
 * 
 */
package tuan5SanhSu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachHangHoa {
	ArrayList<HangHoa> dSHangHoa;

	public DanhSachHangHoa() {
		dSHangHoa = new ArrayList<HangHoa>();
	}

	public ArrayList<HangHoa> getdSHangHoa() {
		return dSHangHoa;
	}

	public void sua(HangHoa hh) {
		// TODO Auto-generated method stub
		int vitri = dSHangHoa.indexOf(hh);
		dSHangHoa.set(vitri, hh);
	}

	public boolean xoaHangHoa(String maHang) {
		// TODO Auto-generated method stub
		HangHoa hh = timHangHoa(maHang);
		if (hh != null) {
			dSHangHoa.remove(hh);
			return true;
		} else
			return false;
	}

	public HangHoa timHangHoa(String maPhong) {
		// TODO Auto-generated method stub
		for (HangHoa x : dSHangHoa) {
			if (x.getMaHang().equalsIgnoreCase(maPhong))
				return x;
		}
		return null;
	}

	public boolean themHangHoa(HangHoa x) throws Exception {
		// TODO Auto-generated method stub
		if (dSHangHoa.contains(x)) {
			throw new Exception("Trùng mã hàng hóa!");
		} else {
			dSHangHoa.add(x);
			return true;
		}
	}

	public void sapXepTheoTenHang() {
		Collections.sort(dSHangHoa, new Comparator<HangHoa>() {
			public int compare(HangHoa h1, HangHoa h2) {
				return h1.getTenHang().compareToIgnoreCase(h2.getTenHang());
			}
		});
	}

	public void sapXepTheoSoLuongTon() {
		Collections.sort(dSHangHoa, new Comparator<HangHoa>() {
			public int compare(HangHoa h1, HangHoa h2) {
				return Integer.compare(h2.getSoLuong(), h1.getSoLuong());
			}
		});
	}

	public ArrayList<HangHoa> danhSachHangKhoBan() {
		ArrayList<HangHoa> arr = new ArrayList<HangHoa>();
		for (HangHoa hh : dSHangHoa) {
			if (hh instanceof HangThucPham)
				if (hh.danhGia().equalsIgnoreCase("Kho ban"))
					arr.add(hh);
		}
		if (arr.size() > 0)
			return arr;
		else
			return null;
	}

	public HangHoa suaCongSuatDienMay(HangHoa hh, int congSuat) throws Exception {
		// TODO Auto-generated method stub
		if (((HangDienMay) hh) instanceof HangDienMay) {
			((HangDienMay) hh).setCongSuat(congSuat);
			return ((HangDienMay) hh);
		} else
			return null;

	}

}
