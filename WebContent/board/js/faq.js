//// 태훈추가 - script분리 ////
$(document).ready(function() {
	// 제이쿼리 페이지 로딩 추가
	// alert("로딩 완료");
	$('header').load('./header/header.jsp')
	$('footer').load('./footer/footer.jsp')
});

$(function() {
	setTimeout(function() {
		$('.loader').fadeOut(1000);
	}, 1000)
});

var Flag = 0;

$(function() {
	var onOff = false;
	$('.depth1').on('click', function() {
		onOff = !onOff;
		if (onOff == true) {
			$(this).siblings('.depth2').css({
				'display' : 'block'
			});
		} else {
			$(this).siblings('.depth2').css({
				'display' : 'none'
			});
		}
	});
});

$(function() {
	if ($('#cate_color').val() == '0') {
		$('.faq > button').removeClass('on');
		$('#button1').addClass('on');
	} else if ($('#cate_color').val() == '1') {
		$('.faq > button').removeClass('on');
		$('#button2').addClass('on');
	} else if ($('#cate_color').val() == '2') {
		$('.faq > button').removeClass('on');
		$('#button3').addClass('on');
	} else if ($('#cate_color').val() == '3') {
		$('.faq > button').removeClass('on');
		$('#button4').addClass('on');
	}
});

function searchCheck(frm) {
	if (frm.keyword.value == '') {
		alert('검색할 단어를 입력해주세요.');
		frm.keyword.focus();
		return false;
	}
	frm.submit();
}

function cateval(button) {
	// 페이징 링크 링크 연결 수정
	var category = button;
	var pageNum = 1;

	if (pageNum != "1") {
		var pageNum = document.getElementById("hiddenCategory").value;
	}

	$("#category").val(category); // 찾기를 위한 카테고리 변수
	location.href = './Faq.bd?category=' + category + '&pageNum=' + pageNum;
}
