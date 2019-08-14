package net.member.action;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;

///////////////////////유정 추가///////////////////////
public class MemberIDCheckAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		JSONObject jsondata = new JSONObject();
		String receiveId = request.getParameter("sendId");
          
        
        MemberDAO dao = new MemberDAO();
        boolean result = dao.duplicateIdCheck(receiveId);
        
        
        if(result){
        	//System.out.println("아이디가 존재합니다.");
        	jsondata.put("result", "id_check_fail");// 사용자 있으면 1을
        }else{
        	jsondata.put("result", "id_check_success");// 없으면 0을 반환.
        }
        
        response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
        
        return null;
	}
}
