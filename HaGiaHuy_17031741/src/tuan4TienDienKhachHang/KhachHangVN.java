/**
 * 
 */
package tuan4TienDienKhachHang;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class KhachHangVN extends KhachHang {

	private String doiTuong;
	private int dinhMuc;

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		if (doiTuong.equalsIgnoreCase("kinh doanh") || doiTuong.equalsIgnoreCase("san xuat"))
			this.doiTuong = doiTuong;
		else
			this.doiTuong = "sinh hoat";
	}

	public int getDinhMuc() {
		return dinhMuc;
	}

	public void setDinhMuc(int dinhMuc) throws Exception {
		if (dinhMuc <= 0)
			throw new Exception("Định mức phải > 0!");
		this.dinhMuc = dinhMuc;
	}

	/**
	 * @param maKH
	 * @param hoTen
	 * @param ngayLapHD
	 * @param soKW
	 * @param donGia
	 * @param doiTuong
	 * @param dinhMuc
	 */
	public KhachHangVN(String maKH, String hoTen, GregorianCalendar ngayLapHD, int soKW, double donGia, String doiTuong,
			int dinhMuc) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		this.doiTuong = doiTuong;
		this.dinhMuc = dinhMuc;
	}

	/**
	 * 
	 */
	public KhachHangVN() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maKH
	 * @param hoTen
	 * @param ngayLapHD
	 * @param soKW
	 * @param donGia
	 */
	public KhachHangVN(String maKH, String hoTen, GregorianCalendar ngayLapHD, int soKW, double donGia) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		// TODO Auto-generated constructor stub
	}

	@Override
	double thanhTien() {
		double tien = 0;
		if (soKW <= dinhMuc)
			tien = soKW * donGia;
		else {
			int soKWVuot = soKW - dinhMuc;
			tien = (soKW * donGia * dinhMuc) + (soKWVuot * donGia * 2.5);
		}
		return (double) tien;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.## VND");
		DecimalFormat df2 = new DecimalFormat("#,##0");
		return super.toString()
				+ String.format("%-23s %-10s %-15s", doiTuong, df2.format(dinhMuc), df.format(thanhTien()));
	}

}
