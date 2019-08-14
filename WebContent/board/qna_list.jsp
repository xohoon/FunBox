<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.dao.BoardDAO" %>
<%@ page import="net.board.dto.QnaVO" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.Timestamp"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>1:1 문의 내역</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/service.css" rel="stylesheet">
  <link href="css/loader.css" rel="stylesheet" type="text/css">
  <script src="js/jquery-3.1.1.min.js"></script>
<script src="board/js/qna_list.js"></script>
</head>

<body>
  <div class="loader">
    <div class="loadercircle"></div>
    <div class="loadercircle"></div>
    <div class="loadercircle"></div>
    <div class="loadercircle"></div>
    <div class="loadercircle"></div>
  </div>

  <div id="wrap">
    <header></header>
    <div class="hdbck"></div> 
    <div class="toppdng"></div>
    
    <section id="section02">
		<div class="tit">
			<h3>고객지원서비스</h3>
			<h5>FUNBOX 고객지원 서비스입니다</h5>
		</div><!--sub_title-->
		<div class="qna_list cf">
			<h4>내 1:1 문의내역</h4>
			<h5>자세한 상담은 1:1문의를 이용해주세요.</h5>
			<button onclick="location.href='./Qna.bd'">문의하기</button>
			<div class="table">
				<div>
					<p class="depth1">
						<span>구분</span>
						<span>제목</span>
						<span>등록일</span>
						<span>답변</span>
					</p>
				</div>
				 <c:forEach var="qna_list" items="${qna_list}" >
				<div>
					<p class="depth1">
						<span>${qna_list.category}</span>
						<span>${qna_list.title}</span>
						<span>${qna_list.reg_date_time}</span>
						<c:if test="${qna_list.qna_reply ne null}">
							<span>OK</span>
						</c:if>
						<c:if test="${qna_list.qna_reply eq null}">
							<span></span>
						</c:if>
					</p>
					<% pageContext.setAttribute("newLineChar", "\r\n"); %>
					<p class="depth2">
						<span>${fn:replace(qna_list.content, newLineChar, '<br/>')}</span>
						<!-- <span>답변입니다</span> -->
						<c:if test="${qna_list.qna_reply ne null}">
							<span>${fn:replace(qna_list.qna_reply, newLineChar, '<br/>')}</span>
						</c:if>
						<c:if test="${qna_list.qna_reply eq null}">
							<span></span>
						</c:if>
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
						<a href="./BoardQnaList.bd?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a>
					</c:if>
						<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<li><b><a class="on" href="./BoardQnaList.bd?pageNum=${i}"><font size=3>${i}</font></a></b></li>
								</c:when>
								<c:otherwise>
									<li><a href="./BoardQnaList.bd?pageNum=${i}"><font size=3>${i} </font></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
						<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./BoardQnaList.bd?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
						</c:if>
				</c:if>
			</ul><!--.pager-->
		</div><!--.qna_list-->
	</section>

    <footer></footer>
  </div>
</body></html>
