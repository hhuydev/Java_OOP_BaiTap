/**
 * 
 */
package tuan4NhaDat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachGiaoDich {
	ArrayList<GiaoDich> qLGD;

	public DanhSachGiaoDich() {
		qLGD = new ArrayList<GiaoDich>();
	}

	public ArrayList<GiaoDich> getAllGD() {
		return qLGD;
	}

	public boolean themGD(GiaoDich x) throws Exception {
		if (qLGD.contains(x))
			throw new Exception("Trùng mã giao dịch!");
		else {
			qLGD.add(x);
			return true;
		}

	}

	public GiaoDich timGD(String maGD) {
		for (GiaoDich x : qLGD) {
			if (x.getMaGD().equalsIgnoreCase(maGD)) {
				return x;
			}
		}
		return null;
	}

	public void sua(GiaoDich s) {
		int vitri = qLGD.indexOf(s);
		qLGD.set(vitri, s);
	}

	public boolean xoaGD(String maGD) {
		GiaoDich x = timGD(maGD);
		if (x != null) {
			qLGD.remove(x);
			return true;
		} else
			return false;
	}

	public int tongSoLuongGDDat() {
		int dem = 0;
		for (GiaoDich x : qLGD) {
			if (x instanceof GiaoDichDat)
				++dem;
		}
		return dem;
	}

	public int tongSoLuongGDNha() {
		int dem = 0;
		for (GiaoDich x : qLGD) {
			if (x instanceof GiaoDichNha)
				++dem;
		}
		return dem;
	}

	public double trungBinhGDDat() {
		double s = 0;
		int dem = 0;
		for (GiaoDich x : qLGD) {
			if (x instanceof GiaoDichDat) {
				++dem;
				s += x.thanhTien();
			}
		}
		return s / dem;
	}

	public void sapXepTheoThanhTienGD() {
		Collections.sort(qLGD, new Comparator<GiaoDich>() {
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

	public ArrayList<GiaoDich> lay2013() {
		ArrayList<GiaoDich> temp = new ArrayList<GiaoDich>();
		for (GiaoDich x : qLGD) {
			if (x.getNgayGD().getTime().getYear() + 1900 == 2013 && x.getNgayGD().getTime().getMonth() == 10) {
				temp.add(x);
			}
		}
		return temp;
	}
}
