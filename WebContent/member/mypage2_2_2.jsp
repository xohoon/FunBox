<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <link href="css/common.css" rel="stylesheet">
  <link href="css/input.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="member/js/point_withdraw.js"></script>
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
        <input type="password" id="pin" name="pin"  maxlength="6" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
        <font id="pin_check" size="2" color="red"></font>
      </div>
      <!--pin-->
      <input type="button" class="submit" value="환전하기" id="ex_pointBtn">
    </form>
  </div><!--.coin_send-->
  
  <script>
	  $(function(){
		  $('#coin_send button').on('click', function(){
			 $(this).parent('#coin_send').hide();
		  });
	  });
  </script>
