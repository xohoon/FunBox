package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class Token_WithdrawAction implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject JSONdata = new JSONObject();
		MemberDAO memberDAO = new MemberDAO();
		
		String session_idx = request.getParameter("session_idx");
		String token_sum = request.getParameter("token_sum");
		String token_wallet = request.getParameter("token_wallet");
		String bar = request.getParameter("bar");
		
		int result = 0;
		
		if(token_sum != null && token_wallet != null) {
			result = memberDAO.Token_Withdraw(token_sum, token_wallet, session_idx, bar);
		}
		
		if(result != 0) {
			JSONdata.put("result", "1");
		}else {
			JSONdata.put("result", "0");
		}
		
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(JSONdata);
    	
		return null;
	}

}
