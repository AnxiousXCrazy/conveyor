package net.uchoice.conveyor.common.licence;

import java.io.Serializable;
import java.util.Date;

public class Licence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mac;

	private Date valideDate;

	private Date expiredDate;

	public Licence(Date valideDate, Date expiredDate, String mac) {
		this.expiredDate = expiredDate;
		this.valideDate = valideDate;
		this.mac = mac;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public Date getValideDate() {
		return valideDate;
	}

	public void setValideDate(Date valideDate) {
		this.valideDate = valideDate;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}
}
