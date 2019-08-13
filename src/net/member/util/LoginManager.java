package net.member.util;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LoginManager implements HttpSessionListener{
	private static LoginManager loginManager = null;
	
	// 로그인한 접속자를 담기 위한 해시테이블
	private static Hashtable loginUsers = new Hashtable();
	
	// 싱글톤 패턴 사용
	public static synchronized LoginManager getInstance() {
		if(loginManager == null) {
			loginManager = new LoginManager();
		}
		return loginManager;
	}
	
	/*
	 * 세션이 끊겼을 때 호출(invalidate)
	 * Hashtable에 저장된 로그인한 정보를 제거
	 * 
	 */
	public void valueUnbound(HttpSessionBindingEvent event) {
		// session값을 찾아서 없애준다
		loginUsers.remove(event.getSession());
		System.out.println("::"+event.getName()+"님이 로그아웃 하셨습니다.");
		System.out.println("현재 접속자 수 ::"+getUserCount());
	}
	
	/*
	 * 입력받은 아이디를 해시테이블에서 삭제
	 * @param userID 사용자 아이디
	 * @return void
	*/
	public void removeSession(String userID) {
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		while(e.hasMoreElements()) {
			session = (HttpSession)e.nextElement();
			if(loginUsers.get(session).equals(userID)) {
				session.invalidate();
			}
		}
	}
	
	/*
	 * 사용자가 입력한 ID, PW가 맞는지 확인하는 메소드
	 * @param userID 사용자 아이디
	 * @param userPW 사용자 패스워드
	 * @return boolean ID/PW가 일치하는지 여부
	*/
	
	public boolean isValid(String userID, String userPW) {
		
		/*
		 * DB로직이 들어간다
		*/
		String id = "test09";
		String pw = "qwer1234";
		
		if(userID.equals(id) && userPW.equals(pw)) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * 해당 아이디의 동시 사용을 막기위해
	 * 이미 사용중인 아이디인지 확인
	 * @param userID
	 * @return boolean 이미 사용중 true, 사용중 아니면 false
	*/
	public boolean isUsing(String userID) {
		return loginUsers.containsValue(userID);
	}
	
	/*
	 * 로그인을 완료한 사용자의 아이디를 세션에 저장하는 메소드
	 * @param session세션 객체
	 * @param userID 사용자 아이디
	*/
	public void setSession(HttpSession session, String userID) {
		
		// login에 자기자신을 넣는다
		session.setAttribute(userID, "");
	}
	
	/*
	 * 입력받은 세션 Object로 아이디를 리턴
	 * @param session : 접속한 사용자의 session Object
	 * @return String 접속자 아이디
	*/
	public String getUserID(HttpSession session) {
		return (String)loginUsers.get(session);
	}
	
	/*
	 * 현재 접속한 사용자 수
	 * @return int 현재 접속자 수
	*/
	public int getUserCount() {
		return loginUsers.size();
	}
	
	/*
	 * 현재 접속중인 모든 사용자 아이디를 출력
	 * @return void
	*/
	public void printloginUsers() {
		Enumeration e = loginUsers.keys();
		HttpSession session = null;
		System.out.println("--------------");
		int i = 0;
		while(e.hasMoreElements()) {
			session = (HttpSession)e.nextElement();
			System.out.println((++i)+"접속자 :: "+loginUsers.get(session));
		}
		System.out.println("--------------");
	}
	
	/*
	 * 현재 접속중인 모든 사용자리스트를 리턴
	 * @return list
	*/
	public Collection getUsers() {
		Collection collection = loginUsers.values();
		return collection;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
















