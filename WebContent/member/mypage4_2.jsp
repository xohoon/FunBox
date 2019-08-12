<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.member.dao.MemberDAO" %>
<%@ page import="net.member.dto.MemberBean" %>
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
  <link href="css/mypage.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/947fdcffe2.js"></script>
   <script src="js/jquery-3.1.1.min.js"></script>
   <script src="member/js/update_functions.js"></script>
  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
	  $('.like_box').load('./member/like_box.jsp')
    }); 
	  
  </script>

</head>

<body>
<%
	String id = (String)session.getAttribute("id");

	MemberDAO dao = new MemberDAO();
	MemberBean memberBean = dao.getMemberInfo(id);
%>
	<input type="hidden" id="phone_code" name="phone_code" >
    <input type="hidden" id="phone_number" name="phone_number">
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    
    <section>
    	<div class="like_box"></div><!--.info-->
    	<ul class="tab">
    		<li onclick="location.href='./MemberInvestmentList.mb'">투자현황</li>
    		<li onclick="location.href='./Mypage2.mb'">자산관리</li>
    		<li onclick="location.href='./Mypage3.mb'">거래내역</li>
    		<li class="on" onclick="location.href='./Mypage4_2.mb'">내정보</li>
		</ul>
   		<div class="myinfo">
   		<form id="mypage4_2_form" name="mypage4_2_form" action="./MemberUpdateAction.mb" method="post">
   			<div>
   				<label for="id">아이디</label>
   				<input type="text" id="id" name="id" value="<%=memberBean.getId() %>" readonly="readonly">
   			</div>
   			<div>
   				<label for="name">이름</label>
   				<input type="text" id="name" name="name" value="<%=memberBean.getName() %>" readonly="readonly">
   			</div>
   			<div>
   				<label for="mail">E-mail</label>
   				<input type="text" id="mail" name="mail" value="<%=memberBean.getEmail() %>" readonly="readonly">
   				<input type="button" class="rev" id="rev_mail" value="수정하기">
   				<input type="text" class="rev_form" id="new_mail" name="new_mail" placeholder="새로운 이메일주소를 입력하세요">
   			</div>
   			<div>
   				<label for="pw">비밀번호</label>
   				<input type="password" id="pw" name="pw" maxlength="15" placeholder="현재 비밀번호를 입력하세요">
   				<input type="hidden" id="h_pw" name="h_pw" value="<%=memberBean.getPw() %>">
   				<input type="button" class="rev" id="rev_pw" value="수정하기">
   				<input type="password" class="rev_form" id="new_pw" name="new_pw" maxlength="15" placeholder="새로운 비밀번호를 입력하세요">
   			</div>
   			<div>
   				<label for="pin">PIN</label>
   				<input type="password" id="pin" name="pin" maxlength="6" placeholder="현재 PIN번호를 입력하세요">
   				<input type="hidden" id="h_pin" name="h_pin" value="<%=memberBean.getPin() %>">
   				<input type="button" class="rev" id="rev_pin" value="수정하기">
   				<input type="password" class="rev_form" id="new_pin" name="new_pin" maxlength="6" placeholder="새로운 PIN번호를 입력하세요">
   			</div>
   			<div>
   				<label for="ph">전화번호</label>
   				<input type="text" id="ph" name="ph" maxlength="11" value="<%=memberBean.getPh() %>" readonly="readonly">
   				<input type="button" class="rev" id="rev_ph" value="수정하기">
   				<input type="text" class="rev_form" id="new_ph" name="new_ph" maxlength="11" placeholder="새로운 전화번호를 입력하세요">
   				<input type="button" class="letter rev_form" value="인증번호받기" onclick="check_to_phone();">
		        <input type="text" class="verti_num rev_form" name="verti_num" placeholder="인증번호 6자리">
         		<input type="button" value="확인" class="rev_form ver_ch" onclick="certification_check();">
   			</div>
   			<div>
   				<label for="addr">주소</label>
   				<input type="text" class="addr" name="add_num" id="sample6_postcode" value="<%=memberBean.getAdd_num() %>" placeholder="우편번호" readonly="readonly">
   				<input type="button" class="addr_btn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
				<input type="text" name="add_ch" class="addr2" id="sample6_address" placeholder="주소" value="<%=memberBean.getAdd_ch() %>" readonly="readonly"><br>
				<input type="text" name="add_more" class="addr3" id="sample6_detailAddress" placeholder="상세주소" value="<%=memberBean.getAdd_more() %>">
				<input type="text" name="add_extra" class="addr4" id="sample6_extraAddress" placeholder="참고항목" value="<%=memberBean.getAdd_extra() %>">
				<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js">sample6_execDaumPostcode()</script>
   			</div>
   			<input type="button" class="submit" value="저장하기" onclick="update_check();">
   		</form>
   		</div><!--.myinfo-->
    </section>

    <footer></footer>
  </div>
	<script>
	/* 
	  $(function(){
		 $('.rev').on('click',function(){
			 $(this).siblings('.rev_form').toggleClass('on');
		 });
	  });
	 */  
	  $(function() {
		  $('.rev').click( function() {
			$(this).siblings('.rev_form').toggleClass('on');
			  
			if( $(this).val() == '수정하기' ) {
			  $(this).val('취소');
			}
			else if($(this).val() == '취소'){
			  $(this).val('수정하기');
			}
		  });
		});
	</script>
</body>
</html>
