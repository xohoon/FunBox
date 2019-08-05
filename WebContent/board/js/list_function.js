///// 태훈 추가 /////
//전역변수
var getKeyword = null;
var getSelect = null;
var list_sector = new Array;
var list_city = new Array;
var list_status = new Array;
var c = "검색어없음";

var current_page = 0;
var companyListHTML ;
var count = 0;

/// check box ///
$(document).ready(function() {
	main_chkbox();
	// 함수 실행
	search_btnFunc();
	option_clickFunc();
	ckbox_clickFunc();
	ckbox_func();
//	search_key();
});

/*
// 검색어 입력할때마다 실시간 검색(ajax X)
function search_key() {
	// 검색어 toggle 방식 검색
	$("#search_text").keyup(function() {
		var key_word = $("#search_text").val();
		$(".corp_box").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(key_word) > -1)
		});
	});
}
 */
function checkboxTrriger(){
	current_page = 0;
	$('.scrolload').stop().html('');
	$('.moreBtn').trigger('click');
}
function search_btnFunc() {
	$("#search_btn").on('click', function() {
		search_value();
		option_value();
		ckbox_list();
		alert('search_btn');
		checkboxTrriger();
	});
}
function option_clickFunc() {
	// select 할때마다 이벤트 함수 실행
	$("#select_option").on("change", function() {
		search_value();
		option_value();
		ckbox_list();
		alert('select_option');
		checkboxTrriger();
	});
}

function ckbox_clickFunc() {
	// 체크박스 클릭시 이벤트 발생
	$("input[type='checkbox']").on('click', function() {
		
		// 체크된 데이터 불러오는 함수 호출
		search_value();
		option_value();
		ckbox_list();
		checkboxTrriger();
	});
}

//검색 ajax
/*function search_ajax() {
	$.ajax({
		type: "POST",
		url: "./ListSearchAction.bd",
		dataType: "json", 
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		data: {
			"list_sector": list_sector,
			"list_city": list_city,
			"list_status": list_status,
			"select_value": getSelect,
			"getKeyword": getKeyword,
			"page" : 0
		},
		success: function(data, idx, val,response) {
			console.log("ajax 통신 성공>>>>");
			console.log("ajax 통신 성공>>>>"+data);
			console.log("ajax 통신 성공>>>>"+idx);
			console.log("ajax 통신 성공>>>>"+response);
			if(data != null) {
				$('.boxwrap').html('');
				$.each(data, function(idx, val) {
					var search_data = {
							cp_idx: val.cp_idx,
							cp_name: val.cp_name,
							cp_percent: val.percent,
							cp_current: val.cp_current_amount,
							cp_goal: val.cp_goal_amount,
							cp_profit: val.cp_monthly_profit,
							cp_branch: val.cp_branch,
							cp_sector: val.cp_sector
					}
					addLists(search_data);
				});
			}else if(data == null){
				window.location.reload();
				console.log("null>>>null");
			}
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
		}
	});
}*/
function makeMoreCompanyListHTML(resultData){	
	companyListHTML += "<div class='corp_box' onclick='location.href='./CorporationAction.cp?cp_idx="+resultData.cp_idx+"'><div class='c_img'><img src='./img/row1_anotherminae.jpg' alt=''></div><div class='c_txt'><p>"+resultData.cp_sector+"</p><h5>"+resultData.cp_name+" <span>추천</span></h5><p>"+resultData.cp_branch+"</p></div><div class='gage'><div class='per'><span>"+resultData.cp_percent+"</span>%</div><div class='gage_full'><div class='gage_fill' style='overflow: hidden; width: 2.155%;'><span></span></div></div><div><span class='p_amt'><span>"+resultData.cp_current+"</span> / <span>"+resultData.cp_goal+"</span> P</span><span class='d_day'>D-<span>27</span></span></div></div><div class='reward_per'>수익률<span>"+resultData.cp_profit+"%</span></div></div>";
};
function search_ajax() {
	$.ajax({
		type: "POST",
		url: "./ListSearchAction.bd",
		dataType: "json", 
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		data: {
			"page" : current_page,
			"list_sector": list_sector,
			"list_city": list_city,
			"list_status": list_status,
			"select_value": getSelect,
			"getKeyword": getKeyword,
		},
		success: function(data, idx, val,response) {
			if(data != null) {
				companyListHTML = "<div class='boxwrap'>";
				$.each(data, function(idx, val) {
					var resultData = {
							cp_idx: val.cp_idx,
							cp_name: val.cp_name,
							cp_percent: val.percent,
							cp_current: val.cp_current_amount,
							cp_goal: val.cp_goal_amount,
							cp_profit: val.cp_monthly_profit,
							cp_branch: val.cp_branch,
							cp_sector: val.cp_sector
					}
					makeMoreCompanyListHTML(resultData);
					str += "1";
				});
				companyListHTML += "</div>";
				
				alert(str);
				current_page++;
				
				console.log(companyListHTML);
			}else if(data == null){
				alert('data null');
				console.log(companyListHTML);
			}
			console.log(companyListHTML);
		},
		error: function(request, status, error) {
			console.log("request>>"+request);
			console.log("status>>"+status);
			console.log("error>>" +error);
		}
		
	});
	alert(str+'sss');
	console.log(companyListHTML);
	return companyListHTML;
}

function search_value() {
	var b = document.getElementById("search_text").value;
	if(!b) {
		getKeyword = c;
	}else {
		getKeyword = b;
	}
	console.log("text value:::"+getKeyword);
}

// select option 값 저장
function option_value() {
	var a = document.getElementById("select_option").value;
	getSelect = a;
	console.log("select value:::"+getSelect);
}

