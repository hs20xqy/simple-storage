package com.storage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by hs on 2017/6/28.
 */
public class Encrypt {

    private Encrypt() {}

    public static String getSHA512(String str) throws NoSuchAlgorithmException {
        return getHashCode(str, "SHA-512");
    }

    public static String getSHA256(String str) throws NoSuchAlgorithmException {
        return getHashCode(str, "SHA-256");
    }

    private static String getHashCode(String str, String hashType) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(hashType);
        md.update(str.getBytes());
        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer hashCodeBuffer = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return hashCodeBuffer.toString();
    }
}