package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.money.dto.TokenTransaction;

///////////////////////박신규짱 추가///////////////////////
public class MypageSendTokenAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String mb_id = (String)session.getAttribute("id");
		String mb_idx = (String)session.getAttribute("idx");
		
		if (mb_id == null || mb_idx == null) {
			//로그인 안된 사용자 접근 처리
		}
				
		//String tk_to_address = request.getParameter("tk_to_address");
		String tk_amount = request.getParameter("tk_amount");
		
		//System.out.println("tk_to_address"+tk_to_address+"tk_amount:"+tk_amount);
		
		TokenTransaction tokenTransaction = new TokenTransaction();		
		tokenTransaction.setTk_amount(tk_amount);
		
		
	//	MemberDAO memberDAO = new MemberDAO();
		//memberDAO.withdrawToken(tokenTransaction);
		
		forward.setRedirect(false);
		forward.setPath("/Mypage2_1.mb");
		return forward;
	}
}
