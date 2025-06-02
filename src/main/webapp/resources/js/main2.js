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
    
    // 회원 로그인
	$("#member_modal_form").on("submit", function(e) {
		e.preventDefault(); // 기본 제출 막기
	    const username = $("#m_username").val().trim();
	    const password = $("#m_password").val().trim();
		
		$.ajax({
	        type: "POST",
	        url: ctx + "/member/loginUser",
	        contentType: "application/json",
	        data: JSON.stringify({
	            
	        	username: username,
	            password: password
	            
	        }),
	        success: function(rs) {
	            if (rs.success) {
					const redirectUrl = sessionStorage.getItem("dest") || "/";
	                sessionStorage.removeItem("dest");
	                
	                if (redirectUrl.startsWith(ctx)) {
					    window.location.href = redirectUrl;
					} else {
					    window.location.href = ctx + redirectUrl;
					}
	            } else {
	                alert(rs.message);
	                // 모달 유지, 입력값 초기화하지 않음
	            }
	        },
	        error: function(xhr, status, error) {
				alert("서버와의 통신 중 오류가 발생했습니다.");
			}
	    });
    });
    
    // 회원가입 기능
    // 아이디 검사
    $("#username").on("input", function () {
        const id = $(this).val().trim();
        const idRegex = /^[a-z0-9]{4,16}$/;
        const msg = $("#username_msg");

        if (id === "") {
            msg.text("아이디를 입력해주세요.").css("color", "red");
        } else if (!idRegex.test(id)) {
            msg.text("아이디는 4~16자의 영문 소문자와 숫자만 가능합니다.").css("color", "red");
        } else {
            msg.text("");
        }
    });
    
    // 아이디 중복검사
    let checkIdPassed = false;
    $("#username").on("blur", function(e) {
		e.preventDefault(); // 기본 제출 막기
		const id = $("#username").val().trim();
		const msg = $("#username_msg");
		
		if(id === "") {
			msg.text("아이디를 입력해주세요.").css("color", "red");
			return;
		}
		
		$.ajax({
			url: "/sky/member/existID",
			method: "GET",
			data: {username:id},
			success: function(rs) {
				if(rs === 1) {
					msg.text("이미 사용 중인 아이디입니다.").css("color", "red");
					checkIdPassed = false;
				} else {
					msg.text("사용 가능한 아이디입니다.").css("color", "green");
					checkIdPassed = true;
				}
			},
			error: function() {
				msg.text("서버 오류가 발생했습니다.").css("color", "red");
			}
		})
	});

    // 비밀번호 검사
    $("#password").on("input", function () {
        const pw = $(this).val().trim();
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
        const msg = $("#pw_msg");

        if (pw === "") {
            msg.text("비밀번호를 입력해주세요.").css("color", "red");
        } else if (!pwRegex.test(pw)) {
            msg.text("비밀번호는 영문, 숫자, 특수문자를 포함한 8~20자여야 합니다.").css("color", "red");
        } else {
            msg.text("");
        }
    });

    // 비밀번호 확인 검사
    $("#pwChk").on("input", function () {
        const pw = $("#password").val().trim();
        const pwChk = $(this).val().trim();
        const pwChkRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
        const msg = $("#pwChk_msg");

        if (pwChk === "") {
            msg.text("비밀번호 확인을 입력해주세요.").css("color", "red");
        } else if (pw !== pwChk) {
            msg.text("비밀번호가 일치하지 않습니다.").css("color", "red");
        } else if (!pwChkRegex.test(pwChk)) {
            msg.text("비밀번호는 영문, 숫자, 특수문자를 포함한 8~20자여야 합니다.").css("color", "red");
        } else {
            msg.text("");
        }
    });
    
    // 이름 확인
    $("#name").on("input", function() {
		const name = $(this).val().trim();
		const nameRegex = /^[가-힣a-zA-Z]{2,20}$/;
		const msg = $("#name_msg");
		
		if (name === "") {
			msg.text("이름을 입력해주세요.").css("color", "red");
		} else if (/\s/.test(name)) {
			// 공백이 하나라도 포함되어 있으면
			msg.text("이름에 공백을 포함할 수 없습니다.").css("color", "red");
		} else if (!nameRegex.test(name)) {
			msg.text("이름은 한글 또는 영문만 사용하며, 2~20자 이내여야 합니다.").css("color", "red");
		} else {
			msg.text("");
		}
	});
	
	//이메일 앞 주소
	$("#femail").on("input", function () {
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
	
	$("#lemail").on("input", function () {
    	const domain = $(this).val().trim();
    	const msg = $("#email_msg");
    	const domainRegex = /^[a-z0-9.-]+\.[a-z]{2,}$/;
    	const duplicateTldRegex = /\.(\w+)\.\1$/;

	    if ($("#emailSelect").val() === "self") {
	        if(domain === null || domain === "") {
				msg.text("이메일 주소를 입력해주세요.").css("color", "red");
			} else if (!domainRegex.test(domain)) {
	            msg.text("이메일 주소를 잘못 입력하셨습니다.").css("color", "red");
	        } else if (duplicateTldRegex.test(domain)) {
           		msg.text("도메인에 중복된 형식이 있습니다. 예: com.com").css("color", "red");
        	} else {
	            msg.text("");
	        }
	    }
	});
	
	let checkIdPassed = false;
    $("#username").on("blur", function(e) {
		e.preventDefault(); // 기본 제출 막기
		const id = $("#username").val().trim();
		const msg = $("#username_msg");
		
		if(id === "") {
			msg.text("아이디를 입력해주세요.").css("color", "red");
			return;
		}
		
		$.ajax({
			url: "/sky/member/existID",
			method: "GET",
			data: {username:id},
			success: function(rs) {
				if(rs === 1) {
					msg.text("이미 사용 중인 아이디입니다.").css("color", "red");
					checkIdPassed = false;
				} else {
					msg.text("사용 가능한 아이디입니다.").css("color", "green");
					checkIdPassed = true;
				}
			},
			error: function() {
				msg.text("서버 오류가 발생했습니다.").css("color", "red");
			}
		})
	});
	
	// 회원 이메일 중복 검사
	let checkEmailPassed = false;
    $("#femail").on("blur", function(e) {
		e.preventDefault();
		const femail = $("#femail").val().trim();
		const lemail = $("#lemail").val().trim();
		const emailSelect = $("#emailSelect").val();
        const fullEmail = femail + "@" + lemail
        const msg = $("#email_msg");
        const email = $("#email").val(fullEmail);
		
		if(email === "") {
			msg.text("아이디를 입력해주세요.").css("color", "red");
			return;
		}
		
		$.ajax({
			url: "/sky/member/existEmail",
			method: "GET",
			data: {email:fullEmail},
			success: function(rs) {
				if (rs === 1) {
					msg.text("이미 사용 중인 이메일입니다.").css("color", "red");
					checkEmailPassed = false;
				} else {
					msg.text("사용 가능한 이메일입니다.").css("color", "green");
					checkEmailPassed = true;
				}
			},
			error: function() {
				msg.text("서버 오류가 발생했습니다.").css("color", "red");
			}
		})
	});
	
	// 회원가입 유효성 검사 및 진행
	$("#reg_form").on("submit", function (e) {
		e.preventDefault();
		
        const id = $("#username").val().trim();
        const pw = $("#password").val().trim();
        const pwChk = $("#pwChk").val().trim();
        const name = $("#name").val().trim();
        const femail = $("#femail").val().trim();
        const lemail = $("#lemail").val().trim();
        const emailSelect = $("#emailSelect").val();
        const fullEmail = femail + "@" + lemail

        const idRegex = /^[a-z0-9]{4,16}$/;
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
        const nameRegex = /^[가-힣a-zA-Z]{2,20}$/;
        const emailIdRegex = /^[a-z0-9]{4,16}$/;
        const domainRegex = /^[a-z0-9.-]+\.[a-z]{2,}$/;

        if (id === "" || !idRegex.test(id)) {
            alert("아이디를 확인해주세요.");
            $("#username").focus();
            return false;
        }
        
        if (!checkIdPassed) {
			alert("아이디 중복 확인을 해주세요.");
			$("#username").focus();
			return false;
		}

        if (pw === "" || !pwRegex.test(pw)) {
            alert("비밀번호를 확인해주세요.");
            $("#password").focus();
            return false;
        }

        if (pwChk === "" || pwChk !== pw || !pwRegex.test(pwChk)) {
            alert("비밀번호 확인이 일치하지 않거나 형식이 잘못되었습니다.");
            $("#pwChk").focus();
            return false;
        }

        if (name === "" || !nameRegex.test(name)) {
            alert("이름을 확인해주세요.");
            $("#name").focus();
            return false;
        }

        if (femail === "" || !emailIdRegex.test(femail)) {
            alert("이메일 주소를 확인해주세요.");
            $("#femail").focus();
            return false;
        }

        if (emailSelect === "none") {
            alert("이메일 주소를 선택해주세요.");
            $("#emailSelect").focus();
            return false;
        }

        if (emailSelect === "self") {
            if (lemail === "" || !domainRegex.test(lemail)) {
                alert("이메일 주소를 올바르게 입력해주세요.");
                $("#lemail").focus();
                return false;
            }
        }
        
        $.ajax ({
			type: "POST",
			url: ctx + "/member/insertUser",
			contentType: "application/json",
			data: JSON.stringify({
				username: id,
				password: pw,
				name: name,
				email: fullEmail
			}),
			success: function(rs) {
				if(rs.success) {
					const redirectUrl = sessionStorage.getItem("dest") || "/";
					sessionStorage.removeItem("dest");
					if (redirectUrl.startsWith(ctx)) {
					    window.location.href = redirectUrl;
					} else {
					    window.location.href = ctx + redirectUrl;
					}
					alert(rs.message);
				} else {
					alert(rs.message);
				}
			}, 
			error: function(xhr, status, error) {
				alert("서버와의 통신 중 오류가 발생했습니다.");
			}
		});
    });
	
	
	
	// 비회원 이메일 앞 주소
	$("#g_femail").on("input", function () {
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
	
	// 비회원 이메일 뒷 주소
	const select = $("#g_emailSelect").val();
	const lemailed = $("#g_lemail");
	if(select === "none") {
		lemailed.val("");
		lemailed.prop("readonly", true);
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
	
	$("#g_lemail").on("input", function () {
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
	
	// 비회원 비밀번호 검사
    $("#g_password").on("input", function () {
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
    
    
    
    // 비회원 로그인 시 유효성 검사
    $("#guest_modal_form").on("submit", function(e) {
		e.preventDefault();
		const pw = $("#g_password").val().trim();
		const femail = $("#g_femail").val().trim();
		const lemail = $("#g_lemail").val().trim();
		const emailSelect = $("#g_emailSelect").val();
        const fullEmail = femail + "@" + lemail
        $("#g_email").val(fullEmail);
        
        const mode = $(this).data("mode");
        
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
		const emailIdRegex = /^[a-z0-9]{4,16}$/;
		const domainRegex = /^[a-z0-9.-]+\.[a-z]{2,}$/;
		
		if (pw === "" || !pwRegex.test(pw)) {
            alert("비밀번호를 확인해주세요.");
            $("#g_password").focus();
            return false;
        }
        
        if (femail === "" || !emailIdRegex.test(femail)) {
            alert("이메일 주소를 확인해주세요.");
            $("#g_femail").focus();
            return false;
        }

        if (emailSelect === "none") {
            alert("이메일 주소를 선택해주세요.");
            $("#g_emailSelect").focus();
            return false;
        }

        if (emailSelect === "self") {
            if (lemail === "" || !domainRegex.test(lemail)) {
                alert("이메일 주소를 올바르게 입력해주세요.");
                $("#g_lemail").focus();
                return false;
            }
        }
        //비회원 상담내역 로그인용
		if (mode === "login") {
			
			$.ajax({
	            type: "POST",
	            url: ctx + "/memeber/loginGuest",
	            contentType: "application/json",
	            data: JSON.stringify({
	                
	            	g_email: fullEmail,
	                g_password: pw
	                
	            }),
	            success: function(rs) {
	                if (rs.success) {
	                    window.location.href = ctx + rs.redirectUrl;
	                    alert(rs.message);
	                } else {
	                    alert(rs.message);
	                    // 모달 유지, 입력값 초기화하지 않음
	                }
	            },
	            error: function(xhr, status, error) {
					alert("서버와의 통신 중 오류가 발생했습니다.");
				}
	        });
		} else if (mode === "insert") {
			let checkEmailPassed = false;
		    $("#g_femail").on("blur", function(e) {
				e.preventDefault();
				const femail = $("#g_femail").val().trim();
				const lemail = $("#g_lemail").val().trim();
				const emailSelect = $("#g_emailSelect").val();
		        const fullEmail = femail + "@" + lemail
		        const msg = $("#email_msg");
				
				$.ajax({
					url: "/sky/member/existEmail",
					method: "GET",
					data: {email:fullEmail},
					success: function(rs) {
						if(rs === 1) {
							msg.text("이미 사용 중인 이메일입니다.").css("color", "red");
							checkEmailPassed = false;
						} else {
							msg.text("사용 가능한 이메일입니다.").css("color", "green");
							checkEmailPassed = true;
						}
					},
					error: function() {
						msg.text("서버 오류가 발생했습니다.").css("color", "red");
					}
				})
			});
			
			$.ajax({
	            type: "POST",
	            url: ctx + "/memeber/insertGuest",
	            contentType: "application/json",
	            data: JSON.stringify({
	                
	            	g_email: fullEmail,
	                g_password: pw
	                
	            }),
	            success: function(rs) {
	                if (rs.success) {
	                    window.location.href = ctx + rs.redirectUrl;
	                    alert(rs.message);
	                } else {
	                    alert(rs.message);
	                    // 모달 유지, 입력값 초기화하지 않음
	                }
	            },
	            error: function(xhr, status, error) {
					alert("서버와의 통신 중 오류가 발생했습니다.");
				}
	        });
			
			
			this.submit();
		}
	});
	
	// 모달 변화 기능 (비회원 로그인용)
	$("#writer_modal").on("click", function() {
		$("#guest_modal_form").data("mode", "insert");
	});
	$("#list_modal").on("click", function() {
		$("#guest_modal_form").data("mode", "login");
	});
    
	// 모달 기능 구현
	$(".modalShow").on("click", function() {
		$("#select_modal").modal("show");
		
		const dest = $(this).data("dest") || "/";
		
		sessionStorage.setItem("dest", dest);
	});
	
	$(".loginModal").on("click", function() {
		const currentUrl = window.location.pathname + window.location.search;
		
		sessionStorage.setItem("dest", currentUrl);
		
		$("#memberModal").modal("show");
		console.log("dest ====> " + currentUrl);
	});
	
	$(".regModal").on("click", function() {
		const currentUrl = window.location.pathname + window.location.search;
		
		sessionStorage.setItem("dest", currentUrl);
		
		$("#regModal").modal("show");
		
		$("#memberModal").modal("hide");
		console.log("dest ====> " + currentUrl);
	});
	
	$("#memberBtn").on('click', function(){
		$('#select_modal').modal('hide');
	});
	
	$('#guestBtn').on('click', function(){
		$('#select_modal').modal('hide');
	});
	
	$("#guestModal").on("show.bs.modal", function() {
	    // 이메일 관련 초기화
    	$('#g_femail').val('');
	    $('#g_lemail').val('');
	    $('#g_emailSelect').val('none');
	    $('#g_email').val('');
	    $('#g_email_msg').text('').css('color', '');

	    // 비밀번호 초기화
	    $('#g_password').val('');
	    $('#g_pw_msg').text('').css('color', '');
		});
		
	$('#regModal').on('show.bs.modal', function () {
        // 입력값 초기화
        $('#username').val('');
        $('#password').val('');
        $('#pwChk').val('');
        $('#name').val('');
        $('#femail').val('');
        $('#lemail').val('');
        $('#emailSelect').val('none');
        $('#email').val('');

        // 메시지 초기화 및 색상 제거
        $('#username_msg').text('').css('color', '');
        $('#pw_msg').text('').css('color', '');
        $('#pwChk_msg').text('').css('color', '');
        $('#name_msg').text('').css('color', '');
        $('#email_msg').text('').css('color', '');
    });
	
});