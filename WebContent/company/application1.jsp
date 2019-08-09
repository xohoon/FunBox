<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 한글처리
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
  <script src="js/html5.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="company/js/application_functions.js"></script>
  <!-- DAUM address API -->
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<!--head-->

<body>
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form class="application" name="application01" method="post" action="./Application01Action.cp">
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
     	<div class="active">
     		<span></span>step1
     	</div>
     	<div>
     		<span></span>step2
     	</div>
     	<div>
     		<span></span>step3
     	</div>
     	<div>
     		<span></span>step4
     	</div>
     </div><!--.step-->
     <div class="step1">
		  <div id="app1-group" class="group cf">
			<label for="app1">기업명</label>
			<input type="text" id="name" name="name" placeholder="상호명을 입력하세요.">
		  </div><!--#app1-->
		  <div id="app2-group" class="group cf">
			<label for="app2">담당자 이름</label>
			<input type="text" id="manager" name="manager" placeholder="이름을 입력하세요." onKeyup="this.value=this.value.replace(/[^가-힣a-zA-Z]/g,'');">
		  </div><!--#app2-->
		   <div id="app3-group" class="group cf">
			<label for="app3">연락처</label>
			<input type="text" id="phone" name="phone" placeholder="ex)01012345678" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
		  </div><!--#app3-->
		  <div id="app4-group" class="group cf">
			<label for="app4">사업장소재지</label>
			<input type="button" value="검색" class="app4_btn" onclick="address_search();">
			<input type="text" id="app4" name="app4" placeholder="우편번호" readonly="readonly">
			<input type="text" id="app4_1" name="app4_1" placeholder="주소" readonly="readonly">
			<input type="text" id="app4_2" name="app4_2" placeholder="상세주소">
			<input type="text" id="app4_3" name="app4_3" placeholder="참조" readonly="readonly">
		  </div><!--#app4-->
		  <div id="app5-group" class="group cf">
			<label for="app5">업종</label>
			<input type="text" id="sector" name="sector" placeholder="ex)일반음식점, 주점, 카페 등">
		  </div><!--#app5-->
		  <div id="app6-group" class="group cf">
			<label for="app6">기업 임대정보</label>
			<span>권리금</span>
			<input type="text" id="prestige" name="prestige" placeholder="전세, 자가인 경우 생략" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
			<span>보증금</span>
			<input type="text" id="deposit" name="deposit" placeholder="전세, 자가인 경우 생략" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
			<span>월세</span>
			<input type="text" id="monthly" name="monthly" placeholder="전세, 자가인 경우 생략" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
		  </div><!--#app6-->
     	  <div id="app7-group" class="group cf">
			<label for="app7">오픈상태</label>
			<input type="text" id="open_datetime" name="open_datetime" placeholder="오픈날짜 ex)20190628" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
			<select name="status">
			  <option value="1">운영중</option>
			  <option value="0">오픈예정</option>
			</select>
		  </div><!--#app7-->
    		<div class="cf">
     		<input type="button" class="next" value="다음" onclick="company_join_app01();">
     		<input type="button" class="cancel" value="취소하기" onclick="location.href='./Index.mb'">
     		</div>
      </div><!--.step1-->
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