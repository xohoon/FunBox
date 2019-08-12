package net.company.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.member.dao.MemberDAO;

// 박신규 짱~
// 투자하기 전 확인 페이지
public class InvestAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		
		//HttpSession session = request.getSession();
		//String _mb_id = (String)session.getAttribute("id");
		
		CompanyDAO companyDAO = new CompanyDAO();
		int _mb_idx = Integer.parseInt(request.getParameter("mb_idx"));
		int _cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		int _po_amount = Integer.parseInt(request.getParameter("point"));
		String _mi_hoiling_stock = request.getParameter("amount");
		String _cp_name = request.getParameter("cp_name");
		
		//System.out.println(_mb_idx+_cp_idx+_cp_name+_po_amount+_mi_hoiling_stock);
		
		if (companyDAO.invest(_mb_idx, _cp_idx,_cp_name ,_po_amount,_mi_hoiling_stock)) {
			MemberDAO memberDAO = new MemberDAO();
			int mi_idx = memberDAO.Member_Invest_check(_mb_idx);
			System.out.println("투자하기 성공");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('투자가 완료되었습니다.');");
			out.println("location.href='./MemberInvestmentList.mb?mi_idx="+mi_idx+"';");
			out.println("</script>");
			out.close();

			return null;
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('투자에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./CorporationAction.cp';");
			out.println("</script>");
			out.close();

			return null;
		}

	}

}
