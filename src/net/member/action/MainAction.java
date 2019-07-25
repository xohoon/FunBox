package net.member.action;




import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.page.dto.MainPageDateOfOpenVO;
import net.page.dto.MainPageDeadLineVO;

///////////////////////유정 추가///////////////////////
public class MainAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		ActionForward forward = new ActionForward();
		
		CompanyDAO companyDAO = new CompanyDAO();
		ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = companyDAO.getCompanyDateOfOpen();
		companyDAO = new CompanyDAO();
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = companyDAO.getCompanyDeadLine();
		
		
		
		request.setAttribute("mainPageDateOfOpenVOs", mainPageDateOfOpenVOs);
		request.setAttribute("mainPageDeadLineVOs", mainPageDeadLineVOs);
		
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}
}
