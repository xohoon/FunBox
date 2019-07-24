///// 태훈 script 추가 /////

/// check box ///
$(document).ready(function() {
	// 전체 체크박스 클릭시 세부 체크박스 전체 선택 및 해제
	$('#chka').click(function() {
		$('.checkBox').prop('checked', this.checked);
	});
	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.checkBox').click(function() {
		if($("#chk1").prop("checked")
				&& $("#chk2").prop("checked") 
				&& $("#chk3").prop("checked") 
				&& $("#chk4").prop("checked")) {
			$('#chka').prop('checked', true);
		}
	});
	// 세부 체크박스 하나라도 해제시 전체 체크박스 자동 해제
	$('.checkBox').click(function() {
		if($("#chk1").is(":checked") == false
				|| $("#chk2").is(":checked") == false
				|| $("#chk3").is(":checked") == false
				|| $("#chk4").is(":checked") == false) {
			$('#chka').prop('checked', false);
		}
	});
});

/// check box 유효성 검사 ///
function checkGo() {
	
	if(!$('#chk1').prop("checked")) {
		alert("유의사항을 확인해 주세요.");
		return location.reload();
	}else if(!$('#chk2').prop("checked")) {
		alert("유의사항을 확인해 주세요.");
		return location.reload();
	}else if(!$('#chk2').prop("checked")) {
		alert("유의사항을 확인해 주세요.");
		return location.reload();
	}else if(!$('#chk3').prop("checked")) {
		alert("유의사항을 확인해 주세요.");
		return location.reload();
	}else if(!$('#chk4').prop("checked")) {
		alert("유의사항을 확인해 주세요.");
		return location.reload();
	}else if(!$('#chka').prop("checked")) {
		alert("유의사항을 확인해 주세요.");
		return location.reload();
	}
	
}

/// invest 투자포인트/구좌 양
function invest_add() {
	var f = document.inv_before;
	f.submit();
}





