/**
 * 
 */
package tuan4TienDienKhachHang;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public abstract class KhachHang {
	protected String maKH;
	protected String hoTen;
	protected GregorianCalendar ngayLapHD;
	protected int soKW;
	protected double donGia;

	abstract double thanhTien();

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) throws Exception {
		if (maKH.length() == 0)
			throw new Exception("Mã KH ko dc rỗng!");
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (hoTen.length() == 0)
			throw new Exception("Tên KH ko dc rỗng!");
		this.hoTen = hoTen;
	}

	public GregorianCalendar getNgayLapHD() {
		return ngayLapHD;
	}

	public void setNgayLapHD(GregorianCalendar ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}

	public int getSoKW() {
		return soKW;
	}

	public void setSoKW(int soKW) throws Exception {
		if (soKW <= 0)
			throw new Exception("Số KW phải > 0!");
		this.soKW = soKW;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia <= 0)
			throw new Exception("Đơn giá phải > 0!");
		this.donGia = donGia;
	}

	/**
	 * @param maKH
	 * @param hoTen
	 * @param ngayLapHD
	 * @param soKW
	 * @param donGia
	 */
	public KhachHang(String maKH, String hoTen, GregorianCalendar ngayLapHD, int soKW, double donGia) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.ngayLapHD = ngayLapHD;
		this.soKW = soKW;
		this.donGia = donGia;
	}

	/**
	 * 
	 */
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.##");
		return String.format("%-16s %-23s %-12s %-7s %-12s ", maKH, hoTen, sf.format(getNgayLapHD().getTime()),
				df.format(soKW), df.format(donGia));
	}

}
