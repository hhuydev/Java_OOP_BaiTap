/**
 * 
 */
package tuan5SanhSu;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Ha Gia Huy
 */
public class HangThucPham extends HangHoa {
	private String ncc;
	private LocalDate ngaySX;
	private LocalDate ngayHH;

	public String getNcc() {
		return ncc;
	}

	public void setNcc(String ncc) throws Exception {
		if (ncc.length() == 0)
			throw new Exception("Nhà cung cấp k dc rỗng!");
		this.ncc = ncc;
	}

	public LocalDate getNgaySX() {
		return ngaySX;
	}

	public void setNgaySX(LocalDate ngaySX) {
		this.ngaySX = ngaySX;
	}

	public LocalDate getNgayHH() {
		return ngayHH;
	}

	public void setNgayHH(LocalDate ngayHH) {
		this.ngayHH = ngayHH;
	}

	@Override
	public double VAT() {
		// TODO Auto-generated method stub
		return 0.05;
	}

	@Override
	public String danhGia() {
		String result = "";
		if (soLuong >= 1 && ngayHH.isAfter(LocalDate.now()))
			result = "Kho ban";
		return result;
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 * @param ncc
	 * @param ngaySX
	 * @param ngayHH
	 */
	public HangThucPham(String maHang, String tenHang, double donGia, int soLuong, String ncc, LocalDate ngaySX,
			LocalDate ngayHH) {
		super(maHang, tenHang, donGia, soLuong);
		this.ncc = ncc;
		this.ngaySX = ngaySX;
		this.ngayHH = ngayHH;
	}

	/**
	 * 
	 */
	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 */
	public HangThucPham(String maHang, String tenHang, double donGia, int soLuong) {
		super(maHang, tenHang, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.##");
		String vat = df.format(VAT() * 100) + "%";
		return super.toString() + String.format("%-20s %-13s %-13s %-10s %-10s", ncc, dtf.format(ngaySX),
				dtf.format(ngayHH), vat, danhGia());
	}

}
