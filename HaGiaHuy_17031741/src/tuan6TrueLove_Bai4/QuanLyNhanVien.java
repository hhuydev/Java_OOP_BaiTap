/**
 * 
 */
package tuan6TrueLove_Bai4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyNhanVien {
	Queue<NhanVien> dsNV;

	public QuanLyNhanVien() {
		dsNV = new ArrayDeque<NhanVien>();
	}

	public boolean themNV(NhanVien nv) throws Exception {
		if (dsNV.contains(nv))
			throw new Exception("Nhân viên đã có trong danh sách");
		dsNV.add(nv);
		return true;
	}

	public boolean xoaNV(NhanVien nv) {
		if (dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		} else
			return false;
	}

	public NhanVien timNV(String maNV) {
		for (NhanVien nv : dsNV) {
			if (nv.getMaNV().equalsIgnoreCase(maNV)) {
				return nv;
			}
		}
		return null;
	}

	public boolean suaNhanVien(NhanVien nv) throws Exception {
		for (NhanVien x : dsNV) {
			if (x.getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				x.setTenNV(nv.getTenNV());
				x.setSdt(nv.getSdt());
				x.setCmnd(nv.getCmnd());
				return true;
			}
		}
		return false;
	}

	public Queue<NhanVien> getList() {
		return dsNV;
	}

	public NhanVien getNVDauTien() {
		return dsNV.peek();
	}

}
