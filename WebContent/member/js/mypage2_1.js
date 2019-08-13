		
		function depositAmount(amount) {
			  var transAmount;
			  transAmount = amount.replace(/(^0+)/, "");
			  console.log(transAmount);			  
			  $('#td_amount').val(transAmount); 			  			  
		}
		
		function characterCheck() {
            
			var RegExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;//정규식 구문
            
			var obj = document.getElementsByName("td_tx_hash")[0]
            if (RegExp.test(obj.value)) {
                alert("특수문자는 입력하실 수 없습니다.");
                obj.value = obj.value.substring(0, obj.value.length - 1);//특수문자를 지우는 구문
            }
        }


		$(function() {
			var winW = $(window).width();
			if (winW > 767) {
				var h1 = $('.b2').height();
				$('.btn button').height((h1 + 32) / 2 - 4);
				var h2 = $('.b3').height();
				$('.b1').height(h2);
			} else {
				$('.btn button').height(40);
				$('.b1').height(auto);
			}

		});

		$(document).ready(function() {
			$('.txt_wrap').on('keyup', 'textarea', function(e) {
				$(this).css('height', 'auto');
				$(this).height(this.scrollHeight);
			});
			$('.txt_wrap').find('textarea').keyup();

			//영어 숫자만 가능하게 하깅~//
			$("input[name=td_from_address]").keyup(function(event) {
				if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
					var inputVal = $(this).val();
					$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
				}
			});
			$("input[name=tk_to_address]").keyup(function(event) {
				if (!(event.keyCode >= 37 && event.keyCode <= 40)) {
					var inputVal = $(this).val();
					$(this).val(inputVal.replace(/[^a-z0-9]/gi, ''));
				}
			});
			//영어 숫자만 가능하게 하깅~//
		});

		var clipboard = new ClipboardJS('.copybtn');
		clipboard.on('success', function(e) {
			console.log(e);
			alert("내 지갑주소를 복사하였습니다.");
		});

		clipboard.on('error', function(e) {
			console.log(e);
			alert("복사하기를 실패하였습니다.");
		});

		function numberWithCommas(x) {
			return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		}
		function sumWithCommas() {
			var sumstr1 = $('#sumcomma1').text();
			var sumstr2 = $('#sumcomma2').text();
			var numre1 = numberWithCommas(sumstr1);
			var numre2 = numberWithCommas(sumstr2);
			document.getElementById('sumcomma1').innerHTML = numre1;
			document.getElementById('sumcomma2').innerHTML = numre2;
		}
		$('.coin').on('keyup', function() {
			$(this).siblings('.out').text($(this).val());
			$(this).parent().siblings('.sum').find('span').text($(this).val());
			sumWithCommas();

		});
		$('.send_btn').on('click', function() {
			$('#send').load('./Mypage2_1_1.mb');
		});

		$('.cob1').on(
				'click',
				function() {
					var m1 = $(this).parent().siblings('.coin').val();
					$(this).parent().siblings('.coin').val(m1 * 1 + 1000000);
					$(this).parent().siblings('.out').text(
							$(this).parent().siblings('.coin').val());
					$(this).parents().siblings('.sum').find('span').text(
							$(this).parent().siblings('.coin').val());
					sumWithCommas();
				});

		$('.cob2').on(
				'click',
				function() {
					var m2 = $(this).parent().siblings('.coin').val();
					$(this).parent().siblings('.coin').val(m2 * 1 + 5000000);
					$(this).parent().siblings('.out').text(
							$(this).parent().siblings('.coin').val());
					$(this).parents().siblings('.sum').find('span').text(
							$(this).parent().siblings('.coin').val());
					sumWithCommas();
				});

		$('.cob3').on(
				'click',
				function() {
					var m3 = $(this).parent().siblings('.coin').val();
					$(this).parent().siblings('.coin').val(m3 * 1 + 10000000);
					$(this).parent().siblings('.out').text(
							$(this).parent().siblings('.coin').val());
					$(this).parents().siblings('.sum').find('span').text(
							$(this).parent().siblings('.coin').val());
					sumWithCommas();
				});