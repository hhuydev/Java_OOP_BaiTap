/**
 * 
 */
package tuan4NhaDat;

import java.util.GregorianCalendar;

/**
 * @author Ha Gia Huy
 *
 */
public class GiaoDichDat extends GiaoDich {
	private String loaiDat;

	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) {
		if (loaiDat.trim().equalsIgnoreCase("B") || loaiDat.trim().equalsIgnoreCase("C"))
			this.loaiDat = loaiDat;
		else
			this.loaiDat = "A";
	}

	public GiaoDichDat(String maGD, GregorianCalendar ngayGD, double donGia, float dienTich, String loaiDat) {
		super(maGD, ngayGD, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat() {
	}

	@Override
	double thanhTien() {
		if (loaiDat.trim().equalsIgnoreCase("A"))
			return getDienTich() * getDonGia() * 1.5;
		else
			return getDienTich() + getDonGia();
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%25s %30.2f", loaiDat, thanhTien());

	}
}
