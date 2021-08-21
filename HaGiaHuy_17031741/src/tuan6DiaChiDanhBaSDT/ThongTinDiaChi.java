/**
 * 
 */
package tuan6DiaChiDanhBaSDT;

/**
 * @author Ha Gia Huy
 *
 */
public class ThongTinDiaChi {
	private String diaChi;
	private String chuSoHuu;

	public String getChuSoHuu() {
		return chuSoHuu;
	}

	public void setChuSoHuu(String chuSoHuu) throws Exception {
		if (chuSoHuu.length() == 0)
			throw new Exception("Thông tin chủ sở hữu k dc rỗng!");
		this.chuSoHuu = chuSoHuu;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		if (diaChi.length() == 0)
			throw new Exception("Đia chỉ đăng ký sdt k dc rỗng!");
		this.diaChi = diaChi;
	}

	/**
	 * @param diaChi
	 * @param chuSoHuu
	 * @param soNguoiO
	 */
	public ThongTinDiaChi(String diaChi, String chuSoHuu) {
		super();
		this.diaChi = diaChi;
		this.chuSoHuu = chuSoHuu;

	}

	/**
	 * 
	 */
	public ThongTinDiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param diaChi
	 */
	public ThongTinDiaChi(String diaChi) {
		super();
		this.diaChi = diaChi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
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
		ThongTinDiaChi other = (ThongTinDiaChi) obj;
		if (diaChi == null) {
			if (other.diaChi != null)
				return false;
		} else if (!diaChi.equals(other.diaChi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-15s %15s", diaChi, chuSoHuu);
	}

}
