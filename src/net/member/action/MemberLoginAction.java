package net.member.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberIplog;

///////////////////////유정 추가///////////////////////
public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		// 태훈
		MemberDAO memberDAO = new MemberDAO();

		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String tx = request.getParameter("tx");
		String saveId = request.getParameter("saveId");

		// 태훈
		String mb_idx = memberDAO.Session_idx(id);

		/*
		 * System.out.println(id+"님이 로그인 요청 하셨습니다.");
		 * 
		 * pw = Sha1_SecretCode.sha1(pw); pw = Md5_SecretCode.md5(pw);
		 * 
		 * MemberBean member = new MemberBean(); member.setId(id); member.setPw(pw);
		 * 
		 * MemberDAO member_dao = new MemberDAO(); int result =
		 * member_dao.login_check(member);
		 * 
		 * if(result==0) {//비밀번호 틀리다는 결과값 나오면 alert 띄우고 다시 로그인 창
		 * System.out.println("비밀번호 틀림");
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
		 * response.getWriter(); out.println("<script>");
		 * out.println("alert('비밀번호가 일치하지 않습니다.');");
		 * out.println("location.href='./LoginPage.mb';"); out.println("</script>");
		 * out.close();
		 * 
		 * return null; }else if(result==-1) {//아이디가 존재하지 않으면 alert 띄운후 다시 로그인 창
		 * System.out.println("아이디 존재 하지 않음");
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter out =
		 * response.getWriter(); out.println("<script>");
		 * out.println("alert('존재하지 않는 아이디 입니다.');");
		 * out.println("location.href='./LoginPage.mb';"); out.println("</script>");
		 * out.close(); return null; }
		 */

		/*
		 * String ip = request.getHeader("X-FORWARDED-FOR");
		 * 
		 * if (ip == null || ip.length() == 0) { ip =
		 * request.getHeader("Proxy-Client-IP"); }
		 * 
		 * if (ip == null || ip.length() == 0) { ip =
		 * request.getHeader("WL-Proxy-Client-IP"); // 웹로직 }
		 * 
		 * if (ip == null || ip.length() == 0) { ip = request.getRemoteAddr() ; } String
		 * content = "로그인"; MemberDAO dao= new MemberDAO();
		 */

		// 아이디 저장 여부를 보고 쿠키로 아이디값 저장
		if (saveId != null) {
			Cookie c = new Cookie("saveId", id);
			// 쿠키값 저장 시간을 지정함, 숫자당 1초로 계산
			c.setMaxAge(60 * 60 * 24 * 7); // 7일간 저장
			response.addCookie(c);
		} else {
			Cookie c = new Cookie("saveId", id);
			c.setMaxAge(0);
			response.addCookie(c);
		}
		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		
		MemberIplog memberIplog = new MemberIplog();
		memberIplog.setId(id);
		memberIplog.setIp(ip);
		memberIplog.setContent("회원 로그인");
		
		memberDAO = new MemberDAO();
		memberDAO.insertMemberLoginLog(memberIplog);

		System.out.println("로그인 성공");
		System.out.println("ID >> " + id + "IDX>>" + mb_idx);
		// 로그인 성공시 페이지 이동
		session.setAttribute("id", id); // 세션에 id등록
		session.setAttribute("idx", mb_idx);
		forward.setRedirect(true);
		forward.setPath("./Index.mb");
		// return null;
		return forward;
	}
}
