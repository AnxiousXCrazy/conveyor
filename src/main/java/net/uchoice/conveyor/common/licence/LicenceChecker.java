package net.uchoice.conveyor.common.licence;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class LicenceChecker {

	private static LicenceChecker checker = new LicenceChecker();

	private Licence licence;
	
	private String mac;

	private LicenceChecker() {
		super();
	}

	public static LicenceChecker get() {
		return checker;
	}

	public void checkLicence() throws AuthorityException {
		try {
			if (null == licence) {
				licence = LicenceDescriptor.readLicence();
			}
			if(null == mac){
				mac = getLocalMac();
			}
		} catch (Exception e) {
			throw new AuthorityException("Licence 读取错误");
		}
		if (null == licence.getMac() || null == licence.getValideDate()
				|| null == licence.getExpiredDate()) {
			throw new AuthorityException("Licence无效");
		}
		if (!mac.equals(licence.getMac())) {
			throw new AuthorityException("无效的Licence");
		}
		if (licence.getValideDate().getTime() > System.currentTimeMillis()) {
			throw new AuthorityException("Licence未激活");
		}
		if (licence.getExpiredDate().getTime() < System.currentTimeMillis()) {
			throw new AuthorityException("Licence已过期");
		}
	}

	private String getLocalMac() throws SocketException, UnknownHostException {
		String macAddress = "";
		InetAddress inetAddress = InetAddress.getLocalHost();
		// 貌似此方法需要JDK1.6。
		byte[] mac = NetworkInterface.getByInetAddress(inetAddress)
				.getHardwareAddress();
		// 下面代码是把mac地址拼装成String
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// mac[i] & 0xFF 是为了把byte转化为正整数
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		// 把字符串所有小写字母改为大写成为正规的mac地址并返回
		macAddress = sb.toString().trim().toUpperCase();
		return macAddress;
	}
	
	public static void main(String[] args) throws AuthorityException {
		LicenceChecker.get().checkLicence();
		LicenceChecker.get().checkLicence();
	}
}
