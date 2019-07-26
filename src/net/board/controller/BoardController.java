package net.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.action.BoardQnaAction;
import net.board.action.BoardQnaList;
import net.board.action.ListAction;
import net.common.action.Action;
import net.common.action.ActionForward;

///////////////////////유정 추가///////////////////////
public class BoardController extends HttpServlet implements Servlet{
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println(command);
		ActionForward forward = null;
		Action action = null;
		
		
		
		///////////////////////유정 추가 start///////////////////////
		if (command.equals("/List.bd")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/list.jsp");
		}else if (command.equals("/Intro.bd")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/intro.jsp");
		}else if (command.equals("/Notice.bd")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/notice.jsp");
		}else if (command.equals("/Faq.bd")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/faq.jsp");
		}else if (command.equals("/Qna.bd")){ 
			forward = new ActionForward();
		    forward.setRedirect(false); 
		    forward.setPath("./board/qna.jsp"); 
		}else if (command.equals("/Policy_1.bd")){ 
			forward = new ActionForward();
		    forward.setRedirect(false); 
		    forward.setPath("./board/policy_1.jsp"); 
		}else if (command.equals("/Policy_2.bd")){ 
			forward = new ActionForward();
		    forward.setRedirect(false); 
		    forward.setPath("./board/policy_2.jsp"); 
		}else if (command.equals("/Policy_3.bd")){ 
			forward = new ActionForward();
		    forward.setRedirect(false); 
		    forward.setPath("./board/policy_3.jsp"); 
		}else if (command.equals("/Policy_4.bd")){ 
			forward = new ActionForward();
		    forward.setRedirect(false); 
		    forward.setPath("./board/policy_4.jsp"); 
		}else if (command.equals("/BoardQnaAction.bd")) { // 1:1문의 등록
			action = new BoardQnaAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/BoardQnaList.bd")) { // 1:1문의 리스트
			action = new BoardQnaList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/ListAction.bd")) { // 메인 지도에서 지역 선택하면 해당하는 기업리스트 불러오기
			action = new ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		///////////////////////유정 추가 end///////////////////////
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
