package net.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.member.dao.MemberDAO;
import net.member.dto.Main_CityVO;
import net.member.dto.Main_LikeVO;
import net.member.dto.Main_SlideVO;
import net.page.dto.MainPageDateOfOpenVO;
import net.page.dto.MainPageDeadLineVO;

public class MainAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// 태훈 추가
		MemberDAO slideDAO = new MemberDAO();
		List<Main_SlideVO> slideVO = slideDAO.Main_SlideInfo();
		MemberDAO likeDAO = new MemberDAO();
		List<Main_LikeVO> likeVO = likeDAO.Main_LikeInfo();
		MemberDAO cityDAO = new MemberDAO();
		Main_CityVO cityVO = cityDAO.Main_CityInfo();
		
		// 신규 추가
		CompanyDAO companyDAO = new CompanyDAO();
		ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = companyDAO.getCompanyDateOfOpen();
		companyDAO = new CompanyDAO();
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = companyDAO.getCompanyDeadLine();
		
		ActionForward forward = new ActionForward();		
		
		request.setAttribute("cityVO", cityVO);
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
