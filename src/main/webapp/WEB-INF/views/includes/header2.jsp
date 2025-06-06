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
	<link href="${ctx}/resources/css/main3.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	<!-- Bootstrap CSS -->
  	<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous"> -->
  	<link rel="stylesheet" href="${ctx}/resources/css/main3.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script type="text/javascript">
  		const ctx = "${ctx}";
  	</script>
  	<script src="${ctx}/resources/js/main2.js"></script>
</head>
<body>
    <header class="mainHeader">
        <nav class="main-header">
            <div class="headA">
                <a href="${ctx}">하늘병원</a>
            </div>
            <div class="headB">
                <ul>
                	<c:choose>
                		<c:when test="${not empty sessionScope.login}">
                			<!-- 회원 로그인 상태 -->
                			<li><a href="${ctx}/member/logout">로그아웃</a></li>
	                    	<li><a href="#">마이페이지</a></li>
                		</c:when>
                		
                		<c:when test="${empty sessionScope.login and not empty sessionScope.guestInfo}">
                			<!-- 비회원 로그인 상태 -->
                			<li><a href="${ctx}/member/logout">로그아웃(비회원)</a></li>
	                    	<li><a href="#" class="regModal">회원가입</a></li>
                		</c:when>
                		<c:otherwise>
	                		<!-- 로그아웃 상태 -->
	                		<li><a href="#" class="loginModal">로그인</a></li>
	                    	<li><a href="#" class="regModal">회원가입</a></li>
                		</c:otherwise>
                	</c:choose>
                </ul>
            </div>
 		</nav>
		<nav class="sub-header">
			<div>
				<a href="#" class="hB-small">병원소개</a>
				<ul>
	                <li><a href="#">인사말</a></li>
	                <li><a href="#">의료진 소개</a></li>
	                <li><a href="#">병원 둘러보기</a></li>
	                <li><a href="#">오시는길</a></li>
	            </ul>
			</div>
			<div>
				<a href="#" class="hB-small">진료안내</a>
				<ul>
                    <li><a href="#">진료현황</a></li>
                    <c:choose>
                    	<c:when test="${not empty sessionScope.login}">
                    		<li><a href="${ctx}/consult/writer">상담문의</a></li>
                    	</c:when>
                    	<c:when test="${empty sessionScope.login and not empty sessionScope.guestInfo}">
                			<li><a href="${ctx}/consult/writer">상담문의</a></li>
                		</c:when>
                    	<c:otherwise>
                    		<li><a href="#" id="writer_modal" class="modalShow" data-dest="${ctx}/consult/writer">상담문의</a></li>
                    	</c:otherwise>
                    </c:choose>
                    <li><a href="#">예약안내</a></li>
                    <li><a href="#">비급여안내</a></li>
                </ul>
			</div>
			<div>
				<a href="#" class="hB-small">건강일지</a>
				<ul>
	                <li><a href="#">건강도우미</a></li>
	                <li><a href="#">혈당입력</a></li>
	                <li><a href="#">키/몸무게입력</a></li>
	                <li><a href="#">진료도우미</a></li>
	            </ul>
			</div>
			<div>
				<a href="${ctx}/center/notice" class="hB-small">고객센터</a>
				<ul>
					<li><a href="${ctx}/center/notice">공지사항</a></li>
					<li><a href="#">자주하는 질문</a></li>
					<li><a href="#">커뮤니티</a></li>
					<c:choose>
                    	<c:when test="${not empty sessionScope.login}">
                    		<li><a href="${ctx}/consult/list">내 상담내역</a></li>
                    	</c:when>
                    	<c:when test="${empty sessionScope.login and not empty sessionScope.guestInfo}">
                			<li><a href="${ctx}/consult/list">내 상담내역</a></li>
                		</c:when>
                    	<c:otherwise>
                    		<li><a href="#" id="list_modal" class="modalShow" data-dest="${ctx}/consult/list">내 상담내역</a></li>
                    	</c:otherwise>
                    </c:choose>
				</ul>
			</div>
		</nav>
        <button type="button" class="allMenu" aria-label="전체 메뉴 열기">
					<span class="fa fa-bars"></span>
		</button>
        <!-- 로그아웃 메세지 -->
        <c:if test="${not empty logoutMsg}">
        	<script>
		        alert('${logoutMsg}');
		    </script>
		</c:if>
		
	</header>

