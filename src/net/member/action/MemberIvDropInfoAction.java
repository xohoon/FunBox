package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class MemberIvDropInfoAction implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject JSONdata = new JSONObject();
		String sessionID = request.getParameter("sessionID");
		MemberDAO memberDAO = new MemberDAO();
		String result = memberDAO.Member_Invest_check(sessionID);

		
		return null;
	}

}
