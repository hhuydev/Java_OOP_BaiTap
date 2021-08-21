/**
 * 
 */
package tuan5PhongHocInterface;

import java.util.ArrayList;

/**
 * @author Ha Gia Huy
 *
 */
public interface ChucNangPhongHoc {
	boolean themPhongHoc(PhongHoc x) throws Exception;

	PhongHoc timPhongHoc(String maPhong);

	boolean xoaPhongHoc(String maPhong);

	void sua(PhongHoc x);

	ArrayList<PhongHoc> danhSachPhongDatChuan();

	void sapXepDayNha();

	void sapXepDienTich();

	void sapXepBongDen();

	int tongPhongHoc();

	ArrayList<PhongHoc> thongTinPhongMayTinhTren60May();

	PhongHoc suaSoMayPhongMayTinh(PhongHoc ph, int soMay) throws Exception;

}