<!-- 로그인 선택 모달 start -->
<div class="modal fade" id="select_modal" 
 	data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" 
 	aria-labelledby="modallabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
      				<button type="button" class="close" data-dismiss="modal">&times;</button>
      				<h4 class="modal-title" id="modallabel">로그인 방식을 선택하세요</h4>
			</div>
			<div class="modal-body text-center">
				<button class="btn btn-primary" id="memberBtn" data-dismiss="modal" data-toggle="modal" data-target="#memberModal">회원</button>
				<button class="btn btn-primary" id="guestBtn" data-dismiss="modal" data-toggle="modal" data-target="#guestModal">비회원</button>
			</div>
		</div>
	</div>
</div><!-- 로그인 선택 모달 end -->

<!-- 회원 로그인 모달 start -->
<div class="modal fade" id="memberModal"
	data-backdrop="static" data-keyboard="false"
	aria-labelledby="modallabel2" tabindex="-1" role="dialog">
	<div class="modal-dialog" style="margin-top: 100px;">
		<div class="login-container">
        	<div class="modal-header header-radius">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h1 class="modal-title" id="modallabel2">로그인</h1>
			</div>
	        <form action="${ctx}/member/loginUser" id="member_modal_form" method="post">
	            <input type="text" name="username" id=m_username placeholder="아이디">
	            <input type="password" name="password" id="m_password" placeholder="비밀번호">
	            <button type="submit" class="login">로그인</button>
	        </form>
	        <div class="extra-links">
	            <a href="#">아이디 찾기</a> |
	            <a href="#">비밀번호 찾기</a> |
	            <a href="#" class="regModal">회원가입</a>
	        </div>
    	</div>
	</div>
</div><!-- 회원 로그인 모달 end -->

<!-- 비회원 로그인 모달 start -->
<div class="modal fade" id="guestModal"
	data-backdrop="static" data-keyboard="false"
	aria-labelledby="modallabel2" tabindex="-1" role="dialog">
	<div class="modal-dialog" style="margin-top: 100px;">
		<div class="login-container">
			<div class="modal-header header-radius">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h1 class="modal-title" id="modallabel2">비회원 로그인</h1>
			</div>
			<form id="guest_modal_form" action="${ctx }/member/" method="post">
			<div class="modal-body">
				<div class="form-group">
					<label for="email" class="control-label">이메일</label>
        						<div class="form-inline">
	         						<input type="text" class="form-control" id="g_femail" name="femail" style="width: 30%;">
	         						<span>@</span>
					        		<input type="text" class="form-control" id="g_lemail" name="lemail" style="width: 30%;">
					               <select id="g_emailSelect">
					                   <option value="none">선택해주세요</option>
					                   <option value="naver.com">naver.com</option>
					                   <option value="kakao.com">kakao.com</option>
					                   <option value="gmail.com">gmail.com</option>
					                   <option value="daum.net">daum.net</option>
					                   <option value="self">직접 입력</option>
					               </select>
        						</div>
			        <label id="g_email_msg"></label><br>
			        <input type="hidden" name="g_email" id="g_email">
				</div>
				<div class="form-group">
					<label for="g_pw" class="control-label">비밀번호</label>
    				<input type="password" class="form-control" id="g_password" name="g_password">
    				<label id="g_pw_msg"></label>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary" id="gusetloginBtn">로그인</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</form>
		</div>
	</div>
</div><!-- 비회원 로그인 모달 end -->

<!-- 회원가입 모달 start -->
<div class="modal fade" id="regModal"
	data-backdrop="static" data-keyboard="false"
	aria-labelledby="modallabel3" tabindex="-1" role="dialog">
	<div class="modal-dialog" style="margin-top: 100px;">
		<div class="register-container">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h1 class="modal-title" id="modallabel2">회원가입</h1>
			</div>
	        <form id="reg_form" action="${ctx}/member/insertUser" method="post" autocomplete="off">
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
	               <input type="text" id="femail" name="femail">
	               <span>@</span>
	               <input type="text" id="lemail" name="lemail">
	               <select id="emailSelect">
	                   <option value="none">선택해주세요</option>
	                   <option value="naver.com">naver.com</option>
	                   <option value="kakao.com">kakao.com</option>
	                   <option value="gmail.com">gmail.com</option>
	                   <option value="daum.net">daum.net</option>
	                   <option value="self">직접 입력</option>
	               </select>
				</div>
	               <label id="email_msg"></label>
	               <input type="hidden" name="email" id="email">
	            <div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="regBtn">회원가입</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				</div>
	        </form>
	    </div>
	</div>
</div>

