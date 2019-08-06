package net.member.util;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/// 태훈 추가 - 웹소켓 통신 이용 실시간 인기순위
@ServerEndpoint("/websocket")
public class Socket_Handler {
	
	// 웹 소켓 연결되면 호출되는 이벤트
	@OnOpen
	public void handleOpen() {
		System.out.println("client is noe connec......");
	}
	/*
	*웹 소켓으로부터 메시지 오면 호출되는 이벤트
	*@param message
	*@return
	*/
	@OnMessage
	public String handleMessage(String message) {
		System.out.println("receive from client ::: " + message);
		String replymessage = "echo" + message;
		System.out.println("send to client :::" + replymessage);
		
		return replymessage;
	}
	
	// 웹 소켓 닫히면 호출
	@OnClose
	public void handleClose() {
		System.out.println("client is now disconnec.....");
	}
	
	// 에러나면 호출
	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}
	
}
