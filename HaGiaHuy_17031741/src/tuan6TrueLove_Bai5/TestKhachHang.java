/**
 * 
 */
package tuan6TrueLove_Bai5;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Ha Gia Huy
 *
 */
public class TestKhachHang {
	public static Scanner sc = new Scanner(System.in);
	public static DanhSachKhachHang qLKH = new DanhSachKhachHang();
	public static TreeSet<KhachHang> arrKH = qLKH.getList();

	public static void tieuDeBang() {
		System.out.println(String.format("%-15s %15s %13s", "Mã KH", "Họ tên", "Doanh số"));
	}

	public static void nhapCung() throws Exception {
		KhachHang kh1 = new KhachHang("KH1", "Trần Phát", 1300000);
		KhachHang kh2 = new KhachHang("KH2", "Nguyễn Anh", 53000000);
		KhachHang kh3 = new KhachHang("KH3", "Lê Mai", 5000000);
		KhachHang kh4 = new KhachHang("KH4", "Hoàng Định", 7000000);
		KhachHang kh5 = new KhachHang("KH5", "Đặng Nguyên", 2400000);

		qLKH.themKH(kh1);
		qLKH.themKH(kh2);
		qLKH.themKH(kh3);
		qLKH.themKH(kh4);
		qLKH.themKH(kh5);

	}

	public static void xuatDSKH() {
		for (KhachHang kh : arrKH) {
			System.out.println(kh);
		}
	}

	public static void menu() {
		System.out.println("1. Nhập cứng khách hàng");
		System.out.println("2. Nhập mềm khách hàng");
		System.out.println("3. Xuất danh sách khách hàng");
		System.out.println("4. Xóa khách hàng");
		System.out.println("5. Sửa thông tin khách hàng");
		System.out.println("6. Thông tin khách hàng có doanh số cao nhất");
		System.out.println("7. Thông tin khách hàng có doanh số thấp nhất");
		System.out.println("0. Thoát");
	}

	public static void main(String[] args) {
		System.out.println("Chương trình quản lý khách hàng bởi công ty TrueLove");
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
					System.out.print("Nhập số lượng khách hàng cần thêm: ");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						qLKH.themKH(nhapMemKH());
					}
					break;
				case 3:
					tieuDeBang();
					xuatDSKH();
					break;
				case 4:
					xoaKH();
					break;
				case 5:
					suaThongTinKH();
					break;
				case 6:
					KhachHang kh = qLKH.timKHdoanhSoCaoNhat();
					if (kh != null) {
						System.out.println("Thông tin khách hàng có doanh số cao nhất:");
						tieuDeBang();
						System.out.println(kh);
					} else
						System.out.println("Không tìm thấy:");
					break;
				case 7:
					kh = qLKH.timKHdoanhSoThapNhat();
					if (kh != null) {
						System.out.println("Thông tin khách hàng có doanh số thấp nhất:");
						tieuDeBang();
						System.out.println(kh);
					} else
						System.out.println("Không tìm thấy:");
					break;

				}
			} while (chon >= 0 && chon <= 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaKH() {
		// TODO Auto-generated method stub
		KhachHang kh;
		String maKH = "";
		String choice = "";
		System.out.println("Nhập mã khách hàng cần xóa: ");
		maKH = sc.nextLine();
		kh = qLKH.timKH(maKH);
		if (kh != null) {
			System.out.println("Bạn muốn thực sự muốn xóa khách hàng này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				try {
					if (qLKH.xoaKH(maKH)) {
						System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
						System.out.println("Danh sách khách hàng sau khi xóa");
						tieuDeBang();
						xuatDSKH();
						return;
					}

					else {
						System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
						return;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Thông tin khách hàng không tồn tại");
				}
			} else
				return;
		}
	}

	public static void suaThongTinKH() {
		String tenKH = "", maKH = "";
		double doanhSo = 0;
		System.out.println("Nhập khách hàng tìm để sửa: ");
		maKH = sc.nextLine();
		KhachHang kh = qLKH.timKH(maKH);
		if (kh != null) {
			System.out.println("\nThông tin khách hàng trước khi sửa");
			System.out.println(kh);
			try {
				System.out.println("Nhập tên cần sửa: ");
				tenKH = sc.nextLine();
				kh.setHoTen(tenKH);
				qLKH.suaKH(kh);
				System.out.println("Nhập doanh số cần sửa: ");
				doanhSo = sc.nextDouble();
				kh.setDoanhSo(doanhSo);
				qLKH.suaKH(kh);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi sửa: " + e.getMessage());
			}
		}
		System.out.println("Sửa thông tin nhân viên thành công vui lòng kiểm tra lại!");
		System.out.println("Danh sách nhân viên sau khi sửa:");
		tieuDeBang();
		xuatDSKH();
	}

	public static KhachHang nhapMemKH() {
		String maKH = "", hoTen = "";
		double doanhSo = 0;
		KhachHang kh = new KhachHang();
		sc.nextLine();
		try {
			System.out.println("Nhập mã KH: ");
			maKH = sc.nextLine();
			kh.setMaKH(maKH);
			System.out.println("Nhập họ tên: ");
			hoTen = sc.nextLine();
			kh.setHoTen(hoTen);
			System.out.println("Nhập doanh số: ");
			doanhSo = sc.nextDouble();
			kh.setDoanhSo(doanhSo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi thêm: " + e.getMessage());
		}

		kh = new KhachHang(maKH, hoTen, doanhSo);
		return kh;
	}
}
