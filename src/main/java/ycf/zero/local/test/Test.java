package ycf.zero.local.test;
			
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {

	public static void main(String[] args) {
		System.out.println(getPushUrl("38247.livepush.myqcloud.com","3b50b346a273a75bbb4769133adbb996", "deviceId", 1469762325L));
	}

	private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/*
	 * KEY+ stream_id + txTime
	 */
	private static String getPushUrl(String domain,String key, String streamId, long txTime) {
		String input = new StringBuilder().append(key).append(streamId).append(Long.toHexString(txTime).toUpperCase()).toString();

		String txSecret = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			txSecret  = byteArrayToHexString(
					messageDigest.digest(input.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return txSecret == null ? "" :
			new StringBuilder().
				append("rtmp://").
				append(domain).
				append("/live/").
				append(streamId).
				append("?txSecret=").
				append(txSecret).
				append("&").
				append("txTime=").
				append(Long.toHexString(txTime).toUpperCase()).
				toString();
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
			
			