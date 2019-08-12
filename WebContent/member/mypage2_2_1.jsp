<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="css/input.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="member/js/point_deposit.js"></script>
  <div id="coin_send">
     <button>
      <span></span>
      <span></span>
     </button>
     <input type="hidden" value="${sessionScope.id }" id="session_value">
     <input type="hidden" value="${sessionScope.idx }" id="session_idx">
    <form>
      <div id="pin-group" class="group cf">
        <label for="pin">Pin code</label>
        <input type="password" id="pin" name="pin" maxlength="6" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
      	<font id="pin_check" size="2" color="red"></font>
      </div>
      <!--pin-->
      <input id="charge_button" type="button" class="submit" value="충전하기">
    </form>
  </div><!--.coin_send-->
  
  <script src="member/js/mypage2_2_1.js"></script>