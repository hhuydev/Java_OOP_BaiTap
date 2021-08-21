/**
 * 
 */
package tuan5PhongHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyPhongHoc {
	ArrayList<PhongHoc> dSPhongHoc;

	public QuanLyPhongHoc() {
		dSPhongHoc = new ArrayList<PhongHoc>();
	}

	public ArrayList<PhongHoc> getdSPhongHoc() {
		return dSPhongHoc;
	}

	public boolean themPhongHoc(PhongHoc x) throws Exception {
		if (dSPhongHoc.contains(x)) {
			throw new Exception("Trùng mã phòng!");
		} else {
			dSPhongHoc.add(x);
			return true;
		}

	}

	public PhongHoc timPhongHoc(String maPhong) {
		for (PhongHoc x : dSPhongHoc) {
			if (x.getMaPhong().equalsIgnoreCase(maPhong))
				return x;
		}
		return null;
	}

	public boolean xoaPhongHoc(String maPhong) {
		PhongHoc x = timPhongHoc(maPhong);
		if (x != null) {
			dSPhongHoc.remove(x);
			return true;
		} else
			return false;
	}

	public void sua(PhongHoc x) {
		int vitri = dSPhongHoc.indexOf(x);
		dSPhongHoc.set(vitri, x);
	}

	public ArrayList<PhongHoc> danhSachPhongDatChuan() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for (PhongHoc x : dSPhongHoc) {
			if (x.phongDatChuan()) {
				temp.add(x);
			}
		}
		if (temp.size() == 0)
			return null;
		else
			return temp;
	}

	public void sapXepDayNha() {
		Collections.sort(dSPhongHoc, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc phong1, PhongHoc phong2) {
				return phong1.getDayNha().compareToIgnoreCase(phong2.getDayNha());
			}
		});
	}

	public void sapXepDienTich() {
		Collections.sort(dSPhongHoc, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc phong1, PhongHoc phong2) {
				@SuppressWarnings("deprecation")
				Float dienTich1 = new Float(phong1.getDienTich());
				@SuppressWarnings("deprecation")
				Float dienTich2 = new Float(phong2.getDienTich());

				return dienTich1.compareTo(dienTich2);
			}
		});
	}

	public void sapXepBongDen() {
		Collections.sort(dSPhongHoc, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc phong1, PhongHoc phong2) {
				@SuppressWarnings("deprecation")
				Integer bongden1 = new Integer(phong1.getSoBongDen());
				@SuppressWarnings("deprecation")
				Integer bongden2 = new Integer(phong2.getSoBongDen());

				return bongden1.compareTo(bongden2);
			}
		});
	}

	public int tongPhongHoc() {
		int dem = 0;
		for (int i = 0; i < dSPhongHoc.size(); i++) {
			++dem;
		}
		return dem;
	}

	public ArrayList<PhongHoc> thongTinPhongMayTinhTren60May() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for (PhongHoc x : dSPhongHoc) {
			if (x instanceof PhongMayTinh && ((PhongMayTinh) x).getSoMayTinh() == 60) {
				temp.add(x);
			}
		}
		if (temp.size() == 0)
			return null;
		else
			return temp;
	}

	public PhongHoc suaSoMayPhongMayTinh(PhongHoc ph, int soMay) throws Exception {
		// TODO Auto-generated method stub
		if (((PhongMayTinh) ph) instanceof PhongMayTinh) {
			((PhongMayTinh) ph).setSoMayTinh(soMay);
			return ((PhongMayTinh) ph);
		} else
			return null;

	}
}
