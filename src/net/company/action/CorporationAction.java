package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;
import net.company.dto.CompanyListVO;


// 유정 추가
// 투자하기 - 프랜차이즈 - 투자 상세보기
public class CorporationAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		CompanyBean company = new CompanyBean();		
		ArrayList<CompanyListVO> leftCompanyList = new ArrayList<CompanyListVO>();
		int cp_idx = 1;
		
		try {
			String idx = request.getParameter("cp_idx");
			cp_idx = Integer.parseInt(idx);
		}catch(NumberFormatException e) {
			System.out.println("NumberFormatException 에러: " + e);
		}
		
		String mb_idx = (String)session.getAttribute("idx");
		
		CompanyDAO company_dao = new CompanyDAO();
		company = company_dao.getCompanyInfo2(cp_idx);		
		
		
		CompanyDAO company_dao2 = new CompanyDAO();
		leftCompanyList = company_dao2.getCompanyList();
		
		
		CompanyDAO company_dao3 = new CompanyDAO();
		int count = company_dao3.getLikeBoxCount(mb_idx, cp_idx);
		
		request.setAttribute("leftCompanyList", leftCompanyList);
		request.setAttribute("companyBean", company);
		request.setAttribute("count", count);
		
		forward.setRedirect(false);
		forward.setPath("./company/corporation.jsp");
		return forward;
	}
	
	
}
