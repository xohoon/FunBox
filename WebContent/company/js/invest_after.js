$(function() {
	$('header').load('./header/header.jsp');
	$('footer').load('./footer/footer.jsp');
});

var p1 = document.getElementById('pincode1');
var p2 = document.getElementById('pincode2');
var p3 = document.getElementById('pincode3');
var p4 = document.getElementById('pincode4');
var p5 = document.getElementById('pincode5');
var p6 = document.getElementById('pincode6');

$('#pincode1').keyup(function(e) {
	if (e.keyCode == 8) {
		alert('6자리 PINCODE를 입력해주세요.');
	} else {
		p2.value = '';
		p2.focus();
	}
});
$('#pincode2').keyup(function(e) {
	if (e.keyCode == 8) {
		p1.value = '';
		p1.focus();
	} else {
		p3.value = '';
		p3.focus();
	}
});
$('#pincode3').keyup(function(e) {
	if (e.keyCode == 8) {
		p2.value = '';
		p2.focus();
	} else {
		p4.value = '';
		p4.focus();
	}
});
$('#pincode4').keyup(function(e) {
	if (e.keyCode == 8) {
		p3.value = '';
		p3.focus();
	} else {
		p5.value = '';
		p5.focus();
	}
});
$('#pincode5').keyup(function(e) {
	if (e.keyCode == 8) {
		p4.value = '';
		p4.focus();
	} else {
		p6.value = '';
		p6.focus();
	}
});
$('#pincode6').keyup(function(e) {
	if (e.keyCode == 8) {
		p5.value = '';
		p5.focus();
	} else {
		alert('내역을 확인하시고 투자 확정 버튼을 눌러주세요.');
	}
});