package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class Member_Invest_check implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject JSONdata = new JSONObject();
		System.out.println("memberController>>>>>>>>>>>>>>>>");
		String sessionID = request.getParameter("sessionID");
		System.out.println("member action >>>"+sessionID);
		MemberDAO memberDAO = new MemberDAO();
		String result = memberDAO.Member_Invest_check(sessionID);
		System.out.println("member action >>>"+sessionID+">>"+result);
		
		if(result.equals("0")) {
			JSONdata.put("result", "0");
		}else {
			JSONdata.put("result", "1");
		}
		
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(JSONdata);
    	
		return null;
	}

}
