package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.function.Md5_SecretCode;
import net.member.function.Sha1_SecretCode;

///////////////////////유정 추가///////////////////////
public class MypagePINCheckAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8"); //한글처리
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		JSONObject jsondata = new JSONObject();
		String pin = request.getParameter("pin");
		System.out.println("Action>>>>>>"+id+pin);
		
		try {
			pin = Sha1_SecretCode.sha1(pin);
			pin = Md5_SecretCode.md5(pin);
			
		}catch(Exception e) {
			System.out.println("PIN 암호화 오류 : " + e);
		}
		
        MemberDAO dao = new MemberDAO();
        
        String select_pin = dao.get_Find_pin(id);
        
        if (select_pin.equals(pin)) {	// 비밀번호가 일치할 때
        	System.out.println("핀코드 일치함");
			jsondata.put("result", "confirm_pin_success");
			
		}else {
			System.out.println("핀코드 불일치");
			jsondata.put("result", "confirm_pin_fail");
			
		}
        
        response.setContentType("application/x-json; charset=UTF-8");
        response.getWriter().print(jsondata);
        
        return null;
	}
}
