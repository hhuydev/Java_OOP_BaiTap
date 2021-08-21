package tuan5PhongHoc;

import java.util.ArrayList;
import java.util.Scanner;

import tuan5PhongHocInterface.PhongHoc;
import tuan5PhongHocInterface.PhongMayTinh;
import tuan5PhongHocInterface.PhongLyThuyet;
import tuan5PhongHocInterface.PhongThiNghiem;
import tuan5PhongHocInterface.QuanLyPhongHoc;

/**
 * @author Ha Gia Huy
 *
 */
public class TestPhongHoc {
	static Scanner sc = new Scanner(System.in);
	static QuanLyPhongHoc qlPhongHoc = new QuanLyPhongHoc();
	static ArrayList<PhongHoc> dsPhongHoc = new ArrayList<PhongHoc>();

	static void tieuDePhongMT() {
		System.out.println(String.format("%-10s %13s %13s %15s %15s %15s", "Mã phòng", "Dãy nhà", "Diện tích",
				"Số bóng đèn", "Đạt chuẩn", "Số máy tính"));
	}

	static void tieuDePhongLT() {
		System.out.println(String.format("%-10s %13s %13s %15s %15s %15s", "Mã phòng", "Dãy nhà", "Diện tích",
				"Số bóng đèn", "Đạt chuẩn", "Máy chiếu"));
	}

	static void tieuDePhongTN() {
		System.out.println(String.format("%-10s %13s %13s %15s %15s %20s %10s %-20s", "Mã phòng", "Dãy nhà",
				"Diện tích", "Số bóng đèn", "Đạt chuẩn", "Chuyên nghành", "Sứa chứa", "Bồn rửa"));
	}

