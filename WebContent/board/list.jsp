<%@page import="net.board.dto.Board_Search_ListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="net.company.dto.CompanyBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	ArrayList<Board_Search_ListVO> searchVO = (ArrayList<Board_Search_ListVO>)request.getAttribute("searchVO");
	System.out.println("list>>>>>"+searchVO);
	String cityName = (String)request.getAttribute("cityName");
%>
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
  <link href="css/list.css" rel="stylesheet">

  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.scrollstop.js"></script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>

    <section id="sec1">
      <div class="inner">
        <article class="search_bar">
          <div class="view_type">
            <span class="view_type_ract on"></span>
            <span class="view_type_wide"></span>
          </div>

          <div class="search">
            <input type="search" placeholder="추천 키워드 '바른생선회'">
            <input type="button" value="검색">
          </div>

          <div class="list_set">
            <select>
              <option>등록순</option>
              <option>추천순</option>
              <option>수익순</option>
            </select>
          </div>

          <div class="filter">
            <div></div>
            <div></div>
          </div>
          <div class="f_list">
            <form>
              <div class="f_list_type1">
                <h2>업종</h2>
                <span>
                  <input type="checkbox" id="con1_all">
                  <label for="con1_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_1">
                  <label for="con1_1">한식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_2">
                  <label for="con1_2">분식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_3">
                  <label for="con1_3">일식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_4">
                  <label for="con1_4">중식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_5">
                  <label for="con1_5">양식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_6">
                  <label for="con1_5">카페</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_7">
                  <label for="con1_5">치킨</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_8">
                  <label for="con1_5">기타</label>
                </span>
              </div>

              <div class="f_list_type2">
                <h2>지역</h2>
                <span>
                  <input type="checkbox" id="con2_all">
                  <label for="con2_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_1">
                  <label for="con2_1">서울</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_2">
                  <label for="con2_2">경기</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_3">
                  <label for="con2_3">인천</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_4">
                  <label for="con2_4">강원</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_5">
                  <label for="con2_5">대전/충천</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_6">
                  <label for="con2_6">대구</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_7">
                  <label for="con2_7">부산</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_8">
                  <label for="con2_8">울산</label>
                </span>
                <span>
                  <input type="checkbox" name="18">
                  <label for="con2_8">경상</label>
                </span>
                <span>
                  <input type="checkbox" name="19">
                  <label for="con2_8">광주/전라</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_9">
                  <label for="con2_all">제주</label>
                </span>
              </div>

              <div class="f_list_type3">
                <h2>현황</h2>
                <span>
                  <input type="checkbox" id="con3_all">
                  <label for="con3_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_1">
                  <label for="con3_1">대기중</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_2">
                  <label for="con3_2">펀딩중</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_3">
                  <label for="con3_3">펀딩완료</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_4">
                  <label for="con3_4">수익 분배중</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_4">
                  <label for="con3_4">수익 분배완료</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_4">
                  <label for="con3_4">연체중</label>
                </span>
              </div>
            </form>
          </div>
        </article>
      </div>
    </section>

    <section id="sec2">
      <div class="inner">
	        <div class="mom_box">
	          <div class="boxwrap">
        <c:forEach var="searchVO" items="${searchVO }">
	            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
	              <div class="c_img">
	                <img src="./img/row1_anotherminae.jpg" alt="">
	              </div>
	              <div class="c_txt">
	                <p>${searchVO.search_cp_sector }</p>
	                <h5>${searchVO.search_cp_name } <span>추천</span></h5>
	                <p>${searchVO.search_cp_branch }</p>
	              </div>
	              <div class="gage">
	                <div class="per"><span>${searchVO.search_cp_percent }</span>%</div>
	                <div class="gage_full">
	                  <div class="gage_fill"></div>
	                </div>
	                <div>
	                  <span class="p_amt"><span>${searchVO.search_cp_current_amount }</span> / <span>${searchVO.search_cp_goal_amount }</span> P</span>
	                  <span class="d_day">D-<span>27</span></span>
	                </div>
	              </div>
	              <div class="reward_per">
	                수익률
	                <span>${searchVO.search_cp_profit }</span>
	              </div>
	            </div>
        </c:forEach>
	          </div>
	        </div>

        <div class="scrolload">
          <div class="loader">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
          </div>
        </div>

        <button class="moreBtn">더보기 <span>▼</span></button>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <footer></footer>
  </div>
  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')

      $('.filter').on('click', function() {
        $('.search_bar').toggleClass('on');
      });
    });

    $(function() {
      $('.view_type_ract').on('click', function() {
        $('.view_type span').removeClass('on');
        $(this).addClass('on');
        $('.corp_box').removeClass('wide_box')
      });
      $('.view_type_wide').on('click', function() {
        $('.view_type span').removeClass('on');
        $(this).addClass('on');
        $('.corp_box').addClass('wide_box')
      });
    });

    $(function() {

      $('.gage').each(function() {
        var percent = $(this).find('.per > span').text();

        $(this).find('.gage_fill').animate({
          'width': percent + '%'
        }, 1500);
      });


      var currentscroll = 0;
      var lastscroll = 0;


      $(window).on('scrollstop', function() {
        var randomarti = Math.ceil(Math.random() * 6)
        var randomnum = (randomarti + 4) * 100
        var clonedata = $('.mom_box').html();
        var htmlheight = $('html').outerHeight();
        var veiwheight = $(window).height();
        var trigger = htmlheight - veiwheight - 20

        if (currentscroll < trigger) {
          currentscroll = $(window).scrollTop();
        }
        //alert(lastscroll)

        if (lastscroll = trigger && currentscroll > trigger) {

          $('.loader').stop().fadeIn(100);
          lastscroll = $(window).scrollTop()

          $('.scrolload').stop().append(clonedata)

          var foot = $('footer').offset().top

          /*
          var movingpoint = foot - veiwheight * 1.3

          $('html').stop().animate({
            scrollTop: movingpoint
          }, 0)          
          */

          setTimeout(function() {
            $('.scrolload > .boxwrap').addClass('on')
            $('.loader').stop().fadeOut(randomnum);

            $('.gage').each(function() {
              var percent = $(this).find('.per > span').text();

              $(this).find('.gage_fill').animate({
                'width': percent + '%'
              }, 1500);
            });
          }, randomnum);
        }
      });

      $('.moreBtn').on('click', function() {
        var randomarti = Math.ceil(Math.random() * 6)
        var randomnum = (randomarti + 4) * 100
        var clonedata = $('.mom_box').html();

        $('.loader').stop().fadeIn(100);
        $('.scrolload').stop().append(clonedata)

        setTimeout(function() {
          $('.scrolload > .boxwrap').addClass('on')
          $('.loader').stop().fadeOut(randomnum);

          $('.gage').each(function() {
            var percent = $(this).find('.per > span').text();

            $(this).find('.gage_fill').animate({
              'width': percent + '%'
            }, 1500);
          });
        }, randomnum);
      });

    });
    
    $(document).ready(function(){
    	
    	$("input[name$='"+<%=cityName%>+"']").prop("checked", true);
    	
    	var cityName = <%=cityName%>
    	if(cityName != null){
	    	$('.search_bar').toggleClass('on');
    	}
    });
  </script>
</body></html>
