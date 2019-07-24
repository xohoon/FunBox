<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <div class="footTop">
        <ul>
          <c:if test="${sessionScope.id eq null}">
          <li><a href="./JoinPage.mb">회원가입</a></li>
          <li><a href="./LoginPage.mb">로그인</a></li>
          </c:if>
          <li><a href="./Policy_1.bd">이용안내</a></li>
          <li><a href="./Notice.bd">공지사항</a></li>
        </ul>
      </div>
      <div class="footMid">
        <div><span>고객센터</span> 평일 9:00 ~ 18시 (점심 11:30 ~ 12:30)</div>
        <div><span>전화</span> 000-000-0000</div>
        <div><span>팩스</span> 051-000-0000</div>
        <div><span>대표메일</span> 000@000.com</div>
        <div><span>사업제휴</span> partner@000.com</div>
        <div>(주)FUNBOX <span>대표</span> 000</div>
        <div><span>사업자번호</span> 000-00-000000</div>
        <div><span>주소</span> 부산광역시 어디동 어디000-00</div>
      </div>
      <div class="footBot">
        <p>FUNBOX는 투자원금과 수익을 보장하지 않으며, 투자손실에 대한 책임은 모두 투자자에게 있습니다.</p>
        <div>Copyright © 2019 IOLAB. All rights reserved.</div>
      </div>

 