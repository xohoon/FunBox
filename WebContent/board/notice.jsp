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
  <link href="css/service.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
 

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div> 
    <div class="toppdng"></div>
    
    <section id="section03">
		<div class="tit">
			<h3>고객지원서비스</h3>
			<h5>FUNBOX 고객지원 서비스입니다</h5>
		</div><!--sub_title-->
		<div class="notice">
			<h4>공지사항</h4>
			<h5>펀박스 이용관련 공지사항입니다.</h5>
			<div class="table">
				<div>
					<p class="depth1">
						<span>번호</span>
						<span>제목</span>
						<span>등록일</span>
					</p>
				</div>
				<div>
					<p class="depth1">
						<span>100</span>
						<span>제목1</span>
						<span>19.06.20</span>
					</p>
					<p class="depth2">
						<span>공지사항내용이 들어갑니다</span>
					</p>
				</div>
				<div>
					<p class="depth1">
						<span>101</span>
						<span>제목2</span>
						<span>19.06.20</span>
					</p>
					<p class="depth2">
						<span>공지사항내용이 들어갑니다</span>
					</p>
				</div>
			</div><!--.table-->
			<a href="#" class="prev">◀</a>
			<ul class="pager">
				<li class="on">1</li>
				<li>2</li>
				<li>3</li>
			</ul><!--.pager-->
			<a href="#" class="next">▶</a>
		</div><!--.qna_list-->
	</section>

    <footer></footer>
  </div>
 <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
	   $(function(){
		  $('.depth1').on('click',function(){
            $(this).siblings('.depth2').slideToggle(200);
        });
	  });
  </script>
</body></html>
