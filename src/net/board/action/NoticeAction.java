package net.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.board.dto.NoticeVO;
import net.common.action.Action;
import net.common.action.ActionForward;

// 유정 고객지원 - 공지사항 불러오기
public class NoticeAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		System.out.println("NoticeAction OK");
		ActionForward forward = new ActionForward();
		
		BoardDAO bd_dao = new BoardDAO();
		ArrayList<NoticeVO> notice = bd_dao.getNotice();
		System.out.println("notice>>>"+notice);
		
		request.setAttribute("notice", notice);
		
		forward.setRedirect(false);
		forward.setPath("./board/notice.jsp");
		return forward;
	}
}
