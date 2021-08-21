/**
 * 
 */
package tuan4NhaDat;

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
	protected float dienTich;

	abstract double thanhTien();

	public String getMaGD() {
		return maGD;
	}

	public void setMaGD(String maGD) throws Exception {
		if (maGD.trim().equalsIgnoreCase("") || maGD.length() == 0)
			throw new Exception("Mã GD không dc rỗng!");
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

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) throws Exception {
		if (dienTich <= 0)
			throw new Exception("Diện tích phải > 0!");
		this.dienTich = dienTich;
	}

	public GiaoDich(String maGD, GregorianCalendar ngayGD, double donGia, float dienTich) {
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
		this.dienTich = dienTich;
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
		DecimalFormat df = new DecimalFormat("#,##0.00 vnd");
		return String.format("%-5s %20s %25s %15.2f", getMaGD(), sf.format(getNgayGD().getTime()),
				df.format(getDonGia()), getDienTich());
	}
}
