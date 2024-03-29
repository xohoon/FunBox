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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- wedqdwq -->
<%
	ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = (ArrayList<MainPageDateOfOpenVO>)request.getAttribute("mainPageDateOfOpenVOs");
	ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = (ArrayList<MainPageDeadLineVO>)request.getAttribute("mainPageDeadLineVOs");
	Main_CityVO cityVO = (Main_CityVO)request.getAttribute("cityVO");
%>

<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>메인 화면</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" type="text/css" href="./css/slick.css">
  <link rel="stylesheet" type="text/css" href="./css/slick-theme.css">
  

  <link href="css/index.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>
  <script src="js/index_function.js"></script>
  <script type="text/javascript" src="js/index.js"></script>
</head>

<body>
<input type="hidden" id="select_k" value="0">
<input type="hidden" id="select_k" value="0">
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    <section id="sec1">
      <div class="inner">
        <div class="regular slider">
        <c:forEach var="slideVO" items="${slideVO}" varStatus="status">
	        <a href="./CorporationAction.cp?cp_idx=${slideVO.sl_cp_idx }">
	          <div>
	            <div class="slide" id="slide_${status.count }">
	            <img src="<c:url value="${resourcePath }/CompanyFile/${slideVO.banner_image }"/>" alt="">
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
          <ul class="list_ul">
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
	            <img src="${likeVO.thumbnail_image }" alt="">
	          </div>
	          <div class="c_txt">
	            <p>${likeVO.lk_cp_sector }</p>
	            <h5>${likeVO.lk_cp_name }<span>추천</span></h5>
	            <p>${likeVO.lk_cp_branch }</p>
	          </div>
	          <div class="gage">
	            <div class="per">
	            	<span><fmt:parseNumber value ="${likeVO.lk_cp_percent }" integerOnly ="true" /></span>%
	            </div>	            
	            <div class="gage_full">
	              <div class="gage_fill">
	              	<span></span>
	              </div>
	            </div>
	            <div>
	              <span class="p_amt"><span><fmt:formatNumber value="${likeVO.lk_cp_current_amount}" pattern="#,###" />
	              </span> / <span> <fmt:formatNumber value="${likeVO.lk_cp_goal_amount }" pattern="#,###" />
	              </span> P</span>
	              <span class="d_day">D-<span id="like_DDay_${likeVO.lk_cp_idx }">1</span></span>
	            </div>
	          </div>
	          <div class="reward_per">
	            수익률
	            <span>${likeVO.lk_cp_profit }%</span>
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
              <li class="local01">서울(<span id="seoul_count">${cityVO.seoul }</span>)</li>
              <li class="local02">경기(<span id="gyeonggi_count">${cityVO.gyeonggi }</span>)</li>
              <li class="local03">인천(<span id="incheon_count">${cityVO.incheon }</span>)</li>
              <li class="local04">강원(<span id="gangwon_count">${cityVO.gangwon }</span>)</li>
              <li class="local05">대전·충청(<span id="daejeonNchungcheong_count">${cityVO.daejeonNchungcheong }</span>)</li>
              <li class="local06">대구(<span id="daegu_count">${cityVO.daegu }</span>)</li>
              <li class="local07">부산(<span id="busan_count">${cityVO.busan }</span>)</li>
              <li class="local08">울산(<span id="ulsan_count">${cityVO.ulsan }</span>)</li>
              <li class="local09">경상(<span id="gyeongsang_count">${cityVO.gyeongsang }</span>)</li>
              <li class="local10">광주·전라(<span id="gwangjuNjeonla_count">${cityVO.gwangjuNjeonla }</span>)</li>
              <li class="local11">제주(<span id="jeju_count">${cityVO.jeju }</span>)</li>
            </ul>
          </div>
        </div>

        <div class="inright"> 
          <div class="comingsoon_box">
            <div class="sec3_box1 slider">
            <c:forEach var="mainPageDateOfOpenVO" items="${mainPageDateOfOpenVOs}" varStatus="status">
            	<div>
            		<div class="slide slide${status.count}" onclick="location.href = './CorporationAction.cp?cp_idx=${mainPageDateOfOpenVO.cp_idx}';">
            			<img src="<c:url value="${resourcePath }/CompanyFile/${mainPageDateOfOpenVO.banner_image }"/>" alt="">
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
                	<img src="${mainPageDeadLineVO.thumbnail_image }" alt="">
              	</div>
              	<div class="c_txt">
	                <p>${mainPageDeadLineVO.cp_sector }</p>
	                <h5>${mainPageDeadLineVO.cp_name } <span>마감임박</span></h5>
	                <p>${mainPageDeadLineVO.cp_branch }</p>
              	</div>
              	<div class="gage">
              		<div class="per"><span><fmt:parseNumber value ="${mainPageDeadLineVO.persent }" integerOnly ="true" /></span>%
              			<ul id="timer_${mainPageDeadLineVO.cp_idx }">
              				<li><span id="days"></span>일</li>
		                    <li><span id="hours"></span> :</li>
		                    <li><span id="minutes"></span> :</li>
		                    <li><span id="seconds"></span></li>		                    
              			</ul>
              		</div>
              			<div class="gage_full">
                  			<div class="gage_fill">
                  				<span></span>
                  			</div>                  			
                		</div>
                		<div>
		                  <span class="p_amt"><span><fmt:formatNumber value="${mainPageDeadLineVO.iv_current_amount }" pattern="#,###" />
		                  </span> 
		                  / <span><fmt:formatNumber value="${mainPageDeadLineVO.iv_goal_amount }" pattern="#,###" />
		                  </span> P</span>
		                  <span class="d_day">D-<span id="DDay_${mainPageDeadLineVO.cp_idx }">1</span></span>
		                </div>
              		
              	</div>
              	<div class="reward_per">
              		수익률<span>${mainPageDeadLineVO.cp_monthly_profit}%</span>
	            </div>
          	</div>
          </c:forEach>
          </aritcle>
        </div>
      </div>
    </section>
    <footer></footer>
  </div>
