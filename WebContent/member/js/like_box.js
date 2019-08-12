	var cp_idx = null;
        $('.fav a').on('click', function(){
            var delConfirm = confirm('즐겨찾기에서 제외하시겠습니까?');
            if(delConfirm){
	        	cp_idx = $("#cp_idx").val();
	            $(this).parent('li').remove();
	            bookmark(0);
            }
            return false;
        });
		
        $(".fav ul").mousewheel(function(event, delta) {
            this.scrollLeft -= (delta * 100);
            event.preventDefault();
        });
        
		$(function() {
			$('.gage').each(function() {
					var percent = $(this).find('.per > span').text();

					$(this).find('.gage_fill').animate({
						'width': percent + '%'
					}, 1500);
			});
		});
		
	      //찜하기 추가
	      function bookmark(val){
	    	  
	    	  alert(cp_idx);

	    	  $.ajax({
	    		 url : "./BookmarkAction.cp",
	    		 data : {
	    			 "val" : val,
	    			 "cp_idx" : cp_idx,
	    		 },
	    		 type : "POST",
	    		 dataType : "JSON",
	    		 
	    		 success : function(data){
	    			 if(String(data.result) == "remove_likebox_success"){
	    				 alert('즐겨찾기에서 제외되었습니다.');
	    				 return false;
	    			 }else if(String(data.result) == "remove_likebox_fail"){
	    				 alert('즐겨찾기 제외에 실패했습니다.\n다시 시도해주세요.');
	    				 return false;
	    			 }
	    		 },
	    		 error : function(e){
	    			 alert('error');
	    			 console.log(e.responseText);
	    		 }
	    	  });
	    }