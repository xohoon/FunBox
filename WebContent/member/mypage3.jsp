<%@page import="oracle.net.aso.s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="net.member.dto.MemberTransactionVO"%>
<%@page import="net.member.dto.MypagePointTransactionVO"%>
<%@page import="net.member.dto.MemberInvestVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="kr">
<%
	ArrayList<MemberTransactionVO> transaction = (ArrayList<MemberTransactionVO>)request.getAttribute("transaction");
	ArrayList<MypagePointTransactionVO> transactionP = (ArrayList<MypagePointTransactionVO>)request.getAttribute("transactionP");
	String category = request.getParameter("category");
	ArrayList<MemberInvestVO> member_invest_list = (ArrayList<MemberInvestVO>)request.getAttribute("member_invest_list");
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
	td {
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
  <script>
  	function cateval(category){  		
  		 location.href='./Mypage3.mb?category='+category;
  	}
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
                    <button id = "button1" value = "1" class="on" onclick= "cateval(this.value)">입출금내역</button>
                    <button id = "button2" value = "2" onclick= "cateval(this.value)">포인트내역</button>
                    <button id = "button3" value = "3" onclick= "cateval(this.value)">투자내역</button>
                    <input type="hidden" id="cate_color" name="cate_color" value="${category}">
                    
                </div>
			</div>
			<c:if test = "${category == '1'}">
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
									<td>${transaction.td_to_address}</td>
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
					<div class="b4 c on">
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
								<a href="./Mypage3.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./Mypage3.mb?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./Mypage3.mb?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<a href="./Mypage3.mb?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a>
								</c:if>
						</c:if>
					</ul><!--.pager-->
					</div>
				</c:if>
				<c:if test = "${category =='2'}">
						<table>
						<tr>
      						<td>구분</td>
      						<td>코인수량</td>
      						<td>포인트수량</td>
      						<td>날짜</td>
					     </tr>
							<c:forEach var = "transactionP" items="${transactionP}">
								<tr>
								<c:choose>
									<c:when test="${transactionP.po_category == '2'}" >
										<td class="plus">충전</td>
										<td>-<fmt:formatNumber value="${transactionP.po_amount}" pattern="#,###" /></td>
										<td>-<fmt:formatNumber value="${transactionP.tk_amount}" pattern="#,###" /></td>
										<td>${transactionP.po_date_time}</td>
									</c:when>
									<c:when test="${transactionP.po_category == '3'}" >
										<td class="plus">환전</td>
										<td>+<fmt:formatNumber value="${transactionP.po_amount}" pattern="#,###" /></td>
										<td>+<fmt:formatNumber value="${transactionP.tk_amount}" pattern="#,###" /></td>
										<td>${transactionP.po_date_time}</td>
									</c:when>
								</c:choose>
							  </tr>
							</c:forEach>
						</table>
						<div class="b4 c on">
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
								<a href="./Mypage3.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./Mypage3.mb?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./Mypage3.mb?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<a href="./Mypage3.mb?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a>
								</c:if>
						</c:if>
						</ul><!--.pager-->
						</div>
				</c:if>
				<c:if test = "${category == '3'}">
						<table>
              			<tr>
      						<td>구분</td>
      						<td>내용</td>
      						<td>수량</td>
      						<td>날짜</td>
      						<td>비고</td>
					     </tr>
					<c:forEach var = "member_invest_list" items="${member_invest_list}">
             		 <tr>
       		       	<c:set var="category" value="${member_invest_list.mi_category}" />
					<c:choose>
						<c:when test="${category == '투자'}">
  							<td class="minus">${member_invest_list.mi_category}</td>
  						</c:when>
  						<c:otherwise>
  							<td class="plus">${member_invest_list.mi_category}</td>
  						</c:otherwise>  							
  					</c:choose>
  					
  					<td>${member_invest_list.name }</td>
  					
  					<c:choose>
  						<c:when test="${category == '투자'}">
  							<td class="minus">-<fmt:formatNumber value="${member_invest_list.point }" pattern="#,###"/>P</td>
  						</c:when>
  						<c:otherwise>
				        	<td class="plus">+<fmt:formatNumber value="${member_invest_list.point }" pattern="#,###"/>P</td>
				        </c:otherwise>
  					</c:choose>
  						<td><fmt:formatDate value="${member_invest_list.mi_reg_date_time }" pattern="yyyy-MM-dd"/></td>
  						<td>${member_invest_list.mi_note }</td>
  					</tr>
  					</c:forEach>
  				</table>
  				<div class="b4 c on">
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
								<a href="./Mypage3.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a>
							</c:if>
								<ul class="pager">
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<c:choose>
										<c:when test="${currentPage == i}">
											<b><a class="on" href="./Mypage3.mb?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b>
										</c:when>
										<c:otherwise>
											<li><a href="./Mypage3.mb?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
								<c:if test="${numPageGroup < pageGroupCount}">
								<a href="./Mypage3.mb?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a>
								</c:if>
						</c:if>
						</ul><!--.pager-->
						</div>
				</c:if>
   		</div>
    </section>

    <footer></footer>
  </div>
 	  <script>
		  $(function(){
			  if($('#cate_color').val() == '1'){
				$('.button > button').removeClass('on');
				$('#button1').addClass('on');
			  }
			  else if($('#cate_color').val() == '2'){
		 		$('.button > button').removeClass('on');
		 		$('#button2').addClass('on');
		 	  }
			  else if($('#cate_color').val() == '3'){
			 	$('.button > button').removeClass('on');
			 	$('#button3').addClass('on');
			  }
			
		  });
	  </script>
</body>
</html>
