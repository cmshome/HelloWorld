package com.lxk.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author LiXuekai on 2019/12/23
 */
public class EncryptUtil {
    public static String charset = "utf-8";
    public static int keysizeAES = 128;
    public static final String AES = "AES";

    public EncryptUtil() {
    }

    public static String encode(String res, String key) {
        return keyGeneratorES(res, "AES", key, keysizeAES, true);
    }

    public static String decode(String res, String key) {
        return keyGeneratorES(res, "AES", key, keysizeAES, false);
    }

    private static String keyGeneratorES(String res, String algorithm, String key, int keysize, boolean isEncode) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            if (keysize == 0) {
                if (charset == null) {
                    key.getBytes();
                } else {
                    key.getBytes(charset);
                }

                random.setSeed(key.getBytes());
                kg.init(random);
            } else if (key == null) {
                kg.init(keysize);
            } else {
                if (charset == null) {
                    key.getBytes();
                } else {
                    key.getBytes(charset);
                }

                random.setSeed(key.getBytes());
                kg.init(keysize, random);
            }

            SecretKey sk = kg.generateKey();
            SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            if (isEncode) {
                cipher.init(1, sks);
                byte[] resBytes = charset == null ? res.getBytes() : res.getBytes(charset);
                return parseByte2HexStr(cipher.doFinal(resBytes));
            } else {
                cipher.init(2, sks);
                return new String(cipher.doFinal(parseHexStr2Byte(res)));
            }
        } catch (Exception var11) {
            var11.printStackTrace();
            return null;
        }
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hexStr.length() / 2];

            for(int i = 0; i < hexStr.length() / 2; ++i) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte)(high * 16 + low);
            }

            return result;
        }
    }

    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }
}
