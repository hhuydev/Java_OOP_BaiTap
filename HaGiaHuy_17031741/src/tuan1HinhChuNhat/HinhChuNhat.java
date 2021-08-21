package tuan1HinhChuNhat;

public class HinhChuNhat {
	private int chieuDai, chieuRong;

	public int getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(int chieuDai) {
		this.chieuDai = chieuDai;
	}

	public int getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(int chieuRong) {
		this.chieuRong = chieuRong;
	}

	/**
	 * @param chieuDai
	 * @param chieuRong
	 */
	public HinhChuNhat(int chieuDai, int chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}

	/**
	 * 
	 */
	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int tinhDienTichHCN(int cDai, int cRong) {
		return cDai * cRong;
	}

	public int tinhChuViHCN(int cDai, int cRong) {
		return (cDai + cRong) * 2;
	}

	

}
