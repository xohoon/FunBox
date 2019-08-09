

/////////////////////////// 유정 추가 ///////////////////////////
function invest_after_check(){
	var f = document.invest_after_form;
	
	// 약관동의란 체크값
	var agree = f.agree.checked;
	
	if (!agree){
		alert('이용약관에 동의하지 않았습니다.');
		return false;
	}else if (f.pincode1.value == '') {
		alert('PINCODE를 입력해주세요.');
		f.pincode1.focus();
		return false;
	}else if (f.pincode2.value == '') {
		alert('PINCODE를 입력해주세요.');
		f.pincode2.focus();
		return false;
	}else if (f.pincode3.value == '') {
		alert('PINCODE를 입력해주세요.');
		f.pincode3.focus();
		return false;
	}else if (f.pincode4.value == '') {
		alert('PINCODE를 입력해주세요.');
		f.pincode4.focus();
		return false;
	}else if (f.pincode5.value == '') {
		alert('PINCODE를 입력해주세요.');
		f.pincode5.focus();
		return false;
	}else if (f.pincode6.value == '') {
		alert('PINCODE를 입력해주세요.');
		f.pincode6.focus();
		return false;
	}else{
	    $('.confirm').fadeIn(300);
	    $('body').css('overflow', 'hidden');
	}
}



// 기존 핀코드를 정확하게 입력했는지 확인합니다.
function pincode_check(){
	var f = document.invest_after_form;
	var pincode = f.pincode1.value + f.pincode2.value + f.pincode3.value
			+ f.pincode4.value + f.pincode5.value + f.pincode6.value;
	
	$.ajax({
		url : "./MypagePINCheckAction.mb",
		data : {
			"pin" : pincode
		},
		type : "POST",
		dataType : "JSON",
		
		success : function(data){
			if(String(data.result) == "confirm_pin_fail"){
				alert('PIN이 일치하지 않습니다.');
				history.go(0);
				f.pin.focus();
				return false;
			}else{
				f.submit();
			}
		}
	})
}
/////////////////////////// 유정 추가 ///////////////////////////