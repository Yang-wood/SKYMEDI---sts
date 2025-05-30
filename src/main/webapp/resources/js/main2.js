$(document).ready(function() {
	
/*	//모바일 화면용 버튼 구현
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
	handleScroll();*/
	
	//이메일 앞 주소
	$("#g_femail").on("blur", function () {
	    const id = $(this).val().trim();
	    const idRegex = /^[a-z0-9]{4,16}$/;
	    const msg = $("#g_email_msg");
	
	    if (id === "") {
	        msg.text("이메일 주소를 입력해주세요.").css("color", "red");
	    } else if (!idRegex.test(id)) {
	        msg.text("이메일 주소는 4~16자의 영문 소문자와 숫자만 가능합니다.").css("color", "red");
	    } else {
	        msg.text("");
	    }
	});
	
	// 이메일 뒷 주소
	const selected = $("#g_emailSelect").val();
	const lemail = $("#g_lemail");
	if(selected === "none") {
		lemail.val("");
		lemail.prop("readonly", true);
	}
	$("#g_emailSelect").on("change", function() {
		const selected = $(this).val();
		const lemail = $("#g_lemail");
		
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
	
	$("#g_lemail").on("blur", function () {
    	const domain = $(this).val().trim();
    	const msg = $("#g_email_msg");
    	const domainRegex = /^[a-z0-9.-]+\.[a-z]{2,}$/;

	    if ($("#g_emailSelect").val() === "self") {
	        if(domain === null || domain === "") {
				msg.text("이메일 주소를 입력해주세요.").css("color", "red");
			} else if (!domainRegex.test(domain)) {
	            msg.text("이메일 주소를 잘못 입력하셨습니다.").css("color", "red");
	        } else {
	            msg.text("");
	        }
	    }
	});
	
	// 비밀번호 검사
    $("#g_password").on("blur", function () {
        const pw = $(this).val().trim();
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
        const msg = $("#g_pw_msg");

        if (pw === "") {
            msg.text("비밀번호를 입력해주세요.").css("color", "red");
        } else if (!pwRegex.test(pw)) {
            msg.text("비밀번호는 영문, 숫자, 특수문자를 포함한 8~20자여야 합니다.").css("color", "red");
        } else {
            msg.text("");
        }
    });
    
    $("#modal_form").on("submit", function(e) {
		const pw = $("#g_password").val().trim();
		const femail = $("#g_femail").val().trim();
		const lemail = $("#g_lemail").val().trim();
		const emailSelect = $("#g_emailSelect").val();
        const fullEmail = femail + "@" + lemail
        $("#g_email").val(fullEmail);
        
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
		const emailIdRegex = /^[a-z0-9]{4,16}$/;
		
		if (pw === "" || !pwRegex.test(pw)) {
            alert("비밀번호를 확인해주세요.");
            $("#g_password").focus();
            e.preventDefault();
            return false;
        }
        
        if (femail === "" || !emailIdRegex.test(femail)) {
            alert("이메일 주소를 확인해주세요.");
            $("#g_femail").focus();
            e.preventDefault();
            return false;
        }

        if (emailSelect === "none") {
            alert("이메일 주소를 선택해주세요.");
            $("#g_emailSelect").focus();
            e.preventDefault();
            return false;
        }

        if (emailSelect === "self") {
            if (lemail === "" || !domainRegex.test(lemail)) {
                alert("이메일 주소를 올바르게 입력해주세요.");
                $("#g_lemail").focus();
                e.preventDefault();
                return false;
            }
        }
	});
	
    
	// 모달 기능 구현
	let openModal2 = false;
	$(".modalShow").on("click", function() {
		$("#modal1").modal("show");
	});
	
	$('#guestBtn').on('click', function(){
		openModal2 = true;
		$('#modal1').modal('hide');
	});
	
	$("#modal1").on("hidden.bs.modal", function() {
	    document.activeElement.blur();
	    if (openModal2) {
			$('#modal2').modal('show');
			openModal2 = false;
		}
	});
	
	$(".close").on("click", function() {
		openModal2 = false;
		$("#modal2").modal("hide");
	})

});