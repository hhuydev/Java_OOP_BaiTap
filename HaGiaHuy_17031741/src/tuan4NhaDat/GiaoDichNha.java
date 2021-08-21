/**
 * 
 */
package tuan4NhaDat;

import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class GiaoDichNha extends GiaoDich {
	private String loaiNha;
	private String diaChi;

	public String getLoaiNha() {
		return loaiNha;
	}

	public GiaoDichNha(String maGD, GregorianCalendar ngayGD, double donGia, float dienTich, String loaiNha,
			String diaChi) {
		super(maGD, ngayGD, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	public GiaoDichNha(String loaiNha, String diaChi) {
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	public GiaoDichNha() {
	}

	public void setLoaiNha(String loaiNha) {
		if (loaiNha.trim().equalsIgnoreCase("Cao Cap"))
			this.loaiNha = loaiNha;
		else
			this.loaiNha = "Thuong";
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	double thanhTien() {
		if (getLoaiNha().trim().equalsIgnoreCase("Cao Cap"))
			return getDienTich() * getDonGia();
		else
			return getDienTich() * getDonGia() * 0.9;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%25s %25s %21.2f ", getLoaiNha(), getDiaChi(), thanhTien());
	}
}
