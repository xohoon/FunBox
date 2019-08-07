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
	iv_pincode = $("#pin01").val()+$("#pin02").val()+$("#pin03").val()+$("#pin04").val()+$("#pin05").val()+$("#pin06").val();
	console.log(">>>"+iv_pincode);
	if(isRun == true) {
        return;
    }
	isRun = true;
	$.ajax({
		url: "./MypagePINCheckAction.mb",
		type: "POST",
		dataType: "JSON",
		data : {
			"pin": iv_pincode
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
