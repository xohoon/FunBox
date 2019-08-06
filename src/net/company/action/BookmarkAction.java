package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.LikeBoxVO;

public class BookmarkAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		HttpSession session = request.getSession();
		LikeBoxVO like_box = new LikeBoxVO();
		JSONObject jsondata = new JSONObject();
		boolean result = false;

		String mb_idx = (String)session.getAttribute("idx");
		int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		String cp_name = (String)request.getParameter("cp_name");
		
		int val = Integer.parseInt(request.getParameter("val"));
		
		like_box.setMb_idx(mb_idx);
		like_box.setCp_idx(cp_idx);
		like_box.setLike_cp_name(cp_name);
		
		if(val == 1) {
			CompanyDAO cp_dao1 = new CompanyDAO();
			result = cp_dao1.insertLikeBox(like_box);
			if(result == true) {
				jsondata.put("result", "add_likebox_success");
			}else {
				jsondata.put("result", "add_likebox_fail");
			}
		}else {
			CompanyDAO cp_dao2 = new CompanyDAO();
			result = cp_dao2.deleteLikeBox(cp_idx, mb_idx);
			if(result == true) {
				jsondata.put("result", "remove_likebox_success");
			}else {
				jsondata.put("result", "remove_likebox_fail");
			}
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
    	
		return null;
	}
}
