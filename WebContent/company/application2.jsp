<%@page import="net.company.dto.ApplicationVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 한글처리
	ApplicationVO company = (ApplicationVO)request.getAttribute("company");
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
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/html5.js"></script>
  <script src="company/js/application_functions.js"></script>
</head>
<!--head-->

<body>
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form class="application" name="application02" method="post" action="./Application02Action.cp">
    <input type="hidden" name="name" id="name" value="<%=company.getApp_cp_name()%>">
    <input type="hidden" name="manager" id="manager" value="<%=company.getApp_cp_manager()%>">
    <input type="hidden" name="phone" id="phone" value="<%=company.getApp_cp_hp()%>">
    <input type="hidden" name="num" id="num" value="<%=company.getApp_cp_num()%>">
    <input type="hidden" name="ch" id="ch" value="<%=company.getApp_cp_num()%>">
    <input type="hidden" name="more" id="more" value="<%=company.getApp_cp_more()%>">
    <input type="hidden" name="extra" id="extra" value="<%=company.getApp_cp_extra()%>">
    <input type="hidden" name="sector" id="sector" value="<%=company.getApp_cp_sector()%>">
    <input type="hidden" name="open_datetime" id="open_datetime" value="<%=company.getApp_cp_open_date_time()%>">
    <input type="hidden" name="prestige" id="prestige" value="<%=company.getApp_cp_prestige()%>">
    <input type="hidden" name="deposit" id="deposit" value="<%=company.getApp_cp_deposit()%>">
    <input type="hidden" name="monthly" id="monthly" value="<%=company.getApp_cp_monthly()%>">
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
     	<div class="active">
     		<span></span>step2
     	</div>
     	<div>
     		<span></span>step3
     	</div>
     	<div>
     		<span></span>step4
     	</div>
     </div><!--.step-->
     <div class="step2">
      	<div id="app8-group" class="group cf">
			<label for="app8">목표 투자 금액</label>
			<input type="text" id="goal_amount" name="goal_amount" placeholder="">
		  </div><!--#app8-->
		  <div id="app9-group" class="group cf">
			<label for="app9">평균 월 매출액</label>
			<input type="text" id="avg_monthly_profit" name="avg_monthly_profit" placeholder="오픈 예정일 경우 예상 월 매출액">
		  </div><!--#app9-->
		   <div id="app10-group" class="group cf">
			<label for="app10">월 수익률</label>
			<input type="text" id="monthly_profit" name="monthly_profit" placeholder="오픈 예정일 경우 예상 월 수익률">
		  </div><!--#app10-->
		  <div id="app11-group" class="group cf">
			<label for="app11">투자 모집 기간</label>
			<input type="text" id="during" name="during" placeholder="">
		  </div><!--#app11-->
		  <div id="app12-group" class="group cf">
			<label for="app12">투자 최소 금액</label>
			<input type="text" id="inv_min_amount" name="inv_min_amount" placeholder="">
			<span>입력한 값은 예상치로 심사 후 최종결정됩니다.</span>
		  </div><!--#app5-->
    	  <div class="cf">
     	  <input type="button" class="next" value="다음" onclick="company_join_app02();">
     	  <input type="button" class="prev" value="이전으로" onclick="history.go(-1);">
     	  </div>
      </div><!--.step2-->
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