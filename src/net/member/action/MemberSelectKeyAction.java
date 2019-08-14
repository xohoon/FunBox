package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

// 태훈 추가 실시간 수동 자동 확인 후 데이터 뿌려줌
public class MemberSelectKeyAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		@SuppressWarnings("unused")
		ActionForward forward = new ActionForward();
		MemberDAO memberDAO = new MemberDAO();
		JSONArray JSONarray = new JSONArray();
		ArrayList<String> list = new ArrayList<String>();
		//System.out.println("위치테스트>>>"+Integer.parseInt(request.getParameter("select_key")));
		int select_key = Integer.parseInt(request.getParameter("select_key"));
		// 수동인지 자동인지 확인
		if(select_key == 0) {
			select_key = memberDAO.getSelectKey();
		}
		
		if(select_key == 1) {
			list = memberDAO.getRealList(select_key);
		}
		
		/* 수동 - 관리자 페이지 만들때 추가
		 * else if(select_key == 2) {
		 * 	list = memberDAO.getManagerList(select_key);
		 * }
		 */
		
		JSONarray.addAll(list);
		
		response.setContentType("application/x-json;charset=UTF-8");
    	response.getWriter().print(JSONarray);
		
		return null;
	}

}
