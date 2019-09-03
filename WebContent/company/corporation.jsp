<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	//CompanyBean companyBean = (CompanyBean)request.getAttribute("companyBean");
	//ArrayList<CompanyListVO> leftCompanyList = (ArrayList<CompanyListVO>)request.getAttribute("leftCompanyList"); 
	int sumPayPrincipal;
  	String idx = (String)session.getAttribute("idx");
	int count = (Integer)request.getAttribute("count");
%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title></title>
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/corporation.css" rel="stylesheet">
  <!-- <link href="css/loader.css" rel="stylesheet" type="text/css"> -->
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="company/js/jquery.mousewheel.js"></script>
  <script type="text/javascript" src="company/js/corporation.js"></script>
</head>
<body>
  <div id="wrap">
    <header></header>
    <section class="cf">
    	<div class="list">
    		<h3>투자기업 목록</h3>
    		<ul>
    			<c:forEach var="company" items="${leftCompanyList}">
    			<c:choose>
    				<c:when test="${company.cp_idx eq companyBean.cp_idx }">
    					<c:choose>
    						<c:when test="${company.cp_recommand and company.cp_best}">
    							<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name}<div class="recommend ">추천</div><div class="best">BEST</div></li>
		    				</c:when>
		    				<c:when test="${company.cp_idx eq companyBean.cp_idx and company.cp_recommand}">
								<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}<div class="recommend ">추천</div></li>
							</c:when>
							<c:when test="${company.cp_idx eq companyBean.cp_idx and company.cp_best}">
								<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}<div class="best ">BEST</div></li>
							</c:when>
							<c:otherwise>
								<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}</li>
							</c:otherwise>
    					</c:choose>
    				</c:when>
    				<c:otherwise>
    					<c:choose>
    						<c:when test="${ company.cp_recommand and company.cp_best}">
    							<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}<div class="recommend ">추천</div><div class="best">BEST</div></li>
    						</c:when>
    						<c:when test="${ company.cp_recommand}">
    							<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}<div class="recommend ">추천</div></li>
    						</c:when>
    						<c:when test="${ company.cp_best}">
    							<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}<div class="best ">BEST</div></li>
    						</c:when>
    						<c:otherwise>
								<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx}'">${company.cp_name}</li>
							</c:otherwise>
    					</c:choose>
    				</c:otherwise>
    			</c:choose>    				
			  </c:forEach> 
    		</ul>
    	</div>
    	<div class="info">
    		<h2><img src="img/con001.jpg" alt="바른생선회"></h2>
	        <h3>${companyBean.cp_sector}</h3>
            <h1>${companyBean.cp_name}<span>${companyBean.cp_branch}</span></h1>
            <c:if test="${ count != 0}">
            	<button class="like" value="1"><i></i> 즐겨찾기</button>
            </c:if>
            <c:if test="${ count == 0}">
            	<button class="like" value="0"><i></i> 즐겨찾기</button>
            </c:if>
            <ul class="data">
            	<li>
                  <i><img src="img/corpor_icon1.png"></i>
                  <p>월 수익률</p>
                  <p>${companyBean.cp_monthly_profit}%</p>
                </li>
                <li>
                  <i><img src="img/corpor_icon2.png"></i>
                  <p>투자계약기간</p>
                  <p><span>펀딩종료부터</span>${companyBean.iv_contraction_during}</p>
                </li>
                <li>
                  <i><img src="img/corpor_icon3.png"></i>
                  <p>최소투자금액</p>
                  <p><fmt:formatNumber value="${companyBean.iv_min_amount }" pattern="#,###" /> Point</p>
                </li>
                <li>
                  <i><img src="img/corpor_icon4.png"></i>
                  <p>잔여구좌</p>
                  <p><fmt:formatNumber value="${companyBean.iv_balance_stock}" pattern="#,###" /></p>
                </li>
                <li>
                  <i><img src="img/corpor_icon5.png"></i>
                  <p>현재모금액</p>
                  <p><fmt:formatNumber value="${companyBean.iv_current_amount}" pattern="#,###" /> Point</p>
                </li>
                <li>
                  <i><img src="img/corpor_icon6.png"></i>
                  <p>투자가능금액</p>
                  <p><fmt:formatNumber value="${companyBean.iv_possible_amount}" pattern="#,###" /> Point</p>
                </li>
                <li>
                  <i><img src="img/corpor_icon7.png"></i>
                  <p>현재참여인원</p>
                  <p><fmt:formatNumber value="${companyBean.iv_current_participants}" pattern="#,###" />명</p>
                </li>
                <li>
                  <i><img src="img/corpor_icon8.png"></i>
                  <p>펀딩종료까지</p>
                  <p>2일</p>
                </li>
            </ul>
            <div class="calc">
            	<h2>지금 이 상품에</h2>
	          	<div class="calc_top">
	          		<select>
		              <option></option>
		              <option></option>
		              <option></option>
		              <option></option>
		              <option></option>
            		</select>	
            		<p>을 투자하시면</p>
	          	</div>
	          	<div class="calc_bottom">
	          		<div class="cf">
	          			<p>예상 세후 총 수익금</p>
	          			<div class="circle">!
               				<div>상기 표시된 연 수익률에서 플랫폼 수수료를 제외한 총액이며, 실제 상환 일정에 따라 변동될 수 있습니다.</div>
             			</div>
             			<input type="text" value="273,440 원" readonly class="rew1">
	          		</div>
	          		<div class="cf">
		              <p>12개월동안 월 평균</p>
		              <div class="circle">!
		                <div>펀딩 실행일로부터 30일간 발생할 예상 세후 수익금의 총액을 표기한 값이며, 실제 지급금은 상환 회차와 일정에 따라 변동될 수 있습니다.</div>
		              </div>
		              <input type="text" value="22,474 원" readonly class="rew2">
		            </div>
		            <div class="cf">
		              <p>1금융권 정기예금의 평균</p>
		              <div class="circle">!
		                <div>1금융권 정기 예금 평균 금리 1.3%를 기준으로 세후 수익률을 계산한 값입니다.</div>
		              </div>
		              <input type="text" value="7 배" readonly class="rew3">
		            </div>
		            <a href="#rwd">예상 지급스케쥴 자세히 보러가기</a>
	          	</div>
	          	<div class="invest" onclick="investClick();">투자하기</div>
            </div>
            <div class="gauge_bar">
            	<p>${test}%</p>
            	<div class="gauge">
            		<div></div>
            	</div>
            	<div class="cf">
            		<p><fmt:formatNumber value="${companyBean.iv_current_amount }" pattern="#,###" /> FUN</p>
                	<p><fmt:formatNumber value="${companyBean.iv_goal_amount }" pattern="#,###" /> FUN</p>
            	</div>
            </div>
            <div class="photo cf">
            	<div>
            		<button class="prev icon" onclick="plusSlides(-1)"></button>
              		<button href="#" class="next icon" onclick="plusSlides(+1)"></button>
            		<p id="caption"></p>
            	</div>
            	<ul></ul>
            </div>
            <div id="lightBox">
            	<button class="close"><i></i></button>
		          <div>
		          	<button class="prev icon" onclick="plusSlides(-1)"></button>
               		<button href="#" class="next icon" onclick="plusSlides(+1)"></button>
		            <p id="caption2"></p>
		          </div>
		          <ul></ul>
			</div>    	
    	<article class="row1">
    		<h3>기본 정보</h3>
	          <ul>
	            <li>대표자</li>
	            <li>${companyBean.cp_manager}</li>
	            <li>사업자등록번호</li>
	            <li>${companyBean.cp_number}</li>
	            <li>자본금</li>
	            <li><fmt:formatNumber value="${companyBean.cp_capital}" pattern="#,###" /> 원</li>
	            <li>본사주소</li>
	            <li>${companyBean.cp_add_ch} ${companyBean.cp_add_more}</li>
	          </ul>
	          <div class="corpor-location">
	            <div id="daumRoughmapContainer1567051096650" class="root_daum_roughmap root_daum_roughmap_landing"></div>
	          </div>
    	</article>
    	<article class="row2">
    		<div>
	            <i></i>
	            <p>펀딩에 참여하시는 모든분들께 1만원 상당의 식사권을 드립니다 !</p>
	            <p>배송일 : 2019년 12월 1일</p>
	            <p>회원 가입 시 정확한 주소를 등록해주세요.<br>잘못 등록된 주소로 인한 오배송 문제는 당사에서 책임지지 않습니다.</p>
	            <i></i>
	            <h3>회사 소개</h3>
	            <div>
	              <p>싱싱한 회 한 접시에 소주 한 잔?</p>
	            </div>
	            <div class="txt_wrap">
	              <textarea readonly>'바른생선횟집'은 생선회가 비싸다는 편견을 파괴하여
	다양한 해산물 및 밑찬제공으로 퀄리티 있는 서비스를 제공합니다.
	수족관을 관림함으로써 드는 비용절감, 생선의 관리 미필요로 인한 인건비 절감,
	수족관에서 생선재고 관리가 없어짐으로서생선관리 비용 절감이 가능합니다.
	저렴한 가격으로 깨끗한 식사 환경으로 만족도 상승하여 누구나 즐길 수 있습니다!
	매장네 포장판매 및 배달로 집에서도 싱싱한 회를 즐겨보세요.</textarea>
				</div>
			</div>
    	</article>
    	<article class="row3">
          <h3>투자 노트</h3>
          <h4>1. 수요가 많은 원룸 밀집 지역!</h4>
          <p>- 조금 더 자세한 설명 :: 어디어디에 위치해서 언제 어느소비자층에 수요가 많고 어쩌고 저쩌고</p>
          <h4>2. 직배송으로 남다른 신선도를 자랑하는 착한 횟집!</h4>
          <p>- 어디서 직배송으로 당일 아침마다 어쩌고저쩌고 ㄹ라라라ㅏㅏㅏㅏ</p>
          <h4>3. 연 ㅇ%의 수익, 안전한 투자처</h4>
          <p>- ㅇ년간 안정적인 매출로 원금손실의 위험부담이 적습니다</p>
          <p>- 6개월 분할 상환으로 빠른 원금회수가 가능합니다.</p>
          <div class="operPlan cf">
            <div id="planView"></div>
            <ul></ul>
          </div>
        </article>
        <article class="row4">
          <h3>기업 예상 순수익</h3>
          <h4>손익상세 <span>(2019년 4월 기준)</span><span>(단위 : 원 / 년)</span></h4>
          <table>
            <tr>
              <th colspan="2">매출</th>
              <td>340,000,000</td>
            </tr>
            <tr>
              <th rowspan="4">비용</th>
              <td>원재료(생선매입비용)</td>
              <td>136,000,000</td>
            </tr>
            <tr>
              <td>인건비</td>
              <td>94,800,000</td>
            </tr>
            <tr>
              <td>임대비</td>
              <td>36,000,000</td>
            </tr>
            <tr>
              <td>운영비</td>
              <td>12,000,000</td>
            </tr>
            <tr>
              <th colspan="2">순수익</th>
              <td>61,104,000</td>
            </tr>
          </table>
          <h4>월 평균 수익금 <span>(1구좌 당)</span><span>(단위 : 원 / 년)</span></h4>
          <table class="avrg">
          	<tr>
          		<th colspan="2">매출</th>
          		<td><fmt:formatNumber value="${companyBean.cp_pre_sales }" pattern="#,###" /> 원</td>
          	</tr>
            <tr>
              <th rowspan="4">비용</th>
              <td>원재료(생선매입비용)</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_stuff }" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <td>인건비</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_costs_person }" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <td>임대비</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_lease_expenses}" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <td>운영비</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_operating_expenses}" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <th colspan="2">순수익</th>
              <td><fmt:formatNumber value="${companyBean.cp_pre_net_income }" pattern="#,###" /> 원</td>
            </tr>
          </table>
          <h4>월 평균 수익금 <span>(1구좌 당)</span><span>(단위 : 원 / 년)</span></h4>
          <table class="avrg">
            <tr>
              <th>현금 배당률</th>
              <td>순수익의 50%</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_cash_dividend_ratio }" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <th>지분</th>
              <td>1%</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_share }" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <th>플랫폼 이용료</th>
              <td>지분의 10.5%</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_platform }" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <th>예상 수익금</th>
              <td>지분 - 플랫폼 이용료</td>
              <td><fmt:formatNumber value="${companyBean.cp_pre_proceeds }" pattern="#,###" /> 원</td>
            </tr>
            <tr>
              <th colspan="2">월 평균</th>
              <td style="color: #ff9123"><fmt:formatNumber value="${companyBean.cp_pre_avg_monthly }" pattern="#,###" /> 원</td>
            </tr>
          </table>
          <h4>1금융권 정기 예금과 평균 비교</h4>
          <table class="thanbank">
            <tr>
              <th>실 수익률</th>
              <td>(지급이자 - 플랫폼 이용료) / 원금</td>
              <td>9.11%</td>
            </tr>
            <tr>
              <th colspan="2">1금융권 정기예금 평균 금리</th>
              <td>1.3%</td>
            </tr>
            <tr></tr>
          </table>
        </article>
      	<article class="row5" id="rwd">
        	<h3>예상 지급 스케쥴</h3>
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
                <!-- 관리자 페이지에서 값을 지정할때 지급회차 수를 입력할시 수정 필요 현재는 for문 사용 -->
                <c:forEach var = "i" begin = "1" end = "12"> 
	                <tr>
	                  <td>${i}</td>
	                  <td>${companyBean.cp_pay_expected_payment_date}</td>
	                  <td><fmt:formatNumber value="${companyBean.cp_pay_principal }" pattern="#,###" /></td>	                  
	                  <td><fmt:formatNumber value="${companyBean.cp_pay_interest_paid }" pattern="#,###" /></td>
	                  <td><fmt:formatNumber value="${companyBean.cp_pay_fees }" pattern="#,###" /></td>
	                  <td><fmt:formatNumber value="${companyBean.cp_pay_actual_payment_amout }" pattern="#,###" /></td>
	                  <td><fmt:formatNumber value="${companyBean.cp_pay_actual_rate_return }" pattern="#,###" /></td>
	                </tr>
              	</c:forEach>
                <tr>
                  <td>총 합계</td>
                  <td>-</td>
                  <td>${companyBean.cp_pay_principal}</td>
                  <td>305,520원</td>
                  <td>32,080원</td>
                  <td>273,470원</td>
                  <td>9.13%</td>
                </tr>
              </table>
        	</div>
        </article>
        <article class="row6">
          <h3>참고자료</h3>
        </article>
        <article class="row7">
        	<h3>투자시 유의사항</h3>
              <div>
                <h4>사업위험</h4>
                <p>
                <!-- 
                [자연재해] 태풍의 직접적인 영향권에 있는 서귀표 외해에 위치하여 외해수중 가두리 자체의 손상 및 참다랑어의 피해 가능성이 있습니다. 매출이 발생하지 않거나 천재지변으로 인한 양식장 손실시 연간 최대 손실은 약 4~5억이 예상됩니다. (2021년 당기 순이익 -5억 발생시 -12.5%손실)
                </p>
                <p>
                [원가상승] 현재까지 고등어 등의 생사료에 의존하고 있어 사료가격의 급등에 대한 위험성이 있습니다.
                 -->
                ${companyBean.cp_business_risk }
                </p>
              </div>
              <div>
                <h4>회사위험</h4>
                <p>
                <!-- 
                [매출 지연 리스크] 참다랑어의 경우 가두리 시설 등  초기 투자비용이 크고 최소 2년반 이상의 양식기간이 소요됩니다.
                </p>
                <p>
                [진입장벽/ 법적규제] 외해가두리 면허는 해양수산부의 인허가 사항이며 법적 절차를 준수하면 면허를  취득할 수 있으나, 육상 작업 중 어항내 작업 (시설공사, 사료 창고, 가공) 등에 있어서 지역 단체와의 긴밀한 협조 필요합니다.
                 -->
                 ${companyBean.cp_company_risk }
                </p>
              </div>
              <div>
                <h4>기타위험</h4>
                <p>
                <!-- 
                [발행일정 변경 위험] 청약기간이 연장되거나 투자판단과 밀접하게 연관된 주요내용이 변경될 경우 명시된 일정이 변경될 가능성이 존재합니다.
                </p>
                <p>
                [독자적 투자판단의 필요성] 본 설명서에 기재된 사항 이외의 투자위험요소를 검토하여 투자자 개인의 독자적인 판단이 필요합니다.
                 -->
                ${companyBean.cp_other_risks }
                </p>
              </div>
        </article>
        </div>
    </section>
    <footer></footer>
    	<input type="hidden" value="${companyBean.cp_add_ch }" name="cp_add_ch" id="cp_add_ch">
	  	<input type="hidden" value="${companyBean.cp_name }" name="cp_name" id="cp_name">
	  	<input type="hidden" value="${companyBean.cf_corporation_banner }" name="cf_corporation_banner" id="cf_corporation_banner">
	  	<input type="hidden" value="${companyBean.cf_corporation_icon }" name="cf_corporation_icon" id="cf_corporation_icon">
	  
		<form name="investForm" action="./Invest_beforeAction.cp" method="post">
		  	<input type="hidden" value="${idx }" name="idx" id="idx">
			<input type="hidden" value="${companyBean.cp_idx }" name="cp_idx" id="cp_idx">
		</form>
    </div>    
    <!-- <script  src="./js/jquery-3.1.1.min.js"></script> -->
 	<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3fd911319378df3f4ed86e94c8737483&libraries=services,clusterer,drawing"></script>
	<script type="text/javascript" src="company/js/map.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script> -->
  </body>
  <script type="text/javascript">
  	var company_image_path = '${companyBean.company_image_path}';
  </script>
  <script>
    $(function() {
      $('header').load('./header/header.jsp');
      $('footer').load('./footer/footer.jsp');
    });

    $(function() {
        var $win = $(window);
        
      //즐겨찾기
      $('.like').on('click', function() {
        $(this).toggleClass('on');
      });

      //리스트
      $(window).on('scroll resize', function() {
        var scTop = $win.scrollTop(),
          winWidth = $win.width(),
          winHeight = $win.height(),
          docHeight = $('HTML').height();
        if (winWidth > 1023) {
          if (scTop + winHeight == docHeight) {
            $('.list').addClass('done');
          } else if (scTop > 0) {
            $('.list').removeClass('done');
            $('.list').addClass('on');
          } else {
            $('.list').removeClass('on');
            $('.list').removeClass('done');
          }
        }else{
            $('.list').removeClass('on');
            $('.list').removeClass('done');
        }
      });

      //계산기셀렉트
      var $select = $('.calc_top').find('select')
      $select.on('click', function() {
        $('.calc_top').toggleClass('on');
      });
      $select.focusout(function() {
        $('.calc_top').removeClass('on');
      });

      var min = $('.min').text();
      min = min.replace(/[^0-9]/g, "");
      min = min.replace(/\,/g, "");

      var $option = $('.calc_top').find('option');
      $option.eq(0).text(min * 1 / 10000 + '만원');
      $option.eq(1).text(min * 3 / 10000 + '만원');
      $option.eq(2).text(min * 5 / 10000 + '만원');
      $option.eq(3).text(min * 10 / 10000 + '만원');
      $option.eq(4).text(min * 20 / 10000 + '만원');
      
      var m=1;
      
      var rew = $('.rewards').text(),
            rewM = $('.rewMonth').text(),
            $rew1 = $('.rew1'),
            $rew2 = $('.rew2'),
            $rew3 = $('.rew3');
      rew = rew.replace(/\,/g, "");
        rewM = rewM.replace(/\,/g, "");
        
      
      var rVal1 = rew*m,
            rVal2 = rewM*m,
            rVal3 = rew*m/(min)*100/1.3,
            rVal3 = rVal3.toFixed(2);
      rVal1 = numberWithCommas(rVal1);
        rVal2 = numberWithCommas(rVal2);
      $rew1.val(rVal1 + "원");
        $rew2.val(rVal2 + "원");
        $rew3.val(rVal3 + "배");
      
      
      $select.on('change', function(){
        var pick = $(this).children('option:selected').index(),
            pickVal = $(this).val();
        pickVal = pickVal.replace(/[^0-9]/g, "");
        switch(pick){            
          case 0: m=1;break;
          case 1: m=3;break;
          case 2: m=5;break;
          case 3: m=10;break;
          case 4: m=20;break;
        }
         var rVal1 = rew*m,
            rVal2 = rewM*m,
            rVal3 = rew*m/(min)*100/1.3,
            rVal3 = rVal3.toFixed(2);
      rVal1 = numberWithCommas(rVal1);
        rVal2 = numberWithCommas(rVal2);
      $rew1.val(rVal1 + "원");
        $rew2.val(rVal2 + "원");
        
        $rew1.val(rVal1 + "원");
        $rew2.val(rVal2 + "원");
      });


      //게이지
      var percent = $('.gauge').prev('p').text();
      $('.gauge').find('div').stop().animate({
        'width': percent
      }, 2000);

    });
    
    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
    
  </script>

  <script>
    //라이트박스
    $(function() {
    	var image_file_name_array = '${companyBean.cf_alias_store_images}'.split(',');
    	for (var i = 0; i < image_file_name_array.length; i++) {
    		image_file_name_array[0] = company_image_path + image_file_name_array[0];
		}
    	var i;
        var imgArr = image_file_name_array,
          imgLeng = imgArr.length,
          $ul = $('.photo').find('ul'),
          $div = $('.photo').find('div'),
          $box = $('#lightBox'),
          $ul2 = $box.find('ul'),
          $div2 = $box.find('div');
         

      for (i = 0; i < imgLeng; i++) {
        var addLi = document.createElement('li'),
            addImg = document.createElement('img');
        addLi.style.backgroundImage = "url(" + imgArr[i] + ")";
        addImg.className = 'corImg';
        addImg.setAttribute('src',imgArr[i]);
        $ul.append(addLi);
        $div.append(addImg);
      }

      for (i = 0; i < imgLeng; i++) {
        var addLi = document.createElement('li'),
            addImg = document.createElement('img');
        addLi.style.backgroundImage = "url(" + imgArr[i] + ")";
        addLi.setAttribute('onclick', "currentSlide(" + (i + 1) + ")");
        addImg.className = 'corImg2';
        addImg.setAttribute('src',imgArr[i]);
        $ul2.append(addLi);
          $div2.append(addImg);
      }
      document.getElementById('caption').innerHTML = slideIndex + '&nbsp;/&nbsp;' + imgLeng;
      document.getElementById('caption2').innerHTML = slideIndex + '&nbsp;/&nbsp;' + imgLeng;

      $ul2.find('li').eq(slideIndex - 1).addClass('on');

      $box.hide();
      $ul.find('li').eq(5).on('click', function() {
        $box.show();
      });
      $box.find('.close').on('click', function() {
        $box.hide();
      });

      $ul.find('li').on('click', function() {
        var a = $(this).index();
        switch(a){
          case 0 : currentSlide(1);break;
          case 1 : currentSlide(2);break;
          case 2 : currentSlide(3);break;
          case 3 : currentSlide(4);break;
          case 4 : currentSlide(5);break;
               }
      });
      var square = $(window).height();
          square = (square - 80)*0.2 - 16;
      $ul2.find('li').width(square*1);
      
      if($(window).width() < 768){
        var squ = $ul.find('li').width();
      $ul.find('li').height(squ);
      $ul.height(squ*2 + 16);
      var after = '<style> .photo li:nth-child(6):after{ line-height:' + squ+ 'px; }</style>'
      $('head').append(after);
      }
      
    });

    //라이트박스 스크롤
    $('#lightBox ul').mousewheel(function(event, delta) {
      this.scrollLeft -= (delta * 100);
      event.preventDefault();
    });
    //textarea
    $(document).ready(function() {
      $('.txt_wrap').on('keyup', 'textarea', function(e) {
        $(this).css('height', 'auto');
        $(this).height(this.scrollHeight);
      });
      $('.txt_wrap').find('textarea').keyup();
    });

    var slideIndex = 1;
    $(document).ready(function(){
    	showSlides();	
    });
    


    function plusSlides(n) {
      showSlides(slideIndex += n);
    }


    function currentSlide(n) {
      showSlides(slideIndex = n);
    }

    function showSlides(n) {
      var i;
      var slides = document.getElementsByClassName("corImg");
      var slides2 = document.getElementsByClassName("corImg2");
      if (n > slides.length) {
        slideIndex = 1
      }
      if (n < 1) {
        slideIndex = slides.length
      }
        for(n=0;n<slides.length;n++){
            slides[n].style.display = "none";
            slides2[n].style.display = "none";
        }
      slides[slideIndex - 1].style.display = "block";
      slides2[slideIndex - 1].style.display = "block";
      document.getElementById('caption').innerHTML = slideIndex + '&nbsp;/&nbsp;' + slides.length;
      document.getElementById('caption2').innerHTML = slideIndex + '&nbsp;/&nbsp;' + slides2.length;
      $('#lightBox').find('li').removeClass('on');
      $('#lightBox').find('li').eq(slideIndex - 1).addClass('on');
    }
    
  </script>
  <script>
    //사업계획서
    $(function() {
      var p,
        //pArr = ['img/store_info1.png', 'img/store_info1.png', 'img/store_info1.png', 'img/row1_anotherminae.jpg', 'img/row1_busancoffee.jpg', 'img/row1_soinsoo.jpg', 'img/row2_bokraeheon.jpg', 'img/row2_moon.jpg', 'img/row3_noodle.jpg', 'img/row2_myeonchaeum.jpg'],
        pArr ='${companyBean.cf_alias_business_plan_images}'.split(',');
        planL = pArr.length,
        $operPlan = $('.operPlan');
      for (p = 0; p < planL; p++) {
        var addP = document.createElement('li');
        addP.style.backgroundImage = "url(" + pArr[p] + ")";
        $operPlan.find('ul').append(addP);
      }
      document.getElementById('planView').style.backgroundImage = "url(" + pArr[0] + ")";

      $operPlan.find('li').on('click', function() {
        var liIn = $(this).index();

        document.getElementById('planView').style.backgroundImage = "url(" + pArr[liIn] + ")";
      });
    });
  </script>
  <script>
  	
    //참고자료
    $(function(){
      var real_file_name_array= '${companyBean.cf_store_images}'.split(',');
      var corFile,
          //corFileArr = ['data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EA%B3%84%ED%9A%8D%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%ED%8E%80%EB%94%A9%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%9E%84%EB%8C%80%EC%B0%A8%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EA%B0%80%EB%A7%B9%ED%97%88%EA%B0%80%EC%9E%90%EB%A3%8C.txt'],          
          corFileArr = '${companyBean.cf_alias_store_images}'.split(',');
          corL = corFileArr.length,
          $row6 = $('.row6');
      for(corFile=0;corFile<corL;corFile++){
        var addFile = document.createElement('a');
        addFile.setAttribute('href',corFileArr[corFile]);
        addFile.className = 'corFile';
        $row6.append(addFile);
        
      var fileUrl = corFileArr[corFile].split('/'),
          fileUrlLeng =fileUrl.length,
          fileNameFull = fileUrl[fileUrlLeng-1],
          fileNameDec = decodeURI(fileNameFull);
        addFile.setAttribute('download',real_file_name_array[corFile]);
        addFile.innerHTML = '<i></i>' + real_file_name_array[corFile] + '<i></i>';
        
      }
      
    });
  </script>
</html>
