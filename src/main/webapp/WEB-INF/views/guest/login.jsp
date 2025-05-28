<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" 
       value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }" 
       scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	//이메일 앞 주소
	$("#femail").on("blur", function () {
	    const id = $(this).val().trim();
	    const idRegex = /^[a-z0-9]{4,16}$/;
	    const msg = $("#email_msg");
	
	    if (id === "") {
	        msg.text("이메일 주소를 입력해주세요.").css("color", "red");
	    } else if (!idRegex.test(id)) {
	        msg.text("이메일 주소는 4~16자의 영문 소문자와 숫자만 가능합니다.").css("color", "red");
	    } else {
	        msg.text("");
	    }
	});
	
	// 이메일 뒷 주소
	const selected = $("#emailSelect").val();
	const lemail = $("#lemail");
	if(selected === "none") {
		lemail.val("");
		lemail.prop("readonly", true);
	}
	$("#emailSelect").on("change", function() {
		const selected = $(this).val();
		const lemail = $("#lemail");
		
		if (selected === "none") {
	    	lemail.val("");
	    	lemail.prop("readonly", true);
		} else if (selected === "self") {
	    	lemail.val("");
	    	lemail.prop("readonly", false);
		} else {
	    	lemail.val(selected);
	    	lemail.prop("readonly", true);
		}
	});
	$("form").on("submit", function() {
		// 최종 이메일 hidden에 입력
		const femail = $("#femail").val().trim();
        const lemail = $("#lemail").val().trim();
        const emailSelect = $("#emailSelect").val();
	    $("#email").val(femail + "@" + lemail);
	});
});
</script>

</head>
<body>
    <form action="${ctx}/guest/login" method="post">
        <label>이메일</label>
               <input type="text" id="femail" placeholder="" name="femail">
               <span>@</span>
               <input type="text" id="lemail" placeholder="" name="lemail">
               <select id="emailSelect">
                   <option value="none">선택해주세요</option>
                   <option value="naver.com">naver.com</option>
                   <option value="kakao.com">kakao.com</option>
                   <option value="gmail.com">gmail.com</option>
                   <option value="daum.net">daum.net</option>
                   <option value="self">직접 입력</option>
               </select>
               <label id="email_msg"></label><br>
               <input type="hidden" name="g_email" id="email">
        <label>비밀번호</label>
        <input type="password" name="g_password"><br><br>

        <button type="submit">등록</button>
    </form>
</body>
</html>
