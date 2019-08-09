///// 태훈 추가 /////
//전역변수
var getKeyword = null;
var getSelect = null;
var sector_array = new Array;
var city_array = new Array;
var city_status = new Array;
var c = "검색어없음";

var current_page = 0;
var companyListHTML;
var count = 0;

var wideBoxFlag = false;
var wide_box = 'wide_box';

// / check box ///
$(document).ready(function() {
	// 함수 실행
	main_chkbox();
	search_btnFunc();
	option_clickFunc();
	ckbox_clickFunc();
	ckbox_func();
});

function checkboxTrriger() {
	current_page = 0;
	if ($._data($(window)[0], 'events').scrollstop == undefined
			|| $._data($('.moreBtn')[0], 'events').click == undefined) {
		$('.gage').each(function() {
			var percent = $(this).find('.per > span').text();

			$(this).find('.gage_fill').animate({
				'width' : percent + '%'
			}, 1500);
		});

		var currentscroll = 0;
		var lastscroll = 0;

		$(window)
				.on(
						'scrollstop',
						function() {

							$
									.ajax({
										type : "POST",
										url : "./ListSearchAction.bd",
										dataType : "json",
										contentType : "application/x-www-form-urlencoded;charset=utf-8",
										data : {
											"page" : current_page,
											"sector_array" : sector_array,
											"city_array" : city_array,
											"city_status" : city_status,
											"select_value" : getSelect,
											"getKeyword" : getKeyword,
										},
										success : function(data, idx, val,
												response) {
											if (data != null) {
												var count = 0;
												companyListHTML = "<div class='boxwrap'>";
												$
														.each(
																data,
																function(idx,
																		val) {
																	var resultData = {
																		cp_idx : val.cp_idx,
																		cp_name : val.cp_name,
																		cp_percent : val.percent,
																		cp_current : val.cp_current_amount,
																		cp_goal : val.cp_goal_amount,
																		cp_profit : val.cp_monthly_profit,
																		cp_branch : val.cp_branch,
																		cp_sector : val.cp_sector,
																		cp_stop_date_time : val.cp_stop_date_time,
									    								thumbnail_image : val.thumbnail_image
																	}
																	count++;
																	makeMoreCompanyListHTML(resultData);
																});
												companyListHTML += "</div>";
												var clonedata = companyListHTML;

												var randomarti = Math.ceil(Math
														.random() * 6)
												var randomnum = (randomarti + 4) * 100

												var htmlheight = $('html')
														.outerHeight();
												var veiwheight = $(window)
														.height();
												var trigger = htmlheight
														- veiwheight - 20

												if (currentscroll < trigger) {
													currentscroll = $(window)
															.scrollTop();
												}

												if (lastscroll = trigger
														&& currentscroll > trigger) {

													$('.loader').stop().fadeIn(
															100);
													lastscroll = $(window)
															.scrollTop()

													$('.scrolload').stop()
															.append(clonedata)

													var foot = $('footer')
															.offset().top

													setTimeout(
															function() {
																$(
																		'.scrolload > .boxwrap')
																		.addClass(
																				'on')
																$('.loader')
																		.stop()
																		.fadeOut(
																				randomnum);

																$('.gage')
																		.each(
																				function() {
																					var percent = $(
																							this)
																							.find(
																									'.per > span')
																							.text();

																					$(
																							this)
																							.find(
																									'.gage_fill')
																							.animate(
																									{
																										'width' : percent
																												+ '%'
																									},
																									1500);
																				});
															}, randomnum);
												}
												current_page++;
											}
											if (count < 8) {
												$('.moreBtn').off('click');
												$('.moreBtn').hide();
												$(window).off('scrollstop');
											}
										},
										error : function(request, status, error) {
											console.log("request>>" + request);
											console.log("status>>" + status);
											console.log("error>>" + error);
										}
									});
						});

		$('.moreBtn')
				.on(
						'click',
						function() {
							$
									.ajax({
										type : "POST",
										url : "./ListSearchAction.bd",
										dataType : "json",
										contentType : "application/x-www-form-urlencoded;charset=utf-8",
										data : {
											"page" : current_page,
											"sector_array" : sector_array,
											"city_array" : city_array,
											"city_status" : city_status,
											"select_value" : getSelect,
											"getKeyword" : getKeyword,
										},
										success : function(data, idx, val,
												response) {
											if (data != null) {
												var count = 0;
												companyListHTML = "<div class='boxwrap'>";
												$
														.each(
																data,
																function(idx,
																		val) {
																	var resultData = {
																		cp_idx : val.cp_idx,
																		cp_name : val.cp_name,
																		cp_percent : val.percent,
																		cp_current : val.cp_current_amount,
																		cp_goal : val.cp_goal_amount,
																		cp_profit : val.cp_monthly_profit,
																		cp_branch : val.cp_branch,
																		cp_sector : val.cp_sector,
																		cp_stop_date_time : val.cp_stop_date_time,
									    								thumbnail_image : val.thumbnail_image
																	}
																	count++;
																	makeMoreCompanyListHTML(resultData);
																});
												companyListHTML += "</div>";
												var clonedata = companyListHTML;
												var randomarti = Math.ceil(Math
														.random() * 6)
												var randomnum = (randomarti + 4) * 100
												$('.loader').stop().fadeIn(100);
												$('.scrolload').stop().append(
														clonedata)

												setTimeout(
														function() {
															$(
																	'.scrolload > .boxwrap')
																	.addClass(
																			'on')
															$('.loader')
																	.stop()
																	.fadeOut(
																			randomnum);

															$('.gage')
																	.each(
																			function() {
																				var percent = $(
																						this)
																						.find(
																								'.per > span')
																						.text();

																				$(
																						this)
																						.find(
																								'.gage_fill')
																						.animate(
																								{
																									'width' : percent
																											+ '%'
																								},
																								1500);
																			});
														}, randomnum);
												current_page++;
											}
											if (count < 8) {
												$('.moreBtn').off('click');
												$('.moreBtn').hide();
												$(window).off('scrollstop');
											}
										},
										error : function(request, status, error) {
											console.log("request>>" + request);
											console.log("status>>" + status);
											console.log("error>>" + error);
										}

									});
						});
		$('.moreBtn').show();
	}
	$('.scrolload').stop().html('');
	$('.moreBtn').trigger('click');
}
function search_btnFunc() {
	$("#search_btn").on('click', function() {
		search_value();
		option_value();
		ckbox_list();
		checkboxTrriger();
	});
}
function option_clickFunc() {
	// select 할때마다 이벤트 함수 실행
	$("#select_option").on("change", function() {
		search_value();
		option_value();
		ckbox_list();
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

function makeMoreCompanyListHTML(resultData) {
	var Dday = getDday(resultData.cp_stop_date_time);
	var Dday_text = "D-";
	if (Dday <= 0) {
		Dday_text = "";
		Dday = "편딩 기간 종료"
	}
	//wide_box
	if (wideBoxFlag == false) {
		companyListHTML += "<div class='corp_box' onclick=location.href='./CorporationAction.cp?cp_idx=";
	}else{
		companyListHTML += "<div class='corp_box wide_box' onclick=location.href='./CorporationAction.cp?cp_idx=";
	}
	companyListHTML+= resultData.cp_idx
			+ "'><div class='c_img'><img src='"+resultData.thumbnail_image+"' alt=''></div><div class='c_txt'><p>"
			+ resultData.cp_sector
			+ "</p><h5>"
			+ resultData.cp_name
			+ " <span>추천</span></h5><p>"
			+ resultData.cp_branch
			+ "</p></div><div class='gage'><div class='per'><span>"
			+ resultData.cp_percent
			+ "</span>%</div><div class='gage_full'><div class='gage_fill' style='overflow: hidden; width: 2.155%;'><span></span></div></div><div><span class='p_amt'><span>"
			+ comma(resultData.cp_current)
			+ "</span> / <span>"
			+ comma(resultData.cp_goal)
			+ "</span> P</span><span class='d_day'>"+Dday_text+"<span>"+Dday+"</span></span></div></div><div class='reward_per'>수익률<span>"
			+ resultData.cp_profit + "%</span></div></div>";
};
function search_ajax() {
	$.ajax({
		type : "POST",
		url : "./ListSearchAction.bd",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {
			"page" : current_page,
			"sector_array" : sector_array,
			"city_array" : city_array,
			"city_status" : city_status,
			"select_value" : getSelect,
			"getKeyword" : getKeyword,
		},
		success : function(data, idx, val, response) {
			if (data != null) {
				companyListHTML = "<div class='boxwrap'>";
				$.each(data, function(idx, val) {
					var resultData = {
						cp_idx : val.cp_idx,
						cp_name : val.cp_name,
						cp_percent : val.percent,
						cp_current : val.cp_current_amount,
						cp_goal : val.cp_goal_amount,
						cp_profit : val.cp_monthly_profit,
						cp_branch : val.cp_branch,
						cp_sector : val.cp_sector,
						cp_stop_date_time : val.cp_stop_date_time
					}
					makeMoreCompanyListHTML(resultData);
					str += "1";
				});
				companyListHTML += "</div>";

				alert(str);
				current_page++;

				console.log(companyListHTML);
			} else if (data == null) {
				alert('data null');
				console.log(companyListHTML);
			}
			console.log(companyListHTML);
		},
		error : function(request, status, error) {
			console.log("request>>" + request);
			console.log("status>>" + status);
			console.log("error>>" + error);
		}

	});
	console.log(companyListHTML);
	return companyListHTML;
}

function search_value() {
	getKeyword = document.getElementById("search_text").value;
	/*if (!b) {
		getKeyword = c;
	} else {
		getKeyword = b;
	}*/
	console.log("text value:::" + getKeyword);
}

// select option 값 저장
function option_value() {
	var a = document.getElementById("select_option").value;
	getSelect = a;
	console.log("select value:::" + getSelect);
}

function test() {
	$.each($('.sector_ckbox'), function(index, item) {
		console.log(item.checked);
	})
};

// 체크박스 체크 후 데이터 배열형태로 저장
function ckbox_list() {

	// 임의 저장할 배열생성
	var list_sector_box = new Array;
	var list_city_box = new Array;
	var list_status_box = new Array;

	var city_all = new Array;
	var sector_all = new Array;
	var status_all = new Array;

	// city_all = ["서울", "경기", "인천", "강원", "대전/충천", "대구", "부산", "울산", "경상",
	// "광주/전라", "제주"];

	// sector input
	/*
	 * $("input[id='con1_all']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 */
	/*
	 * if ($('#con1_all').prop('checked')) {
	 * $("input[id='con1_all']:checked").each(function(i) { list_sector_box =
	 * new Array; $.each($('.sector_ckbox'), function (index, item) {
	 * list_sector_box.push(item.value); }) }); }else{ sector_array = new Array;
	 * $("input[id='con1_1']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_2']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_3']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_4']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_5']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_6']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_7']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); });
	 * $("input[id='con1_8']:checked").each(function(i) {
	 * list_sector_box.push($(this).val()); }); }
	 */
	// 체크 되어 있으면 값을 추가 해준다.
	$.each($('.sector_ckbox'), function(index, item) {
		if (item.checked) {
			list_sector_box.push(item.value);
		}
	})

	if ($('#con1_all').prop('checked')) {
		$("input[id='con1_all']:checked").each(function(i) {
			list_sector_box = new Array;
			$.each($('.sector_ckbox'), function(index, item) {
				list_sector_box.push(item.value);
			})
		});
	}

	// city input
	/*
	 * $("input[id='con2_all']:checked").each(function(i) {
	 * list_city_box.push($(this).attr("value1"));
	 * list_city_box.push($(this).attr("value2"));
	 * list_city_box.push($(this).attr("value3"));
	 * list_city_box.push($(this).attr("value4"));
	 * list_city_box.push($(this).attr("value5"));
	 * list_city_box.push($(this).attr("value6"));
	 * list_city_box.push($(this).attr("value7"));
	 * list_city_box.push($(this).attr("value8"));
	 * list_city_box.push($(this).attr("value9"));
	 * list_city_box.push($(this).attr("value10"));
	 * list_city_box.push($(this).attr("value11")); });
	 */

	$.each($('.city_ckbox'), function(index, item) {
		if (item.checked) {
			list_city_box.push(item.value);
		}
	})

	/*
	 * $("input[id='con2_1']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_2']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_3']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_4']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_5']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_6']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_7']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_8']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_9']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_10']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 * $("input[id='con2_11']:checked").each(function(i) {
	 * list_city_box.push($(this).val()); });
	 */
	if ($('#con2_all').prop('checked')) {
		$("input[id='con2_all']:checked").each(function(i) {
			list_city_box = new Array;
			$.each($('.city_ckbox'), function(index, item) {
				list_city_box.push(item.value);
			})
		});
	}
	// status input
	/*
	 * $("input[id='con3_all']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 * $("input[id='con3_1']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 * $("input[id='con3_2']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 * $("input[id='con3_3']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 * $("input[id='con3_4']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 * $("input[id='con3_5']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 * $("input[id='con3_6']:checked").each(function(i) {
	 * list_status_box.push($(this).val()); });
	 */

	$.each($('.status_ckbox'), function(index, item) {
		if (item.checked) {
			list_status_box.push(item.value);
		}
	})

	if ($('#con3_all').prop('checked')) {
		$("input[id='con3_all']:checked").each(function(i) {
			list_status_box = new Array;
			$.each($('.status_ckbox'), function(index, item) {
				list_status_box.push(item.value);
			})
		});
	}

	sector_array = list_sector_box;
	city_array = list_city_box;
	city_status = list_status_box;
	// 전역변수에 넣어준다
	/*
	 * if(!list_sector_box) { sector_array = c; alert(c+sector_array); }else {
	 * sector_array = list_sector_box; } if(!list_city_box) { city_array = c;
	 * }else { city_array = list_city_box; } if(!list_status_box) { city_status =
	 * c; }else { city_status = list_status_box; }
	 */

	// console.log("sector_array:::"+sector_array);
	// console.log("city_array:::"+city_array);
	// console.log("city_status:::"+city_status);
}

/*
 * function addLists(search_data) { $('.boxwrap').append( "<div
 * class=\"corp_box\" onclick=\"location.href='./CorporationAction.cp'\">" +"<div
 * class=\"c_img\">" +"<img src=\"./img/row1_anotherminae.jpg\" alt=\"\">" +"</div><div
 * class=\"c_txt\">" +"<p>"+search_data.cp_sector+"</p>" +"<h5>"+search_data.cp_name+"
 * <span>추천</span></h5>" +"<p>"+search_data.cp_branch+"</p>" +"</div><div
 * class=\"gage\">" +"<div class=\"per\"><span>"+search_data.cp_percent+"" +"</span>%</div><div
 * class=\"gage_full\"><div class=\"gage_fill\">" +"<span></span></div></div><div>" +"<span
 * class=\"p_amt\"><span>"+search_data.cp_current+"" +"</span> / <span>
 * "+search_data.cp_goal+"" +"</span> P</span><span class=\"d_day\">D-<span>27</span></span>" +"</div></div><div
 * class=\"reward_per\">수익률" +"<span>"+search_data.cp_profit+"%</span>" +"</div></div>" ); }
 */

function ckbox_func() {
	// / 업종 체크박스
	// 전체 체크박스 클릭시 세부 체크박스 전체 선택 및 해제
	$('#con1_all').click(function() {
		if ($('#con1_all').prop('checked') == false) {
			sector_array = new Array;
		}
		$('.sector_ckbox').prop('checked', this.checked);
	});

	$('#con2_all').click(function() {
		if ($('#con2_all').prop('checked') == false) {
			city_array = new Array;
		}
		$('.city_ckbox').prop('checked', this.checked);
	});

	$('#con3_all').click(function() {
		if ($('#con3_all').prop('checked') == false) {
			city_status = new Array;
		}
		$('.status_ckbox').prop('checked', this.checked);
	});
	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.sector_ckbox').click(
			function() {
				if ($("#con1_1").prop("checked")
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
	$('.sector_ckbox').click(
			function() {
				if ($("#con1_1").is(":checked") == false
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

	// / 지역 체크박스

	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.city_ckbox').click(
			function() {
				if ($("#con2_1").prop("checked")
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
	$('.city_ckbox').click(
			function() {
				if ($("#con2_1").is(":checked") == false
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

	// / 현황 체크박스
	// 세부 체크박스 모두 선택시 전체 체크박스 자동 선택
	$('.status_ckbox').click(
			function() {
				if ($("#con3_1").prop("checked")
						&& $("#con3_2").prop("checked")
						&& $("#con3_3").prop("checked")
						&& $("#con3_4").prop("checked")
						&& $("#con3_5").prop("checked")
						&& $("#con2_6").prop("checked")) {
					$('#con3_all').prop('checked', true);
				}
			});
	// 세부 체크박스 하나라도 해제시 전체 체크박스 자동 해제
	$('.status_ckbox').click(
			function() {
				if ($("#con3_1").is(":checked") == false
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
	if ($("#con2_1").is(":checked") == true) {
		alert("서울 검색 결과입니다.");
		$("#con2_1").trigger("click");
		if ($("#con2_1").is(":checked") == false) {
			$("#con2_1").trigger("click");
		}
	} else if ($("#con2_2").is(":checked") == true) {
		alert("경기도 검색 결과입니다.");
		$("#con2_2").trigger("click");
		if ($("#con2_2").is(":checked") == false) {
			$("#con2_2").trigger("click");
		}
	} else if ($("#con2_3").is(":checked") == true) {
		alert("인천 검색 결과입니다.");
		$("#con2_3").trigger("click");
		if ($("#con2_3").is(":checked") == false) {
			$("#con2_3").trigger("click");
		}
	} else if ($("#con2_4").is(":checked") == true) {
		alert("강원도 검색 결과입니다.");
		$("#con2_4").trigger("click");
		if ($("#con2_4").is(":checked") == false) {
			$("#con2_4").trigger("click");
		}
	} else if ($("#con2_5").is(":checked") == true) {
		alert("대전과 충천 검색 결과입니다.");
		$("#con2_5").trigger("click");
		if ($("#con2_5").is(":checked") == false) {
			$("#con2_5").trigger("click");
		}
	} else if ($("#con2_6").is(":checked") == true) {
		alert("대구 검색 결과입니다.");
		$("#con2_6").trigger("click");
		if ($("#con2_6").is(":checked") == false) {
			$("#con2_6").trigger("click");
		}
	} else if ($("#con2_7").is(":checked") == true) {
		alert("부산 검색 결과입니다.");
		$("#con2_7").trigger("click");
		if ($("#con2_7").is(":checked") == false) {
			$("#con2_7").trigger("click");
		}
	} else if ($("#con2_8").is(":checked") == true) {
		alert("울산 검색 결과입니다.");
		$("#con2_8").trigger("click");
		if ($("#con2_8").is(":checked") == false) {
			$("#con2_8").trigger("click");
		}
	} else if ($("#con2_9").is(":checked") == true) {
		alert("경상도 검색 결과입니다.");
		$("#con2_9").trigger("click");
		if ($("#con2_9").is(":checked") == false) {
			$("#con2_9").trigger("click");
		}
	} else if ($("#con2_10").is(":checked") == true) {
		alert("광주와 전라도 검색 결과입니다.");
		$("#con2_10").trigger("click");
		if ($("#con2_10").is(":checked") == false) {
			$("#con2_10").trigger("click");
		}
	} else if ($("#con2_11").is(":checked") == true) {
		alert("제주도 검색 결과입니다.");
		$("#con2_11").trigger("click");
		if ($("#con2_11").is(":checked") == false) {
			$("#con2_11").trigger("click");
		}
	}
}

//숫자 콤마~
function comma(num){
    var len, point, str; 
       
    num = num + ""; 
    point = num.length % 3 ;
    len = num.length; 
   
    str = num.substring(0, point); 
    while (point < len) { 
        if (str != "") str += ","; 
        str += num.substring(point, point + 3); 
        point += 3; 
    } 
     
    return str;
}
const second = 1000,
minute = second * 60,
hour = minute * 60,
day = hour * 24;
//Dday 구하깅?
function getDday(stopDate){
	  let countDown = new Date(stopDate).getTime();
	  let now = new Date().getTime();
	  distance = countDown - now;
	  return Math.floor(distance / (day));
};