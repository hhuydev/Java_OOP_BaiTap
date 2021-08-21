/**
 * 
 */
package tuan5SanhSu;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author Ha Gia Huy
 *
 */
public class HangSanhSu extends HangHoa {
	private String nsx;
	private LocalDate ngayNhap;

	public String getNsx() {
		return nsx;
	}

	public void setNsx(String nsx) throws Exception {
		if (nsx.length() == 0)
			throw new Exception("Nhà sản xuất k dc rỗng!");
		this.nsx = nsx;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
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
		// lấy ra số ngày chênh lệch giữa 2 ngày (tháng, năm)
		long days = ChronoUnit.DAYS.between(ngayNhap, LocalDate.now());
		if (soLuong > 50 && days > 10)
			result = "ban cham";
		return result;
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 * @param nsx
	 * @param ngayNhap
	 */
	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuong, String nsx, LocalDate ngayNhap) {
		super(maHang, tenHang, donGia, soLuong);
		this.nsx = nsx;
		this.ngayNhap = ngayNhap;
	}

	/**
	 * 
	 */
	public HangSanhSu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param maHang
	 * @param tenHang
	 * @param donGia
	 * @param soLuong
	 */
	public HangSanhSu(String maHang, String tenHang, double donGia, int soLuong) {
		super(maHang, tenHang, donGia, soLuong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.##");
		String vat = df.format(VAT() * 100) + "%";
		return super.toString() + String.format("%-20s %-13s %-10s %-10s", nsx, dtf.format(ngayNhap), vat, danhGia());
	}

}
