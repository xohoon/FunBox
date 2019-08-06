package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberTransactionVO;

/////// 김윤식 //////// 추가
public class MypageTransAction_s implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		System.out.println("MypageTransAction OK!");
		
		String mb_id = (String)session.getAttribute("id");
		String mb_idx = (String)session.getAttribute("idx");
		
		ArrayList<MemberTransactionVO> transaction = new ArrayList<MemberTransactionVO>();
				
		System.out.println("id"+mb_id);
		System.out.println("idx"+mb_idx);
		
		if (mb_id == null || mb_idx == null) {
			//로그인 안된 사용자 접근 처리
			System.out.println("로그인 안됨");
		}
		
		MemberDAO member_dao = new MemberDAO();
		transaction = member_dao.getTranscationList(mb_idx);
		System.out.println("transaction : " + transaction.toString());
		
		request.setAttribute("transaction", transaction);
		
		forward.setRedirect(false);
		forward.setPath("./member/mypage2_1.jsp");
		
		return forward;
	}

}
