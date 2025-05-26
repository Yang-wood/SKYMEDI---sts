window.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");

    const femail = document.getElementById("femail");
    const lemail = document.getElementById("lemail");
    const emailField = document.getElementById("email");
    const emailSelect = document.getElementById("emailSelect");

    const password = document.getElementById("password");
    const pwChk = document.getElementById("pwChk");

    // 이메일 선택 시 자동 입력
    emailSelect.addEventListener("change", function () {
        const selected = emailSelect.value;
        if (selected !== "self") {
            lemail.value = selected;
            lemail.readOnly = true;
        } else {
            lemail.value = "";
            lemail.readOnly = false;
        }
    });

    form.addEventListener("submit", function (e) {
        // 이메일 합치기
        if (femail.value && lemail.value) {
            emailField.value = femail.value.trim() + "@" + lemail.value.trim();
        } else {
            alert("이메일을 모두 입력하세요.");
            e.preventDefault();
            return;
        }

        // 비밀번호 일치 확인
        if (password.value !== pwChk.value) {
            alert("비밀번호가 일치하지 않습니다.");
            e.preventDefault();
            return;
        }
    });

    console.log("register.js loaded ✅");
});

$(document).ready(function() { 
	
	$("#username").on("blur", function() {
		const id = $(this).val().trim();
		const idRegex = /^[a-z0-9]{4,12}$/;
		
		if (id === '' || id === null) {
            $('#username_msg').text('아이디를 입력해주세요.').css('color', 'red');
        } else if (!idRegex.test(id)) {
            $('#username_msg').text('아이디는 4~12자의 영문 소문자와 숫자만 가능합니다.').css('color', 'red');
        } else {
            $('#username_msg').text('사용 가능한 아이디입니다.').css('color', 'green');
        }
	});
	
});

