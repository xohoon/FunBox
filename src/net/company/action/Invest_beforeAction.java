package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;


// 유정 추가
// 투자하기 - 프랜차이즈 - 투자 상세보기
public class Invest_beforeAction  implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		ActionForward forward = new ActionForward();
		
		CompanyBean company = new CompanyBean();
		
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		
		CompanyDAO company_dao = new CompanyDAO();
		company = company_dao.getCompanyInfo2(cp_idx);
				
		request.setAttribute("company", company);
		
		
		forward.setRedirect(false);
		forward.setPath("./company/invest_before.jsp");
		return forward;
	}
}
