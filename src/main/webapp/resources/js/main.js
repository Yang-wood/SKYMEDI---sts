/**
 * 
 */
 
 function checkAllMenuVisible() {
	const headB = $(".headB");
	const headD = $(".headD");

	if (window.innerWidth > 968) {
		headB.slideUp(300);
		headD.fadeIn(200);
	}
}

function changeLogin(loginstate) {
	if (loginstate) {
		$(".headD").html(`
            <ul>
				<li><a href="logout.html">로그아웃</a></li>
                <li><a href="mypage.html">마이페이지</a></li>
            </ul>
        `);
	} else {
		$(".headD").html(`
            <ul>
                <li><a href="login.html">로그인</a></li>
                <li><a href="signup.html">회원가입</a></li>
            </ul>
        `);
	}
}

$(document).ready(function(){
	
	//모바일 화면용 버튼 구현
	$(".allMenu").click(function(){
		const headB = $(".headB");
		const headD = $(".headD");

		if (headB.is(":visible")) {
			headB.slideUp(300);
			headD.fadeIn(200);
		} else {
			headB.slideDown(300);
			headD.fadeOut(200);
		}
	});
	
	$(window).on('scroll', function() {
		const header = $(".mainHeader");
		const headB = $(".headB");
		const headD = $(".headD");

		if ($(window).scrollTop() > 10) {
			header.addClass("scrolled");
			setTimeout(function () {
				header.removeClass("scrolled");
			}, 1000);
		} else {
			header.removeClass("scrolled");
		}
		headB.slideUp(300);
		headD.fadeIn(200);
	});

	$(window).on('resize', function(){
		checkAllMenuVisible();
	});
	checkAllMenuVisible();
});

