<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@page import="net.company.dto.ApplicationVO"%> --%>
<%
	request.setCharacterEncoding("utf-8"); // 한글처리
	/* ApplicationVO company = (ApplicationVO) request.getAttribute("company"); */
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
  <script type="text/javascript" src="./company/js/application_functions.js"></script>
</head>
<!--head-->

<body>
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form id="form" class="application" method="post" enctype="multipart/form-data" action="./comapny_application_file_upload.cp">
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
    <input type="hidden" name="app_cp_introduction" id="app_cp_introduction" value="${company.app_cp_introduction }">
    <input type="hidden" name="app_cp_purpose" id="app_cp_purpose" value="${company.app_cp_purpose }">
    <input type="hidden" name="app_cp_point" id="app_cp_point" value="${company.app_cp_point }">
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
     	<div>
     		<span></span>step3
     	</div>
     	<div class="active">
     		<span></span>step4
     	</div>
     </div><!--.step-->
     <div class="step4">
	 	<div id="app16-group" class="group cf">
			<label>필수 제출 서류</label>
			<span>사업자 등록증</span>
			<label for="yet1">오픈 전 매장입니다.</label>
			<input type="checkbox" name="yet1" id="yet1">
			<input type="file" name="app_cp_registrantion" id="app_cp_registrantion">
			<span>재무제표</span>
			<label for="yet1">오픈 전 매장입니다.</label>
			<input type="checkbox" name="yet2" id="yet2">
			<input type="file" name="app_cp_financial" id="app_cp_financial">
			<span>부동산 계약서</span>
			<label for="yet1">오픈 전 매장입니다.</label>
			<input type="checkbox" name="yet3" id="yet3">
			<input type="file" name="app_cp_estate_contract" id="app_cp_estate_contract">
			<span>매장사진(최소 3장)</span>
			<label for="yet1">오픈 전 매장입니다.</label>
			<input type="checkbox" name="yet4" id="yet4">
			<input type="file" multiple name="app_cp_images" id="app_cp_images">
			<p>* 오픈 예정 매장일 경우, 본 프랜차이즈 매장 중 영업 및 입지조건이 비슷한 타 가맹점 최소 2개의 가맹점 자료 첨부.<br>비교 대상 부재 등 자료 첨부가 어려울 경우 생략 가능</p>
		  </div><!--#app8-->
		  <div id="app17-group" class="group cf">
			<label>기타 제출 서류</label>
			<span>결산장부, 법인등기부등본, 정관, 주주명부 등</span>
			<input type="file" multiple name="app_cp_other_documents" id="app_cp_other_documents">
			<p>* 기타서류 제출 시 심사에 반영됩니다.</p>
		  </div><!--#app8-->
		  <input type="checkbox" id="app18">
		  <label for="app18">[필수] 위 정보제공에 동의합니다.</label>
		  <div class="cf">
		  <input type="button" class="submit" value="제출하기">
		  <input type="button" class="prev" value="이전으로"  onclick="history.go(-1);">
		  </div>
	 </div><!--.step4-->
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