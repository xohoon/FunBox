$(function() {
	$('header').load('./header/header.jsp')
    $('footer').load('./footer/footer.jsp')
    $('.like_box').load('./member/like_box.jsp')
    
	var h = $('.cor_info').height() + 32;
	var winW = $(window).width();
	var liOff = $('.cor_info').offset().top;
	var liOffs = liOff * 1 + 56
	if (winW > 1200) {
		$('.list').height(h);
	} else {
		$('.list').height(400);
		$('.list').offset({
			top : liOff
		})
	}
});
$('.list_show').on('click', function() {
	$('.list').toggleClass('on');
	if ($(this).text() == '투자리스트보기') {
		$(this).text('닫기');
	} else if ($(this).text() == '닫기') {
		$(this).text('투자리스트보기');
	}
});
$(function() {
	$(".rep").mousewheel(function(event, delta) {
		this.scrollLeft -= (delta * 100);
		event.preventDefault();
	});
});

function invest_click() {
	$("#invest_check").on('click', function() {
		invest_chk_ajax();
	});
}

function invest_chk_ajax() {
	$.ajax({
		type : "POST",
		url : "./MemberInvestcheck.mb",
		dataType : "json",
		contentType : "application/x-www-form-urlencoded;charset=utf-8",
		data : {},
		success : function(resultData, result, response) {
			if (resultData.mi_idx == -1) {
				alert("투자현황이 존재하지 않습니다. 기업에 투자해보세요.");
				location.href = "./ListAction.bd";
			} else if (resultData.cp_funding_status == 11) {
				location.href = "./MemberInvestmentDrop.mb?mi_idx="
						+ resultData.mi_idx;
			} else if (resultData.cp_funding_status == 12) {
				location.href = "./MemberInvestmentList.mb?mi_idx="
						+ resultData.mi_idx;
			} else {
				alert("잘못된 접급입니다.");
				location.href = "./Index.mb";
			}
		},
		error : function(request, status, error) {
			console.log("request>>" + request);
			console.log("status>>" + status);
			console.log("error>>" + error);
		}
	});
}