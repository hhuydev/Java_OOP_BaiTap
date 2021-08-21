/**
 * 
 */
package tuan3ChuyenXe;

/**
 * @author Ha Gia Huy
 *
 */
public class ChuyenXeNoiThanh extends ChuyenXe {
	private double soKm;
	private String soTuyen;

	public double getSoKm() {

		return soKm;
	}

	public void setSoKm(double soKm) throws Exception {
		if (soKm < 0)
			throw new Exception(" Lỗi số km < 0");
		this.soKm = soKm;
	}

	public String getSoTuyen() throws Exception {
		if (soTuyen.length() == 0 || soTuyen.equals(""))
			throw new Exception("Số tuyến không dc rỗng!");
		return soTuyen;
	}

	public void setSoTuyen(String soTuyen) {
		this.soTuyen = soTuyen;
	}

	/**
	 * @param soKm
	 * @param soTuyen
	 */
	public ChuyenXeNoiThanh(double soKm, String soTuyen) {
		super();
		this.soKm = soKm;
		this.soTuyen = soTuyen;
	}

	/**
	 * 
	 */
	public ChuyenXeNoiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maChuyen
	 * @param tenTX
	 * @param soXe
	 * @param doanhThu
	 * @param soKM2
	 * @param soTuyen2
	 */
	public ChuyenXeNoiThanh(String maChuyen, String tenTX, String soXe, double doanhThu, double soKM2,
			String soTuyen2) {
		// TODO Auto-generated constructor stub
		super(maChuyen, tenTX, soXe, doanhThu);
		this.soKm = soKM2;
		this.soTuyen = soTuyen2;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%14.2f %16s", soKm, soTuyen);
	}

}
