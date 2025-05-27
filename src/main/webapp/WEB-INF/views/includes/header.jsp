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
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<!-- Self CSS -->
	<link href="${ctx}/resources/css/main.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                            <li><a href="#">상담문의</a></li>
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
					<li><a href="${ctx }/center/notice" class="hB-small">고객센터</a>
						<ul>
							<li><a href="${ctx }/center/notice">공지사항</a></li>
							<li><a href="#">자주하는 질문</a></li>
							<li><a href="#">커뮤니티</a></li>
							<li><a href="#">내 상담내역</a></li>
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
    </header>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>