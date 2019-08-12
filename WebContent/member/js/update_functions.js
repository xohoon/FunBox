 	///////////////////////////////////////////////////통신 객체 생성///////////////////////////////////////////////////
    var httpRequest_join = null;
	
	
	
	//httpRequest 객체 생성
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
	///////////////////////////////////////////////////통신 객체 생성///////////////////////////////////////////////////
	
	
	
	/////////////////////////////////////////////////////헨드폰 중복 여부////////////////////////////////////////////
	function check_to_phone() {
		var f = document.mypage4_2_form;
		var keyword = f.new_ph.value;
		var phone_number = document.getElementById('phone_number');
		
		var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
		var phEx = /\d{11}$/g; //휴대전화번호 정규식
	
		if (keyword == '') {
			alert("휴대폰 번호를 입력해 주세요.");
			return false;
		} else if (!ph_check(num, f.new_ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
			return false;
		} else if(!ph_check(phEx, f.new_ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
			return false;
		} else {
			phone_number.value = keyword;
			
			var params = "ph=" + encodeURI(keyword);
				
			/* sendRequest("./id_check.jsp", params, displayResult, 'POST'); */
			httpRequest_join = getXMLHttpRequest_join();
			httpRequest_join.onreadystatechange = displayResult_phone;
			httpRequest_join.open("POST", "./check_page/check_to_phone.jsp", true);
			httpRequest_join.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			httpRequest_join.send(params);
			
		}
	}
	
	
	
	//휴대폰 중복체크 결과를 화면에 보여주는 함수.
	function displayResult_phone() {
		
		if (httpRequest_join.readyState == 4) {
			if (httpRequest_join.status == 200) {
				var resultText = httpRequest_join.responseText;
				var f = document.mypage4_2_form;
												
				if (resultText.indexOf("사용가능") > -1) {
					//문자 전송 코드
					sms_code_send(f.new_ph.value);
				} else if(resultText.indexOf("중복됨") > -1){
					alert("이미 사용중인 번호입니다.");
					return;
				}
			} else {
				alert("error: " + httpRequest_join.status);
			}
		}
	}
	/////////////////////////////////////////////////////헨드폰 중복여부////////////////////////////////////////////
	
	
	
	/////////////////////////////////////////////////////개인정보수정 유효성 검사////////////////////////////////////////////
	    	
	//문자 인증체크 변수
	var sms_certification_check = false;
		
	function phone_false_check(){
		sms_certification_check = false;
	}
	
	//문자인증 함수
	function sms_code_send(ph) {
		
		$.ajax({
			url : "./MemberPhoneCheckAction.mb",
			data : {
				"ph" : ph
			},
			type : "POST", //get post둘중하나
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
	
	
	function certification_check(){
		var f = document.mypage4_2_form;
		
		var phone_code = document.getElementById('phone_code');
		var phone_number = document.getElementById('phone_number');
		
		if (f.verti_num.value == '') {
			alert('전송받은 인증번호를 입력해주세요.');
			f.verti_num.focus();
			return false;
		} else if(phone_code.value != f.verti_num.value){
			alert('잘못된 인증번호 입니다.');
			f.verti_num.focus();
			return false;
		} else if(f.new_ph.value != phone_number.value){
			f.new_ph.focus();
			alert('인증받은 휴대전화번호를 입력해주세요.');
			return false;
		}else{
			alert('인증번호가 확인되었습니다.');
		} 
	}
	
	
	
	
	// 개인정보수정
	function update_check(){
		var f = document.mypage4_2_form;
		
		if(f.pw.value != '' && f.new_pw.value != ''
			&& f.pin.value != '' && f.new_pin.value != ''){
			pw_pin_check(f.pw.value, f.pin.value);
		}else if(f.pw.value != '' && f.new_pw.value != ''){
			password_check(f.pw.value);
		}else if(f.pin.value != '' && f.new_pin.value != ''){
			pincode_check(f.pin.value);
		}else{
			update_check2();
		}
	}
	
	
	// 유효성 검사
	function update_check2(){
		var f = document.mypage4_2_form;
		// 특수문자/문자/숫자 포함 형태의 8~15 이내의 비밀번호 정규식
		var pw =  /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		var num = /^[0-9]+$/; // 숫자만 입력(휴대폰 번호)
		var phEx = /\d{11}$/g; //휴대전화번호 정규식
		var pinEx = /\d{6}$/g; //pin code 정규식
		// 이메일 정규식
		var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		// 공백 체크
		var blank_pattern = /[\s]/g;
		
		if($('#rev_pw').val() == '취소' && f.pw.value == '' && f.new_pw.value == ''){
			alert('변경할 비밀번호를 입력해주세요.');
			return false;
		} else if($('#rev_pw').val() == '수정하기' && f.pw.value != '' && f.new_pw.value != ''){
			alert('비밀번호 수정하기 버튼을 눌러주세요.');
			return false;
		} else if (f.pw.value != '' && f.new_pw.value == '') {
			alert('새 비밀번호를 입력해주세요.');
			f.new_pw.focus();
			return false;
		} else if (f.pw.value == '' && f.new_pw.value != '') {
			alert('비밀번호를 입력해주세요.');
			f.pw.focus();
			return false;
		} else if(f.pw.value != '' && blank_pattern.test(f.new_pw.value)){
			alert('비밀번호는 공백을 포함할 수 없습니다.');
			f.new_pw.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
			return false;
		} else if (f.pw.value != '' && !pw_check(pw, f.new_pw, "비밀번호는 8~15자리의 영문,숫자,특수문자 사용만 가능합니다.")) {
			return false;
		} else if($('#rev_pin').val() == '취소' && f.pin.value == '' && f.new_pin.value == ''){
			alert('변경할 Pin code를 입력해주세요.');
			return false;
		} else if($('#rev_pin').val() == '수정하기' && f.pin.value != '' && f.new_pin.value != ''){
			alert('Pin code 수정하기 버튼을 눌러주세요.');
			return false;
		} else if (f.pin.value != '' && f.new_pin.value == '') {
			alert('새 Pin code를 입력해주세요.');
			f.new_pin.focus();
			return false;
		} else if (f.pin.value == '' && f.new_pin.value != '') {
			alert('Pin code를 입력해주세요.');
			f.pin.focus();
			return false;
		} else if(f.pin.value != '' && blank_pattern.test(f.new_pin.value)){
			alert('Pin code는 공백을 포함할 수 없습니다.');
			f.new_pin.focus(); // 텍스트 창의 경우, 커서를 위치시켜 바로 입력이 가능합니다.
			return false;
		} else if (f.pin.value != '' && !pin_check(num, f.new_pin, "Pin code는 숫자만 등록가능합니다.")) {
			return false;
		} else if (f.pin.value != '' && !pin_check(pinEx, f.new_pin, "Pin code는 숫자 6자리 등록가능합니다.")) {
			return false;
		} else if($('#rev_mail').val() == '취소' && f.new_mail.value == ''){
			alert('변경할 이메일을 입력해주세요.');
			return false;
		} else if ($('#rev_mail').val() == '취소' && f.new_mail.value != '' && !email_check(email, f.new_mail, "적합하지 않은 이메일 형식입니다.")) {
			return false;
		} else if($('#rev_mail').val() == '수정하기' && f.new_mail.value != ''){
			alert('이메일 수정하기 버튼을 눌러주세요.');
			return false;
		} else if($('#rev_ph').val() == '취소' && f.new_ph.value == ''){
			alert('변경할 휴대전화번호를 입력해주세요.');
			return false;
		} else if($('#rev_ph').val() == '수정하기' && f.new_ph.value != ''){
			alert('휴대전화번호 수정하기 버튼을 눌러주세요.');
			return false;
		} else if(f.new_ph.value != '' && !ph_check(num, f.new_ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
			return false;
		} else if(f.new_ph.value != '' && !ph_check(phEx, f.new_ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
			return false;
		} else if(f.new_ph.value != '' && !sms_certification_check){
			alert('문자인증을 해주세요.');
			f.new_ph.focus();
			return false;
		} else if (f.new_ph.value != '' && f.verti_num.value == '') {
			alert('전송받은 인증번호를 입력해주세요.');
			f.verti_num.focus();
			return false;
		} else if(f.new_ph.value != '' && phone_code.value != f.verti_num.value){
			alert('올바른 인증번호를 입력해주세요.');
			f.verti_num.focus();
			return false;
		} else if(f.new_ph.value != '' && f.new_ph.value != phone_number.value){
			f.new_ph.focus();
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
		} else {
			f.submit();
		}
	}
	
	

	//정규식 결과 리턴 함수
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
	
	

	// 기존 비밀번호를 정확하게 입력했는지 확인합니다.
	function password_check(pw){
		var f = document.mypage4_2_form;

		$.ajax({
			url : "./MypagePWCheckAction.mb",
			data : {
				"pw" : pw
			},
			type : "POST",
			dataType : "JSON",
			
			success : function(data){
				if(String(data.result) == "confirm_pw_fail"){
					alert('비밀번호가 일치하지 않습니다.');
					f.pw.focus();
					return false;
				}else{
					update_check2();
				}
			}
		})
	}
	
	
	// 기존 핀코드를 정확하게 입력했는지 확인합니다.
	function pincode_check(pin){
		var f = document.mypage4_2_form;

		$.ajax({
			url : "./MypagePINCheckAction.mb",
			data : {
				"pin" : pin
			},
			type : "POST",
			dataType : "JSON",
			
			success : function(data){
				if(String(data.result) == "confirm_pin_fail"){
					alert('PIN이 일치하지 않습니다.');
					f.pin.focus();
					return false;
				}else{
					update_check2();
				}
			}
		})
	}
	
	
	// 기존 비밀번호와 핀코드를 정확하게 입력했는지 확인합니다.
	function pw_pin_check(pw, pin){
		var f = document.mypage4_2_form;

		$.ajax({
			url : "./MypagePWPINCheckAction.mb",
			data : {
				"pw" : pw,
				"pin" : pin
			},
			type : "POST",
			dataType : "JSON",
			
			success : function(data){
				if(String(data.result) == "confirm_pw_fail"){
					alert('비밀번호가 일치하지 않습니다.');
					f.pw.focus();
					return false;
				}else if(String(data.result) == "confirm_pin_fail"){
					alert('PIN이 일치하지 않습니다.');
					f.pin.focus();
					return false;
				}else{
					update_check2();
				}
			}
		})
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

	/////////////////////////////////////////////////////개인정보수정 유효성 검사////////////////////////////////////////////