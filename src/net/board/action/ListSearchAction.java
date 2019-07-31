package net.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.board.dao.BoardDAO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 태훈 추가 - 기업 검색 Action
public class ListSearchAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		@SuppressWarnings("unused")
		ActionForward forward = new ActionForward();
		BoardDAO boardDAO = new BoardDAO();
		
		// 배열 선언
		ArrayList<String> sector = new ArrayList<String>();
		ArrayList<String> city = new ArrayList<String>();
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<String> list_all = new ArrayList<String>();
		
		// 배열 받아오기
		String[] list_sector = request.getParameterValues("list_sector[]");
		String[] list_city = request.getParameterValues("list_city[]");
		String[] list_status = request.getParameterValues("list_status[]");
		String select_value = request.getParameter("select_value");
		String getKeyword = request.getParameter("getKeyword");
		System.out.println("action>>>>>"+getKeyword);
		
		// 검색어 null 일때
		if(getKeyword == null) {
			getKeyword = "검색어없음";
		}
		System.out.println("action>>>>>"+getKeyword);
		
		// 배열 뽑아내기
		if(list_sector != null) {
			for(int i=0; i<list_sector.length; i++) {
				sector.add(list_sector[i]);
				System.out.println("받은배열 sector::"+list_sector[i]+"받은배열 sector::"+sector);
			}
		}
		if(list_city != null) {
			for(int i=0; i<list_city.length; i++) {
				city.add(list_city[i]);
				System.out.println("받은배열 city::"+list_city[i]+"받은배열 city::"+city);
			}
		}
		if(list_status != null) {
			for(int i=0; i<list_status.length; i++) {
				status.add(list_status[i]);
				System.out.println("받은배열 status::"+list_status[i]+"받은배열 status::"+status);
			}
		}
		// 차라리 하나로 몰자...
		list_all.add(getKeyword);
		list_all.addAll(sector);
		list_all.addAll(city);
		list_all.addAll(status);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+select_value);
		JSONArray search_list = boardDAO.Search_ListInfo(list_all, select_value);
		System.out.println("Action 최종 데이터:::" + search_list);
		
		response.setContentType("application/x-json;charset=UTF-8");
    	response.getWriter().print(search_list);
		
		return null;
	}
}
