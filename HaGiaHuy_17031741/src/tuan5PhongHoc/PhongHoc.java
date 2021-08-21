/**
 * 
 */
package tuan5PhongHoc;

/**
 * @author Ha Gia Huy
 *
 */
public abstract class PhongHoc {
	protected String maPhong, dayNha;
	protected float dienTich;
	protected int soBongDen;

	public abstract boolean phongDatChuan();

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) throws Exception {
		if (maPhong.length() == 0)
			throw new Exception("Mã phòng k dc rỗng!");
		this.maPhong = maPhong;
	}

	public String getDayNha() {
		return dayNha;
	}

	public void setDayNha(String dayNha) throws Exception {
		if (dayNha.length() == 0)
			throw new Exception("Dãy nhà k dc rỗng!");
		this.dayNha = dayNha;
	}

	public float getDienTich() {
		return dienTich;
	}

	public void setDienTich(float dienTich) throws Exception {
		if (dienTich <= 0)
			throw new Exception("Diện tích phải > 0!");
		this.dienTich = dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public void setSoBongDen(int soBongDen) throws Exception {
		if (soBongDen < 0)
			throw new Exception("Số bóng đèn phải >= 0!");
		this.soBongDen = soBongDen;
	}

	public PhongHoc(String maPhong, String dayNha, float dienTich, int soBongDen) {
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	public PhongHoc() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongHoc other = (PhongHoc) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}

	public boolean phongDuSang() {
		return (dienTich / soBongDen <= 10);
	}

	@Override
	public String toString() {
		String datChuan = phongDatChuan() ? "Đạt chuẩn" : "Không đạt chuẩn";
		return String.format("%-5s %13s %18.2f %15d %18s", getMaPhong(), getDayNha(), getDienTich(), getSoBongDen(),
				datChuan);
	}
}
