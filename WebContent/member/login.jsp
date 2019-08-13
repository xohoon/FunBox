<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">


<head>
  <meta charset="utf-8">
  <title>FUNBOX 로그인</title>
  <link href="css/common.css" rel="stylesheet">
  <link href="css/form.css" rel="stylesheet">
  <script src="member/js/login.js"></script>
</head>
<!--head-->

<body>
<!-- 아이디 저장 체크할 때 쿠키에 7일간 저장합니다 -->
<%
	Cookie[] id = request.getCookies();
	String cookieVal="";
	if(id != null){
		for(Cookie i : id){
			if(i.getName().equals("saveId")){
				cookieVal=i.getValue();
			}
		}
	}
%>
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form id="login_form" name="login_form" method="post" action="./MemberLoginAction.mb">
    <h3>로그인</h3>
     <div id="intro">
        <p class="tt1">
            안녕하세요.<br>
            <span>Funbox</span> 입니다.
        </p>
        <p class="tt2">
            아직 펀박스 회원이 아니신가요?
            <a href="./JoinPage.mb" target="_self">회원가입하기</a>
        </p>
     </div><!--#intro-->
      <div id="id-group" class="group cf">
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" maxlength="15" value="<%=cookieVal != ""? cookieVal : "" %>" placeholder="아이디를 입력하세요">
      </div>
      <!--#id-->
      <div id="pw-group" class="group cf">
        <label for="pw">비밀번호</label>
        <input type="password" id="pw" name="pw" maxlength="15" placeholder="비밀번호를 입력하세요" onKeyUp="press_event()">
      </div>
      <!--pw-->
      <input type="button" class="submit" value="로그인하기" onclick="login_check();">
      <div class="sch cf">
        <input type="checkbox" id="load_id" name="saveId" <%=cookieVal != ""? "checked" : "" %>> <label for="load_id">아이디 저장</label>
        <ul>
            <li><a href="./Find_id.mb" target="_blank">아이디 찾기</a></li>
            <li><a href="./Find_pw.mb" target="_blank">비밀번호 찾기</a></li>
            <li><a href="./Find_pin.mb" target="_blank">Pin 찾기</a></li>
        </ul>
     </div><!--#intro-->
    </form>
    <footer>
        <ul>
            <li><a href="./Policy_1.bd">이용안내</a></li>
            <li><a href="./Notice.bd">공지사항</a></li>
        </ul>
        <p>
            Copyright ⓒ 2019 IOLAB. All rights reserved.
        </p>
    </footer>
  </div><!--#wrap-->
  <script src="js/html5.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
</body></html>