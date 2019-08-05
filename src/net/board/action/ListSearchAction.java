package net.board.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.board.dao.BoardDAO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 태훈 추가 - 기업 검색 Action
public class ListSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		@SuppressWarnings("unused")
		ActionForward forward = new ActionForward();
		BoardDAO boardDAO = new BoardDAO();
		//page
		int page = Integer.parseInt(request.getParameter("page"));
		
		// 배열 선언
		List<String> sector_list = new ArrayList<String>();
		List<String> city_list = new ArrayList<String>();
		List<String> status_list = new ArrayList<String>();
		List<String> list_all = new ArrayList<String>();
		
		// 배열 받아오기
		String[] sector_array = request.getParameterValues("sector_array[]");	
		String[] city_array = request.getParameterValues("city_array[]");
		String[] city_status = request.getParameterValues("city_status[]");
		
		if (sector_array != null) {
			sector_list =  Arrays.asList(sector_array);
		}
		if (city_array != null) {
			city_list =  Arrays.asList(city_array);
		}
		if (city_status != null) {
			status_list =  Arrays.asList(city_status);
		}
		
		String select_value = request.getParameter("select_value");
		String getKeyword = request.getParameter("getKeyword");
		
		
		
		list_all.add(getKeyword);
		list_all.addAll(sector_list);
		list_all.addAll(city_list);
		list_all.addAll(status_list);
	
		JSONArray search_list = boardDAO.Search_ListInfo(list_all, select_value,page); 

		response.setContentType("application/x-json;charset=UTF-8");
		response.getWriter().print(search_list);
		 

		return null;
	}
}
