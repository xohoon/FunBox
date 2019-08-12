	 $(function(){
		  $('#coin_send button').on('click', function(){
			 $(this).parent('#coin_send').hide();
		  });
		  $('#button_withdraw').on('click',function(){
				$('#form_withdraw').submit();
			});
	  });