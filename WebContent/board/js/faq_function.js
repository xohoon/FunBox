///// 태훈 추가 /////

function search_ajax() {
	
	$("#search_faq").keyup(function() {
		var key_word = $("search_faq").val();
		if(key_word != '') {
			$.ajax({
				type: 'POST',
				url: './search_faq.bd',
				data: { key_word : key_word},
				dataType: 'JSON',
				success: function(result) {
					if(result.length > 0) {
						var str = '';
						for(var i=0; i<result.length; i++) {
							str += '<p class="depth1"><span>'+result[i].data+'</span></p>';
							str += '<p class="depth2"><span>'+result[i].data+'</span></p>';
						}
						$(".table").html(str);
					}else {
						$(".table").html("");
					}
				},
				error: function(e) {
					console.log('error:'+e.status);
				}
			});
		}
	});
	
}
