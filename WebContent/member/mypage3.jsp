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
    		<li onclick="location.href='./Mypage1.mb'">투자현황</li>
    		<li onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li class="on" onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
		</ul>
		<div class="list_all">
		    <div class="cf">
			    <h5>거래내역</h5>
                <div class="button">
                    <button class="on">입출금내역</button>
                    <button>포인트내역</button>
                    <button>투자내역</button>
                </div>
			</div>
			<div class="b4 c on">
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
						<td>2019.07.02<br>10:01:55</td>
					</tr>
					<tr>
						<td class="minus">출금</td>
						<td>완료</td>
						<td>18ThfiqFJkbhLWcfBoZ8geUch2NAgtXzna</td>
						<td class="minus">-100,000coin</td>
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
			<div class="b4 p">
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
			<div class="b4 t">
				<table>
					<tr>
						<td>구분</td>
						<td>내용</td>
						<td>수량</td>
						<td>날짜</td>
						<td>비고</td>
					</tr>
					<tr>
						<td class="minus">투자</td>
						<td>바른생선회</td>
						<td class="minus">-1,000,000P</td>
						<td>2019.06.14<br>16:29:49</td>
						<td></td>
					</tr>
					<tr>
						<td class="plus">이자</td>
						<td>바른생선회</td>
						<td class="plus">+50,000P</td>
						<td>2019.06.14<br>16:29:49</td>
						<td>1/24</td>
					</tr>
					<tr>
						<td class="plus">회수</td>
						<td>바른생선회</td>
						<td class="plus">+5,000,000P</td>
						<td>2019.06.14<br>16:29:49</td>
						<td></td>
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
		  $('.button button').on('click', function(){
			  var btnI = $('.button button').index(this);
			  $('.b4').removeClass('on');
			  $('.b4').eq(btnI).addClass('on');
			  $('.button button').removeClass('on');
			  $(this).addClass('on');
		  });
	  });
		
	</script>
</body>
</html>
