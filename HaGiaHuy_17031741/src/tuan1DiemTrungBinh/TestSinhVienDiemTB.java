/**
 * 
 */
package tuan1DiemTrungBinh;

import java.util.Scanner;

/**
 * @author Ha Gia Huy
 *
 */
public class TestSinhVienDiemTB {

	public static void tieuDeBang() {
		System.out.println(
				String.format("%-5s %-30s %10s %10s %10s", "Mã SV", "Họ tên", "Điểm LT", "Điểm TH", "Điểm TB"));
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH TÍNH ĐIỂM TB SINH VIÊN\n");
		SinhVien sv1 = new SinhVien(123, "Lê Văn Bảo", 8, 7);
		SinhVien sv2 = new SinhVien(111, "Phùng Ngọc Mai", 10, 9);

		tieuDeBang();
		System.out.println(sv1);
		System.out.println(sv2);
		SinhVien sv3 = nhapMemThongTin();
		System.out.println(sv3);
	}

	public static SinhVien nhapMemThongTin() {
		int masv;
		String hoten;
		float diemLT, diemTH;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã số của sinh viên sv: ");
		masv = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập họ và tên của sinh viên: ");
		hoten = sc.nextLine();
		System.out.println("Nhập điểm lý thuyết của sinh viên: ");
		diemLT = sc.nextFloat();
		System.out.println("Nhập điểm thực hành của sinh viên: ");
		diemTH = sc.nextFloat();
		SinhVien sv = new SinhVien(masv, hoten, diemLT, diemTH);
		return sv;

	}
}
