<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
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
		%>
		<%=userID %>님 환영합니다.
		<a href="logout.jsp">로그아웃</a>
		<p>
		현재 접속자 ::: <br>
		<%
		Collection collection = loginManager.getUsers();
		Iterator iterator = collection.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			out.println((++i)+",  "+iterator.next()+"<br>");
		}
	}else {
		%>
		<script>
			alert("로그인 후 이용해주세요1");
			location.href="login_test.jsp";
		</script>
		<%
	}
%>

</body>
</html>