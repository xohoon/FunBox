package net.member.ajax;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.nexmo.client.NexmoClientException;

import net.member.dao.MemberDAO;
import net.member.function.Md5_SecretCode;
import net.member.function.NexmoSms;
import net.member.function.Sha1_SecretCode;

///////////////////////유정 추가///////////////////////
public class NewTxSms extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "static-access", "unchecked" })
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // utf-8 인코딩
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		System.out.println("문자 전송 시작 ");
		JSONObject jsondata = new JSONObject();
		String uuid = null;
		String newtx = null;
		NexmoSms sms = new NexmoSms();
		String phonenum = sms.phoneNumber_format(request.getParameter("phone"));
		String mb_id = request.getParameter("mb_id");
		String mb_pw = request.getParameter("mb_pw");
		boolean re = false;
		Sha1_SecretCode sha1 = new Sha1_SecretCode();
		Md5_SecretCode md5 = new Md5_SecretCode();

		try {
			mb_pw = sha1.sha1(mb_pw);
			mb_pw = md5.md5(mb_pw);
			
		}catch(Exception e) {
			System.out.println("패스워드 암호화 오류 : " + e);
		}
		
		MemberDAO dao = new MemberDAO();
		String select_id = dao.get_FindTx_id(mb_id);
		
		MemberDAO dao2 = new MemberDAO();
		String select_pw = dao2.get_FindTx_pw(mb_id, mb_pw);
		
		MemberDAO dao3 = new MemberDAO();
		String select_phone = dao3.get_FindTx_phone(mb_id, request.getParameter("phone"));
		
		
		if (select_id == null) {	// 아이디가 존재하지 않을 때

			jsondata.put("result", "find_tx_id_fail");
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jsondata);

		} else {	// 아이디가 존재할 때
			
			if(select_pw == null) {
				
				jsondata.put("result", "find_tx_pw_fail");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jsondata);
			} else if(select_phone == null) {
				
				jsondata.put("result", "find_tx_phone_fail");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jsondata);
			} else {
			
				uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
				uuid = uuid.substring(0, 8); // uuid를 앞에서부터 10자리 잘라줌.
				System.out.println(uuid);
			
			try {
				newtx = sha1.sha1(uuid);
				newtx = md5.md5(newtx);
				
				MemberDAO dao4 = new MemberDAO();
				
				//새 패스워드 디비 없데이트
				re = dao4.setNewTx(mb_id, newtx);
				

				sms.sms2("82" + phonenum, "FunBox Temporary Pin Code. [" + uuid + "]");

			} catch (NexmoClientException e) {
				// TODO Auto-generated catch block
				System.out.println("문자 전송 오류 : " + e);
				jsondata.put("result", "sms_fail");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jsondata);

			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				System.out.println("pin code 재발급 실패 : " + e);
				jsondata.put("result", "change_tx_fail");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jsondata);
				e.printStackTrace();
			}

			if (re == false) {
				System.out.println("pin code 변경 실패  ");
				jsondata.put("result", "change_tx_fail");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jsondata);
			} else {
				jsondata.put("result", "good");
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jsondata);
			}
			}
		}

	}
}