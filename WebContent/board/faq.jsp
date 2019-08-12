<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.board.dto.FaqVO"%>
<%@page import="net.board.dao.BoardDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="kr">

<%
	ArrayList<FaqVO> faq = (ArrayList<FaqVO>)request.getAttribute("faq");
	ArrayList<FaqVO> faq_list = (ArrayList<FaqVO>)request.getAttribute("faq_list");
	int cate = (Integer)request.getAttribute("cate");
	int category = (Integer)request.getAttribute("caetgory");
%>
<head>
  <title>FAQ</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/loader.css" rel="stylesheet" type="text/css">
  <link href="css/jquery.bxslider.css" rel="stylesheet">
  <link href="css/service.css" rel="stylesheet">
  <link href="css/list_box.css" rel="stylesheet">
  <link rel="stylesheet" href="../node_modules/dist/fakeLoader.min.css">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>
  <script type="text/javascript" src="jquery-2.2.2.min.js"></script>
  <script type="text/javascript"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
  <script> 
  
  var Flag = 0;
  
  
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
		  if($('#cate_color').val() == '0'){
			$('.faq > button').removeClass('on');
			$('#button1').addClass('on');
		  }
		  else if($('#cate_color').val() == '1'){
	 		$('.faq > button').removeClass('on');
	 		$('#button2').addClass('on');
	 	  }
		  else if($('#cate_color').val() == '2'){
		 	$('.faq > button').removeClass('on');
		 	$('#button3').addClass('on');
		  }
		  else if($('#cate_color').val() == '3'){
		 	$('.faq > button').removeClass('on');
		 	$('#button4').addClass('on');
		  }
	  });

	  function searchCheck(frm){
		  console.log(frm.keyword.value);
		  
		  if(frm.keyword.value==''){
			alert('검색할 단어를 입력해주세요.');
			frm.keyword.focus();
			return false;
		  }
		  frm.submit();
		  console.log("search test");
	  }
	  
	  function cateval(button){
		  // 페이징 링크 링크 연결 수정
		  var category = button;
		  var pageNum = 1;
		  
		  if(pageNum != "1"){
			  var pageNum = document.getElementById("hiddenCategory").value;
		  }
		  
		  $("#category").val(category); // 찾기를 위한 카테고리 변수
		  location.href='./Faq.bd?category='+category+ '&pageNum='+pageNum;
	}
  </script>
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
    
    <section id="section04">
		<div class="tit">
			<h3>고객지원서비스</h3>
			<h5>FUNBOX 고객지원 서비스입니다</h5>
		</div><!--sub_title-->
		
		<div class="faq">
			<h4>FAQ</h4>
			<h5>궁금한 점이 있다면 여기서 먼저 찾아보세요</h5>
				<button id="button1" value = "0" onclick= "cateval(this.value)" class="on">전체FAQ</button>
				<button id="button2" value = "1" onclick= "cateval(this.value)" >입출금관련FAQ</button>
				<button id="button3" value = "2" onclick= "cateval(this.value)">투자관련FAQ</button>
				<button id="button4" value = "3" onclick= "cateval(this.value)">기타FAQ</button>			
			<div class="sch">
				<form name="search" method="post" action="./search_faq.bd">
					<label>키워드로 검색해보세요</label>
					<input type="text" id="search_faq" name="keyword" onKeypress="javascript:if(event.keyCode==13) {searchCheck(this.form)}">
					<input type="hidden" id="category" name="category" value="${categroyFlag}">
					<input type="hidden" id="cate_color" name="cate_color" value="${category}">
					<input type="button" onclick="searchCheck(this.form)">
				</form>
			</div><!--.sch-->
			<div class="table">
			<c:set var="cate" value="${category}"/>
			<c:if test="${cate == 0}">
			<c:forEach var="faq_list" items="${faq}">
				<div class="btn0">
					<p class="depth1">
						<span>${faq_list.title}</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content}
						</span>
					</p>
				</div>
			</c:forEach>
			</c:if>
				<c:set var="cate" value="${category}"/>
				<c:if test="${cate == 1}">
				<c:forEach var="faq_list" items="${faq}">
				<div class="btn1">
					<p class="depth1">
						<span>${faq_list.title}</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content}
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				<c:set var="cate" value="${category}"/>
				<c:if test="${cate == 2}"> 
				<c:forEach var="faq_list" items="${faq}">
				<div class="btn2">
					<p class="depth1">
						<span>${faq_list.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content }
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				<c:set var="cate" value="${category}"/>
				<c:if test="${cate == 3}">
				<c:forEach var="faq_list" items="${faq}">
				<div class="btn">
					<p class="depth1">
						<span>${faq_list.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content }
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				<form name="cateForm">
					<input type="hidden" name="cate" value="${cate }">
				</form>
								
				<!-- 검색한 값 보여주기 -->
				<c:set var="cate" value="${cate }"/>
				<c:if test="${cate == 0}">
				<c:forEach var="faq_list" items="${faq_list }">
				<div class="btn0">
					<p class="depth1">
						<span>${faq_list.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content }
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				<c:if test="${cate == 1}">
				<c:forEach var="faq_list" items="${faq_list}">
				<div class="btn1">
					<p class="depth1">
						<span>${faq_list.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content }
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				<c:if test="${cate == 2}">
				<c:forEach var="faq_list" items="${faq_list }">
				<div class="btn2">
					<p class="depth1">
						<span>${faq_list.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content }
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				<c:if test="${cate == 3}">
				<c:forEach var="faq_list" items="${faq_list }">
				<div class="btn3">
					<p class="depth1">
						<span>${faq_list.title }</span>
					</p>
					<p class="depth2">
						<span>
							${faq_list.content }
						</span>
					</p>
				</div>
				</c:forEach>
				</c:if>
				</div><!--.table-->
				
			<ul class="pager">
				<c:if test="${count > 0}">
					<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" /> 
					<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
					<c:set var="endPage" value="${startPage + pageGroupSize-1}" />
					<c:if test="${endPage > pageCount}">
						<c:set var="endPage" value="${pageCount}" />
					</c:if>
					<c:if test="${numPageGroup > 1}">
						<li><a href="./Faq.bd?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&category=${categroyFlag}" class="prev">◀</a></li>
					</c:if>
					
					<ul class="pager">
						<c:forEach var="i" begin="${startPage}" end="${endPage}">
							<c:choose>
								<c:when test="${currentPage == i}">
									<c:choose>
										<c:when test="${flag == 1}">
											<li><b><a class="on" href="./Faq.bd?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b></li>
											<input type="hidden" id= "hiddenCategory"  name="hiddenCategory" value="${i}">
										</c:when>
										<c:otherwise>
											<li><b><a class="on" href="./search_faq.bd?pageNum=${i}&category=${categroyFlag}&keyword=${keyword}"><font size=3>${i}</font></a></b></li>
											<input type="hidden" id= "hiddenCategory"  name="hiddenCategory" value="${i}">
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${flag == 1}">
											<li><b><a class="on" href="./Faq.bd?pageNum=${i}&category=${categroyFlag}"><font size=3>${i}</font></a></b></li>
											<input type="hidden" id= "hiddenCategory"  name="hiddenCategory" value="${i}">
										</c:when>
										<c:otherwise>
											<li><b><a class="on" href="./search_faq.bd?pageNum=${i}&category=${categroyFlag}&keyword=${keyword}"><font size=3>${i}</font></a></b></li>
											<input type="hidden" id= "hiddenCategory"  name="hiddenCategory" value="${i}">
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
					
					<c:if test="${numPageGroup < pageGroupCount}">
						<a href="./Faq.bd?pageNum=${numPageGroup*pageGroupSize+1}&category=${categroyFlag}" class="next">▶</a>
					</c:if>
				</c:if>
			</ul><!--.pager-->
		</div><!--.qna_list-->
	</section>

    <footer></footer>
  </div>
<script type="text/javascript">
	$( document ).ready(function() {
		  // 제이쿼리 페이지 로딩 추가
		 // alert("로딩 완료");
		$('header').load('./header/header.jsp')
    	$('footer').load('./footer/footer.jsp')
	});
  
    $(function() {
      setTimeout(function() {
        $('.loader').fadeOut(1000);
      }, 1000)
    });
</script>
</body></html>
