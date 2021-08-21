/**
 * 
 */
package tuan2AccountBank;

import java.util.Scanner;

import tuan2Xe.DanhSachXe;
import tuan2Xe.Xe;

/**
 * @author Ha Gia Huy
 *
 */
public class TestAccount {
	static Scanner sc = new Scanner(System.in);

	public static void tieuDeBang() {
		System.out.println(String.format("%10s %-20s %15s %-25s", "Số TK", "Tên TK", "Số Dư", "Trạng thái"));
	}

	public static void menu() {

		System.out.println("\t\t\t\t========== MENU ==========");
		System.out.println("1. Thêm tài khoản");
		System.out.println("2. Danh sách số tài khoản hiện có");
		System.out.println("3. Xuất danh sách thông tin tài khoản");
		System.out.println("4. Nạp tiền vào tài khoản");
		System.out.println("5. Rút tiền vào tài khoản");
		System.out.println("6. Chuyển tiền vào tài khoản");
		System.out.println("0. Thoát");
	}

	public static void main(String[] args) {
		System.out.println("\t\t\t\tCHƯƠNG TRÌNH QUẢN LÝ ACCOUNT BANK\n");
		int chon = 0;
		Account[] acc = new Account[10];
		DanhSachAccount dsAccount = new DanhSachAccount(10);
		do {
			menu();
			System.out.println("Nhập lựa chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 0:
				System.exit(0);
				break;
			case 1:
				nhapCungAccount(dsAccount);
				break;
			case 2:
				xuatDanhSachSoTK(dsAccount.getAllAccount(), dsAccount.length);
				break;
			case 3:
				tieuDeBang();
				xuatDanhSachAccount(dsAccount.getAllAccount(), dsAccount.length);
				break;
			case 4:
				napTien(dsAccount);
				break;
			case 5:
				rutTien(dsAccount);
				break;
			case 6:
				chuyenTien(dsAccount);
				break;
			}
		} while (chon >= 0 || chon <= 6);

	}

	/**
	 * @param accChuyen
	 * @param accNhan
	 * @param tienChuyen
	 */
	public static void chuyenTien(DanhSachAccount dsAccount) {
		// TODO Auto-generated method stub
		long soTK;
		double tienChuyen;
		Account accChuyen, accNhan;
		System.out.println("Nhập số tài khoản cần chuyển: ");
		soTK = sc.nextLong();
		accChuyen = dsAccount.timAccount(soTK);
		System.out.println("Nhập số tài khoản nhận: ");
		soTK = sc.nextLong();
		accNhan = dsAccount.timAccount(soTK);
		if (accChuyen != null && accNhan != null) {
			System.out.println("Nhập số tiền cần chuyển: ");
			tienChuyen = sc.nextDouble();
			if (accChuyen.chuyenTien(accChuyen, accNhan, tienChuyen)) {
				System.out.println("Chuyển tiền thành công vui lòng kiểm tra lại số dư");
			} else
				System.out.println("Chuyển tiền thất bại! Số tiền rút phải < số dư hiện tại!");

		} else
			System.out.println("Không tìm thấy tài khoản!");
	}

	/**
	 * @param dsAccount
	 */
	public static void rutTien(DanhSachAccount dsAccount) {
		// TODO Auto-generated method stub
		long soTK;
		double tienRut;
		Account acc;
		System.out.println("Nhập số tài khoản cần rút: ");
		soTK = sc.nextLong();
		acc = dsAccount.timAccount(soTK);
		if (acc != null) {
			System.out.println("Nhập số tiền cần rút: ");
			tienRut = sc.nextDouble();
			if (acc.rutTien(tienRut)) {
				System.out.println("Rút tiền thành công vui lòng kiểm tra lại số dư");
			} else
				System.out.println("Rút tiền thất bại! Số tiền rút phải < số dư hiện tại!");

		} else
			System.out.println("Không tìm thấy tài khoản!");
	}

	/**
	 * 
	 */
	private static void napTien(DanhSachAccount dsAccount) {
		// TODO Auto-generated method stub
		long soTK;
		double tienNap;
		Account acc;
		System.out.println("Nhập số tài khoản cần nạp: ");
		soTK = sc.nextLong();
		acc = dsAccount.timAccount(soTK);
		if (acc != null) {
			System.out.println("Nhập số tiền cần nạp: ");
			tienNap = sc.nextDouble();
			if (acc.napTien(tienNap)) {
				System.out.println("Nạp tiền thành công vui lòng kiểm tra lại số dư");
			} else
				System.out.println("Nạp tiền thất bại! Số tiền nạp phải > 0!");
		} else
			System.out.println("Không tìm thấy tài khoản!");
	}

	/**
	 * @param dsAccount
	 */
	public static void xuatDanhSachSoTK(Account[] dsAccount, int length) {
		// TODO Auto-generated method stub
		System.out.println("Danh sách số tài khoản của các account");
		for (int i = 0; i < length; i++) {
			System.out.println(dsAccount[i].getSoTK());
		}
	}

	/**
	 * @param dsAccounts
	 * @param length
	 */
	public static void xuatDanhSachAccount(Account[] dsAccounts, int length) {
		// TODO Auto-generated method stub
		for (int i = 0; i < length; i++) {
			System.out.println(dsAccounts[i]);
		}
	}

	public static Account nhapMemAccount() {
		String tenTK, trangThai;
		double soTien;
		long soTK;
		Account acc;
		System.out.println("Nhập số TK: ");
		soTK = sc.nextLong();
		System.out.println("Nhập tên TK: ");
		tenTK = sc.nextLine();
		System.out.println("Nhập số tiền: ");
		soTien = sc.nextDouble();
		System.out.println("Nhập trạng thái: ");
		trangThai = sc.nextLine();
		acc = new Account(soTK, tenTK, soTien, trangThai);
		return acc;

	}

	/**
	 * @param dsAccount
	 */
	public static void nhapCungAccount(DanhSachAccount dsAccount) {
		// TODO Auto-generated method stub
		Account acc = new Account();

		acc = new Account(101, "Lê Bảo Ngọc", 30000000, "Unknow");
		dsAccount.themAccount(acc);
		acc = new Account(102, "Phạm Vân", 15000000, "Unknow");
		dsAccount.themAccount(acc);
		acc = new Account(103, " Phan Văn Mạnh", 25000000, "Unknow");
		dsAccount.themAccount(acc);
		acc = new Account(104, "Võ Văn Phi", 50000000, "Unknow");
		dsAccount.themAccount(acc);
		acc = new Account(105, "Trần Bảy", 400000, "Unknow");
		dsAccount.themAccount(acc);
	}
}
