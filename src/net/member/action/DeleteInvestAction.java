package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class DeleteInvestAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		boolean result = false;
		
		System.out.println("mb_idx???"+Integer.parseInt((String)session.getAttribute("idx")));
		System.out.println("cp_idx???"+Integer.parseInt(request.getParameter("cp_idx")));
		
		int mb_idx = Integer.parseInt((String)session.getAttribute("idx"));
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		
		MemberDAO mb_dao = new MemberDAO();
		result = mb_dao.deleteInvest(mb_idx, cp_idx);
		
		if(result==false){
			System.out.println("투자 철회하기 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('투자 철회하기에 실패했습니다.\n다시 시도해주세요.');");
			out.println("opener.location.href='./MemberInvestmentList.mb'");
			out.println("window.close();");
			out.println("</script>");
			out.close();
			
			return null;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('투자 철회하기에 성공했습니다.');");
		out.println("opener.location.href='./MemberInvestmentList.mb'");
		out.println("window.close();");
		out.println("</script>");
		out.close();
		
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./member/Investment_list.jsp");
		
		return null;
	}

}
