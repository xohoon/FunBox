package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dto.ApplicationVO;

// 김태훈 - CompanyApplication02Action
public class CompanyApplication02Action implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		ActionForward forward = new ActionForward();
		
		
		//  page1 파라미터값
		String app_cp_name = request.getParameter("name");
		String app_cp_manager = request.getParameter("manager");
		String app_cp_hp = request.getParameter("phone");
		String app_cp_num = request.getParameter("app4");
		String app_cp_ch = request.getParameter("app4_1");
		String app_cp_more = request.getParameter("app4_2");
		String app_cp_extra = request.getParameter("app4_3");
		String app_cp_sector = request.getParameter("sector");
		String app_cp_open_date_time = request.getParameter("open_datetime");
		String app_cp_prestige = request.getParameter("open_datetime");
		String app_cp_deposit = request.getParameter("deposit");
		String app_cp_monthly = request.getParameter("monthly");

		// page2 파라미터값
		String app_cp_goal_amount = request.getParameter("goal_amount");
		String app_cp_avg_monthly_profit = request.getParameter("avg_monthly_profit");
		String app_cp_monthly_profit = request.getParameter("monthly_profit");
		String app_cp_during = request.getParameter("during");
		String app_cp_inv_min_amount = request.getParameter("inv_min_amount");

		ApplicationVO company = new ApplicationVO();

		// page1 company에 데이터 추가
		company.setApp_cp_name(app_cp_name);
		company.setApp_cp_manager(app_cp_manager);
		company.setApp_cp_hp(app_cp_hp);
		company.setApp_cp_num(app_cp_num);
		company.setApp_cp_ch(app_cp_ch);
		company.setApp_cp_more(app_cp_more);
		company.setApp_cp_extra(app_cp_extra);
		company.setApp_cp_sector(app_cp_sector);
		company.setApp_cp_open_date_time(app_cp_open_date_time);
		company.setApp_cp_prestige(app_cp_prestige);
		company.setApp_cp_deposit(app_cp_deposit);
		company.setApp_cp_monthly(app_cp_monthly);
		
		// page2 company에 데이터 추가
		company.setApp_cp_goal_amount(app_cp_goal_amount);
		company.setApp_cp_avg_monthly_profit(app_cp_avg_monthly_profit);
		company.setApp_cp_monthly_profit(app_cp_monthly_profit);
		company.setApp_cp_during(app_cp_during);
		company.setApp_cp_inv_min_amount(app_cp_inv_min_amount);

		// 다음페이지에 company 전달
		request.setAttribute("company", company);

		forward.setRedirect(false);
		forward.setPath("./company/application3.jsp");
		return forward;
	}
}
