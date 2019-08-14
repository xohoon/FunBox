package net.member.action;

import java.util.List;

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
		List<String> mi_idx_funding_status = memberDAO.Member_Invest_check(mb_idx);
		
		if (mi_idx_funding_status != null) {
			JSONdata.put("mi_idx", mi_idx_funding_status.get(0));
			JSONdata.put("cp_funding_status", mi_idx_funding_status.get(1));
			
			System.out.println("mi_idx"+mi_idx_funding_status.get(0));
			System.out.println("mi_idx_funding_status"+mi_idx_funding_status.get(1));
			
		}else {
			JSONdata.put("mi_idx", "-1");
			JSONdata.put("cp_funding_status", "-1");
		}
		
		
		
		
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(JSONdata);
    	
		return null;
	}

}
