<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">


<head>
  <meta charset="utf-8">
  <title>FUNBOX Pin Code찾기</title>
  <link href="css/common.css" rel="stylesheet">
  <link href="css/form.css" rel="stylesheet">
  <script src="member/js/find.js"></script>
</head>
<!--head-->

<body>
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form id="find_tx" name="find_tx" method="post">
    <input type="hidden" name="find_tx_key" id="find_tx_key" >
    <h3>Pin Code찾기</h3>
     <div id="intro">
        <p class="tt1">
            안녕하세요.<br>
            <span>Funbox</span> 입니다.
        </p>
        <p class="tt2">
            가입 시 입력한 정보를 입력해주세요.
        </p>
     </div><!--#intro-->
      <div id="id-group" class="group cf">
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" maxlength="15" placeholder="영문 또는 영문/숫자 조합, 6~15자리 ">
      </div>
       <div id="pw-group" class="group cf">
        <label for="pw">비밀번호</label>
        <input type="password" id="pw" name="pw" maxlength="15" placeholder="영문/숫자/특수문자 조합, 8~15자리">
      </div>
      <!--pw-->
        <div id="ph-group" class="group cf">
        <label for="ph">휴대전화번호</label>
        <input type="text" id="ph" name="ph" maxlength="11" placeholder="'-'없이 11자리 입력해주세요.">
        <input type="button" class="letter" value="인증번호받기" onclick="send_tx_sms();">
        </div><!--#ph-->
        <div id="verti-group" class="group cf">
        <input type="button" class="num_ch" value="확인" onClick="find_tx_confirm();">
        <input type="text" id="verti_num" name="verti_num" placeholder="인증번호 6자리">
        </div><!--#verti-->
        <input type="button" class="submit" value="제출하기" onClick="find_tx_confirm();">
        <div class="found_id">
            <a href="./Find_id.mb" target="_blank">아이디찾으러가기</a>
            <a href="./Find_pw.mb" target="_blank">비밀번호찾으러가기</a>
            <a href="./LoginPage.mb" target="_self">로그인하러가기</a>
         </div><!--.go_login-->
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