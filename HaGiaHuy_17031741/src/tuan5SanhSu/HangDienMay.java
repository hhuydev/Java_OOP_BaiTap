/**
 * 
 */
package tuan5SanhSu;

import java.text.DecimalFormat;

/**
 * @author Ha Gia Huy
 *
 */
public class HangDienMay extends HangHoa {
	private int thoiGianBaoHanh;
	private int congSuat;

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) throws Exception {
		if (thoiGianBaoHanh < 0)
			throw new Exception("Thời gian bảo hành phải >= 0!");
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}

	public int getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(int congSuat) throws Exception {
		if (congSuat <= 0)
			throw new Exception("Công suât phải > 0!");
		this.congSuat = congSuat;
	}

	@Override
	public double VAT() {
		// TODO Auto-generated method stub
		return 0.1;
	}

	@Override
	public String danhGia() {
		// TODO Auto-generated method stub
		String result = "";
		if (soLuong < 3)
			result = "ban duoc";
		return result;
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 * @param thoiGianBaoHanh
	 * @param congSuat
	 */
	public HangDienMay(String maHang, String tenHang, double donGia, int soLuong, int thoiGianBaoHanh, int congSuat) {
		super(maHang, tenHang, donGia, soLuong);
		this.thoiGianBaoHanh = thoiGianBaoHanh;
		this.congSuat = congSuat;
	}

	/**
	 * 
	 */
	public HangDienMay() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 */
	public HangDienMay(String maHang, String tenHang, double donGia, int soLuong) {
		super(maHang, tenHang, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.##");
		String vat = df.format(VAT() * 100) + "%";
		return super.toString()
				+ String.format("%-10s %16s %12s %13s", thoiGianBaoHanh, df.format(congSuat) + " W", vat, danhGia());
	}
}
