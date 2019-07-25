package net.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.Main_LikeVO;
import net.member.dto.Main_SlideVO;

///////////////////////유정 추가///////////////////////
public class MainAction implements Action {
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		MemberDAO slideDAO = new MemberDAO();
		List<Main_SlideVO> slideVO = slideDAO.Main_SlideInfo();
		MemberDAO likeDAO = new MemberDAO();
		List<Main_LikeVO> likeVO = likeDAO.Main_LikeInfo();
		
		request.setAttribute("likeVO", likeVO);
		request.setAttribute("slideVO", slideVO);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./index.jsp");
		return forward;
	}
}
