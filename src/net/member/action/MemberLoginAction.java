package net.member.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberIplog;
import net.member.util.EgovHttpSessionBindingListener;

///////////////////////유정 추가///////////////////////
public class MemberLoginAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		// 태훈
		MemberDAO memberDAO = new MemberDAO();

		String id = request.getParameter("id");
		String saveId = request.getParameter("saveId");
		
		request.getSession().setAttribute("TAATLoginId", id);

		EgovHttpSessionBindingListener httpSessionBindingListener = new EgovHttpSessionBindingListener();
		
		request.getSession().setAttribute(id, httpSessionBindingListener); 
		
		// 태훈
		String mb_idx = memberDAO.Session_idx(id);

		
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
