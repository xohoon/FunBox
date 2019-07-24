/**
 * 
 */


function send_id_sms(){	

	var phone = document.find_id.ph.value;
	
	var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; //휴대전화번호 정규식
	
	if(phone==''){
		alert('휴대폰 번호를 입력하세요.');
		return false;
	} else if (!check(num, find_id.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!check(phEx, find_id.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	}
		
	$.ajax({
        url : "./FindSms", // FindSms 에서 받아옴
        data : {
        	"phone" : phone
        },
        type : "POST", // get post둘중하나
        dataType : "JSON", // 데이터타입을 json 으로 받아옴
        success : function(data) {
        	if(String(data.result)=="sms_fail"){
        		alert('error');
        		return false;
        	}else {
        		document.getElementById("find_id_key").value = data.key;
        		alert('문자 전송 완료');
        	}
        },
        error : function(e) {
        	alert('통신 실패');
            console.log(e.responseText);
        }
    });
	
}


function send_pw_sms(){

	var phone = document.find_pw.ph.value;
	var mb_id = document.find_pw.id.value;
	
	var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; //휴대전화번호 정규식
	
	if(phone==''){
		alert('휴대폰 번호를 입력하세요.');
		return false;
	} else if (!check(num, find_pw.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!check(phEx, find_pw.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else if(mb_id==''){
		alert('아이디를 입력하세요.');
		return false;
	}
	
	$.ajax({
        url : "./FindSms", // FindSms 에서 받아옴
        data : {
        	"phone" : phone
        },
        type : "POST", // get post둘중하나
        dataType : "JSON", // 데이터타입을 json 으로 받아옴
       
        success : function(data) {
        	if(String(data.result)=="sms_fail"){
        		alert('error');
        		return false;
        	}else {
        		document.getElementById("find_pw_key").value = data.key;
        	alert('문자 전송 완료');
        	}
        },
        error : function(e) {
        	alert('통신 실패');
            console.log(e.responseText);
        }
    });
	
}



function send_tx_sms(){

	var phone = document.find_tx.ph.value;
	var mb_id = document.find_tx.id.value;
	var mb_pw = document.find_tx.pw.value;
	
	var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; //휴대전화번호 정규식

	if(phone==''){
		alert('휴대폰 번호를 입력하세요.');
		return false;
	} else if (!check(num, find_tx.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!check(phEx, find_tx.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else if(mb_id==''){
		alert('아이디를 입력하세요.');
		return false;
	} else if(mb_pw==''){
		alert('비밀번호를 입력하세요.');
		return false;
	}
		
	$.ajax({
        url : "./FindSms", // FindSms 에서 받아옴
        data : {
        	"phone" : phone
        },
        type : "POST", // get post둘중하나
        dataType : "JSON", // 데이터타입을 json 으로 받아옴
       
        success : function(data) {
        	if(String(data.result)=="sms_fail"){
        		alert('error');
        		return false;
        	}else {
        		document.getElementById("find_tx_key").value = data.key;
        	alert('문자 전송 완료');
        	}
        },
        error : function(e) {
        	alert('통신 실패');
            console.log(e.responseText);
        }
    });
	
}



function find_id_confirm() {
	
	var form = document.find_id;
	var phone = form.ph.value;
	var name = form.name.value;
	var verti_num = form.verti_num.value;
		
	var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; //휴대전화번호 정규식

	if(name==''){
		alert('이름을 입력해 주세요.');
		return false;
	} else if(phone==''){
		alert('휴대폰 번호를 입력하세요.');
		return false;
	} else if (!check(num, form.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!check(phEx, form.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else if(verti_num==''){
		alert('인증번호를 입력해주세요.');
		return false;
	} else if(verti_num!=form.find_id_key.value){
		alert('잘못된 인증번호 입니다.');
		return false;
	} else{
		
		$.ajax({
	        url : "./FindIdView", // FindSms 에서 받아옴
	        data : {
	        	"phone" : phone,
	        	"name" : name
	        },
	        type : "POST", // get post둘중하나
	        dataType : "JSON", // 데이터타입을 json 으로 받아옴
	       
	        success : function(data) {
	        	if(String(data.result)=="find_id_fail"){
	        		
	        		document.getElementById("name").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		
	        		alert('해당 정보의 계정이 존재하지 않습니다.');
	        		return false;
	        	}else {
	        		
	        		document.getElementById("name").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		
	        	alert('회원님의 아이디는 '+data.newid+ '입니다.');
	        	
	        	}
	        },
	        error : function(e) {
	        	alert('통신 실패');
	            console.log(e.responseText);
	        }
	    });
		
		
	}
	
}




//비밀번호 찾기 유효성
function find_pw_confirm() {
	
	var form = document.find_pw;
	var phone = form.ph.value;
	var mb_id = form.id.value;
	var verti_num = form.verti_num.value;
	
	var re =  /^[a-z]+[a-z0-9]{5,}$/g;
	var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; //휴대전화번호 정규식
	
	if(mb_id==''){
		alert('아이디를 입력해주세요.');
		return false;
	} else if(!check(re, form.id, "아이디는 6~15자리의 영문,숫자 사용만 가능합니다.")) {
		return false;
	} else if(phone==''){
		alert('휴대폰 번호를 입력하세요.');
		return false;
	} else if (!check(num, form.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!check(phEx, form.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else if(verti_num==''){
		alert('인증번호를 입력해주세요.');
		return false;
	} else if(verti_num!=form.find_pw_key.value){
		alert('잘못된 인증번호 입니다.');
		return false;
	} else{
		
		$.ajax({
	        url : "./NewPwSms", // FindSms 에서 받아옴
	        data : {
	        	"phone" : phone,
	        	"mb_id" : mb_id
	        },
	        type : "POST", // get post둘중하나
	        dataType : "JSON", // 데이터타입을 json 으로 받아옴
	       
	        success : function(data) {
	        	if(String(data.result)=="find_pw_fail"){
	        		
	        		document.getElementById("id").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		
	        		alert('해당 정보의 계정이 존재하지 않습니다.');
	        		return false;
	        	}else if(String(data.result)=="change_pw_fail"){
	        		alert('비밀번호 재발급에 실패하였습니다.');
	        	}else if(String(data.result)=="sms_fail"){
	        		alert('문자전송에 실패하였습니다.');
	        	}else{
	        		
	        		document.getElementById("id").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		
	        	alert('회원님의 임시 비밀번호가 발급되어 문자전송 되었습니다.');
	        	
	        	}
	        },
	        error : function(e) {
	        	alert('통신 실패');
	            console.log(e.responseText);
	        }
	    });
		
		
	}
	 
	
}



//tx비밀번호 찾기 유효성
function find_tx_confirm() {
	
	var form = document.find_tx;
	var phone = form.ph.value;
	var mb_id = form.id.value;
	var verti_num = form.verti_num.value;
	var mb_pw = form.pw.value;
	
	var re =  /^[a-z]+[a-z0-9]{5,}$/g;
	var num = /^[0-9]+$/; //숫자만 입력(휴대폰 번호)
	var phEx = /\d{11}$/g; //휴대전화번호 정규식
	
	if(mb_id==''){
		alert('아이디를 입력해주세요.');
		return false;
	} else if(!check(re, form.id, "아이디는 6~15자리의 영문,숫자 사용만 가능합니다.")) {
		return false;
	} else if(mb_pw==''){
		alert('비밀번호를 입력해주세요.');
		return false;
	} else if(phone==''){
		alert('휴대폰 번호를 입력하세요.');
		return false;
	} else if (!check(num, form.ph, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
		return false;
	} else if(!check(phEx, form.ph, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
		return false;
	} else if(verti_num==''){
		alert('인증번호를 입력해주세요.');
		return false;
	} else if(verti_num!=form.find_tx_key.value){
		alert('잘못된 인증번호 입니다.');
		return false;
	}else{
		
		$.ajax({
	        url : "./NewTxSms", // FindSms 에서 받아옴
	        data : {
	        	"phone" : phone,
	        	"mb_id" : mb_id,
	        	"mb_pw" : mb_pw
	        },
	        type : "POST", // get post둘중하나
	        dataType : "JSON", // 데이터타입을 json 으로 받아옴
	       
	        success : function(data) {
	        	if(String(data.result)=="find_tx_id_fail"){
	        		
	        		document.getElementById("id").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		document.getElementById("pw").value = '';
	        		
	        		alert('해당 정보의 계정이 존재하지 않습니다.');
	        		return false;
	        	} else if(String(data.result)=="find_tx_pw_fail"){
	        		
	        		document.getElementById("id").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		document.getElementById("pw").value = '';
	        		
	        		alert('입력하신 비밀번호가 일치하지 않습니다.');
	        		return false;
	        	} else if(String(data.result)=="find_tx_phone_fail"){
	        		
	        		document.getElementById("id").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		document.getElementById("pw").value = '';
	        		
	        		alert('전화번호를 다시 확인해주세요.');
	        		return false;
	        	} else if(String(data.result)=="change_tx_fail"){
	        		alert('pin code 재발급에 실패하였습니다.');
	        	} else if(String(data.result)=="sms_fail"){
	        		alert('문자전송에 실패하였습니다.');
	        	} else{
	        		
	        		document.getElementById("id").value = '';
	        		document.getElementById("ph").value = '';
	        		document.getElementById("verti_num").value = '';
	        		document.getElementById("pw").value = '';
	        		
	        		alert('회원님의 임시 pin code가 발급되어 문자전송 되었습니다.');
	        	
	        	}
	        },
	        error : function(e) {
	        	alert('통신 실패');
	            console.log(e.responseText);
	        }
	    });
		
		
	}
	 
	
}

	function check(re, what, message) {
		if (re.test(what.value)) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
	}
