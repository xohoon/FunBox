package net.member.action;


import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberInvestCompanyVO;
import net.member.dto.MemberInvestPageVO;

///////////////////////김윤식 박신규 추가///////////////////////
public class MemberInvestmentListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		String mb_id = (String) session.getAttribute("id");
		
		if (mb_id == null ) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('1잘못된 접근 입니다.');</script>");
			out.close();
			forward.setRedirect(true);
			forward.setPath("./index.mb");
			return forward;
		}
		
		String cp_idx_string = null;
		cp_idx_string = request.getParameter("cp_idx");
		int cp_idx = 0;
		if (cp_idx_string == null) {
			System.out.println("null");
			System.out.println(mb_id);
		}else {
			cp_idx = Integer.parseInt(cp_idx_string);
		}
		
		boolean flag = false;		
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberInvestCompanyVO> memberInvestCompanyVOList = memberDAO.getInvestmentCompanyList(mb_id);
		for (MemberInvestCompanyVO memberInvestVO : memberInvestCompanyVOList ) {
			if (cp_idx_string == null) {
				cp_idx = memberInvestVO.getCp_idx();
				flag = true;
				break;
			}
			if (memberInvestVO.getCp_idx() == cp_idx) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('2잘못된 접근 입니다.');</script>");
			out.close();
			forward.setRedirect(true);
			forward.setPath("./index.mb");
			return forward;
		}
		memberDAO = new MemberDAO();
		MemberInvestPageVO memberInvestVO = memberDAO.getMyPageInvestment(cp_idx,mb_id);
		
		request.setAttribute("memberInvestVO", memberInvestVO);
		request.setAttribute("memberInvestCompanyVOList", memberInvestCompanyVOList);
		request.setAttribute("selectedCp_idx", cp_idx);		
		forward.setRedirect(false);
		forward.setPath("./member/Investment_list.jsp");
		
		/*
		if (mb_id == null ) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근 입니다.');</script>");
			out.println("<script>location.href = './Index.mb'</script>");
			out.close();
		}
		int cp_idx = Integer.parseInt(cp_idx_string);

		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberInvestCompanyVO> memberInvestCompanyVOList = memberDAO.getInvestmentCompanyList(mb_id);
		
		for (MemberInvestCompanyVO memberInvestVO : memberInvestCompanyVOList ) {
			if (memberInvestVO.getCp_idx() == cp_idx) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('flag 잘못된 접근 입니다.');</script>");
			out.println("<script>location.href = './Index.mb'</script>");
			out.close();
		}
		
		memberDAO = new MemberDAO();
		MemberInvestVO memberInvestVO = memberDAO.getMyPageInvestment(cp_idx,mb_id);
		
		
		
		request.setAttribute("memberInvestVO", memberInvestVO);
		request.setAttribute("memberInvestCompanyVOList", memberInvestCompanyVOList);
		request.setAttribute("selectedCp_idx", cp_idx);		
		forward.setRedirect(false);
		forward.setPath("./member/Investment_list.jsp");
		*/
		return forward;
	}
}
