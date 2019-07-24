<%@page import="net.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Funbox CheckToPhone</title>

<%
	String ph = (String)request.getParameter("ph");
	String ph2 = (String)request.getParameter("ph");
	
	if (ph2.length() >= 8 && ph2.length() < 11) {
		if (ph2.substring(0, 2).equals("10") && ph2.length() > 8) {
			ph2 = "0" + ph2;
		}
		if (ph2.length() <= 8) {
			ph2 = "010" + ph2;
		}
	} 
	
	
	
	MemberDAO dao = new MemberDAO();
	boolean re = dao.duplicatePhoneCheck(ph,ph2);
	if(!re){
		out.println("사용가능");
	}else{
		out.println("중복됨");
	}
%>

<%=re%>
