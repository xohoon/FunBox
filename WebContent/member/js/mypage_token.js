/////////////// 태훈 추가 //////////////////////////
var token_sum = null;
var token_wallet = null;
var token_hash = null;
var bar = null;
var session_idx = null;

$(document).ready(function() {
	token_deposit_btn();
	token_withdraw_btn();
});

// 토큰 입금신청 
function token_deposit_btn() {
	$("#button_deposit").on('click', function() {
		token_sum = $("#sumcomma1").text();
		token_wallet = $("#token_wallet").val();
		token_hash = $("#token_hash").val();
		bar = $("#bar").val();
		session_idx = $("#session_idx").val();
		if(token_sum != 0 && token_wallet != null 
				&& token_hash != null && session_idx != null) {
			token_depositAjax();
		}else {
			console.log("token_sum:::"+token_sum);
			console.log("token_wallet:::"+token_wallet);
			console.log("token_hash:::"+token_hash);
			console.log("bar:::"+bar);
			alert("정보를 입력해주세요");
		}
	});
}

//토큰 입금신청 ajax
function token_depositAjax() {
	console.log("token_sum:::"+token_sum);
	console.log("token_wallet:::"+token_wallet);
	console.log("token_hash:::"+token_hash);
	console.log("bar:::"+bar);
	$.ajax({
		type: "POST",
		dataType: "JSON",
		url: "./TokenDepositAction.mb",
		data: {
			"token_sum": token_sum,
			"token_wallet": token_wallet,
			"token_hash": token_hash,
			"bar": bar,
			"session_idx": session_idx
		},
		success: function(data) {
			if(data.result == 1) {
				alert("입금신청이 완료되었습니다.");
				location.href="./MypageDeposit.mb";
			}else {
				alert("입금 내용을 정확히 입력해주세요11");
				location.href="./MypageDeposit.mb";
			}
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
			alert("입금 내용을 정확히 입력해주세요22");
			location.href="./MypageDeposit.mb";
		}
	});
}

// 토큰 출금신청
function token_withdraw_btn() {
	$('.send_btn').on('click', function() {
		bar = $("#bar").val();
		token_wallet = $("#tk_to_address").val();
		token_sum = $("#sumcomma2").text();
		session_idx = $("#session_idx").val();
		if(token_sum != 0 && token_wallet != null 
				&& session_idx != null) {
			token_withdrawAjax();
		}else {
			console.log("token_sum:::"+token_sum);
			console.log("token_wallet:::"+token_wallet);
			console.log("bar:::"+bar);
			alert("정보를 입력해주세요");
		}
	});
}

// 토큰 출금 ajax
function token_withdrawAjax() {
	console.log("token_sum:::"+token_sum);
	console.log("token_wallet:::"+token_wallet);
	console.log("bar:::"+bar);
	$.ajax({
		type: "POST",
		dataType: "JSON",
		url: "./TokenWithdrawAction.mb",
		data: {
			"token_sum": token_sum,
			"token_wallet": token_wallet,
			"bar": bar,
			"session_idx": session_idx
		},
		success: function(data) {
			if(data.result == 1) {
				alert("출금신청이 완료되었습니다.");
				location.href="./MypageDeposit.mb";
			}else {
				alert("출금내용을 정확히 입력해주세요11");
				location.href="./MypageDeposit.mb";
			}
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
			alert("입금 내용을 정확히 입력해주세요22");
			location.href="./MypageDeposit.mb";
		}
	});
}
