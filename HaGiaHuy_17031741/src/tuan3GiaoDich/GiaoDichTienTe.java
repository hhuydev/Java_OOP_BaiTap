/**
 * 
 */
package tuan3GiaoDich;

import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class GiaoDichTienTe extends GiaoDich {
	private String loaiTien;
	private double tiGia;

	public String getLoaiTien() {
		return loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		if (loaiTien.trim().equalsIgnoreCase("USD") || loaiTien.trim().equalsIgnoreCase("EURO")) {
			this.loaiTien = loaiTien;
		} else
			this.loaiTien = "VND";
	}

	public double getTiGia() {
		return tiGia;
	}

	public void setTiGia(double tiGia) throws Exception {
		if (tiGia < 0)
			throw new Exception("Tỉ giá phải > 0!");
		this.tiGia = tiGia;
	}

	/**
	 * @param maGD
	 * @param ngayGD
	 * @param donGia
	 * @param soLuong
	 * @param loaiTien
	 * @param tiGia
	 */
	public GiaoDichTienTe(String maGD, GregorianCalendar ngayGD, double donGia, int soLuong, String loaiTien,
			double tiGia) {
		super(maGD, ngayGD, donGia, soLuong);
		this.loaiTien = loaiTien;
		this.tiGia = tiGia;
	}

	/**
	 * 
	 */
	public GiaoDichTienTe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maGD
	 * @param ngayGD
	 * @param donGia
	 * @param soLuong
	 */
	public GiaoDichTienTe(String maGD, GregorianCalendar ngayGD, double donGia, int soLuong) {
		super(maGD, ngayGD, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	double thanhTien() {
		// TODO Auto-generated method stub
		double tien = 0;
		if (loaiTien.equalsIgnoreCase("VND"))
			tien = getDonGia() * getSoLuong();
		else
			tien = getDonGia() * getSoLuong() * tiGia;
		return tien;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%25s %11.2f %21.2f", loaiTien, tiGia, thanhTien());
	}

}
