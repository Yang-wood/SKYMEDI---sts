$(document).ready(function() {
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
	$("form").on("submit", function() {
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
		openModal2 = true;
		$('#modal1').modal('hide');
	});
	
	$("#modal1").on("hidden.bs.modal", function() {
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