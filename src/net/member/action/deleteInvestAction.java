package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class deleteInvestAction implements Action {
	@SuppressWarnings("unchecked")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		JSONObject jsondata = new JSONObject();
		HttpSession session = request.getSession();
		boolean result = false;
		
		int mb_idx = Integer.parseInt((String)session.getAttribute("idx"));
		int cp_idx = Integer.parseInt((String)session.getAttribute("idx"));
		
		MemberDAO mb_dao = new MemberDAO();
		result = mb_dao.deleteInvest(mb_idx, cp_idx);
		
		if(result) {
			jsondata.put("result", "1");// 투자 철회 성공하면 1
		}else {
			jsondata.put("result", "0");// 실패하면 0
		}
		
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
    	
		forward.setRedirect(false);
		forward.setPath("./member/mypage1_1_1.jsp");
		return forward;
	}

}
