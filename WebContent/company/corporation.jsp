<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.company.dto.CompanyListVO"%>
<%@page import="net.company.dto.CompanyBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	CompanyBean companyBean = (CompanyBean)request.getAttribute("companyBean");
	ArrayList<CompanyListVO> leftCompanyList = (ArrayList<CompanyListVO>)request.getAttribute("leftCompanyList");
%>
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
  <link href="css/corporation.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    <!--여기에 내용 입력-->
    <div class="bodyWrap">
      <div class="inner">
        <div class="content">
          <div class="list" id="list-p">
            <h3>투자기업 목록</h3>
            <ul>
              <c:forEach var="company" items="${leftCompanyList}">
    			<c:choose>
    				<c:when test="${company.cp_idx eq companyBean.cp_idx }">
    					<c:choose>
    						<c:when test="${company.cp_recommand and company.cp_best}">
    							<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }<div class="recommend ">추천</div><div class="best">BEST</div></li>
		    				</c:when>
		    				<c:when test="${company.cp_idx eq companyBean.cp_idx and company.cp_recommand}">
								<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }<div class="recommend ">추천</div></li>
							</c:when>
							<c:when test="${company.cp_idx eq companyBean.cp_idx and company.cp_best}">
								<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }<div class="best ">BEST</div></li>
							</c:when>
							<c:otherwise>
								<li class="on" onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }</li>
							</c:otherwise>
    					</c:choose>
    				</c:when>
    				<c:otherwise>
    					<c:choose>
    						<c:when test="${ company.cp_recommand and company.cp_best}">
    							<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }<div class="recommend ">추천</div><div class="best">BEST</div></li>
    						</c:when>
    						<c:when test="${ company.cp_recommand}">
    							<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }<div class="recommend ">추천</div></li>
    						</c:when>
    						<c:when test="${ company.cp_best}">
    							<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }<div class="best ">BEST</div></li>
    						</c:when>
    						<c:otherwise>
								<li onclick="location.href='./CorporationAction.cp?cp_idx=${company.cp_idx }'">${company.cp_name }</li>
							</c:otherwise>
    					</c:choose>
    				</c:otherwise>
    			</c:choose>    				
			  </c:forEach>         
            </ul>
          </div>
          <!--.list-->
          <div class="info">
            <h2 class="logo"></h2>
            <h3>일반음식점</h3>
            <h1>바른생선횟집<span>해운대점</span></h1>
            <div class="info-content">
              <div class="data">
                <div>
                  <i><img src="img/corpor_icon1.png"></i>
                  <p>월 수익률</p>
                  <p>${companyBean.cp_monthly_profit}</p>
                </div>
                <div>
                  <i><img src="img/corpor_icon2.png"></i>
                  <p>투자계약기간</p>
                  <p><span>펀딩종료부터</span>${companyBean.iv_contraction_during}</p>
                </div>
                <div>
                  <i><img src="img/corpor_icon3.png"></i>
                  <p>최소투자금액</p>
                  <p><fmt:formatNumber value="<%=companyBean.getIv_min_amount() %>" pattern="#,###" /> Point</p>
                </div>
                <div>
                  <i><img src="img/corpor_icon4.png"></i>
                  <p>잔여구좌</p>
                  <p><fmt:formatNumber value="<%=companyBean.getIv_balance_stock() %>" pattern="#,###" /></p>
                </div>
                <div>
                  <i><img src="img/corpor_icon5.png"></i>
                  <p>현재모금액</p>
                  <p><fmt:formatNumber value="<%=companyBean.getIv_current_amount() %>" pattern="#,###" /> Point</p>
                </div>
                <div>
                  <i><img src="img/corpor_icon6.png"></i>
                  <p>투자가능금액</p>
                  <p><fmt:formatNumber value="<%=companyBean.getIv_possible_amount() %>" pattern="#,###" /> Point</p>
                </div>
                <div>
                  <i><img src="img/corpor_icon7.png"></i>
                  <p>현재참여인원</p>
                  <p><fmt:formatNumber value="<%=companyBean.getIv_current_participants() %>" pattern="#,###" />명</p>
                </div>
                <div>
                  <i><img src="img/corpor_icon8.png"></i>
                  <p>펀딩종료까지</p>
                  <p>2일</p>
                </div>
              </div>
              <div class="calc">
                <h2>지금 이 상품에</h2>
                <div class="calc-top">
                  <div class="select-box">
                    <select>
                      <option>300 만원</option>
                      <option>1,000 만원</option>
                      <option>5,000 만원</option>
                      <option>10,000 만원</option>
                    </select>
                  </div>
                  <p>을 투자하시면</p>
                </div>
                <div class="calc-bottom">
                  <div>
                    <p>예상 세후 총 수익금</p>
                    <div class="circle">!
                      <div>상기 표시된 연 수익률에서 플랫폼 수수료를 제외한 총액이며, 실제 상환 일정에 따라 변동될 수 있습니다.</div>
                    </div>
                    <input type="text" value="273,440 원" readonly>
                  </div>
                  <div>
                    <p>12월동안 월 평균</p>
                    <div class="circle">!
                      <div>펀딩 실행일로부터 30일간 발생할 예상 세후 수익금의 총액을 표기한 값이며, 실제 지급금은 상환 회차와 일정에 따라 변동될 수 있습니다.</div>
                    </div>
                    <input type="text" value="22,474 원" readonly>
                  </div>
                  <div>
                    <p>1금융권 정기예금의 평균</p>
                    <div class="circle">!
                      <div>1금융권 정기 예금 평균 금리 1.3%를 기준으로 세후 수익률을 계산한 값입니다.</div>
                    </div>
                    <input type="text" value="7 배" readonly>
                  </div>
                  <a href="#">예상 지급스케쥴 자세히 보러가기</a>
                </div>
                <div class="invest" onclick="location.href='./Invest_beforeAction.cp'">투자하기</div>
              </div>
            </div>
            <div class="gage-bar">
              <p><%=companyBean.getIv_percent() %>%</p>
              <div class="gage">
                <div>
                  <span>${companyBean.iv_percent}</span>
                </div>
              </div>
              <div>
                <p><fmt:formatNumber value="<%=companyBean.getIv_current_amount() %>" pattern="#,###" /></p>
                <p><fmt:formatNumber value="<%=companyBean.getIv_goal_amount() %>" pattern="#,###" /></p>
              </div>
            </div>
            <div class="bg">
             <p>
             	<span><%=companyBean.getCp_intro_headline()%></span><br>
             	<%=companyBean.getCp_intro_content()%>
             </p>
            </div>
            <div class="photo">
              <h3>매장사진</h3>
              <div class="photo-top">
                <img src="<%=companyBean.getCf_image1() %>">
              </div>
              <div class="photo-mid">
                <div>
                  <img src="<%=companyBean.getCf_image2() %>">
                </div>
                <div>
                  <img src="<%=companyBean.getCf_image3() %>">
                </div>
              </div>
              <div class="photo-bottom">
                <img src="<%=companyBean.getCf_image4() %>">
              </div>
            </div>
            <div class="information">
              <div class="information-left">
                <h3>회사소개 및 사업계획</h3>
                <div class="info_inwrap">
                  <img src="img/store_info1.png">
                  <img src="img/store_info1.png">
                  <img src="img/store_info1.png">
                  <img src="img/store_info1.png">
                  <img src="img/store_info1.png">
                  <img src="img/store_info1.png">
                </div>
              </div>
              <div class="information-right">
                <div class="basic-info">
                  <h3>기본정보</h3>
                  <table>
                    <tr>
                      <td>대표자</td>
                      <td><%=companyBean.getCp_manager() %></td>
                    </tr>
                    <tr>
                      <td>사업자 등록번호</td>
                      <td><%=companyBean.getCp_number() %></td>
                    </tr>
                    <tr>
                      <td>자본금</td>
                      <td><fmt:formatNumber value="<%=companyBean.getCp_capital() %>" pattern="#,###" /></td>
                    </tr>
                    <tr>
                      <td>본사주소</td>
                      <td><%=companyBean.getCp_add_ch() %> <%=companyBean.getCp_add_more() %></td>
                    </tr>
                  </table>
                </div>
                <div class="data">
                  <h3>참고자료</h3>
                  <ul>
                    <li class="c1 on">
                      <div class="click"><a href="#">
                          <p class="name">재무제표.pdf</p>
                          <p class="more">more</p>
                        </a></div>
                      <div class="box"><a href="#">
                          <div class="img"></div>
                          <div class="text">
                            <a href="./CompanyFileDownload?filename=<%=companyBean.getCf_financial() %>&cp_idx=<%=companyBean.getCp_idx() %>" download>재무제표 다운로드</a>
                          </div>
                        </a></div>
                    </li>
                    <li class="c2">
                      <div class="click"><a href="#">
                          <p class="name">해당 업종 자격증 사본.JPG</p>
                          <p class="more">more</p>
                        </a></div>
                      <div class="box"><a href="#">
                          <div class="img"></div>
                          <div class="text">
                            <a href="./CompanyFileDownload?filename=<%=companyBean.getCf_certificate() %>&cp_idx=<%=companyBean.getCp_idx() %>" download>해당 업종 자격증 사본 다운로드</a>
                          </div>
                        </a></div>
                    </li>
                    <li class="c3">
                      <div class="click"><a href="#">
                          <p class="name">부동산 임대차 계약서 사본.JPG</p>
                          <p class="more">more</p>
                        </a></div>
                      <div class="box"><a href="#">
                          <div class="img"></div>
                          <div class="text">
                            <a href="./CompanyFileDownload?filename=<%=companyBean.getCf_estate_contract() %>&cp_idx=<%=companyBean.getCp_idx() %>" download>부동산 임대차 계약서 사본 다운로드</a>
                          </div>
                        </a></div>
                    </li>
                    <li class="c4">
                      <div class="click"><a href="#">
                          <p class="name">사업자 등록증 사본.JPG</p>
                          <p class="more">more</p>
                        </a></div>
                      <div class="box"><a href="#">
                          <div class="img"></div>
                          <div class="text">
                            <a href="./CompanyFileDownload?filename=<%=companyBean.getCf_registration() %>&cp_idx=<%=companyBean.getCp_idx() %>" download>사업자 등록증 사본 다운로드</a>
                          </div>
                        </a></div>
                    </li>
                  </ul>
                </div>
                <div class="map">
                  <h3>매장위치</h3>
                  <div class="corpor-location">
                    <!--  <div id="daumRoughmapContainer1561009275041" class="root_daum_roughmap root_daum_roughmap_landing"></div>-->
                    <div id="map" style="width:450px;height:400px;" ></div>
                  </div>
                </div>
              </div>
            </div>
            <div id="rwd">
              <h3>기업 예상 순수익</h3>
              <h4>손익상세 <span>(2019년 4월 기준)</span><span>(단위 : 원 / 년)</span></h4>
               <table>
                <tr>
                  <th colspan="2">매출</th>

                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_sales() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th rowspan="4">비용</th>
                  <td>원재료(생선매입비용)</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_stuff() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <td>인건비</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_costs_person() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <td>임대비</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_lease_expenses() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <td>운영비</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_operating_expenses() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th colspan="2">순수익</th>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_net_income() %>" pattern="#,###" /> 원</td>
                </tr>
              </table>
              <h4>월 평균 수익금 <span>(1구좌 당)</span><span>(단위 : 원 / 년)</span></h4>
              <table class="avrg">
                <tr>
                  <th>현금 배당률</th>
                  <td>순수익의 50%</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_cash_dividend_ratio() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th>지분</th>
                  <td>1%</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_share() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th>플랫폼 이용료</th>
                  <td>지분의 10.5%</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_platform() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th>예상 수익금</th>
                  <td>지분 - 플랫폼 이용료</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_proceeds() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th colspan="2">월 평균</th>
                  <td style="color: #ff9123"><fmt:formatNumber value="<%=companyBean.getCp_pre_avg_monthly() %>" pattern="#,###" /> 원</td>
                </tr>
              </table>
              <h4>1금융권 정기 예금과 평균 비교</h4>
              <table class="thanbank">
                <tr>
                  <th>실 수익률</th>
                  <td>(지급이자 - 플랫폼 이용료) / 원금</td>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_net_profit_ratio() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr>
                  <th colspan="2">1금융권 정기예금 평균 금리</th>
                  <td><fmt:formatNumber value="<%=companyBean.getCp_pre_interest_rate() %>" pattern="#,###" /> 원</td>
                </tr>
                <tr></tr>
              </table>

            </div>
            <div id="rwdsd">
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
                <c:forEach var = "i" begin = "1" end = "12"> 
	                <tr>
	                  <td>${i}</td>
	                  <td><%=companyBean.getCp_pay_expected_payment_date() %></td>
	                  <td><%=companyBean.getCp_pay_principal() %></td>
	                  <td><%=companyBean.getCp_pay_interest_paid() %></td>
	                  <td><%=companyBean.getCp_pay_fees() %></td>
	                  <td><%=companyBean.getCp_pay_actual_payment_amout() %></td>
	                  <td><%=companyBean.getCp_pay_actual_rate_return() %></td>
	                </tr>
              	</c:forEach>
                <tr>
                  <td>총 합계</td>
                  <td>-</td>
                  <td>3,000,000원</td>
                  <td>305,520원</td>
                  <td>32,080원</td>
                  <td>273,470원</td>
                  <td>9.13%</td>
                </tr>
              </table>
              </div>
              
            </div>
            <div class="notice">
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
                <%=companyBean.getCp_business_risk() %>
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
                 <%=companyBean.getCp_company_risk() %>
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
                <%=companyBean.getCp_other_risks() %>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--.inner-->
    </div>
    <!--.bodyWrap-->
    <footer></footer>
  </div>
  <input type="hidden" value="${companyBean.cp_add_ch }" name="cp_add_ch" id="cp_add_ch">
  <input type="hidden" value="${companyBean.cp_name }" name="cp_name" id="cp_name">
  </body>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3fd911319378df3f4ed86e94c8737483&libraries=services,clusterer,drawing"></script>
  <script type="text/javascript" src="company/js/map.js"></script>
  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
  </script>
  <script>
    $(function() {
      $('.gage').each(function() {
        var percent = $(this).find('span').text() + '%'

        $(this).find('div').animate({
          'width': percent
        }, 2000)
      });
    });
  </script>
  <script>
    $(function() {
      var FH = $('.content').offset().top

      $(window).on('scroll', function() {
        if ($(window).width() >= 767) {
          var WH = $(window).scrollTop();

          if (WH > FH) {
            $('.content').addClass('on')
          } else {
            $('.content').removeClass('on')
          }
        } else false;
      });
    });
  </script>
  <script>
    $(function() {
      if ($(window).width() <= 767) {
        $('.content .list').height($(window).height());
      } else false;
    });
  </script>
  <script>
    $(function() {
      $(".data ul li .click").click(function() {
        $(".data ul li").removeClass("on");
        $(this).parent("li").addClass("on");
        return false;
      });
    });
  </script>
  <script>
    $(function() {
      $(".list ul li").click(function() {
        $(".list ul li").removeClass("on");
        $(this).addClass("on");
      });
    });
  </script>
  <script>
    $(function() {
      var winh = $(window).height();

      $(".list-float").click(function() {
        $(".list-float").toggleClass("on"),
          $('.content .list').slideToggle(500);
        return false;
      });
    });
  </script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
  <!-- <script charset="UTF-8">
    var mapWidth = $('.corpor-location').innerWidth();
    var mapHeight = $('.corpor-location').innerHeight();

    new daum.roughmap.Lander({
      "timestamp": "1561009275041",
      "key": "uz7i",
      "mapWidth": mapWidth,
      "mapHeight": mapHeight
    }).render();
  </script> -->
  </html>
