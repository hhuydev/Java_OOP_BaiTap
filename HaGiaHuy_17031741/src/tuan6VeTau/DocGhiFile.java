/**
 * 
 */
package tuan6VeTau;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Ha Gia Huy
 *
 */
public class DocGhiFile {
	static final String WORKING_DIR = System.getProperty("user.dir") + "/src/tuan6VeTau/data";
	static final String FILENAME = WORKING_DIR + "/DanhMucKhachHang.txt";

	public static Queue<KhachHang> docFile() throws Exception {
		Queue<KhachHang> ds = new ArrayDeque<KhachHang>();
		BufferedReader br = null;
		File f = new File(WORKING_DIR);
		if (!f.exists()) {
			f.mkdirs();
		}
		if (new File(FILENAME).exists()) {
			br = new BufferedReader(new FileReader(FILENAME));
			while (br.ready()) {
				String line = br.readLine();
				String[] s = line.split(";");
				double giaVe = Double.parseDouble(s[3]);
				KhachHang kh = new KhachHang(s[0], s[1], s[2], giaVe);
				ds.add(kh);
			}
			br.close();
		}
		return ds;
	}

	public static void luuFile(Queue<KhachHang> ds) throws Exception {
		BufferedWriter bw;
		// tạo thư mục lưu
		File f = new File(WORKING_DIR);
		if (!f.exists()) {
			f.mkdirs();
		}

		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
			bw.write("");
			for (KhachHang kh : ds) {
				bw.write(kh.getCmnd() + ";" + kh.getTenKH() + ";" + kh.getGaDen() + ";" + kh.getGiaTien() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
