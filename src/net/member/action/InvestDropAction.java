package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;

public class InvestDropAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		ActionForward forward = new ActionForward();		
		
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		request.setAttribute("cp_idx", cp_idx);
		
		forward.setRedirect(false);
		forward.setPath("./member/mypage1_1.jsp");
		return forward;
	}

}
