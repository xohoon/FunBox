<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.board.dto.NoticeVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kr">
<%
	ArrayList<NoticeVO> notice = (ArrayList<NoticeVO>)request.getAttribute("notice");
%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>공지사항</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/service.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
 

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div> 
    <div class="toppdng"></div>
    
    <section id="section03">
		<div class="tit">
			<h3>고객지원서비스</h3>
			<h5>FUNBOX 고객지원 서비스입니다</h5>
		</div><!--sub_title-->
		<div class="notice">
			<h4>공지사항</h4>
			<h5>펀박스 이용관련 공지사항입니다.</h5>
			<div class="table">
				<div>
					<p class="depth1">
						<span>번호</span>
						<span>제목</span>
						<span>등록일</span>
					</p>
				</div>
				<c:forEach var="notice" items="${notice }">
				<div>
					<p class="depth1">
						<span>${notice.idx }</span>
						<span>${notice.title }</span>
						<span>${notice.reg_date_time }</span>
					</p>
					<p class="depth2">
					<%
						request.setAttribute("newLine", "\n");
						request.setAttribute("br", "<br/>");
					%>
						<span>${fn:replace(notice.content, newLine, br) }</span>
					</p>
				</div>
				</c:forEach>
			</div><!--.table-->
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
						<a href="./Notice.bd?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a>
					</c:if>
						<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<b><a class="on" href="./Notice.bd?pageNum=${i}"><font size=3>${i}</font></a></b>
								</c:when>
								<c:otherwise>
									<li><a href="./Notice.bd?pageNum=${i}"><font size=3>${i}</font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
						<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./Notice.bd?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
						</c:if>
				</c:if>
			</ul><!--.pager-->
	</section>

    <footer></footer>
  </div>
 <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
	   $(function(){
		  $('.depth1').on('click',function(){
            $(this).siblings('.depth2').slideToggle(200);
        });
	  });
  </script>
</body></html>
