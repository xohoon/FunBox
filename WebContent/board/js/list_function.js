///// 태훈 추가 /////

/// check box ///
$(document).ready(function() {
	/// 업종 체크박스
	// 전체 체크박스 클릭시 세부 체크박스 전체 선택 및 해제
	$('#con1_all').click(function() {
		$('.sector_ckbox').prop('checked', this.checked);
	});
	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.sector_ckbox').click(function() {
		if($("#con1_1").prop("checked")
				&& $("#con1_2").prop("checked") 
				&& $("#con1_3").prop("checked") 
				&& $("#con1_4").prop("checked") 
				&& $("#con1_5").prop("checked") 
				&& $("#con1_6").prop("checked") 
				&& $("#con1_7").prop("checked") 
				&& $("#con1_8").prop("checked")) {
			$('#con1_all').prop('checked', true);
		}
	});
	// 세부 체크박스 하나라도 해제시 전체 체크박스 자동 해제
	$('.sector_ckbox').click(function() {
		if($("#con1_1").is(":checked") == false
				|| $("#con1_2").is(":checked") == false
				|| $("#con1_3").is(":checked") == false
				|| $("#con1_4").is(":checked") == false
				|| $("#con1_5").is(":checked") == false
				|| $("#con1_6").is(":checked") == false
				|| $("#con1_7").is(":checked") == false
				|| $("#con1_8").is(":checked") == false) {
			$('#con1_all').prop('checked', false);
		}
	});
	
	/// 지역 체크박스
	// 전체 체크박스 클릭시 세부 체크박스 전체 선택 및 해제
	$('#con2_all').click(function() {
		$('.city_ckbox').prop('checked', this.checked);
	});
	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.city_ckbox').click(function() {
		if($("#con2_1").prop("checked")
				&& $("#con2_2").prop("checked") 
				&& $("#con2_3").prop("checked") 
				&& $("#con2_4").prop("checked") 
				&& $("#con2_5").prop("checked") 
				&& $("#con2_6").prop("checked") 
				&& $("#con2_7").prop("checked") 
				&& $("#con2_8").prop("checked") 
				&& $("#con2_9").prop("checked") 
				&& $("#con2_10").prop("checked") 
				&& $("#con2_11").prop("checked")) {
			$('#con2_all').prop('checked', true);
		}
	});
	// 세부 체크박스 하나라도 해제시 전체 체크박스 자동 해제
	$('.city_ckbox').click(function() {
		if($("#con2_1").is(":checked") == false
				|| $("#con2_2").is(":checked") == false
				|| $("#con2_3").is(":checked") == false
				|| $("#con2_4").is(":checked") == false
				|| $("#con2_5").is(":checked") == false
				|| $("#con2_6").is(":checked") == false
				|| $("#con2_7").is(":checked") == false
				|| $("#con2_8").is(":checked") == false
				|| $("#con2_9").is(":checked") == false
				|| $("#con2_10").is(":checked") == false
				|| $("#con2_11").is(":checked") == false) {
			$('#con2_all').prop('checked', false);
		}
	});
	
	/// 현황 체크박스
	// 전체 체크박스 클릭시 세부 체크박스 전체 선택 및 해제
	$('#con3_all').click(function() {
		$('.status_ckbox').prop('checked', this.checked);
	});
	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.status_ckbox').click(function() {
		if($("#con3_1").prop("checked")
				&& $("#con3_2").prop("checked") 
				&& $("#con3_3").prop("checked") 
				&& $("#con3_4").prop("checked") 
				&& $("#con3_5").prop("checked") 
				&& $("#con2_6").prop("checked")) {
			$('#con3_all').prop('checked', true);
		}
	});
	// 세부 체크박스 하나라도 해제시 전체 체크박스 자동 해제
	$('.status_ckbox').click(function() {
		if($("#con3_1").is(":checked") == false
				|| $("#con3_2").is(":checked") == false
				|| $("#con3_3").is(":checked") == false
				|| $("#con3_4").is(":checked") == false
				|| $("#con3_5").is(":checked") == false
				|| $("#con3_6").is(":checked") == false) {
			$('#con3_all').prop('checked', false);
		}
	});
});
/*
var search_list = [];
$("input[class='sector_ckbox']:checked").each(function(i) {
	search_list.push($(this).val());
});
*/
function search_ajax(){
    $.ajax({
        type: "POST",
        url : "./ListSearchAction.bd",
        data: JSON.stringify(ArrayList),
        dataType : "json",
        contentType : "application; charset=utf-8",
        success : function(data){
            //success function
            //TIP : location.herf = "사용할 URL" 하면 GET방식으로 
        },
        error : function(){
            //error function
        }
    });
}







