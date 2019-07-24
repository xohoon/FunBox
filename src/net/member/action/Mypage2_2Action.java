package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;


// 유정 추가 - 자산관리 - 포인트 관리
public class Mypage2_2Action implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		ActionForward forward = new ActionForward();

		System.out.println("Mypage2_2Action OK!");
		
		forward.setRedirect(false);
//		forward.setPath("/Mypage2_2.mb");
		forward.setPath("./member/mypage2_2.jsp");
		return forward;
	}
}
