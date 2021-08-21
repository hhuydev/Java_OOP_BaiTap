/**
 * 
 */
package tuan2AccountBank;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachAccount {
	Account dsAccounts[];
	public int length;

	/**
	 * 
	 */
	public DanhSachAccount(int length) {
		// TODO Auto-generated constructor stub
		dsAccounts = new Account[length];
	}

	public boolean themAccount(Account acc) {
		if (timAccount(acc.getSoTK()) != null)
			return false;

		if (length == dsAccounts.length)
			MangTangKichThuoc();
		dsAccounts[length] = acc;
		length++;
		return true;
	}

	public void xoaAccount(Account acc) {
		int viTri = timViTriAccount(acc.getSoTK());
		for (int i = viTri; i < dsAccounts.length - 1; i++) {
			dsAccounts[i] = dsAccounts[i + 1];
		}
		length--;

	}

	public boolean suaThongTinAccount(long soTK, String tenTK, double soTien, String trangThai) throws Exception {
		int index = timViTriAccount(soTK);
		dsAccounts[index].setTenTK(tenTK);
		dsAccounts[index].setSoTien(soTien);
		dsAccounts[index].setTrangThai(trangThai);
		return true;
	}

	public Account[] getAllAccount() {
		return dsAccounts;
	}

	/**
	 * 
	 */
	private void MangTangKichThuoc() {
		// TODO Auto-generated method stub
		Account[] temp = new Account[(int) (dsAccounts.length * 2)];
		for (int i = 0; i < dsAccounts.length; i++)
			temp[i] = dsAccounts[i];
		dsAccounts = temp;
	}

	public int timViTriAccount(long soTK) {
		int i;
		for (i = 0; i < length; i++) {
			if (dsAccounts[i].getSoTK() == soTK)
				return i;
		}
		return -1;
	}

	/**
	 * @param soTK
	 * @return
	 */
	public Account timAccount(long soTK) {
		// TODO Auto-generated method stub
		for (int i = 0; i < length; ++i) {
			if (dsAccounts[i].getSoTK() == soTK)
				return dsAccounts[i];
		}
		return null;
	}

}
