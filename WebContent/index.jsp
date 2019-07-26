<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="net.member.dto.Main_CityVO"%>
<%@page import="net.member.dto.Main_LikeVO"%>
<%@page import="net.member.dto.Main_SlideVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.page.dto.MainPageDateOfOpenVO"%>
<%@page import="net.page.dto.MainPageDeadLineVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = (ArrayList<MainPageDateOfOpenVO>)request.getAttribute("mainPageDateOfOpenVOs");
	ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = (ArrayList<MainPageDeadLineVO>)request.getAttribute("mainPageDeadLineVOs");
	List<Main_SlideVO> slideVO = (List<Main_SlideVO>)request.getAttribute("slideVO");
	List<Main_LikeVO> likeVO = (List<Main_LikeVO>)request.getAttribute("likeVO");
	Main_CityVO cityVO = (Main_CityVO)request.getAttribute("cityVO");
%>

<!DOCTYPE html>
<html lang="kr">
<%
	//int count = (Integer)request.getAttribute("count");
%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title></title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="./css/slick.css">
  <link rel="stylesheet" type="text/css" href="./css/slick-theme.css">

  <link href="css/index.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>


    <section id="sec1">
      <div class="inner">
        <div class="regular slider">
        <c:forEach var="slideVO" items="${slideVO }">
	        <a href="./CorporationAction.cp?cp_idx=${slideVO.sl_cp_idx }">
	          <div>
	            <div class="slide slide1">
	              <div class="owop"></div>
	              <div class="txtbox">
	                <h2>${slideVO.sl_cp_name }</h2>
	                <h4>${slideVO.sl_cp_branch }</h4>
	                <p>${slideVO.sl_cp_content }</p>
	              </div>
	            </div>
	          </div>
	        </a>
        </c:forEach>
        </div>
        <script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
        <script src="./js/slick.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
          $(document).on('ready', function() {
            $(".regular").slick({
              autoplay: true,
              dots: true,
              infinite: true,
              slidesToShow: 1,
              slidesToScroll: 1
            });
          });
        </script>

        <div class="live_chart">
          <h3>실시간 인기순위</h3>
          <ul>
            <li>
              <span>1</span>&nbsp;
              <a href="#">어나더 미네스</a>
              <span>-</span>
            </li>
            <li>
              <span>2</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>3</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>▲ 4</span>
            </li>
            <li>
              <span>4</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>5</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>6</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>7</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>▼ 4</span>
            </li>
            <li>
              <span>8</span>&nbsp;
              <a href="#">-</a>
              <span>-</span>
            </li>
            <li>
              <span>9</span>&nbsp;
              <a href="#">-</a>
              <span>-</span>
            </li>
            <li>
              <span>10</span>&nbsp;
              <a href="#">-</a>
              <span>-</span>
            </li>
          </ul>
        </div>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <section id="sec2">
      <div class="inner">
      <c:forEach var="likeVO" items="${likeVO }">
	        <div class="corp_box" onclick="location.href='./CorporationAction.cp?cp_idx=${likeVO.lk_cp_idx }'">
	          <div class="c_img">
	            <img src="./img/row1_anotherminae.jpg" alt="">
	          </div>
	          <div class="c_txt">
	            <p>${likeVO.lk_cp_sector }</p>
	            <h5>${likeVO.lk_cp_name }<span>추천</span></h5>
	            <p>${likeVO.lk_cp_branch }</p>
	          </div>
	          <div class="gage">
	            <div class="per"><span>${likeVO.lk_cp_percent }</span>%</div>
	            <div class="gage_full">
	              <div class="gage_fill"></div>
	            </div>
	            <div>
	              <span class="p_amt"><span>${likeVO.lk_cp_current_amount }</span> / <span>${likeVO.lk_cp_goal_amount }</span> P</span>
	              <span class="d_day">D-<span>27</span></span>
	            </div>
	          </div>
	          <div class="reward_per">
	            수익률
	            <span>${likeVO.lk_cp_profit }</span>
	          </div>
	        </div>
      </c:forEach>
      </div>
    </section>

    <section id="sec3">
      <div class="inner">
        <div class="inleft">
          <div class="location">
            <h5>지역별 현황</h5>
            <div class="map"></div>
            <ul>
              <li class="local01">서울(${cityVO.seoul })</li>
              <li class="local02">경기(${cityVO.gyeonggi })</li>
              <li class="local03">인천(${cityVO.incheon })</li>
              <li class="local04">강원(${cityVO.gangwon })</li>
              <li class="local05">대전·충청(${cityVO.daejeonNchungcheong })</li>
              <li class="local06">대구((${cityVO.daegu })</li>
              <li class="local07">부산(${cityVO.busan })</li>
              <li class="local08">울산(${cityVO.ulsan })</li>
              <li class="local09">경상(${cityVO.gyeongsang })</li>
              <li class="local10">광주·전라(${cityVO.gwangjuNjeonla })</li>
              <li class="local11">제주(${cityVO.jeju })</li>
            </ul>
          </div>
        </div>

        <div class="inright"> 
          <div class="comingsoon_box">
            <div class="sec3_box1 slider">
            <c:forEach var="mainPageDateOfOpenVO" items="${mainPageDateOfOpenVOs}" varStatus="status">
            	<div>
            		<div class="slide slide${status.count}" onclick="location.href = './CorporationAction.cp?cp_idx=${mainPageDateOfOpenVO.cp_idx}';">
            			<img src="./img/side_${status.count}_portana.jpg" alt="">
            			<div class="cb_inbox">
		                    <h4>${mainPageDateOfOpenVO.cp_name } <span>${mainPageDateOfOpenVO.cp_open_datetime }오픈예정</span></h4>
		                    <p><span>${mainPageDateOfOpenVO.cp_intro_headline }</span>${mainPageDateOfOpenVO.cp_intro_content }</p>
		                </div>
            		</div>
            	</div>
            </c:forEach>
            </div>
            <script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
            <script src="./js/slick.min.js" type="text/javascript" charset="utf-8"></script>
            <script type="text/javascript">
              $(document).on('ready', function() {
                $(".sec3_box1").slick({
                  autoplay: true,
                  dots: true,
                  infinite: true,
                  slidesToShow: 1,
                  slidesToScroll: 1
                });
              });
            </script>
          </div>
          <aritcle class="corp_boxwrap">
          <c:forEach var="mainPageDeadLineVO" items="${mainPageDeadLineVOs}">
          	<div class="corp_box" onclick="location.href = './CorporationAction.cp?cp_idx=${mainPageDeadLineVO.cp_idx}';">
          		<div class="c_img">
                	<img src="./img/row3_noodle.jpg" alt="">
              	</div>
              	<div class="c_txt">
	                <p>${mainPageDeadLineVO.cp_sector }</p>
	                <h5>${mainPageDeadLineVO.cp_name } <span>마감임박</span></h5>
	                <p>${mainPageDeadLineVO.cp_branch }</p>
              	</div>
              	<div class="gage">
              		<div class="per"><span>${mainPageDeadLineVO.persent }</span>%
              			<ul id="timer_${mainPageDeadLineVO.cp_idx }">
              				<li><span id="days"></span>일</li>
		                    <li><span id="hours"></span> :</li>
		                    <li><span id="minutes"></span> :</li>
		                    <li><span id="seconds"></span></li>		                    
              			</ul>
              			<div class="gage_full">
                  			<div class="gage_fill"></div>
                		</div>
                		<div>
		                  <span class="p_amt"><span>${mainPageDeadLineVO.iv_current_amount }</span> / <span>${mainPageDeadLineVO.iv_goal_amount }</span> P</span>
		                  <span class="d_day">D-<span id="DDay_${mainPageDeadLineVO.cp_idx }">1</span></span>
		                </div>
              		</div>
              	</div>
              	<div class="reward_per">
              		수익률<span>${mainPageDeadLineVO.cp_monthly_profit}</span>
	            </div>
          	</div>
          </c:forEach>
          </aritcle>
        </div>
      </div>
    </section>
    <footer></footer>
  </div>

  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
      $('.map').load('./company/map.jsp')
    });
    
    $(function() {

      var i = 1;

      setInterval(function() {
        var liheight = $('.live_chart li').height();
        
        $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY(-'+ liheight*4 +'%)');
        setTimeout(function() {
          $('.live_chart li:nth-child(' + i + ') *').fadeOut(0);
          $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY('+ liheight*4 +'%)');

          $('.live_chart li:nth-child(' + i + ') a').text('바뀐 택스트')
          /*변수 값 바꾸는 스크립트를 넣어주시오*/
        }, 800);
        setTimeout(function() {

          $('.live_chart span:contains(▼)').css({
            'color': '#ff9124'
          });
          $('.live_chart span:contains(▲)').css({
            'color': '#73a6d6'
          });
          $('.live_chart li:nth-child(' + i + ') *').fadeIn(0);
          $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY(0px)');

          i = i + 1;
          if (i == 11) {
            i = 1;
          }
        }, 1000);

      }, 2000)


      $('.live_chart span:contains(▼)').css({
        'color': '#ff9124'
      });
      $('.live_chart span:contains(▲)').css({
        'color': '#73a6d6'
      });
    });
    //실시간 인기순위

    $(function() {
      $('.gage').each(function() {
        var percent = $(this).find('.per > span').text();

        $(this).find('.gage_fill').animate({
          'width': percent + '%'
        }, 1500);
      });
    });
    //게이지 바

    $(function() {

      $('.location li').hover(function() {
        var classname = $(this).attr('class')
        $('#map .' + classname).css('color', 'ff9124').css('transform', 'scale(1.05)');
      }, function() {
        var classname = $(this).attr('class')
        $('#map .' + classname).css('color', '#73a6d6').css('transform', 'scale(1)');
      });
    });
    //지도
  </script>
  <script>
	  const second = 1000,
      minute = second * 60,
      hour = minute * 60,
      day = hour * 24;
	  
	  $(document).ready(function(){
	      <c:forEach var="mainPageDeadLineVO" items="${mainPageDeadLineVOs}">
	      	setCountDown('${mainPageDeadLineVO.cp_idx}','${mainPageDeadLineVO.iv_appl_stop_date_time}');
	      </c:forEach>
	  });
	  
	  function setCountDown(cp_idx,stopDate){
		  var timer_day = document.getElementById('timer_'+cp_idx).childNodes.item(1).childNodes.item(0);
		  var timer_hour = document.getElementById('timer_'+cp_idx).childNodes.item(3).childNodes.item(0);
		  var timer_minute = document.getElementById('timer_'+cp_idx).childNodes.item(5).childNodes.item(0);
		  var timer_second = document.getElementById('timer_'+cp_idx).childNodes.item(7).childNodes.item(0);
		  var DDay = document.getElementById('DDay_'+cp_idx);
		  let countDown = new Date(stopDate).getTime(),
		  
		  x = setInterval(function() {
			  let now = new Date().getTime(),
			  distance = countDown - now;
			  timer_day.innerText = Math.floor(distance / (day)),
			  timer_hour.innerText = Math.floor((distance % (day)) / (hour)),
			  timer_minute.innerText = Math.floor((distance % (hour)) / (minute)),
			  timer_second.innerText = Math.floor((distance % (minute)) / second),
			  DDay.innerText= Math.floor(distance / (day))
			  
			  }, second)
	  };
  </script>

</body></html>
