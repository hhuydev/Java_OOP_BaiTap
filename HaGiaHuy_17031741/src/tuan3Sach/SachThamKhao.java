/**
 * 
 */
package tuan3Sach;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 */
public class SachThamKhao extends Sach {
	private double thue;

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		if (thue < 0)
			thue = 0.1;
		this.thue = thue;
	}

	/**
	 * @param maSach
	 * @param nhaXBan
	 * @param ngayNhap
	 * @param donGia
	 * @param soLuong
	 * @param thue
	 * @throws Exception
	 */
	public SachThamKhao(String maSach, String nhaXBan, GregorianCalendar ngayNhap, double donGia, int soLuong,
			double thue) throws Exception {
		super(maSach, nhaXBan, ngayNhap, donGia, soLuong);
		this.thue = thue;
	}

	/**
	 * 
	 */
	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maSach
	 * @param nhaXBan
	 * @param ngayNhap
	 * @param donGia
	 * @param soLuong
	 * @throws Exception
	 */
	public SachThamKhao(String maSach, String nhaXBan, GregorianCalendar ngayNhap, double donGia, int soLuong)
			throws Exception {
		super(maSach, nhaXBan, ngayNhap, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	double thanhTien() {
		// TODO Auto-generated method stub
		return getSoLuong() * getDonGia() + thue;
	}

	@Override
	public String toString() {
		DecimalFormat def = new DecimalFormat("#,##0.00 vnd");
		return super.toString() + String.format("%18s %25s", thue, def.format(thanhTien()));
	}

}
