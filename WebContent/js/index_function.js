////////////////태훈 추가 - 메인페이지 실시간 순위
/*
$(document).ready(function() {
	main_list();
	realtime_like();
});
*/
var select_key = null;

function realtime_like() {
	select_key = $('#select_k').val();
	timer = setInterval(function() {
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
						var real_list = {
								cp_name1: val.cp_name1,
								cp_name2: val.cp_name2,
								cp_name3: val.cp_name3,
								cp_name4: val.cp_name4,
								cp_name5: val.cp_name5,
								cp_name6: val.cp_name6,
								cp_name7: val.cp_name7,
								cp_name8: val.cp_name8,
								cp_name9: val.cp_name9,
								cp_name10: val.cp_name10
						}
					});
					console.log("successDATA:::"+val.cp_name1);
					console.log("successDATA:::"+val.cp_name2);
					console.log("successDATA:::"+val.cp_name3);
					console.log("successDATA:::"+val.cp_name4);
					console.log("successDATA:::"+val.cp_name5);
					console.log("successDATA:::"+val.cp_name6);
					console.log("successDATA:::"+val.cp_name7);
					console.log("successDATA:::"+val.cp_name8);
					console.log("successDATA:::"+val.cp_name9);
					console.log("successDATA:::"+val.cp_name10);
					view_list(real_list);
				}else if(data == null) {
					console.log("데이터없어 왜???");
				}
			},
			error: function(error, request, status) {
				
			}
		});
	}, 10000);
}
function view_list(real_list) {
	$('.list_ul').append(
				"<li>"
	            +"<span>1</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name1+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>2</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name2+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>3</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name3+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>4</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name4+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>5</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name5+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>6</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name6+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>7</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name7+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>8</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name8+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>9</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name9+"</a>"
	            +"<span>-</span>"
	            +"</li>"
	            +"<li>"
	            +"<span>1</span>&nbsp;"
	            +"<a href=\"#\">"+real_list.cp_name10+"</a>"
	            +"<span>-</span>"
	            +"</li>"
			);
	
}

function main_list() {
	window.onload = function () {
		view_list(real_list);
	}
}


/*
timerOn = false;
expnowminsec = 0;
// Ajax 통신중인지를 확인하는 전역변수 설정

// Ajax 요청 이전에 확인하는 timer() 함수를 생성
timer = function(delay) {
   var delayVal = delay || 10000;
   if (timerOn) {
      // timer에 현재시간을 설정
      nowTime = new Date;
      nowmin = nowTime.getMinutes()*60*1000;
      nowsec = nowTime.getSeconds() * 1000;
      nowmillisec = nowTime.getMilliseconds();
      nowminsec = nowmin + nowsec + nowmillisec;
   }
   else {
      nowTime = new Date;
      nowmin = nowTime.getMinutes()*60*1000;
      nowsec = nowTime.getSeconds() * 1000;
      nowmillisec = nowTime.getMilliseconds();
      expnowminsec = nowmin + nowsec + nowmillisec + delay;
      timerOn = true;
      return true;
    }

    if (((timerOn)) && (expnowminsec != 0) && (expnowminsec != '')) {
       if (expnowminsec <= nowminsec) {
           timerOn = false;
           expnowminsec = 0;
           return false;
       }
       else {
          timerOn = true;
          return true;
       }
    }
    timerOn = true;
    return true;
}
*/
