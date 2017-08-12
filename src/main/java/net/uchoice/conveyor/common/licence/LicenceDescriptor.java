package net.uchoice.conveyor.common.licence;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.shiro.codec.Base64;

import net.uchoice.conveyor.common.utils.FileUtils;

public class LicenceDescriptor {

	private LicenceDescriptor() {
		super();
	}

	public static Licence readLicence() throws IOException {
		File file = new File(LicenceDescriptor.class.getClassLoader()
				.getResource("key.lic").getPath());
		if (!file.exists()) {
			throw new IllegalArgumentException("licence不存在");
		}
		String key = FileUtils.readFileToString(file);
		return decodeLicence(key.trim());
	}

	public static Licence decodeLicence(String key) {
		try {
			String t = new String(Base64.decode(key));
			Calendar v = Calendar.getInstance();
			v.setTimeInMillis(Long.valueOf(t.substring(17, 30)));
			Calendar e = Calendar.getInstance();
			e.setTimeInMillis(Long.valueOf(t.substring(30)));
			return new Licence(v.getTime(), e.getTime(), t.substring(0, 17));
		} catch (Exception e) {
			throw new IllegalArgumentException("无效的licence", e);
		}
	}
}
