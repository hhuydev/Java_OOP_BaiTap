/**
 * 
 */
package tuan3GiaoDich;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyGiaoDich {
	ArrayList<GiaoDich> qlGD;

	public QuanLyGiaoDich() {
		qlGD = new ArrayList<GiaoDich>();
	}

	public ArrayList<GiaoDich> getALLGD() {
		return qlGD;
	}

	public boolean themGD(GiaoDich x) throws Exception {
		if (qlGD.contains(x)) {
			throw new Exception("Trùng mã giao dịch!");
		} else {
			qlGD.add(x);
			return true;
		}

	}

	public GiaoDich timGD(String maGD) {
		for (GiaoDich x : qlGD) {
			if (x.getMaGD().equalsIgnoreCase(maGD)) {
				return x;
			}
		}
		return null;
	}

	public void sua(GiaoDich s) {
		int vitri = qlGD.indexOf(s);
		qlGD.set(vitri, s);
	}

	public boolean xoaGD(String maGD) {
		GiaoDich x = timGD(maGD);
		if (x != null) {
			qlGD.remove(x);
			return true;
		} else
			return false;
	}

	public double tongSLGDVang() {
		double s = 0;
		for (GiaoDich x : qlGD) {
			if (x instanceof GiaoDichVang)
				s += x.getSoLuong();
		}
		return s;
	}

	public double tongSLGDTien() {
		double s = 0;
		for (GiaoDich x : qlGD) {
			if (x instanceof GiaoDichTienTe)
				s += x.getSoLuong();
		}
		return s;
	}

	public void sapXepTheoThanhTienGD() {
		Collections.sort(qlGD, new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich gd1, GiaoDich gd2) {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				Double tt1 = new Double(gd1.thanhTien());
				@SuppressWarnings("deprecation")
				Double tt2 = new Double(gd2.thanhTien());
				return tt1.compareTo(tt2);
			}
		});
	}

	public double trungBinhCongTienTe() {
		int dem = 0;
		double s = 0;
		for (GiaoDich x : qlGD) {
			if (x instanceof GiaoDichTienTe) {
				++dem;
				s += x.thanhTien();
			}
		}
		return s / dem;
	}

	public GiaoDich giaoDichHon1Ty() {
		for (GiaoDich x : qlGD) {
			if (x.getDonGia() > 1000000000) {
				return x;
			}
		}
		return null;
	}

}
