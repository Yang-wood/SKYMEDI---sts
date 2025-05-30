<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp" %>

<link href="${ctx}/resources/css/login.css" rel="stylesheet">

<section class="conA">
</section>
<section class="conB">
    <div class="login-container">
        <h2>하늘병원 로그인</h2>
        <form action="${ctx}/member/login" method="post">
            <input type="text" name="username" placeholder="아이디">
            <input type="password" name="password" placeholder="비밀번호">
            <button type="submit">로그인</button>
        </form>
        <div class="extra-links">
            <a href="#">아이디 찾기</a> |
            <a href="#">비밀번호 찾기</a> |
            <a href="${ctx }/member/register">회원가입</a>
        </div>
    </div>
</section>

<c:if test="${not empty errorMsg}">
    <script>
        alert('${errorMsg}');
    </script>
</c:if>

<script>
	window.addEventListener('pageshow', function(event) {
	  if (event.persisted) {
	    window.location.reload();
	  }
	});
</script>
<%@ include file="../includes/footer2.jsp"  %>