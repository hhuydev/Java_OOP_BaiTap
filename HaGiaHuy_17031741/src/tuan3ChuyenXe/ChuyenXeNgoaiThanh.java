/**
 * 
 */
package tuan3ChuyenXe;

/**
 * @author Ha Gia Huy
 *
 */
public class ChuyenXeNgoaiThanh extends ChuyenXe {
	private String noiDen;
	private int soNgay;

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public int getSoNgay() {
		return soNgay;
	}

	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}

	/**
	 * @param noiDen
	 * @param soNgay
	 */
	public ChuyenXeNgoaiThanh(String noiDen, int soNgay) {
		super();
		this.noiDen = noiDen;
		this.soNgay = soNgay;
	}

	/**
	 * 
	 */
	public ChuyenXeNgoaiThanh() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maChuyen
	 * @param tenTX
	 * @param soXe
	 * @param doanhThu
	 * @param noiDen2
	 * @param soNgay2
	 */
	public ChuyenXeNgoaiThanh(String maChuyen, String tenTX, String soXe, double doanhThu, String noiDen2,
			int soNgay2) {
		// TODO Auto-generated constructor stub
		super(maChuyen, tenTX, soXe, doanhThu);
		this.noiDen = noiDen2;
		this.soNgay = soNgay2;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%15s %15d", noiDen, soNgay);
	}

}
