/**
 * 
 */
package tuan2Xe;

/**
 * @author Ha Gia Huy
 *
 */
public class Xe {
	private String maXe;
	private String chuXe;
	private String loaiXe;
	private long triGiaXe;
	private int dungTich;
	static final double PHANTRAM_GIATRI_1 = 0.01;
	static final double PHANTRAM_GIATRI_2 = 0.03;
	static final double PHANTRAM_GIATRI_3 = 0.05;

	public String getChuXe() {
		return chuXe;
	}

	public void setChuXe(String chuXe) throws Exception {
		if (chuXe.equalsIgnoreCase("") || chuXe.length() == 0)
			throw new Exception("Chủ xe không dc rỗng!");
		this.chuXe = chuXe;
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}

	public long getTriGiaXe() {
		return triGiaXe;
	}

	public void setTriGiaXe(long triGiaXe) {
		this.triGiaXe = triGiaXe;
	}

	public String getMaXe() {
		return maXe;
	}

	public void setMaXe(String maXe) throws Exception {
		if (maXe.equalsIgnoreCase("") || maXe.length() == 0)
			throw new Exception("Mã xe không dc rỗng!");
		this.maXe = maXe;
	}

	public int getDungTich() {
		return dungTich;
	}

	public void setDungTich(int dungTich) {
		this.dungTich = dungTich;
	}

	/**
	 * @param chuXe
	 * @param loaiXe
	 * @param triGiaXe
	 * @param dungTich
	 */
	public Xe(String chuXe, String loaiXe, long triGiaXe, int dungTich) {
		super();
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		this.triGiaXe = triGiaXe;
		this.dungTich = dungTich;
	}

	/**
	 * @param maXe
	 * @param chuXe
	 * @param loaiXe
	 * @param triGiaXe
	 * @param dungTich
	 */
	public Xe(String maXe, String chuXe, String loaiXe, long triGiaXe, int dungTich) {
		super();
		this.maXe = maXe;
		this.chuXe = chuXe;
		this.loaiXe = loaiXe;
		this.triGiaXe = triGiaXe;
		this.dungTich = dungTich;
	}

	/**
	 * 
	 */
	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double tinhThue() {
		double thue = 0;
		if (dungTich < 100)
			thue = triGiaXe * PHANTRAM_GIATRI_1;
		else if (dungTich >= 100 && dungTich <= 200)
			thue = triGiaXe * PHANTRAM_GIATRI_2;
		else if (dungTich > 200)
			thue = triGiaXe * PHANTRAM_GIATRI_3;
		return thue;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-20s %-15s %9d %14d %20.2f", maXe, chuXe, loaiXe, dungTich, triGiaXe, tinhThue());
	}

}
