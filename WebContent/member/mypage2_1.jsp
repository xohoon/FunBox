<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.member.dto.MemberTransactionVO"%>
<!DOCTYPE html>
<html lang="kr">
<% 
	ArrayList<MemberTransactionVO> transaction = (ArrayList<MemberTransactionVO>)request.getAttribute("transaction");
%>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>자산관리</title>

<!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage.css" rel="stylesheet">
<link href="css/mypage3.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
<script src="js/clipboard.min.js"></script>
<script src="js/jquery-3.1.1.min.js"></script>
<script src="member/js/mypage_token.js"></script>
</head>

<body>

	<div id="wrap">
		<header></header>
		<div class="hdbck"></div>
		<div class="toppdng"></div>
		<section>
			<div class="like_box"></div>
			<input type="hidden" value="${sessionScope.id }" id="session_value">
			<input type="hidden" value="${sessionScope.idx }" id="session_idx">
			<ul class="tab">
				<li id="invest_check">투자현황</li>
				<li class="on" onclick="location.href='./Mypage2_1.mb'">자산관리</li>
				<li onclick="location.href='./Mypage3.mb'">거래내역</li>
				<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
			</ul>
			<div class="asset">
				<div class="btn">
					<button class="on" onclick="location.href='./Mypage2_1.mb'">입출금관리</button>
					<button onclick="location.href='./Mypage2_2.mb'">포인트관리</button>
				</div>
				<!--btn-->
				<div class="b1">
					<div>
						<span>내 지갑주소<span>
								<div class="txt_wrap cf">
									<textarea id="bar" readonly>durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek</textarea>
									<button class="copybtn" data-clipboard-target="#bar"
										data-clipboard-action="copy">복사하기</button>
								</div>
					</div>
				</div>
				<div>
					<form id="form_deposit" action="MypageDeposit.mb" method="post">
						<div class="b2 cf">
							<h5>토큰받기</h5>
							<div>
								<label>보낸사람 지갑주소</label> <input type="text"
									name="td_from_address" id="token_wallet">
							</div>
							<div>
								<label>TX Hash</label> <input type="text" name="td_tx_hash" id="token_hash" onkeyup="characterCheck()" onkeydown="characterCheck()">
							</div>
							<div>
								<label>입금받을 수량</label> <input type="text" id="td_amount" name="td_amount"
									class="coin" value=""
									onKeydown="depositAmount(this.value)" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/><span>Coin</span>
								<div class="coinbtn">
									<input type="button" value="+1백만" class="cob cob1"> <input
										type="button" value="+5백만" class="cob cob2"> <input
										type="button" value="+1천만" class="cob cob3">
								</div>
								<p class="out">0</p>
							</div>
							<hr>
							<div class="sum">
								합계 <span id="sumcomma1">0</span> point
							</div>
							<input name="td_to_address" type="hidden" value="td_to_address">
							<input id="button_deposit" type="button" value="입금하기">
							<!-- <input type="submit" value="입금하기"> -->
						</div>
						<!--입금-->
					</form>
					<form id="form_sendToken" action="MypageSendToken.mb" method="post">
						<div class="b3 cf">
							<h5>토큰보내기</h5>
							<div>
								<label>받을사람 지갑주소</label> <input type="text" name="tk_to_address" id="tk_to_address">
							</div>
							<div>
								<label>출금할 수량</label> <input type="text" name="tk_amount"
									class="coin"
									onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" /><span>Coin</span>
								<div class="coinbtn">
									<input type="button" value="+1백만" class="cob cob1"> <input
										type="button" value="+5백만" class="cob cob2"> <input
										type="button" value="+1천만" class="cob cob3">
								</div>
								<p class="out">0</p>
							</div>
							<hr>
							<div class="sum">
								합계 <span id="sumcomma2">0</span> point
							</div>
							<!-- <input id="button_withdraw" type="button" value="출금하기" class="send_btn"> -->
							<input type="button" class="send_btn" value="출금하기">
						</div>
					</form>
					<!--출금하기-->
					<div id="send"></div>
				</div>
				<!--2-->
				<div class="b4 c">
					<h5>입출금내역</h5>
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
						<a href="./Mypage2_1.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a>
					</c:if>
						<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<b><a class="on" href="./Mypage2_1.mb?pageNum=${i}"><font size=3>${i}</font></a></b>
								</c:when>
								<c:otherwise>
									<li><a href="./Mypage2_1.mb?pageNum=${i}"><font size=3>${i}</font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
						<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./Mypage2_1.mb?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
						</c:if>
				</c:if>
			</ul><!--.pager-->
				</div>
			</div>
		</section>

		<footer></footer>
	</div>
	<script src="js/clipboard.min.js"></script>
	<script src="member/js/mypage2_1.js"></script>
	<script type="text/javascript" src="member/js/investment_status.js"></script>
</body>
</html>