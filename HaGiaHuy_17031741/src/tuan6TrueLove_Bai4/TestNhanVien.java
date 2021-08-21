/**
 * 
 */
package tuan6TrueLove_Bai4;

import java.util.Queue;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestNhanVien {
	static Scanner sc = new Scanner(System.in);
	static QuanLyNhanVien qlNV = new QuanLyNhanVien();
	static Queue<NhanVien> arrNV = qlNV.getList();

	static void tieuDeBangNV() {
		System.out.printf("%-12s %-20s %-13s %-10s\n", "Mã NV", "Tên NV", "SDT", "Cmnd");
	}

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Nhập cứng nhân viên");
		System.out.println("2. Nhập mềm nhân viên");
		System.out.println("3. Xuất danh sách tất cả nhân viên");
		System.out.println("4. Xóa nhân viên");
		System.out.println("5. Sửa nhân viên");
		System.out.println("6. Chọn nhân viên đăng ký đầu tiên đi du lịch");
		System.out.println("0. Thoát");
	}

	public static void xuatHetNV() {
		for (NhanVien nv : arrNV) {
			System.out.println(nv);
		}
	}

	public static void nhapCung() throws Exception {

		NhanVien nv1 = new NhanVien("NV001", "Phạm An", "01234123", "1932334");
		NhanVien nv2 = new NhanVien("NV002", "Lê Ngọc", "02223123", "25672334");
		NhanVien nv3 = new NhanVien("NV003", "Nguyễn Giang", "03234123", "2572334");
		NhanVien nv4 = new NhanVien("NV004", "Trịnh Phúc", "04234123", "5632334");
		NhanVien nv5 = new NhanVien("NV005", "Lê Ngọc", "06234123", "2232334");

		qlNV.themNV(nv1);
		qlNV.themNV(nv2);
		qlNV.themNV(nv3);
		qlNV.themNV(nv4);
		qlNV.themNV(nv5);
	}

	public static void main(String[] args) {
		System.out.println("Chương trình quản lý sản phẩm bởi công ty TrueLove");
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
					System.out.print("Nhập số lượng nhân viên cần thêm: ");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						qlNV.themNV(nhapTTNV());
					}
					break;
				case 3:
					tieuDeBangNV();
					xuatHetNV();
					break;
				case 4:
					xoaNV();
					break;
				case 5:
					suaThongTinNV();
					break;
				case 6:
					System.out.println("Nhân viên đăng đý đầu tiên đi du lịch:");
					tieuDeBangNV();
					System.out.println(arrNV.peek());
					break;

				}
			} while (chon >= 0 && chon <= 6);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void suaThongTinNV() {
		String tenNV = "", sdt = "", cmnd = "";
		System.out.println("Nhập nhân viên tìm để sửa: ");
		String maNV = sc.nextLine();
		NhanVien nv = qlNV.timNV(maNV);
		if (nv != null) {
			System.out.println("\nThông tin nhân viên trước khi sửa");
			System.out.println(nv);
			try {
				System.out.println("Nhập tên cần sửa: ");
				tenNV = sc.nextLine();
				nv.setTenNV(tenNV);
				qlNV.suaNhanVien(nv);
				System.out.println("Nhập SĐT cần sửa: ");
				sdt = sc.nextLine();
				nv.setSdt(sdt);
				qlNV.suaNhanVien(nv);
				System.out.println("Nhập cmnd cần sửa: ");
				cmnd = sc.nextLine();
				nv.setCmnd(cmnd);
				qlNV.suaNhanVien(nv);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi sửa: " + e.getMessage());
			}
		}
		System.out.println("Sửa thông tin nhân viên thành công vui lòng kiểm tra lại!");
		System.out.println("Danh sách nhân viên sau khi sửa:");
		tieuDeBangNV();
		xuatHetNV();
	}

	public static void xoaNV() {
		// TODO Auto-generated method stub
		NhanVien nv;
		String maNV = "";
		String choice = "";
		System.out.println("Nhập mã nhân viên cần xóa: ");
		maNV = sc.nextLine();
		nv = qlNV.timNV(maNV);
		if (nv != null) {
			System.out.println("Bạn muốn thực sự muốn xóa nhân viên này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qlNV.xoaNV(nv)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách nhân viên sau khi xóa");
					tieuDeBangNV();
					xuatHetNV();
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin nhân viên không tồn tại");
	}

	public static NhanVien nhapTTNV() {
		String maNV = "", tenNV = "", sdt = "", cmnd = "";
		NhanVien nv = new NhanVien();
		sc.nextLine();
		try {
			System.out.println("Nhập mã nhân viên: ");
			maNV = sc.nextLine();
			nv.setMaNV(maNV);
			System.out.println("Nhập tên nhân viên: ");
			tenNV = sc.nextLine();
			System.out.println("Nhập sđt: ");
			sdt = sc.nextLine();
			System.out.println("Nhập cmnd: ");
			cmnd = sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}

		nv = new NhanVien(maNV, tenNV, sdt, cmnd);
		return nv;
	}

}
