package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

//		System.out.println("CorporationAction OK!");
		
		CompanyBean company = new CompanyBean();
		CompanyListVO List = new CompanyListVO();
		ArrayList<CompanyListVO> leftCompanyList = new ArrayList<CompanyListVO>();
		
//		int idx = Integer.parseInt(request.getParameter("idx"));
		
		CompanyDAO company_dao = new CompanyDAO();
		
		company = company_dao.getCompanyInfo2(1);		
		request.setAttribute("company", company);
		
		CompanyDAO company_dao2 = new CompanyDAO();
		
		leftCompanyList = company_dao2.getCompanyList();
		request.setAttribute("leftCompanyList", leftCompanyList);
		
//		System.out.println(leftCompanyList.toString());
		
		forward.setRedirect(false);
		forward.setPath("./company/corporation.jsp");
		
		return forward;
	}
	
	
}
