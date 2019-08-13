///////////////////////////////////////////////////로그인 유효성 체크///////////////////////////////////////////////////

	function login_check(){
		 var f = document.login_form;
		  var re = /^[a-z]+[a-z0-9]{5,}$/g;//아이디 정규식//영어 대소문자,숫자 가능
		  //유효성 체크 시작
		  if(!f.id.value){
			  f.id.focus();
			  alert('아이디를 입력해주세요.');
			  return false;
		  } else if(!check(re,f.id,"아이디는 6~15자리의 영문,숫자 사용만 가능합니다.")){
			  return false;
		  } else if(!f.pw.value){
			  f.pw.focus();
			  alert('비밀번호를 입력해주세요.');
			  return false;
		  } /*else if(!f.tx.value){
			  f.tx.focus();
			  alert('tx비밀번호를 입력해주세요.');
			  return false;
		  }*/ else {
			  login_check_result(f.id, f.pw);
		  }
		  
		  
	  }
	  
		//정규식 결과 리턴 함수
	  function check(re, what, message) {
	      if(re.test(what.value)) {
	          return true;
	      }
	      alert(message);
	      what.value = "";
	      what.focus();
	  }
	  
	  
	  function press_event(){
			if(window.event.keyCode == 13){ //javascript에서는 13이 enter키를 의미함 
				login_check();
				//document.login_form.submit(); //formname에 사용자가 지정한 form의 name입력 
			}

		}
	  
	  
	  // 로그인 버튼을 누르면 에이젝스 코드를 실행해라
	  function login_check_result(id, pw){
		  var f = document.login_form;
				$.ajax({
					url : "./MemberLoginCheckAction.mb",
					type : "POST",
					data : {
						"id" : f.id.value,
						"pw" : f.pw.value,
						},
					dataType : "JSON",
					success : function(data){
						if(parseInt(data.result) == 0){
							alert("비밀번호가 일치하지 않습니다.");
							return false;
						} /*else if(parseInt(data.result) == 2){
							alert("tx비밀번호가 일치하지 않습니다.");
							return false;
						} else if(parseInt(data.result) == 3){
							alert("비밀번호와 tx비밀번호가 모두 일치하지 않습니다.");
							return false;
						}*/ else if(parseInt(data.result) == -1) {
							alert("존재하지 않는 아이디입니다.");
							return false;
						} else{
							alert("로그인 하셨습니다.");
							f.submit();
						}
					}
				});	// ajax 끝
			} // function() 끝
////////////////////////////////////////////////////로그인 유효성 체크///////////////////////////////////////////////////