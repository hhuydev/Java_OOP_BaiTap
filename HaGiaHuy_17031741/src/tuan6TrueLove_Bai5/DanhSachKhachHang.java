package tuan6TrueLove_Bai5;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachKhachHang {

	TreeSet<KhachHang> dsKH;

	public DanhSachKhachHang() {
		dsKH = new TreeSet<KhachHang>();
	}

	public boolean themKH(KhachHang kh) throws Exception {
		if (dsKH.contains(kh))
			throw new Exception("KH đã tồn tại");
		dsKH.add(kh);
		return true;
	}

	public boolean xoaKH(String ma) throws Exception {
		KhachHang kh = timKH(ma);
		if (kh != null) {
			dsKH.remove(kh);
			return true;
		}
		throw new Exception("Không tìm thấy KH.");
	}

	public boolean suaKH(KhachHang kh) throws Exception {
		xoaKH(kh.getMaKH());
		themKH(kh);
		return true;
	}

	public KhachHang timKH(String ma) {
		for (KhachHang kh : dsKH) {
			if (kh.getMaKH().equalsIgnoreCase(ma)) {
				return kh;
			}
		}
		return null;
	}

	public KhachHang timKHdoanhSoCaoNhat() {
		return dsKH.last();
	}

	public KhachHang timKHdoanhSoThapNhat() {
		return dsKH.first();
	}

	public TreeSet<KhachHang> getList() {
		return dsKH;
	}

}