//체크박스 체크 후 데이터 배열형태로 저장
function ckbox_list() {
	
	// 임의 저장할 배열생성
	var list_sector_box = new Array;
	var list_city_box = new Array;
	var list_status_box = new Array;
	
	var city_all = new Array;
	var sector_all = new Array;
	var status_all = new Array;
	
//	city_all = ["서울", "경기", "인천", "강원", "대전/충천", "대구", "부산", "울산", "경상", "광주/전라", "제주"];
	
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
//		list_city_box.push($(this).val());
		alert(">>>"+$(this).attr("value1"));
		list_city_box.push($(this).attr("value1"));
		list_city_box.push($(this).attr("value2"));
		list_city_box.push($(this).attr("value3"));
		list_city_box.push($(this).attr("value4"));
		list_city_box.push($(this).attr("value5"));
		list_city_box.push($(this).attr("value6"));
		list_city_box.push($(this).attr("value7"));
		list_city_box.push($(this).attr("value8"));
		list_city_box.push($(this).attr("value9"));
		list_city_box.push($(this).attr("value10"));
		list_city_box.push($(this).attr("value11"));
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
	if(!list_sector_box) {
		list_sector = c;
	}else {
		list_sector = list_sector_box;
	}
	if(!list_city_box) {
		list_city = c;
	}else {
		list_city = list_city_box;
	}
	if(!list_status_box) {
		list_status = c;
	}else {
		list_status = list_status_box;
	}
	
	console.log("list_sector:::"+list_sector);
	console.log("list_city:::"+list_city);
	console.log("list_status:::"+list_status);
}

/*function addLists(search_data) {
	$('.boxwrap').append(
			"<div class=\"corp_box\" onclick=\"location.href='./CorporationAction.cp'\">"
			+"<div class=\"c_img\">"
			+"<img src=\"./img/row1_anotherminae.jpg\" alt=\"\">"
			+"</div><div class=\"c_txt\">"
			+"<p>"+search_data.cp_sector+"</p>"
			+"<h5>"+search_data.cp_name+" <span>추천</span></h5>"
			+"<p>"+search_data.cp_branch+"</p>"
			+"</div><div class=\"gage\">"
			+"<div class=\"per\"><span>"+search_data.cp_percent+""
			+"</span>%</div><div class=\"gage_full\"><div class=\"gage_fill\">"
			+"<span></span></div></div><div>"
			+"<span class=\"p_amt\"><span>"+search_data.cp_current+""
			+"</span> / <span> "+search_data.cp_goal+""
			+"</span> P</span><span class=\"d_day\">D-<span>27</span></span>"
			+"</div></div><div class=\"reward_per\">수익률"
			+"<span>"+search_data.cp_profit+"%</span>"
			+"</div></div>"
			);
}
*/


function ckbox_func() {
	/// 업종 체크박스
	// 전체 체크박스 클릭시 세부 체크박스 전체 선택 및 해제
	$('#con1_all').click(function() {
		$('.sector_ckbox').prop('checked', this.checked);		
		//checkboxTrriger();
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
		//checkboxTrriger();
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
}

function main_chkbox() {
	window.onload = function () {
		if($("#con2_1").is(":checked") == true) {
			alert("서울 검색 결과입니다.");
			$("#con2_1").trigger("click");
			if($("#con2_1").is(":checked") == false) {
				$("#con2_1").trigger("click");
			}
		}else if($("#con2_2").is(":checked") == true) {
			alert("경기도 검색 결과입니다.");
			$("#con2_2").trigger("click");
			if($("#con2_2").is(":checked") == false) {
				$("#con2_2").trigger("click");
			}
		}else if($("#con2_3").is(":checked") == true) {
			alert("인천 검색 결과입니다.");
			$("#con2_3").trigger("click");
			if($("#con2_3").is(":checked") == false) {
				$("#con2_3").trigger("click");
			}
		}else if($("#con2_4").is(":checked") == true) {
			alert("강원도 검색 결과입니다.");
			$("#con2_4").trigger("click");
			if($("#con2_4").is(":checked") == false) {
				$("#con2_4").trigger("click");
			}
		}else if($("#con2_5").is(":checked") == true) {
			alert("대전과 충천 검색 결과입니다.");
			$("#con2_5").trigger("click");
			if($("#con2_5").is(":checked") == false) {
				$("#con2_5").trigger("click");
			}
		}else if($("#con2_6").is(":checked") == true) {
			alert("대구 검색 결과입니다.");
			$("#con2_6").trigger("click");
			if($("#con2_6").is(":checked") == false) {
				$("#con2_6").trigger("click");
			}
		}else if($("#con2_7").is(":checked") == true) {
			alert("부산 검색 결과입니다.");
			$("#con2_7").trigger("click");
			if($("#con2_7").is(":checked") == false) {
				$("#con2_7").trigger("click");
			}
		}else if($("#con2_8").is(":checked") == true) {
			alert("울산 검색 결과입니다.");
			$("#con2_8").trigger("click");
			if($("#con2_8").is(":checked") == false) {
				$("#con2_8").trigger("click");
			}
		}else if($("#con2_9").is(":checked") == true) {
			alert("경상도 검색 결과입니다.");
			$("#con2_9").trigger("click");
			if($("#con2_9").is(":checked") == false) {
				$("#con2_9").trigger("click");
			}
		}else if($("#con2_10").is(":checked") == true) {
			alert("광주와 전라도 검색 결과입니다.");
			$("#con2_10").trigger("click");
			if($("#con2_10").is(":checked") == false) {
				$("#con2_10").trigger("click");
			}
		}else if($("#con2_11").is(":checked") == true) {
			alert("제주도 검색 결과입니다.");
			$("#con2_11").trigger("click");
			if($("#con2_11").is(":checked") == false) {
				$("#con2_11").trigger("click");
			}
		}
	}
}