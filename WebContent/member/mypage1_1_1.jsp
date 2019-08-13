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
<link href="css/mypage1_1_1.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
</head>

<body>

<%
	List<InvestDeleteVO> DeleteInfo = (List<InvestDeleteVO>)request.getAttribute("DeleteInfo");
%>
  <section id="q">
    <p>투자를 철회하시겠습니까?</p>
    <form name="cancelFun">
      <div class="tit">
        <p><%=DeleteInfo.get(0).getMi_name() %></p>
        <p><input type="text" value="<%=DeleteInfo.get(0).getMi_point() %>" readonly="readonly" name="point">POINT</p>
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
      <input type="hidden" name="cp_idx" value="<%=DeleteInfo.get(0).getCp_idx() %>" id="cp_idx">
      <input type="hidden" name="mi_idx" value="<%=DeleteInfo.get(0).getMi_idx() %>" id="mi_idx">
      <input type="button" value="철회하기" id="IvDrop_btn">
    </form>
  </section>
  <section id="a">
    <div>
      <p>포인트 환불이 완료되었습니다.</p>
    </div>
  </section>
  <script src="member/js/mypage1_1_1.js"></script>
</body>

</html>