package net.board.action;

import java.util.ArrayList;
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
		System.out.println("action>>>>>" + getKeyword);
		
		// 검색어 null 일때
		System.out.println("action>>>>>" + getKeyword);
		// 배열 뽑아내기
		
		String[] cityall = {"서울", "경기", "인천", "강원", "대전/충천", "대구", "부산", "울산", "경상", "광주/전라", "제주"};
		String[] sectorall = {"한식", "분식", "일식", "중식", "양식", "카페", "치킨", "기타"};
		String[] statusall = {"10", "11", "12", "21", "22", "30"};
		System.out.println(">>>>>>>>>>>>>>>>>>>>1111>"+statusall[0]+statusall[5]);
		if (list_city != null) {
			for (int i = 0; i < list_city.length; i++) {
				if(list_city[i].equals("도시전체")) {
					list_city = cityall;
				}else {
					city.add(list_city[i]);
				}
			}
			System.out.println("받은배열 city::" + list_city + "받은배열 city::" + city);
		}
		
		if (list_sector != null) {
			for (int i = 0; i < list_sector.length; i++) {
				if(list_sector[i].equals("업종전체")) {
					list_sector = sectorall;
				}else {
					sector.add(list_sector[i]);
				}
			}
			System.out.println("받은배열 sector::" + list_sector + "받은배열 sector::" + sector);
		}
		
		if (list_status != null) {
			for (int i = 0; i < list_status.length; i++) {
				if(list_status[i].equals("현황전체")) {
					list_status = statusall;
				}else {
					status.add(list_status[i]);
				}
			}
			System.out.println("받은배열 sector::" + list_sector + "받은배열 sector::" + sector);
		}
		
		
		
		/*
		 * // list_status <- all // status <- list_status if (list_status != null) {
		 * for(int i = 0; i < list_status.length; i++) {
		 * if(!list_status[i].equals("현황전체")) { status.add(list_status[i]); } } for(int
		 * i = 0; i < list_status.length; i++) { if(list_status[i].equals("현황전체")) {
		 * list_status = statusall; status.add(list_status[i]); } } }
		 */
		// 차라리 하나로 몰자...
		list_all.add(getKeyword);
		list_all.addAll(sector);
		list_all.addAll(city);
		list_all.addAll(status);
	
		JSONArray search_list = boardDAO.Search_ListInfo(list_all, select_value,page); 

		response.setContentType("application/x-json;charset=UTF-8");
		response.getWriter().print(search_list);
		 

		return null;
	}
}
