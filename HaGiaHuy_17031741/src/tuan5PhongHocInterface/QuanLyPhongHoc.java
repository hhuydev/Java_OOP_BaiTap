/**
 * 
 */
package tuan5PhongHocInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyPhongHoc implements ChucNangPhongHoc {
	ArrayList<PhongHoc> dSPhongHoc;

	public QuanLyPhongHoc() {
		dSPhongHoc = new ArrayList<PhongHoc>();
	}

	public ArrayList<PhongHoc> getdSPhongHoc() {
		return dSPhongHoc;
	}

	@Override
	public void sua(PhongHoc x) {
		// TODO Auto-generated method stub
		int vitri = dSPhongHoc.indexOf(x);
		dSPhongHoc.set(vitri, x);
	}

	@Override
	public boolean xoaPhongHoc(String maPhong) {
		// TODO Auto-generated method stub
		PhongHoc x = timPhongHoc(maPhong);
		if (x != null) {
			dSPhongHoc.remove(x);
			return true;
		} else
			return false;
	}

	@Override
	public PhongHoc timPhongHoc(String maPhong) {
		// TODO Auto-generated method stub
		for (PhongHoc x : dSPhongHoc) {
			if (x.getMaPhong().equalsIgnoreCase(maPhong))
				return x;
		}
		return null;
	}

	@Override
	public boolean themPhongHoc(PhongHoc x) throws Exception {
		// TODO Auto-generated method stub
		if (dSPhongHoc.contains(x)) {
			throw new Exception("Trùng mã phòng!");
		} else {
			dSPhongHoc.add(x);
			return true;
		}
	}

	@Override
	public ArrayList<PhongHoc> danhSachPhongDatChuan() {
		// TODO Auto-generated method stub
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

	@Override
	public ArrayList<PhongHoc> thongTinPhongMayTinhTren60May() {
		// TODO Auto-generated method stub
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

	@Override
	public void sapXepBongDen() {
		// TODO Auto-generated method stub
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

	@Override
	public int tongPhongHoc() {
		// TODO Auto-generated method stub
		int dem = 0;
		for (int i = 0; i < dSPhongHoc.size(); i++) {
			++dem;
		}
		return dem;
	}

	@Override
	public void sapXepDienTich() {
		// TODO Auto-generated method stub
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

	@Override
	public void sapXepDayNha() {
		// TODO Auto-generated method stub
		Collections.sort(dSPhongHoc, new Comparator<PhongHoc>() {
			@Override
			public int compare(PhongHoc phong1, PhongHoc phong2) {
				return phong1.getDayNha().compareToIgnoreCase(phong2.getDayNha());
			}
		});
	}

	@Override
	public PhongHoc suaSoMayPhongMayTinh(PhongHoc ph, int soMay) throws Exception {
		// TODO Auto-generated method stub
		if (((PhongMayTinh) ph) instanceof PhongMayTinh) {
			((PhongMayTinh) ph).setSoMayTinh(soMay);
			return ((PhongMayTinh) ph);
		} else
			return null;

	}

}
