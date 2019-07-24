package net.member.function;


import java.io.IOException;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;

public class NexmoSms {

	public void sms(String phone, String key) throws IOException, NexmoClientException {

		String sms_str = "Verification Code.\n" + key;
		/*String sms_str = "[AndUs] 인증번호 [" + key + "]를 입력해주세요.";
		byte[] byte_str = sms_str.getBytes("UTF-8");
		
		CharBuffer cbuffer = CharBuffer.wrap((new String(byte_str, "EUC-KR")).toCharArray());
		Charset utf8charset = Charset.forName("UTF-8");
		ByteBuffer bbuffer = utf8charset.encode(cbuffer);
		
		String sms_str2 = new String(bbuffer.array());
		System.out.println(sms_str2);
*/

		
		AuthMethod auth = new TokenAuthMethod("1b652ce7", "iTrrxhNRiHMbYBo7");
		NexmoClient client = new NexmoClient(auth);
		SmsSubmissionResult[] responses = client.getSmsClient()
				.submitMessage(new TextMessage("Nexmo", phone, sms_str));
		for (SmsSubmissionResult response : responses) {
			System.out.println(response);
		}

	}
	
	public void sms2(String phone, String key) throws IOException, NexmoClientException {

		String sms_str = key;


		
		AuthMethod auth = new TokenAuthMethod("1b652ce7", "iTrrxhNRiHMbYBo7");
		NexmoClient client = new NexmoClient(auth);
		SmsSubmissionResult[] responses = client.getSmsClient()
				.submitMessage(new TextMessage("Nexmo", phone, sms_str));
		for (SmsSubmissionResult response : responses) {
			System.out.println(response);
		}

	}
	
	public String phoneNumber_format(String phoneNum) {
		
		if (phoneNum.length() >= 8 && phoneNum.length() < 11) {
			if (phoneNum.substring(0, 2).equals("10") && phoneNum.length() > 8) {
				phoneNum = "0" + phoneNum;
			}
			if (phoneNum.length() <= 8) {
				phoneNum = "010" + phoneNum;
			}
		} 
		
		if (phoneNum.length() >= 8 && phoneNum.length() < 12) {
			if (phoneNum.substring(0, 3).equals("010")) {
				int intnexphone = Integer.parseInt(phoneNum);
				phoneNum = String.valueOf(intnexphone);
			}
			if (phoneNum.length() <= 8) {
				phoneNum = "10" + phoneNum;
			}
		}
		
		return phoneNum;
	}
	
	public int sms_code_making() {
		double prvkey = Math.floor(Math.random() * 1000000) + 100000;
		if (prvkey > 1000000) {
			prvkey = prvkey - 100000;
		}
		return (int)prvkey;
	}
}
