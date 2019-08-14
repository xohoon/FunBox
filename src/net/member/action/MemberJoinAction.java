package net.member.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MemberBean;
import net.member.function.Md5_SecretCode;
import net.member.function.Sha1_SecretCode;

///////////////////////유정 추가///////////////////////
public class MemberJoinAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		MemberBean member = new MemberBean();
		boolean result = false;
		
		int ag3 = 0;
		int ag4 = 0;
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pin = request.getParameter("pin");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String ph = request.getParameter("ph");
		String add_num = request.getParameter("add_num");
		String add_ch = request.getParameter("add_ch");
		String add_more = request.getParameter("add_more");
		String add_extra = request.getParameter("add_extra");
		String reco = request.getParameter("reco");

		if(request.getParameter("ag3") != null) {
			ag3 = Integer.parseInt(request.getParameter("ag3"));
		}else {
		//	System.out.println("회원가입 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./JoinPage.mb';");
			out.println("</script>");
			out.flush();
		}
		
		if(request.getParameter("ag4") != null) {
			ag4 = Integer.parseInt(request.getParameter("ag4"));
		}else {
		//	System.out.println("회원가입 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./JoinPage.mb';");
			out.println("</script>");
			out.flush();
		}
		
		
		if (ph.length() >= 8 && ph.length() < 11) {
			if (ph.substring(0, 2).equals("10") && ph.length() > 8) {
				ph = "0" + ph;
			}
			if (ph.length() <= 8) {
				ph = "010" + ph;
			}
		} 
		
	//	System.out.println("휴대폰 번호 : "+ ph);
		
		
		
		if(reco.equals("")) {
			reco = null;
		}
		
		
		//비밀번호 암호화
		pw = Sha1_SecretCode.sha1(pw);
		pw = Md5_SecretCode.md5(pw);
		
		//tx비밀번호 암호화
		pin = Sha1_SecretCode.sha1(pin);
		pin = Md5_SecretCode.md5(pin);
		
		member.setId(id);
		member.setPw(pw);
		member.setPin(pin);
		member.setEmail(email);
		member.setName(name);
		member.setPh(ph);
		member.setAdd_num(add_num);
		member.setAdd_ch(add_ch);
		member.setAdd_more(add_more);
		member.setAdd_extra(add_extra);
		member.setReco(reco);
		member.setAgree1(ag3);
		member.setAgree2(ag4);
		
		
		MemberDAO member_dao = new MemberDAO();
		result = member_dao.insertMember(member);
		
		if(result==false){
			//System.out.println("회원가입 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./JoinPage.mb';");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
	//	System.out.println("회원가입 성공");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입이 완료되었습니다.');");
		out.println("location.href='./LoginPage.mb';");
		out.println("</script>");
		out.close();
		
		return null;
	}
}
