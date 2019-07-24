<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <input type="button" class="submit" value="충전하기">
    </form>
  </div><!--.coin_send-->
  
  <script>
	  $(function(){
		  $('#coin_send button').on('click', function(){
			 $(this).parent('#coin_send').hide();
		  });
	  });
  </script>
