/**
 * 
 */
package tuan3Sach;

import java.text.DecimalFormat;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class SachGiaoKhoa extends Sach {
	private String tinhTrang;

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		if (tinhTrang.equalsIgnoreCase("cu"))
			this.tinhTrang = "cu";
		else
			this.tinhTrang = "moi";
	}

	/**
	 * @param maSach
	 * @param nhaXBan
	 * @param ngayNhap
	 * @param donGia
	 * @param soLuong
	 * @param tinhTrang
	 * @throws Exception
	 */
	public SachGiaoKhoa(String maSach, String nhaXBan, GregorianCalendar ngayNhap, double donGia, int soLuong,
			String tinhTrang) throws Exception {
		super(maSach, nhaXBan, ngayNhap, donGia, soLuong);
		this.tinhTrang = tinhTrang;
	}

	/**
	 * 
	 */
	public SachGiaoKhoa() {
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
	public SachGiaoKhoa(String maSach, String nhaXBan, GregorianCalendar ngayNhap, double donGia, int soLuong)
			throws Exception {
		super(maSach, nhaXBan, ngayNhap, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	double thanhTien() {
		// TODO Auto-generated method stub
		double tien = 0;
		if (tinhTrang.equalsIgnoreCase("moi"))
			tien = getSoLuong() * getDonGia();
		else
			tien = getSoLuong() * getDonGia() * 0.5;
		return tien;
	}

	@Override
	public String toString() {
		DecimalFormat def = new DecimalFormat("#,##0.00 vnd");
		return super.toString() + String.format("%16s %26s", getTinhTrang(), def.format(thanhTien()));
	}

}
