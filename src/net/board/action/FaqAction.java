package net.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.board.dto.FaqVO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 유정 고객지원 - 공지사항 불러오기
public class FaqAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		System.out.println("FaqAction OK");
		ActionForward forward = new ActionForward();
		
		BoardDAO bd_dao = new BoardDAO();
		ArrayList<FaqVO> faq = bd_dao.getFaq(1);
		System.out.println("faq>>>"+faq);
		
		request.setAttribute("faq", faq);
		
//		int category = (Integer)request.getAttribute("category");
//		System.out.println(">>>"+category);
		
		forward.setRedirect(false);
		forward.setPath("./board/faq.jsp");
		return forward;
	}
}
