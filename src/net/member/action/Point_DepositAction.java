package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class Point_DepositAction implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject JSONdata = new JSONObject();
		MemberDAO memberDAO = new MemberDAO();
		
		String session_idx = request.getParameter("session_idx");
		String point_sum = request.getParameter("point_sum");
		
		int result = 0;
		
		if(point_sum != null && session_idx != null) {
			result = memberDAO.Point_Deposit(point_sum, session_idx);
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