package net.company.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.action.CompanyApplication01Action;
import net.company.action.CompanyApplication02Action;
import net.company.action.CompanyApplication03Action;
import net.company.action.CompanyApplication04Action;
import net.company.action.CorporationAction;
import net.company.action.InvestAction;
import net.company.action.Invest_beforeAction;
import net.company.action.Invest_pointAction;

@MultipartConfig(maxFileSize = 1024 * 1024 * 2)
public class CompanyController extends HttpServlet implements Servlet {
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

		/////////////////////// 유정 추가 start///////////////////////
		if (command.equals("/Application1.cp")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./company/application1.jsp");
		} else if (command.equals("/Corporation.cp")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./company/corporation.jsp");
		} else if (command.equals("/Invest_before.cp")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./company/invest_before.jsp");
		} else if (command.equals("/Invest_after.cp")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./company/invest_after.jsp");
		} else if (command.equals("/Application03Action.cp")) {
			action = new CompanyApplication03Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (command.equals("/CorporationAction.cp")) {
			action = new CorporationAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if (command.equals("/InvestAction.cp")) {
			action = new InvestAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		/////////////////////// 유정 추가 end///////////////////////
		
		/////////////////////// 태훈 추가 start ///////////////////////
		else if (command.equals("/Application01Action.cp")) {
			action = new CompanyApplication01Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Application02Action.cp")) {
			action = new CompanyApplication02Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Invest_beforeAction.cp")) {
		action = new Invest_beforeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Invest_point.cp")) {
			action = new Invest_pointAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/////////////////////// 태훈 추가 end ///////////////////////
		
		///////////////////////박신규 추가 start///////////////////
		else if (command.equals("/comapny_application_file_upload.cp")) {
			action = new CompanyApplication04Action();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		///////////////////////박신규 추가 end///////////////////
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
