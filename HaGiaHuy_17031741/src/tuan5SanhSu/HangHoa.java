/**
 * 
 */
package tuan5SanhSu;

import java.text.DecimalFormat;

/**
 * @author Ha Gia Huy
 *
 */
public abstract class HangHoa {
	protected String maHang;
	protected String tenHang;
	protected double donGia;
	protected int soLuong;

	public abstract double VAT();

	public abstract String danhGia();

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {
		if (maHang.trim().length() == 0)
			throw new Exception("Mã hàng không dc rỗng!");
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if (tenHang.trim().length() == 0)
			throw new Exception("Tên hàng không dc rỗng!");
		this.tenHang = tenHang;
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
		if (soLuong < 0)
			throw new Exception("Số lượng phải >= 0!");
		this.soLuong = soLuong;
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 */
	public HangHoa(String maHang, String tenHang, double donGia, int soLuong) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	/**
	 * 
	 */
	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHang == null) ? 0 : maHang.hashCode());
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
		HangHoa other = (HangHoa) obj;
		if (maHang == null) {
			if (other.maHang != null)
				return false;
		} else if (!maHang.equals(other.maHang))
			return false;
		return true;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.##");
		return String.format("%-12s %-20s %-13s %-10s ", maHang, tenHang, df.format(donGia), df.format(soLuong));
	}

}
