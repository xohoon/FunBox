package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

//태훈 - 기업 투자 현황 페에지 제어
public class MemberInvestcheck implements Action {

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject JSONdata = new JSONObject();
		String sessionID = request.getParameter("sessionID");
		MemberDAO memberDAO = new MemberDAO();
		String result = memberDAO.Member_Invest_check(sessionID);
		
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
