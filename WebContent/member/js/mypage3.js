    $(function() {
    	$('header').load('./header/header.jsp')
        $('footer').load('./footer/footer.jsp')
        $('.like_box').load('./member/like_box.jsp')
    });

    function cateval(category){  		
  		 location.href='./Mypage3.mb?category='+category;
  	}
  	
	  $(function(){
		  if($('#cate_color').val() == '1'){
			$('.button > button').removeClass('on');
			$('#button1').addClass('on');
		  }
		  else if($('#cate_color').val() == '2'){
	 		$('.button > button').removeClass('on');
	 		$('#button2').addClass('on');
	 	  }
		  else if($('#cate_color').val() == '3'){
		 	$('.button > button').removeClass('on');
		 	$('#button3').addClass('on');
		  }
		
	  });