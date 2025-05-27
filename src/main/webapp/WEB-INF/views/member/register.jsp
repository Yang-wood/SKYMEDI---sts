<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>

<section class="conA">
    <h1>회원가입</h1>
</section>

<section class="conB">
    <div class="register-container">
        <h2>하늘병원 회원가입</h2>
        <form action="${ctx}/member/register" method="post">
            <label>아이디</label>
            <input type="text" placeholder="아이디" id="username" name="username">
            <button type="button" id="checkIdBtn">중복확인</button>
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
               <input type="text" id="femail" placeholder="이메일 아이디" name="femail">
               <span>@</span>
               <input type="text" id="lemail" placeholder="도메인" name="lemail">
               <select id="emailSelect">
                   <option value="">선택해주세요</option>
                   <option value="naver.com">naver.com</option>
                   <option value="kakao.com">kakao.com</option>
                   <option value="gmail.com">gmail.com</option>
                   <option value="daum.net">daum.net</option>
                   <option value="self">직접 입력</option>
               </select>
               <label id="email_msg"></label><br>
               <input type="hidden" name="email" id="email">
            <button type="submit">회원가입</button>
            <button type="button">돌아가기</button>
        </form>
    </div>
</section>

<script src="<c:url value='/resources/js/register.js'/>"></script>
<%@ include file="../includes/footer.jsp" %>