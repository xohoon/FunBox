package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class MemberIvDropInfoAction implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject JSONdata = new JSONObject();
		HttpSession session = request.getSession();
		
		int mb_idx = Integer.parseInt((String)session.getAttribute("idx"));
		request.setAttribute("mb_idx", mb_idx);
		
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		request.setAttribute("cp_idx", cp_idx);

		ActionForward forward = new ActionForward();		
		
		forward.setRedirect(false);
		forward.setPath("./member/mypage1_1_1.jsp");
		return forward;
	}

}