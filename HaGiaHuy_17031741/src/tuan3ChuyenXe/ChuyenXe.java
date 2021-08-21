/**
 * 
 */
package tuan3ChuyenXe;

/**
 * @author Ha Gia Huy
 *
 */
public class ChuyenXe {
	protected String maSoChuyen;
	protected String tenTX;
	protected String soXe;
	protected double doanhThu;

	public String getMaSoChuyen() {
		return maSoChuyen;
	}

	public void setMaSoChuyen(String maSoChuyen) throws Exception {
		if (maSoChuyen.length() == 0 || maSoChuyen.equals(""))
			throw new Exception("Mã chuyến xe không dc rỗng!");
		this.maSoChuyen = maSoChuyen;
	}

	public String getSoXe() {
		return soXe;
	}

	public String getTenTX() {
		return tenTX;
	}

	public void setTenTX(String tenTX) throws Exception {
		if (tenTX.length() == 0 || tenTX.equals(""))
			throw new Exception("Tên tài xế không dc rỗng!");
		this.tenTX = tenTX;
	}

	public void setSoXe(String soXe) throws Exception {
		if (soXe.length() == 0 || soXe.equals(""))
			throw new Exception("Số xe không dc rỗng!");
		this.soXe = soXe;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) throws Exception {
		if (doanhThu < 0)
			throw new Exception("Doanh thu phải > 0!");
		this.doanhThu = doanhThu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSoChuyen == null) ? 0 : maSoChuyen.hashCode());
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
		ChuyenXe other = (ChuyenXe) obj;
		if (maSoChuyen == null) {
			if (other.maSoChuyen != null)
				return false;
		} else if (!maSoChuyen.equals(other.maSoChuyen))
			return false;
		return true;
	}

	/**
	 * @param maSoChuyen
	 * @param tenTX
	 * @param soXe
	 * @param doanhThu
	 */
	public ChuyenXe(String maSoChuyen, String tenTX, String soXe, double doanhThu) {
		super();
		this.maSoChuyen = maSoChuyen;
		this.tenTX = tenTX;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}

	/**
	 * 
	 */
	public ChuyenXe() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("%-8s %-20s %-8s %8.2f", maSoChuyen, tenTX, soXe, doanhThu);
	}
}
