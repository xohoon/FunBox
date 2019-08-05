<%@page import="net.member.dto.MemberInvestVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title></title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/mypage.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
   <script src="js/jquery-3.1.1.min.js"></script>
  <script>
    $(function() {
    	$('header').load('./header/header.jsp')
        $('footer').load('./footer/footer.jsp')
        $('.like_box').load('./member/like_box.jsp')
    }); 
	  
  </script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    
    <section>
    	<div class="like_box"></div>
    	<ul class="tab">
    		<li onclick="location.href='./MemberInvestmentList.mb'">투자현황</li>
    		<li class="on" onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
		</ul>
 		<div class="asset">
			<div class="btn">
				<button onclick="location.href='./Mypage2_1.mb'">입출금관리</button>
				<button class="on" onclick="location.href='./Mypage2_2Action.mb'">포인트관리</button>
			</div><!--btn-->
			<div class="b1 brif">
			<div>
				<div class="cf">
					<p>현재 보유 포인트</p>
					<p></p>
				</div>
				<div class="cf">
					<p>충전 가능 포인트</p>
					<p></p>
				</div>
				<div class="cf">
					<p>이번달 수익</p>
					<p></p>
				</div>
				<div class="cf">
					<p>총 누적 수익</p>
					<p></p>
				</div>
				</div>
			</div>
			<div>
					<div class="b2 cf">
						<h5>포인트 충전하기</h5>
						<div>
							<label>충전할 포인트</label>
							<p class="cf">
								<span>100,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num1">
									<button class="up">+</button>
								</span>
							</p>
							<p class="cf">
								<span>500,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num2">
									<button class="up">+</button>
								</span>
							</p>
							<p class="cf">
								<span>1,000,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num3">
									<button class="up">+</button>
								</span>
							</p>
							<p class="cf">
								<span>10,000,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num4">
									<button class="up">+</button>
								</span>
							</p>
						</div>
						<hr>
						<div class="coinout">-1,000,000 Coin</div>
						<div class="sum po">
						    합계 <span class="sumcomma1">0</span> point
						</div>
						<form id="form_charge" action="MypageChargePoint.mb" method="post">
							<input id="charge_point" name="charge_point" type="hidden" value="">
						</form>
						<input type="button" value="충전하기" class="char_btn">
						<div id="char"></div>
					</div><!--입금-->
				<div class="b3 cf">
					<h5>토큰으로 환전하기</h5>
					<div>
						<label>환전할 포인트</label>
						<input type="text" class="coin" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/><span>POINT</span>
						<div class="coinbtn">
						<input type="button" value="+1백만" class="cob cob1">
						<input type="button" value="+5백만" class="cob cob2">
						<input type="button" value="+1천만" class="cob cob3">
						</div>
						<p class="out toco">0</p>
					</div>
					<hr>
					<div class="coinout">+1,000,000 Coin</div>
					<div class="sum">
					    합계 <span class="sumcomma2">0</span> point
					</div>
					<input type="button" value="환전하기" class="ex_btn">
					<div id="exch"></div>
				</div><!--출금하기-->
				<script>
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
                    </script>
			</div><!--2-->
			<div class="b4 p">
			<h5>포인트내역</h5>
				<table>
					<tr>
						<td>구분</td>
						<td>코인수량</td>
						<td>포인트수량</td>
						<td>날짜</td>
					</tr>
					<tr>
						<td class="plus">충전</td>
						<td>-100,000coin</td>
						<td>+100,000point</td>
						<td>2019.07.02<br>10:01:55</td>
					</tr>
					<tr>
						<td class="minus">환전</td>
						<td>+100,000coin</td>
						<td>-100,000point</td>
						<td>2019.07.02<br>10:01:55</td>
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
	<script>
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
	</script>
</body>
</html>
