<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.board.dto.FaqVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="kr">

<%
	ArrayList<FaqVO> faq1 = (ArrayList<FaqVO>)request.getAttribute("faq1");
	ArrayList<FaqVO> faq2 = (ArrayList<FaqVO>)request.getAttribute("faq2");
	ArrayList<FaqVO> faq3 = (ArrayList<FaqVO>)request.getAttribute("faq3");
%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>FAQ</title>
	
  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/jquery.bxslider.css" rel="stylesheet">

  <link href="css/service.css" rel="stylesheet">
  <link href="css/list_box.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>
 <script type="text/javascript" src="jquery-2.2.2.min.js"></script>

  <script type="text/javascript"></script>
  <script>
  
  $(document).ready(function(){
	$("#button").trigger("click");
  });



출처: https://namik.tistory.com/101 [남익의 생활]
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
	  
	  
	  $(function(){
		  var onOff = false;
        $('.depth1').on('click',function(){
            onOff = !onOff;
            if(onOff==true){
                $(this).siblings('.depth2').css({
                    'display':'block'
                });
            }else{
                $(this).siblings('.depth2').css({
                    'display':'none'
                });
            }
        });
	  });
	  
	  $(function(){
		  var f = document.faqForm;
		  $('.faq > button').on('click',function(){
			  $('.faq > button').removeClass('on');
			  $(this).addClass('on');
		  });
		  $('.faq > button').eq(0).on('click',function(){
			  $('.table > div').css({
				  'display':'block'
			  });
		  });
		  $('.faq > button').eq(1).on('click',function(){
			  $('.table > div').css({
				  'display':'none'
			  });
			  $('.btn1').css({
				  'display':'block'
			  });
		  });
		  $('.faq > button').eq(2).on('click',function(){
			  $('.table > div').css({
				  'display':'none'
			  });
			  $('.btn2').css({
				  'display':'block'
			  });
		  });
		  $('.faq > button').eq(3).on('click',function(){
			  $('.table > div').css({
				  'display':'none'
			  });
			  $('.btn3').css({
				  'display':'block'
			  });
		  });
	  });
	  
	  function List(button){
		  var category = button;
		  console.log(button);
		  
		  $.ajax({
				url : './Faq.bd', 
				type : 'POST',
				data : "category="+category,  	
				dataType : 'json',
				success:function(data){
					
				}, error:function(data){
				
				}
			});
	  }
	  
  </script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div> 
    <div class="toppdng"></div>
    
    <section id="section04">
		<div class="tit">
			<h3>고객지원서비스</h3>
			<h5>FUNBOX 고객지원 서비스입니다</h5>
		</div><!--sub_title-->
		
		<div class="faq">
			<h4>FAQ</h4>
			<h5>궁금한 점이 있다면 여기서 먼저 찾아보세요</h5>
			<button id="button" value = "ALL" onclick = "List(this.value)" class="on">전체FAQ</button>
			<button id="button" value = "1" onclick = "List(this.value)">입출금관련FAQ</button>
			<button id="button" value = "2" onclick = "List(this.value)">투자관련FAQ</button>
			<button id="button" value = "3" onclick = "List(this.value)">기타FAQ</button>
			<div class="sch">
				<label>키워드로 검색해보세요</label>
				<input type="text" id="search_faq">
				<input type="button">
			</div><!--.sch-->
			<div class="table">
				<c:forEach var="faq1" items="${faq1 }">
				<div class="btn1">
					<p class="depth1">
						<span>${faq1.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq1.content }
						</span>
					</p>
				</div>
				</c:forEach>
				<c:forEach var="faq2" items="${faq2 }">
				<div class="btn2">
					<p class="depth1">
						<span>${faq2.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq2.content }
						</span>
					</p>
				</div>
				</c:forEach>
				<c:forEach var="faq3" items="${faq3 }">
				<div class="btn3">
					<p class="depth1">
						<span>${faq3.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq3.content }
						</span>
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
						<a href="./Faq.bd?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">◀</a>
					</c:if>
						<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<b><a class="on" href="./Faq.bd?pageNum=${i}"><font size=3>${i}</font></a></b>
								</c:when>
								<c:otherwise>
									<a href="./Faq.bd?pageNum=${i}">
									<font size=3>${i}</font></a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
						<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./Faq.bd?pageNum=${numPageGroup*pageGroupSize+1}" class="next">▶</a>
						</c:if>
				</c:if>
			</ul><!--.pager-->
		</div><!--.qna_list-->
	</section>

    <footer></footer>
  </div>

</body></html>
