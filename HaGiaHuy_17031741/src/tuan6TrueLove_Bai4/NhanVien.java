/**
 * 
 */
package tuan6TrueLove_Bai4;

/**
 * @author Ha Gia Huy
 *
 */
public class NhanVien {
	private String maNV;
	private String tenNV;
	private String sdt;
	private String cmnd;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) throws Exception {
		if (maNV.length() == 0)
			throw new Exception("Mã NV k dc trống!");
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) throws Exception {
		if (tenNV.length() == 0)
			throw new Exception("Tên NV k dc trống!");
		this.tenNV = tenNV;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) throws Exception {
		if (sdt.length() == 0)
			throw new Exception("SĐT NV k dc trống!");
		this.sdt = sdt;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) throws Exception {
		if (cmnd.length() == 0)
			throw new Exception("CMND NV k dc trống!");
		this.cmnd = cmnd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

	/**
	 * @param maNV
	 * @param tenNV
	 * @param sdt
	 * @param cmnd
	 */
	public NhanVien(String maNV, String tenNV, String sdt, String cmnd) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.cmnd = cmnd;
	}

	/**
	 * 
	 */
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("%-12s %-20s %-13s %-10s ", maNV, tenNV, sdt, cmnd);
	}
}
