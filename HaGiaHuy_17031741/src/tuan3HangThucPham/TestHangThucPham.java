/**
 * 
 */
package tuan3HangThucPham;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import tuan2Xe.Xe;
import tuan3ChuyenXe.ChuyenXe;
import tuan3ChuyenXe.ChuyenXeNoiThanh;

/**
 * @author Ha Gia Huy
 *
 */
public class TestHangThucPham {
	static Scanner sc = new Scanner(System.in);
	static HangThucPham[] tp = new HangThucPham[10];
	static DanhSachThucPham dsThucPham = new DanhSachThucPham(10);

	public static void tieuDeBang() {
		System.out.println(String.format("%10s %20s %25s %20s %20s", "Mã thực phẩm", "Tên thực phẩm", "Đơn giá",
				"Ngày sản xuất", "Ngày hết hạn"));

	}

	public static void menu() {

		System.out.println("\t\t\t\t========== MENU ==========");
		System.out.println("1. Nhập cứng thông tin thực phẩm");
		System.out.println("2. Nhập mềm thông tin thực phẩm");
		System.out.println("3. Xuất danh sách hàng thực phẩm");
		System.out.println("4. Sửa thông tin thực phẩm");
		System.out.println("5. Tìm kiếm thông tin thực phẩm");
		System.out.println("6. Xóa thực phẩm");
		System.out.println("7. Kiểm tra 1 thực phẩm đã hết hạn");
		System.out.println("8. Xuất danh sách thực phẩm đã hết hạn");
		System.out.println("9. Trung bình đơn giá các loại thực phẩm");
		System.out.println("0. Thoát");
	}

	public static void xuatDanhSachThucPham(HangThucPham[] dsTP, int length) {
		for (int i = 0; i < length; i++) {
			System.out.println(dsTP[i]);
		}
	}

