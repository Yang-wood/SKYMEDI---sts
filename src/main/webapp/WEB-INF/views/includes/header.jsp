<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="/resources/js/main.js"></script>
</head>
<body>
    <header class="mainHeader">
        <div class="contain">
            <div class="contain-small">
                <a href="main.jsp" class="headA">하늘병원</a>
                <button type="button" class="allMenu" aria-label="전체 메뉴 열기">
					<span class="fa fa-bars" aria-hidden="true"></span>
				</button>
            </div>
            <nav class="headB">
				<ul>
					<li><a href="./hospital-info/welcome.html" class="hB-small">병원소개</a>
                        <ul>
                            <li><a href="./hospital-info/welcome.html">인사말</a></li>
                            <li><a href="./hospital-info/doctors.html">의료진 소개</a></li>
                            <li><a href="./hospital-info/hopital.html">병원 둘러보기</a></li>
                            <li><a href="./hospital-info/map.html">오시는길</a></li>
                        </ul>
                    </li>
					<li><a href="./medi-info/medical-status.html" class="hB-small">진료안내</a>
                        <ul>
                            <li><a href="./medi-info/medical-status.html">진료현황</a></li>
                            <li><a href="./medi-info/consulting.html">상담문의</a></li>
                            <li><a href="./medi-info/reservation.html">예약안내</a></li>
                            <li><a href="./medi-info/non-insurance.html">비급여안내</a></li>
                        </ul>
                    </li>
					<li><a href="./health-log/input.html" class="hB-small">건강일지</a>
                        <ul>
                            <li><a href="./health-log/input.html">진단 입력하기</a></li>
                            <li><a href="./health-log/bst.html">혈당입력</a></li>
                            <li><a href="./health-log/bmi.html">키/몸무게입력</a></li>
                            <li><a href="./health-log/agree.html">조회 허락하기</a></li>
                        </ul>
                    </li>
					<li><a href="./information/practice.html" class="hB-small">고객센터</a>
						<ul>
							<li><a href="./information/practice.html">공지사항</a></li>
							<li><a href="./information/faq.html">자주하는 질문</a></li>
							<li><a href="./information/feedback.html">칭찬합니다</a></li>
							<li><a href="./information/complain.html">불편사항</a></li>
						</ul>
					</li>
				</ul>
			</nav>
            <nav class="headD">
                <ul>
                    <li><a href="./sign/signin.html">로그인</a></li>
                    <li><a href="./sign/signup.html">회원가입</a></li>
                </ul>
            </nav>
        </div>
    </header>