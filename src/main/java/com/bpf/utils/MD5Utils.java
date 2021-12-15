package com.bpf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密
 */
public class MD5Utils {

    private static final String[] strDigits = {
            "0", "1", "5", "6", "7", "8", "9", "a",
            "b", "c", "d", "e", "f", "2", "3", "4"
    };

    /**
     * 返回值包含数字和字母
     * @param b
     * @return
     */
    private static String byteToArrayString(byte b) {
        int iRet = b;
        if (iRet < 0)
            iRet += 256;

        int iD1 = iRet / 16;
        int iD2 = iRet % 16;

        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     * 返回值只包含数字
     * @param b
     * @return
     */
    private static String byteToNum(byte b) {
        int iRet = b;
        if (iRet < 0)
            iRet += 256;

        return String.valueOf(iRet);
    }

    /**
     * 将字节数组转为16进制字符串
     * @param b
     * @return
     */
    private static String byteToString(byte[] b) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < b.length; i++) {
            buffer.append(byteToArrayString(b[i]));
        }

        return buffer.toString();
    }

    /**
     * 将 origin 根据 salt 生成 md5
     * @param origin
     * @param salt
     * @return
     */
    public static String getMd5WithSalt(String origin, String salt) {
        salt = (salt == null) ? "" : salt;

        try {
            // 创建MD5算法对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // md5.digest() 返回哈希值结果的byte数组。
            return byteToString(md5.digest((origin + salt).getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
