/**
 * 
 */
package tuan3Sach;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public abstract class Sach {
	protected String maSach, nhaXBan;
	protected GregorianCalendar ngayNhap;
	protected double donGia;
	protected int soLuong;
 
	abstract double thanhTien();

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) throws Exception {
		if (maSach.length() == 0 || maSach.equalsIgnoreCase(""))
			throw new Exception("Mã sách không dc rỗng!");
		this.maSach = maSach;
	}

	public String getNhaXBan() {
		return nhaXBan;
	}

	public void setNhaXBan(String nhaXBan) throws Exception {
		if (nhaXBan.trim().length() == 0 || nhaXBan.trim().equalsIgnoreCase(""))
			throw new Exception("NXB không dc rỗng!");
		this.nhaXBan = nhaXBan;
	}

	public GregorianCalendar getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(GregorianCalendar ngayNhap) {
		this.ngayNhap = ngayNhap;
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
		if (soLuong > 0)
			this.soLuong = soLuong;
		else
			throw new Exception("Số lượng không dc < 0");

	}

	public Sach(String maSach, String nhaXBan, GregorianCalendar ngayNhap, double donGia, int soLuong)
			throws Exception {
		super();
		this.maSach = maSach;
		this.nhaXBan = nhaXBan;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.setSoLuong(soLuong);
	}

	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
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
		Sach other = (Sach) obj;
		if (maSach == null) {
			if (other.maSach != null)
				return false;
		} else if (!maSach.equals(other.maSach))
			return false;
		return true;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat def = new DecimalFormat("#,##0.00 vnd");
		return String.format("%-5s %10d %-15s %20s %20s", getMaSach(), getSoLuong(), getNhaXBan(),
				def.format(getDonGia()), df.format(getNgayNhap().getTime()));
	}
}
