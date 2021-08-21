/**
 * 
 */
package tuan5SanhSu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestHangHoa {
	static Scanner sc = new Scanner(System.in);
	static DanhSachHangHoa qlHangHoa = new DanhSachHangHoa();
	static ArrayList<HangHoa> dsHangHoa = new ArrayList<HangHoa>();

	static void tieuDeBangSangSu() {
		System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-10s %-10s\n", "Mã hàng", "Tên hàng", "Đơn giá",
				"Số Lượng", "NSX", "Ngày nhập", "VAT", "Đánh giá");
	}

	static void tieuDeBangDienMay() {
		System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-10s %-10s\n", "Mã hàng", "Tên hàng", "Đơn giá",
				"Số Lượng", "Bảo hành", "Công suất", "VAT", "Đánh giá");
	}

	static void tieuDeBangThucPham() {
		System.out.printf("%-12s %-20s %-13s %-10s %-20s %-13s %-13s %-10s %-10s\n", "Mã hàng", "Tên hàng", "Đơn giá",
				"Số Lượng", "NCC", "Ngày SX", "Ngày HH", "VAT", "Đánh giá");
	}

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Nhập hàng hóa");
		System.out.println("2. Xuất danh sách tất cả hàng hóa");
		System.out.println("3. Tìm kiếm hàng hóa theo mã");
		System.out.println("4. Sắp xếp hàng hóa tăng dần theo tên");
		System.out.println("5. Sắp xếp hàng hóa tăng dần theo số lượng tồn kho");
		System.out.println("6. Xuất danh sách thực phẩm khó bán");
		System.out.println("7. Xóa hàng hóa theo mã hàng");
		System.out.println("8. Cập nhật công suất hàng hóa điện máy");
		System.out.println("0. Thoát");
	}

	public static void xuatHethangHoa(ArrayList<HangHoa> ds) {
		int dem = 0, dem2 = 0, dem3 = 0;
		for (HangHoa hh : ds) {
			if (hh instanceof HangSanhSu) {
				if (dem == 0) {
					System.out.println("Hàng sành sứ:");
					tieuDeBangSangSu();
					dem++;
				}
				System.out.println(hh);
			}

			if (hh instanceof HangDienMay) {
				if (dem2 == 0) {
					System.out.println("Hàng điện máy:");
					tieuDeBangDienMay();
					dem2++;
				}
				System.out.println(hh);
			}

			if (hh instanceof HangThucPham) {
				if (dem3 == 0) {
					System.out.println("Hàng thực phẩm:");
					tieuDeBangThucPham();
					dem3++;
				}
				System.out.println(hh);
			}
		}
	}

	public static void nhapCung() throws Exception {

		HangHoa hh1 = new HangThucPham("TP01", "Cá nướng", 75000, 10, "A", LocalDate.of(2021, 8, 10),
				LocalDate.of(2021, 8, 25));
		HangHoa hh2 = new HangThucPham("TP02", "Thịt bò xào", 100000, 10, "B", LocalDate.of(2020, 8, 25),
				LocalDate.of(2020, 11, 26));
		HangHoa hh3 = new HangDienMay("DM01", "Tivi LG", 10000000, 5, 24, 1000);
		HangHoa hh4 = new HangDienMay("DM02", "Máy giặt", 7000000, 2, 60, 1000);
		HangHoa hh5 = new HangSanhSu("SS01", "Chén", 1000000, 20, "C", LocalDate.of(2020, 9, 10));
		HangHoa hh6 = new HangSanhSu("SS02", "Bình trà", 700000, 100, "D", LocalDate.of(2020, 10, 14));

		qlHangHoa.themHangHoa(hh1);
		qlHangHoa.themHangHoa(hh2);
		qlHangHoa.themHangHoa(hh3);
		qlHangHoa.themHangHoa(hh4);
		qlHangHoa.themHangHoa(hh5);
		qlHangHoa.themHangHoa(hh6);
	}

	public static void main(String[] args) {
		int chon = 0;
		try {
			do {
				menu();
				chon = sc.nextInt();
				sc.nextLine();
				switch (chon) {
				case 0:
					System.exit(0);
					break;
				case 1:
					nhapCung();
					break;
				case 2:
					dsHangHoa = qlHangHoa.getdSHangHoa();

					xuatHethangHoa(dsHangHoa);
					break;
				case 3:
					HangHoa timHH = timHangHoaTheoMa();
					if (timHH != null) {
						System.out.println("Thông tin hàng hóa tìm dc: ");

						System.out.println(timHH);
					} else
						System.out.println("Không tìm thấy hàng hóa!");
					break;
				case 4:
					qlHangHoa.sapXepTheoTenHang();
					System.out.println("Danh sách hàng hóa sau khi sắp xếp theo tên: ");

					xuatHethangHoa(dsHangHoa);
					break;
				case 5:
					qlHangHoa.sapXepTheoSoLuongTon();
					System.out.println("Danh sách hàng hóa sau khi sắp xếp theo số lượng tồn: ");

					xuatHethangHoa(dsHangHoa);
					break;
				case 6:
					dsHangHoa = qlHangHoa.danhSachHangKhoBan();
					if (dsHangHoa != null) {
						System.out.println("Danh sách hàng hóa thực phẩm khó bán: ");

						xuatHethangHoa(dsHangHoa);
					}

					break;
				case 7:
					xoaHangHoa();
					break;
				case 8:
					System.out.println("Nhập mã hàng điện máy cập nhật số W: ");
					String maHH = sc.nextLine();
					System.out.println("Nhập số W cần cập nhật: ");
					int soW = sc.nextInt();

					if (qlHangHoa.timHangHoa(maHH) != null) {
						HangHoa temp = qlHangHoa.timHangHoa(maHH);
						try {
							HangHoa suaSoW = new HangDienMay();
							suaSoW = qlHangHoa.suaCongSuatDienMay(temp, soW);
							if (suaSoW != null) {
								System.out.println("Cập nhật số W thành công. Hãy kiểm tra lại!");
								System.out.println("Thông tin hàng điện máy sau khi cập nhật lại số W:");
								tieuDeBangDienMay();
								System.out.println(temp);
							} else
								System.out.println("Lỗi sửa");

						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Lỗi: " + e.getMessage());
						}

					} else
						System.out.println("Không tìm thấy mã hàng điện máy!");
					break;
				}
			} while (chon >= 0 && chon <= 8);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaHangHoa() {
		// TODO Auto-generated method stub
		HangHoa hh;
		String maHH = "";
		String choice = "";
		System.out.println("Nhập mã hàng cần xóa: ");
		maHH = sc.nextLine();
		hh = qlHangHoa.timHangHoa(maHH);
		if (hh != null) {
			System.out.println("Bạn muốn thực sự muốn xóa hàng hóa này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qlHangHoa.xoaHangHoa(maHH)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách hàng hóa sau khi xóa");
					xuatHethangHoa(dsHangHoa);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin hàng hóa không tồn tại");
	}

	public static HangHoa timHangHoaTheoMa() {
		String maHH = "";
		HangHoa hh;
		System.out.println("Nhập mã hàng hóa cần tìm: ");
		maHH = sc.nextLine();
		hh = qlHangHoa.timHangHoa(maHH);
		if (hh != null) {
			return hh;
		} else
			return null;
	}

}
