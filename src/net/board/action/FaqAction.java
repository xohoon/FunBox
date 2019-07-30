package net.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.board.dto.FaqVO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 유정 고객지원 - FAQ
public class FaqAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		//FAQ 불러오기
		System.out.println("FaqAction OK");
		ActionForward forward = new ActionForward();

		BoardDAO bd_dao1 = new BoardDAO();
		ArrayList<FaqVO> faq1 = bd_dao1.getFaq(1);
		
		BoardDAO bd_dao2 = new BoardDAO();
		ArrayList<FaqVO> faq2 = bd_dao2.getFaq(2);
		
		BoardDAO bd_dao3 = new BoardDAO();
		ArrayList<FaqVO> faq3 = bd_dao3.getFaq(3);
		
		request.setAttribute("faq1", faq1);
		request.setAttribute("faq2", faq2);
		request.setAttribute("faq3", faq3);
		
		forward.setRedirect(false);
		forward.setPath("./board/faq.jsp");
		return forward;
	}
}
