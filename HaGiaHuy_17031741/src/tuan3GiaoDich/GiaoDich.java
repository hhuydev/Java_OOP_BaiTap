/**
 * 
 */
package tuan3GiaoDich;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public abstract class GiaoDich {
	protected String maGD;
	protected GregorianCalendar ngayGD;
	protected double donGia;
	protected int soLuong;

	abstract double thanhTien();

	public String getMaGD() {
		return maGD;
	}

	public void setMaGD(String maGD) throws Exception {
		if (maGD.trim().length() == 0 || maGD.trim().equalsIgnoreCase(""))
			throw new Exception("Mã giao dịch ko dc rỗng!");
		this.maGD = maGD;
	}

	public GregorianCalendar getNgayGD() {
		return ngayGD;
	}

	public void setNgayGD(GregorianCalendar ngayGD) {
		this.ngayGD = ngayGD;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia <= 0)
			throw new Exception("Đơn giá phải > 0!");
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) throws Exception {
		if (soLuong <= 0)
			throw new Exception("Số lượng phải > 0!");
		this.soLuong = soLuong;
	}

	public GiaoDich(String maGD, GregorianCalendar ngayGD, double donGia, int soLuong) {
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public GiaoDich() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maGD == null) ? 0 : maGD.hashCode());
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
		GiaoDich other = (GiaoDich) obj;
		if (maGD == null) {
			if (other.maGD != null)
				return false;
		} else if (!maGD.equals(other.maGD))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat def = new DecimalFormat("#,##0.00 vnd");
		return String.format("%-10s %10d %20s %25s", getMaGD(), getSoLuong(), sf.format(getNgayGD().getTime()),
				def.format(getDonGia()));
	}
}
