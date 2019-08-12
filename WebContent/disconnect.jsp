<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="net.member.util.LoginManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	LoginManager loginManager = LoginManager.getInstance();
	String userID = (String)session.getAttribute("userID");
	
	if(userID != null) {
		// 기존 접속 끊는다
		loginManager.removeSession(userID);
		//새로운 세션 등록
		loginManager.setSession(session, userID);
		response.sendRedirect("login_ok.jsp");
	}
%>

</body>
</html>