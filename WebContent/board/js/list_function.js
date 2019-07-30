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
	// 검색어 toggle 방식 검색
	$("#search_ajax").keyup(function() {
		var key_word = $("#search_ajax").val();
		$(".corp_box").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(key_word) > -1)
		});
	});
	// 체크박스 클릭시 이벤트 발생
	$("input[type='checkbox']").on('click', function() {
		// 체크된 데이터 불러오는 함수 호출
		ckbox_list();
		// ajax 함수 호출
		search_ajax();
	});
});

//전역변수로 설정
var list_sector = new Array;
var list_city = new Array;
var list_status = new Array;


// 체크박스 체크 후 데이터 배열형태로 저장
function ckbox_list() {
	
	// 임의 저장할 배열생성
	var list_sector_box = new Array;
	var list_city_box = new Array;
	var list_status_box = new Array;
	
	// sector input
	$("input[id='con1_all']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_1']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_2']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_3']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_4']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_5']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_6']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_7']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	$("input[id='con1_8']:checked").each(function(i) {
		list_sector_box.push($(this).val());
	});
	// city input
	$("input[id='con2_all']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_1']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_2']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_3']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_4']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_5']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_6']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_7']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_8']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_9']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_10']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	$("input[id='con2_11']:checked").each(function(i) {
		list_city_box.push($(this).val());
	});
	// status input
	$("input[id='con3_all']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	$("input[id='con3_1']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	$("input[id='con3_2']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	$("input[id='con3_3']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	$("input[id='con3_4']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	$("input[id='con3_5']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	$("input[id='con3_6']:checked").each(function(i) {
		list_status_box.push($(this).val());
	});
	
	// 전역변수에 넣어준다
	list_sector = list_sector_box;
	list_city = list_city_box;
	list_status = list_status_box;
	
	console.log("list_sector:::"+list_sector);
	console.log("list_city:::"+list_city);
	console.log("list_status:::"+list_status);
}

//검색 ajax
function search_ajax() {
	$.ajax({
		type: "POST",
		url: "./ListSearchAction.bd",
		dataType: "JSON", 
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		data: {
			"list_sector": list_sector,
			"list_city": list_city,
			"list_status": list_status
		},
		success: function(result) {
			console.log("성공좀해라"+result.toString());
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
		}
	});
}







