<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="net.member.util.LoginManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 중복 로그인 테스트
	LoginManager loginManager = LoginManager.getInstance();
	session.removeAttribute("userID");
%>
<h2 align="center">접속자 수 :: <%=loginManager.getUserCount() %>명</h2>
<form action="./Login_try.jsp" name="login">
	<div align="center">
		아이디 :: <input type="text" name="userID"><br>
		비밀번호 :: <input type="password" name="userPW"><br>
		<input type="submit" value="로그인">
	</div>
</form>
</body>
</html>