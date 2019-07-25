package net.company.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.member.dto.MemberInvestVO;

// 유정 추가
// 투자하기 전 확인 페이지
public class InvestAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		MemberInvestVO member_invest = new MemberInvestVO();
		boolean result = false;

		System.out.println("InvestAction OK!");
		
		int mb_idx = Integer.parseInt(request.getParameter("mb_idx"));
		String mb_id = request.getParameter("mb_id");
		String mi_category = request.getParameter("mi_category");
		String cp_name = request.getParameter("cp_name");
		String cp_branch = request.getParameter("cp_branch");
		String mi_point = request.getParameter("point");
		String mi_hoiling_stock = request.getParameter("amount");
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));

		member_invest.setMi_idx(mb_idx);
		member_invest.setMb_id(mb_id);
		member_invest.setMi_category(mi_category);
		member_invest.setName(cp_name);
		member_invest.setMi_branch(cp_branch);
		member_invest.setPoint(mi_point);
		member_invest.setHoiling_stock(mi_hoiling_stock);
		member_invest.setCp_idx(cp_idx);
		
		CompanyDAO company_dao = new CompanyDAO();
		result = company_dao.MemberInvest(member_invest);
		
		if(result==false){
			System.out.println("투자하기 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('투자에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./CorporationAction.cp';");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		System.out.println("투자하기 성공");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('투자가 완료되었습니다.');");
		out.println("location.href='./MemberInvestmentList.mb';");
		out.println("</script>");
		out.close();
		
		return null;
	}

}
