
// number OK
function only_number(obj) {
	if (event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37
			|| event.keyCode == 39 || event.keyCode == 46)
		return false;
	obj.value = obj.value.replace(
			/[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi, '');
	obj.value = obj.value.replace(/(\s*)/g, '');// 공백제거
	obj.value = obj.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, '');
	obj.value = obj.value.replace(/[\a-zA-Z]/g, '');
}
	


/////////// application1 company add ///////////
function company_join_app01() {
	
	// 기업신청 유효성

	var f = document.application01;
	var manager_reg = /^[가-힣a-zA-Z]+$/;
	var phoneReg = /^[0-9]{9,12}$/;
	var name = $('#name').val();
	var manager = $('#manager').val();
	var phone = $('#phone').val();
	var app4 = $('#app4').val();
	var app4_1 = $('#app4_1').val();
	var app4_2 = $('#app4_2').val();
	var app4_3 = $('#app4_3').val();
	var sector = $('#sector').val();
	var prestige = $('#prestige').val();
	var deposit = $('#deposit').val();
	var monthly = $('#monthly').val();
	var open_datetime = $('#open_datetime').val();
	
	if(!name) {
		alert('기업명을 입력해주세요.');
		return false;
	}else if(!manager) {
		alert('담당자 이름을 입력해주세요.');
		return false;
	}else if(!manager_reg.test($("input[name=manager]").val())) {
		alert('이름은 숫자입력이 불가능합니다.');
		return false;
	}else if(!phone) {
		alert('연락처를 입력해주세요.');
		return false;
	}else if(!phoneReg.test($("input[name=phone]").val())) {
		alert('전화번호를 확인해주세요.');
		return false;
	}else if(!app4 && !app4_1 && !app4_2) {
		alert('주소를 입력해주세요.');
		return false;
	}else if(!sector) {
		alert('업종을 입력해주세요.');
		return false;
	}else if(!open_datetime) {
		alert('오픈날짜를 입력해주세요.');
		return false;
	}else{
		f.submit();
	}
	
}

/////////// application2 company add ///////////
function company_join_app02() {
	
	var f = document.application02;
	var goal_amount = $('#goal_amount').val();
	var avg_monthly_profit = $('#avg_monthly_profit').val();
	var monthly_profit = $('#monthly_profit').val();
	var during = $('#during').val();
	var inv_min_amount = $('#inv_min_amount').val();
	
	if(!goal_amount) {
		alert('목표 투자 금액을 입력해주세요.');
		return false
	}else if(!avg_monthly_profit) {
		alert('평균 월 매출액을 입력해주세요');
		return false
	}else if(!monthly_profit) {
		alert('월 수익률을 입력해주세요.');
		return false
	}else if(!during) {
		alert('투자 모집 기간을 입력해주세요.');
		return false
	}else if(!inv_min_amount) {
		alert('투자 최소 금액을 입력해주세요');
		return false
	}else{
		f.submit();
	}
}

/////////// Daum Address API ///////////
function address_search() {
	
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
                document.getElementById("app4_3").value = extraAddr;
            
            } else {
                document.getElementById("app4_2").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('app4').value = data.zonecode;
            document.getElementById("app4_1").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("app4_2").focus();
        }
    }).open();

}


//application3.jsp 유효성 검사
function application3_check(){
	var f = document.application3_form;
	
	if(f.introduction.value == '') {
		alert('기업소개 및 사업계획을 입력해주세요.');
		f.introduction.focus();
		return false;
	}else if(f.purpose.value == '') {
		alert('투자 모집 목적을 입력해주세요.');
		f.purpose.focus();
		return false;
	}else if(f.point.value == '') {
		alert('투자 포인트를 입력해주세요.');
		f.point.focus();
		return false;
	}else{
		f.submit();
	}
}
/*
//application4.jsp 유효성 검사
function application4_check(){
	var f = document.application4_form;
	
	var business_license = f.business_license.value;			//사업자 등록증
	var financial_statements = f.financial_statements.value;	//재무재표
	var real_covenant = f.real_covenant.value;					//부동산 계약서
	var store = f.store.value;									//매장사진
	var submission = f.submission.value;						//기타 제출 서류
	
	var agree = f.agree.checked;								//정보제공 동의
	
	if(!business_license){
		alert("사업자 등록증을 첨부해 주세요.");
		return false;
	}else if(!financial_statements){
		alert("재무재표를 첨부해 주세요.");
		return false;
	}else if(!real_covenant){
		alert("부동산 계약서를 첨부해 주세요.");
		return false;
	}else if(!store){
		alert("매장사진을 첨부해 주세요.");
		return false;
	}else if(!submission){
		alert("기타 제출 서류를 첨부해 주세요.");
		return false;
	}else if(!agree) {
		alert('정보제공에 동의하지 않았습니다.');
		return false;
	}else{
		f.submit();
	}
}*/
var MB_10 = 10485760;
var MB_10_str = '10MB';
var MB_50 = 52428800;

