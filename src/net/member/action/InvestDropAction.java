package net.member.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;
import net.company.dto.Company_pay_scheduleVO;
import net.member.dao.MemberDAO;
import net.member.dto.MemberInvestCompanyVO;
import net.member.dto.MemberInvestPageVO;
import net.member.dto.MemberInvestVO;

public class InvestDropAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		String mb_id = (String) session.getAttribute("id");
		Integer mb_idx = Integer.parseInt((String) session.getAttribute("idx"));
		String mi_idx_string = request.getParameter("mi_idx");
		
		if (mb_id == null || mb_idx == null || mi_idx_string == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('1잘못된 접근 입니다."+mb_id+mb_idx+mi_idx_string+"');</script>");
			out.close();
			forward.setRedirect(true);
			forward.setPath("./Index.mb");
			return forward;
		}
		
		int mi_idx = Integer.parseInt(mi_idx_string);
		
		/*
		 * int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		 * 
		 * String cp_idx_string = null; cp_idx_string = request.getParameter("cp_idx");
		 */
		
		boolean flag = false;		
		MemberDAO memberDAO = new MemberDAO();
		int cp_idx = 0;
		ArrayList<MemberInvestCompanyVO> memberInvestCompanyVOList = memberDAO.getInvestmentCompanyList(mb_idx);
		for (MemberInvestCompanyVO memberInvestVO : memberInvestCompanyVOList ) {
			if (memberInvestVO.getMi_idx() == mi_idx) {
				flag = true;
				cp_idx = memberInvestVO.getCp_idx();
				break;
			}
		}
		
		if (!flag) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('23잘못된 접근 입니다.');</script>");
			out.close();
			forward.setRedirect(true);
			forward.setPath("./Index.mb");
			return forward;
		}
		memberDAO = new MemberDAO();
		MemberInvestPageVO memberInvestVO = memberDAO.getMyPageInvestment(cp_idx,mb_idx);
		/// 윤식 추가
		CompanyDAO companyDAO2 = new CompanyDAO();
		ArrayList<Company_pay_scheduleVO> CompanyPayScheduleVO = companyDAO2.getCompanySchedule(cp_idx);
				
		// 유정 추가
		// 투자현황 - 투자내역 불러오기
		//////////////// 페이징 처리 ////////////////
		// 한 페이지 당 보여줄 글 갯수
		int pageSize = 5;
		// 페이지그룹안의 페이지 갯수 ex) [이전] 1 2 3 4 5 [다음] 일 경우 페이지 갯수는 5
		int pageGroupSize = 5;

		String pageNum = request.getParameter("pageNum");// 페이지 번호
		if (pageNum == null) {
			pageNum = "1";
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number = 0;


		ArrayList<MemberInvestVO> member_invest_list = null;
		CompanyDAO company_dao = new CompanyDAO();
		count = company_dao.getInvestmentCount(mb_id);// 전체 글의 수 불러오기

		if (count > 0) {
			if (endRow > count)
				endRow = count;
			member_invest_list = company_dao.getInvestment(mb_id, startRow - 1, endRow);// 현재 페이지에 해당하는 글 목록불러오기
		} else {
			member_invest_list = company_dao.getInvestment(mb_id, startRow - 1, endRow);
		}

		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		// 페이지그룹의 갯수
		// ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
		int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
		// 페이지 그룹 번호
		// ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1 이고 '[2][3][4]'의 페이지그룹번호는 2
		// 이다.
		int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);
		
		
		CompanyBean company = new CompanyBean();
		CompanyDAO company_dao2 = new CompanyDAO();
		company = company_dao2.getCompanyInfo(cp_idx);
		request.setAttribute("company", company);
		
		
		request.setAttribute("id", mb_id);
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));

		request.setAttribute("number", new Integer(number));
		request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
		
		request.setAttribute("investListCount", memberInvestCompanyVOList.size());
		request.setAttribute("member_invest_list", member_invest_list);
		request.setAttribute("memberInvestVO", memberInvestVO);
		request.setAttribute("CompanyPayScheduleVO", CompanyPayScheduleVO);
		request.setAttribute("memberInvestCompanyVOList", memberInvestCompanyVOList);
		request.setAttribute("selectedMi_idx", mi_idx);	
		
		request.setAttribute("cp_idx", cp_idx);
		forward.setRedirect(false);
		forward.setPath("./member/mypage1_1.jsp");
		return forward;
	}

}
