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
		
		List<Main_SlideVO> mainBanner_1_List = new ArrayList<Main_SlideVO>(); 
		slideDAO.getMainBanner_1(mainBanner_1_List);
		
		MemberDAO likeDAO = new MemberDAO();
		List<Main_LikeVO> likeVO = likeDAO.Main_LikeInfo();
		MemberDAO cityDAO = new MemberDAO();
		Main_CityVO cityVO = cityDAO.Main_CityInfo();
		
		// 신규 추가
		CompanyDAO companyDAO = new CompanyDAO();
		List<MainPageDateOfOpenVO> mainBanner_2_List = new ArrayList<MainPageDateOfOpenVO>();
		companyDAO.getMainBanner_2(mainBanner_2_List);
		companyDAO = new CompanyDAO();
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = companyDAO.getCompanyDeadLine();
		
		ActionForward forward = new ActionForward();		
		
		request.setAttribute("cityVO", cityVO);
		request.setAttribute("likeVO", likeVO);
		request.setAttribute("slideVO", mainBanner_1_List);
		request.setAttribute("mainPageDateOfOpenVOs", mainBanner_2_List);
		request.setAttribute("mainPageDeadLineVOs", mainPageDeadLineVOs);
		
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}

	
}
