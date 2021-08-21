/**
 * 
 */
package tuan4TienDienKhachHang;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestKhachHang {
	static DanhSachKhachHang qLKH = new DanhSachKhachHang();
	static ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1.Nhập cứng danh sách quản lý hóa đơn khách hàng ");
		System.out.println("2.Nhập tay khách hàng ngoại");
		System.out.println("3.Nhập tay khách hàng VN");
		System.out.println("4.Xuất danh sách hóa đơn khách hàng");
		System.out.println("5.Tính số lượng khách hàng ngoại");
		System.out.println("6.Tính số lượng khách hàng VN");
		System.out.println("7.Tính trung bình thành tiền KH nước ngoài");
		System.out.println("8.Xuất các hóa đơn KH ngoại tháng 9 năm 2013");
		System.out.println("9.Xuất các hóa đơn KH VN tháng 9 năm 2013");
		System.out.println("10.Xóa khách hàng");
		System.out.println("11.Sửa thông tin khách hàng");
		System.out.println("12.Sắp xếp theo thành tiền các hóa đơn");
		System.out.println("0.Thoát");
	}

	public static void nhapCung() throws Exception {
		GregorianCalendar ngay1 = new GregorianCalendar(2021, 3, 10);
		GregorianCalendar ngay2 = new GregorianCalendar(2021, Calendar.MARCH, 20);
		GregorianCalendar ngay3 = new GregorianCalendar(2021, Calendar.APRIL, 1);
		GregorianCalendar ngay4 = new GregorianCalendar(2013, 10, 1);
		GregorianCalendar ngay5 = new GregorianCalendar(2013, 10, 12);
		KhachHang kh1 = new KhachHangNuocNgoai("NN01", "Trần Thanh Minh", ngay1, 200, 3200, "USA");
		KhachHang kh2 = new KhachHangNuocNgoai("NN02", "Trần Ngọc Ngân", ngay2, 100, 3200, "Singapore");
		KhachHang kh3 = new KhachHangVN("VN01", "Phạm Văn Toàn", ngay3, 100, 3000, "Sinh hoạt", 200);
		KhachHang kh4 = new KhachHangVN("VN02", "Nguyễn Tấn Thanh", ngay4, 210, 3000, "Kinh Doanh", 200);
		KhachHang kh5 = new KhachHangNuocNgoai("NN03", "Võ An", ngay5, 200, 3200, "AUS");

		qLKH.themKH(kh1);
		qLKH.themKH(kh2);
		qLKH.themKH(kh3);
		qLKH.themKH(kh4);
		qLKH.themKH(kh5);
	}

	public static void tieuDeKHNgoai() {
		System.out.println(String.format("%-16s %-23s %-12s %-7s %-12s %-23s %21s", "Mã KH", "Họ Tên", "Ngày Lập HD",
				"Số KW", "Đơn Giá", "Quốc tịnh", "Thành Tiền"));
	}

	public static void tieuDeKHVN() {
		System.out.println(String.format("%-16s %-23s %-12s %-7s %-12s %-23s %-10s %-15s", "Mã KH", "Họ Tên",
				"Ngày Lập HD", "Số KW", "Đơn Giá", "Đối tượng", "Định Mức", "Thành Tiền"));
	}

	public static void xuatHetKH(ArrayList<KhachHang> dsKhachHang) {
		int dem = 0, dem2 = 0;
		for (KhachHang kh : dsKhachHang) {
			if (kh instanceof KhachHangNuocNgoai) {
				if (dem == 0) {
					System.out.println("Khách nước ngoài:");
					tieuDeKHNgoai();
					dem++;
				}
				System.out.println(kh);
			}

			if (kh instanceof KhachHangVN) {
				if (dem2 == 0) {
					System.out.println("Khách trong nước:");
					tieuDeKHVN();
					dem2++;
				}
				System.out.println(kh);
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ TIỀN ĐIỆN kHÁCH VN - QUỐC TẾ");
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
					KhachHang x = nhapTayKHNgoai();
					qLKH.themKH(x);
					break;
				case 3:
					x = nhapTayKHVN();
					qLKH.themKH(x);
					break;
				case 4:
					dsKH = qLKH.getAllKH();
					xuatHetKH(dsKH);
					break;
				case 5:
					System.out.println("Tổng sl KH ngoại = " + qLKH.tongSoLuongKHNgoai());
					break;
				case 6:
					System.out.println("Tổng sl KH VN = " + qLKH.tongSoLuongKHVN());
					break;
				case 7:
					System.out.println("Thành tiền trung bình hóa đơn KH ngoại = " + qLKH.trungBinhKHNuocNgoai());
					break;
				case 8:
					System.out.println("Các hóa đơn tháng 9 năm 2013 KH ngoại: ");
					ArrayList<KhachHang> temp = qLKH.lay2013KHNgoai();
					if (temp != null) {

						for (KhachHang gd : temp) {
							System.out.println(gd);
						}
					} else
						System.out.println("Không có hóa đơn tháng 9 năm 2013 của KH ngoại");

					break;
				case 9:
					System.out.println("Các hóa đơn tháng 9 năm 2013 KH VN: ");
					temp = qLKH.lay2013KHVN();
					if (temp != null) {

						for (KhachHang gd : temp) {
							System.out.println(gd);
						}
					} else
						System.out.println("Không có hóa đơn tháng 9 năm 2013 của KH VN");

					break;
				case 10:
					xoaKhachHang();
					break;
				case 11:
					KhachHang suaKH = suaThongTinKH();
					if (suaKH != null) {
						System.out.println("Sửa thông tin khách hàng thành công! Hãy kiểm tra lại");
						System.out.println("Khách hàng sau khi sửa thông tin:");
						System.out.println(suaKH);
					} else
						System.out.println("Không tìm thấy khách hàng!");

					break;
				case 12:
					qLKH.sapXepTheoThanhTien();

					System.out.println("Danh sách các khách hàng sau khi sắp xếp theo thành tiền theo hóa đơn:");
					xuatHetKH(dsKH);
					break;

				}
			} while (chon >= 0 && chon <= 11);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaKhachHang() {
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
				if (qLKH.xoaKH(maKH)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách khách hàng sau khi xóa");
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

	static KhachHang suaThongTinKH() throws Exception {
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String maKH = "", ngay = "", hoTen = "";
		int soKW = 0;
		double donGia = 0;
		Date temp = new Date();
		KhachHang x;
		System.out.println("Nhập mã KH tìm để sửa: ");
		maKH = sc.nextLine();
		KhachHang suaKH = qLKH.timKH(maKH);
		if (suaKH != null) {
			System.out.println("\nThông tin khách hàng trước khi sửa");

			System.out.println(suaKH);
			try {
				System.out.println("Nhập ngày/tháng/năm cần sửa: ");
				ngay = sc.nextLine();
				temp = sf.parse(ngay);
				date.setTime(temp);
				suaKH.setNgayLapHD(date);
				qLKH.sua(suaKH);
				System.out.println("Nhập đơn giá cần sửa: ");
				donGia = sc.nextDouble();
				suaKH.setDonGia(donGia);
				qLKH.sua(suaKH);
				System.out.println("Nhập số KW cần sửa: ");
				soKW = sc.nextInt();
				suaKH.setSoKW(soKW);
				qLKH.sua(suaKH);
				System.out.println("Nhập họ tên cần sửa: ");
				hoTen = sc.nextLine();
				suaKH.setHoTen(hoTen);
				qLKH.sua(suaKH);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		return suaKH;
	}

	public static KhachHang nhapTayKHNgoai() {
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String maKH = "", ngay = "", hoTen = "", quocTich = "";
		int soKW = 0;
		double donGia = 0;
		Date temp = new Date();
		KhachHang x = new KhachHangNuocNgoai();
		try {
			System.out.println("Nhập mã KH: ");
			maKH = sc.nextLine();
			x.setMaKH(maKH);
			System.out.println("Nhập họ tên KH: ");
			hoTen = sc.nextLine();
			x.setHoTen(hoTen);
			System.out.println("Nhập ngày/tháng/năm lập hóa đơn: ");
			ngay = sc.nextLine();
			sf = new SimpleDateFormat("dd/MM/yyyy");
			temp = sf.parse(ngay);
			date.setTime(temp);
			x.setNgayLapHD(date);
			System.out.println("Nhập số KW: ");
			soKW = sc.nextInt();
			x.setSoKW(soKW);
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			x.setDonGia(donGia);
			sc.nextLine();
			System.out.println("Nhập quốc tịch: ");
			quocTich = sc.nextLine();
			((KhachHangNuocNgoai) x).setQuocTich(quocTich);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		x = new KhachHangNuocNgoai(maKH, hoTen, date, soKW, donGia, quocTich);
		return x;
	}

	public static KhachHang nhapTayKHVN() {
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String maKH = "", ngay = "", hoTen = "", doiTuong = "";
		int soKW = 0, dinhMuc = 0;
		double donGia = 0;
		Date temp = new Date();
		KhachHang x = new KhachHangVN();
		try {
			System.out.println("Nhập mã KH: ");
			maKH = sc.nextLine();
			x.setMaKH(maKH);
			System.out.println("Nhập họ tên KH: ");
			hoTen = sc.nextLine();
			x.setHoTen(hoTen);
			System.out.println("Nhập ngày/tháng/năm lập hóa đơn: ");
			ngay = sc.nextLine();
			sf = new SimpleDateFormat("dd/MM/yyyy");
			temp = sf.parse(ngay);
			date.setTime(temp);
			x.setNgayLapHD(date);
			System.out.println("Nhập số KW: ");
			soKW = sc.nextInt();
			x.setSoKW(soKW);
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			x.setDonGia(donGia);
			sc.nextLine();
			System.out.println("Nhập đối tượng (kinh doanh - san xuat - sinh hoat): ");
			doiTuong = sc.nextLine();
			((KhachHangVN) x).setDoiTuong(doiTuong);
			System.out.println("Nhập định mức: ");
			dinhMuc = sc.nextInt();
			((KhachHangVN) x).setDinhMuc(dinhMuc);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		x = new KhachHangVN(maKH, hoTen, date, soKW, donGia, doiTuong, dinhMuc);
		return x;
	}

}
