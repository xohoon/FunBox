<%@page import="net.board.dto.Board_Search_ListVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="net.company.dto.CompanyBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	/* ArrayList<Board_Search_ListVO> searchVO = (ArrayList<Board_Search_ListVO>)request.getAttribute("searchVO"); */
	String cityName = (String)request.getAttribute("cityName");
%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!DOCTYPE html>
<html lang="kr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title>기업 리스트</title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/list.css" rel="stylesheet">

  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.scrollstop.js"></script>
  <script src="board/js/list_function.js"></script>
  <script src="board/js/unlimitedScrolling.js"></script>
  <script src="board/js/list.js"></script>
</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>

    <section id="sec1">
      <div class="inner">
        <article class="search_bar">
          <div class="view_type">
            <span class="view_type_ract on"></span>
            <span class="view_type_wide"></span>
          </div>

          <div class="search">
            <input type="search" placeholder="추천 키워드 '바른생선회'" id="search_text">
            <input type="button" value="검색" id="search_btn">
          </div>

          <div class="list_set">
            <select id="select_option">
              <option value="0">등록순</option>
              <option value="1">추천순</option>
              <option value="2">수익순</option>
            </select>
          </div>

          <div class="filter">
            <div></div>
            <div></div>
          </div>
          <div class="f_list">
            <form>
              <div class="f_list_type1">
                <h2>업종</h2>
                <span>
                  <input type="checkbox" id="con1_all" value="업종전체">
                  <label for="con1_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_1" class="sector_ckbox" value="한식">
                  <label for="con1_1">한식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_2" class="sector_ckbox" value="분식">
                  <label for="con1_2">분식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_3" class="sector_ckbox" value="일식">
                  <label for="con1_3">일식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_4" class="sector_ckbox" value="중식">
                  <label for="con1_4">중식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_5" class="sector_ckbox" value="양식">
                  <label for="con1_5">양식</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_6" class="sector_ckbox" value="카페">
                  <label for="con1_5">카페</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_7" class="sector_ckbox" value="치킨">
                  <label for="con1_5">치킨</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_8" class="sector_ckbox" value="기타">
                  <label for="con1_5">기타</label>
                </span>
              </div>

              <div class="f_list_type2">
                <h2>지역</h2>
                <span>
                  <input type="checkbox" id="con2_all" value="도시전체">
                  <label for="con2_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" name="10" id="con2_1" class="city_ckbox" value="서울">
                  <label for="con2_1">서울</label>
                </span>
                <span>
                  <input type="checkbox" name="11" id="con2_2" class="city_ckbox" value="경기">
                  <label for="con2_2">경기</label>
                </span>
                <span>
                  <input type="checkbox" name="12" id="con2_3" class="city_ckbox" value="인천">
                  <label for="con2_3">인천</label>
                </span>
                <span>
                  <input type="checkbox" name="13" id="con2_4" class="city_ckbox" value="강원">
                  <label for="con2_4">강원</label>
                </span>
                <span>
                  <input type="checkbox" name="14" id="con2_5" class="city_ckbox" value="대전/충천">
                  <label for="con2_5">대전/충천</label>
                </span>
                <span>
                  <input type="checkbox" name="15" id="con2_6" class="city_ckbox" value="대구">
                  <label for="con2_6">대구</label>
                </span>
                <span>
                  <input type="checkbox" name="16" id="con2_7" class="city_ckbox" value="부산">
                  <label for="con2_7">부산</label>
                </span>
                <span>
                  <input type="checkbox" name="17" id="con2_8" class="city_ckbox" value="울산">
                  <label for="con2_8">울산</label>
                </span>
                <span>
                  <input type="checkbox" name="18" id="con2_9" class="city_ckbox" value="경상">
                  <label for="con2_9">경상</label>
                </span>
                <span>
                  <input type="checkbox" name="19" id="con2_10" class="city_ckbox" value="광주/전라">
                  <label for="con2_10">광주/전라</label>
                </span>
                <span>
                  <input type="checkbox" name="20" id="con2_11" class="city_ckbox" value="제주">
                  <label for="con2_11">제주</label>
                </span>
              </div>

              <div class="f_list_type3">
                <h2>현황</h2>
                <span>
                  <input type="checkbox" id="con3_all" value="현황전체">
                  <label for="con3_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_1" class="status_ckbox" value="10">
                  <label for="con3_1">대기중</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_2" class="status_ckbox" value="11">
                  <label for="con3_2">펀딩중</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_3" class="status_ckbox" value="12">
                  <label for="con3_3">펀딩완료</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_4" class="status_ckbox" value="21">
                  <label for="con3_4">수익 분배중</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_5" class="status_ckbox" value="22">
                  <label for="con3_4">수익 분배완료</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_6" class="status_ckbox" value="30">
                  <label for="con3_4">연체중</label>
                </span>
              </div>
            </form>
          </div>
        </article>
      </div>
    </section>

    <section id="sec2">
      <div class="inner">
	        <div class="mom_box"></div>
        <div class="scrolload">
          <div class="loader">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
          </div>
        </div>

        <button class="moreBtn">더보기 <span>▼</span></button>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <footer></footer>
  </div>
  <script>
    $(document).ready(function(){
    	var cityName = <%=cityName%>;
    	if(cityName != null){
	    	$('.search_bar').toggleClass('on');
	    	$("input[name$='"+<%=cityName%>+"']").click();
    	}else{
    		$('.moreBtn').trigger('click');
    	}
    });
  </script>  
</body>
</html>
