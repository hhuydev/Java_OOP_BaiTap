/**
 * 
 */
package tuan2AccountBank;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Ha Gia Huy
 *
 */
public class Account {
	private long soTK;
	private String tenTK;
	private double soTien;
	private String trangThai;
	private final double LAI_SUAT = 0.035;
	static final double PHIRUT = 1000;

	public long getSoTK() {
		return soTK;
	}

	public void setSoTK(long soTK) {
		if (soTK < 0)
			soTK = 999999;
		this.soTK = soTK;
	}

	public String getTenTK() {
		return tenTK;
	}

	public void setTenTK(String tenTK) throws Exception {
		if (tenTK.length() == 0 || tenTK.equals(""))
			throw new Exception("Tên không dc rỗng!");
		this.tenTK = tenTK;
	}

	public double getSoTien() {
		return soTien;
	}

	public void setSoTien(double soTien) {
		if (soTien < 50000)
			soTien = 50000;
		this.soTien = soTien;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	/**
	 * @param soTK
	 * @param tenTK
	 * @param soTien
	 * @param trangThai
	 */
	public Account(long soTK, String tenTK, double soTien, String trangThai) {
		super();
		this.soTK = soTK;
		this.tenTK = tenTK;
		this.soTien = soTien;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		Locale local = new Locale("vi", "vn");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(local);
		return String.format("%10d %-20s %15s %-25s", soTK, tenTK, formatter.format(soTien), trangThai);
	}

	/**
	 * 
	 */
	public Account() {
		this.soTK = 999999;
		this.tenTK = "Chưa Xác Định";
		this.soTien = 50;
	}

	public boolean napTien(double soTienNap) {
		if (soTienNap <= 0)
			return false;
		soTien += soTienNap;
		return true;
	}

	public boolean rutTien(double tienRut) {
		if (tienRut <= 0 && soTien <= tienRut + PHIRUT)
			return false;
		soTien -= (tienRut + PHIRUT);
		return true;
	}

	public void daoHan() {
		soTien += soTien * LAI_SUAT;
	}

	public boolean chuyenTien(Account accChuyen, Account accNhan, double soTienChuyen) {
		if (soTienChuyen <= 0 && (soTienChuyen - soTien) <= 0) {
			return false;
		} else {
			accChuyen.soTien -= (soTienChuyen + PHIRUT);
			accNhan.soTien += soTienChuyen;
		}
		return true;
	}

}
