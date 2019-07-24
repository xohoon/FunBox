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
public class MypagePWPINCheckAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8"); //한글처리
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		JSONObject jsondata = new JSONObject();
		String pw = request.getParameter("pw");
		String pin = request.getParameter("pin");
		
		try {
			pw = Sha1_SecretCode.sha1(pw);
			pw = Md5_SecretCode.md5(pw);
			
			pin = Sha1_SecretCode.sha1(pin);
			pin = Md5_SecretCode.md5(pin);
			
		}catch(Exception e) {
			System.out.println("패스워드+핀코드 암호화 오류 : " + e);
		}
		System.out.println("pin: "+pin);
        MemberDAO dao1 = new MemberDAO();
        String select_pw = dao1.get_Find_pw(id);
        
        MemberDAO dao2 = new MemberDAO();
        String select_pin = dao2.get_Find_pin(id);
        System.out.println("select_pin: "+select_pin);
        
        if(!select_pw.equals(pw)) {	// 비밀번호가 일치하지 않을 때
        	System.out.println("비밀번호 불일치");
			jsondata.put("result", "confirm_pw_fail");
			
		}else if(!select_pin.equals(pin)){ // 핀코드가 일치하지 않을 때
			System.out.println("핀코드 불일치");
			jsondata.put("result", "confirm_pin_fail");
			
		}else if(select_pw.equals(pw)){
			System.out.println("비밀번호 일치함");
			jsondata.put("result", "confirm_pw_success");
			
		}else if(select_pin.equals(pin)){
			System.out.println("핀코드 일치함");
			jsondata.put("result", "confirm_pin_success");
			
		}
        
        response.setContentType("application/x-json; charset=UTF-8");
        response.getWriter().print(jsondata);
        
        return null;
	}
}
