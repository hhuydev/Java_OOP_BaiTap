
package tuan3HangThucPham;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class HangThucPham {
	private String maHang;
	private String tenHang;
	private double donGia;
	private GregorianCalendar ngaySXuat, ngayHHan;

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) throws Exception {

		if (maHang.length() == 0 || maHang.equalsIgnoreCase(""))
			throw new Exception("Mã hàng không dc rỗng!");
		this.maHang = maHang;
	}

	public String getTenHang() {

		return tenHang;
	}

	public void setTenHang(String tenHang) throws Exception {
		if (tenHang.length() == 0 || tenHang.equalsIgnoreCase(""))
			throw new Exception("Tên hàng không dc rỗng!");
		this.tenHang = tenHang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia <= 0)
			throw new Exception("Đơn giá phải > 0");
		this.donGia = donGia;
	}

	public GregorianCalendar getNgaySXuat() {
		return ngaySXuat;
	}

	public void setNgaySXuat(GregorianCalendar ngaySXuat) throws Exception {
		GregorianCalendar ngayHT = new GregorianCalendar();
		if (ngaySXuat.compareTo(ngayHT) > 0)
			throw new Exception("Ngày sản xuất không dc lớn hơn ngày hiện tại!");
		this.ngaySXuat = ngaySXuat;
	}

	public GregorianCalendar getNgayHHan() {
		return ngayHHan;
	}

	public void setNgayHHan(GregorianCalendar ngayHHan) throws Exception {
		if (ngayHHan.compareTo(ngaySXuat) <= 0)
			throw new Exception("Ngày hết hạn phải > ngày sản xu");
		this.ngayHHan = ngayHHan;
	}


	public HangThucPham(String maHang, String tenHang, double donGia, GregorianCalendar ngaySXuat,
			GregorianCalendar ngayHHan) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.donGia = donGia;
		this.ngaySXuat = ngaySXuat;
		this.ngayHHan = ngayHHan;
	}


	public HangThucPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HangThucPham(String maHang) {
		super();
		this.maHang = maHang;
	}

	@Override
	public String toString() {
		String s = "";
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		s += String.format("%-10s %15s %32.2f %17s %21s", getMaHang(), getTenHang(), getDonGia(),
				df.format(ngaySXuat.getTime()), df.format(ngayHHan.getTime()), ngaySXuat.getTime().getYear() + 1900);
		return s;
	}

}
