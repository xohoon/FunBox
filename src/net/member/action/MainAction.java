package net.member.action;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

public class MainAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		// 유정 추가 - 지도에서 지역별로 매장 개수 가져오기
		/*String location = request.getParameter("selectedValue");
		System.out.println("location: "+location);
		
		MemberDAO mb_dao = new MemberDAO();
		int count = mb_dao.getLocationCount(location);

		request.setAttribute("count", count);*/
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}
}
