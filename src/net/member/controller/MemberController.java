package net.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.action.MemberIDCheckAction;
import net.member.action.MemberInvestmentListAction;
import net.member.action.MemberJoinAction;
import net.member.action.MemberLoginAction;
import net.member.action.MemberLoginCheckAction;
import net.member.action.MemberPhoneCheckAction;
import net.member.action.MemberUpdateAction;
import net.member.action.Mypage2_2Action;
import net.member.action.MypagePINCheckAction;
import net.member.action.MypagePWCheckAction;
import net.member.action.MypagePWPINCheckAction;


public class MemberController extends HttpServlet implements Servlet {
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
		if (command.equals("/Index.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./index.jsp");
		}else if (command.equals("/LoginPage.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/login.jsp");
		}else if (command.equals("/JoinPage.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/join.jsp");
		}else if (command.equals("/Find_id.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/find_id.jsp");
		}else if (command.equals("/Find_pw.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/find_pw.jsp");
		}else if (command.equals("/Find_pin.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/find_pin.jsp");
		}else if (command.equals("/Mypage1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage1.jsp");
		}else if (command.equals("/Mypage2_1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_1.jsp");
		}else if (command.equals("/Mypage2_1_1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_1_1.jsp");
		}else if (command.equals("/Mypage2_2.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_2.jsp");
		}else if (command.equals("/Mypage2_2_1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_2_1.jsp");
		}else if (command.equals("/Mypage2_2_2.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_2_2.jsp");
		}else if (command.equals("/Mypage3.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage3.jsp");
		}else if (command.equals("/Mypage4_1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage4_1.jsp");
		}else if (command.equals("/Mypage4_2.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage4_2.jsp");
		}else if (command.equals("/MemberIDCheckAction.mb")) { // 회원가입 아이디 중복 확인
			action = new MemberIDCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MemberPhoneCheckAction.mb")) { 
			action = new MemberPhoneCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (command.equals("/MemberJoinAction.mb")) { // 회원가입 insert 액션
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MemberLoginAction.mb")) { // 로그인 액션
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MemberLoginCheckAction.mb")) { // 로그인 체크 액션
			action = new MemberLoginCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MemberUpdateAction.mb")) { // 개인정보수정 액션
			action = new MemberUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/MypagePWCheckAction.mb")) { 
			action = new MypagePWCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MypagePINCheckAction.mb")) { 
			action = new MypagePINCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MypagePWPINCheckAction.mb")) { 
			action = new MypagePWPINCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mypage2_2Action.mb")) { 
			action = new Mypage2_2Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		///////////////////////유정 추가 end///////////////////////
		
		/*박신규 시작*/
		else if (command.equals("/MemberInvestmentList.mb")) {
			action = new MemberInvestmentListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*박신규 끝*/
		
		
		
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
