<%@page import="net.company.dto.CompanyBean"%>
<%@page import="net.company.dto.InvestPointVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="kr">
<!-- 유정 추가 -->
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>투자 내역</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/invest.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="company/js/invest_after_functions.js"></script>

</head>

<body>

<%
	request.setCharacterEncoding("utf-8"); // 한글처리
	CompanyBean companyBean = (CompanyBean)request.getAttribute("company");
	InvestPointVO inv_pointVO = (InvestPointVO)request.getAttribute("inv_pointVO");
%>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>


    <section id="inv_af">
      <div class="inner">
        <article class="inv_inbox">
          <img src="${companyBean.cf_image5}" alt="">
          <form class="inv_intxt" name="invest_after_form" action="./InvestAction.cp" method="post">
            <input type="hidden" name="mb_idx" value="${sessionScope.idx}">
            <input type="hidden" name="mb_id" value="${sessionScope.id}">
            <input type="hidden" name="mi_category" value="투자">
            <input type="hidden" name="amount" value="${inv_pointVO.invest_amount }">
            <input type="hidden" name="point" value="${inv_pointVO.invest_point }">
            <input type="hidden" name="cp_name" value="${company.cp_name }">
            <input type="hidden" name="cp_branch" value="${company.cp_branch }">
            <input type="hidden" name="cp_idx" value="${company.cp_idx }">
            <h2>투자 내역</h2>
            <h3>${company.cp_name }<span>${company.cp_branch }</span></h3>

            <div class="summary">
              <div><span><fmt:formatNumber value="${company.iv_min_amount }" pattern="#,###" /></span> point</div>
              <div>x <span>${inv_pointVO.invest_amount }</span> 구좌</div>
              <hr>
              <div><span><fmt:formatNumber value="${inv_pointVO.invest_point }" pattern="#,###" /></span> point</div>
            </div>

            <div class="inv_noti">
              <h4>이용약관안내</h4>
              <p>위 약관은 어쩌고 저쩌고 그래서 어쨋든 저쨋다.</p>
              <input type="checkbox" id="agree"><label for="agree">위 내용에 동의합니다</label>
            </div>

            <div class="pcnum">
              <label for="pincode1">PINCODE</label>
              <input id="pincode1" name="pincode1" type="password" maxlength="1">
              <input id="pincode2" name="pincode2" type="password" maxlength="1">
              <input id="pincode3" name="pincode3" type="password" maxlength="1">
              <input id="pincode4" name="pincode4" type="password" maxlength="1">
              <input id="pincode5" name="pincode5" type="password" maxlength="1">
              <input id="pincode6" name="pincode6" type="password" maxlength="1">
            </div>

            <input class="okdk" type="button" value="투자 확정" onclick="invest_after_check();">


          </form>
        </article>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <article class="confirm">
      <div class="cfrm_inbox">
        <h5>투자완료!</h5>
        <p>수익은 매달 5일 정산 후 지급되며 내가 투자한 기업 페이지에서 자세한 내용을 확인할 수 있습니다. 지금 확인하시겠습니까?</p>
        <button onclick="pincode_check();">확인</button>
        <button onclick="history.go(0);">취소</button>
      </div>
    </article>

    <footer></footer>
  </div>

  <script>
    $(function() {
      $('header').load('./header/header.jsp');
      $('footer').load('./footer/footer.jsp');
    });



    var p1 = document.getElementById('pincode1');
    var p2 = document.getElementById('pincode2');
    var p3 = document.getElementById('pincode3');
    var p4 = document.getElementById('pincode4');
    var p5 = document.getElementById('pincode5');
    var p6 = document.getElementById('pincode6');


    $('#pincode1').keyup(function(e) {
      if (e.keyCode == 8) {
        alert('6자리 PINCODE를 입력해주세요.');
      } else {
        p2.value = '';
        p2.focus();
      }
    });
    $('#pincode2').keyup(function(e) {
      if (e.keyCode == 8) {
        p1.value = '';
        p1.focus();
      } else {
        p3.value = '';
        p3.focus();
      }
    });
    $('#pincode3').keyup(function(e) {
      if (e.keyCode == 8) {
        p2.value = '';
        p2.focus();
      } else {
        p4.value = '';
        p4.focus();
      }
    });
    $('#pincode4').keyup(function(e) {
      if (e.keyCode == 8) {
        p3.value = '';
        p3.focus();
      } else {
        p5.value = '';
        p5.focus();
      }
    });
    $('#pincode5').keyup(function(e) {
      if (e.keyCode == 8) {
        p4.value = '';
        p4.focus();
      } else {
        p6.value = '';
        p6.focus();
      }
    });
    $('#pincode6').keyup(function(e) {
      if (e.keyCode == 8) {
        p5.value = '';
        p5.focus();
      } else {
        alert('내역을 확인하시고 투자 확정 버튼을 눌러주세요.');
      }
    });
    
  </script>
</body>

</html>
