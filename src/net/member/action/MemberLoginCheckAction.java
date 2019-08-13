package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberBean;
import net.member.function.Md5_SecretCode;
import net.member.function.Sha1_SecretCode;

///////////////////////유정 추가///////////////////////
public class MemberLoginCheckAction implements Action {
		
	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject jsondata = new JSONObject();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//String tx = request.getParameter("tx");
		
		pw = Sha1_SecretCode.sha1(pw);
		pw = Md5_SecretCode.md5(pw);
		
//		tx = Sha1_SecretCode.sha1(tx);
//		tx = Md5_SecretCode.md5(tx);

		MemberBean member = new MemberBean();
		member.setId(id);
		member.setPw(pw);
		//member.setTx(tx);
		
		MemberDAO member_dao = new MemberDAO();
		int result = member_dao.login_check(member);
		
		if(result == 0) {
			jsondata.put("result", 0);
			System.out.println("비밀번호가 일치하지 않습니다.");
		}/*else if(result == 2) {
			jsondata.put("result", 2);
			System.out.println("tx비밀번호가 일치하지 않습니다.");
		}else if(result == 3) {
			jsondata.put("result", 3);
			System.out.println("비밀번호와 tx비밀번호가 모두 일치하지 않습니다.");
		}*/else if(result == -1) {
			jsondata.put("result", -1);
			System.out.println("존재하지 않는 아이디입니다.");
		}else {
			// 로그인 성공
			jsondata.put("result", 1);
			
		}
		
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
    	
		return null;
	}

}
