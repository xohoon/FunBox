    $(function() {
    	$('header').load('./header/header.jsp')
        $('footer').load('./footer/footer.jsp')
        $('.like_box').load('./member/like_box.jsp')
    });
    
    function numberWithCommas(x) {
		return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
function sumWithCommas(){
		var sumstr1 = $('.sumcomma1').text();
		var numre1 = numberWithCommas(sumstr1);
		var sumstr2 = $('.sumcomma2').text();
		var numre2 = numberWithCommas(sumstr2);
	  document.querySelector('.sumcomma1').innerHTML=numre1;
	  document.querySelector('.sumcomma2').innerHTML=numre2;
	  document.getElementById('charge_point').value=numre1;
	}

	$('.down').on('click', function(){
			var point = $(this).siblings('input').val();
			if(point>0){
					$(this).siblings('input').val(point-1);
			}else{
					$(this).siblings('input').val(point);
			}
	});
	$('.up').on('click', function(){
			var point = $(this).siblings('input').val();
			$(this).siblings('input').val(point*1+1);
	});
	$('.b2 button').click(function(){
			var sum1 = $('.num1').val()*100000;
			var sum2 = $('.num2').val()*500000;
			var sum3 = $('.num3').val()*1000000;
			var sum4 = $('.num4').val()*10000000;
			$('.sum.po span').text(sum1+sum2+sum3+sum4);
			sumWithCommas();
	});      
	 $('.coin').on('keyup', function(){
				$(this).siblings('.out').text($(this).val());
				$(this).parent().siblings('.sum').find('span').text($(this).val());
				sumWithCommas();
	 });
		$('.cob1').on('click', function(){
			var m1 = $(this).parent().siblings('.coin').val();
			$(this).parent().siblings('.coin').val(m1*1+1000000);
			$(this).parent().siblings('.out').text($(this).parent().siblings('.coin').val());
			$(this).parents().siblings('.sum').find('span').text($(this).parent().siblings('.coin').val());
			sumWithCommas();
		});

		$('.cob2').on('click', function(){
				var m2 = $(this).parent().siblings('.coin').val();
				$(this).parent().siblings('.coin').val(m2*1+5000000);
				$(this).parent().siblings('.out').text($(this).parent().siblings('.coin').val());
			$(this).parents().siblings('.sum').find('span').text($(this).parent().siblings('.coin').val());
				sumWithCommas();
		});

		$('.cob3').on('click', function(){
				var m3 = $(this).parent().siblings('.coin').val();
				$(this).parent().siblings('.coin').val(m3*1+10000000);
				$(this).parent().siblings('.out').text($(this).parent().siblings('.coin').val());
			$(this).parents().siblings('.sum').find('span').text($(this).parent().siblings('.coin').val());
				sumWithCommas();
		});

            

	$('.char_btn').on('click', function(){
			$('#char').load('./Mypage2_2_1.mb');
	});
	$('.ex_btn').on('click', function(){
			$('#exch').load('./Mypage2_2_2.mb');
	});
	
	$(function(){
		var winW = $(window).width();
		if(winW > 767){
			var h1 = $('.b2').height();
			$('.btn button').height((h1+32)/2-4);
			var h2 = $('.b3').height();
			$('.b1').height(h2);
		}else{
			$('.btn button').height(40);
			$('.b1').height(auto);
		}								
	});