/**
 * 
 */
package tuan6TrueLove_Bai123;

/**
 * @author Ha Gia Huy
 *
 */
public class SanPham {
	private String maSP;
	private String tenSP;
	private double giaBan;

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) throws Exception {
		if (maSP.length() == 0)
			throw new Exception("Mã Sp k dc rỗng!");
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) throws Exception {
		if (tenSP.length() == 0)
			throw new Exception("Tên Sp k dc rỗng!");
		this.tenSP = tenSP;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) throws Exception {
		if (giaBan <= 0)
			throw new Exception("Giá bán phải > 0!");
		this.giaBan = giaBan;
	}

	/**
	 * 
	 */
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maSP
	 * @param tenSP
	 * @param giaBan
	 */
	public SanPham(String maSP, String tenSP, double giaBan) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return String.format("%-12s %-20s %20.2f", maSP, tenSP, giaBan);
	}

}
