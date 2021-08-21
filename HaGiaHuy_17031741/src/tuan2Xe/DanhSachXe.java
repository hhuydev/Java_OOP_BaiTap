/**
 * 
 */
package tuan2Xe;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachXe {
	Xe dsXe[];
	public int length;

	/**
	 * 
	 */
	public DanhSachXe(int length) {
		// TODO Auto-generated constructor stub
		dsXe = new Xe[length];
	}

	public boolean themXe(Xe xe) {
		if (timXe(xe.getMaXe()) != null)
			return false;

		if (length == dsXe.length)
			MangTangKichThuoc();
		dsXe[length] = xe;
		length++;
		return true;
	}

	public void xoaXe(Xe xe) {
		int viTri = timViTriXe(xe.getMaXe());
		for (int i = viTri; i < dsXe.length - 1; i++) {
			dsXe[i] = dsXe[i + 1];
		}
		length--;

	}

	public boolean suaThongTinXe(String maXe, String chuXe, String loaiXe, long triGiaXe, int dungTich)
			throws Exception {
		int index = timViTriXe(maXe);
		dsXe[index].setChuXe(chuXe);
		dsXe[index].setLoaiXe(loaiXe);
		dsXe[index].setTriGiaXe(triGiaXe);
		dsXe[index].setDungTich(dungTich);
		return true;
	}

	public double tongThue() {
		double sum = 0;
		for (int i = 0; i < length; i++) {
			sum += dsXe[i].tinhThue();
		}
		return sum;
	}

	public Xe[] getAllXe() {
		return dsXe;
	}

	/**
	 * 
	 */
	private void MangTangKichThuoc() {
		// TODO Auto-generated method stub
		Xe[] temp = new Xe[(int) (dsXe.length * 2)];
		for (int i = 0; i < dsXe.length; i++)
			temp[i] = dsXe[i];
		dsXe = temp;
	}

	public int timViTriXe(String maXe) {
		int i;
		for (i = 0; i < length; i++) {
			if (dsXe[i].getMaXe().equalsIgnoreCase(maXe))
				return i;
		}
		return -1;
	}

	/**
	 * @param chuXe
	 * @return
	 */
	public Xe timXe(String maXe) {
		// TODO Auto-generated method stub
		for (int i = 0; i < length; ++i) {
			if (dsXe[i].getMaXe().equalsIgnoreCase(maXe))
				return dsXe[i];
		}
		return null;
	}

}
