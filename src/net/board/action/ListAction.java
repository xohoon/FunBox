package net.board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.BoardDAO;
import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dto.CompanyBean;
//유정 추가
public class ListAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		System.out.println("ListAction OK");
		
		ActionForward forward = new ActionForward();
		
		String location = request.getParameter("location");
		System.out.println("location: "+location);
		
		List<CompanyBean> company_list = null;
		
		BoardDAO bd_dao = new BoardDAO();
		company_list = bd_dao.getCompanyList(location);
		
		request.setAttribute("company_list", company_list);
		
		forward.setRedirect(false);
		forward.setPath("./board/list.jsp");
		return forward;
	}
}
