/**
 * 
 */
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
	
	$("#lemail").on("blur", function () {
    	const domain = $(this).val().trim();
    	const msg = $("#email_msg");
    	const domainRegex = /^[a-z0-9.-]+\.[a-z]{2,}$/;

	    if ($("#emailSelect").val() === "self") {
	        if(domain === null || domain === "") {
				msg.text("이메일 주소를 입력해주세요.").css("color", "red");
			} else if (!domainRegex.test(domain)) {
	            msg.text("이메일 주소를 잘못 입력하셨습니다.").css("color", "red");
	        } else {
	            msg.text("");
	        }
	    }
	});
	
	$("#modal_form").on("submit", function() {
		// 최종 이메일 hidden에 입력
		const femail = $("#femail").val().trim();
        const lemail = $("#lemail").val().trim();
        const emailSelect = $("#emailSelect").val();
	    $("#email").val(femail + "@" + lemail);
	});
	
	
	
	// 모달 기능 구현
	$("#modalShow").on("click", function() {
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

