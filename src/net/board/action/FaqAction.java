package net.board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.board.dto.FaqVO;
import net.common.action.Action;
import net.common.action.ActionForward;


// 유정 FAQ - 공지사항 불러오기
// 윤식 FAQ - 페이징 처리
// 유정 고객지원 - FAQ

public class FaqAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		//FAQ 불러오기
		System.out.println("FaqAction OK");
		ActionForward forward = new ActionForward();
		String category = request.getParameter("category");
		System.out.println("category:"+category);
		
		try {
			if(category.equals(null)) {
				category = "0";
			}
		}catch(NullPointerException e) {
			//System.out.println("NullPointerException :" + e);
			category = "0";			
		}
			
		// 페이징 처리 구문
		int pageSize = 10; // 한페이지에 보여줄 List
		
		int pageGroupSize = 5; // 페이지 단위 [◀] 1 2 3 4 5 [▶]
		String pageNum = request.getParameter("pageNum");// 페이지 번호 / 1
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		System.out.println("currentPage : "+currentPage);
		
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호 / 1
		System.out.println("startRow : "+startRow);
		
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호 / 10
		System.out.println("endRow : "+endRow);
		
		int count = 0;
		int number = 0;
		
		BoardDAO qna_dao_count = new BoardDAO();		
		count = qna_dao_count.faqCount(category); // 전체 글의 수 불러오기 (선택시)
		
		System.out.println("해당 DB 글 개수 불러오기" + count);
		
		if(count > 0) {
			if (endRow > count) {
				endRow = count;
			}
			if(category.equals("0")) {//전체
				BoardDAO bd_dao1 = new BoardDAO(); //입출금 관련 FAQ
				ArrayList<FaqVO> faq1 = bd_dao1.getFaq(1, startRow - 1, pageSize);			
				BoardDAO bd_dao2 = new BoardDAO(); //투자관련 FAQ
				ArrayList<FaqVO> faq2 = bd_dao2.getFaq(2, startRow - 1, pageSize);			
				BoardDAO bd_dao3 = new BoardDAO(); //기타 FAQ
				ArrayList<FaqVO> faq3 = bd_dao3.getFaq(3, startRow - 1, pageSize);
				
				request.setAttribute("faq1", faq1);		
				request.setAttribute("faq2", faq2);
				request.setAttribute("faq3", faq3);
				
			}else if(category.equals("1")) {//입출금 관련 FAQ
				BoardDAO bd_dao1 = new BoardDAO(); 
				ArrayList<FaqVO> faq1 = bd_dao1.getFaq(1, startRow - 1, pageSize);
				request.setAttribute("faq1", faq1);
			}else if(category.equals("2")) {//투자관련 FAQ
				BoardDAO bd_dao2 = new BoardDAO(); 
				ArrayList<FaqVO> faq2 = bd_dao2.getFaq(2, startRow - 1, pageSize);
				request.setAttribute("faq2", faq2);
			}else if(category.equals("3")) {//기타 FAQ
				BoardDAO bd_dao3 = new BoardDAO(); 
				ArrayList<FaqVO> faq3 = bd_dao3.getFaq(3, startRow - 1, pageSize);
				request.setAttribute("faq3", faq3);
			}
			
			
		}else {
			if(category.equals("0")) {//전체
				BoardDAO bd_dao1 = new BoardDAO(); //입출금 관련 FAQ
				ArrayList<FaqVO> faq1 = bd_dao1.getFaq(1, startRow - 1, pageSize);			
				BoardDAO bd_dao2 = new BoardDAO(); //투자관련 FAQ
				ArrayList<FaqVO> faq2 = bd_dao2.getFaq(2, startRow - 1, pageSize);			
				BoardDAO bd_dao3 = new BoardDAO(); //기타 FAQ
				ArrayList<FaqVO> faq3 = bd_dao3.getFaq(3, startRow - 1, pageSize);
				
				request.setAttribute("faq1", faq1);		
				request.setAttribute("faq2", faq2);
				request.setAttribute("faq3", faq3);
				
			}else if(category.equals("1")) {//입출금 관련 FAQ
				BoardDAO bd_dao1 = new BoardDAO(); 
				ArrayList<FaqVO> faq1 = bd_dao1.getFaq(1, startRow - 1, pageSize);
				request.setAttribute("faq1", faq1);
			}else if(category.equals("2")) {//투자관련 FAQ
				BoardDAO bd_dao2 = new BoardDAO(); 
				ArrayList<FaqVO> faq2 = bd_dao2.getFaq(2, startRow - 1, pageSize);
				request.setAttribute("faq2", faq2);
			}else if(category.equals("3")) {//기타 FAQ
				BoardDAO bd_dao3 = new BoardDAO(); 
				ArrayList<FaqVO> faq3 = bd_dao3.getFaq(3, startRow - 1, pageSize);
				request.setAttribute("faq3", faq3);
			}
			
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
		System.out.println(currentPage); // 1
		
		request.setAttribute("startRow", new Integer(startRow));
		System.out.println(startRow); //1
		
		request.setAttribute("endRow", new Integer(endRow));
		System.out.println(endRow); //2
		
		request.setAttribute("count", new Integer(count));
		System.out.println(count); //2
		
		request.setAttribute("pageSize", new Integer(pageSize));
		System.out.println(pageSize); //10

		request.setAttribute("number", new Integer(number));
		System.out.println(number); // 2
		
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		System.out.println(pageGroupSize); //5
		
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		System.out.println(numPageGroup); // 1
		
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
		System.out.println(pageGroupCount); // 1
			
		forward.setRedirect(false);
		forward.setPath("./board/faq.jsp");
		
		return forward;
	}
}
