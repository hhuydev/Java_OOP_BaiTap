/**
 * 
 */
package tuan3GiaoDich;

import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

	public String getLoaiVang() {
		return loaiVang;
	}

	public void setLoaiVang(String loaiVang) throws Exception {
		if (loaiVang.trim().equalsIgnoreCase("") || loaiVang.trim().length() == 0)
			throw new Exception("Loại vàng k dc bỏ trống!");
		this.loaiVang = loaiVang;
	}

	/**
	 * @param maGD
	 * @param ngayGD
	 * @param donGia
	 * @param soLuong
	 * @param loaiVang
	 */
	public GiaoDichVang(String maGD, GregorianCalendar ngayGD, double donGia, int soLuong, String loaiVang) {
		super(maGD, ngayGD, donGia, soLuong);
		this.loaiVang = loaiVang;
	}

	/**
	 * 
	 */
	public GiaoDichVang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maGD
	 * @param ngayGD
	 * @param donGia
	 * @param soLuong
	 */
	public GiaoDichVang(String maGD, GregorianCalendar ngayGD, double donGia, int soLuong) {
		super(maGD, ngayGD, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	double thanhTien() {
		// TODO Auto-generated method stub
		return soLuong * donGia;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%25s %32.2f", loaiVang, thanhTien());
	}

}
