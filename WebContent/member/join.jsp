<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">

  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>FUNBOX 회원가입</title>
  <link href="./css/common.css" rel="stylesheet">
  <link href="./css/form.css" rel="stylesheet">
  <script src="member/js/join_functions.js"></script>
  <script src="js/html5.js"></script>
  <script src="js/jquery-3.1.1.min.js"></script>
</head>
<!--head-->

<body>
	<input type="hidden" id="phone_code" name="phone_code" >
    <input type="hidden" id="phone_number" name="phone_number">
  <div id="wrap">
    <h1><img src="./img/logo.svg" alt="logo" onclick="location.href='./Index.mb'"></h1>
    <form id="join_form" name="join_form" action="./MemberJoinAction.mb" method="post">
    <h3>회원가입</h3>
     <div id="intro">
        <p class="tt1">
            안녕하세요.<br>
            <span>Funbox</span> 입니다.
        </p>
        <p class="tt2">
            회원정보를 입력해주세요.
        </p>
     </div><!--#intro-->
      <div id="id-group" class="group cf">
        <label for="id">아이디</label>
        <input type="text" id="id" name="id" maxlength="15" placeholder="영문 또는 영문/숫자 조합, 6~15자리 등록가능합니다."
        onkeydown="id_false_check();fn_press_sub_capital(this);" onBlur="fn_press_sub_capital(this);">
        <input type="button" value='중복확인' onclick="id_ch();">
      </div>
      <!--#id-->
      <div id="pw-group" class="group cf">
        <label for="pw">비밀번호</label>
        <input type="password" id="pw" name="pw" maxlength="15" placeholder="영문/숫자/특수문자 조합, 8~15자리 등록가능합니다.">
      </div>
      <!--pw-->
      <div id="pwc-group" class="group cf">
        <label for="pwc">비밀번호 확인</label>
        <input type="password" id="pwc" name="pwc" maxlength="15" placeholder="비밀번호를 한번 더 입력해주세요.">
      </div>
      <!--pwssword check-->
      <!-- <div id="tx-group" class="group cf">
        <label for="tx">TX비밀번호</label>
        <input type="button" value="확인" class="tx_btn" onclick="tx_check();">
        <input type="password" id="tx" name="tx"  maxlength="15" placeholder="영문/숫자/특수문자 조합, 8~15자리 등록가능합니다.">
      </div> -->
      <!--tx-->
      <div id="pin-group" class="group cf">
        <label for="pin">Pin code</label>
        <input type="password" id="pin" name="pin"  maxlength="6" placeholder="숫자 6자리 등록가능합니다.">
      </div>
      <!--pin-->
      <div id="pinch-group" class="group cf">
        <label for="pinch">Pin code 확인</label>
        <input type="password" id="pinch" name="pinch" maxlength="6" placeholder="핀코드를 한번 더 입력해주세요.">
      </div>
      <!--pwssword check-->
      <div id="email-group" class="group cf">
        <label for="email">E-mail</label>
        <input type="text" id="email" name="email" maxlength="35" placeholder="이메일을 입력해주세요.">
      </div>
      <!--email-->
        <div id="name-group" class="group cf">
        <label for="name">성명</label>
        <input type="text" id="name" name="name" maxlength="10" placeholder="이름을 입력해주세요.">
        </div><!--#name-->
        <div id="ph-group" class="group cf">
        <label for="ph">휴대전화번호</label>
        <input type="text" id="ph" name="ph" maxlength="11" placeholder="'-'없이 11자리 입력해주세요." onkeydown="phone_false_check();">
        <input type="button" class="letter" value="인증번호받기" onclick="check_to_phone();">
        </div><!--#ph-->
        <div id="verti-group" class="group cf">
        <input type="button" class="num_ch" value="확인" onclick="certification_check();">
        <input type="text" id="verti_num" name="verti_num" placeholder="인증번호 6자리">
        </div><!--#verti-->
        <!-- <div id="add-group" class="group cf">
     		<label for="add">주소</label>
     		<input type="button" value="주소검색" class="add_btn">
     		<input type="text" id="add_num" readonly name="add_num">
     		<input type="text" readonly id="add_ch" name="add_ch">
     		<input type="text" id="add_more" name="add_more" placeholder="상세주소를 입력하세요.">
     	</div> --><!--adderess-->
     	<div id="add-group" class="group cf">
			<label for="add">주소</label>
     		<input type="button" onclick="sample6_execDaumPostcode()" class="add_btn" value="우편번호 찾기">
     		<input type="text" name="add_num" id="sample6_postcode" placeholder="우편번호" readonly="readonly">
			<input type="text" name="add_ch" id="sample6_address" placeholder="주소" readonly="readonly"><br>
			<input type="text" name="add_more" id="sample6_detailAddress" placeholder="상세주소">
			<input type="text" name="add_extra" id="sample6_extraAddress" placeholder="참고항목">
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js">sample6_execDaumPostcode();</script>
     	</div>
      <div id="reco-group" class="group cf">
        <label for="reco">추천인 ID</label>
        <input type="button" class="reco_btn" value="확인" onclick="recommender_check();">
        <input type="text" id="reco" name="reco" maxlength="20" placeholder="추천인 ID를 입력해주세요."
        onkeydown="recom_false_check();fn_press_sub_capital(this);" onblur="fn_press_sub_capital(this);">
      </div>
      <!--추천인-->
      <div id="agree-group" class="group">
      <p>서비스정책동의</p>
      <div id="agree1" class="cf"><input type="checkbox" id="ag1"> <label for="ag1">[필수] 서비스이용약관에 동의합니다.</label></div>
      <div id="agree2" class="cf"><input type="checkbox" id="ag2"> <label for="ag2">[필수] 개인정보처리방침에 동의합니다.</label></div>
      <div id="agree3" class="cf"><input type="checkbox" id="ag3" name="ag3"> <label for="ag3">[선택] 마케팅 정보수집 및 활용에 동의합니다.</label></div>
      <div id="agree4" class="cf"><input type="checkbox" id="ag4" name="ag4"> <label for="ag4">[선택] 이벤트 및 뉴스레터 수신에 동의합니다.</label></div>
      </div>
      <input type="button" class="submit" value="가입하기" onclick="join_check();">
      <div class="go_login">
        이미 펀박스 회원이신가요?
        <a href="./LoginPage.mb" target="_self">로그인</a>
     </div><!--.go_login-->
    </form>
    <footer>
        <ul>
            <li><a href="./Policy_1.bd">이용안내</a></li>
            <li><a href="./Notice.bd">공지사항</a></li>
        </ul>
        <p>
            Copyright ⓒ 2019 IOLAB. All rights reserved.
        </p>
    </footer>
  </div><!--#wrap-->
  <div class="pol policy1">
    <div class="pol_wrap">
     <p>서비스이용약관</p>
     <button class="closer">
         <span></span>
         <span></span>
     </button>
      <div id="txt_box">
          제1장 총칙<br><br>
          제1조 (목적)
