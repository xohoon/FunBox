package net.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberBean;
import net.member.function.Md5_SecretCode;
import net.member.function.Sha1_SecretCode;

///////////////////////유정 추가///////////////////////
public class MemberUpdateAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		MemberBean member = new MemberBean();
		boolean result = false;
		HttpSession session = request.getSession();

		String id = (String)session.getAttribute("id");
		String email = request.getParameter("new_mail");
		String pw = request.getParameter("new_pw");
		String pin = request.getParameter("new_pin"); 
		String ph = request.getParameter("new_ph");
		String add_num = request.getParameter("add_num");
		String add_ch = request.getParameter("add_ch");
		String add_more = request.getParameter("add_more");
		String add_extra = request.getParameter("add_extra");
		
		
		
		/////////////////// 수정하지 않는 회원 정보 ///////////////////
			
		if(email.equals("")) {
			email = request.getParameter("mail");
		}else if(add_num.equals("")) {
			add_num = request.getParameter("add_num");
		}else if(add_ch.equals("")) {
			add_ch = request.getParameter("add_ch");
		}else if(add_more.equals("")) {
			add_more = request.getParameter("add_more");
		}else if(add_extra.equals("")) {
			add_extra = request.getParameter("add_extra");
		}
		//System.out.println("add_ch: "+add_ch);
		
		//비밀번호 암호화
		if(pw.equals("")) {
			pw = request.getParameter("h_pw");
		}else {
			pw = Sha1_SecretCode.sha1(pw);
			pw = Md5_SecretCode.md5(pw);
		}
		
		//tx비밀번호 암호화
		if(pin.equals("")) {
			pin = request.getParameter("h_pin");
		}else {
			pin = Sha1_SecretCode.sha1(pin);
			pin = Md5_SecretCode.md5(pin);
		}
		
		//휴대폰번호
		if(ph.equals("")) {
			ph = request.getParameter("ph");
		}else {
			if (ph.length() >= 8 && ph.length() < 11) {
				if (ph.substring(0, 2).equals("10") && ph.length() > 8) {
					ph = "0" + ph;
				}
				if (ph.length() <= 8) {
					ph = "010" + ph;
				}
			//	System.out.println("휴대폰 번호 : "+ ph);
			} 
		}
		
		/////////////////// 수정하지 않는 회원 정보 ///////////////////
		
		
		member.setId(id);
		member.setEmail(email);
		member.setPw(pw);
		member.setPin(pin);
		member.setPh(ph);
		member.setAdd_num(add_num);
		member.setAdd_ch(add_ch);
		member.setAdd_more(add_more);
		member.setAdd_extra(add_extra);
		
		MemberDAO member_dao = new MemberDAO();
		result = member_dao.updateMember(member);
		
		if(result==false){
		//	System.out.println("개인정보수정 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('개인정보수정에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./Mypage4_2.mb';");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
	//	System.out.println("개인정보수정 성공");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('개인정보수정이 완료되었습니다.');");
		out.println("location.href='./Index.mb';");
		out.println("</script>");
		out.close();
		
		return null;
	}
}
