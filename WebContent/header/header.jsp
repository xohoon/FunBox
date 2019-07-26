<%@page import="net.member.dto.Member_headerVO"%>
<%@page import="net.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <link href="css/HF.css" rel="stylesheet" type="text/css">
  <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
  
  <!--로그인 전-->
  <c:choose>
  <c:when test="${sessionScope.id eq null}">
  <div class="hdbar">
    <div class="inner">
      <h1><a href="./Index.mb"><img src="./img/logo.svg" alt="logo"></a></h1>
      <span>간편하고 쉬운 자산관리 펀박스</span>
      <div class="logbox">
        <a href="./JoinPage.mb">회원가입</a>
        <a href="./LoginPage.mb">로그인</a>
      </div>
      <div class="hdbtn">
        <div></div>
        <div></div>
        <div></div>
      </div>
    </div>
  </div>
  </c:when>


  

  <c:otherwise>
  <%
  	String idx = (String)session.getAttribute("idx");
    	System.out.println(">>>>>>>>>"+idx);
    	
    	MemberDAO memberDAO = new MemberDAO();
  	Member_headerVO member = memberDAO.Member_accumulate(idx);
  	System.out.println("point>>"+member.getMb_point()+"token"+member.getMb_token()+"누적"+member.getMb_accumulate());
  %>

  <div class="hdbar">
    <div class="inner">
      <h1><a href="./Index.mb"><img src="./img/logo.svg" alt="logo"></a></h1>
      <span>간편하고 쉬운 자산관리 펀박스</span>
      <div class="logbox">
        반갑습니다. <span>${sessionScope.id}</span> 회원님
        <a href="./member/logout.jsp">로그아웃</a>
      </div>
      <div class="hdbtn">
        <div></div>
        <div></div>
        <div></div>
      </div>
    </div>
  </div>

  <div class="hdinfo">
    <div class="inner">
      <div>
        <p><img src="./img/icon_fun.svg" alt="포인트수량">보유 펀토큰</p>
        <span><%=member.getMb_token() %></span> FUN
      </div>
      <div>
        <p><img src="./img/icon_point.svg" alt="포인트수량">보유 포인트</p>
        <span><%=member.getMb_point() %></span> P
      </div>
      <div>
        <p><img src="./img/icon_reward.svg" alt="포인트수량">누적 수익</p>
        <span><%=member.getMb_accumulate() %></span> P
      </div>
      <button onclick="location.href='./Mypage4_1.mb'">자산관리 바로가기</button>
    </div>
  </div>
  </c:otherwise>
  </c:choose>
  <!--로그인 후-->
  <div class="hdbody">
    <div class="inner">
      <h1><a href="./Index.mb"><img src="./img/logo.svg" alt="logo"></a></h1>
      <nav>
        <ul>
          <li>투자하기
            <ul>
              <li onclick="location.href='./List.bd'">프랜차이즈</li>
            </ul>
          </li>
          <li>기업신청
            <ul>
              <li onclick="location.href='./Application1.cp'">기업용 신청서 작성</li>
            </ul>
          </li>
          <li>회사소개
            <ul>
              <li onclick="location.href='./Intro.bd'">펀박스</li>
            </ul>
          </li>
          <li>고객지원
            <ul>
              <li onclick="location.href='./Notice.bd'">공지사항</li>
              <c:choose>
	              <c:when test="${sessionScope.id ne null}">
	              <li onclick="location.href='./BoardQnaList.bd'">1:1상담</li>
	              </c:when>
	              <c:otherwise>
	              <li>1:1상담</li>
	              </c:otherwise>
              </c:choose>
              <li onclick="location.href='./Faq.bd'">FAQ</li>
            </ul>
          </li>
        </ul>
      </nav>
    </div>
  </div>
  
  <div class="mobmenubg"></div>
  
  <div class="quickmenu">
    <ul>
      <li onclick="location.href='./List.bd'"><div></div>기업목록</li>
      <li onclick="location.href='./Mypage1.mb'"><div></div>기업관리</li>
      <li onclick="location.href='./Mypage2_1.mb'"><div></div>FBX 입·출금</li>
      <li onclick="location.href='./Mypage2_2.mb'"><div></div>P 환전</li>
    </ul>
  </div>
  
 <script>
  	$(function(){
      var hdbarheight = $('.hdbar').outerHeight();
      var hdinfoheight = $('.hdinfo').outerHeight();

      if (hdinfoheight == undefined) {
        hdinfoheight = 0
      }

      var menuheigth2 = hdbarheight + hdinfoheight + 72

     $('.toppdng').css('height', menuheigth2);

      var gnb = $('header'),
        delta = false,
        nowScroll,
        lastScroll = 0;

      $(window).resize(function() {
        gnb.css('top', '0');
        $('.quickmenu').css('bottom', '0');
        $('header').removeClass('on');
        $('body').removeClass('on');
        $('.hdbck').fadeOut(300);
      });

      $(window).on('scroll', function() {

        if ($(window).width() >= 767) {
          nowScroll = $(window).scrollTop();

          var hdbarheight = $('.hdbar').outerHeight();
          var hdinfoheight = $('.hdinfo').outerHeight();

          if (hdinfoheight == undefined) {
            hdinfoheight = 0
          }

          var menuheigth = hdbarheight + hdinfoheight

          if (nowScroll < lastScroll) {
            
            if (delta) {
              gnb.stop().css('top','0')
              delta = false;
            }
          } else {
            if (delta == false) {
              gnb.stop().css('top', '-' + menuheigth + 'px');
              delta = true;
            }
          }

          lastScroll = $(window).scrollTop();
        } else{
          nowScroll = $(window).scrollTop();
          var hdbarheight = $('.hdbar').outerHeight();
          var quickmenuheight = $('.quickmenu').outerHeight();
          
          if (nowScroll < lastScroll) {
            if (delta) {
              gnb.stop().stop().css('top','0')
              $('.quickmenu').stop().css('bottom','0')
              delta = false;
            }
          } else {
            if (delta == false) {
              gnb.stop().css('top','-' + hdbarheight + 'px');
               $('.quickmenu').stop().css('bottom','-' + quickmenuheight + 'px');
              delta = true;
            }
          }

          lastScroll = $(window).scrollTop();
        }
      });

      $('.hdbtn').on('click', function() {
        $('header').toggleClass('on');
        $('.hdbck').fadeToggle(300);
        $('body').toggleClass('on');
      });
      
    });
<<<<<<< HEAD
   
=======
   /*링크 루트 이해를 위한 임시링크제이쿼리 - 개발자분들 작업하실 때 삭제 해주시면 됩니다*/
   /*링크 루트 이해를 위한 임시링크제이쿼리 - 개발자분들 작업하실 때 삭제 해주시면 됩니다*/
>>>>>>> branch 'master' of https://github.com/xohoon/FunBox.git
  </script>
