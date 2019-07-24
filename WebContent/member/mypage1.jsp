<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <meta name="format-detection" content="telephone=no" />

  <title>투자현황</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/mypage.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
  <script src="js/jquery.mousewheel.js"></script>
   <script src="js/jquery-3.1.1.min.js"></script>
  <script>
    $(function() {
    	$('header').load('./header/header.jsp')
        $('footer').load('./footer/footer.jsp')
        $('.like_box').load('./member/like_box.jsp')
    });	 
    alert('ddd');
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
    		<li class="on" onclick="location.href='./Mypage1.mb'">투자현황</li>
    		<li onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
    	</ul>
		<div class="con">
  <ul>
    <li>
      <img src="img/ico_fin1.jpg" alt="투자현황"><p>
        기업명</p><span>바른생선횟집<span>해운대점</span></span>
    </li>
    <li>
      <img src="img/ico_fin2.jpg" alt="투자현황"><p>
      보유구좌</p><span>5구좌</span>
    </li>
    <li>
      <img src="img/ico_fin3.jpg" alt="투자현황"><p>
      구좌가치</p><span>50,000P</span>
    </li>
    <li>
      <img src="img/ico_fin4.jpg" alt="투자현황"><p>
      당월수익</p><span>30,000P</span>
    </li>
    <li>
      <img src="img/ico_fin5.png" alt="투자현황"><p>
      누적수익</p><span>30,000P</span>
    </li>
  </ul>
  <button class="list_show">투자리스트보기</button>
  <div class="cor_info">
    <h5>기업정보</h5>
    <div>
      <h6>기본정보</h6>
      <table>
        <tr>
          <td>대표자</td>
          <td>땡땡땡</td>
        </tr>
        <tr>
          <td>사업자 등록번호</td>
          <td>841-86-00000</td>
        </tr>
        <tr>
          <td>자본금</td>
          <td>3억</td>
        </tr>
        <tr>
          <td>본사주소</td>
          <td>부산시 해운대구</td>
        </tr>
      </table>
    </div>
    <div>
      <h6>참고자료</h6>
      <a href="#" download>해당 업종 자격증 사본.jpg <i class="fas fa-download"></i></a>
      <a href="#" download>부동산 임대차 계약서 사본.jpg <i class="fas fa-download"></i></a>
      <a href="#" download>사업자 등록증 사본.jpg <i class="fas fa-download"></i></a>
      <select>
        <option>2019년 6월</option>
        <option>2019년 5월</option>
        <option>2019년 4월</option>          
      </select>
      <a href="#" download>재무제표 <i class="fas fa-download"></i></a>
    </div>
    <div class="rep">
      <h6>예상 지급 스케쥴</h6>
      <div>
        <table>
          <tr>
            <th>지급회차</th>
            <th>예상 지급일</th>
            <th>원금</th>
            <th>지급이자</th>
            <th>플랫폼 이용료</th>
            <th>실 지급금액</th>
            <th>실 수익률</th>
          </tr>
          <tr>
            <td>1 회차</td>
            <td>2019.09.01</td>
            <td>0원</td>
            <td>25,111원</td>
            <td>2,636원</td>
            <td>22,475원</td>
            <td>0.75%</td>
          </tr>
          <tr>
            <td>2 회차</td>
            <td>2019.10.01</td>
            <td>0원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>3 회차</td>
            <td>2019.11.01</td>
            <td>0원</td>
            <td>25,111원</td>
            <td>2,636원</td>
            <td>22,475원</td>
            <td>0.75%</td>
          </tr>
          <tr>
            <td>4 회차</td>
            <td>2019.12.01</td>
            <td>0원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>5 회차</td>
            <td>2020.01.01</td>
            <td>0원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>6 회차</td>
            <td>2020.02.01</td>
            <td>0원</td>
            <td>23,437원</td>
            <td>2,460원</td>
            <td>20,997원</td>
            <td>0.74%</td>
          </tr>
          <tr>
            <td>7 회차</td>
            <td>2020.03.01</td>
            <td>0원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>8 회차</td>
            <td>2020.04.01</td>
            <td>0원</td>
            <td>25,111원</td>
            <td>2,636원</td>
            <td>22,475원</td>
            <td>0.75%</td>
          </tr>
          <tr>
            <td>9 회차</td>
            <td>2020.05.01</td>
            <td>0원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>10 회차</td>
            <td>2020.06.01</td>
            <td>0원</td>
            <td>25,111원</td>
            <td>2,636원</td>
            <td>22,475원</td>
            <td>0.75%</td>
          </tr>
          <tr>
            <td>11 회차</td>
            <td>2020.07.01</td>
            <td>0원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>12 회차</td>
            <td>2020.08.01</td>
            <td>3,000,000원</td>
            <td>25,948원</td>
            <td>2,724원</td>
            <td>23,224원</td>
            <td>0.77%</td>
          </tr>
          <tr>
            <td>총 합계</td>
            <td>-</td>
            <td>3,000,000원</td>
            <td>305,520원</td>
            <td>32,080원</td>
            <td>273,470원</td>
            <td>9.13%</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</div>
<div class="list">
  <p>
    내가 투자한 BOX<br>
    <span>20건</span>
  </p>
  <ul>
      <li class="on">바른생선횟집(해운대점)</li>
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
      <li>바른생선횟집(해운대점)</li>
      <li>바른생선횟집(해운대점)</li>
  </ul>
</div>
<div class="b4 t">
  <h5>투자내역</h5>
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
   
<script src="js/jquery-3.1.1.min.js"></script>
<script type='text/javascript' src='js/jquery.mousewheel.js'></script>
<script>
$(function(){
   var h = $('.con').height();
    var winW = $(window).width();
    var liOff = $('.list_show').offset().top;
    var liOffs = liOff*1+56
    if(winW>1200){
        $('.list').height(h);
    }else{
        $('.list').height(400);
        $('.list').offset({top:liOffs})
    }
});

 $('.list_show').on('click',function(){
     $('.list').toggleClass('on');
     if( $(this).text() == '투자리스트보기' ) {
      $(this).text('닫기');
    }
    else if($(this).text() == '닫기'){
      $(this).text('투자리스트보기');
    }
 });

$(function(){
    $(".rep").mousewheel(function(event, delta) {

      this.scrollLeft -= (delta * 100);

      event.preventDefault();
    });
	
	
});
</script>
</body>
</html>