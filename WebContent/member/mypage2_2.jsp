<%@page import="net.member.dto.MemberInvestVO"%>
<%@page import="net.member.dto.Member_headerVO"%>
<%@page import="net.member.dto.benefitVO"%>
<%@page import="net.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.member.dto.MypagePointTransactionVO"%>
<!DOCTYPE html>
<html lang="kr">
<% 
	ArrayList<MypagePointTransactionVO> transaction = (ArrayList<MypagePointTransactionVO>)request.getAttribute("transaction");
	String idx = (String)session.getAttribute("idx");
	MemberDAO memberDAO = new MemberDAO();
	Member_headerVO member = (Member_headerVO)memberDAO.Member_accumulate(idx);
	
	MemberDAO memberDAO2 = new MemberDAO();
  	benefitVO benefit = (benefitVO)memberDAO2.benefit(idx);
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
  <link href="css/mypage.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
  
</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    <input type="hidden" value="${sessionScope.id }" id="session_value">
	<input type="hidden" value="${sessionScope.idx }" id="session_idx">
    <section>
    	<div class="like_box"></div>
    	<ul class="tab">
    		<li id="invest_check">투자현황</li>
    		<li class="on" onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
		</ul>
 		<div class="asset">
			<div class="btn">
				<button onclick="location.href='./Mypage2_1.mb'">입출금관리</button>
				<button class="on" onclick="location.href='./Mypage2_2.mb'">포인트관리</button>
			</div><!--btn-->
			<div class="b1 brif">
			<div>
				<div class="cf">
					<p>현재 보유 포인트</p>
					<p><fmt:formatNumber value="<%=member.getMb_point() %>" pattern="#,###" /> P</p>
				</div>
				<div class="cf">
					<p>충전 가능 포인트</p>
					<p><fmt:formatNumber value="<%=member.getMb_token() %>" pattern="#,###" /> P</p>
				</div>
				<div class="cf">
					<p>이번달 수익</p>
					<p><fmt:formatNumber value="<%=benefit.getMonth_benefit() %>" pattern="#,###" /> P</p>
				</div>
				<div class="cf">
					<p>총 누적 수익</p>
					<p><fmt:formatNumber value="<%=benefit.getTotal_benefit()%>" pattern="#,###" /> P</p>
				</div>
				</div>
			</div>
			<div>
					<div class="b2 cf">
						<h5>포인트 충전하기</h5>
						<div>
							<label>충전할 포인트</label>
							<p class="cf">
								<span>100,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num1">
									<button class="up">+</button>
								</span>
							</p>
							<p class="cf">
								<span>500,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num2">
									<button class="up">+</button>
								</span>
							</p>
							<p class="cf">
								<span>1,000,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num3">
									<button class="up">+</button>
								</span>
							</p>
							<p class="cf">
								<span>10,000,000 POINT</span>
								<span>
									<button class="down">-</button>
									<input type="number" min="0" step="1" value="0" class="num4">
									<button class="up">+</button>
								</span>
							</p>
						</div>
						<hr>
						<div class="coinout">-1,000,000 Coin</div>
						<div class="sum po">
						    합계 <span class="sumcomma1">0</span> point
						</div>
						<input type="button" value="충전하기" class="char_btn">
						<div id="char"></div>
					</div><!--입금-->
				<div class="b3 cf">
					<h5>토큰으로 환전하기</h5>
					<div>
						<label>환전할 포인트</label>
						<input type="text" class="coin" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/><span>POINT</span>
						<div class="coinbtn">
						<input type="button" value="+1백만" class="cob cob1">
						<input type="button" value="+5백만" class="cob cob2">
						<input type="button" value="+1천만" class="cob cob3">
						</div>
						<p class="out toco">0</p>
					</div>
					<hr>
					<div class="coinout">+1,000,000 Coin</div>
					<div class="sum">
					    합계 <span class="sumcomma2">0</span> point
					</div>
					<input type="button" value="환전하기" class="ex_btn">
					<div id="exch"></div>
				</div><!--출금하기-->
			</div><!--2-->
			<div class="b4 p">
			<h5>포인트내역</h5>
				<table>
					<tr>
						<td>구분</td>
						<td>토큰수량</td>
						<td>포인트수량</td>
						<td>날짜</td>
					</tr>
					<c:forEach var = "transaction" items="${transaction}">
						<tr>
						<c:choose>														
							<c:when test="${transaction.po_category == '2'}" >
								<td class="minus">환전</td>																
								<td>-<fmt:formatNumber value="${transaction.tk_amount}" pattern="#,###" /> FBX</td>
								<td>+<fmt:formatNumber value="${transaction.po_amount}" pattern="#,###" /> P</td>								
								<td>${transaction.po_date_time}</td>					
							</c:when>
							<c:when test="${transaction.po_category == '3'}" >
								<td class="plus">충전</td>																
								<td>+<fmt:formatNumber value="${transaction.tk_amount}" pattern="#,###" /> FBX</td>
								<td>-<fmt:formatNumber value="${transaction.po_amount}" pattern="#,###" /> P</td>								
								<td>${transaction.po_date_time}</td>					
							</c:when>						
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
						<a href="./Mypage2_2.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a>
					</c:if>
						<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<b><a class="on" href="./Mypage2_2.mb?pageNum=${i}"><font size=3>${i}</font></a></b>
								</c:when>
								<c:otherwise>
									<li><a href="./Mypage2_2.mb?pageNum=${i}"><font size=3>${i}</font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
						<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./Mypage2_2.mb?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
						</c:if>
					</c:if>
				</ul><!--.pager-->
			</div>
		</div>
    </section>
  <script src="member/js/mypage2_2.js"></script>
    <footer></footer>
  </div>
</body>
</html>
