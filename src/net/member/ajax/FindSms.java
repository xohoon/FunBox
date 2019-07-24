package net.member.ajax;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.nexmo.client.NexmoClientException;

import net.member.function.NexmoSms;

///////////////////////유정 추가///////////////////////
public class FindSms extends HttpServlet implements Servlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6744625790742043649L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //utf-8 인코딩
		@SuppressWarnings("unused")
		HttpSession session =request.getSession();
		System.out.println("문자 전송 시작 ");
		NexmoSms sms = new NexmoSms();
		JSONObject jsondata = new JSONObject();
						
		String ph = request.getParameter("phone");
        System.out.println(ph);
        int prvkey = sms.sms_code_making();
        String key = Integer.toString(prvkey);
        
        String phoneNum = "82"+sms.phoneNumber_format(ph);
        System.out.println("phoneNum : "+phoneNum);
		
		try {
			
			sms.sms(phoneNum, key);
			
		} catch (NexmoClientException e) {
			// TODO Auto-generated catch block
			System.out.println("문자 전송 오류 : "+e);
			jsondata.put("result", "sms_fail"); 
			response.setContentType("application/x-json; charset=UTF-8");
	    	 response.getWriter().print(jsondata);
	    	 
		}
		
		jsondata.put("key", key);
		jsondata.put("result", "good");
    	 response.setContentType("application/x-json; charset=UTF-8");
    	 response.getWriter().print(jsondata);
		
		

			
			
		}
    	 
	}
