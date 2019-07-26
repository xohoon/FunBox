package net.board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.board.dto.Board_Search_ListVO;
import net.common.action.Action;
import net.common.action.ActionForward;
//유정 추가
public class ListAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		System.out.println("ListAction OK");
		ActionForward forward = new ActionForward();

		/// 태훈 추가 - 기업 리스트 전체 뿌려주기
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<Board_Search_ListVO> searchVO = boardDAO.Search_ListInfo();
		System.out.println(">>>>>>>>>>>>>>>>>>>>"+searchVO);
		
		/// 태훈 추가 - 기업 리스트 전체 뿌려주기
		request.setAttribute("searchVO", searchVO);
		
		
		String cityName = (String)request.getParameter("cityName");
		request.setAttribute("cityName", cityName);
		
		forward.setRedirect(false);
		forward.setPath("./board/list.jsp");
		return forward;
	}
}
