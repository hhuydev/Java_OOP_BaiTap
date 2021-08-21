/**
 * 
 */
package tuan3ChuyenXe;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestChuyenXe {
	static Scanner sc = new Scanner(System.in);
	static DanhSachChuyenXe ds = new DanhSachChuyenXe();
	static ArrayList<ChuyenXe> allCXe = new ArrayList<ChuyenXe>();

	public static void tieuDeXeNoi() {
		System.out.println(String.format("%-8s %-20s %-8s %8s %12s %16s", "Mã", "Tên tài xế", "Số xe", "Doanh thu",
				"Số tuyến", "Số km"));
	}

	public static void tieuDeXeNgoai() {
		System.out.println(String.format("%-8s %-20s %-8s %8s %12s %16s", "Mã", "Tên tài xế", "Số xe", "Doanh thu",
				"Nơi đến", "Số ngày đi"));
	}

	public static void xuatDSChuyenXe(ArrayList<ChuyenXe> allCXe) {
		int dem = 0, dem2 = 0;

		for (ChuyenXe xe : allCXe) {
			if (xe instanceof ChuyenXeNoiThanh) {
				if (dem == 0) {
					System.out.println("Xe nội thành:");
					tieuDeXeNoi();
					dem++;
				}
				System.out.println(xe);
			}

			if (xe instanceof ChuyenXeNgoaiThanh) {
				if (dem2 == 0) {
					System.out.println("Xe ngoại thành:");
					tieuDeXeNgoai();
					dem2++;
				}
				System.out.println(xe);
			}

		}
	}

	public static void nhapCungChuyenXe() {
		ChuyenXe xe1, xe2, xe3, xe4, xe5;
		xe1 = new ChuyenXeNoiThanh("111", "Đặng Bá", "113A", 50000, 125.5, "24");
		xe2 = new ChuyenXeNoiThanh("112", "Trần Anh", "118C", 40000, 97, "32");
		xe3 = new ChuyenXeNoiThanh("113", "Nguyễn Phúc", "116E", 35000, 92, "56");
		xe4 = new ChuyenXeNgoaiThanh("14", "Phạm Khang", "111B", 80000, "Tây Ninh ", 1);
		xe5 = new ChuyenXeNgoaiThanh("12", "Đào Vương", "112D", 90000, "Long An", 2);

		ds.themChuyenXe(xe1);
		ds.themChuyenXe(xe2);
		ds.themChuyenXe(xe3);
		ds.themChuyenXe(xe4);
		ds.themChuyenXe(xe5);
	}

	public static void menu() {
		System.out.println("\t\t\t\t==========MENU==========");
		System.out.println("1. Thêm cứng chuyến xe nội/ngoại thành");
		System.out.println("2. Thêm mềm xe nội thành");
		System.out.println("3. Thêm mềm xe ngoại thành");
		System.out.println("4. Xuất danh sách các chuyến xe");
		System.out.println("5. Xóa chuyến xe");
		System.out.println("6. Sửa chuyến xe nội thành");
		System.out.println("7. Sửa chuyến xe ngoại thành");
		System.out.println("8. Tổng doanh thu chuyến xe nội thành");
		System.out.println("9. Tổng doanh thu chuyến xe ngoại thành");
		System.out.println("10. Sắp xếp tổng doanh thu các chuyến xe");
		System.out.println("0. Thoát chương trình");
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ CHUYẾN XE NỘI - NGOẠI THÀNH");
		ChuyenXe xeTemp;
		int chon = 0;
		do {
			menu();
			System.out.println("Nhập lựa chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 0:
				System.out.println("Cảm ơn đã dùng chương trình!");
				System.exit(0);
				break;
			case 1:
				nhapCungChuyenXe();
				break;
			case 2:
				xeTemp = nhapMemXeNoiThanh();
				ds.themChuyenXe(xeTemp);
				break;
			case 3:
				xeTemp = nhapMemXeNgoaiThanh();
				ds.themChuyenXe(xeTemp);
				break;
			case 4:

				allCXe = ds.getAll();
				xuatDSChuyenXe(allCXe);
				break;
			case 5:
				xoaChuyenXe();
				break;
			case 6:
				ChuyenXe suaXeNoiThanh = suaChuyenXeNoiThanh();
				if (suaXeNoiThanh != null) {
					System.out.println("Sửa xe thành công! Hãy kiểm tra lại");
				} else
					System.out.println("Thông tin chuyến xe không tồn tại");
				break;
			case 7:
				ChuyenXe suaXeNgoaiThanh = suaChuyenXeNgoaiThanh();
				if (suaXeNgoaiThanh != null) {
					System.out.println("Sửa xe thành công! Hãy kiểm tra lại");
				} else
					System.out.println("Thông tin chuyến xe không tồn tại");

				break;
			case 8:
				tongDoanhThuXeNoiThanh();
				break;
			case 9:
				tongDoanhThuXeNgoaiThanh();
				break;
			case 10:
				ds.sapXepTheoDoanhThu();

				System.out.println("Danh sách các chuyến xe sau khi sắp xếp theo doanh thu:");
				xuatDSChuyenXe(allCXe);
				break;
			default:
				break;
			}
		} while (chon >= 0 && chon <= 10);

	}

	private static void tongDoanhThuXeNgoaiThanh() {
		// TODO Auto-generated method stub
		System.out.println("Tổng doanh thu xe ngoại thành = " + ds.tongDoanhThuXeNgoaiThanh());
	}

	private static void tongDoanhThuXeNoiThanh() {
		// TODO Auto-generated method stub
		System.out.println("Tổng doanh thu xe nội thành = " + ds.tongDoanhThuXeNoiThanh());
	}

	private static ChuyenXeNgoaiThanh suaChuyenXeNgoaiThanh() {
		// TODO Auto-generated method stub
		ChuyenXeNgoaiThanh xe;
		String maChuyen = "", tenTX = "", soXe = "", noiDen = "";
		double doanhThu = 0;
		int soNgay = 0;
		sc.nextLine();
		System.out.println("Nhập mã chuyến xe: ");
		maChuyen = sc.nextLine();
		xe = (ChuyenXeNgoaiThanh) ds.timChuyenXe(maChuyen);
		if (xe != null) {
			System.out.println("Thông tin chuyến xe trước khi sửa:");

			System.out.println(xe);

			System.out.println("Nhập thông tin mới");
			try {
				System.out.println("Nhập tên tài xế: ");
				tenTX = sc.nextLine();
				xe.setTenTX(tenTX);
				System.out.println("Nhập số xe:");
				soXe = sc.nextLine();
				xe.setSoXe(soXe);
				System.out.println("Nhập doanh thu:");
				doanhThu = sc.nextDouble();
				xe.setDoanhThu(doanhThu);
				System.out.println("Nhập số ngày đi:");
				soNgay = sc.nextInt();
				xe.setSoNgay(soNgay);
				sc.nextLine();
				System.out.println("Nhập nơi đến:");
				xe.setNoiDen(noiDen);
				noiDen = sc.nextLine();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		return xe;

	}

	public static void xoaChuyenXe() {
		// TODO Auto-generated method stub
		ChuyenXe xe;
		String maXe = "";
		String choice = "";
		System.out.println("Nhập mã chuyến xe cần xóa: ");
		maXe = sc.nextLine();
		xe = ds.timChuyenXe(maXe);
		if (xe != null) {
			System.out.println("Bạn muốn thực sự muốn xóa xe này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (ds.xoa(maXe)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách xe sau khi xóa");
					xuatDSChuyenXe(allCXe);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin chuyến xe không tồn tại");
	}

	private static ChuyenXeNoiThanh suaChuyenXeNoiThanh() {
		// TODO Auto-generated method stub
		ChuyenXeNoiThanh xe;
		String maChuyen = "", tenTX = "", soXe = "", soTuyen = "";
		double doanhThu = 0, soKM = 0;
		sc.nextLine();
		System.out.println("Nhập mã chuyến xe: ");
		maChuyen = sc.nextLine();
		xe = (ChuyenXeNoiThanh) ds.timChuyenXe(maChuyen);
		if (xe != null) {
			System.out.println("Thông tin chuyến xe trước khi sửa:");
			System.out.println(xe);

			System.out.println("Nhập thông tin mới");
			try {
				System.out.println("Nhập tên tài xế: ");
				tenTX = sc.nextLine();
				xe.setTenTX(tenTX);
				System.out.println("Nhập số xe:");
				soXe = sc.nextLine();
				xe.setSoXe(soXe);
				System.out.println("Nhập doanh thu:");
				doanhThu = sc.nextDouble();
				xe.setDoanhThu(doanhThu);
				System.out.println("Nhập số km:");
				soKM = sc.nextDouble();
				xe.setSoKm(soKM);
				System.out.println("Nhập số tuyến:");
				soTuyen = sc.nextLine();
				xe.setSoTuyen(soTuyen);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		}
		return xe;
	}

	private static ChuyenXe nhapMemXeNoiThanh() {
		String maChuyen = "", tenTX = "", soXe = "", soTuyen = "";
		double doanhThu = 0, soKM = 0;
		ChuyenXe xe = new ChuyenXeNoiThanh();
		try {
			sc.nextLine();
			System.out.println("Nhập mã chuyến: ");
			maChuyen = sc.nextLine();
			xe.setMaSoChuyen(maChuyen);
			System.out.println("Nhập tên tài xế: ");
			tenTX = sc.nextLine();
			xe.setTenTX(tenTX);
			System.out.println("Nhập số xe:");
			soXe = sc.nextLine();
			xe.setSoXe(soXe);
			System.out.println("Nhập doanh thu:");
			doanhThu = sc.nextDouble();
			xe.setDoanhThu(doanhThu);
			System.out.println("Nhập số km:");
			soKM = sc.nextDouble();
			sc.nextLine();
			System.out.println("Nhập số tuyến:");
			soTuyen = sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		xe = new ChuyenXeNoiThanh(maChuyen, tenTX, soXe, doanhThu, soKM, soTuyen);
		return xe;
	}

	private static ChuyenXe nhapMemXeNgoaiThanh() {
		String maChuyen = "", tenTX = "", soXe = "", noiDen = "";
		double doanhThu = 0;
		int soNgay = 0;
		ChuyenXe xe = new ChuyenXeNgoaiThanh();
		try {
			sc.nextLine();
			System.out.println("Nhập mã chuyến: ");
			maChuyen = sc.nextLine();
			xe.setMaSoChuyen(maChuyen);
			System.out.println("Nhập tên tài xế: ");
			tenTX = sc.nextLine();
			xe.setTenTX(tenTX);
			System.out.println("Nhập số xe:");
			soXe = sc.nextLine();
			xe.setSoXe(soXe);
			System.out.println("Nhập doanh thu:");
			doanhThu = sc.nextDouble();
			xe.setDoanhThu(doanhThu);

			System.out.println("Nhập số ngày đi:");
			soNgay = sc.nextInt();
			sc.nextLine();
			System.out.println("Nhập nơi đến:");
			noiDen = sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		xe = new ChuyenXeNgoaiThanh(maChuyen, tenTX, soXe, doanhThu, noiDen, soNgay);
		return xe;

	}
}
