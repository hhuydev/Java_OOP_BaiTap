/**
 * 
 */
package tuan6VeTau;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Ha Gia Huy
 *
 */
public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmnd;
	private String tenKH;
	private String gaDen;
	private double giaTien;

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	/**
	 * @param cmnd
	 * @param tenKH
	 * @param gaDen
	 * @param giaTien
	 */
	public KhachHang(String cmnd, String tenKH, String gaDen, double giaTien) {
		super();
		this.cmnd = cmnd;
		this.tenKH = tenKH;
		this.gaDen = gaDen;
		this.giaTien = giaTien;
	}

	/**
	 * 
	 */
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmnd == null) ? 0 : cmnd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (cmnd == null) {
			if (other.cmnd != null)
				return false;
		} else if (!cmnd.equals(other.cmnd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-15s %15s %15s %15.2f", cmnd, tenKH, gaDen, giaTien);
	}

}
