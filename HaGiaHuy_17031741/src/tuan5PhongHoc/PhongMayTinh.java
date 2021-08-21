/**
 * 
 */
package tuan5PhongHoc;

/**
 * @author Ha Gia Huy
 *
 */
public class PhongMayTinh extends PhongHoc {

	private int soMayTinh;

	public int getSoMayTinh() {
		return soMayTinh;
	}

	public void setSoMayTinh(int soMayTinh) throws Exception {
		if (soMayTinh < 0)
			throw new Exception("Số máy tính phải >=0!");
		this.soMayTinh = soMayTinh;
	}

	public PhongMayTinh(String maPhong, String dayNha, float dienTich, int soBongDen, int soMayTinh) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.soMayTinh = soMayTinh;
	}

	public PhongMayTinh() {

	}

	public PhongMayTinh(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	@Override
	public boolean phongDatChuan() {
		return (phongDuSang() && (dienTich / soMayTinh) >= 1.5);
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%34d", soMayTinh);

	}

}
