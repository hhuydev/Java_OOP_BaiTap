/**
 * 
 */
package tuan1HinhChuNhat;

/**
 * @author Ha Gia Huy
 *
 */
public class TestHinhChuNhat {
	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH TÍNH CHU VI - DIỆN TÍCH HCN\n");
		HinhChuNhat cn1 = new HinhChuNhat();
		cn1.setChieuDai(5);
		cn1.setChieuRong(3);
		System.out.println("Chu vi HCN1 = " + cn1.tinhChuViHCN(cn1.getChieuDai(), cn1.getChieuRong()));
		System.out.println("Diện tích HCN1 = " + cn1.tinhDienTichHCN(cn1.getChieuDai(), cn1.getChieuRong()));

		HinhChuNhat cn2 = new HinhChuNhat(10, 5);
		System.out.println("Chu vi HCN2 = " + cn2.tinhChuViHCN(cn2.getChieuDai(), cn2.getChieuRong()));
		System.out.println("Diện tích HCN2 = " + cn2.tinhDienTichHCN(cn2.getChieuDai(), cn2.getChieuRong()));

	}

}
