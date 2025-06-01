$(document).ready(function() {
	$("form").on("submit", function(e) {
		e.preventDefault();
		const title =  $("#title").val().trim();
		const content = $("#content").val().trim();
		
		if(title === "" || title === null) {
			alert("제목을 입력해 주세요");
            $("#title").focus();
            return false;
		}
		
		if(content === "" || content === null) {
			alert("내용을 입력해 주세요");
            $("#content").focus();
            return false;
		}
		
		this.submit();
	});
});

