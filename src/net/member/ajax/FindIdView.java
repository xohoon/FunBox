package net.member.ajax;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import net.member.dao.MemberDAO;
import net.member.function.NexmoSms;

///////////////////////유정 추가///////////////////////
@SuppressWarnings("serial")
public class FindIdView extends HttpServlet implements Servlet{
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //utf-8 인코딩
		@SuppressWarnings("unused")
		HttpSession session =request.getSession();
		System.out.println("회원 아이디 찾기");
		JSONObject jsondata = new JSONObject();
		
		
		@SuppressWarnings("unused")
		NexmoSms sms = new NexmoSms();
		String name = request.getParameter("name");
		
		  
			MemberDAO dao = new MemberDAO();
			
			String mb_id = dao.get_MemberId(name,request.getParameter("phone"));
			
			
			
		if(mb_id==null) {
			
			
			jsondata.put("result", "find_id_fail");
			response.setContentType("application/x-json; charset=UTF-8");
	    	 response.getWriter().print(jsondata);
		}else {
		
			
		jsondata.put("newid", mb_id);
		jsondata.put("result", "good");
    	 response.setContentType("application/x-json; charset=UTF-8");
    	 response.getWriter().print(jsondata);
		}
		

			
			
		}
    	 
	}