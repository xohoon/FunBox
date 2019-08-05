package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.money.dto.TokenDepositVO;

///////////////////////박신규짱 추가///////////////////////
public class MypageDepositAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String mb_id = (String)session.getAttribute("id");
		String mb_idx = (String)session.getAttribute("idx");
		
		if (mb_id == null || mb_idx == null) {
			//로그인 안된 사용자 접근 처리
		}
		
		String td_from_address = request.getParameter("td_from_address");
		String td_to_address = request.getParameter("td_to_address");
		String td_tx_hash = request.getParameter("td_tx_hash");
		String td_amount = request.getParameter("td_amount");
		
		//System.out.println("td_from_address"+td_from_address+"td_to_address:"+td_to_address+"td_tx_hash:"+td_tx_hash+"td_amount:"+td_amount);
		
		TokenDepositVO tokenDepositVO = new TokenDepositVO();		
		tokenDepositVO.setMb_idx(Integer.parseInt(mb_idx));
		tokenDepositVO.setTd_from_address(td_from_address);
		tokenDepositVO.setTd_to_address(td_to_address);
		tokenDepositVO.setTd_tx_hash(td_tx_hash);
		tokenDepositVO.setTd_amount(td_amount);
		
		
		MemberDAO memberDAO = new MemberDAO();
		
		forward.setRedirect(false);
		forward.setPath("/Mypage2_1.mb");
		return forward;
	}
}
