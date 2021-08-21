/**
 * 
 */
package tuan3HangThucPham;

import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachThucPham {
	HangThucPham dsThucPham[];
	public int length;

	public DanhSachThucPham(int length) {
		// TODO Auto-generated constructor stub
		dsThucPham = new HangThucPham[length];
	}

	public boolean themThucPham(HangThucPham tp) {
		if (timThucPham(tp.getMaHang()) != null)
			return false;

		if (length == dsThucPham.length)
			mangTangKichThuoc();
		dsThucPham[length] = tp;
		length++;
		return true;
	}

	public HangThucPham timThucPham(String maHang) {
		for (int i = 0; i < length; ++i) {
			if (dsThucPham[i].getMaHang().equalsIgnoreCase(maHang))
				return dsThucPham[i];
		}
		return null;
	}

	public int timViTriThucPham(String maHang) {
		for (int i = 0; i < length; i++) {
			if (dsThucPham[i].getMaHang().equalsIgnoreCase(maHang))
				return i;
		}
		return -1;
	}

	public void xoaThucPham(HangThucPham tp) {
		int viTri = timViTriThucPham(tp.getMaHang());
		for (int i = viTri; i < dsThucPham.length - 1; i++) {
			dsThucPham[i] = dsThucPham[i + 1];
		}
		length--;

	}

	public boolean suaThongTinThucPham(String maHang, String tenHang, double donGia, GregorianCalendar ngaySXuat,
			GregorianCalendar ngayHHan) throws Exception {
		int index = timViTriThucPham(maHang);
		dsThucPham[index].setTenHang(tenHang);
		dsThucPham[index].setDonGia(donGia);
		dsThucPham[index].setNgaySXuat(ngaySXuat);
		dsThucPham[index].setNgayHHan(ngayHHan);
		return true;
	}

	public HangThucPham[] getAllThucPham() {
		return dsThucPham;
	}

	private void mangTangKichThuoc() {
		HangThucPham[] temp = new HangThucPham[(int) (dsThucPham.length * 2)];
		for (int i = 0; i < dsThucPham.length; i++)
			temp[i] = dsThucPham[i];
		dsThucPham = temp;
	}

	public boolean kiemTraHetHan(HangThucPham tp) {
		LocalDate ngayHetHan = tp.getNgayHHan().toZonedDateTime().toLocalDate();
		return ngayHetHan.isBefore(LocalDate.now()) ? true : false;
	}

	public double trungBinhDonGiaThucPham() {
		double tong = 0;
		for (int i = 0; i < length; i++) {
			tong += dsThucPham[i].getDonGia();
		}
		return tong / length;
	}

}
