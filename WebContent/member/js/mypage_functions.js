	
	function mypage4_1_check(){
		var f = document.mypage4_1_form;
		// 특수문자/문자/숫자 포함 형태의 8~15 이내의 비밀번호 정규식
		var pw = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		
		if(f.pw.value == ''){
			alert('비밀번호를 입력해주세요.');
			f.pw.focus();
			return false;
		}else if(!pw_check(pw, f.pw, "비밀번호는 8~15자리의 영문,숫자,특수문자 사용만 가능합니다.")){
			return false;
		}else{
			password_check(f.pw.value);
		}
	}
	
	function pw_check(re, what, message) {
		if(re.test(what.value)) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
	}
	
	function press_event(){
		if(window.event.keyCode == 13){ //javascript에서는 13이 enter키를 의미함 
			mypage4_1_check();
			//document.login_form.submit(); //formname에 사용자가 지정한 form의 name입력 
		}
	}

	function password_check(pw){
		var f = document.mypage4_1_form;

		$.ajax({
			url : "./MypagePWCheckAction.mb",
			data : {
				"pw" : pw
			},
			type : "POST",
			dataType : "JSON",
			
			success : function(data){
				if(String(data.result) == "confirm_pw_success"){
					f.submit();
				}else{
					alert('비밀번호가 일치하지 않습니다.');
				}
			}
		})
	}
	
	
	
/////////////////////////////////////////// 태훈 추가////////////////////////

/*var sessionID; 
$(document).ready(function() {
	invest_click();
});

function invest_click() {
	$("#invest_check").on('click', function() {
		invest_chk_ajax();
	});
}

function invest_chk_ajax() {
		$.ajax({
			type: "POST",
			url: "./MemberInvestcheck.mb",
			dataType: "json",
			contentType: "application/x-www-form-urlencoded;charset=utf-8",
			data: {},
			success: function(resultData, result, response) {
				if(resultData.mi_idx != -1 ) {
					location.href="./MemberInvestmentList.mb?mi_idx="+resultData.mi_idx;
				}else {
					alert("투자현황이 존재하지 않습니다. 기업에 투자해보세요");
					location.href="./ListAction.bd";
				}
			},
			error: function(request, status, error){
				console.log("request>>"+request);
				console.log("status>>"+status);
				console.log("error>>" +error);
			}
		});
}*/// 옮김 investment_status.js 로
/////////////////////////////////////////// 태훈 추가////////////////////////
