<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp" %>
<link href="${ctx}/resources/css/register.css" rel="stylesheet">
<section class="conA">
</section>

<section class="conB">
    <div class="register-container">
        <form action="${ctx}/member/register" method="post" autocomplete="off">
            <label>아이디</label>
            <div class="id_input">
	            <input type="text" placeholder="아이디" id="username" name="username">
	            <button type="button" id="checkIdBtn">중복확인</button>
            </div>
            <label id="username_msg"></label><br>

            <label>비밀번호</label>
            <input type="password" placeholder="비밀번호" id="password" name="password">
			<label id="pw_msg"></label><br>
			
            <label>비밀번호확인</label>
            <input type="password" placeholder="비밀번호확인" id="pwChk" name="pwChk">
			<label id="pwChk_msg"></label><br>
			
            <label>이름</label>
            <input type="text" id="name" name="name">
            <label id="name_msg"></label><br>
			
			<label>이메일</label>
			<div class="email_input">
               <input type="text" id="femail" placeholder="" class="mailInput" name="femail">
               <span>@</span>
               <input type="text" id="lemail" placeholder="" class="mailInput" name="lemail">
               <select id="emailSelect">
                   <option value="none">선택해주세요</option>
                   <option value="naver.com">naver.com</option>
                   <option value="kakao.com">kakao.com</option>
                   <option value="gmail.com">gmail.com</option>
                   <option value="daum.net">daum.net</option>
                   <option value="self">직접 입력</option>
               </select>
			</div>
               <label id="email_msg"></label><br>
               <input type="hidden" name="email" id="email">
            <button type="submit">회원가입</button>
            <button type="button">돌아가기</button>
        </form>
    </div>
</section>

<script src="<c:url value='/resources/js/register.js'/>"></script>
<%@ include file="../includes/footer2.jsp" %>