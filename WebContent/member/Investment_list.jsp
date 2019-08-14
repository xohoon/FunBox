<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="net.member.dto.MemberInvestPageVO"%>
<%@page import="net.member.dto.MemberInvestVO"%>
<%@page import="net.company.dto.Company_pay_scheduleVO"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("utf-8"); // 한글처리
	MemberInvestPageVO memberInvestVO = (MemberInvestPageVO)request.getAttribute("memberInvestVO");
	ArrayList<MemberInvestVO> member_invest_list = (ArrayList<MemberInvestVO>)request.getAttribute("member_invest_list");
	ArrayList<Company_pay_scheduleVO> companypayscheduleVO = (ArrayList<Company_pay_scheduleVO>)request.getAttribute("CompanyPayScheduleVO");
%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta name="format-detection" content="telephone=no" />
  
  <title>투자현황</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <script src="js/jquery-3.1.1.min.js"></script>
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/mypage.css" rel="stylesheet">  
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
  <script src="js/jquery.mousewheel.js"></script>
  <script src="member/js/investment_status.js"></script>
</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    
    <section>
    	<div class="like_box"></div>
    	<ul class="tab">
    		<li id="invest_check" class="on">투자현황</li>
    		<li onclick="location.href='./Mypage2_1.mb'">자산관리</li>
    		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li onclick="location.href='./Mypage4_1.mb'">내정보</li>
    	</ul>
    </section>
		<div class="con">
  <ul>
    <li>
      <img src="img/ico_fin1.jpg" alt="투자현황"><p>
        기업명</p>
        <span><%=memberInvestVO.getCp_name() %><span><%=memberInvestVO.getCp_add_ch() %></span></span>
    </li>
    <li>
      <img src="img/ico_fin2.jpg" alt="투자현황"><p>
      보유구좌</p>
      <span><%=memberInvestVO.getMi_hoiling_stock() %>계좌</span>
    </li>
    <li>
      <img src="img/ico_fin3.jpg" alt="투자현황"><p>
      구좌가치</p>
      <fmt:formatNumber var= "possible_amount" value="<%=memberInvestVO.getMi_stock_value() %>" pattern="#,###" />
      <span>${possible_amount}P</span>
    </li>
    <li>
      <img src="img/ico_fin4.jpg" alt="투자현황"><p>
      당월수익</p>
      <fmt:formatNumber var= "monthly_profit" value="<%=memberInvestVO.getMi_monthly_profit() %>" pattern="#,###" />
      <span>${monthly_profit}P</span>
    </li>
    <li>
      <img src="img/ico_fin5.png" alt="투자현황"><p>
      누적수익</p>
      <fmt:formatNumber var= "cumulative_profit" value="<%=memberInvestVO.getMi_cumulative_profit() %>" pattern="#,###" />
      <span>${cumulative_profit}P</span>
    </li>
  </ul>
  <button class="list_show">투자리스트보기</button>
  <div class="cor_info">
    <h5>기업정보</h5>
    <div>
      <h6>기본정보</h6>
      <table>
        <tr>
          <td>대표자</td>
          <td><%=memberInvestVO.getCp_manager() %></td>
        </tr>
        <tr>
          <td>사업자 등록번호</td>
          <td><%=memberInvestVO.getCp_number() %></td>
        </tr>
        <tr>
          <td>자본금</td>
          <td><fmt:formatNumber value ="<%=memberInvestVO.getCp_capital() %>" pattern="#,###" /></td>
        </tr>
        <tr>
          <td>본사주소</td>
          <td><%=memberInvestVO.getCp_add_ch() %></td>
        </tr>
      </table>
    </div>
    <div>
      <h6>참고자료</h6>
      <a href="./CompanyFileDownload?filename=${memberInvestVO.cf_certificate }&cp_idx=${memberInvestVO.cp_idx}" download>해당 업종 자격증 사본.jpg <i class="fas fa-download"></i></a>
      <a href="./CompanyFileDownload?filename=${memberInvestVO.cf_estate_contract }&cp_idx=${memberInvestVO.cp_idx}" download>부동산 임대차 계약서 사본.jpg <i class="fas fa-download"></i></a>
      <a href="./CompanyFileDownload?filename=${memberInvestVO.cf_registration }&cp_idx=${memberInvestVO.cp_idx}" download>사업자 등록증 사본.jpg <i class="fas fa-download"></i></a>
      <select id="cf_financial_selector">
       	<c:forEach var="cf_financial" items="${memberInvestVO.cf_financial_arr}" >
       		   <option value="${cf_financial}">${cf_financial}</option>
    	</c:forEach>      
      </select>
      <a id="cf_financial_download" href="./CompanyFileDownload?filename=${memberInvestVO.cf_financial_arr[0] }&cp_idx=${memberInvestVO.cp_idx}" download>재무제표 <i class="fas fa-download"></i></a>
    </div>
    <div class="rep">
      <h6>예상 지급 스케쥴</h6>
      <div>
        <table>
          <tr>
            <th>지급회차</th>
            <th>예상 지급일</th>
            <th>원금</th>
            <th>지급이자</th>
            <th>플랫폼 이용료</th>
            <th>실 지급금액</th>
            <th>실 수익률</th>
          </tr>
            <c:forEach var = "i" begin = "1" end = "12"> 
             <tr>
               <td>${i}</td>
               <td><%= companypayscheduleVO.get(0).getCp_pay_expected_payment_date() %></td>
               <td><fmt:formatNumber value="<%= companypayscheduleVO.get(0).getCp_pay_principal() %>" pattern="#,###" /></td>
               <td><fmt:formatNumber value="<%= companypayscheduleVO.get(0).getCp_pay_interest_paid() %>" pattern="#,###" /></td>
               <td><fmt:formatNumber value="<%= companypayscheduleVO.get(0).getCp_pay_fees() %>" pattern="#,###" /></td>
               <td><fmt:formatNumber value="<%= companypayscheduleVO.get(0).getCp_pay_actual_payment_amout() %>" pattern="#,###" /></td>
               <td><fmt:formatNumber value="<%= companypayscheduleVO.get(0).getCp_pay_actual_rate_return() %>" pattern="#,###" /></td>            
             </tr>             
          	</c:forEach>
              <tr>
                <td>총 합계</td>
                <td>-</td>                 
                <td>100,000,000</td>               
                <td>305,520원</td>
                <td>32,080원</td>
                <td>273,470원</td>
                <td>9.13%</td>
              </tr>
        </table>
      </div>
    </div>
  </div>