	public static void nhapCungTP() {
		HangThucPham tp = new HangThucPham();

		tp = new HangThucPham("A10", "Cá Thu", 200000, new GregorianCalendar(2021, Calendar.MARCH, 10),
				new GregorianCalendar(2021, Calendar.MARCH, 15));
		dsThucPham.themThucPham(tp);
		tp = new HangThucPham("A20", "Bánh ngọt", 50000, new GregorianCalendar(2021, Calendar.JANUARY, 3),
				new GregorianCalendar(2021, Calendar.JANUARY, 21));
		dsThucPham.themThucPham(tp);
		tp = new HangThucPham("A30", "Thịt bò", 220000, new GregorianCalendar(2021, Calendar.FEBRUARY, 4),
				new GregorianCalendar(2021, Calendar.FEBRUARY, 18));
		dsThucPham.themThucPham(tp);
		tp = new HangThucPham("A40", "Bò viên", 75000, new GregorianCalendar(2021, Calendar.JULY, 25),
				new GregorianCalendar(2021, Calendar.JULY, 27));
		dsThucPham.themThucPham(tp);
		tp = new HangThucPham("A50", "Cà rốt", 30000, new GregorianCalendar(2021, Calendar.SEPTEMBER, 20),
				new GregorianCalendar(2021, Calendar.SEPTEMBER, 22));
		dsThucPham.themThucPham(tp);
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ HÀNG THỰC PHẨM\n");

		int chon = 0;
		do {
			menu();
			System.out.println("Nhập lựa chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 0:
				System.exit(0);
				break;
			case 1:
				nhapCungTP();
				break;
			case 2:
				System.out.print("Nhập số lượng hàng thực phẩm cần thêm: ");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					dsThucPham.themThucPham(nhapMemThucPham());
				}
				break;
			case 3:
				tieuDeBang();
				xuatDanhSachThucPham(dsThucPham.getAllThucPham(), dsThucPham.length);
				break;
			case 4:
				HangThucPham suaTp = suaThongTinThucPham();
				if (suaTp != null) {
					System.out.println("Sửa thực phẩm thành công! Hãy kiểm tra lại");
					tieuDeBang();
					xuatDanhSachThucPham(dsThucPham.getAllThucPham(), dsThucPham.length);
				} else
					System.out.println("Không tìm thấy thực phẩm!");
				break;
			case 5:
				timThucPham();
				break;
			case 6:
				xoaThucPham();
				System.out.println("Danh sách thục phẩm sau khi xóa:");
				tieuDeBang();
				xuatDanhSachThucPham(dsThucPham.getAllThucPham(), dsThucPham.length);
				break;
			case 7:
				kiemTraThucPhamHetHan();
				break;
			case 8:
				tp = dsThucPham.getAllThucPham();
				System.out.println("Danh sách thực phẩm hết hạn:");
				tieuDeBang();
				for (int i = 0; i < dsThucPham.length; i++) {
					if (dsThucPham.kiemTraHetHan(tp[i]))
						System.out.println(tp[i].toString());
				}
				break;
			case 9:
				System.out.println("Trung bình đơn giá các thực phẩm = " + dsThucPham.trungBinhDonGiaThucPham());
				break;
			}
		} while (chon >= 0 || chon <= 9);

	}

	public static void kiemTraThucPhamHetHan() {
		HangThucPham tp;
		String maHang = "";
		sc.nextLine();
		System.out.println("Nhập mã thực phẩm kiểm tra hết hạn: ");
		maHang = sc.nextLine();
		tp = dsThucPham.timThucPham(maHang);
		if (tp != null) {
			if (dsThucPham.kiemTraHetHan(tp)) {
				System.out.println("Thực phẩm đã quá hạn sử dụng");
			} else
				System.out.println("Thực phẩm còn hạn sử dụng");
		} else
			System.out.println("Thông tin thực phẩm không tồn tại");
	}

	public static void xoaThucPham() {
		// TODO Auto-generated method stub
		HangThucPham tp;
		String maHang = "";
		String choice = "";
		sc.nextLine();
		System.out.println("Nhập mã thực phẩm: ");
		maHang = sc.nextLine();
		tp = dsThucPham.timThucPham(maHang);
		if (tp != null) {
			System.out.println("Bạn muốn thực sự muốn xóa thực phẩm này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				dsThucPham.xoaThucPham(tp);
				System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
				return;
			}

			else {
				System.out.println("Cảm ơn bạn đã dùng chức năng sửa");
			}

		} else
			System.out.println("Thông tin thực phẩm không tồn tại");
	}

	public static void timThucPham() {
		String maHang = "";
		HangThucPham tp = new HangThucPham();
		sc.nextLine();
		System.out.println("Nhập mã hàng: ");
		maHang = sc.nextLine();
		tp = dsThucPham.timThucPham(maHang);
		if (tp != null) {
			System.out.println("Thông tin thực phẩm tìm được:");
			tieuDeBang();
			System.out.println(tp);
		} else
			System.out.println("Không tìm thấy thực phẩm!");

	}

	public static HangThucPham suaThongTinThucPham() {
		String maHang = "", tenHang = "", ngay = "";
		GregorianCalendar ngaySS = new GregorianCalendar();
		GregorianCalendar ngayHH = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateTemp = new Date();
		double donGia = 0;
		HangThucPham tp = new HangThucPham();
		sc.nextLine();
		System.out.println("Nhập mã hàng: ");
		maHang = sc.nextLine();
		tp = dsThucPham.timThucPham(maHang);
		if (tp != null) {
			try {
				System.out.println("Thông tin hàng thực phẩm trước khi sửa:");
				tieuDeBang();
				System.out.println(tp);
				System.out.println("Nhập thông tin mới");
				System.out.println("Nhập tên thực phẩm: ");
				tenHang = sc.nextLine();
				tp.setTenHang(tenHang);
				System.out.println("Nhập đơn giá:");
				donGia = sc.nextDouble();
				tp.setDonGia(donGia);
				sc.nextLine();
				System.out.println("Nhập ngày sản xuất:");
				ngay = sc.nextLine();
				dateTemp = sf.parse(ngay);
				ngaySS.setTime(dateTemp);
				tp.setNgaySXuat(ngaySS);
				System.out.println("Nhập ngày hết hạn:");
				ngay = sc.nextLine();
				dateTemp = sf.parse(ngay);
				ngayHH.setTime(dateTemp);
				tp.setNgayHHan(ngayHH);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lỗi:" + e.getMessage());
				System.out.println("Sửa không thành công!");
			}
		}
		return tp;
	}

	public static HangThucPham nhapMemThucPham() {
		String maHang = "", tenHang = "", ngay = "";
		GregorianCalendar ngaySS = new GregorianCalendar();
		GregorianCalendar ngayHH = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateTemp = new Date();
		double donGia = 0;
		HangThucPham tp = new HangThucPham();
		try {
			sc.nextLine();
			System.out.println("Nhập mã hàng: ");
			maHang = sc.nextLine();
			if (dsThucPham.timThucPham(maHang) == null) {
				tp.setMaHang(maHang);
				System.out.println("Nhập tên thực phẩm: ");
				tenHang = sc.nextLine();
				tp.setTenHang(tenHang);
				System.out.println("Nhập đơn giá:");
				donGia = sc.nextDouble();
				tp.setDonGia(donGia);
				sc.nextLine();
				System.out.println("Nhập ngày sản xuất:");
				ngay = sc.nextLine();
				dateTemp = sf.parse(ngay);
				ngaySS.setTime(dateTemp);
				tp.setNgaySXuat(ngaySS);
				System.out.println("Nhập ngày hết hạn:");
				ngay = sc.nextLine();
				dateTemp = sf.parse(ngay);
				ngayHH.setTime(dateTemp);
				tp.setNgayHHan(ngayHH);
//				long khoangCachHaiNgay = (ngayHH.getTime().getTime() - ngaySS.getTime().getTime()) / (24 * 3600 * 1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi: " + e.getMessage());
			System.out.println("Thêm không thành công!");
		}
		tp = new HangThucPham(maHang, tenHang, donGia, ngaySS, ngayHH);
		return tp;

	}

}
