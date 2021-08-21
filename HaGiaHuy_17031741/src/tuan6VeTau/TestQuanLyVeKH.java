/**
 * 
 */
package tuan6VeTau;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestQuanLyVeKH {
	static Scanner sc = new Scanner(System.in);
	static QuanLyVeKH qlVeKh = new QuanLyVeKH();
	static Queue<KhachHang> dsKH = new ArrayDeque<KhachHang>();

	static void tieuDeBang() {
		System.out.printf("%-15s %15s %15s %15s\n", "CMND", "Tên KH", "Trạm đến", "Giá vé");
	}

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Thêm cứng khách hàng");
		System.out.println("2. Thêm một khách hàng mới vào hàng đợi mua vé");
		System.out.println("3. Hiển thị danh sách khách hàng đợi mua vé.");
		System.out.println("4. Bán một vé cho khách hàng. Chỉ bán cho người đăng ký trước.");
		System.out.println("5. Thống kê tình hình bán vé ");
		System.out.println("6. Hủy một khách hàng ra khỏi danh sách. (Khách hàng không mua vé nữa)");
		System.out.println("7. Hiển thị danh sách các ga đang chờ mua vé.");
		System.out.println("8. Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga.");
		System.out.println("9. Lưu danh sách vào file");
		System.out.println("0. Thoát");
	}

	public static void xuatHetKH(Queue<KhachHang> dsKH) {
		for (KhachHang nv : dsKH) {
			System.out.println(nv);
		}
	}

	public static void nhapCung() throws Exception {

		KhachHang kh1 = new KhachHang("123", "Phạm An", "Bắc Ninh", 400000);
		KhachHang kh2 = new KhachHang("312", "Lê Mạnh", "Hà Nội", 430000);
		KhachHang kh3 = new KhachHang("232", "Trần Phúc", "Vũng Tàu", 120000);
		KhachHang kh4 = new KhachHang("454", "Đặng Ngọc", "Đà Lạt", 200000);
		KhachHang kh5 = new KhachHang("323", "Lâm Anh", "Đà Nẵng", 250000);

		qlVeKh.themKH(kh1);
		qlVeKh.themKH(kh2);
		qlVeKh.themKH(kh3);
		qlVeKh.themKH(kh4);
		qlVeKh.themKH(kh5);
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ BÁN VÉ TÀU");
		docFile();
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
					System.out.print("Nhập số lượng hành khách cần thêm: ");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						dsKH.add(qlVeKh.themKH(nhapTayKH()));
					}
					break;
				case 3:
					tieuDeBang();
					xuatHetKH(dsKH);
					break;

				case 4:
					KhachHang banVe = qlVeKh.banVeKHPhaiDau();
					if (banVe == null) {
						KhachHang temp = dsKH.peek();
						qlVeKh.dsKHDaMuaVe.add(temp);
						dsKH.remove(temp);
					} else
						dsKH.remove(banVe);
					System.out.println("Đã bán vé cho khách hàng ở hàng đợi đầu.");
					tieuDeBang();
					xuatHetKH(dsKH);
					break;
				case 5:
					Queue<KhachHang> dsKHDaMuaVe = qlVeKh.getDsKHDaMuaVe();
					tieuDeBang();
					xuatHetKH(dsKHDaMuaVe);
					tieuDeBang();
					xuatHetKH(dsKH);
					System.out.println("\nTổng tiền vé đã bán = " + qlVeKh.tongTienVeDaBan());
					break;
				case 6:
					xoaKHKhongConMuaVe();
					break;

				case 7:
					if (dsKH.size() > 0) {
						System.out.println("Danh sách ga chờ mua vé: ");
						for (KhachHang kh : dsKH) {
							System.out.println(kh.getGaDen());
						}
					} else
						System.out.println("Không còn khách chờ.");
					break;
				case 8:
					Map<String, Integer> thongKe = qlVeKh.thongKeSoVeTungGa();
					if (thongKe.size() > 0) {
						System.out.printf("%10s %15s\n", "Tên ga", "Số vé đã bán");
						for (String tenGa : thongKe.keySet())
							System.out.printf("%10s %15s\n", tenGa, thongKe.get(tenGa));
					} else
						System.out.println("Chưa bán vé nào.");
					break;
				case 9:
					luuFile();
					break;

				}
			} while (chon >= 0 && chon <= 9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void luuFile() {
		try {
			DocGhiFile.luuFile(dsKH);
			System.out.println("Lưu file thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi lưu file: " + e.getMessage());
		}
	}

	public static void docFile() {
		try {
			dsKH = qlVeKh.docDuLieuTuFile();
			tieuDeBang();
			xuatHetKH(dsKH);
			System.out.println("Đọc file thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi đọc file: " + e.getMessage());
		}
	}

	public static void xoaKHKhongConMuaVe() {
		KhachHang kh;
		String cmnd = "";
		String choice = "";
		System.out.println("Nhập cmnd khách hàng cần xóa: ");
		cmnd = sc.nextLine();
		kh = qlVeKh.timKH(cmnd);
		if (kh != null) {
			System.out.println("Bạn muốn thực sự muốn xóa khách hàng này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (dsKH.remove(kh)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách khách hàng hiện tại");
					xuatHetKH(dsKH);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin khách hàng không tồn tại");
	}

	public static KhachHang nhapTayKH() {
		String cmnd = "", noiDen = "", hoTen = "";
		double giaVe = 0;
		KhachHang kh = new KhachHang();
		try {
			sc.nextLine();
			System.out.println("Nhập cmnd: ");
			cmnd = sc.nextLine();
			kh.setCmnd(cmnd);
			System.out.println("Nhập họ tên: ");
			hoTen = sc.nextLine();
			kh.setTenKH(hoTen);
			System.out.println("Nhập nơi đến: ");
			noiDen = sc.nextLine();
			kh.setGaDen(noiDen);
			System.out.println("Nhập giá vé: ");
			giaVe = sc.nextDouble();
			kh.setGiaTien(giaVe);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}
		kh = new KhachHang(cmnd, hoTen, noiDen, giaVe);
		return kh;
	}

}
