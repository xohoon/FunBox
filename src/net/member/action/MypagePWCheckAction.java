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
public class MypagePWCheckAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8"); //한글처리
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		JSONObject jsondata = new JSONObject();
		String pw = request.getParameter("pw");
		
		try {
			pw = Sha1_SecretCode.sha1(pw);
			pw = Md5_SecretCode.md5(pw);
			
		}catch(Exception e) {
			System.out.println("패스워드 암호화 오류 : " + e);
		}
		
        MemberDAO dao = new MemberDAO();
        
        String select_pw = dao.get_Find_pw(id);
        
        if (select_pw.equals(pw)) {	// 비밀번호가 일치할 때
        	System.out.println("비밀번호 일치함");
			jsondata.put("result", "confirm_pw_success");
			
		}else {
			System.out.println("비밀번호 불일치");
			jsondata.put("result", "confirm_pw_fail");
			
		}
        
        response.setContentType("application/x-json; charset=UTF-8");
        response.getWriter().print(jsondata);
        
        return null;
	}
}
