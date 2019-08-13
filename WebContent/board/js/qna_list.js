$(function() {
	$('header').load('./header/header.jsp')
	$('footer').load('./footer/footer.jsp')
});

$(function() {
	$('.depth1').on('click', function() {
		$(this).siblings('.depth2').slideToggle(300);
	});
	setTimeout(function() {
		$('.loader').fadeOut(1000);
	}, 1000)
});