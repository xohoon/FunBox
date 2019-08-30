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
import net.member.action.InvestDropAction;
import net.member.action.MainAction;
import net.member.action.MemberIDCheckAction;
import net.member.action.MemberInvestcheck;
import net.member.action.MemberInvestmentListAction;
import net.member.action.MemberIvDropInfoAction;
import net.member.action.MemberJoinAction;
import net.member.action.MemberLoginAction;
import net.member.action.MemberLoginCheckAction;
import net.member.action.MemberPhoneCheckAction;
import net.member.action.MemberSelectKeyAction;
import net.member.action.MemberUpdateAction;
import net.member.action.Mypage1_1Action;
import net.member.action.Mypage1_1_1Action;
import net.member.action.Mypage2_2Action;
import net.member.action.MypageChargePointAction;
import net.member.action.MypageDepositAction;
import net.member.action.MypageExchangePointToTokenAction;
import net.member.action.MypagePINCheckAction;
import net.member.action.MypagePWCheckAction;
import net.member.action.MypagePWPINCheckAction;
import net.member.action.MypageSendTokenAction;
import net.member.action.MypageTransAction;
import net.member.action.MypageTransAction_s;
import net.member.action.PointTransAction;
import net.member.action.Point_DepositAction;
import net.member.action.Point_WithdrawAction;
import net.member.action.Token_DepositAction;
import net.member.action.Token_WithdrawAction;
import net.member.action.deleteInvestAction;


public class MemberController extends HttpServlet implements Servlet {
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		
		
		///////////////////////유정 추가 start///////////////////////
		if (command.equals("/Index.mb")) {
			action = new MainAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/LoginPage.mb")) {
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
		}else if (command.equals("/Mypage2_1_1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_1_1.jsp");
		}else if (command.equals("/Mypage2_2_1.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_2_1.jsp");
		}else if (command.equals("/Mypage2_2_2.mb")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/mypage2_2_2.jsp");
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
		}else if (command.equals("/Mypage1_1Action.mb")) { 
			action = new Mypage1_1Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mypage1_1_1Action.mb")) { 
			action = new Mypage1_1_1Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		///////////////////////유정 추가 end///////////////////////
		/////////////////////////태훈 추가 / 시작//////////////////////////
		else if(command.equals("/MemberInvestcheck.mb")) {
			action = new MemberInvestcheck();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberSelectKey.mb")) {
			action = new MemberSelectKeyAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/TokenDepositAction.mb")) {
			action = new Token_DepositAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/TokenWithdrawAction.mb")) {
			action = new Token_WithdrawAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/PointDepositAction.mb")) {
			action = new Point_DepositAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/PointWithdrawAction.mb")) {
			action = new Point_WithdrawAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberInvestmentDrop.mb")) {
			action = new InvestDropAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberIvDropInfo.mb")) {
			action = new MemberIvDropInfoAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/MemberIvDrop.mb")) {
			action = new deleteInvestAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		else if (command.equals("/socket_test.mb")) {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("./socket_test.jsp");
			}
		/////////////////////////태훈 추가 끝///////////////////////////
		
		/*박신규 시작*/
		else if (command.equals("/MemberInvestmentList.mb")) {
			action = new MemberInvestmentListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MypageDeposit.mb")) {
			action = new MypageDepositAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MypageSendToken.mb")) {
			action = new MypageSendTokenAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MypageChargePoint.mb")) {
			action = new MypageChargePointAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MypageExchangePointToToken.mb")) {
			action = new MypageExchangePointToTokenAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mypage2_1.mb")) { // 윤식 추가 (입출금내역)
			action = new MypageTransAction_s();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mypage2_2.mb")) { // 윤식 추가(포인트내역)
			action = new PointTransAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mypage3.mb")) { // 윤식 추가(거래내역 - 입출금, 포인트)
			action = new MypageTransAction();
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
