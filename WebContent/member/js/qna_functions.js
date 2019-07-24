	/////////////////////////////////////////////////////문의 등록 유효성 검사////////////////////////////////////////////

	function qna_check(){
		var f = document.qna_form;
//		var num = /^[0-9]+$/; // 숫자만 입력(휴대폰 번호)
//		var phEx = /\d{11}$/g; //휴대전화번호 정규식
//		// 이메일 정규식
//		var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if($("#category").val() == ''){
			alert('카테고리를 선택해주세요.');
			return false;
		} /*else if (f.email.value == '') {
			alert('이메일을 입력해주세요.');
			f.email.focus();
			return false;
		} else if (!email_check(email, f.email, "적합하지 않은 이메일 형식입니다.")) {
			return false;
		} else if (f.mobile.value == '') {
			alert('휴대전화번호를 입력해주세요.');
			f.mobile.focus();
			return false;
		} else if (!ph_check(num, f.mobile, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
			return false;
		} else if(!ph_check(phEx, f.mobile, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
			return false;
		}*/ else if (f.title.value == '') {
			alert('제목을 입력해주세요.');
			f.title.focus();
			return false;
		} else if (f.content.value == '') {
			alert('내용을 입력해주세요.');
			f.content.focus();
			return false;
		} else{
			f.submit();
		}
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
	

	  $(document).ready(function(){
			$("#ag_e").val("0");
			$("#ag_p").val("0");
			
			$("#ag_e").click(function() {
				if ($("#ag_e").is(":checked")) {
					$("#ag_e").val("1");

					var f = document.qna_form;
					// 이메일 정규식
					var email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
					
					if (f.email.value == '') {
						alert('이메일을 입력해주세요.');
						f.email.focus();
						return false;
					} else if (!email_check(email, f.email, "적합하지 않은 이메일 형식입니다.")) {
						return false;
					}
				} else {
					$("#ag_e").val("0");
				}
			});
			
			$("#ag_p").click(function() {
				if ($("#ag_p").is(":checked")) {
					$("#ag_p").val("1");

					var f = document.qna_form;
					var num = /^[0-9]+$/; // 숫자만 입력(휴대폰 번호)
					var phEx = /\d{11}$/g; //휴대전화번호 정규식

					if (f.mobile.value == '') {
						alert('휴대전화번호를 입력해주세요.');
						f.mobile.focus();
						return false;
					} else if (!ph_check(num, f.mobile, "휴대전화번호는 숫자로만 입력 가능합니다.")) {
						return false;
					} else if(!ph_check(phEx, f.mobile, "휴대전화번호는 '-'없이 11자리 입력해주세요.")) {
						return false;
					}
				} else {
					$("#ag_p").val("0");
				}
			});
		});

	
	/////////////////////////////////////////////////////문의 등록 유효성 검사////////////////////////////////////////////