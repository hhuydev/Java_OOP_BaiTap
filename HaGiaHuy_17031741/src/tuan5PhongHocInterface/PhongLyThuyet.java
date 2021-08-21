/**
 * 
 */
package tuan5PhongHocInterface;

/**
 * @author Ha Gia Huy
 *
 */
public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public boolean isCoMayChieu() {
		return coMayChieu;
	}

	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}

	public PhongLyThuyet(String maPhong, String dayNha, float dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}

	public PhongLyThuyet(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	public PhongLyThuyet() {
	}

	public boolean hasMayChieu() {
		return coMayChieu;
	}

	@Override
	public boolean phongDatChuan() {
		return (phongDuSang() && coMayChieu);
	}

	@Override
	public String toString() {
		String coMayChieu = hasMayChieu() ? "Có máy chiếu" : "Không có máy chiếu";
		return super.toString() + String.format("%16s", coMayChieu);
	}
}
