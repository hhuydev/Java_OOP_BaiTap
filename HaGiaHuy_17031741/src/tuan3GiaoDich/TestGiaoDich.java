/**
 * 
 */
package tuan3GiaoDich;

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
	static QuanLyGiaoDich qlGD = new QuanLyGiaoDich();
	static ArrayList<GiaoDich> dsGiaoDich = new ArrayList<GiaoDich>();
	static Scanner sc = new Scanner(System.in);

	public static void tieuDeGDVang() {
		System.out.println(String.format("%-10s %5s %20s %25s %25s %31s", "Mã giao dịch", "Số lượng", "Ngày giao dịch",
				"Đơn giá", "Loại vàng", "Thành tiền"));
	}

	public static void tieuDeGDTien() {
		System.out.println(String.format("%-10s %5s %20s %25s %25s %10s %21s", "Mã giao dịch", "Số lượng",
				"Ngày giao dịch", "Đơn giá", "Loại tiền", "Tỉ giá", "Thành tiền"));
	}

	public static void xuatHetGD(ArrayList<GiaoDich> dsGiaoDich) {
		int dem = 0, dem2 = 0;
		for (GiaoDich gd : dsGiaoDich) {
			if (gd instanceof GiaoDichVang) {
				if (dem == 0) {
					System.out.println("Giao dịch vàng:");
					tieuDeGDVang();
					dem++;
				}
				System.out.println(gd);
			}

			if (gd instanceof GiaoDichTienTe) {
				if (dem2 == 0) {
					System.out.println("Giao dịch tiền:");
					tieuDeGDTien();
					dem2++;
				}
				System.out.println(gd);
			}

		}
	}

	static void menu() {
		System.out.println("========== MENU ==========");
		System.out.println("1.Nhập cứng các giao dịch");
		System.out.println("2.Nhập tay giao dịch vàng");
		System.out.println("3.Nhập tay giao dịch tiền tệ");
		System.out.println("4.Xuất các giao dịch");
		System.out.println("5.Tính tổng số lượng sao dịch vàng");
		System.out.println("6.Tính tổng số lượng sao dịch tiền tệ");
		System.out.println("7.Tính trung bình thành tiền giao dịch tiền tệ");
		System.out.println("8.Xuất giao dịch có đơn giá trên 1 tỷ");
		System.out.println("9.Xóa giao dịch");
		System.out.println("10.Sửa thông tin giao dịch");
		System.out.println("11.Sắp xếp thành tiền các các giao dịch");
		System.out.println("0.Thoát");
	}

	public static void nhapCung() throws Exception {
		GregorianCalendar date1 = new GregorianCalendar(2021, Calendar.MAY, 5);
		GregorianCalendar date2 = new GregorianCalendar(2021, 4, 3);
		GregorianCalendar date3 = new GregorianCalendar(2021, 2, 12);
		GregorianCalendar date4 = new GregorianCalendar(2021, 6, 12);
		GregorianCalendar date5 = new GregorianCalendar(2021, 3, 12);
		GiaoDich gd1 = new GiaoDichVang("11a", date1, 1312314435.34, 5, "Miếng");
		GiaoDich gd2 = new GiaoDichVang("12f", date2, 23232.4, 5, "Nhẫn");
		GiaoDich gd3 = new GiaoDichTienTe("14x", date3, 23134, 10, "USD", 1.5);
		GiaoDich gd4 = new GiaoDichTienTe("16e", date4, 232123, 10, "VND", 1.5);
		GiaoDich gd5 = new GiaoDichTienTe("17g", date5, 1787523221, 10, "EURO", 1.5);
		qlGD.themGD(gd1);
		qlGD.themGD(gd2);
		qlGD.themGD(gd3);
		qlGD.themGD(gd4);
		qlGD.themGD(gd5);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("\t\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ GIAO DỊCH TIỀN - VÀNG");
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
					GiaoDich gd = nhapTayGDVang();
					qlGD.themGD(gd);
					break;
				case 3:
					gd = nhapTayGDTien();
					qlGD.themGD(gd);
					break;
				case 4:

					dsGiaoDich = qlGD.getALLGD();
					xuatHetGD(dsGiaoDich);
					break;
				case 5:
					System.out.println("Tổng giao dịch vàng = " + qlGD.tongSLGDVang());
					break;
				case 6:
					System.out.println("Tổng giao dịch tiền = " + qlGD.tongSLGDTien());
					break;
				case 7:
					System.out.println("Trung bình giao dịch tiền tệ = " + qlGD.trungBinhCongTienTe());
					break;
				case 8:
					gd = qlGD.giaoDichHon1Ty();
					if (gd != null) {

						System.out.println(gd);
					} else
						System.out.println("Không có giao dịch trên 1 tỷ!");
					break;
				case 9:
					System.out.println("Nhập mã giao dịch cần xóa: ");
					String timMaGD = sc.nextLine();
					if (qlGD.xoaGD(timMaGD) != false) {
						System.out.println("Xóa giao dịch thành công. Vui lòng kiểm tra lại!");
					} else
						System.out.println("Không tìm thấy mã giao dịch để xóa!");
					break;
				case 10:
					gd = suaThongTinGD();
					if (gd != null)
						System.out.println("Sửa thông tin giao dịch thành công vui lòng kiểm tra lại!");
					else
						System.out.println("Không tìm thấy giao dịch cần sửa!");
					break;
				case 11:
					qlGD.sapXepTheoThanhTienGD();

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
		System.out.println("Nhập mã giao dịch cần xóa: ");
		maGD = sc.nextLine();
		gd = qlGD.timGD(maGD);
		if (gd != null) {
			System.out.println("Bạn muốn thực sự muốn xóa giao dịch này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				if (qlGD.xoaGD(maGD)) {
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

	static GiaoDich nhapTayGDVang() {
		String maGd = "", ngay = "", loaiVang = "";
		double donGia = 0;
		int soLuong = 0;
		Date temp = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar date = new GregorianCalendar();
		GiaoDich x = new GiaoDichVang();
		try {
			System.out.println("Nhập mã giao dịch: ");
			maGd = sc.nextLine();
			x.setMaGD(maGd);
			System.out.println("Nhập ngày/tháng/năm giao dịch: ");
			ngay = sc.nextLine();
			temp = sf.parse(ngay);
			date.setTime(temp);
			x.setNgayGD(date);
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			x.setDonGia(donGia);
			System.out.println("Nhập số lượng vàng giao dịch: ");
			soLuong = sc.nextInt();
			x.setSoLuong(soLuong);
			sc.nextLine();
			System.out.println("Nhập loai vàng giao dịch: ");
			loaiVang = sc.nextLine();
			((GiaoDichVang) x).setLoaiVang(loaiVang);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		x = new GiaoDichVang(maGd, date, donGia, soLuong, loaiVang);
		return x;
	}

	static GiaoDich nhapTayGDTien() {
		String maGd = "", loaiTien = "", ngay = "";
		double tiGia = 0, donGia = 0;
		int soLuong = 0;
		Date temp = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar date = new GregorianCalendar();
		GiaoDich x = new GiaoDichTienTe();
		try {
			System.out.println("Nhập mã giao dịch: ");
			maGd = sc.nextLine();
			x.setMaGD(maGd);
			System.out.println("Nhập ngày/tháng/năm giao dịch: ");
			ngay = sc.nextLine();
			temp = sf.parse(ngay);
			date.setTime(temp);
			x.setNgayGD(date);
			System.out.println("Nhập đơn giá: ");
			donGia = sc.nextDouble();
			x.setDonGia(donGia);
			System.out.println("Nhập số lượng tiền giao dịch: ");
			soLuong = sc.nextInt();
			x.setSoLuong(soLuong);
			sc.nextLine();
			System.out.println("Nhập loại tiền: ");
			loaiTien = sc.nextLine();
			((GiaoDichTienTe) x).setLoaiTien(loaiTien);
			System.out.println("Nhập tỉ giá: ");
			tiGia = sc.nextDouble();
			((GiaoDichTienTe) x).setTiGia(tiGia);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		x = new GiaoDichTienTe(maGd, date, donGia, soLuong, loaiTien, tiGia);
		return x;
	}

	static GiaoDich suaThongTinGD() throws Exception {
		System.out.println("Nhập mã giao dịch tìm để sửa: ");
		String timMaGD = sc.nextLine();
		GiaoDich suaGD = qlGD.timGD(timMaGD);
		if (suaGD != null) {
			System.out.println("\nThông tin giao dịch trước khi sửa");

			System.out.println(suaGD);
		}
		try {
			System.out.println("Nhập ngày/tháng/năm cần sửa: ");
			String suaNgay = sc.nextLine();
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date date = df.parse(suaNgay);
			GregorianCalendar gC = new GregorianCalendar();
			gC.setTime(date);
			suaGD.setNgayGD(gC);
			qlGD.sua(suaGD);
			System.out.println("Nhập đơn giá cần sửa: ");
			double suaDonGia = sc.nextDouble();
			suaGD.setDonGia(suaDonGia);
			qlGD.sua(suaGD);
			System.out.println("Nhập số lượng cần sửa: ");
			int suaSoLuong = sc.nextInt();
			suaGD.setSoLuong(suaSoLuong);
			qlGD.sua(suaGD);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return suaGD;

	}
}
