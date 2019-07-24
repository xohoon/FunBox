<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="css/like_box.css" rel="stylesheet">
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
    			<li>
    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
                        <div class="img">
					    <img src="img/row1_anotherminae.jpg" alt="미네스">
					    </div>
					    <div class="txt_box">
						<span>카페</span>
						<h6>어나더미네스<span>부산남산점</span></h6>
						<div class="gage">
							<div class="per"><span>87</span>%</div>
							<p>수익률 5%</p>
							<div class="gage_full">
							  <div class="gage_fill"></div>
							</div>
						 </div>
						 <span class="d_day">D-<span>27</span></span>
                        </div>
    			</li>
    			<li>
    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
                        <div class="img">
					    <img src="img/row1_anotherminae.jpg" alt="미네스">
					    </div>
					    <div class="txt_box">
						<span>카페</span>
						<h6>어나더미네스<span>부산남산점</span></h6>
						<div class="gage">
							<div class="per"><span>87</span>%</div>
							<p>수익률 5%</p>
							<div class="gage_full">
							  <div class="gage_fill"></div>
							</div>
						 </div>
						 <span class="d_day">D-<span>27</span></span>
                        </div>
    			</li>
    			<li>
    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
                        <div class="img">
					    <img src="img/row1_anotherminae.jpg" alt="미네스">
					    </div>
					    <div class="txt_box">
						<span>카페</span>
						<h6>어나더미네스<span>부산남산점</span></h6>
						<div class="gage">
							<div class="per"><span>87</span>%</div>
							<p>수익률 5%</p>
							<div class="gage_full">
							  <div class="gage_fill"></div>
							</div>
						 </div>
						 <span class="d_day">D-<span>27</span></span>
                        </div>
    			</li>
    			<li>
    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
                        <div class="img">
					    <img src="img/row1_anotherminae.jpg" alt="미네스">
					    </div>
					    <div class="txt_box">
						<span>카페</span>
						<h6>어나더미네스<span>부산남산점</span></h6>
						<div class="gage">
							<div class="per"><span>87</span>%</div>
							<p>수익률 5%</p>
							<div class="gage_full">
							  <div class="gage_fill"></div>
							</div>
						 </div>
						 <span class="d_day">D-<span>27</span></span>
                        </div>
    			</li>
    			<li>
    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
                        <div class="img">
					    <img src="img/row1_anotherminae.jpg" alt="미네스">
					    </div>
					    <div class="txt_box">
						<span>카페</span>
						<h6>어나더미네스<span>부산남산점</span></h6>
						<div class="gage">
							<div class="per"><span>87</span>%</div>
							<p>수익률 5%</p>
							<div class="gage_full">
							  <div class="gage_fill"></div>
							</div>
						 </div>
						 <span class="d_day">D-<span>27</span></span>
                        </div>
    			</li>
    			<li>
    				<a href="#" class="delete"><i class="fas fa-times-circle"></i></a>
                        <div class="img">
					    <img src="img/row1_anotherminae.jpg" alt="미네스">
					    </div>
					    <div class="txt_box">
						<span>카페</span>
						<h6>어나더미네스<span>부산남산점</span></h6>
						<div class="gage">
							<div class="per"><span>87</span>%</div>
							<p>수익률 5%</p>
							<div class="gage_full">
							  <div class="gage_fill"></div>
							</div>
						 </div>
						 <span class="d_day">D-<span>27</span></span>
                        </div>
    			</li>
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