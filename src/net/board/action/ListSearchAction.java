package net.board.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import net.board.dao.BoardDAO;
import net.board.dto.Board_Search_ListVO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 태훈 추가 - 기업 검색 Action
public class ListSearchAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		ActionForward forward = new ActionForward();
		BoardDAO boardDAO = new BoardDAO();
		
		String key_word = request.getParameter("key_word");
		System.out.println("검색 리스트 >>>111"+request.getParameter("key_word"));
		
		ArrayList<Board_Search_ListVO> search_list = boardDAO.Search_ListInfo(key_word);
		System.out.println("검색 리스트 >>>222"+search_list);
		
		// map
//		Map<String, Object> search_map = new HashMap<String, Object>();
//		search_map.put("Search_list", Search_list);
		
		request.setAttribute("search_list", search_list);
//		request.setAttribute("search_map", search_map);
		
		forward.setRedirect(false);
		forward.setPath("./board/list.jsp");
		
		return forward;
	}
}
