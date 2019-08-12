///////////////////////////////////////////////////통신 객체 생성///////////////////////////////////////////////////
var httpRequest_join = null;

// httpRequest 객체 생성
function getXMLHttpRequest_join() {
	var httpRequest_join = null;

	if (window.ActiveXObject) {
		try {
			httpRequest_join = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				httpRequest_join = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				httpRequest_join = null;
			}
		}
	} else if (window.XMLHttpRequest) {
		httpRequest_join = new window.XMLHttpRequest();
	}
	return httpRequest_join;
}
// /////////////////////////////////////////////////통신 객체 생성///////////////////////////////////////////////////

// ///////////////////////////////////////////////////헨드폰 중복 여부////////////////////////////////////////////
function check_to_phone() {
	var f = document.join_form;
	var keyword = f.ph.value;
	var phone_number = document.getElementById('phone_number');

	var num = /^[0-9]+$/; // 숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; // 휴대전화번호 정규식

	if (keyword == '') {
		alert("휴대폰 번호를 입력해 주세요.");
		return false;
	} else if (!ph_check(num, f.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if (!ph_check(phEx, f.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else {
		phone_number.value = keyword;

		var params = "ph=" + encodeURI(keyword);

		/* sendRequest("./id_check.jsp", params, displayResult, 'POST'); */
		httpRequest_join = getXMLHttpRequest_join();
		httpRequest_join.onreadystatechange = displayResult_phone;
		httpRequest_join.open("POST", "./check_page/check_to_phone.jsp", true);
		httpRequest_join.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		httpRequest_join.send(params);

	}
}

// 휴대폰 중복체크 결과를 화면에 보여주는 함수.
function displayResult_phone() {

	if (httpRequest_join.readyState == 4) {
		if (httpRequest_join.status == 200) {
			var resultText = httpRequest_join.responseText;
			var f = document.join_form;

			if (resultText.indexOf("사용가능") > -1) {
				// 문자 전송 코드
				sms_code_send(f.ph.value);
			} else if (resultText.indexOf("중복됨") > -1) {
				alert("이미 사용중인 번호입니다.");
				return;
			}
		} else {
			alert("error: " + httpRequest_join.status);
		}
	}
}
///////////////////////////////////////////////////헨드폰 중복여부////////////////////////////////////////////

///////////////////////////////////////////////////회원가입 유효성 검사////////////////////////////////////////////

function fn_press_sub_capital(obj) {
	if (event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37
			|| event.keyCode == 39 || event.keyCode == 46)
		return false;
	obj.value = obj.value.replace(
			/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi, '');
	obj.value = obj.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, '');
	obj.value = obj.value.replace(/[A-Z]/g, '');
}

// id 중복체크 변수
var id_duplication_check = false;
// 문자 인증체크 변수
var sms_certification_check = false;
// 추천인 체크 변수
var recom_check = false;

// id 중복체크 함수
function id_ch() {
	var f = document.join_form;
	var sendId = f.id.value;
	var re = /^[a-z]+[a-z0-9]{5,}$/g;
	// 아이디 정규식//영문/숫자 허용, 6~15 이내의 아이디 정규식
	var blank_pattern = /[\s]/g; // 공백 체크

	if (!sendId) {
		f.id.focus();
		alert('사용할 아이디를 입력해주세요.');
		return false;
	} else if (blank_pattern.test(f.id.value)) {
		alert('아이디는 공백을 포함할 수 없습니다.');
		f.id.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
		return false;
	} else if (!id_check(re, f.id, "아이디는 6~15자리의 영문,숫자 사용만 가능합니다.")) {
		return false;
	} else {
		idCheck_result(sendId);
	}
}

function idCheck_result(sendId) {
	$.ajax({
		url : "./MemberIDCheckAction.mb",
		data : {
			"sendId" : sendId
		},
		type : "POST", // get post둘중하나
		dataType : "JSON", // 데이터타입을 json 으로 받아옴

		success : function(data) {
			if (String(data.result) == "id_check_fail") {
				alert('사용 불가능한 아이디 입니다.');
				return false;
			} else {
				id_duplication_check = true;
				alert('사용 가능한 아이디 입니다.');
			}
		},
		error : function(e) {
			alert('사용 불가능한 아이디 입니다.');
			console.log(e.responseText);
		}
	});
}

function id_false_check() {
	id_duplication_check = false;
}
function phone_false_check() {
	sms_certification_check = false;
}
function recom_false_check() {
	recom_check = false;
}

// 문자인증 함수
function sms_code_send(ph) {

	$.ajax({
		url : "./MemberPhoneCheckAction.mb",
		data : {
			"ph" : ph
		},
		type : "POST", // get post둘중하나
		dataType : "JSON", // 데이터타입을 json 으로 받아옴

		success : function(data) {
			if (String(data.result) == "sms_fail") {
				alert('문자 전송에 실패했습니다.\n다시 시도해주세요.');
				return false;
			} else {
				sms_certification_check = true;
				document.getElementById("phone_code").value = data.key;
				alert('문자 전송을 완료했습니다.\n인증코드를 입력해주세요.');
			}
		},
		error : function(e) {
			alert('문자 전송에 실패했습니다.\n다시 시도해주세요.');
			console.log(e.responseText);
		}
	});
}

function recommender_check() {
	recom_check = false;
	var f = document.join_form;
	var recomId = f.reco.value;
	var rec = /^[a-z]+[a-z0-9]{5,}$/g;

	if (!reco_check(rec, f.reco, "추천인 아이디는 6~15자리의 영문,숫자 사용만 가능합니다.")) {
		return false;
	} else {
		recommender_check_result(recomId);
	}
}

function recommender_check_result(recomId) {
	$.ajax({
		url : "./MemberIDCheckAction.mb",
		data : {
			"sendId" : recomId
		},
		type : "POST", // get post둘중하나
		dataType : "JSON", // 데이터타입을 json 으로 받아옴

		success : function(data) {
			if (String(data.result) == "id_check_success") {
				// document.getElementById('recom_check').innerHTML = '추천인의 아이디를
				// 올바르게 입력해주세요.';
				alert('추천인의 아이디를 올바르게 입력해주세요.');
			} else {
				recom_check = true;
				// document.getElementById('recom_check').innerHTML = '존재하는 추천인
				// 입니다.';
				alert('존재하는 추천인 입니다.');
			}
		},
		error : function(e) {
			alert('사용 불가능한 추천인 아이디 입니다.');
			console.log(e.responseText);
		}
	});
}

function certification_check() {
	var f = document.join_form;

	var phone_code = document.getElementById('phone_code');
	var phone_number = document.getElementById('phone_number');

	if (f.verti_num.value == '') {
		alert('전송받은 인증번호를 입력해주세요.');
		f.verti_num.focus();
		return false;
	} else if (phone_code.value != f.verti_num.value) {
		alert('잘못된 인증번호 입니다.');
		f.verti_num.focus();
		return false;
	} else if (f.ph.value != phone_number.value) {
		f.ph.focus();
		alert('인증받은 휴대전화번호를 입력해주세요.');
		return false;
	} else {
		alert('인증번호가 확인되었습니다.');
	}
}

/*function tx_check(){
var f = document.join_form;

// 특수문자/문자/숫자 포함 형태의 8~15 이내의 비밀번호 정규식
var pw =  /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
// 공백 체크
var blank_pattern = /[\s]/g;

if (f.tx.value == '') {
	alert('TX비밀번호를 입력해주세요.');
	f.tx.focus();
	return false;
} else if(blank_pattern.test(f.tx.value)){
	alert('TX비밀번호는 공백을 포함할 수 없습니다.');
	f.tx.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
	return false;
} else if (!pw_check(pw, f.tx, "tx비밀번호는 8~15자리의 영문,숫자,특수문자 사용만 가능합니다.")) {
	return false;
} else{
	alert('사용가능한 tx비밀번호입니다.');
}
}*/


function join_check() {
	var f = document.join_form;

	// 특수문자/문자/숫자 포함 형태의 8~15 이내의 비밀번호 정규식
	var pw = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	// 한글과 영문만 가능
	var name = /[^a-zA-Z가-힣]/;
	var num = /^[0-9]+$/; // 숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; // 휴대전화번호 정규식
	var pinEx = /\d{6}$/g; // pin code 정규식
	// 이메일 정규식
	var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 공백 체크
	var blank_pattern = /[\s]/g;

	var phone_code = document.getElementById('phone_code');
	var phone_number = document.getElementById('phone_number');

	// 약관동의란 체크값
	var agree1 = f.ag1.checked;
	var agree2 = f.ag2.checked;
//	var agree3 = f.ag3.checked;

	if (f.id.value == '') {
		alert('사용할 아이디를 입력해주세요.');
		f.id.focus();
		return false;
	} else if (blank_pattern.test(f.id.value)) {
		alert('아이디는 공백을 포함할 수 없습니다.');
		f.id.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
		return false;
	} else if (!id_duplication_check) {
		alert('아이디 중복 확인을 해주세요.');
		f.id.focus();
		return false;
	} else if (f.pw.value == '') {
		alert('비밀번호를 입력해주세요.');
		f.pw.focus();
		return false;
	} else if (blank_pattern.test(f.pw.value)) {
		alert('비밀번호는 공백을 포함할 수 없습니다.');
		f.pw.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
		return false;
	} else if (!pw_check(pw, f.pw, "비밀번호는 8~15자리의 영문,숫자,특수문자 사용만 가능합니다.")) {
		return false;
	} else if (f.pwc.value == '' || f.pwc.value != f.pw.value) {
		alert('비밀번호를 정확히 입력해주세요.');
		f.pwc.value = "";
		f.pwc.focus();
		return false;
	} else if (f.pin.value == '') {
		alert('Pin code를 입력해주세요.');
		f.pin.focus();
		return false;
	} else if (blank_pattern.test(f.pin.value)) {
		alert('Pin code는 공백을 포함할 수 없습니다.');
		f.pin.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
		return false;
	} else if (!pin_check(num, f.pin, "Pin code는 숫자만 등록가능합니다.")) {
		return false;
	} else if (!pin_check(pinEx, f.pin, "Pin code는 숫자 6자리 등록가능합니다.")) {
		return false;
	} else if (f.pinch.value == '' || f.pinch.value != f.pin.value) {
		alert('Pin code를 정확히 입력해주세요.');
		f.pinch.value = "";
		f.pinch.focus();
		return false;
	} else if (f.email.value == '') {
		alert('이메일을 입력해주세요.');
		f.email.focus();
		return false;
	} else if (!email_check(email, f.email, "적합하지 않은 이메일 형식입니다.")) {
		return false;
	} else if (f.name.value == '') {
		alert('이름을 입력해주세요.');
		f.name.focus();
		return false;
	} else if (!name_check(name, f.name, "적합하지 않은 이름 형식입니다.")) {
		return false;
	} else if (f.ph.value == '') {
		sms_certification_check = false;
		alert('휴대전화번호를 입력해주세요.');
		f.ph.focus();
		return false;
	} else if (!ph_check(num, f.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!ph_check(phEx, f.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else if(!sms_certification_check){
		alert('문자인증을 해주세요.');
		f.ph.focus();
		return false;
	} else if (f.verti_num.value == '') {
		alert('전송받은 인증번호를 입력해주세요.');
		f.verti_num.focus();
		return false;
	} else if(phone_code.value != f.verti_num.value){
		alert('올바른 인증번호를 입력해주세요.');
		f.verti_num.focus();
		return false;
	} else if(f.ph.value != phone_number.value){
		f.ph.focus();
		alert('인증받은 휴대전화번호를 입력해주세요.');
		return false;
	} else if (f.add_num.value == '' || f.add_ch.value == '') {
		alert('주소를 입력해주세요.');
		f.add_num.focus();
		return false;
	} else if (f.add_more.value == '') {
		alert('상세주소를 입력해주세요.');
		f.add_more.focus();
		return false;
	} else if (blank_pattern.test(f.reco.value)) {
		alert('추천인 아이디는 공백을 포함할 수 없습니다.');
		f.reco.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
		return false;
	} else if (f.reco.value != '' && recom_check == false) {
		alert('올바른 추천인 아이디를 입력해주세요.');
		f.reco.focus();
		return false;
	} else if (!agree1) {
		alert('서비스이용약관에 동의하지 않았습니다.');
		return false;
	} else if (!agree2) {
		alert('개인정보처리방침에 동의하지 않았습니다.');
		return false;
	} /*else if(!agree3){
		alert('마케팅 정보수집 및 활용에 동의하지 않았습니다.');
		return false;
	}*/ else {
		f.submit();
	}

}

// 정규식 결과 리턴 함수
function reco_check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}
function name_check(re, what, message) {
	if (!re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}
function id_check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}
function email_check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}
function ph_check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}
function pw_check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}
function pin_check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
}



function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

$(window).on('resize',function(){
    var winh = $(window).height();
    $('.pol').height(winh);
});
  
  $(function(){
      $('#agree1').click(function(){
          $('.pol').removeClass('on');
          $('.policy1').addClass('on');
      });
      $('#agree2').click(function(){
          $('.pol').removeClass('on');
          $('.policy2').addClass('on');
      });
      $('#agree3').click(function(){
          $('.pol').removeClass('on');
          $('.policy3').addClass('on');
      });
      $('.pol .closer').click(function(){
          $('.pol').removeClass('on');
      });
		/* $('.add_btn').click(function(){
			$('.sch_address').addClass('on');
		});
		$('.sch_address .closer').click(function(){
          $('.sch_address').removeClass('on');
      }); */
  });      
// ///////////////////////////////////////////////////회원가입 유효성 검사////////////////////////////////////////////
