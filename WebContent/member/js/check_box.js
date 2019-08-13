var f = document.join_form;
$(document).ready(function(){
	$("#ag3").val("0");
	$("#ag4").val("0");
	
	$("#ag3").click(function() {
		if ($("#ag3").is(":checked")) {
			$("#ag3").val("1");
		} else {
			$("#ag3").val("0");
		}
	});
	$("#ag4").click(function() {
		if ($("#ag4").is(":checked")) {
			$("#ag4").val("1");
		} else {
			$("#ag4").val("0");
		}
	});
});