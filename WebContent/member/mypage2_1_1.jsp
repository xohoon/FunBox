<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <link href="css/common.css" rel="stylesheet">
  <link href="css/input.css" rel="stylesheet">

  <div id="coin_send">
     <button>
      <span></span>
      <span></span>
     </button>
    <form>
      <div id="pin-group" class="group cf">
        <label for="pin">Pin code</label>
        <input type="password" id="pin" name="pin"  maxlength="6" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
      </div>
      <!--pin-->
     <div id="ph-group" class="group cf">
        <label for="ph">휴대전화번호</label>
        <input type="text" id="ph" name="ph" maxlength="11" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
        <input type="button" class="letter" value="인증번호받기">
        </div><!--#ph-->
        <div id="verti-group" class="group cf">
        <input type="text" id="verti_num" name="verti_num" placeholder="인증번호 6자리" maxlength="6" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
         <input type="button" class="num_ch" value="확인">
        </div><!--#verti-->
      <input type="button" class="submit" value="출금하기">
    </form>
  </div><!--.coin_send-->
  
  <script>
	 $(function(){
		  $('#coin_send button').on('click', function(){
			 $(this).parent('#coin_send').hide();
		  });
	  });
  </script>
