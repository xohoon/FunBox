<%-- <%@page import="net.company.action.CompanyApplication02Action"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page import="net.company.dto.ApplicationVO"%> --%>
<%
	request.setCharacterEncoding("utf-8"); // 한글처리
/* 	ApplicationVO company = (ApplicationVO)request.getAttribute("company"); */
%>
  
<!doctype html>
<html lang="ko">

 <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">


<head>
  <meta charset="utf-8">
  <title>FUNBOX 기업신청</title>
  <link href="css/common.css" rel="stylesheet">
  <link href="css/form.css" rel="stylesheet">
  <script type="text/javascript" src="./js/jquery-3.1.1.min.js"></script>
  <script src="company/js/application_functions.js"></script>
</head>
<!--head-->

<body>
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form class="application" name="application3_form" action="./Application03Action.cp" method="post">
    <input type="hidden" name="name" id="name" value="${company.app_cp_name }">
    <input type="hidden" name="manager" id="manager" value="${company.app_cp_manager }">
    <input type="hidden" name="phone" id="phone" value="${company.app_cp_hp }">
    <input type="hidden" name="num" id="num" value="${company.app_cp_num }">
    <input type="hidden" name="ch" id="ch" value="${company.app_cp_ch }">
    <input type="hidden" name="more" id="more" value="${company.app_cp_more }">
    <input type="hidden" name="extra" id="extra" value="${company.app_cp_extra }">
    <input type="hidden" name="sector" id="sector" value="${company.app_cp_sector }">
    <input type="hidden" name="open_datetime" id="open_datetime" value="${company.app_cp_open_date_time }">
    <input type="hidden" name="prestige" id="prestige" value="${company.app_cp_prestige }">
    <input type="hidden" name="deposit" id="deposit" value="${company.app_cp_deposit }">
    <input type="hidden" name="monthly" id="monthly" value="${company.app_cp_monthly }">
    <input type="hidden" name="status" id="status" value="${company.app_cp_status }">
    <input type="hidden" name="goal_amount" id="goal_amount" value="${company.app_cp_goal_amount }">
    <input type="hidden" name="avg_monthly_profit" id="avg_monthly_profit" value="${company.app_cp_avg_monthly_profit }">
    <input type="hidden" name="monthly_profit" id="monthly_profit" value="${company.app_cp_monthly_profit }">
    <input type="hidden" name="during" id="during" value="${company.app_cp_during }">
    <input type="hidden" name="inv_min_amount" id="inv_min_amount" value="${company.app_cp_inv_min_amount }">
    
    <h3>투자기업신청</h3>
     <div id="intro">
        <p class="tt1">
            안녕하세요.<br>
            <span>Funbox</span> 입니다.
        </p>
        <p class="tt2">
            기업정보를 입력해주세요
        </p>
     </div><!--#intro-->
     <div class="step">
     	<div>
     		<span></span>step1
     	</div>
     	<div>
     		<span></span>step2
     	</div>
     	<div class="active">
     		<span></span>step3
     	</div>
     	<div>
     		<span></span>step4
     	</div>
     </div><!--.step-->
     <div class="step3">
      	<div id="app13-group" class="group cf">
			<label>기업소개 및 사업계획</label>
			<span>200자 이내로 입력해주세요</span>
			<textarea cols="20" rows="15" maxlength="300" name="introduction"></textarea>
		  </div><!--#app13-->
		  <div id="app14-group" class="group cf">
			<label>투자 모집 목적</label>
			<span>200자 이내로 입력해주세요</span>
			<textarea cols="20" rows="15" maxlength="300" name="purpose"></textarea>
		  </div><!--#app14-->
		 <div id="app15-group" class="group cf">
				<label>투자 포인트</label>
				<span>200자 이내로 입력해주세요</span>
				<textarea cols="20" rows="15" maxlength="300" name="point" placeholder="귀하의 투자상품(창업아이템)이 수익률이 높을 것이라고 예상되는 이유 및 투자 포인트를 기입해주세요."></textarea>
			  </div><!--#app15-->
			  <div class="cf">
			  <input type="button" class="next" value="다음"  onclick="application3_check();">
			  <input type="button" class="prev" value="이전으로"  onclick="history.go(-1);">
			  </div>
		  </div><!--.step3-->
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
</body></html>