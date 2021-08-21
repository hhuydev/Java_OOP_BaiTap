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
public class KhachHangNuocNgoai extends KhachHang {
	private String quocTich;

	public String getQuocTich() {
		return quocTich;
	}

	public void setQuocTich(String quocTich) throws Exception {
		if (quocTich.length() == 0)
			throw new Exception("Quốc tịnh ko dc rỗng!");
		this.quocTich = quocTich;
	}

	/**
	 * @param maKH
	 * @param hoTen
	 * @param ngayLapHD
	 * @param soKW
	 * @param donGia
	 * @param quocTich
	 */
	public KhachHangNuocNgoai(String maKH, String hoTen, GregorianCalendar ngayLapHD, int soKW, double donGia,
			String quocTich) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		this.quocTich = quocTich;
	}

	/**
	 * 
	 */
	public KhachHangNuocNgoai() {
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
	public KhachHangNuocNgoai(String maKH, String hoTen, GregorianCalendar ngayLapHD, int soKW, double donGia) {
		super(maKH, hoTen, ngayLapHD, soKW, donGia);
		// TODO Auto-generated constructor stub
	}

	@Override
	double thanhTien() {
		// TODO Auto-generated method stub
		return (double) (soKW * donGia);
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.## VND");
		return super.toString() + String.format("%-23s %-10s %-10s", quocTich, "", df.format(thanhTien()));
	}

}
