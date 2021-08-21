/**
 * 
 */
package tuan3ChuyenXe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Ha Gia Huy
 *
 */
public class DanhSachChuyenXe {
	ArrayList<ChuyenXe> ds;

	/**
	 * @param ds
	 */
	public DanhSachChuyenXe() {
		ds = new ArrayList<ChuyenXe>();
	}

	public ArrayList<ChuyenXe> getAll() {
		return ds;
	}

	public boolean themChuyenXe(ChuyenXe xe) {
		if (ds.contains(xe))
			return true;
		else
			ds.add(xe);
		return false;
	}

	public ChuyenXe timChuyenXe(String maCX) {
		for (ChuyenXe xe : ds) {
			if (xe.getMaSoChuyen().equalsIgnoreCase(maCX))
				return xe;
		}
		return null;
	}

	public boolean xoa(String maCX) {
		ChuyenXe xe = timChuyenXe(maCX);
		if (xe == null)
			return false;
		else {
			ds.remove(xe);
			return true;
		}
	}

	public boolean suaChuyenXe(ChuyenXe xe) {
		int vtri = ds.indexOf(xe);
		if (vtri >= 0) {
			ds.set(vtri, xe);
			return true;
		} else
			return false;
	}

	public void sapXepTheoDoanhThu() {
		Collections.sort(ds, new Comparator<ChuyenXe>() {

			@Override
			public int compare(ChuyenXe xe1, ChuyenXe xe2) {
				// TODO Auto-generated method stub
				@SuppressWarnings("deprecation")
				Double dt1 = new Double(xe1.getDoanhThu());
				@SuppressWarnings("deprecation")
				Double dt2 = new Double(xe2.getDoanhThu());
				return dt1.compareTo(dt2);
			}
		});
	}

	public double tongDoanhThuXeNoiThanh() {
		double tongDT = 0;
		for (ChuyenXe xe : ds) {
			if (xe instanceof ChuyenXeNoiThanh)
				tongDT += xe.getDoanhThu();
		}
		return tongDT;
	}

	public double tongDoanhThuXeNgoaiThanh() {
		double tongDT = 0;
		for (ChuyenXe xe : ds) {
			if (xe instanceof ChuyenXeNgoaiThanh)
				tongDT += xe.getDoanhThu();
		}
		return tongDT;
	}
}