	static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Thêm cứng phòng học");
		System.out.println("2. Nhập tay phòng lý thuyết");
		System.out.println("3. Nhập tay phòng thực hành");
		System.out.println("4. Nhập tay phòng thí nghiệm");
		System.out.println("5. Xuất danh sách phòng học");
		System.out.println("6. Sắp xếp theo diện tích");
		System.out.println("7. Sắp xếp theo bóng đèn");
		System.out.println("8. Sắp xếp theo dãy nhà");
		System.out.println("9. Xuất thông tin phòng máy tính có 60 máy");
		System.out.println("10. Xuất thông tin phòng đạt chuẩn");
		System.out.println("11. Cập nhật số máy tính khi biết mã phòng máy tính");
		System.out.println("12. Sửa thông tin phòng học");
		System.out.println("13. Xóa thông tin phòng học");
		System.out.println("14. Tổng số phòng học");
		System.out.println("0.Thoát");
	}

	public static void xuatHetPhongHoc(ArrayList<PhongHoc> dSPhongHoc) {

		int dem = 0, dem2 = 0, dem3 = 0;
		for (PhongHoc ph : dSPhongHoc) {
			if (ph instanceof PhongMayTinh) {
				if (dem == 0) {
					System.out.println("Phòng máy tính:");
					tieuDePhongMT();
					dem++;
				}
				System.out.println(ph);
			}

			if (ph instanceof PhongLyThuyet) {
				if (dem2 == 0) {
					System.out.println("Phòng lý thuyết:");
					tieuDePhongLT();
					dem2++;
				}
				System.out.println(ph);
			}

			if (ph instanceof PhongThiNghiem) {
				if (dem3 == 0) {
					System.out.println("Phòng thí nghiệm:");
					tieuDePhongTN();
					dem3++;
				}
				System.out.println(ph);
			}
		}
	}

	public static void nhapCung() throws Exception {
		PhongHoc phong1 = new PhongLyThuyet("11a", "A1", 100f, 20, true);
		PhongHoc phong2 = new PhongMayTinh("12b", "E2", 120f, 10, 60);
		PhongHoc phong3 = new PhongThiNghiem("13c", "X3", 100f, 20, "Môi trường", 100, true);
		PhongHoc phong4 = new PhongThiNghiem("14d", "V12", 100f, 20, "Môi trường", 100, true);
		PhongHoc phong5 = new PhongMayTinh("13e", "X3", 100f, 20, 90);
		PhongHoc phong6 = new PhongLyThuyet("14f", "B4", 110f, 30, true);
		qlPhongHoc.themPhongHoc(phong1);
		qlPhongHoc.themPhongHoc(phong2);
		qlPhongHoc.themPhongHoc(phong3);
		qlPhongHoc.themPhongHoc(phong4);
		qlPhongHoc.themPhongHoc(phong5);
		qlPhongHoc.themPhongHoc(phong6);
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ CÁC PHÒNG HỌC");
		int chon = 0;
		try {
			do {
				menu();
				chon = sc.nextInt();
				sc.nextLine();
				switch (chon) {
				case 1:
					nhapCung();
					break;
				case 2:
					PhongHoc x = nhapTayPhongLyThuyet();
					if (x != null) {
						qlPhongHoc.themPhongHoc(x);
						System.out.println("Thêm thành công!");
						xuatHetPhongHoc(dsPhongHoc);
					}

					break;
				case 3:
					x = nhapTayPhongThiNghiem();
					if (x != null) {
						qlPhongHoc.themPhongHoc(x);
						System.out.println("Thêm thành công!");
						xuatHetPhongHoc(dsPhongHoc);
					}
					break;
				case 4:
					x = nhapTayPhongThiNghiem();
					if (x != null) {
						qlPhongHoc.themPhongHoc(x);
						System.out.println("Thêm thành công!");
						xuatHetPhongHoc(dsPhongHoc);
					}

					break;
				case 5:
					dsPhongHoc = qlPhongHoc.getdSPhongHoc();
					xuatHetPhongHoc(dsPhongHoc);
					break;
				case 6:
					qlPhongHoc.sapXepDienTich();
					System.out.println("Danh sách các phòng học sau khi sắp xếp theo diện tích:");

					xuatHetPhongHoc(dsPhongHoc);
					break;
				case 7:
					qlPhongHoc.sapXepBongDen();
					System.out.println("Danh sách các phòng học sau khi sắp xếp theo số bóng đèn:");

					xuatHetPhongHoc(dsPhongHoc);
					break;
				case 8:
					qlPhongHoc.sapXepDayNha();
					System.out.println("Danh sách các phòng học sau khi sắp xếp theo dãy nhà:");

					xuatHetPhongHoc(dsPhongHoc);
					break;
				case 9:
					dsPhongHoc = qlPhongHoc.thongTinPhongMayTinhTren60May();
					if (dsPhongHoc != null) {

						xuatHetPhongHoc(dsPhongHoc);
					} else
						System.out.println("Không tìm thấy phòng có trên 60 máy tính!");
					break;
				case 10:
					dsPhongHoc = qlPhongHoc.danhSachPhongDatChuan();
					if (dsPhongHoc != null) {

						xuatHetPhongHoc(dsPhongHoc);
					} else
						System.out.println("Không tìm thấy phòng nào đạt chuẩn!");
					break;
				case 11:
					System.out.println("Nhập mã phòng máy tính để cập nhật số máy: ");
					String maPhong = sc.nextLine();
					System.out.println("Nhập số máy cần cập nhật: ");
					int soMay = sc.nextInt();

					if (qlPhongHoc.timPhongHoc(maPhong) != null) {
						PhongHoc temp = qlPhongHoc.timPhongHoc(maPhong);
						try {
							PhongHoc suaSoMay = new PhongMayTinh();
							suaSoMay = qlPhongHoc.suaSoMayPhongMayTinh(temp, soMay);
							if (suaSoMay != null) {
								System.out.println("Cập nhật số máy thành công. Hãy kiểm tra lại!");
								System.out.println("Thông tin phòng máy sau khi cập nhật lại số máy:");

								System.out.println(temp);
							} else
								System.out.println("Lỗi sửa");

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Lỗi: " + e.getMessage());
						}

					} else
						System.out.println("Không tìm thấy mã phòng máy tính!");
					break;
				case 12:
					suaThongTinPhongHoc();
					break;
				case 13:
					xoaPhongHoc();
					break;
				case 14:
					System.out.println("Tổng số phòng học: " + qlPhongHoc.tongPhongHoc());
					break;

				}
			} while (chon >= 0 && chon <= 14);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaPhongHoc() {
		// TODO Auto-generated method stub
		PhongHoc ph;
		String maPhong = "";
		String choice = "";
		System.out.println("Nhập mã phòng: ");
		maPhong = sc.nextLine();
		ph = qlPhongHoc.timPhongHoc(maPhong);
		if (ph != null) {
			System.out.println("Bạn muốn thực sự muốn xóa phòng học này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qlPhongHoc.xoaPhongHoc(maPhong)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách phòng học sau khi xóa");

					xuatHetPhongHoc(dsPhongHoc);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin phòng học không tồn tại");
	}

	public static void suaThongTinPhongHoc() {
		System.out.println("Nhập mã phòng tìm để sửa: ");
		String maPhong = sc.nextLine();
		PhongHoc suaPhongHoc = qlPhongHoc.timPhongHoc(maPhong);
		if (suaPhongHoc != null) {
			System.out.println("\nThông tin phòng học trước khi sửa");

			System.out.println(suaPhongHoc);
			try {
				System.out.println("Nhập dãy nhà cần sửa: ");
				String suaDayNha = sc.nextLine();
				suaPhongHoc.setDayNha(suaDayNha);
				qlPhongHoc.sua(suaPhongHoc);
				System.out.println("Nhập diện tích cần sửa: ");
				float suaDienTich = sc.nextFloat();
				suaPhongHoc.setDienTich(suaDienTich);
				qlPhongHoc.sua(suaPhongHoc);
				System.out.println("Nhập số bóng đèn cần sửa: ");
				int suaBongDen = sc.nextInt();
				suaPhongHoc.setSoBongDen(suaBongDen);
				qlPhongHoc.sua(suaPhongHoc);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi sửa: " + e.getMessage());
			}
		}
		System.out.println("Sửa thông tin phòng học thành công vui lòng kiểm tra lại!");
		System.out.println("Danh sách phòng học sau khi sửa:");

		xuatHetPhongHoc(dsPhongHoc);
	}

	public static PhongHoc nhapTayPhongThiNghiem() {
		String maPhong = "", dayNha = "", chuyenNganh = "";
		float dienTich = 0;
		int soBongDen = 0, sucChua = 0, bonRua = 0;
		boolean check = false;
		PhongHoc ph = new PhongThiNghiem();
		try {
			System.out.println("Nhập mã phòng: ");
			maPhong = sc.nextLine();
			ph.setMaPhong(maPhong);
			System.out.println("Nhập dãy nhà: ");
			dayNha = sc.nextLine();
			ph.setDayNha(dayNha);
			System.out.println("Nhập diện tích: ");
			dienTich = sc.nextFloat();
			ph.setDienTich(dienTich);
			System.out.println("Nhập số bóng đèn: ");
			soBongDen = sc.nextInt();
			ph.setSoBongDen(soBongDen);
			sc.nextLine();
			System.out.println("Nhập chuyên nghành: ");
			chuyenNganh = sc.nextLine();
			((PhongThiNghiem) ph).setChuyenNghanh(chuyenNganh);
			System.out.println("Nhập sức chứa phòng: ");
			sucChua = sc.nextInt();
			((PhongThiNghiem) ph).setSuaChua(sucChua);
			System.out.println("Phòng có bồn rửa không (1.Có 0.Không): ");
			bonRua = sc.nextInt();
			check = bonRua == 1 ? true : false;
			((PhongThiNghiem) ph).setCoBonRua(check);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}

		PhongHoc x = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, check);
		return x;
	}

	public static PhongHoc nhapTayPhongMayTinh() {
		String maPhong = "", dayNha = "";
		float dienTich = 0;
		int soBongDen = 0, soMayTinh = 0;
		PhongHoc ph = new PhongMayTinh();
		try {
			System.out.println("Nhập mã phòng: ");
			maPhong = sc.nextLine();
			ph.setMaPhong(maPhong);
			System.out.println("Nhập dãy nhà: ");
			dayNha = sc.nextLine();
			ph.setDayNha(dayNha);
			System.out.println("Nhập diện tích: ");
			dienTich = sc.nextFloat();
			ph.setDienTich(dienTich);
			System.out.println("Nhập số bóng đèn: ");
			soBongDen = sc.nextInt();
			ph.setSoBongDen(soBongDen);
			System.out.println("Số máy tính: ");
			soMayTinh = sc.nextInt();
			((PhongMayTinh) ph).setSoMayTinh(soMayTinh);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}

		PhongHoc x = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
		return x;
	}

	public static PhongHoc nhapTayPhongLyThuyet() {
		String maPhong = "", dayNha = "";
		float dienTich = 0;
		int soBongDen = 0, soMayChieu = 0;
		boolean check = false;
		PhongHoc ph = new PhongLyThuyet();
		try {
			System.out.println("Nhập mã phòng: ");
			maPhong = sc.nextLine();
			ph.setMaPhong(maPhong);
			System.out.println("Nhập dãy nhà: ");
			dayNha = sc.nextLine();
			ph.setDayNha(dayNha);
			System.out.println("Nhập diện tích: ");
			dienTich = sc.nextFloat();
			ph.setDienTich(dienTich);
			System.out.println("Nhập số bóng đèn: ");
			soBongDen = sc.nextInt();
			ph.setSoBongDen(soBongDen);
			System.out.println("Phòng có máy chiếu không (1.Có 0.Không): ");
			soMayChieu = sc.nextInt();
			check = soMayChieu == 1 ? true : false;
			((PhongLyThuyet) ph).setCoMayChieu(check);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}
		ph = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, check);
		return ph;
	}

}
