package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		String mb_idx_String = (String) session.getAttribute("idx");
		int mb_idx = -1;
		
		if (mb_idx_String != null) {
			mb_idx = Integer.parseInt(mb_idx_String);
		}
		
		MemberDAO memberDAO = new MemberDAO();
		int mi_idx = memberDAO.Member_Invest_check(mb_idx);
		
		JSONdata.put("mi_idx", mi_idx);
		
		
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(JSONdata);
    	
		return null;
	}

}
