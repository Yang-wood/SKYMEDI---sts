$(document).ready(function () {

    // 아이디 검사
    $("#username").on("blur", function () {
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
    
    // 아이디 중복버튼
    $("#checkIdBtn").on("click", function(e) {
		const id = $("#username").val().trim();
		const msg = $("#username_msg");
		
		if(id === null || id === "") {
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
				} else {
					msg.text("사용 가능한 아이디입니다.").css("color", "green");
				}
			},
			error: function() {
				msg.text("서버 오류가 발생했습니다.").css("color", "red");
			}
		})
	});

    // 비밀번호 검사
    $("#password").on("blur", function () {
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
    $("#pwChk").on("blur", function () {
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
    
    $("#name").on("blur", function() {
		const name = $(this).val().trim();
		const nameRegex = /^[가-힣a-zA-Z]{2,20}$/;
		const msg = $("#name_msg");
		
		if(name === null || name === "") {
			msg.text("이름을 입력해주세요.").css("color", "red");
		} else if(!nameRegex.test(name)) {
			msg.text("이름은 한글 또는 영문만 사용하며, 2~20자 이내여야 합니다.").css("color", "red");
		} else {
        	msg.text("");
   		}
	});
	
	// 이메일 앞 주소
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
	$("form").on("submit", function (e) {
        const id = $("#username").val().trim();
        const pw = $("#password").val().trim();
        const pwChk = $("#pwChk").val().trim();
        const name = $("#name").val().trim();
        const femail = $("#femail").val().trim();
        const lemail = $("#lemail").val().trim();
        const emailSelect = $("#emailSelect").val();

        const idRegex = /^[a-z0-9]{4,16}$/;
        const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,20}$/;
        const nameRegex = /^[가-힣a-zA-Z]{2,20}$/;
        const emailIdRegex = /^[a-z0-9]{4,16}$/;
        const domainRegex = /^[a-z0-9.-]+\.[a-z]{2,}$/;

        if (id === "" || !idRegex.test(id)) {
            alert("아이디를 확인해주세요.");
            $("#username").focus();
            e.preventDefault();
            return false;
        }

        if (pw === "" || !pwRegex.test(pw)) {
            alert("비밀번호를 확인해주세요.");
            $("#password").focus();
            e.preventDefault();
            return false;
        }

        if (pwChk === "" || pwChk !== pw || !pwRegex.test(pwChk)) {
            alert("비밀번호 확인이 일치하지 않거나 형식이 잘못되었습니다.");
            $("#pwChk").focus();
            e.preventDefault();
            return false;
        }

        if (name === "" || !nameRegex.test(name)) {
            alert("이름을 확인해주세요.");
            $("#name").focus();
            e.preventDefault();
            return false;
        }

        if (femail === "" || !emailIdRegex.test(femail)) {
            alert("이메일 주소를 확인해주세요.");
            $("#femail").focus();
            e.preventDefault();
            return false;
        }

        if (emailSelect === "none") {
            alert("이메일 주소를 선택해주세요.");
            $("#emailSelect").focus();
            e.preventDefault();
            return false;
        }

        if (emailSelect === "self") {
            if (lemail === "" || !domainRegex.test(lemail)) {
                alert("이메일 주소를 올바르게 입력해주세요.");
                $("#lemail").focus();
                e.preventDefault();
                return false;
            }
        }
        // 최종 이메일 hidden에 입력
        $("#email").val(femail + "@" + lemail);
    });
});

