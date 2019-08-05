package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;

///////////////////////박신규짱 추가///////////////////////
public class MypageExchangePointToTokenAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String mb_id = (String)session.getAttribute("id");
		String mb_idx = (String)session.getAttribute("idx");
		
		if (mb_id == null || mb_idx == null) {
			//로그인 안된 사용자 접근 처리
		}
		
		
		forward.setRedirect(false);
		forward.setPath("/Mypage2_1.mb");
		return forward;
	}
}