</div>
<div class="list">
  <p>
    내가 투자한 BOX<br>
    <span>${investListCount}건</span>
  </p>
  <ul>
      <c:forEach var="memberInvestCompanyVO" items="${memberInvestCompanyVOList}" >
      	<c:choose> 
      		<c:when test="${memberInvestCompanyVO.mi_idx eq selectedMi_idx }">
		      	<li class="on" id="cp_${memberInvestCompanyVO.mi_idx }">
	      			<c:if test="${memberInvestCompanyVO.cp_funding_status eq '12'}">
				      	<a href="./MemberInvestmentList.mb?cp_idx=${memberInvestCompanyVO.cp_idx }&mi_idx=${memberInvestCompanyVO.mi_idx}">${memberInvestCompanyVO.cp_name }</a>
    	  			</c:if>
    	  			<c:if test="${memberInvestCompanyVO.cp_funding_status eq '11'}">
    	  				<a href="./MemberInvestmentDrop.mb?cp_idx=${memberInvestCompanyVO.cp_idx }&mi_idx=${memberInvestCompanyVO.mi_idx}">${memberInvestCompanyVO.cp_name }</a>
    	  			</c:if>
		      	</li>
      		</c:when>
      		<c:otherwise>
      			<li id="cp_${memberInvestCompanyVO.mi_idx }">
	      			<c:if test="${memberInvestCompanyVO.cp_funding_status eq '12'}">
      					<a href="./MemberInvestmentList.mb?cp_idx=${memberInvestCompanyVO.cp_idx }&mi_idx=${memberInvestCompanyVO.mi_idx}">${memberInvestCompanyVO.cp_name }</a>
      				</c:if>
      				<c:if test="${memberInvestCompanyVO.cp_funding_status eq '11'}">
      					<a href="./MemberInvestmentDrop.mb?cp_idx=${memberInvestCompanyVO.cp_idx }&mi_idx=${memberInvestCompanyVO.mi_idx}">${memberInvestCompanyVO.cp_name }</a>
      				</c:if>
      			</li>
      		</c:otherwise>
      	</c:choose>
      </c:forEach>
  </ul>
</div>
<div class="b4 t">
  <h5>투자내역</h5>
  <table>
    <tr>
        <td>구분</td>
        <td>내용</td>
        <td>수량</td>
        <td>날짜</td>
        <td>비고</td>
    </tr>
    <c:forEach var="memberInvest" items="${member_invest_list}" >
    <tr>
       	<c:choose>
       		<c:when test="${memberInvest.mi_category eq '투자'}">
		        <td class="minus">${memberInvest.mi_category}</td>
	        </c:when>
	        <c:otherwise>
	        	<td class="plus">${memberInvest.mi_category}</td>
	        </c:otherwise>
       	</c:choose>
        <td>${memberInvest.name}</td>
        <c:choose>
	        <c:when test="${memberInvest.mi_category eq '투자'}">
		        <td class="minus">-<fmt:formatNumber value="${memberInvest.point}" pattern="#,###"/>P</td>
	        </c:when>
	        <c:otherwise>
	        	<td class="plus">+<fmt:formatNumber value="${memberInvest.point}" pattern="#,###"/>P</td>
	        </c:otherwise>
        </c:choose>
        <td><fmt:formatDate value="${memberInvest.mi_reg_date_time}" pattern="yyyy-MM-dd"/></td>
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
				<a href="./MemberInvestmentList.mb?pageNum=${(numPageGroup-2)*pageGroupSize+1 }&mi_idx=${selectedMi_idx}" class="prev">◀</a>
			</c:if>
				<ul class="pager">
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:choose>
						<c:when test="${currentPage == i}">
							<b><a class="on" href="./MemberInvestmentList.mb?pageNum=${i}&mi_idx=${selectedMi_idx}"><font size=3>${i}</font></a></b>
						</c:when>
						<c:otherwise>
							<li><a href="./MemberInvestmentList.mb?pageNum=${i}&mi_idx=${selectedMi_idx}"><font size=3>${i}</font></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
				<c:if test="${numPageGroup < pageGroupCount}">
				<a href="./MemberInvestmentList.mb.mb?pageNum=${numPageGroup*pageGroupSize+1}&mi_idx=${selectedMi_idx}" class="next">▶</a>
				</c:if>
		</c:if>
	</ul><!--.pager-->
	</div>
</div>
   <footer></footer>
</body>
</html>