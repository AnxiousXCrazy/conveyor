package net.uchoice.conveyor.modules.rest;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by admin on 2017/8/15.
 */
public final class MD5Utils {

    public static boolean checkMD5Str(String templeteId, String content, String md5Str) {
        return md5Str.equals(md5(templeteId+content));
    }

    public static String md5(String str) {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException ue) {
            ue.printStackTrace();
        }
        return null;
    }

}
