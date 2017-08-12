package net.uchoice.conveyor.common.licence;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.shiro.codec.Base64;

public class LicenceGenerator {

	private LicenceGenerator() {
		super();
	}

	public static String encodeLicence(Date valideDate, Date expiredDate,
			String mac) throws SocketException, UnknownHostException {
		StringBuilder key = new StringBuilder();
		key.append(mac);
		key.append(valideDate.getTime());
		key.append(expiredDate.getTime());
		return Base64.encodeToString(key.toString().getBytes());
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SocketException,
			UnknownHostException {
		System.out.println(encodeLicence(new Date(116, 1, 1), new Date(116, 11,
				31), "5C-26-0A-84-6D-17"));
	}
}
