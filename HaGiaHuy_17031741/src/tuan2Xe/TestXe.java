/**
 * 
 */
package tuan2Xe;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestXe {
	static Scanner sc = new Scanner(System.in);
	static Xe[] xe = new Xe[10];
	static DanhSachXe dsXe = new DanhSachXe(10);

	public static void tieuDeBang() {

		System.out.println(String.format("%-10s %-20s %-15s %-15s %-15s %-15s", "Mã xe", "Tên chủ xe", "Loại xe",
				"Dung tích", "Trị giá", "Thuế phải nộp"));

	}

	public static void xuatDanhSach(Xe[] dsXe, int length) {
		for (int i = 0; i < length; i++) {
			System.out.println(dsXe[i]);
		}
	}

	public static void menu() {

		System.out.println("\t\t\t\t========== MENU ==========");
		System.out.println("1. Nhập thông tin xe");
		System.out.println("2. Xuất bảng kê khai thuế theo các xe");
		System.out.println("3. Xoá thông tin xe");
		System.out.println("4. Sửa thông tin xe");
		System.out.println("5. Tìm kiếm thông tin xe");
		System.out.println("6. Tổng thuế các loại xe");
		System.out.println("0. Thoát");
	}

	public static void main(String[] args) {
		System.out.println("\t\t\tCHƯƠNG TRÌNH QUẢN LÝ THUẾ RƯỚC BẠ KHI MUA XE\n");

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
				dsXe.themXe(new Xe("A1", "Nguyen A", "Future Neo", 35000000, 100));
				dsXe.themXe(new Xe("A2", "Le B", "Ford Ranger", 250000000, 3000));
				dsXe.themXe(new Xe("A3", "Pham C", "Landscape", 1000000000, 1500));
				break;
			case 2:
				tieuDeBang();
				xuatDanhSach(dsXe.getAllXe(), dsXe.length);
				break;
			case 3:
				xoaXe();
				break;
			case 4:
				Xe suaXe;
				try {
					suaXe = suaThongTinXe();
					System.out.println("Sửa xe thành công! Hãy kiểm tra lại");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Không tìm thấy xe để sửa!");
				}

				break;
			case 5:
				timThongTinXe();
				break;
			case 6:
				tongThueXe();
				break;
			}
		} while (chon >= 0 || chon <= 6);

	}

	/**
	 * @param dsXe
	 */
	public static void tongThueXe() {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(10);
		System.out.printf("Tổng thuế các loại xe: " + df.format(dsXe.tongThue()));
	}

	/**
	 * @param dsXe
	 */
	public static void timThongTinXe() {
		// TODO Auto-generated method stub
		Xe xe;
		String tenChuXe = "";
		sc.nextLine();
		System.out.println("Nhập tên chủ xe: ");
		tenChuXe = sc.nextLine();
		xe = dsXe.timXe(tenChuXe);
		if (xe != null) {
			System.out.println("Thông tin xe tìm được:");
			System.out.println(xe);
		} else
			System.out.println("Thông tin xe không tồn tại");
	}

	/**
	 * @throws Exception
	 * 
	 */
	public static Xe suaThongTinXe() throws Exception {
		// TODO Auto-generated method stub
		Xe xe;
		String maXe = "", tenChuXe = "", loaiXe = "";
		long triGiaXe = 0;
		int dungTich = 0;
		sc.nextLine();
		System.out.println("Nhập mã xe: ");
		maXe = sc.nextLine();
		xe = dsXe.timXe(maXe);
		if (xe != null) {
			try {
				System.out.println("Thông tin xe trước khi sửa:");
				System.out.println(xe);
				System.out.println("Nhập thông tin mới");
				System.out.println("Nhập tên chủ xe: ");
				tenChuXe = sc.nextLine();

				System.out.println("Loại xe:");
				loaiXe = sc.nextLine();

				System.out.println("Dung tích xe:");
				dungTich = sc.nextInt();

				System.out.println("Trị giá xe:");
				triGiaXe = sc.nextLong();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			dsXe.suaThongTinXe(maXe, tenChuXe, loaiXe, triGiaXe, dungTich);
		}
		return xe;
	}

	public static Xe nhapMemThongTinXe() {
		String chuXe = "", loaiXe = "", maXe = "";
		int dungTich = 0;
		long triGia = 0;
		Xe xe = new Xe();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Nhập mã xe: ");
			maXe = sc.nextLine();
			xe.setMaXe(maXe);
			System.out.println("Nhập tên chủ xe: ");
			chuXe = sc.nextLine();
			xe.setChuXe(chuXe);
			System.out.println("Nhập loại xe: ");
			loaiXe = sc.nextLine();
			xe.setLoaiXe(loaiXe);
			System.out.println("Nhập dung tích: ");
			dungTich = sc.nextInt();
			xe.setDungTich(dungTich);
			System.out.println("Nhập trị giá: ");
			triGia = sc.nextLong();
			xe.setTriGiaXe(triGia);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		xe = new Xe(maXe, chuXe, loaiXe, triGia, dungTich);
		return xe;

	}

	public static void xoaXe() {
		// TODO Auto-generated method stub
		Xe xe;
		String tenChuXe;
		String choice = "";
		sc.nextLine();
		System.out.println("Nhập tên chủ xe: ");
		tenChuXe = sc.nextLine();
		xe = dsXe.timXe(tenChuXe);
		if (xe != null) {
			System.out.println("Bạn muốn thực sự muốn xóa xe này?");
			System.out.println("Nhấn 'y' để xóa ");
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				dsXe.xoaXe(xe);
				System.out.println("Xóa thành công! Vui lòng kiểm tra lại.");
			} else
				return;
		} else
			System.out.println("Thông tin xe không tồn tại");
	}

}
