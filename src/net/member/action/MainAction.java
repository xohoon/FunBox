package net.member.action;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;

///////////////////////유정 추가///////////////////////
public class MainAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}
}
