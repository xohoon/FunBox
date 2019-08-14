package net.member.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.nexmo.client.NexmoClientException;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.function.NexmoSms;

///////////////////////유정 추가///////////////////////
public class MemberPhoneCheckAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception,ServletException, IOException {
	//	System.out.println("들어감");
		NexmoSms sms = new NexmoSms();
		
		JSONObject jsondata = new JSONObject();
		
        String ph = request.getParameter("ph");
    //    System.out.println("MemberPhoneCheckAction : " + ph);
        int prvkey = sms.sms_code_making();
        String key = Integer.toString(prvkey);
        
        String phoneNum = "82"+sms.phoneNumber_format(ph);
     //   System.out.println("phoneNum : "+phoneNum);
        
        	
        	
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
        
        
        return null;
	
        }
    }
        

