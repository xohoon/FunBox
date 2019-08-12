package net.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.InvestDeleteVO;

public class MemberIvDropInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		int mb_idx = Integer.parseInt((String)session.getAttribute("idx"));
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		int mi_idx = Integer.parseInt(request.getParameter("mi_idx"));
		
		MemberDAO memberDAO = new MemberDAO();
		
		List<InvestDeleteVO> DeleteInfo = new ArrayList<InvestDeleteVO>();
		
		DeleteInfo = memberDAO.InvestDeleteInfo(cp_idx, mb_idx, mi_idx);
		request.setAttribute("DeleteInfo", DeleteInfo);

		ActionForward forward = new ActionForward();		
		
		forward.setRedirect(false);
		forward.setPath("./member/mypage1_1_1.jsp");
		return forward;
	}

}