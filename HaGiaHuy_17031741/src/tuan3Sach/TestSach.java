/**
 * 
 */
package tuan3Sach;

/**
 * @author Huy Dep Trai
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestSach {
	static DanhSachSach qlSach = new DanhSachSach();
	static ArrayList<Sach> dsSach = new ArrayList<Sach>();
	static Scanner sc = new Scanner(System.in);

	public static void tieuDeSachGK() {
		System.out.println(String.format("%-5s %5s %-15s %20s %20s %22s %20s", "Mã sách", "Số lượng", "Nhà xuất bản",
				"Đơn giá", "Ngày nộp", "Tình trạng", "Thành tiền"));
	}

	public static void tieuDeSachTK() {
		System.out.println(String.format("%-5s %5s %-15s %20s %20s %22s %20s", "Mã sách", "Số lượng", "Nhà xuất bản",
				"Đơn giá", "Ngày nộp", "Thuế", "Thành tiền"));
	}

	public static void xuatCacSach(ArrayList<Sach> dsSach) {
		int dem = 0, dem2 = 0;
		for (Sach s : dsSach) {
			if (s instanceof SachThamKhao) {
				if (dem == 0) {
					System.out.println("Sách tham khảo:");
					tieuDeSachTK();
					dem++;
				}
				System.out.println(s);
			}

			if (s instanceof SachGiaoKhoa) {
				if (dem2 == 0) {
					System.out.println("Sách giáo khoa:");
					tieuDeSachGK();
					dem2++;
				}
				System.out.println(s);
			}

		}
	}

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1.Nhập cứng sách  ");
		System.out.println("2.Nhập tay sách giáo khoa");
		System.out.println("3.Nhập tay sách tham khảo");
		System.out.println("4.Xuất thông tin sách");
		System.out.println("5.Tính tổng tiền cho sách giáo khoa");
		System.out.println("6.Tính tổng tiền cho sách tham khảo");
		System.out.println("7.Tính trung bình đơn giá sách tham khảo");
		System.out.println("8.Xuất các sách giáo khoa của nhà xuất bản X");
		System.out.println("9.Xóa sách");
		System.out.println("10.Sửa thông tin sách");
		System.out.println("11.Khoảng cách giữa 2 ngày 2 cuốn sách");
		System.out.println("12.Sắp xếp theo đơn giá");
		System.out.println("0.Thoát");
	}

	public static void nhapCung() throws Exception {
		GregorianCalendar date1 = new GregorianCalendar(2021, 10, 28);
		GregorianCalendar date2 = new GregorianCalendar(2021, Calendar.APRIL, 25);
		GregorianCalendar date3 = new GregorianCalendar(2021, 8, 5);
		GregorianCalendar date4 = new GregorianCalendar(2021, 4, 5);
		GregorianCalendar date5 = new GregorianCalendar(2021, Calendar.MARCH, 5);
		Sach sach1 = new SachGiaoKhoa("a11", "Kim Dong", date1, 12000, 3, "moi");
		Sach sach2 = new SachGiaoKhoa("a22", "Phuong Nam", date2, 50000, 33, "moi");
		Sach sach3 = new SachGiaoKhoa("a33", "Giao duc", date3, 500000, 33, "cu");
		Sach sach4 = new SachThamKhao("a44", "Dong A", date4, 100000, 24);
		Sach sach5 = new SachThamKhao("a55", "Cambridge", date5, 100000, 12);
		qlSach.themSach(sach1);
		qlSach.themSach(sach2);
		qlSach.themSach(sach3);
		qlSach.themSach(sach4);
		qlSach.themSach(sach5);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ SÁCH");
		try {
			int chon;
			do {
				menu();
				System.out.println("Mời bạn chọn: ");
				chon = sc.nextInt();

				switch (chon) {
				case 1:
					nhapCung();
					break;
				case 2:
					Sach sach = nhapTaySachGiaoKhoa();
					qlSach.themSach(sach);
					break;
				case 3:
					sach = nhapTaySachThamKhao();
					qlSach.themSach(sach);
					break;
				case 4:

					dsSach = qlSach.getLstSach();
					xuatCacSach(dsSach);
					break;
				case 5:
					System.out.println("Tổng tiền sách giáo khoa: " + (qlSach.tongTienSachGK()));
					break;
				case 6:
					System.out.println("Tổng tiền sách tham khảo: " + (qlSach.tongTienSachTK()));
					break;
				case 7:
					System.out.println("Trung bình cộng đơn giá sách tham khảo: " + (qlSach.trungBinhDonGiaSTK()));
					break;
				case 8:
					sc.nextLine();
					System.out.println("Nhập tên nhà xuất bản cần tìm: ");
					String timNXB = sc.nextLine();
					if (qlSach.timTenNXB(timNXB) != null) {
						sach = qlSach.timTenNXB(timNXB);
						System.out.println("Thông tin sách theo nxb: " + sach);
					} else
						System.out.println("Không tìm thấy tên nhà xuất bản!");
					break;
				case 9:
					xoaSach();
					break;
				case 10:
					sach = suaThongTinSach();
					if (sach != null)
						System.out.println("Sửa sách thành công! Hãy kiểm tra lại");
					else
						System.out.println("Không tìm thấy sách cần sửa!");
					break;
				case 11:
					sc.nextLine();
					System.out.println("Nhập mã sách thứ nhất: ");
					String timMaSach1 = sc.nextLine();
					System.out.println("Nhập mã sách thứ hai: ");
					String timMaSach2 = sc.nextLine();
					if (qlSach.khoangCachGiuaHaiNgay(timMaSach1, timMaSach2) != -1) {
						long kC = qlSach.khoangCachGiuaHaiNgay(timMaSach1, timMaSach2);
						if (qlSach.khoangCachGiuaHaiNgay(timMaSach1, timMaSach2) < 0) {
							System.out.println("Khoảng cách giữa 2 ngày = "
									+ (qlSach.khoangCachGiuaHaiNgay(timMaSach1, timMaSach2) * -1));
						} else
							System.out.println("Khoảng cách giữa 2 ngày = "
									+ (qlSach.khoangCachGiuaHaiNgay(timMaSach1, timMaSach2)));
					} else
						System.out.println("Không tìm thấy mã sách!");
					break;
				case 12:
					qlSach.sapXepTheoDonGia();

					System.out.println("Danh sách các sách sau khi sắp xếp theo đơn giá:");
					xuatCacSach(dsSach);
					break;

				}
			} while (chon >= 0 && chon <= 12);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaSach() {
		// TODO Auto-generated method stub
		Sach s;
		String maSach = "";
		String choice = "";
		System.out.println("Nhập mã khách hàng cần xóa: ");
		maSach = sc.nextLine();
		s = qlSach.timSach(maSach);
		if (s != null) {
			System.out.println("Bạn muốn thực sự muốn xóa sách này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qlSach.xoaSach(maSach)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách sách sau khi xóa");
					xuatCacSach(dsSach);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin sách không tồn tại");
	}

	static Sach nhapTaySachGiaoKhoa() throws Exception {
		GregorianCalendar ngayNhapTay = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Sach x = new SachGiaoKhoa();
		String tTrang = "", ma = "", nxb = "";
		double donGia = 0;
		int soLuong = 0;
		sc.nextLine();
		try {
			System.out.println("Nhập mã sách");
			ma = sc.nextLine();
			x.setMaSach(ma);
			System.out.println("Nhập nhà xuất bản");
			nxb = sc.nextLine();
			x.setNhaXBan(nxb);
			System.out.println("Nhập ngày/tháng/năm: ");
			String ngay = sc.nextLine();
			Date d = df.parse(ngay);
			ngayNhapTay.setTime(d);
			x.setNgayNhap(ngayNhapTay);
			System.out.println("Nhập đơn giá");
			donGia = sc.nextDouble();
			x.setDonGia(donGia);
			System.out.println("Nhập số lượng");
			soLuong = sc.nextInt();
			x.setSoLuong(soLuong);
			sc.nextLine();
			System.out.println("Nhập tình trạng sách: ");
			tTrang = sc.nextLine();
			((SachGiaoKhoa) x).setTinhTrang(tTrang);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		x = new SachGiaoKhoa(ma, nxb, ngayNhapTay, donGia, soLuong, tTrang);
		return x;
	}

	static Sach nhapTaySachThamKhao() throws Exception {

		GregorianCalendar ngayNhapTay = new GregorianCalendar();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Sach x = new SachThamKhao();
		String tTrang = "", ma = "", nxb = "";
		double donGia = 0, thue = 0;
		int soLuong = 0;
		sc.nextLine();
		try {
			System.out.println("Nhập mã sách");
			ma = sc.nextLine();
			x.setMaSach(ma);
			System.out.println("Nhập nhà xuất bản");
			nxb = sc.nextLine();
			x.setNhaXBan(nxb);
			System.out.println("Nhap ngay dang [dd/MM/yyyy]: ");
			String ngay = sc.nextLine();
			df = new SimpleDateFormat("dd/MM/yyyy");
			Date d = df.parse(ngay);
			ngayNhapTay.setTime(d);
			x.setNgayNhap(ngayNhapTay);
			System.out.println("Nhập đơn giá");
			donGia = sc.nextDouble();
			x.setDonGia(donGia);
			System.out.println("Nhập số lượng");
			soLuong = sc.nextInt();
			x.setSoLuong(soLuong);
			System.out.println("Nhập thuế");
			thue = sc.nextDouble();
			((SachThamKhao) x).setThue(thue);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		x = new SachThamKhao(ma, nxb, ngayNhapTay, donGia, soLuong, thue);
		return x;
	}

	static Sach suaThongTinSach() throws Exception {
		sc.nextLine();
		String timMaSach = "", suaNXB = "", suaNgay = "";
		double suaDonGia = 0;
		int suaSoLuong = 0;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		GregorianCalendar gC = new GregorianCalendar();
		Sach sachSua = new SachGiaoKhoa();
		System.out.println("Nhập mã sách tìm để sửa: ");
		timMaSach = sc.nextLine();
		sachSua = qlSach.timSach(timMaSach);
		if (sachSua != null) {
			System.out.println("\nThông tin sách trước khi sửa");
			System.out.println(sachSua);
		}
		try {
			System.out.println("Nhập tên nhà xuất bản cần sửa: ");
			suaNXB = sc.nextLine();
			sachSua.setNhaXBan(suaNXB);
			qlSach.sua(sachSua);
			System.out.println("Nhập ngày/tháng/năm cần sửa: ");
			suaNgay = sc.nextLine();
			date = df.parse(suaNgay);
			gC.setTime(date);
			sachSua.setNgayNhap(gC);
			qlSach.sua(sachSua);
			System.out.println("Nhập đơn giá cần sửa: ");
			suaDonGia = sc.nextDouble();
			sachSua.setDonGia(suaDonGia);
			qlSach.sua(sachSua);
			System.out.println("Nhập số lượng cần sửa: ");
			suaSoLuong = sc.nextInt();
			sachSua.setSoLuong(suaSoLuong);
			qlSach.sua(sachSua);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return sachSua;

	}

}
