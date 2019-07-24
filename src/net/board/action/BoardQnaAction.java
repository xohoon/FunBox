package net.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.board.dao.QnaDAO;
import net.board.dto.QnaVO;
import net.common.action.Action;
import net.common.action.ActionForward;

///////////////////////유정 추가///////////////////////
public class BoardQnaAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		QnaVO qna = new QnaVO();
		boolean result = false;
		
		int ag_e = 0;
		int ag_p = 0;
		
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(request.getParameter("ag_e") != null) {
			ag_e = Integer.parseInt(request.getParameter("ag_e"));
		}
		
		if(request.getParameter("ag_p") != null) {
			ag_p = Integer.parseInt(request.getParameter("ag_p"));
		}
		
		
		qna.setId(id);
		qna.setCategory(category);
		qna.setName(name);
		qna.setEmail(email);
		qna.setMobile(mobile);
		qna.setTitle(title);
		qna.setContent(content);
		qna.setEmail_chk(ag_e);
		qna.setMobile_chk(ag_p);
		
		
		QnaDAO qna_dao = new QnaDAO();
		result = qna_dao.insertQna(qna);
		
		
		
		if(result==false){
			System.out.println("문의하기 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('문의 등록에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./BoardQnaList.bd';");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
		System.out.println("문의하기 성공");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('문의가 등록되었습니다.');");
		out.println("location.href='./BoardQnaList.bd';");
		out.println("</script>");
		out.close();
		
		

		return null;
	}
}
