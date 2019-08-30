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
		CompanyDAO companyDAO = new CompanyDAO();
		List<Boolean> autoStatusList = new ArrayList<Boolean>();
		
		companyDAO.getAllAutoStatus(autoStatusList);
		companyDAO = new CompanyDAO();
		// 태훈 추가
		
		
		List<Main_SlideVO> mainBanner1List = new ArrayList<Main_SlideVO>(); 
		companyDAO.getMainBanner1(mainBanner1List,autoStatusList.get(3).booleanValue());
		
		//MemberDAO likeDAO = new MemberDAO();
		//List<Main_LikeVO> likeVO = likeDAO.Main_LikeInfo();
		
		
		MemberDAO cityDAO = new MemberDAO();
		Main_CityVO cityVO = cityDAO.Main_CityInfo();
		
		// 신규 추가
		companyDAO = new CompanyDAO();
		List<Main_LikeVO> mainRecommandedCompanyList = new ArrayList<Main_LikeVO>();
		companyDAO.getMainRecommandedCompanyList(mainRecommandedCompanyList,autoStatusList.get(1).booleanValue());
		companyDAO = new CompanyDAO();
		List<MainPageDateOfOpenVO> mainBanner2List = new ArrayList<MainPageDateOfOpenVO>();
		companyDAO.getMainBanner2(mainBanner2List,autoStatusList.get(4).booleanValue());
		companyDAO = new CompanyDAO();
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = companyDAO.getCompanyDeadLine();
		
		ActionForward forward = new ActionForward();		
		
		request.setAttribute("cityVO", cityVO);
		request.setAttribute("likeVO", mainRecommandedCompanyList);
		request.setAttribute("slideVO", mainBanner1List);
		request.setAttribute("mainPageDateOfOpenVOs", mainBanner2List);
		request.setAttribute("mainPageDeadLineVOs", mainPageDeadLineVOs);
		
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}

	
}
