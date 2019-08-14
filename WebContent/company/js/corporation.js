$(function() {
	$('header').load('./header/header.jsp');
    $('footer').load('./footer/footer.jsp');
	
	$('.gage').each(function() {
		var percent = $(this).find('span').text() + '%'

		$(this).find('div').animate({
			'width' : percent
		}, 2000)
	});

	$(".data ul li .click").click(function() {
		$(".data ul li").removeClass("on");
		$(this).parent("li").addClass("on");
		return false;
	});

	var FH = $('.content').offset().top

	$(window).on('scroll', function() {
		if ($(window).width() >= 767) {
			var WH = $(window).scrollTop();

			if (WH > FH) {
				$('.content').addClass('on')
			} else {
				$('.content').removeClass('on')
			}
		} else
			false;
	});

	if ($(window).width() <= 767) {
		$('.content .list').height($(window).height());
	} else
		false;

	$(".data ul li .click").click(function() {
		$(".data ul li").removeClass("on");
		$(this).parent("li").addClass("on");
		return false;
	});

	$(".list ul li").click(function() {
		$(".list ul li").removeClass("on");
		$(this).addClass("on");
	});

	var winh = $(window).height();

	$(".list-float").click(
			function() {
				$(".list-float").toggleClass("on"), $('.content .list')
						.slideToggle(500);
				return false;
			});

	// 찜하기 되어 있으면 즐겨찾기 아이콘 클릭처리
	if ($('.like').val() == '1') {
		$('.like').toggleClass('on');
	}
	
	$('.content .info > h2').css('background-image','url('+$('#cf_corporation_icon').val()+')');
	$('.info .bg').css('background-image','url('+$('#cf_corporation_banner').val()+')');

});

// 유정 추가 - 찜버튼에 값 넣기
$(".like").click(function() {
	var idx = $('#idx');
	if (idx == null) {
		swal('로그인이 필요한 서비스입니다.');
	} else {
		if ($(".like").val() == '0') {
			/*
			 * swal({ title: "즐겨찾기에 추가하시겠습니까?", text: "나의 즐겨찾기 목록에 추가됩니다.",
			 * icon: "warning", buttons: true }).then((like_q) = { if(like_q) {
			 * swal("즐겨찾기에 추가되었습니다.", { icon: "success", }); $(this).val('1');
			 * $(this).toggleClass('on'); bookmark('1'); }else {
			 * swal("취소되었습니다."); $(this).val('0'); $(this).removeClass('on'); }
			 * });
			 */
			like_q = confirm('즐겨찾기에 추가하시겠습니까?');
			if (like_q) {
				$(this).val('1');
				$(this).toggleClass('on');
				bookmark('1');
			} else {
				$(this).val('0');
				$(this).removeClass('on');
			}
		} else {
			like_q = confirm('즐겨찾기에서 제외하시겠습니까?');
			if (like_q) {
				$(this).val('0');
				$(this).removeClass('on');
				bookmark('0');
			} else {
				$(this).val('1');
			}
		}
	}
});

// 찜하기 추가
function bookmark(val) {
	var cp_idx = $('#cp_idx').val();
	var cp_name = $('#cp_name').val();

	$.ajax({
		url : "./BookmarkAction.cp",
		data : {
			"val" : val,
			"cp_idx" : cp_idx,
			"cp_name" : cp_name
		},
		type : "POST",
		dataType : "JSON",

		success : function(data) {
			if (String(data.result) == "add_likebox_success") {
				alert('즐겨찾기에 추가되었습니다.');
				return false;
			} else if (String(data.result) == "add_likebox_fail") {
				alert('즐겨찾기 추가에 실패했습니다.\n다시 시도해주세요.');
				return false;
			} else if (String(data.result) == "remove_likebox_success") {
				alert('즐겨찾기에서 제외되었습니다.');
				return false;
			} else if (String(data.result) == "remove_likebox_fail") {
				alert('즐겨찾기 제외에 실패했습니다.\n다시 시도해주세요.');
				return false;
			}
		},
		error : function(e) {
			alert('error');
			console.log(e.responseText);
		}
	});
}

