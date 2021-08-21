/**
 * 
 */
package tuan1DiemTrungBinh;

/**
 * @author Ha Gia Huy
 *
 */
public class SinhVien {
	private int maSV;
	private String hoTenSV;
	private float diemLT, diemTH;

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHoTenSV() {
		return hoTenSV;
	}

	public void setHoTenSV(String hoTenSV) {
		this.hoTenSV = hoTenSV;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	@Override
	public String toString() {
		return String.format("%-5s %-30s %10.2f %10.2f %10.2f", maSV, hoTenSV, diemLT, diemTH, tinhDiemTrungBinh());
	}

	/**
	 * @param maSV
	 * @param hoTenSV
	 * @param diemLT
	 * @param diemTH
	 */
	public SinhVien(int maSV, String hoTenSV, float diemLT, float diemTH) {
		super();
		this.maSV = maSV;
		this.hoTenSV = hoTenSV;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}

	/**
	 * 
	 */
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public float tinhDiemTrungBinh() {
		return (getDiemLT() + getDiemTH()) / 2;
	}

}
