package net.member.function;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1_SecretCode {

	public static String sha1(String msg) throws NoSuchAlgorithmException {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1"); // 이 부분을 SHA-256, MD5로만 바꿔주면 된다.
			md.update(msg.getBytes()); // "세이프123"을 SHA-1으로 변환할 예정!

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			String retVal = sb.toString();
			//System.out.println(retVal);
			return retVal;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;

	}

}
