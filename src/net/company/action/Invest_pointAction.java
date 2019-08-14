package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;
import net.company.dto.InvestPointVO;

// 김태훈 - Invest_pointAction
public class Invest_pointAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		ActionForward forward = new ActionForward();
		
		// 투자포인트/구좌 양
		String invest_point = request.getParameter("invest_point");
		String invest_amount = request.getParameter("invest_amount");
		
		System.out.println("투자 포인트 : " + invest_point);
		System.out.println("투자 양 : " + invest_amount);

		InvestPointVO inv_pointVO = new InvestPointVO();
		
		inv_pointVO.setInvest_amount(invest_amount);
		inv_pointVO.setInvest_point(invest_point);
		
		// 다음페이지에 company 전달
		request.setAttribute("inv_pointVO", inv_pointVO);
		
		CompanyBean company = new CompanyBean();
		
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		
		CompanyDAO company_dao = new CompanyDAO();
		company = company_dao.getCompanyInfo2(cp_idx);
				
		request.setAttribute("company", company);

		forward.setRedirect(false);
		forward.setPath("./company/invest_after.jsp");
		return forward;
	}
}
