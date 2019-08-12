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
	String userID = request.getParameter("userID");
	String userPW = request.getParameter("userPW");
	
	// 아이디 패스워드 체크
	if(loginManager.isValid(userID, userPW)) {
		session.setAttribute("userID", userID);
		
		out.println(userID);
		loginManager.printloginUsers();
		if(loginManager.isUsing(userID)) {
			%>
			<a href="disconnect.jsp">예</a>
			<a href="login_test.jsp">아니오</a>
			<%
		}else {
			loginManager.setSession(session, userID);
			response.sendRedirect("login_ok.jsp");
		}
	}else {
		%>
		<script>
			alert("로그인 후 이용해주세요");
			location.href="login_test.jsp";
		</script>
		<%
	}
		
%>


</body>
</html>