<!-- 
<script>
////////////////////////////////////////// 태훈 추가
$(document).ready(function() {
	city_click();
});
/////////////// 태훈 - 도시 클릭시 제어 기능
function city_click() {
	$(".local01").on('click', function() {
		if($("#seoul_count").text() != 0) {
			location.href="./ListAction.bd?cityName=10";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local02").on('click', function() {
		if($("#gyeonggi_count").text() != 0) {
			location.href="./ListAction.bd?cityName=11";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});$(".local03").on('click', function() {
		if($("#incheon_count").text() != 0) {
			location.href="./ListAction.bd?cityName=12";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local04").on('click', function() {
		if($("#gangwon_count").text() != 0) {
			location.href="./ListAction.bd?cityName=13";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local05").on('click', function() {
		if($("#daejeonNchungcheong_count").text() != 0) {
			location.href="./ListAction.bd?cityName=14";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local06").on('click', function() {
		if($("#daegu_count").text() != 0) {
			location.href="./ListAction.bd?cityName=15";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local07").on('click', function() {
		if($("#busan_count").text() != 0) {
			location.href="./ListAction.bd?cityName=16";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local08").on('click', function() {
		if($("#ulsan_count").text() != 0) {
			location.href="./ListAction.bd?cityName=17";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local09").on('click', function() {
		if($("#gyeongsang_count").text() != 0) {
			location.href="./ListAction.bd?cityName=18";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local10").on('click', function() {
		if($("#gwangjuNjeonla_count").text() != 0) {
			location.href="./ListAction.bd?cityName=19";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local11").on('click', function() {
		if($("#jeju_count").text() != 0) {
			location.href="./ListAction.bd?cityName=20";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
}
</script>


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

          $('.live_chart li:nth-child(' + i + ') a').text(cp_name_list[i-1]);
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
            //Delay_func();
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
	  -->
	  <script type="text/javascript">
	  $(document).ready(function(){
		  <c:forEach var="slideVO" items="${slideVO}" varStatus="status">
		  	document.getElementById('slide_${status.count}').style.background = 'url(${slideVO.banner_image}) no-repeat center top';
		  </c:forEach>
		  <c:forEach var="item" items="${likeVO}">
	      	setLikeDday('${item.lk_cp_idx}','${item.lk_appl_stop_date_time}');
	      </c:forEach>
	      <c:forEach var="mainPageDeadLineVO" items="${mainPageDeadLineVOs}">
	      	setCountDown('${mainPageDeadLineVO.cp_idx}','${mainPageDeadLineVO.iv_appl_stop_date_time}');
	      </c:forEach>
	  });
	  
	 
	 /* function setCountDown(cp_idx,stopDate){
		  var timer_day = document.getElementById('timer_'+cp_idx).childNodes.item(1).childNodes.item(0);
		  var timer_hour = document.getElementById('timer_'+cp_idx).childNodes.item(3).childNodes.item(0);
		  var timer_minute = document.getElementById('timer_'+cp_idx).childNodes.item(5).childNodes.item(0);
		  var timer_second = document.getElementById('timer_'+cp_idx).childNodes.item(7).childNodes.item(0);
		  var DDay_tag = document.getElementById('DDay_'+cp_idx);
		  let countDown = new Date(stopDate).getTime(),
		  
		  x = setInterval(function() {
			  let now = new Date().getTime(),
			  distance = countDown - now;
			  timer_day.innerText = Math.floor(distance / (day)),
			  timer_hour.innerText = Math.floor((distance % (day)) / (hour)),
			  timer_minute.innerText = Math.floor((distance % (hour)) / (minute)),
			  timer_second.innerText = Math.floor((distance % (minute)) / second)
			  var Dday = Math.floor(distance / (day));
			  if (Dday == 0) {
				  DDay_tag.parentNode.innerText = '펀딩 기간 종료';
			  }else{
				  DDay_tag.innerText = Dday;
			  }
			  }, second)
	  };
	  function setDday(cp_idx,stopDate){
		  var DDay_tag = document.getElementById('like_DDay_'+cp_idx);
		  let countDown = new Date(stopDate).getTime();
		  let now = new Date().getTime();
		  distance = countDown - now;
		  var Dday = Math.floor(distance / (day));
		  if (Dday == 0) {
			  DDay_tag.parentNode.innerText = '펀딩 기간 종료';
		  }else{
			  DDay_tag.innerText = Dday;
		  }
	  };
	  
	  function setLikeDday(cp_idx,stopDate){
		  var DDay = document.getElementById('like_DDay_'+cp_idx);
		  let countDown = new Date(stopDate).getTime();
		  let now = new Date().getTime();
		  distance = countDown - now;
		  
		  var DdayCount = Math.floor(distance / (day));
		  
		  if (DdayCount <= 0) {
			  DDay.parentElement.innerText = "편딩 기간 종료"
		  }else{
			  DDay.innerText= DdayCount;  
		  }
	  };
	  function setDday(cp_idx,stopDate){
		  var DDay_tag = document.getElementById('like_DDay_'+cp_idx);
		  let countDown = new Date(stopDate).getTime();
		  let now = new Date().getTime();
		  distance = countDown - now;
		  var Dday = Math.floor(distance / (day));
		  if (Dday == 0) {
			  DDay_tag.parentNode.innerText = '펀딩 기간 종료';
		  }else{
			  DDay_tag.innerText = Dday;
		  }
	  }; */
  </script> 
  


</body></html>
