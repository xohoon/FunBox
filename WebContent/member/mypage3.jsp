<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="net.member.dto.MemberTransactionVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="kr">
<% 
	ArrayList<MemberTransactionVO> transaction = (ArrayList<MemberTransactionVO>)request.getAttribute("transaction");
%>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>거래내역</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/mypage.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
   <script src="js/jquery-3.1.1.min.js"></script>
   <script src="member/js/mypage_functions.js"></script>
   <style>
	div td {
  	overflow: hidden; 
  	text-overflow: ellipsis;
  	white-space: nowrap; 
  	width: 300px;
  	height: 20px;
	}
	</style>
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
    	<input type="hidden" value="${sessionScope.id }" id="session_value">
    	<ul class="tab">
    		<li id="invest_check">투자현황</li>
    		<li onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li class="on" onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
		</ul>
		<div class="list_all">
		    <div class="cf">
			    <h5>거래내역</h5>
                <div class="button">
                    <button id = "button1" value = "1" class="on">입출금내역</button>
                    <button id = "button2" value = "2">포인트내역</button>
                    <button id = "button3" value = "3">투자내역</button>
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
					<c:forEach var = "transaction" items="${transaction}">
						<tr>
						<c:choose>
							<c:when test="${transaction.td_to_address == 'durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'}"  >
								<td class="plus">입금</td>
								<c:if test="${transaction.td_status == '0'}">
									<td>대기</td>
								</c:if>
								<c:if test="${transaction.td_status == '1'}">
									<td>수락</td>
								</c:if>
								<c:if test="${transaction.td_status == '2'}">
									<td>취소</td>
								</c:if>								
								<div>
									<td>${transaction.td_to_address}</td>
								</div>
								<td class="plus">+${transaction.td_amount}</td>
								<td>${transaction.td_date_time}</td>
							</c:when>
							<c:otherwise> 
								<td class="minus">출금</td>
								<c:if test="${transaction.td_status == '0'}">
									<td>대기</td>
								</c:if>
								<c:if test="${transaction.td_status == '1'}">
									<td>수락</td>
								</c:if>
								<c:if test="${transaction.td_status == '2'}">
									<td>취소</td>
								</c:if>
								<td>${transaction.td_to_address}</td>
								<td class="minus">-${transaction.td_amount}</td>
								<td>${transaction.td_date_time}</td>
							</c:otherwise>
						</c:choose>
					  </tr>
					</c:forEach>				
					
				</table>
			<ul class="pager">
				<c:if test="${count > 0}">
					<c:set var="pageCount"
						value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
					<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
					<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
						<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
						<c:if test="${numPageGroup > 1}">
						<a href="./Mypage3.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a>
					</c:if>
						<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<b><a class="on" href="./Mypage3.mb?pageNum=${i}"><font size=3>${i}</font></a></b>
								</c:when>
								<c:otherwise>
									<li><a href="./Mypage3.mb?pageNum=${i}"><font size=3>${i}</font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
						<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./Mypage3.mb?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
						</c:if>
				</c:if>
			</ul><!--.pager-->
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
