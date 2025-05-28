/**
 * 
 */



function checkAllMenuVisible() {
	const headB = $(".headB");
	const headD = $(".headD");

	if (window.innerWidth > 968) {
		headB.stop(true, true).slideUp(0);
		headD.stop(true, true).fadeIn(0);
	}
}

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
});

