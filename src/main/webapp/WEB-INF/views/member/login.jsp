<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../includes/header.jsp" %>
<style>
.login-container {
    background: #fff;
    padding: 50px 40px;
    border-radius: 16px;
    box-shadow: 0 4px 20px rgba(0,0,0,0.1);
    width: 450px;
    max-width: 100%;
}

.login-container h2 {
    text-align: center;
    margin-bottom: 30px;
    font-size: 24px;
}

.login-container input[type="text"],
.login-container input[type="password"] {
    width: 100%;
    padding: 14px;
    margin: 12px 0;
    border: 1px solid #ccc;
    border-radius: 10px;
    font-size: 16px;
}

.login-container button {
    width: 100%;
    padding: 14px;
    background: #3498db;
    color: #fff;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    font-size: 18px;
    margin-top: 10px;
}

.login-container button:hover {
    background: #2980b9;
}

.login-container .extra-links {
    margin-top: 20px;
    text-align: center;
}

.login-container .extra-links a {
    color: #666;
    font-size: 15px;
    text-decoration: none;
    margin: 0 8px;
}

/* ✅ 모바일 반응형 스타일 */
@media (max-width: 576px) {
    .login-container {
        width: 90%;
        padding: 30px 20px;
    }

    .login-container h2 {
        font-size: 20px;
    }

    .login-container input[type="text"],
    .login-container input[type="password"] {
        font-size: 14px;
        padding: 12px;
    }

    .login-container button {
        font-size: 16px;
        padding: 12px;
    }

    .login-container .extra-links a {
        font-size: 13px;
    }
}
</style>


<section class="conA">
        <h1>로그인</h1>
</section>
<section class="conB">
    <div class="login-container">
        <h2>하늘병원 로그인</h2>
        <form action="/login" method="post">
            <input type="text" name="username" placeholder="아이디">
            <input type="password" name="password" placeholder="비밀번호">
            <button type="submit">로그인</button>
        </form>
        <div class="extra-links">
            <a href="#">아이디 찾기</a> |
            <a href="#">비밀번호 찾기</a> |
            <a href="<c:url value='/member/register' />">회원가입</a>
        </div>
    </div>
</section>

<%@ include file="../includes/footer.jsp"  %>