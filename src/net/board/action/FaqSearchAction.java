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
	
	String categroyFlag = "";
	String keyword = "";
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
	
		ActionForward forward = new ActionForward();
		
		//FAQ 키워드 검색
		keyword = request.getParameter("keyword");
		
		int category = Integer.parseInt(request.getParameter("category"));
		String categoryOfcount = request.getParameter("category");
		
		try {
			if(categoryOfcount.equals(null)) {
				categoryOfcount = "0";
			}
		}catch(NullPointerException e) {
			categoryOfcount = "0";			
		}
		
		// 페이징 처리 구문
		int pageSize = 10; // 한페이지에 보여줄 List
		
		int pageGroupSize = 5; // 페이지 단위 [◀] 1 2 3 4 5 [▶]
		String pageNum = request.getParameter("pageNum");// 페이지 번호 / 1
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호 / 1
		
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호 / 10
		
		int count = 0;
		int number = 0;
		categroyFlag = categoryOfcount;
				
		BoardDAO qna_dao_count = new BoardDAO();		
		count = qna_dao_count.searchFaqCount(keyword, category); // 전체 글의 수 불러오기 (선택시)
				
		
		if(count > 0) {
			if (endRow > count) {
				endRow = count;
			}			
			BoardDAO dao = new BoardDAO();
			ArrayList<FaqVO> faq_list = dao.searchFaq(keyword, category,  startRow - 1, pageSize);
			request.setAttribute("faq_list", faq_list);
			request.setAttribute("cate", category);
			
		}else {
			BoardDAO dao = new BoardDAO();
			ArrayList<FaqVO> faq_list = dao.searchFaq(keyword, category,  startRow - 1, pageSize);
			request.setAttribute("faq_list", faq_list);
			request.setAttribute("cate", category);
		}
				
		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		//페이지그룹의 갯수
		//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
		int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
		//페이지 그룹 번호
		//ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1 이고 '[2][3][4]'의 페이지그룹번호는 2
		//이다.
		int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);
		
		request.setAttribute("currentPage", new Integer(currentPage));
		
		request.setAttribute("startRow", new Integer(startRow));
		
		request.setAttribute("endRow", new Integer(endRow));
		
		request.setAttribute("count", new Integer(count));
		
		request.setAttribute("pageSize", new Integer(pageSize));

		request.setAttribute("number", new Integer(number));
		
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
			
		request.setAttribute("categroyFlag", categroyFlag);
		request.setAttribute("keyword", keyword);
		request.setAttribute("category", category);
		
		forward.setRedirect(false);
		forward.setPath("./board/faq.jsp");
		return forward;
	}
}