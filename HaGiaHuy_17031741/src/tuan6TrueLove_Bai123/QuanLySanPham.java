/**
 * 
 */
package tuan6TrueLove_Bai123;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLySanPham {
	Set<SanPham> dsSP;

	public QuanLySanPham() {
		dsSP = new HashSet<SanPham>();
	}

	public Set<SanPham> getDSSP() {
		return dsSP;
	}


	public boolean xoaSP(String maSP) {
		// TODO Auto-generated method stub
		SanPham sp = timSP(maSP);
		if (sp != null) {
			dsSP.remove(sp);
			return true;
		} else
			return false;
	}

	public SanPham timSP(String maSP) {
		// TODO Auto-generated method stub
		for (SanPham x : dsSP) {
			if (x.getMaSP().equalsIgnoreCase(maSP))
				return x;
		}
		return null;
	}

	public boolean themSP(SanPham sp2) throws Exception {
		// TODO Auto-generated method stub
		if (dsSP.contains(sp2)) {
			throw new Exception("Trùng mã!");
		} else {
			dsSP.add(sp2);
			return true;
		}
	}

//	public ArrayList<String> randowTenNV() {
//		ArrayList<String> randomTen = new ArrayList<String>();
//		for (SanPham sp : dsSP) {
//			randomTen.add(sp.get());
//		}
//		return randomTen;
//	}

}
