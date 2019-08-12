<%@page import="net.member.dto.InvestDeleteVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>투자 철회</title>
  <style>
    body{
      background:#f9f9f9;
    }
    section {
      position:absolute;
      top:50%;
      left:50%;
      transform:translate(-50%, -50%);
      font-size: 16px;
      width: 100%;
      max-width:480px;
      padding: 40px 24px;
      background:#fff;
      border-radius:4px;
      box-shadow:2px 2px 2px rgba(0,0,0,0.1);
    }

    p {
      color: #333;
      margin-bottom: 24px;
      text-align: center;
    }

    form:after,
    .tit:after {
      content: "";
      display: block;
      clear: both;
    }

    .tit p {
      text-align: left;
      font-size: 16px;
      line-height: 32px;
    }

    .tit p:first-child {
      float: left;
    }

    .tit p:nth-child(2) {
      float: right;
      text-align: right;
    }

    .tit p input {
      width: auto;
      height: 32px;
      line-height: 32px;
      font-weight: 600;
      color: #73a6d6;
      margin-right: 8px;
      font-size: 20px;
      border: 0;
      outline: 0;
      text-align: right;
    }

    .pin label {
      margin-right: 24px;
      line-height: 24px;
    }

    .pin input {
      width: 24px;
      height: 24px;
      text-align: center;
      font-size: 20px;
      line-height: 24px;

    }
    input[type=button] {
      padding: 0 16px;
      height: 32px;
      line-height:32px;
      font-size: 16px;
      background: #ff9124;
      color: #fff;
      border: 0;
      outline: 0;
      float: right;
      cursor:pointer;
    }
  </style>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="member/js/InvestDrop.js"></script>
</head>

<body>

<%
	List<InvestDeleteVO> DeleteInfo = (List<InvestDeleteVO>)request.getAttribute("DeleteInfo");
%>
  <section id="q">
    <p>투자를 철회하시겠습니까?</p>
    <form name="cancelFun">
      <div class="tit">
        <p>${DeleteInfo.cp_name }</p>
        <p><input type="text" value="${DeleteInfo.cp_point }" readonly="readonly" name="point">POINT</p>
      </div>
      <div class="pin">
        <label>PINCODE</label>
        <input class="pincode" type="password" maxlength="1" id="pin01">
        <input class="pincode" type="password" maxlength="1" id="pin02">
        <input class="pincode" type="password" maxlength="1" id="pin03">
        <input class="pincode" type="password" maxlength="1" id="pin04">
        <input class="pincode" type="password" maxlength="1" id="pin05">
        <input class="pincode" type="password" maxlength="1" id="pin06">
        <font id="pin_check" size="2" color="red"></font>
      </div>
      <input type="hidden" name="cp_idx" value="${cp_idx }" id="cp_idx">
      <input type="hidden" name="mi_idx" value="${DeleteInfo.mi_idx }" id="mi_idx">
      <input type="button" value="철회하기" id="IvDrop_btn">
    </form>
  </section>
  <section id="a">
    <div>
      <p>포인트 환불이 완료되었습니다.</p>
    </div>
  </section>
  <script>
    numWithCom();
    
    var $pincode = document.getElementsByClassName('pincode'),
        pinLeng = $pincode.length,
        $a = document.getElementById('a'),
        $q = document.getElementById('q'),
        $submit = document.getElementsByClassName('submit');
        
    
    window.onload = function(){
      for(var i=0;i<pinLeng; i++){
        $pincode[i].addEventListener('keyup', pinTab, false);
      }
            
      $a.style.display ="none";
    }
    
    
    function numWithCom() {
      var num = cancelFun.point.value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
      cancelFun.point.value = num;
    }
    
    function pinTab(e){
      if (e.keyCode == 8) {
          e.target.previousElementSibling.value = '';
          e.target.previousElementSibling.focus();
        }else {
          e.target.nextElementSibling.value = '';
          e.target.nextElementSibling.focus();
        }
    }
    
    function pointReturned(){
      $q.style.display = 'none';
      $a.style.display = 'block';
    }
    
    
    
  </script>
</body>

</html>