본 약관은 펀박스 주식회사(이하 회사)가 인터넷 사이트(https://www.funbox.kr)를 통하여 제공하는 서비스 등 제반 서비스의 이용과 관련하여 
 회사와 회원과의 권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.

제2조 (정의)
본 약관에서 사용하는 용어의 정의는 다음과 같습니다.

서비스 : 회원이 온라인 홈페이지를 통하여 본 약관에 따라 이용할 수 있는 회사가 제공하는 모든 서비스를 의미합니다.
홈페이지 : 본 약관에 따라 회사가 제공하는 서비스가 구현되는 온라인상의 웹페이지(https://www.funbox.kr)를 말합니다.
회원 : 본 약관에 따라 회사와 서비스이용계약을 체결하고 홈페이지를 통하여 서비스를 이용할 수 있는 자격을 부여받은 자를 말합니다.
아이디(ID) : 회원의 식별과 서비스 이용을 위하여 회원이 정하고 회사가 승인하는 문자와 숫자의 조합을 의미합니다.
비밀번호 : 회원이 부여 받은 아이디와 일치되는 회원임을 확인하고 비밀보호를 위해 회원 자신이 정한 문자 또는 숫자의 조합을 의미합니다.
게시물 : 회원이 서비스를 이용함에 있어 홈페이지의 게시판에 게재한 부호ㆍ문자ㆍ음성ㆍ음향ㆍ화상ㆍ동영상 등의 정보 형태의 
글, 사진, 동영상 및 각종 파일과 링크 등을 의미합니다.


제2장 서비스의 이용

제3조 (서비스의 제공)
회사가 본 약관에 따라 회원이 된 자는 다음 각 호의 서비스를 이용할 수 있습니다.
투자형 크라우드 펀딩서비스 : 투자광고 게시, 게시판 운영관리 등
a호 외 크라우드 펀딩 서비스 : 프로젝트 게시, 사이버거래장소 제공 등
위 각 호 서비스 제공을 위해 필요하거나 이에 부수하는 서비스
회원은 제1항 각 호 서비스와 관련된 개별 서비스를 이용하기 위하여 개별약관에 따른 새로운 약정을 회사와 체결하여야 할 수 있습니다. 
이 경우 각 개별 서비스의 구체적인 내용은 서비스별 개별약관에서 정한 바에 따릅니다.
서비스는 연중무휴, 1일 24시간 제공함을 원칙으로 합니다. 다만, 회사는 서비스를 일정범위로 분할하여 각 범위 별로 이용가능시간을 별도로 
지정할 수 있으며 이러한 경우에는 그 내용을 사전에 공지합니다.
회사는 컴퓨터 등 정보통신설비의 보수점검, 교체 및 고장, 통신두절 또는 운영상 상당한 이유가 있는 경우 서비스의 제공을 일시적으로 
중단할 수 있습니다. 
이 경우 회사는 회원에게 통지합니다. 다만, 회사가 사전에 통지할 수 없는 부득이한 사유가 있는 경우 사후에 통지할 수 있습니다.
회사는 서비스의 제공에 필요한 경우 정기점검을 실시할 수 있으며, 정기점검시간은 서비스제공화면에 공지한 바에 따릅니다.

제4조 (서비스의 변경)
회사는 상당한 이유가 있는 경우에 운영상, 기술상의 필요에 따라 제공하고 있는 전부 또는 일부 서비스를 변경할 수 있습니다.
서비스의 내용, 이용방법, 이용시간에 대하여 변경이 있는 경우에는 변경사유, 변경될 서비스의 내용 및 제공일자 등은 그 변경 전에 해당 서비스 
초기화면에 게시됩니다.
회사는 무료로 제공되는 서비스의 일부 또는 전부를 회사의 정책 및 운영의 필요상 수정, 중단, 변경할 수 있으며, 이에 대하여 관계법령에 
특별한 규정이 없는 한 회원에게 별도의 보상을 하지 않습니다.
      </div><!--#txt_box-->
      </div>
  </div><!--#policy-->
  <div class="pol policy2">
    <div class="pol_wrap">
     <p>개인정보처리방침</p>
     <button class="closer">
         <span></span>
         <span></span>
     </button>
      <div id="txt_box"></div><!--#txt_box-->
      </div>
  </div><!--#policy-->
  <div class="pol policy3">
    <div class="pol_wrap">
     <p>마케팅 정보수집 및 활용방침</p>
     <button class="closer">
         <span></span>
         <span></span>
     </button>
      <div id="txt_box"></div><!--#txt_box-->
      </div>
  </div><!--#policy-->
  
  <!-- <div class="sch_address">
  	<div class="sch_wrap">
  		<p>주소검색</p>
  		<button class="closer">
  			<span></span> 
  			<span></span> 
  		</button>
  		<div class="cf">
  			<label for="sch_box">지번/도로명검색</label>
  			<input type="button" value="검색">
  			<input type="text" id="sch_box" name="sch_box"> 			
  		</div>
  		<div class="add_txt">
  				<p>지번주소 : 동/읍/면/리 이름을 검색하세요.<span>예&#41; 역삼동, 화도읍, 둔내면</span></p>
  				<p>도로명주소 : 도로명을 입력하세요.<span>예&#41; 중앙로, 불정로432번길</span></p>
  			</div> 
  	</div>
  </div> --><!--.sch_address-->
   <script src="js/check_box.js"></script>

  <script>
  $(window).on('resize',function(){
      var winh = $(window).height();
      $('.pol').height(winh);
  });
    
    $(function(){
        $('#agree1').click(function(){
            $('.pol').removeClass('on');
            $('.policy1').addClass('on');
        });
        $('#agree2').click(function(){
            $('.pol').removeClass('on');
            $('.policy2').addClass('on');
        });
        $('#agree3').click(function(){
            $('.pol').removeClass('on');
            $('.policy3').addClass('on');
        });
        $('.pol .closer').click(function(){
            $('.pol').removeClass('on');
        });
		/* $('.add_btn').click(function(){
			$('.sch_address').addClass('on');
		});
		$('.sch_address .closer').click(function(){
            $('.sch_address').removeClass('on');
        }); */
    });      
  </script>
</body></html>
    