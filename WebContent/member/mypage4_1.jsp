<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title></title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/jquery.bxslider.css" rel="stylesheet">
  <link href="css/HF.css" rel="stylesheet" type="text/css">
  <link href="css/mypage.css" rel="stylesheet">
  <link href="css/list_box.css" rel="stylesheet">
  
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="member/js/mypage4_1.js"></script>
  <script src="member/js/investment_status.js"></script>
</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    <section>
    	<div class="like_box"></div>
   		<input type="hidden" value="${sessionScope.id }" id="session_value">
    	<ul class="tab">
    		<li id="invest_check">투자현황</li>
    		<li onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li class="on" onclick="location.href='./Mypage4_1.mb'">내정보</li>
		</ul>
   		<div class="entry">
   			<h5>비밀번호 입력</h5>
   			<p>본인확인을 위해 비밀번호를 입력해주세요.</p>
   			<form id="mypage4_1_form" name="mypage4_1_form" method="post" action="./Mypage4_2.mb">
   			<div>
   				<label for="pw">비밀번호</label>
   				<input type="password" id="pw" name="pw" maxlength="15" onKeyUp="press_event();">
   				<input style="VISIBILITY: hidden; WIDTH: 0px">
   			</div>
   			<input type="button" class="submit" value="입장하기" onclick="mypage4_1_check();">
   			</form>
   		</div>
    </section>

    <footer></footer>
  </div>
	
</body>
<script type="text/javascript" src="member/js/investment_status.js"></script>
</html>
