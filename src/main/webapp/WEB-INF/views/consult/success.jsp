<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header2.jsp" %>
<style>
  .conB {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 60vh;
    background-color: #f9fafb;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }

  .message-box {
    text-align: center;
    background: white;
    padding: 30px 40px;
    border-radius: 10px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.1);
    max-width: 400px;
    width: 90%;
  }

  .message-box h2 {
    color: #333;
    font-size: 1.8rem;
    margin-bottom: 10px;
  }

  .message-box p {
    color: #666;
    font-size: 1.1rem;
    margin-bottom: 25px;
  }

  /* 로딩 애니메이션 */
  .loader {
    margin: 0 auto;
    border: 5px solid #eee;
    border-top: 5px solid #3f51b5;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    animation: spin 1s linear infinite;
  }

  @keyframes spin {
    0% { transform: rotate(0deg);}
    100% { transform: rotate(360deg);}
  }
</style>

<script>
	window.onload = function() {
	    setTimeout(function() {
	        window.location.href = "/sky";  // 원하는 페이지로 리다이렉트
	    }, 2000);
	};
</script>

<section class="conA">
</section>


<section class="conB">
	<div class="message-box">
    <h2>등록이 완료되었습니다.</h2>
    <p>잠시 후 메인 페이지로 이동합니다.</p>
    <div class="loader"></div>
  </div>
</section>


<%@ include file="../includes/footer2.jsp" %>