$(document).ready(function() {
	invest_click();
});

function invest_click() {
	$("#invest_check").on('click', function() {
		invest_chk_ajax();
	});
}

function invest_chk_ajax() {
		$.ajax({
			type: "POST",
			url: "./MemberInvestcheck.mb",
			dataType: "json",
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			data: {},
			success: function(resultData, result, response) {
				if(resultData.mi_idx != -1 ) {
					location.href="./MemberInvestmentList.mb?mi_idx="+resultData.mi_idx;
				}else {
					alert("투자현황이 존재하지 않습니다. 기업에 투자해보세요");
					location.href="./ListAction.bd";
				}
			},
			error: function(request, status, error){
				console.log("request>>"+request);
				console.log("status>>"+status);
				console.log("error>>" +error);
			}
		});
}