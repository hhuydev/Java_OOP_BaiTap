/**
 * 
 */
package tuan6TrueLove_Bai123;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyNhanVien {
	ArrayList<NhanVien> dsNhanVien;

	public QuanLyNhanVien() {
		dsNhanVien = new ArrayList<NhanVien>();
	}

	public ArrayList<NhanVien> getDSNhanVien() {
		return dsNhanVien;
	}

	public void sua(NhanVien nv) {
		// TODO Auto-generated method stub
		int vitri = dsNhanVien.indexOf(nv);
		dsNhanVien.set(vitri, nv);
	}

	public boolean xoaNV(String maNV) {
		// TODO Auto-generated method stub
		NhanVien nv = timNV(maNV);
		if (nv != null) {
			dsNhanVien.remove(nv);
			return true;
		} else
			return false;
	}

	public NhanVien timNV(String maNV) {
		// TODO Auto-generated method stub
		for (NhanVien x : dsNhanVien) {
			if (x.getMaNV().equalsIgnoreCase(maNV))
				return x;
		}
		return null;
	}

	public ArrayList<String> randowTenNV() {
		ArrayList<String> randomTen = new ArrayList<String>();
		for (NhanVien nv : dsNhanVien) {
			randomTen.add(nv.getTenNV());
		}
		return randomTen;
	}

	public boolean themNV(NhanVien x) throws Exception {
		// TODO Auto-generated method stub
		if (dsNhanVien.contains(x)) {
			throw new Exception("Trùng mã hàng hóa!");
		} else {
			dsNhanVien.add(x);
			return true;
		}
	}

	/**
	 * Chỉ so sánh phần tên không quan tâm phần họ + tên lót
	 *
	 */
	public void sapXepNhanVienTheoTen() {
		Collections.sort(dsNhanVien, new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien o1, NhanVien o2) {
				String hoTen1 = o1.getTenNV();
				String hoTen2 = o2.getTenNV();
				hoTen1.trim();
				hoTen2.trim();
				int i1 = hoTen1.lastIndexOf(" ");
				int i2 = hoTen2.lastIndexOf(" ");
				String ten1 = hoTen1.substring(i1 + 1);
				String ten2 = hoTen2.substring(i2 + 1);

				return ten1.compareTo(ten2);
			}
		});
	}

	/**
	 * tên phổ biến là tên xuất hiện nhiều nhất. Lặp 1 qua tất cả để đếm số lần tên
	 * xuất hiện. Lặp 2 tạo biến max và gắn lại biến max = số lần lặp từ lần lặp 1.
	 * Nếu các tên chỉ xuất hiện 1 lần thì sẽ chọn tên xuất hiện cuối cùng.
	 */
	public String timTenPhoBien() {

		int max = 0, dem = 0;
		String ten = "";
		// Lặp 1
		for (int i = 0; i < dsNhanVien.size(); i++) {
			for (int j = i + 1; i < dsNhanVien.size(); i++) {
				if (dsNhanVien.get(i).getTenNV().equalsIgnoreCase(dsNhanVien.get(j).getTenNV())) {
					dem++;
				}
			}
		}
		// Lặp 2
		for (int i = 0; i < dsNhanVien.size(); i++) {
			if (max <= dem) {
				max = dem;
				ten = dsNhanVien.get(i).getTenNV();
			}
		}

		return ten;
	}
}
