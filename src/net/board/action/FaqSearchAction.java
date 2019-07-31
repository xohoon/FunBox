package net.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.board.dto.FaqVO;
import net.common.action.Action;
import net.common.action.ActionForward;

//유정 고객지원 - FAQ
public class FaqSearchAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
	
		System.out.println("FaqSearchAction OK");
		ActionForward forward = new ActionForward();
		
		//FAQ 키워드 검색
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		int category = Integer.parseInt(request.getParameter("category"));
		System.out.println(category);
		
		BoardDAO dao = new BoardDAO();
		ArrayList<FaqVO> faq_list = dao.searchFaq(keyword, category);
		System.out.println(faq_list);
		
		request.setAttribute("faq_list", faq_list);
		
		forward.setRedirect(false);
		forward.setPath("./board/faq.jsp");
		return forward;
	}
}
