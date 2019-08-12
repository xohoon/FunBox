package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class deleteInvestAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int result;
		
		System.out.println("mb_idx???"+Integer.parseInt((String)session.getAttribute("idx")));
		System.out.println("cp_idx???"+Integer.parseInt(request.getParameter("cp_idx")));
		System.out.println("mi_idx???"+Integer.parseInt(request.getParameter("mi_idx")));
		
		int mb_idx = Integer.parseInt((String)session.getAttribute("idx"));
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		int mi_idx = Integer.parseInt(request.getParameter("mi_idx"));
		
		MemberDAO mb_dao = new MemberDAO();
		result = mb_dao.deleteInvest(mb_idx, cp_idx, mi_idx);
		
		if(result == 0){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('투자 철회하기에 실패했습니다.\n다시 시도해주세요.');");
			out.println("window.close()");
//			out.println("opener.location.replace('./Mypage4_1.mb')");
			out.println("opener.location.replace('./MemberInvestmentList.mb?mi_idx="+mi_idx+"')");
//			out.println("location.href='./MemberInvestmentList.mb';");
			out.println("</script>");
			out.close();
			
			return null;
		}else {
			mb_dao = new MemberDAO();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('투자 철회하기가 완료되었습니다.');");
			out.println("window.close()");
//			out.println("opener.location.replace('./Mypage4_1.mb')");
			out.println("opener.location.replace('./MemberInvestmentList.mb?mi_idx="+mb_dao.Member_Invest_check(mb_idx)+"')");
//			out.println("location.href='./MemberInvestmentList.mb';");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
	}

}
