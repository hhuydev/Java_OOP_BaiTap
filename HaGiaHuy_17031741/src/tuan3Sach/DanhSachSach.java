/**
 * 
 */
package tuan3Sach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachSach {
	ArrayList<Sach> lstSach;

	public ArrayList<Sach> getLstSach() {
		return lstSach;
	}

	public DanhSachSach() {
		lstSach = new ArrayList<Sach>();
	}

	public boolean themSach(Sach s) throws Exception {
		if (lstSach.contains(s)) {
			throw new Exception("Trùng mã sách!");
		} else {
			lstSach.add(s);
			return true;
		}
	}

	public Sach timSach(String maSach) {
		for (Sach x : lstSach) {
			if (x.getMaSach().equalsIgnoreCase(maSach))
				return x;
		}
		return null;
	}

	public boolean xoaSach(String maSach) {
		Sach s = timSach(maSach);
		if (s != null) {
			lstSach.remove(s);
			return true;
		} else
			return false;
	}

	public void sua(Sach s) {
		int vitri = lstSach.indexOf(s);
		lstSach.set(vitri, s);
	}

	public long khoangCachGiuaHaiNgay(String maSach1, String maSach2) {
		Sach s1, s2;
		s1 = timSach(maSach1);
		s2 = timSach(maSach2);
		if (s1 != null && s2 != null) {
			GregorianCalendar ngay1 = s1.getNgayNhap();
			GregorianCalendar ngay2 = s2.getNgayNhap();
			long khoangNgay = (ngay2.getTime().getTime() - ngay1.getTime().getTime()) / (24 * 60 * 60 * 1000);
			return khoangNgay;
		} else
			return -1;
	}

	public double trungBinhDonGiaSTK() {
		double s = 0;
		int dem = 0;
		for (Sach x : lstSach) {
			if (x instanceof SachThamKhao) {
				++dem;
				s += x.getDonGia();
			}
		}
		return s / dem;
	}

	public double tongTienSachGK() {
		double s = 0;
		for (Sach x : lstSach) {
			if (x instanceof SachGiaoKhoa)
				s += x.getDonGia();
		}
		return s;
	}

	public double tongTienSachTK() {
		double s = 0;
		for (Sach x : lstSach) {
			if (x instanceof SachThamKhao)
				s += x.getDonGia();
		}
		return s;
	}

	public void sapXepTheoDonGia() {
		Collections.sort(lstSach, new Comparator<Sach>() {

			@Override
			public int compare(Sach s1, Sach s2) {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				Double dg1 = new Double(s1.thanhTien());
				@SuppressWarnings("deprecation")
				Double dg2 = new Double(s2.thanhTien());
				return dg1.compareTo(dg2);
			}
		});
	}

	public boolean kiemTratrungMa(String maSach) {
		for (Sach sach : lstSach) {
			if (sach.getMaSach().equalsIgnoreCase(maSach))
				return true;
		}
		return false;
	}

	public Sach timTenNXB(String timtenNXB) {
		for (Sach x : lstSach) {
			if (x.getNhaXBan().equalsIgnoreCase(timtenNXB)) {
				return x;
			}
		}
		return null;
	}

}
