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
  <link href="css/jquery.bxslider.css" rel="stylesheet">

  <link href="css/service.css" rel="stylesheet">
  <link href="css/list_box.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>
  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
	  
	  
	  $(function(){
		  var onOff = false;
        $('.depth1').on('click',function(){
            onOff = !onOff;
            if(onOff==true){
                $(this).siblings('.depth2').css({
                    'display':'block'
                });
            }else{
                $(this).siblings('.depth2').css({
                    'display':'none'
                });
            }
        });
	  });
	  
	  $(function(){
		  $('.faq > button').on('click',function(){
			  $('.faq > button').removeClass('on');
			  $(this).addClass('on');
		  });
		  $('.faq > button').eq(0).on('click',function(){
			  $('.table > div').css({
				  'display':'block'
			  });
		  });
		  $('.faq > button').eq(1).on('click',function(){
			  $('.table > div').css({
				  'display':'none'
			  });
			  $('.btn1').css({
				  'display':'block'
			  });
		  });
		  $('.faq > button').eq(2).on('click',function(){
			  $('.table > div').css({
				  'display':'none'
			  });
			  $('.btn2').css({
				  'display':'block'
			  });
		  });
		  $('.faq > button').eq(3).on('click',function(){
			  $('.table > div').css({
				  'display':'none'
			  });
			  $('.btn3').css({
				  'display':'block'
			  });
		  });
	  });
	  
  </script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div> 
    <div class="toppdng"></div>
    
    <section id="section04">
		<div class="tit">
			<h3>고객지원서비스</h3>
			<h5>FUNBOX 고객지원 서비스입니다</h5>
		</div><!--sub_title-->
		<div class="faq">
			<h4>FAQ</h4>
			<h5>궁금한 점이 있다면 여기서 먼저 찾아보세요</h5>
			<button class="on">전체FAQ</button>
			<button>입출금관련FAQ</button>
			<button>투자관련FAQ</button>
			<button>기타FAQ</button>
			<div class="sch">
				<label>키워드로 검색해보세요</label>
				<input type="text" id="search_faq">
				<input type="button">
			</div><!--.sch-->
			<div class="table">
				<div class="btn1">
					<p class="depth1">
						<span>Q.여기는 입출금관련 자주묻는질문 자리 입니다.</span>
					</p>
					<p class="depth2">
						<span>
							A.여기는 답변자리구요.
						</span>
					</p>
				</div>
				<div class="btn2">
					<p class="depth1">
						<span>Q.여기는 투자관련 자주묻는질문 자리 입니다.</span>
					</p>
					<p class="depth2">
						<span>
							A.여기는 답변자리구요.
						</span>
					</p>
				</div>
				<div class="btn3">
					<p class="depth1">
						<span>Q.여기는 기타 자주묻는질문 자리 입니다.</span>
					</p>
					<p class="depth2">
						<span>
							A.여기는 답변자리구요.
						</span>
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

</body></html>
