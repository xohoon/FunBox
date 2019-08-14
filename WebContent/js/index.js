$(function() {
	
	
	$('header').load('./header/header.jsp');
    $('footer').load('./footer/footer.jsp');
    $('.map').load('./company/map.jsp');
    
    city_click();
    
    
	var i = 1;

    
    setInterval(function() {
      var liheight = $('.live_chart li').height();
      
      $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY(-'+ liheight*4 +'%)');
      setTimeout(function() {
        $('.live_chart li:nth-child(' + i + ') *').fadeOut(0);
        $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY('+ liheight*4 +'%)');

        $('.live_chart li:nth-child(' + i + ') a').text(cp_name_list[i-1]);
        /*변수 값 바꾸는 스크립트를 넣어주시오*/
      }, 800);
      setTimeout(function() {

        $('.live_chart span:contains(▼)').css({
          'color': '#ff9124'
        });
        $('.live_chart span:contains(▲)').css({
          'color': '#73a6d6'
        });
        $('.live_chart li:nth-child(' + i + ') *').fadeIn(0);
        $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY(0px)');

        i = i + 1;
        if (i == 11) {
          i = 1;
          //Delay_func();
        }
      }, 1000);
    }, 2000)

    $('.live_chart span:contains(▼)').css({
      'color': '#ff9124'
    });
    $('.live_chart span:contains(▲)').css({
      'color': '#73a6d6'
    });
    
	$('.gage').each(function() {
        var percent = $(this).find('.per > span').text();

        $(this).find('.gage_fill').animate({
          'width': percent + '%'
        }, 1500);
      });
  $('.location li').hover(function() {
    var classname = $(this).attr('class')
    $('#map .' + classname).css('color', 'ff9124').css('transform', 'scale(1.05)');
    }, function() {
    var classname = $(this).attr('class')
    $('#map .' + classname).css('color', '#73a6d6').css('transform', 'scale(1)');
  });
  
});

const second = 1000, minute = second * 60, hour = minute * 60, day = hour * 24;

function setCountDown(cp_idx, stopDate) {
	var timer_day = document.getElementById('timer_' + cp_idx).childNodes
			.item(1).childNodes.item(0);
	var timer_hour = document.getElementById('timer_' + cp_idx).childNodes
			.item(3).childNodes.item(0);
	var timer_minute = document.getElementById('timer_' + cp_idx).childNodes
			.item(5).childNodes.item(0);
	var timer_second = document.getElementById('timer_' + cp_idx).childNodes
			.item(7).childNodes.item(0);
	var DDay_tag = document.getElementById('DDay_' + cp_idx);
	let countDown = new Date(stopDate).getTime(),

	x = setInterval(function() {
		let now = new Date().getTime(), distance = countDown - now;
		timer_day.innerText = Math.floor(distance / (day)),
				timer_hour.innerText = Math.floor((distance % (day)) / (hour)),
				timer_minute.innerText = Math.floor((distance % (hour))
						/ (minute)), timer_second.innerText = Math
						.floor((distance % (minute)) / second)
		var Dday = Math.floor(distance / (day));
		if (Dday == 0) {
			DDay_tag.parentNode.innerText = '펀딩 기간 종료';
		} else {
			DDay_tag.innerText = Dday;
		}
	}, second)
};
function setDday(cp_idx, stopDate) {
	var DDay_tag = document.getElementById('like_DDay_' + cp_idx);
	let countDown = new Date(stopDate).getTime();
	let now = new Date().getTime();
	distance = countDown - now;
	var Dday = Math.floor(distance / (day));
	if (Dday == 0) {
		DDay_tag.parentNode.innerText = '펀딩 기간 종료';
	} else {
		DDay_tag.innerText = Dday;
	}
};

function setLikeDday(cp_idx, stopDate) {
	var DDay = document.getElementById('like_DDay_' + cp_idx);
	let countDown = new Date(stopDate).getTime();
	let now = new Date().getTime();
	distance = countDown - now;

	var DdayCount = Math.floor(distance / (day));

	if (DdayCount <= 0) {
		DDay.parentElement.innerText = "편딩 기간 종료"
	} else {
		DDay.innerText = DdayCount;
	}
};
function setDday(cp_idx, stopDate) {
	var DDay_tag = document.getElementById('like_DDay_' + cp_idx);
	let countDown = new Date(stopDate).getTime();
	let now = new Date().getTime();
	distance = countDown - now;
	var Dday = Math.floor(distance / (day));
	if (Dday == 0) {
		DDay_tag.parentNode.innerText = '펀딩 기간 종료';
	} else {
		DDay_tag.innerText = Dday;
	}
};

function city_click() {
	$(".local01").on('click', function() {
		if($("#seoul_count").text() != 0) {
			location.href="./ListAction.bd?cityName=10";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local02").on('click', function() {
		if($("#gyeonggi_count").text() != 0) {
			location.href="./ListAction.bd?cityName=11";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});$(".local03").on('click', function() {
		if($("#incheon_count").text() != 0) {
			location.href="./ListAction.bd?cityName=12";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local04").on('click', function() {
		if($("#gangwon_count").text() != 0) {
			location.href="./ListAction.bd?cityName=13";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local05").on('click', function() {
		if($("#daejeonNchungcheong_count").text() != 0) {
			location.href="./ListAction.bd?cityName=14";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local06").on('click', function() {
		if($("#daegu_count").text() != 0) {
			location.href="./ListAction.bd?cityName=15";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local07").on('click', function() {
		if($("#busan_count").text() != 0) {
			location.href="./ListAction.bd?cityName=16";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local08").on('click', function() {
		if($("#ulsan_count").text() != 0) {
			location.href="./ListAction.bd?cityName=17";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local09").on('click', function() {
		if($("#gyeongsang_count").text() != 0) {
			location.href="./ListAction.bd?cityName=18";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local10").on('click', function() {
		if($("#gwangjuNjeonla_count").text() != 0) {
			location.href="./ListAction.bd?cityName=19";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
	$(".local11").on('click', function() {
		if($("#jeju_count").text() != 0) {
			location.href="./ListAction.bd?cityName=20";
		}else {
			alert("검색 결과가 존재하지 않습니다.");
		}
	});
}