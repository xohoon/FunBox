<%@page import="java.util.List"%>
<%@page import="net.member.dao.MemberDAO"%>
<%@page import="net.member.dto.Member_likeboxVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="css/like_box.css" rel="stylesheet">

<script src="js/jquery.mousewheel.js"></script>
<script src="member/js/like_box.js"></script>

<%
	String idx = (String) session.getAttribute("idx");
	// 회원 idx
	MemberDAO memberDAO = new MemberDAO();
	List<Member_likeboxVO> boxs = memberDAO.LikeboxInfo(idx);
	request.setAttribute("boxs", boxs);
%>
<div class="fav">
	<h6>
		<i class="fas fa-star"></i> 내가 찜한 BOX
	</h6>
	<ul>
		<c:forEach var="boxs" items="${boxs }">
			<li
				onclick="location.href='./CorporationAction.cp?cp_idx=${boxs.getCp_idx() }'">
				<input type="hidden" id="cp_idx" value="${boxs.getCp_idx() }">
				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
				<div class="img">
					<img src="${boxs.getCf_image() }">
				</div>
				<div class="txt_box">
					<span>${boxs.getCp_sector() }</span>
					<h6>${boxs.getLike_cp_name() }<span>${boxs.getCp_branch() }</span>
					</h6>
					<div class="gage">
						<div class="per">
							<fmt:parseNumber var="test" value="${boxs.getCp_like_percent()}"
								integerOnly="true" />
							<span>${test}</span>%
						</div>
						<p>수익률 ${boxs.getCp_monthly_profit()}%</p>
						<div class="gage_full">
							<div class="gage_fill"></div>
						</div>
					</div>
					<span class="d_day">D-<span id="DDay_${boxs.cp_idx }">27</span></span>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
<!--.fav-->
<script>
	const second = 1000;
	minute = second * 60;
	hour = minute * 60;
	day = hour * 24;
	
	function setLikBoxeDday(cp_idx, stopDate) {
		var DDay = document.getElementById('DDay_' + cp_idx);
		let countDown = new Date(stopDate).getTime();
		let now = new Date().getTime();
		distance = countDown - now;

		var DdayCount = Math.floor(distance / (day));

		if (DdayCount <= 0) {
			DDay.parentElement.innerText = "편딩 기간 종료"
		} else {
			DDay.innerText = DdayCount;
		}
	};
	
	$(document).ready(function(){
		<c:forEach var="boxs" items="${boxs }">
		  setLikBoxeDday('${boxs.cp_idx}','${boxs.iv_appl_stop_date_time}');
	    </c:forEach>
	  });
</script>