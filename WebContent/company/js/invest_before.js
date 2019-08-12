$(function() {
	$('header').load('./header/header.jsp');
	$('footer').load('./footer/footer.jsp');
});

$(function() {
	$('body').css('overflow', 'hidden');

	$('.gon').click(function() {
		$('body').css('overflow', 'auto');
		$('.bf_noti').fadeOut(300);

		$('.gage').each(function() {
			var percent = $(this).find('.per > span').text();

			$(this).find('.gage_fill').animate({
				'width' : percent + '%'
			}, 1500);
		});
	});
});

jQuery(
		'<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>')
		.insertAfter('.quantity input');
jQuery('.quantity')
		.each(
				function() {
					var spinner = jQuery(this), input = spinner
							.find('input[type="number"]'), btnUp = spinner
							.find('.quantity-up'), btnDown = spinner
							.find('.quantity-down'), min = input.attr('min'), max = input
							.attr('max');

					btnUp.click(function() {
						var oldValue = parseFloat(input.val());
						if (oldValue >= max) {
							var newVal = oldValue;
						} else {
							var newVal = oldValue + 1;
						}
						spinner.find("input").val(newVal);
						spinner.find("input").trigger("change");
					});

					btnDown.click(function() {
						var oldValue = parseFloat(input.val());
						if (oldValue <= min) {
							var newVal = oldValue;
						} else {
							var newVal = oldValue - 1;
						}
						spinner.find("input").val(newVal);
						spinner.find("input").trigger("change");
					});
				});

$(function() {
	var price = $('.cost span').text();
	var resultPrice = price.replace(",", "");

	$('.sum span').text(resultPrice)

	$('.quantity-button').click(function() {

		var amount = $('.quantity input').val();
		var sum = resultPrice * amount
		var summ;
		summ = addComma(sum);

		// console.log("sum : "+ summ);

		$('.sum span').text(sum)
		$('#invest_amount').val(amount); // 투자하기 넘길때 사용
		$('#invest_point').val(sum); // 투자하기 넘길때 사용
	});

	setInterval(function() {
		var amount = $('.quantity input').val();
		var sum = resultPrice * amount
		var addCommaSum;

		sum = sum + "";
		point = sum.length % 3;
		len = sum.length;

		addCommaSum = sum.substring(0, point);
		while (point < len) {
			if (addCommaSum != "")
				addCommaSum += ",";
			addCommaSum += sum.substring(point, point + 3);
			point += 3;
		}
		$('.sum span').text(addCommaSum) // 여기에 합계 표시
	}, 10);

});

function addComma(num) {
	var regexp = /\B(?=(\d{3})+(?!\d))/g;
	return num.toString().replace(regexp, ',');
}