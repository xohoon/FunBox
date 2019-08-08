<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="format-detection" content="telephone=no" />

  <title></title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <script src="js/jquery.mousewheel.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/mypage1_1.css" rel="stylesheet">
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
    <section>
      <div class="like_box"></div>
      <ul class="tab">
        <li id="invest_check" onclick="location.href='./MemberInvestmentList.mb'">투자현황</li>
		<li class="on" onclick="location.href='./Mypage2_1.mb'">자산관리</li>
		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
      </ul>
      <div class="con">
        <div class="cor_info">
          <div class="cor_ing">
            <p>아직 펀딩이 종료되지 않은 기업이에요 !</p>
            <p>펀딩 모집 완료 후에는 투자철회가 불가능합니다.</p>
            <ul>
              <li onclick="window.open('./MemberIvDropInfo.mb?mb_idx=${sessionScope.idx }&cp_idx=${cp_idx }','기업이름','width=640,height=400,top=0,left=0,scrollbars=yes');">펀딩 철회하기</li>
              <li onclick="location.href='./CorporationAction.cp?cp_idx=${boxs.getCp_idx() }'">기업정보 보러가기</li>
            </ul>
          </div>
        </div><!--.cor_info-->
        <div class="list">
        <p>
          내가 투자한 BOX<br>
          <span>20건</span>
        </p>
        <ul>
          <li onclick="location.href='./mypage1.html'">바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li class="on" onclick="location.href='./mypage1_1.html'">바른생선횟집(해운대점)<span class="ing">펀딩중</span></li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
          <li>바른생선횟집(해운대점)</li>
        </ul>
      </div>
      </div>
      <div class="b4 t">
        <h5>지급내역</h5>
        <table>
          <tr>
            <td>구분</td>
            <td>내용</td>
            <td>수량</td>
            <td>날짜</td>
            <td>회차</td>
          </tr>
          <tr>
            <td class="minus">투자</td>
            <td>바른생선회</td>
            <td class="minus">-1,000,000P</td>
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

      <script src="js/jquery-3.1.1.min.js"></script>
      <script type='text/javascript' src='js/jquery.mousewheel.js'></script>
      <script>
        $(function() {
          var h = $('.cor_info').height() + 32 ;
          var winW = $(window).width();
          var liOff = $('.cor_info').offset().top;
          var liOffs = liOff * 1 + 56
          if (winW > 1200) {
            $('.list').height(h);
          } else {
            $('.list').height(400);
            $('.list').offset({
              top: liOff
            })
          }
        });

        $('.list_show').on('click', function() {
          $('.list').toggleClass('on');
          if ($(this).text() == '투자리스트보기') {
            $(this).text('닫기');
          } else if ($(this).text() == '닫기') {
            $(this).text('투자리스트보기');
          }
        });

        $(function() {
          $(".rep").mousewheel(function(event, delta) {

            this.scrollLeft -= (delta * 100);

            event.preventDefault();
          });


        });
      </script>
</body>

</html>