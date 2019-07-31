package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dto.ApplicationVO;

// 유정 - CompanyApplication03Action
public class CompanyApplication03Action implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();

		System.out.println("CompanyApplication03Action");

		// page1 파라미터값
		String idx = (String)session.getAttribute("idx");
		String app_cp_name = request.getParameter("name");
		String app_cp_manager = request.getParameter("manager");
		String app_cp_hp = request.getParameter("phone");
		String app_cp_num = request.getParameter("num");
		String app_cp_ch = request.getParameter("ch");
		String app_cp_more = request.getParameter("more");
		String app_cp_extra = request.getParameter("extra");
		String app_cp_sector = request.getParameter("sector");
		String app_cp_open_date_time = request.getParameter("open_datetime");
		String app_cp_prestige = request.getParameter("prestige");
		String app_cp_deposit = request.getParameter("deposit");
		String app_cp_monthly = request.getParameter("monthly");
		int app_cp_status = Integer.parseInt(request.getParameter("status"));

		// page2 파라미터값
		String app_cp_goal_amount = request.getParameter("goal_amount");
		String app_cp_avg_monthly_profit = request.getParameter("avg_monthly_profit");
		String app_cp_monthly_profit = request.getParameter("monthly_profit");
		String app_cp_during = request.getParameter("during");
		String app_cp_inv_min_amount = request.getParameter("inv_min_amount");

		// page3 파라미터값
		String app_cp_introduction = request.getParameter("introduction");
		String app_cp_purpose = request.getParameter("purpose");
		String app_cp_point = request.getParameter("point");

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
		company.setApp_cp_status(app_cp_status);
		company.setMb_idx(idx);
		
		// page2 company에 데이터 추가
		company.setApp_cp_goal_amount(app_cp_goal_amount);
		company.setApp_cp_avg_monthly_profit(app_cp_avg_monthly_profit);
		company.setApp_cp_monthly_profit(app_cp_monthly_profit);
		company.setApp_cp_during(app_cp_during);
		company.setApp_cp_inv_min_amount(app_cp_inv_min_amount);

		// page3 company에 데이터 추가
		company.setApp_cp_introduction(app_cp_introduction);
		company.setApp_cp_purpose(app_cp_purpose);
		company.setApp_cp_point(app_cp_point);
		
		System.out.println(company.toString());
		
		// 다음페이지에 company 전달
		request.setAttribute("company", company);

		forward.setRedirect(false);
		forward.setPath("./company/application4.jsp");
		return forward;
	}
}
