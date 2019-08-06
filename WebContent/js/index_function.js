////////////////태훈 추가 - 메인페이지 실시간 순위

$(document).ready(function() {
	main_list();
});

var select_key = null;
var real_list = null;
var cp_name_list = new Array;
var ajax_list = new Array;

function realtime_like() {
	select_key = $('#select_k').val();
	ajax_list = new Array;
	memory_list= new Array;
		$.ajax({
			type: "POST",
			url: "./MemberSelectKey.mb",
			dataType: "json",
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			data: {
				"select_key": select_key
			},
			success: function(data, result, response) {
				if(data != null) {
					$('.list_ul').html('');
					$.each(data, function(idx, val) {
						real_list = {
								cp_name: val.cp_name,
						}
						ajax_list.push(val.cp_name);
						view_list(real_list, idx+1);
					});
				}else if(data == null) {
					console.log("데이터없어 왜???");
				}
				cp_name_list = ajax_list;
			},
			error: function(error, request, status) {
				
			}
		});
}

function view_list(real_list, idx) {
	$('.list_ul').append(
				"<li>"
	            +"<span>"+idx+"</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name+"</a>"
	            +"<span></span>"
	            +"</li>"
			);
}

function main_list() {
	window.onload = function () {
		realtime_like();
	}
}

function Delay_func() {
	setTimeout(function() {
		realtime_like();
	}, 800);
}

