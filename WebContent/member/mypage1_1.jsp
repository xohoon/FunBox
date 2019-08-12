<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="net.member.dto.MemberInvestPageVO"%>
<%@page import="net.member.dto.MemberInvestVO"%>
<%@page import="net.company.dto.Company_pay_scheduleVO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="kr">
<%
	request.setCharacterEncoding("utf-8"); // 한글처리
	MemberInvestPageVO memberInvestVO = (MemberInvestPageVO)request.getAttribute("memberInvestVO");
	ArrayList<MemberInvestVO> member_invest_list = (ArrayList<MemberInvestVO>)request.getAttribute("member_invest_list");
	ArrayList<Company_pay_scheduleVO> companypayscheduleVO = (ArrayList<Company_pay_scheduleVO>)request.getAttribute("CompanyPayScheduleVO");
	int mi_idx = Integer.parseInt(request.getParameter("mi_idx"));
%>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="format-detection" content="telephone=no" />

  <title></title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <script src="js/jquery.mousewheel.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/mypage1_1.css" rel="stylesheet">
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
    <section>
      <div class="like_box"></div>
      <ul class="tab">
        <li id="invest_check" class="on" onclick="location.href='./MemberInvestmentList.mb'">투자현황</li>
		<li onclick="location.href='./Mypage2_1.mb'">자산관리</li>
		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
      </ul>
      </section>
      <div class="con">
        <div class="cor_info">
          <div class="cor_ing">
            <p>아직 펀딩이 종료되지 않은 기업이에요 !</p>
            <p>펀딩 모집 완료 후에는 투자철회가 불가능합니다.</p>
            <ul>
              <li onclick="window.open('./MemberIvDropInfo.mb?mb_idx=${sessionScope.idx }&cp_idx=${cp_idx }&mi_idx=<%=mi_idx %>','기업이름','width=640,height=400,top=0,left=0,scrollbars=yes');">펀딩 철회하기</li>
              <li onclick="location.href='./CorporationAction.cp?cp_idx=${boxs.getCp_idx() }'">기업정보 보러가기</li>
            </ul>
          </div>
        </div><!--.cor_info-->
<div class="list">
  <p>
    내가 투자한 BOX<br>
    <span>${count}건</span>
  </p>
  <ul>
      <c:forEach var="memberInvestCompanyVO" items="${memberInvestCompanyVOList}" >
      	<c:choose> 
      		<c:when test="${memberInvestCompanyVO.cp_idx eq selectedCp_idx }">
		      	<li class="on" id="cp_${memberInvestCompanyVO.cp_idx }">
	      			<c:if test="${memberInvestCompanyVO.cp_funding_status eq '12'}">
				      	<a href="./MemberInvestmentList.mb?cp_idx=${memberInvestCompanyVO.cp_idx }">${memberInvestCompanyVO.cp_name }</a>
    	  			</c:if>
    	  			<c:if test="${memberInvestCompanyVO.cp_funding_status eq '11'}">
    	  				<a href="./MemberInvestmentDrop.mb?cp_idx=${memberInvestCompanyVO.cp_idx }">${memberInvestCompanyVO.cp_name }</a>
    	  			</c:if>
		      	</li>
      		</c:when>
      		<c:otherwise>
      			<li id="cp_${memberInvestCompanyVO.cp_idx }">
	      			<c:if test="${memberInvestCompanyVO.cp_funding_status eq '12'}">
      					<a href="./MemberInvestmentList.mb?cp_idx=${memberInvestCompanyVO.cp_idx }">${memberInvestCompanyVO.cp_name }</a>
      				</c:if>
      				<c:if test="${memberInvestCompanyVO.cp_funding_status eq '11'}">
      					<a href="./MemberInvestmentDrop.mb?cp_idx=${memberInvestCompanyVO.cp_idx }">${memberInvestCompanyVO.cp_name }</a>
      				</c:if>
      			</li>
      		</c:otherwise>
      	</c:choose>
      </c:forEach>
  </ul>
</div>
      </div>
      <div class="b4 t">
        <h5>지급내역</h5>
        <table>
          <tr>
            <td>구분</td>
            <td>내용</td>
            <td>수량</td>
            <td>날짜</td>
            <td>회차</td>
          </tr>
    <%
    	if(member_invest_list != null){
    		for(int i=0; i<member_invest_list.size(); i++){
    %>
    <tr>
       	<c:set var="category" value="<%=member_invest_list.get(i).getMi_category() %>" />
       	<c:choose>
       		<c:when test="${category == '투자'}">
		        <td class="minus"><%=member_invest_list.get(i).getMi_category() %></td>
	        </c:when>
	        <c:otherwise>
	        	<td class="plus"><%=member_invest_list.get(i).getMi_category() %></td>
	        </c:otherwise>
       	</c:choose>
    	
        <td><%=member_invest_list.get(i).getName() %></td>
        
        <c:choose>
	        <c:when test="${category == '투자'}">
		        <td class="minus">-<fmt:formatNumber value="<%=member_invest_list.get(i).getPoint() %>" pattern="#,###"/>P</td>
	        </c:when>
	        <c:otherwise>
	        	<td class="plus">+<fmt:formatNumber value="<%=member_invest_list.get(i).getPoint() %>" pattern="#,###"/>P</td>
	        </c:otherwise>
        </c:choose>
        <td><fmt:formatDate value="<%=member_invest_list.get(i).getMi_reg_date_time() %>" pattern="yyyy-MM-dd"/></td>
    </tr>
    <%
    		}
    	}
    %>
        </table>
  <c:if test="${count > 0}">
		<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="startPage" value="${pageGroupSize*(numPageGroup-1)+1}" />
		<c:set var="endPage" value="${startPage + pageGroupSize-1}" />

		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>
		
		<c:if test="${numPageGroup > 1}">
			<a href="./MemberInvestmentList.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }" class="prev">
			<i class="fas fa-caret-left"></i></a>
		</c:if>
		
		<ul class="pager">
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:choose>
					<c:when test="${currentPage == i}">
						<li><a href="./MemberInvestmentList.mb?pageNum=${i}">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="./MemberInvestmentList.mb?pageNum=${i}">${i}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
									
		<c:if test="${numPageGroup < pageGroupCount}">
			<a href="./MemberInvestmentList.mb?pageNum=${numPageGroup*pageGroupSize+1}" class="next">
			<i class="fas fa-caret-right"></i></a>
		</c:if>
	</c:if>
      </div>
      </div>

      <script src="js/jquery-3.1.1.min.js"></script>
      <script type='text/javascript' src='js/jquery.mousewheel.js'></script>
      <script>
        $(function() {
          var h = $('.cor_info').height() + 32 ;
          var winW = $(window).width();
          var liOff = $('.cor_info').offset().top;
          var liOffs = liOff * 1 + 56
          if (winW > 1200) {
            $('.list').height(h);
          } else {
            $('.list').height(400);
            $('.list').offset({
              top: liOff
            })
          }
        });
        $('.list_show').on('click', function() {
          $('.list').toggleClass('on');
          if ($(this).text() == '투자리스트보기') {
            $(this).text('닫기');
          } else if ($(this).text() == '닫기') {
            $(this).text('투자리스트보기');
          }
        });
        $(function() {
          $(".rep").mousewheel(function(event, delta) {
            this.scrollLeft -= (delta * 100);
            event.preventDefault();
          });
        });
      </script>
</body>

</html>