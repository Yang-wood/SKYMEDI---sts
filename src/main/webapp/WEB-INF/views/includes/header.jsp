<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" 
       value="${pageContext.request.contextPath == '/' ? '' : pageContext.request.contextPath }"
       scope="application"/>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>하늘병원</title>

    <!-- Bootstrap Core CSS -->
    <link href="${ctx}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${ctx}/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="${ctx}/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="${ctx}/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${ctx}/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${ctx}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<!-- Self CSS -->
	<link href="${ctx}/resources/css/main.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
.modal-backdrop {
  z-index: 1040 !important;
}

.modal {
  z-index: 1050 !important;
}

.modal-content {
  z-index: 1060 !important;
}
</style>
</head>
<body>
    <header class="mainHeader">
        <div class="contain">
            <div class="contain-small">
                <a href="${ctx}" class="headA">하늘병원</a>
                <button type="button" class="allMenu" aria-label="전체 메뉴 열기">
					<span class="fa fa-bars" aria-hidden="true"></span>
				</button>
            </div>
            <nav class="headB">
				<ul>
					<li><a href="#" class="hB-small">병원소개</a>
                        <ul>
                            <li><a href="#">인사말</a></li>
                            <li><a href="#">의료진 소개</a></li>
                            <li><a href="#">병원 둘러보기</a></li>
                            <li><a href="#">오시는길</a></li>
                        </ul>
                    </li>
					<li><a href="#" class="hB-small">진료안내</a>
                        <ul>
                            <li><a href="#">진료현황</a></li>
                            <c:choose>
                    			<c:when test="${not empty sessionScope.login}">
                    				<li><a href="${ctx}/consult/writer">상담문의</a></li>
                    			</c:when>
                    			<c:otherwise>
                    				<li><a href="#" id="writerModal">상담문의</a></li>
                    			</c:otherwise>
                    		</c:choose>
                            <li><a href="#">예약안내</a></li>
                            <li><a href="#">비급여안내</a></li>
                        </ul>
                    </li>
					<li><a href="#" class="hB-small">건강일지</a>
                        <ul>
                            <li><a href="#">건강도우미</a></li>
                            <li><a href="#">혈당입력</a></li>
                            <li><a href="#">키/몸무게입력</a></li>
                            <li><a href="#">진료도우미</a></li>
                        </ul>
                    </li>
					<li><a href="${ctx}/center/notice" class="hB-small">고객센터</a>
						<ul>
							<li><a href="${ctx}/center/notice">공지사항</a></li>
							<li><a href="#">자주하는 질문</a></li>
							<li><a href="#">커뮤니티</a></li>
							<li><a href="${ctx}/consult/check">내 상담내역</a></li>
						</ul>
					</li>
				</ul>
			</nav>
            <nav class="headD">
                <ul>
                	<c:choose>
                		<c:when test="${not empty sessionScope.login}">
                			<!-- 로그인 상태 -->
                			<li><a href="${ctx}/member/logout">로그아웃</a></li>
	                    	<li><a href="#">마이페이지</a></li>
                		</c:when>
                		<c:otherwise>
	                		<!-- 로그아웃 상태 -->
	                		<li><a href="${ctx}/member/login">로그인</a></li>
	                    	<li><a href="${ctx}/member/register">회원가입</a></li>
                		</c:otherwise>
                	</c:choose>
                </ul>
            </nav>
        </div>
        <!-- 로그아웃 메세지 -->
        <c:if test="${not empty logoutMsg}">
        	<script>
		        alert('${logoutMsg}');
		    </script>
		</c:if>
</header>
<div class="modal fade" id="modal1" 
 	data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" 
 	aria-labelledby="modallabel" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content" style="z-index: 1050;">
			<div class="modal-header">
      				<button type="button" class="close" data-dismiss="modal">&times;</button>
      				<h4 class="modal-title" id="modallabel">로그인 방식을 선택하세요</h4>
			</div>
			<div class="modal-body">
				<a class="btn btn-primary" href="${ctx}/member/login" role="button">회원</a>
				<button class="btn btn-primary" id="guestBtn" data-dismiss="modal" data-toggle="modal" data-target="#modal2">비회원</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="modal2" aria-hidden="true" 
	data-backdrop="static" data-keyboard="false"
	aria-labelledby="modallabel2" tabindex="-1" role="dialog">
	<div class="modal-dialog" style="margin-top: 100px;">
		<div class="modal-content">
		<form action="${ctx}/guest/loginPost" method="post">
			<div class="modal-header">
				<h1 class="modal-title" id="modallabel2">비회원 로그인</h1>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="email" class="control-label">이메일</label>
        						<div class="form-inline">
	         						<input type="text" class="form-control" id="femail" name="femail" style="width: 30%;">
	         						<span>@</span>
					        		<input type="text" class="form-control" id="lemail" name="lemail" style="width: 30%;">
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
			        <input type="hidden" name="g_email" id="email">
				</div>
				<div class="form-group">
					<label for="g_pw" class="control-label">비밀번호</label>
        						<input type="password" class="form-control" id="g_pw" name="g_password">
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				<button type="submit" class="btn btn-primary" id="gusetloginBtn">로그인</button>
			</div>
		</form>
		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	//모바일 화면용 버튼 구현
	$(".allMenu").click(function(){
		const headB = $(".headB");
		const headD = $(".headD");

		if (headB.is(":visible")) {
			headB.stop(true, true).slideUp(300);
			headD.stop(true, true).fadeIn(200);
		} else {
			headB.stop(true, true).slideDown(300);
			headD.stop(true, true).fadeOut(200);
		}
	});
	
	// 스크롤 시 헤더 처리
	function handleScroll() {
		const header = $(".mainHeader");
		const headB = $(".headB");
		const headD = $(".headD");

		if ($(window).scrollTop() > 10) {
			header.addClass("scrolled");
			setTimeout(function() {
				header.removeClass("scrolled");
			}, 1000);
		} else {
			header.removeClass("scrolled");
		}

		// 스크롤 시 메뉴 닫기 (모바일)
		if (window.innerWidth <= 968 && headB.is(":visible")) {
			headB.stop(true, true).slideUp(500);
			headD.stop(true, true).fadeIn(500);
		}
	}
	
	$(window).on("scroll", handleScroll);
	
	$(window).on('resize', function(){
		checkAllMenuVisible();
	});
	checkAllMenuVisible();
	handleScroll();
	
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
	
	// 모달 기능 구현
	$("#writerModal").on("click", function() {
		targetUrl = $(this).data("target-url");
		$("#modal1").modal("show");
	});
	
	$('#guestBtn').on('click', function(){
	    $('#modal1').modal('hide');
	});
	
	$("#modal1").on("hidden.bs.modal", function() {
	    $('#modal2').modal('show');
	});
});
</script>
