<%@page import="java.util.List"%>
<%@page import="net.member.dao.MemberDAO"%>
<%@page import="net.member.dto.Member_likeboxVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="css/like_box.css" rel="stylesheet">

<%
	String idx = (String)session.getAttribute("idx");
	// 회원 idx
	MemberDAO memberDAO = new MemberDAO();
	List<Member_likeboxVO> boxs = memberDAO.LikeboxInfo(idx);
	request.setAttribute("boxs", boxs);
%>
<!--<div class="info">
    		<div>
    			<div>
    				<img src="img/ico_fbx.jpg" alt="자산"> 보유 자산
    				<h5>3,000,000<span>Coin</span></h5>
    				<p>현재 전환 가능 포인트<span>600,000P</span></p>
    			</div>
    		</div>
    		<div>
    			<div>
    				<img src="img/ico_point.jpg" alt="포인트"> 보유 포인트
    				<h5>1,5000,000<span>P</span></h5>
    			</div>
    		</div>
    		<div>
    			<div>
    				오늘의 COIN 시세
    				<h5>0.3877</h5>
    			</div>
    		</div>
    	</div>.info-->
    	<div class="fav">
    		<h6><i class="fas fa-star"></i> 내가 찜한 BOX</h6>
    		<ul>
    			<c:forEach var="boxs" items="${boxs }">
	    			<li onclick="location.href='./CorporationAction.cp?cp_idx=${boxs.getCp_idx() }'">
	    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
	                        <div class="img">
						    <img src="img/row1_anotherminae.jpg" alt="미네스">
						    </div>
						    <div class="txt_box">
							<span>${boxs.getCp_sector() }</span>
							<h6>${boxs.getLike_cp_name() }<span>${boxs.getCp_branch() }</span></h6>
							<div class="gage">
								<div class="per">
									<fmt:parseNumber var="test" value="${boxs.getCp_like_percent()}" integerOnly = "true" />
                  					<span>${test}</span>%
								</div>
								<p>수익률 ${boxs.getCp_monthly_profit()}</p>
								<div class="gage_full">							
								  <div class="gage_fill">								  
								  </div>
								</div>
							 </div>
							 <span class="d_day">D-<span>27</span></span>
	                        </div>
	    			</li>
    			</c:forEach>
    		</ul>
    	</div><!--.fav-->
    	<script src="js/jquery.mousewheel.js"></script>
	<script>
      
        $('.fav a').on('click', function(){
            $(this).parent('li').remove();
        });
        
        $(".fav ul").mousewheel(function(event, delta) {
            this.scrollLeft -= (delta * 100);
            event.preventDefault();
        });
		$(function() {
			$('.gage').each(function() {
					var percent = $(this).find('.per > span').text();

					$(this).find('.gage_fill').animate({
						'width': percent + '%'
					}, 1500);
			});
		});
    </script>