function investClick() {
	var idx = $('#idx');
	var f = document.investForm;

	if (idx) {
		// location.href='./Invest_beforeAction.cp';
		f.submit();
	} else {
		alert("로그인 후 사용해주세요.");
		// location.href='./LoginPage.mb';
	}
}

$(function() {
	var i;
	var imgArr = [ 'img/row1_anotherminae.jpg', 'img/row1_busancoffee.jpg',
			'img/row1_soinsoo.jpg', 'img/row2_bokraeheon.jpg',
			'img/row2_moon.jpg', 'img/row3_noodle.jpg',
			'img/row2_myeonchaeum.jpg' ], imgLeng = imgArr.length, $ul = $(
			'.photo').find('ul'), $div = $('.photo').find('div'), $box = $('#lightBox'), $ul2 = $box
			.find('ul'), $div2 = $box.find('div');

	for (i = 0; i < imgLeng; i++) {
		var addLi = document.createElement('li');
		addLi.style.backgroundImage = "url(" + imgArr[i] + ")";
		var addDiv = document.createElement('img');
		addDiv.src = imgArr[i];
		addDiv.className = 'corImg';
		$ul.append(addLi);
		$div.append(addDiv);
	}

	for (i = 0; i < imgLeng; i++) {
		var addLi = document.createElement('li');
		addLi.style.backgroundImage = "url(" + imgArr[i] + ")";
		addLi.setAttribute('onclick', "currentSlide(" + (i + 1) + ")");
		var addDiv = document.createElement('img');
		addDiv.src = imgArr[i];
		addDiv.className = 'corImg2';

		$ul2.append(addLi);
		$div2.append(addDiv);
	}

	document.getElementById('caption').innerHTML = slideIndex + '&nbsp;/&nbsp;'
			+ imgLeng;
	document.getElementById('caption2').innerHTML = slideIndex
			+ '&nbsp;/&nbsp;' + imgLeng;

	$ul2.find('li').eq(slideIndex - 1).addClass('on');

	$box.hide();
	$ul.find('li').eq(5).on('click', function() {
		$box.show();
	});
	$box.find('.close').on('click', function() {
		$box.hide();
	});

	$ul.find('li').on('click', function() {
		var a = $(this).index();
		switch (a) {
		case 0:
			currentSlide(1);
			break;
		case 1:
			currentSlide(2);
			break;
		case 2:
			currentSlide(3);
			break;
		case 3:
			currentSlide(4);
			break;
		case 4:
			currentSlide(5);
			break;
		}
	});

	// $ul2.find('li').on('click', function(){
	// var a = $(this).index();
	// switch(a){
	// case a : currentSlid(a+1);
	// }if(a == imgLeng){
	// break;
	// }
	// });

	setTimeout(function() {
		$('.loader').fadeOut(1000);
	}, 1000)

});

$('#lightBox ul').mousewheel(function(event, delta) {
	this.scrollLeft -= (delta * 100);
	event.preventDefault();
});

var slideIndex = 1;
showSlides();

function plusSlides(n) {
	showSlides(slideIndex += n);
}

function currentSlide(n) {
	showSlides(slideIndex = n);
}

function showSlides(n) {
	var i;
	var slides = document.getElementsByClassName("corImg");
	var slides2 = document.getElementsByClassName("corImg2");
	if (n > slides.length) {
		slideIndex = 1
	}
	if (n < 1) {
		slideIndex = slides.length
	}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
		slides2[i].style.display = "none";
	}
	slides[slideIndex - 1].style.display = "block";
	slides2[slideIndex - 1].style.display = "block";
	document.getElementById('caption').innerHTML = slideIndex + '&nbsp;/&nbsp;'
			+ slides.length;
	document.getElementById('caption2').innerHTML = slideIndex
			+ '&nbsp;/&nbsp;' + slides2.length;
	$('#lightBox').find('li').removeClass('on');
	$('#lightBox').find('li').eq(slideIndex - 1).addClass('on');

}
