<%@page import="net.company.dto.CompanyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>투자 하기</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/invest.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="company/js/invest_functions.js"></script>
</head>

<body>
<%
	CompanyBean companyBean = (CompanyBean)request.getAttribute("company");
%>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>

    <article class="bf_noti">
      <div class="noti_in">
        <h1><img src="./img/logo.svg" alt=""></h1>
        <h2>잠깐! 투자 유의사항을 꼼곰히 확인하시고, 투자하세요.</h2>
        <h3>펀박스에서 진행되는 투자 상품에 대한 투자는 아래와 같은 투자 위험을 가지고 있습니다.</h3>
        <h4><span>1</span>원금손실의 위험이 있습니다.</h4>
        <p>모든 투자는 원금손실의 위험을 가지고 있습니다. 때문에 투자 시 한 곳에만 투자하지 아니하고 다양한 상품에 분산하여 투자하실 것을 권유 드립니다. 펀박스는 블록체인을 활용한 투자중개업자로 원금손실에 대한 책임을 지지 않습니다. 모든 투자는 투자자 본인의 의사에 따라 결정 되어야 합니다.</p>
        <input type="checkbox" id="chk1" class="checkBox"><label for="chk1">위 사항을 모두 확인하였습니다.</label>
        <h4><span>2</span>환금성이 낮습니다.</h4>
        <p>비상장기업에 대한 투자는 환금성이 낮습니다. 펀박스의 중개를 통해 모집된 투자금은 약정기간동안 출금이 제한되며, 출금이 가능한 시점이 되더라도 현금으로의 전환이 보장되지는 않습니다. 투자금을 회수하기 위하여 주식의 경우 스타트업 주식거래시장(KSM)에서 거래하거나, 기업의 M&A 또는 주식시장 상장 등이 있을 때까지 기다려야 할 수 있습니다. 채무증권이나 주식 관련 채권의 경우에도 특별한 사정이나 조건이 없는 한 만기까지 기다려야 합니다.</p>
        <input type="checkbox" id="chk2" class="checkBox"><label for="chk2">위 사항을 모두 확인하였습니다.</label>
        <h4><span>3</span>배당금 변동 가능성이 있습니다.</h4>
        <p>펀박스의 중개를 통해 증권을 발행하는 비상장 기업은 성장 초기단계에 있는 경우가 많기 때문에, 아직 성장해야 하는 단계이기 때문에 기간별 수익금 변동에 따라 배당 수익이 변동될 수 있습니다. 따라서 기대 배당수익을 기대하고 투자를 할 경우 기대한 만큼의 수익을 얻지 못할 수 있습니다.</p>
        <input type="checkbox" id="chk3" class="checkBox"><label for="chk3">위 사항을 모두 확인하였습니다.</label>
        <h4><span>4</span>지분 희석이 발생할 수 있습니다.</h4>
        <p>펀박스를 통하여 투자한 회사는 지속적으로 성장하기 위하여 해당 기업의 청관에 근거하여 유상종자를 실시할 가능성이 있습니다. 유상종자로 인하여 투자자가 보유한 지분율은 감소될 수 있습니다.</p>
        <input type="checkbox" id="chk4" class="checkBox"><label for="chk4">위 사항을 모두 확인하였습니다.</label>
        <br>
        <input type="checkbox" id="chka"><label for="chka">모든 투자 위험을 확인했으며 위 내용에 모두 동의합니다.</label>
        <hr>
        <input type="button" value="돌아가기" onclick="location.href='./CorporationAction.cp'">
        <input type="button" value="계속 투자하기" class="gon" onclick="checkGo();">
      </div>
    </article>
    <section id="inv_bf">
      <div class="inner">
        <article class="inv_inbox">
          <img src="./img/con_img002.jpg" alt="">
          <form class="inv_intxt" name="inv_before" method="post" action="./Invest_point.cp">
            <h2>투자 조건 설정</h2>
            <h3><%=companyBean.getCp_name() %><span><%=companyBean.getCp_add_ch() %></span></h3>
            <p><%=companyBean.getCp_intro_content() %></p>
            
            <div class="gage">
              <div class="per">
              <fmt:parseNumber var="test" value="<%=companyBean.getIv_percent() %>" integerOnly = "true" />
              	<span>${test}</span>%
              </div>
              <div class="gage_full">
                <div class="gage_fill"></div>
                <span></span>
              </div>
            </div>
            
			<div class="cost">
				<fmt:formatNumber var="minAmount" value="<%=companyBean.getIv_min_amount() %>" pattern="#,###"/>
				<span>${minAmount}</span> point</div>
            <div class="quantity">
              <input type="number" name="select" min="1" step="1" value="1">
            </div>
            <hr>
            <div class="sum">합계
 				<span>0</span> point 
            </div>
            <input type="hidden" name="invest_point" id="invest_point" value="20000"> 
            <input type="hidden" name="invest_amount" id="invest_amount" value="1"> 
            <input type="hidden" name="cp_idx" value="<%=companyBean.getCp_idx()%>">
            <input type="button" value="투자하기" onclick="invest_add();">
          </form>
        </article>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <footer></footer>
  </div>

  <script>
    $(function() {
      $('header').load('./header/header.jsp');
      $('footer').load('./footer/footer.jsp');
    });
    
    $(function() {
       $('body').css('overflow', 'hidden');
      
      $('.gon').click(function() {
        $('body').css('overflow', 'auto');
        $('.bf_noti').fadeOut(300);

        $('.gage').each(function() {
          var percent = $(this).find('.per > span').text();

          $(this).find('.gage_fill').animate({
            'width': percent + '%'
          }, 1500);
        });
      });
    });

    jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.quantity input');
    jQuery('.quantity').each(function() {
      var spinner = jQuery(this),
        input = spinner.find('input[type="number"]'),
        btnUp = spinner.find('.quantity-up'),
        btnDown = spinner.find('.quantity-down'),
        min = input.attr('min'),
        max = input.attr('max');

      btnUp.click(function() {
        var oldValue = parseFloat(input.val());
        if (oldValue >= max) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue + 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

      btnDown.click(function() {
        var oldValue = parseFloat(input.val());
        if (oldValue <= min) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue - 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });
    });
    
    $(function(){
     var price = $('.cost span').text();
     var resultPrice = price.replace(",","");
     
     $('.sum span').text(resultPrice) 
      
     $('.quantity-button').click(function(){
       
     var amount = $('.quantity input').val();
     var sum = resultPrice * amount
 //    console.log("sum : "+ sum);
     
        $('.sum span').text(sum)
        $('#invest_amount').val(amount); // 투자하기 넘길때 사용
        $('#invest_point').val(sum); // 투자하기 넘길때 사용
      });
      
      setInterval(function(){
        var amount = $('.quantity input').val();
        var sum = resultPrice * amount
        var addCommaSum;
        
        sum = sum + ""; 
        point = sum.length % 3 ;
        len = sum.length; 
       
        addCommaSum = sum.substring(0, point); 
        while (point < len) { 
            if (addCommaSum != "") addCommaSum += ","; 
            addCommaSum += sum.substring(point, point + 3); 
            point += 3; 
        }         
        $('.sum span').text(addCommaSum) // 여기에 합계 표시
      },1000);
      
    });
  </script>
</body></html>
