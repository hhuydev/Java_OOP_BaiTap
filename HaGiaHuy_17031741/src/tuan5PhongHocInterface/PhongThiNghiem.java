/**
 * 
 */
package tuan5PhongHocInterface;

/**
 * @author Ha Gia Huy
 */
public class PhongThiNghiem extends PhongHoc {
	private String chuyenNghanh;
	private int sucChua;
	private boolean coBonRua;

	public String getChuyenNghanh() {
		return chuyenNghanh;
	}

	public void setChuyenNghanh(String chuyenNghanh) throws Exception {
		if (chuyenNghanh.length() == 0)
			throw new Exception("Chuyên nghành k dc rỗng!");
		this.chuyenNghanh = chuyenNghanh;
	}

	public int getSucChua() {
		return sucChua;
	}

	public void setSuaChua(int suaChua) throws Exception {
		if (sucChua <= 0)
			throw new Exception("Sức chứa phải > 0!");
		this.sucChua = suaChua;
	}

	public boolean isCoBonRua() {
		return coBonRua;
	}

	public void setCoBonRua(boolean coBonRua) {
		this.coBonRua = coBonRua;
	}

	public PhongThiNghiem(String maPhong, String dayNha, float dienTich, int soBongDen, String chuyenNghanh,
			int sucChua, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNghanh = chuyenNghanh;
		this.sucChua = sucChua;
		this.coBonRua = coBonRua;
	}

	public PhongThiNghiem() {
	}

	public PhongThiNghiem(String maPhong, String dayNha, float dienTich, int soBongDen) {
		super(maPhong, dayNha, dienTich, soBongDen);
	}

	@Override
	public boolean phongDatChuan() {
		return (phongDuSang() && coBonRua);
	}

	@Override
	public String toString() {
		String bonRua = coBonRua ? "Có bồn rửa" : "Không có bồn rửa";
		return super.toString() + String.format("%15s %13d %-20s", chuyenNghanh, sucChua, bonRua);
	}
}
