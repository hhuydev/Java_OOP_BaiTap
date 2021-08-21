/**
 * 
 */
package tuan6DiaChiDanhBaSDT;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestDiaChiDanhBa {
	static Scanner sc = new Scanner(System.in);
	static QuanLyDiaChiDanhBa qlDiaChi = new QuanLyDiaChiDanhBa();
	static Map<ThongTinDiaChi, List<String>> dsDiaChi;

	static void tieuDeBang() {
		System.out.printf("%-15s %15s %10s\n", "Địa chỉ", "Chủ hộ", "SĐT sở hữu");
	}

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Nhập cứng địa chỉ");
		System.out.println("2. Nhập mềm danh bạ địa chỉ.");
		System.out.println("3. Xuất danh sách danh bạ địa chỉ & sdt đi kèm");
		System.out.println("4. Tìm kiếm sđt theo địa chỉ danh bạ");
		System.out.println("5. Xoá danh bạ địa chỉ theo chỉ định");
		System.out.println("6. Xoá toàn bộ danh bạ địa chỉ");
		System.out.println("0. Thoát");
	}

	public static void xuatHetKH(Map<ThongTinDiaChi, List<String>> ds) {
		for (Entry<ThongTinDiaChi, List<String>> nv : ds.entrySet()) {
			System.out.println(nv);
		}
	}

	public static void nhapCung() throws Exception {

		ThongTinDiaChi dc1 = new ThongTinDiaChi("123a", "Dang An");
		ThongTinDiaChi dc2 = new ThongTinDiaChi("22b", "Ho Han");
		ThongTinDiaChi dc3 = new ThongTinDiaChi("143c", "Tran Khai");
		ThongTinDiaChi dc4 = new ThongTinDiaChi("7d", "Pham Phu");
		ThongTinDiaChi dc5 = new ThongTinDiaChi("261e", "Nguyen Nhat");

		qlDiaChi.themDiaChi(dc1, "09123");
		qlDiaChi.themDiaChi(dc2, "09321");
		qlDiaChi.themDiaChi(dc3, "09444");
		qlDiaChi.themDiaChi(dc4, "09333");
		qlDiaChi.themDiaChi(dc5, "09111");
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ ĐỊA CHỈ - SĐT");
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
					ThongTinDiaChi diaChi = nhapTayDiaChi();
					System.out.println("Nhập sdt cần thêm: ");
					sc.nextLine();
					String sdt = sc.nextLine();
					qlDiaChi.themDiaChi(diaChi, sdt);
					break;
				case 3:
					dsDiaChi = qlDiaChi.getAll();
					tieuDeBang();
					xuatHetKH(dsDiaChi);
					break;
				case 4:
					System.out.println("Nhập địa chỉ danh bạ để tìm kiếm: ");
					String dc = sc.nextLine();
					List<String> dsSdt = qlDiaChi.timDanhBaTheoDiaChi(dc);

					if (dsSdt != null) {
						System.out.println("Thông tin tìm được sdt theo địa chỉ danh bạ tìm dc:");
						System.out.println(dsSdt);
					} else
						System.out.println("Không tìm thấy");
					break;
				case 5:
					xoaDiaChi();
					break;
				case 6:
					if (qlDiaChi.xoaAllDiaChi()) {
						System.out.println("Đã xóa hết danh bạ số điện thoại!");
						tieuDeBang();
						xuatHetKH(dsDiaChi);
					} else
						System.out.println("Danh bạ sdt đã rỗng! Không thể xóa");
					break;
				}

			} while (chon >= 0 && chon <= 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaDiaChi() {
		// TODO Auto-generated method stub
		ThongTinDiaChi dc;
		String diaChi = "";
		String choice = "";
		System.out.println("Nhập địa chỉ danh bạ cần xóa: ");
		diaChi = sc.nextLine();
		dc = qlDiaChi.timDiaChi(diaChi);
		if (dc != null) {
			System.out.println("Bạn muốn thực sự muốn xóa địa chỉ danh bạ này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qlDiaChi.xoaDiaChi(dc)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách các địa chỉ danh bạ sau khi xóa");
					xuatHetKH(dsDiaChi);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin địa chỉ danh bạ không tồn tại");
	}

	public static ThongTinDiaChi nhapTayDiaChi() {
		String diaChiNha = "", chuSoHuu = "";

		ThongTinDiaChi diaChi = new ThongTinDiaChi();
		try {
			System.out.println("Nhập địa chỉ: ");
			diaChiNha = sc.nextLine();
			diaChi.setDiaChi(diaChiNha);
			System.out.println("Nhập họ tên chủ sở hữu: ");
			chuSoHuu = sc.nextLine();
			diaChi.setChuSoHuu(chuSoHuu);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}
		diaChi = new ThongTinDiaChi(diaChiNha, chuSoHuu);
		return diaChi;
	}
}