/////////////// 태훈 추가 //////////////////////////
var isRun = false;
var point_sum = null;
var session_idx = null;
var pin = pin;
var id = id;

$(document).ready(function() {
	pass_key();
});

//버튼비활성화
function btn_off() {
	btn = document.getElementById('charge_button');
	btn.disabled = 'disabled';
}

// 포인트 입금신청 
function point_deposit_btn() {
	btn = document.getElementById('charge_button');
	$("#charge_button").on('click', function() {
		point_sum = $(".sumcomma1").text();
		session_idx = $("#session_idx").val();
		if(point_sum != 0 && session_idx != null) {
			point_depositAjax();
		}else {
			alert("충전할 포인트를 입력해주세요.");
		}
	});
	btn.disabled = false;
}

//포인트 입금신청 ajax
function point_depositAjax() {
	console.log("point_sum:::"+point_sum);
	$.ajax({
		type: "POST",
		dataType: "JSON",
		url: "./PointDepositAction.mb",
		data: {
			"point_sum": point_sum,
			"session_idx": session_idx
		},
		success: function(data) {
			if(data.result == 1) {
				alert("포인트충전이 완료되었습니다.");
				location.href="./Mypage2_2.mb";
			}else {
				alert("보유토큰이 부족합니다.");
				location.href="./Mypage2_2.mb";
			}
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
			alert("보유토큰이 부족합니다.");
			location.href="./Mypage2_2.mb";
		}
	});
}

function pass_key() {
	$("#pin").keyup(function() {
		pincode_check();
	});
}
 
// 핀코드 확인 ajax
function pincode_check() {
	if(isRun == true) {
        return;
    }
    isRun = true;
	pin = $("#pin").val();
	id = $("#session_value").val();
	console.log("pincode:::"+pin);
	console.log("sessionID:::"+id);
	$.ajax({
		url: "./MypagePINCheckAction.mb",
		type: "POST",
		dataType: "JSON",
		data : {
			"pin": pin
		},
		success: function(data) {
			if(String(data.result) == "confirm_pin_success"){
				$('#pin_check').text('');
				$('#pin_check').html("일치");
				document.getElementById("pin_check").setAttribute("color", "blue");
				point_deposit_btn();
			}else{
				$('#pin_check').text('');
				$('#pin_check').html("불일치");
				document.getElementById("pin_check").setAttribute("color", "red");
				btn_off();
			}
			isRun  = false;
		},
		error: function(request, status, error) {
			console.log("reqluest:::"+request);
			console.log("status:::"+status);
			console.log("error:::"+error);
		}
	});
}


