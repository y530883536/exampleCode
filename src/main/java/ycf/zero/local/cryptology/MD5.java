package ycf.zero.local.cryptology;

import java.security.MessageDigest;

/**
 * @author yechangfeng
 * @date 2018/12/13
 */
public class MD5 {

    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void main(String[] args) throws Exception{
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] digest = messageDigest.digest("5d41402abc4b2a76b9719d911017c5921471850187".getBytes("UTF-8"));
        String str = byteArrayToHexString(digest);
        System.out.println(str);
    }

    private static String byteArrayToHexString(byte[] data) {
        char[] out = new char[data.length << 1];

        for (int i = 0, j = 0; i < data.length; i++) {
            out[j++] = DIGITS_LOWER[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS_LOWER[0x0F & data[i]];
        }
        return new String(out);
    }
}
