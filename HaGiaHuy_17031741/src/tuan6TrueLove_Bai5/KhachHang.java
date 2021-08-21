package tuan6TrueLove_Bai5;

/**
 * @author Ha Gia Huy
 *
 */
public class KhachHang implements Comparable<KhachHang> {

	private String maKH;
	private String hoTen;
	private double doanhSo;

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) throws Exception {
		if (maKH.length() == 0)
			throw new Exception("Mã KH không dc rỗng!");
		this.maKH = maKH;
	}

	public String getHoTen() {

		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (hoTen.length() == 0)
			throw new Exception("Họ tên KH không dc rỗng!");
		this.hoTen = hoTen;
	}

	public double getDoanhSo() {
		return doanhSo;
	}

	public void setDoanhSo(double doanhSo) throws Exception {
		if (doanhSo <= 0)
			throw new Exception("Doanh số phải > 0!");
		this.doanhSo = doanhSo;
	}

	public KhachHang(String maKH, String hoTen, double doanhSo) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.doanhSo = doanhSo;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}

	@Override
	public int compareTo(KhachHang o) {
		Double ds1 = this.doanhSo;
		Double ds2 = o.doanhSo;
		return ds1.compareTo(ds2);
	}

	@Override
	public String toString() {
		return String.format("%-15s %15s %15.2f ", maKH, hoTen, doanhSo);
	}

}