$(document).ready(function() {
	function limit_storage_single(id,storage){
		var size = document.getElementById(id).files[0].size;
		if (size > storage) {
			if (storage == MB_10) {
				alert('10MB 이하의 파일을 업로드 해주세요.');
			}else if (storage == MB_50) {
				alert('50MB 이하의 파일을 업로드 해주세요.');				
			}
			document.getElementById(id).value = "";
		}
		
	}
	
	function limit_storage_multi(id,storage){
		var total_storage = 0;
		var file_length = document.getElementById(id).files.length;
		for (var i = 0; i < file_length; i++) {
			total_storage += document.getElementById(id).files[i].size;
		}
		if (total_storage > storage) {
			if (storage == MB_10) {
				alert('10MB 이하의 파일을 업로드 해주세요.');
			}else if (storage == MB_50) {
				alert('50MB 이하의 파일을 업로드 해주세요.');				
			}
			document.getElementById(id).value = "";
		}
		
	}
	$('#app_cp_registrantion').change(function(){
		limit_storage_single("app_cp_registrantion",MB_10);
	});
	
	$('#app_cp_financial').change(function(){
		limit_storage_single("app_cp_financial",MB_10);
	});
	
	$('#app_cp_estate_contract').change(function(){
		limit_storage_single("app_cp_estate_contract",MB_10);
	});
	
	
	$("#app_cp_images").change(function() {
		
		var fileInput = document.getElementById("app_cp_images");

		var files = fileInput.files;

		if (files.length > 5 || files.length < 3) {
			alert('매장 사진 파일은 최소 3장 최대 5장 입니다.');
			$('#app_cp_images').val('');
			return;
		}
		
		limit_storage_multi("app_cp_images",MB_50);

	});
	
	$("#app_cp_other_documents").change(function() {

		var fileInput = document.getElementById("app_cp_other_documents");

		var files = fileInput.files;
		
		if (files.length > 5 ) {
			alert('기타 제출 서류는 5장을 넘을 수 없습니다.');
			$('#app_cp_images').val('');
			return;
		}
		limit_storage_multi("app_cp_other_documents",MB_50);
	});
	
	$('.submit').on('click',function(){
		if (document.getElementById('app_cp_registrantion').files.length != 1) {
			alert('사업자 등록증 파일을 업로드해주세요.');
			return;
		}
		if(document.getElementById('app_cp_financial').files.length != 1){
			alert('사업자 등록증 파일을 업로드해주세요.');
			return;
		}
		if(document.getElementById('app_cp_estate_contract').files.length != 1){
			alert('사업자 등록증 파일을 업로드해주세요.');
			return;
		}
		if(document.getElementById('app_cp_images').files.length > 5 || document.getElementById('app_cp_images').files.length < 3 ){
			alert('매장 사진 파일은 최소 3장 최대 5장 입니다.');
			return;
		}
		if(document.getElementById('app_cp_other_documents').files.length > 5){
			alert('기타 제출 서류는 5장을 넘을 수 없습니다.');
			return;
		}
		limit_storage_single('app_cp_registrantion',MB_10);
		limit_storage_single('app_cp_financial',MB_10);
		limit_storage_single('app_cp_estate_contract',MB_10);
		limit_storage_multi('app_cp_images',MB_50);
		limit_storage_multi('app_cp_other_documents',MB_50);
		
  		$('#form').submit();
  	});

});