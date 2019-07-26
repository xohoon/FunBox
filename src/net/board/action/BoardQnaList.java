package net.board.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.board.dao.BoardDAO;
import net.board.dto.QnaVO;
import net.common.action.Action;
import net.common.action.ActionForward;

///////////////////////유정 추가///////////////////////
public class BoardQnaList implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		System.out.println("BoardQnaList OK");
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		

		
		
		String id = (String) session.getAttribute("id");

		if (session.getAttribute("id") == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('세션이 만료되었습니다.\n다시 로그인해 주세요.');");
			out.println("location.href='./LoginPage.mb';");
			out.println("</script>");
			out.close();

			return null;
		}
		
		
		////////////////페이징 처리 ////////////////
		// 한 페이지 당 보여줄 글 갯수
		int pageSize = 10;
		// 페이지그룹안의 페이지 갯수 ex) [이전] 1 2 3 4 5 [다음] 일 경우 페이지 갯수는 5
		int pageGroupSize = 5;

		String pageNum = request.getParameter("pageNum");// 페이지 번호
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);

		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number = 0;

		List<QnaVO> qna_list = null;
		BoardDAO qna_dao = new BoardDAO();
		count = qna_dao.qnaCount();// 전체 글의 수 불러오기
		

		if (count > 0) {
			if (endRow > count)
				endRow = count;
			BoardDAO qna_dao2 = new BoardDAO();
			qna_list = qna_dao2.getQnaList(id, startRow - 1, pageSize);// 현재 페이지에 해당하는 글 목록불러오기
			

		} else {
			BoardDAO qna_dao2 = new BoardDAO();
			qna_list = qna_dao2.getQnaList(id, startRow - 1, pageSize);
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

		
		// 1:1문의 리스트 가져오기
		request.setAttribute("qna_list", qna_list);
		// 1:1문의 답변 리스트 가져오기
		forward.setRedirect(false);
		forward.setPath("./board/qna_list.jsp");
		return forward;
		
	}

}
