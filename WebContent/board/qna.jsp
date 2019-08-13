<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="net.member.dto.MemberBean"%>
<%@ page import="net.member.dao.MemberDAO"%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>1:1문의하기</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/jquery.bxslider.css" rel="stylesheet">

  <link href="css/service.css" rel="stylesheet">
  <link href="css/list_box.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>
  <script src="board/js/qna_functions.js"></script>
  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
    });
  </script>

</head>

<body>

<%
	String id = (String)session.getAttribute("id");
	MemberDAO dao = new MemberDAO();
	MemberBean memberBean = dao.getMemberInfo(id);
%>

  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>
    
    <section id="section01">
			<div class="tit">
				<h3>고객지원서비스</h3>
				<h5>FUNBOX 고객지원 서비스입니다</h5>
			</div><!--sub_title-->

			<div class="qna cf">
				<h4>문의하기</h4>
				<h5>문의사항을 남겨주세요. 확인 후 답변 드리겠습니다.</h5>
				<button onclick="location.href='./BoardQnaList.bd'">문의내역으로 돌아가기</button>
				<form id="qna_form" name="qna_form" method="post" action="./BoardQnaAction.bd">
					<div>
						<label>질문유형선택</label>
						<select id="category" name="category">
							<option value="">선택</option>
							<option value="가입">가입</option>
							<option value="투자">투자</option>
						</select>
					</div>
						<input type="hidden" id="id" name="id" value="${sessionScope.id}">
					<div>
						<label>이름</label>
						<input type="text" id="name" name="name" value=<%=memberBean.getName() %> readonly="readonly">
					</div>
					<div>
						<label>E-mail</label>
						<input type="text" id="email" name="email" placeholder="이메일을 입력해주세요">
						<div class="alert">
							<input type="checkbox" id="ag_e" name="ag_e">
							<label for="ag_e">이메일로 답변 알림받기</label>
						</div>
					</div>
					<div>
						<label>Mobile</label>
						<input type="text" id="mobile" name="mobile" maxlength="11" placeholder="핸드폰번호 '-' 제외 11자리 입력해주세요">
						<div class="alert">
						<input type="checkbox" id="ag_p" name="ag_p">
						<label for="ag_p">문자로 답변 알림받기</label>
						</div>
					</div>
					<div>
						<label>제목</label>
						<input type="text" id="title" name="title">
					</div>
					<div>
						<label>내용</label>
						<textarea id="content" name="content"></textarea>
					</div>
					<input type="button" value="제출하기" onclick="qna_check();">
				</form>
			</div><!--qna-->
		</section>
		
    <footer></footer>
  </div>

</body></html>
