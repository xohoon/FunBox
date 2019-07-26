package net.member.action;

import java.util.List;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.Main_LikeVO;
import net.member.dto.Main_SlideVO;
import net.company.dao.CompanyDAO;
import net.page.dto.MainPageDateOfOpenVO;
import net.page.dto.MainPageDeadLineVO;

///////////////////////유정 추가///////////////////////
public class MainAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// 태훈 추가
		MemberDAO slideDAO = new MemberDAO();
		List<Main_SlideVO> slideVO = slideDAO.Main_SlideInfo();
		MemberDAO likeDAO = new MemberDAO();
		List<Main_LikeVO> likeVO = likeDAO.Main_LikeInfo();
		
		// 신규 추가
		CompanyDAO companyDAO = new CompanyDAO();
		ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = companyDAO.getCompanyDateOfOpen();
		companyDAO = new CompanyDAO();
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = companyDAO.getCompanyDeadLine();
		
		ActionForward forward = new ActionForward();		
		request.setAttribute("likeVO", likeVO);
		request.setAttribute("slideVO", slideVO);
		request.setAttribute("mainPageDateOfOpenVOs", mainPageDateOfOpenVOs);
		request.setAttribute("mainPageDeadLineVOs", mainPageDeadLineVOs);
		System.out.println(mainPageDeadLineVOs.toString());
		
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}
}
