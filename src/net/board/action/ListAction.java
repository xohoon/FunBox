package net.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
//유정 추가
public class ListAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		System.out.println("ListAction OK");
		
		ActionForward forward = new ActionForward();
		
		
		String cityName = (String)request.getAttribute("cityName");
		request.setAttribute("cityName", cityName);
		
		forward.setRedirect(false);
		forward.setPath("./board/list.jsp");
		return forward;
	}
}
