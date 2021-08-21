/**
 * 
 */
package tuan4NhaDat;

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
public class TestGiaoDich {
	static DanhSachGiaoDich qLND = new DanhSachGiaoDich();
	static ArrayList<GiaoDich> dsGiaoDich = new ArrayList<GiaoDich>();
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1.Nhập cứng danh sách quản lý giao dịch ");
		System.out.println("2.Nhập tay giao dịch đất");
		System.out.println("3.Nhập tay giao dịch nhà");
		System.out.println("4.Xuất danh sách giao dịch");
		System.out.println("5.Tính số lượng giao dịch đất");
		System.out.println("6.Tính số lượng giao dịch nhà");
		System.out.println("7.Tính trung bình thành tiền giao dịch đất");
		System.out.println("8.Xuất các giao dịch tháng 9 năm 2013");
		System.out.println("9.Xóa giao dịch");
		System.out.println("10.Sửa thông tin giao dịch");
		System.out.println("11.Sắp xếp theo thành tiền các giao dịch");
		System.out.println("0.Thoát");
	}

	public static void nhapCung() throws Exception {
		GregorianCalendar ngay1 = new GregorianCalendar(2021, 3, 10);
		GregorianCalendar ngay2 = new GregorianCalendar(2021, Calendar.MARCH, 20);
		GregorianCalendar ngay3 = new GregorianCalendar(2021, Calendar.APRIL, 1);
		GregorianCalendar ngay4 = new GregorianCalendar(2021, 4, 23);
		GregorianCalendar ngay5 = new GregorianCalendar(2013, 10, 12);
		GiaoDich gd1 = new GiaoDichDat("11a", ngay1, 30000000000f, 1000, "A");
		GiaoDich gd2 = new GiaoDichDat("12a", ngay2, 15000000000f, 200, "B");
		GiaoDich gd3 = new GiaoDichNha("13a", ngay3, 50000000000f, 150, "cao cap", "123 Go Vap HCM");
		GiaoDich gd4 = new GiaoDichNha("14a", ngay4, 50000000000f, 120, "thuong", "42b Binh Thanh HCM");
		GiaoDich gd5 = new GiaoDichNha("15a", ngay5, 50000000000f, 70, "cao cap", "23 Truong Dinh HCM");
		qLND.themGD(gd1);
		qLND.themGD(gd2);
		qLND.themGD(gd3);
		qLND.themGD(gd4);
		qLND.themGD(gd5);
	}

	public static void tieuDeGDDat() {
		System.out.println(String.format("%-10s %13s %25s %15s %25s %20s", "Mã giao dịch", "Ngày GD", "Đơn giá",
				"Diện tích", "Loại đất", "Thành tiền"));
	}

	public static void tieuDeGDNha() {
		System.out.println(String.format("%-10s %13s %25s %15s %25s %14s %25s", "Mã giao dịch", "Ngày GD", "Đơn giá",
				"Diện tích", "Loại nhà", "Địa chỉ", "Thành tiền"));
	}

	public static void xuatHetGD(ArrayList<GiaoDich> dsGiaoDich) {
		int dem = 0, dem2 = 0;
		for (GiaoDich gd : dsGiaoDich) {
			if (gd instanceof GiaoDichNha) {
				if (dem == 0) {
					System.out.println("Giao dịch nhà:");
					tieuDeGDNha();
					dem++;
				}
				System.out.println(gd);
			}

			if (gd instanceof GiaoDichDat) {
				if (dem2 == 0) {
					System.out.println("Giao dịch đất:");
					tieuDeGDDat();
					dem2++;
				}
				System.out.println(gd);
			}

		}
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ GIAO DỊCH NHÀ - ĐẤT");
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
					GiaoDich x = nhapTayGDDat();
					if (x != null) {
						qLND.themGD(x);
						System.out.println("Thêm thành công!");
						xuatHetGD(dsGiaoDich);
					}
					break;
				case 3:
					x = nhapTayGDDat();
					if (x != null) {
						qLND.themGD(x);
						System.out.println("Thêm thành công!");
						xuatHetGD(dsGiaoDich);
					}
					break;
				case 4:

					dsGiaoDich = qLND.getAllGD();
					xuatHetGD(dsGiaoDich);
					break;
				case 5:
					System.out.println("Tổng giao dịch đất = " + qLND.tongSoLuongGDDat());
					break;
				case 6:
					System.out.println("Tổng giao dịch nhà = " + qLND.tongSoLuongGDNha());
					break;
				case 7:
					System.out.println("Thành tiền trung bình giao dịch đất = " + qLND.trungBinhGDDat());
					break;
				case 8:
					System.out.println("Các giao dich tháng 9 năm 2013: ");
					ArrayList<GiaoDich> temp = qLND.lay2013();
					if (temp != null) {

						for (GiaoDich gd : temp) {
							System.out.println(gd);
						}
					} else
						System.out.println("Không có giao dich tháng 9 năm 2013!");

					break;
				case 9:
					xoaGiaoDich();
					break;
				case 10:
					GiaoDich suaGD = suaThongTinGD();
					if (suaGD != null) {
						System.out.println("Sửa giao dịch thành công! Hãy kiểm tra lại");
						System.out.println("Giao dịch sau khi sửa thông tin:");
						System.out.println(suaGD);
					} else
						System.out.println("Không tìm thấy giao dịch!");

					break;
				case 11:
					qLND.sapXepTheoThanhTienGD();

					System.out.println("Danh sách các giao dịch sau khi sắp xếp theo thành tiền:");
					xuatHetGD(dsGiaoDich);
					break;

				}
			} while (chon >= 0 && chon <= 11);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void xoaGiaoDich() {
		// TODO Auto-generated method stub
		GiaoDich gd;
		String maGD = "";
		String choice = "";
		System.out.println("Nhập mã khách hàng cần xóa: ");
		maGD = sc.nextLine();
		gd = qLND.timGD(maGD);
		if (gd != null) {
			System.out.println("Bạn muốn thực sự muốn xóa giao dịch này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qLND.xoaGD(maGD)) {
					System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
					System.out.println("Danh sách giao dịch sau khi xóa");
					xuatHetGD(dsGiaoDich);
					return;
				}

				else {
					System.out.println("Xóa bị lỗi! Vui lòng kiểm tra lại.");
					return;
				}
			} else
				return;
		} else
			System.out.println("Thông tin giao dịch không tồn tại");
	}

	public static GiaoDich nhapTayGDDat() {
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String maGD = "", ngay = "", loaiDat = "";
		float dienTich = 0;
		double donGia = 0;
		Date temp = new Date();
		GiaoDich x = new GiaoDichDat();
		try {
			System.out.println("Nhập mã giao dịch: ");
			maGD = sc.nextLine();
			System.out.println("Nhập ngày/tháng/năm giao dịch: ");
			ngay = sc.nextLine();
			temp = sf.parse(ngay);
			date.setTime(temp);
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			System.out.println("Nhập diện tích đất: ");
			dienTich = sc.nextFloat();
			sc.nextLine();
			System.out.println("Nhập loai đất (A, B, C): ");
			loaiDat = sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		x = new GiaoDichDat(maGD, date, donGia, dienTich, loaiDat);
		return x;
	}

	public static GiaoDich nhapTayGDNha() {
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String maGD = "", ngay = "", loaiNha = "", diaChi = "";
		float dienTich = 0;
		double donGia = 0;
		Date temp = new Date();
		GiaoDich x = new GiaoDichNha();
		try {
			System.out.println("Nhập mã giao dịch: ");
			maGD = sc.nextLine();
			System.out.println("Nhập ngày/tháng/năm giao dịch: ");
			ngay = sc.nextLine();
			sf = new SimpleDateFormat("dd/MM/yyyy");
			temp = sf.parse(ngay);
			date.setTime(temp);
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			System.out.println("Nhập diện tích nhà: ");
			dienTich = sc.nextFloat();
			sc.nextLine();
			System.out.println("Nhập loại nhà (Cao cấp - Thường): ");
			loaiNha = sc.nextLine();
			System.out.println("Nhập địa chi: ");
			diaChi = sc.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		x = new GiaoDichNha(maGD, date, donGia, dienTich, loaiNha, diaChi);
		return x;
	}

	static GiaoDich suaThongTinGD() throws Exception {
		GregorianCalendar date = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String maGD = "", ngay = "";
		float dienTich = 0;
		double donGia = 0;
		Date temp = new Date();
		System.out.println("Nhập mã giao dịch tìm để sửa: ");
		maGD = sc.nextLine();
		GiaoDich suaGD = qLND.timGD(maGD);
		if (suaGD != null) {
			System.out.println("\nThông tin giao dịch trước khi sửa");

			System.out.println(suaGD);
			try {
				System.out.println("Nhập ngày/tháng/năm cần sửa: ");
				ngay = sc.nextLine();
				temp = sf.parse(ngay);
				date.setTime(temp);
				suaGD.setNgayGD(date);
				qLND.sua(suaGD);
				System.out.println("Nhập đơn giá cần sửa: ");
				donGia = sc.nextDouble();
				suaGD.setDonGia(donGia);
				qLND.sua(suaGD);
				System.out.println("Nhập diện tích cần sửa: ");
				dienTich = sc.nextFloat();
				suaGD.setDienTich(dienTich);
				qLND.sua(suaGD);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		return suaGD;
	}
}
