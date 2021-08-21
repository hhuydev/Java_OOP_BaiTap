
package tuan6TrueLove_Bai123;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestNhanVienTrueLove {
	static Scanner sc = new Scanner(System.in);
	static QuanLyNhanVien qlNV = new QuanLyNhanVien();
	static ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();

	static void tieuDeBangNV() {
		System.out.printf("%-12s %-20s %-13s %-10s\n", "Mã NV", "Tên NV", "SDT", "Cmnd");
	}

	static void tieuDeBangSP() {
		System.out.printf("%-12s %-20s %20s\n", "Mã SP", "Tên SP", "Giá bán");
	}

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1. Nhập cứng nhân viên");
		System.out.println("2. Xuất danh sách tất cả nhân viên");
		System.out.println("3. Xóa nhân viên");
		System.out.println("4. Sửa thông tin nhân viên");
		System.out.println("5. Sắp xếp theo tên nhân viên");
		System.out.println("6. Chọn ngẫu nhiên 1 nhân viên để nhận quà");
		System.out.println("7. Đặt tên sản phẩm theo tên nhân viên");
		System.out.println("8. Đặt tên sản phẩm theo tên phổ biến của nhân viên");
		System.out.println("0. Thoát");
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

	public static void xuatHetNV(ArrayList<NhanVien> ds) {
		for (NhanVien nv : ds) {
			System.out.println(nv);
		}
	}

	public static void main(String[] args) {
		System.out.println("Chương trình quản lý nhân viên bởi công ty TrueLove");
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
					dsNV = qlNV.getDSNhanVien();
					tieuDeBangNV();
					xuatHetNV(dsNV);
					break;
				case 3:
					xoaNV();
					break;
				case 4:
					suaThongTinNV();
					break;
				case 5:
					qlNV.sapXepNhanVienTheoTen();
					System.out.println("Danh sách nhân viên sau khi sắp xếp theo tên:");
					tieuDeBangNV();
					xuatHetNV(dsNV);
					break;
				case 6:
					ArrayList<String> randomTenNV = qlNV.randowTenNV();
					if (randomTenNV != null) {
						Random rd = new Random();
						int indexRandow = rd.nextInt(randomTenNV.size());
						String randomTen = randomTenNV.get(indexRandow);
						System.out.println("Nhân viên ngẫu nhiên dc nhận quả là: " + randomTen);
					} else
						System.out.println("Hiện tại không có nhân viên!");
					break;
				case 7:
					randomTenNV = qlNV.randowTenNV();
					if (randomTenNV != null) {
						Random rd = new Random();
						int indexRandow = rd.nextInt(randomTenNV.size());
						String randomTen = randomTenNV.get(indexRandow);
						SanPham sp = nhapTTSP(randomTen);
						System.out.println("Sản phẩm mới dc đặt theo tên nhân viên: ");
						tieuDeBangSP();
						System.out.println(sp);
					} else
						System.out.println("Không có nhân viên nào để tìm đặt tên cho sản phẩm!");
					break;
				case 8:
					String tenPhoBien = qlNV.timTenPhoBien();
					if (tenPhoBien.length() > 0) {
						SanPham sp = nhapTTSP(tenPhoBien);
						System.out.println("Sản phẩm mới dc đặt theo tên phổ biến các nhân viên : ");
						tieuDeBangSP();
						System.out.println(sp);
					} else
						System.out.println("Tên các nhân viên chỉ xuất hiện 1 lần! Không có tên nào phổ biến");
					break;

				}
			} while (chon >= 0 && chon <= 8);
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
				qlNV.sua(nv);
				System.out.println("Nhập SĐT cần sửa: ");
				sdt = sc.nextLine();
				nv.setSdt(sdt);
				qlNV.sua(nv);
				System.out.println("Nhập cmnd cần sửa: ");
				cmnd = sc.nextLine();
				nv.setCmnd(cmnd);
				qlNV.sua(nv);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi sửa: " + e.getMessage());
			}
		}
		System.out.println("Sửa thông tin nhân viên thành công vui lòng kiểm tra lại!");
		System.out.println("Danh sách nhân viên sau khi sửa:");
		tieuDeBangNV();
		xuatHetNV(dsNV);
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
				if (qlNV.xoaNV(maNV)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách nhân viên sau khi xóa");
					tieuDeBangNV();
					xuatHetNV(dsNV);
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

	public static SanPham nhapTTSP(String randomTenNV) {
		String maSP = "";
		double giaBan = 0;
		SanPham nv = new SanPham();
		try {
			System.out.println("Nhập mã sản phẩm: ");
			maSP = sc.nextLine();
			nv.setMaSP(maSP);
			nv.setTenSP(randomTenNV);
			System.out.println("Nhập giá bán: ");
			giaBan = sc.nextDouble();
			nv.setGiaBan(giaBan);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Thêm lỗi: " + e.getMessage());
		}
		return nv;
	}
}
