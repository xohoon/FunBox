<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>자산관리</title>

<!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
<script src="js/clipboard.min.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="member/js/mypage_functions.js"></script>
<script>
	$(function() {
		$('header').load('./header/header.jsp')
		$('footer').load('./footer/footer.jsp')
		$('.like_box').load('./member/like_box.jsp')
	});
</script>
<script src="member/js/mypage_token.js"></script>
</head>

<body>

	<div id="wrap">
		<header></header>
		<div class="hdbck"></div>
		<div class="toppdng"></div>
		<section>
			<div class="like_box"></div>
			<input type="hidden" value="${sessionScope.id }" id="session_value">
			<input type="hidden" value="${sessionScope.idx }" id="session_idx">
			<ul class="tab">
				<li id="invest_check" onclick="location.href='./MemberInvestmentList.mb'">투자현황</li>
				<li class="on" onclick="location.href='./Mypage2_1.mb'">자산관리</li>
				<li onclick="location.href='./Mypage3.mb'">거래내역</li>
				<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
			</ul>
			<div class="asset">
				<div class="btn">
					<button class="on" onclick="location.href='./Mypage2_1.mb'">입출금관리</button>
					<button onclick="location.href='./Mypage2_2.mb'">포인트관리</button>
				</div>
				<!--btn-->
				<div class="b1">
					<div>
						<span>내 지갑주소<span>
								<div class="txt_wrap cf">
									<textarea id="bar" readonly>durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek</textarea>
									<button class="copybtn" data-clipboard-target="#bar"
										data-clipboard-action="copy">복사하기</button>
								</div>
					</div>
				</div>
				<div>
					<form id="form_deposit" action="MypageDeposit.mb" method="post">
						<div class="b2 cf">
							<h5>토큰받기</h5>
							<div>
								<label>보낸사람 지갑주소</label> <input type="text"
									name="td_from_address" id="token_wallet">
							</div>
							<div>
								<label>TX Hash</label> <input type="text" name="td_tx_hash" id="token_hash">
							</div>
							<div>
								<label>입금받을 수량</label> <input type="text" name="td_amount"
									class="coin"
									onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" /><span>Coin</span>
								<div class="coinbtn">
									<input type="button" value="+1백만" class="cob cob1"> <input
										type="button" value="+5백만" class="cob cob2"> <input
										type="button" value="+1천만" class="cob cob3">
								</div>
								<p class="out">0</p>
							</div>
							<hr>
							<div class="sum">
								합계 <span id="sumcomma1">0</span> point
							</div>
							<input name="td_to_address" type="hidden" value="td_to_address">
							<input id="button_deposit" type="button" value="입금하기">
							<!-- <input type="submit" value="입금하기"> -->
						</div>
						<!--입금-->
					</form>
					<form id="form_sendToken" action="MypageSendToken.mb" method="post">
						<div class="b3 cf">
							<h5>토큰보내기</h5>
							<div>
								<label>받을사람 지갑주소</label> <input type="text" name="tk_to_address" id="tk_to_address">
							</div>
							<div>
								<label>출금할 수량</label> <input type="text" name="tk_amount"
									class="coin"
									onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" /><span>Coin</span>
								<div class="coinbtn">
									<input type="button" value="+1백만" class="cob cob1"> <input
										type="button" value="+5백만" class="cob cob2"> <input
										type="button" value="+1천만" class="cob cob3">
								</div>
								<p class="out">0</p>
							</div>
							<hr>
							<div class="sum">
								합계 <span id="sumcomma2">0</span> point
							</div>
							<!-- <input id="button_withdraw" type="button" value="출금하기" class="send_btn"> -->
							<input type="button" class="send_btn" value="출금하기">
						</div>
					</form>
					<!--출금하기-->
					<div id="send"></div>
				</div>
				<!--2-->
				<div class="b4 c">
					<h5>입출금내역</h5>
					<table>
						<tr>
							<td>구분</td>
							<td>상태</td>
							<td>지갑주소</td>
							<td>수량</td>
							<td>날짜</td>
						</tr>
						<tr>
							<td class="plus">입금</td>
							<td>진행</td>
							<td>18ThfiqFJkbhLWcfBoZ8geUch2NAgtXzna</td>
							<td class="plus">+100,000coin</td>
							<td>2019.07.02<br>10:01:55
							</td>
						</tr>
						<tr>
							<td class="minus">출금</td>
							<td>완료</td>
							<td>18ThfiqFJkbhLWcfBoZ8geUch2NAgtXzna</td>
							<td class="minus">-100,000coin</td>
							<td>2019.07.02<br>10:01:55
							</td>
						</tr>
					</table>
					<a href="#" class="prev"><i class="fas fa-caret-left"></i></a>
					<ul class="pager">
						<li class="on">1</li>
						<li>2</li>
						<li>3</li>
					</ul>
					<a href="#" class="next"><i class="fas fa-caret-right"></i></a>
				</div>
			</div>
		</section>

		<footer></footer>
	</div>
	<script src="js/clipboard.min.js"></script>
	<script>
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
		});

		clipboard.on('error', function(e) {
			console.log(e);
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
	</script>
</body>
</html>
