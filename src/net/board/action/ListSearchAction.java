package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 태훈 추가
public class ListSearchAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		
		BoardDAO boardDAO = new BoardDAO();
	
	return null;
	}
}
