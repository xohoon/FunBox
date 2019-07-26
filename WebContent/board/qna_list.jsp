<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.board.dao.BoardDAO" %>
<%@ page import="net.board.dto.QnaVO" %>
<%@ page import="net.board.dto.QnaReplyVO" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.Timestamp"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  <link href="css/service.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>

</head>

<body>

<%
	List<QnaVO> qna_list = (List<QnaVO>)request.getAttribute("qna_list");
	List<QnaReplyVO> qna_reply_list = null;
%>
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
				<%
					if(qna_list != null){
							for(int i=0; i<qna_list.size(); i++){
				%>
				<div>
					<p class="depth1">
						<span><%=qna_list.get(i).getCategory()%></span>
						<span><%=qna_list.get(i).getTitle()%></span>
						<span>
						<%
							String reg_date_time = "";
										
								 			try {
								 				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
								 				reg_date_time = formatter.format(qna_list.get(i).getReg_date_time());
								 			} catch (Exception ex) {
								 				reg_date_time = "";
								 			}
								
								 			out.print(reg_date_time);
						%>
							</span>
						<span>
						<%
							BoardDAO qna_dao = new BoardDAO();
										qna_reply_list = qna_dao.getQnaReply(qna_list.get(i).getIdx());
										
										for(int j=0; j<qna_reply_list.size(); j++) {
											if(qna_reply_list.get(j).getContent() != null){
						%>
						OK
						<%
							}else{
										
											}
										}
						%>
						</span>
					</p>
					<p class="depth2">
						<span><%=qna_list.get(i).getContent().replace("\r\n", "<br>")%></span>
						<!-- <span>답변입니다</span> -->
						<span>
						<%
							BoardDAO qna_dao2 = new BoardDAO();
										qna_reply_list = qna_dao2.getQnaReply(qna_list.get(i).getIdx());
										
										for(int k=0; k<qna_reply_list.size(); k++) {
						%>
						<%=qna_reply_list.get(k).getContent() %>
						<%
						}
						%>
						</span>
					</p> 
				</div>
				<%
						}
					}
				%>
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
									<b><a class="on" href="./BoardQnaList.bd?pageNum=${i}"><font size=3>${i}</font></a></b>
								</c:when>
								<c:otherwise>
									<a href="./BoardQnaList.bd?pageNum=${i}">
									<font size=3>${i}</font></a>
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
 <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
	  
	  $(function(){
		  $('.depth1').on('click',function(){
            $(this).siblings('.depth2').slideToggle(300);
        });
	  });
  </script>
</body></html>
