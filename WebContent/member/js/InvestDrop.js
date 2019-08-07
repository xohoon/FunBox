/// 태훈 추가 - 투자 철회기능
var iv_pincode;
var isRun = false;

$(document).ready(function() {
	Drop_key();
});

//버튼 비활성
function btn_off() {
	btn = document.getElementById('IvDrop_btn');
	btn.disabled = 'disabled';
}

// 철회 버튼
function Invest_DropBtn() {
	btn = document.getElementById('IvDrop_btn');
	$("#IvDrop_btn").on('click', function() {
		location.href="./MemberIvDrop.mb";
	});
	btn.disabled = false;
}

function Drop_key() {
	$(".pincode").keyup(function() {
		DropCode_chk();
	});
}

function DropCode_chk() {
	iv_pincode = $("#pin01").val()+$("#pin02").val()+$("#pin03").val()+$("#pin04").val()+$("#pin06").val();
	if(isRun == true) {
        return;
    }
	isRun = true;
	$.ajax({
		url: "./MypagePINCheckAction.mb",
		type: "POST",
		dataType: "JSON",
		data : {
			"iv_pincode": iv_pincode
		},
		success: function(data) {
			if(String(data.result) == "confirm_pin_success"){
				$('#pin_check').text('');
				$('#pin_check').html("일치");
				document.getElementById("pin_check").setAttribute("color", "blue");
				Invest_DropBtn();
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
/*
function DropInvest() {
	$.ajax({
		type: "POST",
		dataType: "JSON",
		url: "./MemberIvDrop.mb",
		data: {
			"point_sum": point_sum,
			"session_idx": session_idx
		},
		success: function(data) {
			if(data.result == 1) {
				alert("포인트충전이 완료되었습니다.");
				location.href="./Mypage2_2.mb";
			}else {
				alert("내용을 정확히 입력해주세요11");
				location.href="./Mypage2_2.mb";
			}
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
			alert("입금 내용을 정확히 입력해주세요22");
			location.href="./Mypage2_2.mb";
		}
	});
}
*/