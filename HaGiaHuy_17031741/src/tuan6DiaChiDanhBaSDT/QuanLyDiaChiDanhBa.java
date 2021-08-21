/**
 * 
 */
package tuan6DiaChiDanhBaSDT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Ha Gia Huy
 *
 */
public class QuanLyDiaChiDanhBa {
	public List<String> lstSdt = new ArrayList<String>();
	Map<ThongTinDiaChi, List<String>> dsDiaChi;

	/**
	 * 
	 */
	public QuanLyDiaChiDanhBa() {
		dsDiaChi = new HashMap<ThongTinDiaChi, List<String>>();
	}

	public Map<ThongTinDiaChi, List<String>> getAll() {
		return dsDiaChi;
	}

	/**
	 * Khi thêm nếu trùng thì sẽ thêm sdt mới vào list sdt tương ứng theo đia chỉ
	 * danh bạ. Ngược lại sẽ thêm mới
	 */
	public boolean themDiaChi(ThongTinDiaChi x, String sdt) throws Exception {
		// TODO Auto-generated method stub
		if (dsDiaChi.containsKey(x) && !lstSdt.contains(sdt)) {
			List<String> sdtTonTai = new ArrayList<String>();
			for (Entry<ThongTinDiaChi, List<String>> dc : dsDiaChi.entrySet()) {
				if (dc.getKey().getDiaChi().trim().equalsIgnoreCase(x.getDiaChi().trim())) {
					sdtTonTai.addAll(dc.getValue());
					sdtTonTai.add(sdt);
				}
			}
			lstSdt.add(sdt);
			dsDiaChi.replace(x, sdtTonTai);
			return true;
		} else if (!dsDiaChi.containsKey(x)) {
			List<String> temp = new ArrayList<String>();
			temp.add(sdt);
			lstSdt.add(sdt);
			dsDiaChi.put(x, temp);
			return true;
		}
		return false;
	}

	public boolean xoaDiaChi(ThongTinDiaChi diaChi) {
		if (dsDiaChi.containsKey(diaChi)) {
			dsDiaChi.remove(diaChi);
			return true;
		} else
			return false;
	}

	public boolean xoaAllDiaChi() {
		if (dsDiaChi.size() > 0) {
			dsDiaChi.clear();
			return true;
		} else
			return false;
	}

	public ThongTinDiaChi timDiaChi(String diaChi) {
		for (ThongTinDiaChi key : dsDiaChi.keySet()) {
			if (key.getDiaChi().equalsIgnoreCase(diaChi)) {
				return key;
			}
		}
		return null;
	}

	public List<String> timDanhBaTheoDiaChi(String diaChi) {
		List<String> dsSdt = new ArrayList<String>();
		for (ThongTinDiaChi key : dsDiaChi.keySet()) {
			if (key.getDiaChi().equalsIgnoreCase(diaChi)) {
				dsSdt = dsDiaChi.get(key);
				return dsSdt;
			}
		}
		return null;
	}

}
