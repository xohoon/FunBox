		/*$(function() {
	      $('header').load('header/header.jsp');
	      $('footer').load('footer/footer.jsp');
	    });
*/
	$(function(){
	    //찜하기 되어 있으면 즐겨찾기 아이콘 클릭처리
	      if($('.like').val() == '1'){
	    	  $('.like').toggleClass('on');
	      }	     	    
	      
		// 유정 추가 - 찜버튼에 값 넣기
		    $(".like").click(function() {
		    	if (!document.investForm.idx.value) {
		    		alert('로그인이 필요한 서비스입니다.');
		    		location.href='./LoginPage.mb';		    		
		    	} else {
		    		if ($(".like").val() == '0') {
		    			like_q = confirm('즐겨찾기에 추가하시겠습니까?');		    			
		    			if (like_q) {
		    				$(this).val('1');
		    				$(this).toggleClass('on');
		    				bookmark('1');
		    			} else {
		    				$(this).val('0');
		    				$(this).removeClass('on');
		    			}
		    		} else {
		    			like_q = confirm('즐겨찾기에서 제외하시겠습니까?');
		    			if (like_q) {
		    				$(this).val('0');
		    				$(this).removeClass('on');
		    				bookmark('0');
		    			} else {
		    				$(this).val('1');
		    			}
		    		}
		    	}
		    });
	});
	   /* $(function() {
	    	var $win = $(window);

	        // 즐겨찾기
	        $('.like').on('click', function() {
	          $(this).toggleClass('on');
	        });

	      // 리스트
	      $(window).on('scroll resize', function() {
	        var scTop = $win.scrollTop(),
	          winWidth = $win.width(),
	          winHeight = $win.height(),
	          docHeight = $('HTML').height();
	        if (winWidth > 1023) {
	          if (scTop + winHeight == docHeight) {
	            $('.list').addClass('done');
	          } else if (scTop > 0) {
	            $('.list').removeClass('done');
	            $('.list').addClass('on');
	          } else {
	            $('.list').removeClass('on');
	            $('.list').removeClass('done');
	          }
	        }else{
	            $('.list').removeClass('on');
	            $('.list').removeClass('done');
	        }
	      });

	      // 계산기셀렉트
	      var $select = $('.calc_top').find('select')
	      $select.on('click', function() {
	        $('.calc_top').toggleClass('on');
	      });
	      $select.focusout(function() {
	        $('.calc_top').removeClass('on');
	      });

	      var min = $('.min').text();
	      min = min.replace(/[^0-9]/g, "");
	      min = min.replace(/\,/g, "");

	      var $option = $('.calc_top').find('option');
	      $option.eq(0).text(min * 1 / 10000 + '만원');
	      $option.eq(1).text(min * 3 / 10000 + '만원');
	      $option.eq(2).text(min * 5 / 10000 + '만원');
	      $option.eq(3).text(min * 10 / 10000 + '만원');
	      $option.eq(4).text(min * 20 / 10000 + '만원');
	      
	      var m=1;
	      
	      var rew = $('.rewards').text(),
	            rewM = $('.rewMonth').text(),
	            $rew1 = $('.rew1'),
	            $rew2 = $('.rew2'),
	            $rew3 = $('.rew3');
	      rew = rew.replace(/\,/g, "");
	        rewM = rewM.replace(/\,/g, "");
	        
	      
	      var rVal1 = rew*m,
	            rVal2 = rewM*m,
	            rVal3 = rew*m/(min)*100/1.3,
	            rVal3 = rVal3.toFixed(2);
	      rVal1 = numberWithCommas(rVal1);
	        rVal2 = numberWithCommas(rVal2);
	      $rew1.val(rVal1 + "원");
	        $rew2.val(rVal2 + "원");
	        $rew3.val(rVal3 + "배");
	      
	      
	      $select.on('change', function(){
	        var pick = $(this).children('option:selected').index(),
	            pickVal = $(this).val();
	        pickVal = pickVal.replace(/[^0-9]/g, "");
	        switch(pick){            
	          case 0: m=1;break;
	          case 1: m=3;break;
	          case 2: m=5;break;
	          case 3: m=10;break;
	          case 4: m=20;break;
	        }
	         var rVal1 = rew*m,
	            rVal2 = rewM*m,
	            rVal3 = rew*m/(min)*100/1.3,
	            rVal3 = rVal3.toFixed(2);
	      rVal1 = numberWithCommas(rVal1);
	        rVal2 = numberWithCommas(rVal2);
	      $rew1.val(rVal1 + "원");
	        $rew2.val(rVal2 + "원");
	        
	        $rew1.val(rVal1 + "원");
	        $rew2.val(rVal2 + "원");
	      });


	      // 게이지
	      var percent = $('.gauge').prev('p').text();
	      $('.gauge').find('div').stop().animate({
	        'width': percent
	      }, 2000);

	    });
	    
	    function numberWithCommas(x) {
	        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	    }*/
	    
	  /*
		 * // 라이트박스 $(function() { var i; var imgArr =
		 * ['img/row1_anotherminae.jpg', 'img/row1_busancoffee.jpg',
		 * 'img/row1_soinsoo.jpg', 'img/row2_bokraeheon.jpg',
		 * 'img/row2_moon.jpg', 'img/row3_noodle.jpg',
		 * 'img/row2_myeonchaeum.jpg'], imgLeng = imgArr.length, $ul =
		 * $('.photo').find('ul'), $div = $('.photo').find('div'), $box =
		 * $('#lightBox'), $ul2 = $box.find('ul'), $div2 = $box.find('div');
		 * 
		 * 
		 * for (i = 0; i < imgLeng; i++) { var addLi =
		 * document.createElement('li'), addImg = document.createElement('img');
		 * addLi.style.backgroundImage = "url(" + imgArr[i] + ")";
		 * addImg.className = 'corImg'; addImg.setAttribute('src',imgArr[i]);
		 * $ul.append(addLi); $div.append(addImg); }
		 * 
		 * for (i = 0; i < imgLeng; i++) { var addLi =
		 * document.createElement('li'), addImg = document.createElement('img');
		 * addLi.style.backgroundImage = "url(" + imgArr[i] + ")";
		 * addLi.setAttribute('onclick', "currentSlide(" + (i + 1) + ")");
		 * addImg.className = 'corImg2'; addImg.setAttribute('src',imgArr[i]);
		 * $ul2.append(addLi); $div2.append(addImg); }
		 * 
		 * document.getElementById('caption').innerHTML = slideIndex +
		 * '&nbsp;/&nbsp;' + imgLeng;
		 * document.getElementById('caption2').innerHTML = slideIndex +
		 * '&nbsp;/&nbsp;' + imgLeng;
		 * 
		 * $ul2.find('li').eq(slideIndex - 1).addClass('on');
		 * 
		 * $box.hide(); $ul.find('li').eq(5).on('click', function() {
		 * $box.show(); }); $box.find('.close').on('click', function() {
		 * $box.hide(); });
		 * 
		 * $ul.find('li').on('click', function() { var a = $(this).index();
		 * switch(a){ case 0 : currentSlide(1);break; case 1 :
		 * currentSlide(2);break; case 2 : currentSlide(3);break; case 3 :
		 * currentSlide(4);break; case 4 : currentSlide(5);break; } }); var
		 * square = $(window).height(); square = (square - 80)*0.2 - 16;
		 * $ul2.find('li').width(square*1);
		 * 
		 * if($(window).width() < 768){ var squ = $ul.find('li').width();
		 * $ul.find('li').height(squ); $ul.height(squ*2 + 16); var after = '<style>
		 * .photo li:nth-child(6):after{ line-height:' + squ+ 'px; }</style>'
		 * $('head').append(after); }
		 * 
		 * });
		 *  // 라이트박스 스크롤 $('#lightBox ul').mousewheel(function(event, delta) {
		 * this.scrollLeft -= (delta * 100); event.preventDefault(); }); //
		 * textarea $(document).ready(function() { $('.txt_wrap').on('keyup',
		 * 'textarea', function(e) { $(this).css('height', 'auto');
		 * $(this).height(this.scrollHeight); });
		 * $('.txt_wrap').find('textarea').keyup(); });
		 * 
		 * var slideIndex = 1; showSlides();
		 * 
		 * 
		 * function plusSlides(n) { showSlides(slideIndex += n); }
		 * 
		 * 
		 * function currentSlide(n) { showSlides(slideIndex = n); }
		 * 
		 * function showSlides(n) { var i; var slides =
		 * document.getElementsByClassName("corImg"); var slides2 =
		 * document.getElementsByClassName("corImg2"); if (n > slides.length) {
		 * slideIndex = 1 } if (n < 1) { slideIndex = slides.length } for(n=0;n<slides.length;n++){
		 * slides[n].style.display = "none"; slides2[n].style.display = "none"; }
		 * slides[slideIndex - 1].style.display = "block"; slides2[slideIndex -
		 * 1].style.display = "block";
		 * document.getElementById('caption').innerHTML = slideIndex +
		 * '&nbsp;/&nbsp;' + slides.length;
		 * document.getElementById('caption2').innerHTML = slideIndex +
		 * '&nbsp;/&nbsp;' + slides2.length;
		 * $('#lightBox').find('li').removeClass('on');
		 * $('#lightBox').find('li').eq(slideIndex - 1).addClass('on'); }
		 *  // 사업계획서 $(function() { var p, pArr = ['img/store_info1.png',
		 * 'img/store_info1.png', 'img/store_info1.png',
		 * 'img/row1_anotherminae.jpg', 'img/row1_busancoffee.jpg',
		 * 'img/row1_soinsoo.jpg', 'img/row2_bokraeheon.jpg',
		 * 'img/row2_moon.jpg', 'img/row3_noodle.jpg',
		 * 'img/row2_myeonchaeum.jpg'], planL = pArr.length, $operPlan =
		 * $('.operPlan'); for (p = 0; p < planL; p++) { var addP =
		 * document.createElement('li'); addP.style.backgroundImage = "url(" +
		 * pArr[p] + ")"; $operPlan.find('ul').append(addP); }
		 * document.getElementById('planView').style.backgroundImage = "url(" +
		 * pArr[0] + ")";
		 * 
		 * $operPlan.find('li').on('click', function() { var liIn =
		 * $(this).index();
		 * 
		 * document.getElementById('planView').style.backgroundImage = "url(" +
		 * pArr[liIn] + ")"; }); }); // 참고자료 $(function(){ var corFile,
		 * corFileArr =
		 * ['data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EA%B3%84%ED%9A%8D%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%ED%8E%80%EB%94%A9%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%82%AC%EC%97%85%EC%9E%90%EB%93%B1%EB%A1%9D%EC%A6%9D.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EC%9E%84%EB%8C%80%EC%B0%A8%EA%B3%84%EC%95%BD%EC%84%9C.txt','data/%EB%B0%94%EB%A5%B8%EC%83%9D%EC%84%A0%ED%9A%8C_%EA%B0%80%EB%A7%B9%ED%97%88%EA%B0%80%EC%9E%90%EB%A3%8C.txt'],
		 * corL = corFileArr.length, $row6 = $('.row6'); for(corFile=0;corFile<corL;corFile++){
		 * var addFile = document.createElement('a');
		 * addFile.setAttribute('href',corFileArr[corFile]); addFile.className =
		 * 'corFile'; $row6.append(addFile);
		 * 
		 * var fileUrl = corFileArr[corFile].split('/'), fileUrlLeng
		 * =fileUrl.length, fileNameFull = fileUrl[fileUrlLeng-1], fileNameDec =
		 * decodeURI(fileNameFull);
		 * addFile.setAttribute('download',fileNameDec); addFile.innerHTML = '<i></i>' +
		 * fileNameDec + '<i></i>';
		 *  }
		 * 
		 * });
		 */
	    
	    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	    // 유정 찜하기 추가
	    function bookmark(val) {
	    	var cp_idx = $('#cp_idx').val();
	    	var cp_name = $('#cp_name').val();

	    	$.ajax({
	    		url : "./BookmarkAction.cp",
	    		data : {
	    			"val" : val,
	    			"cp_idx" : cp_idx,
	    			"cp_name" : cp_name
	    		},
	    		type : "POST",
	    		dataType : "JSON",

	    		success : function(data) {
	    			if (String(data.result) == "add_likebox_success") {
	    				alert('즐겨찾기에 추가되었습니다.');
	    				return false;
	    			} else if (String(data.result) == "add_likebox_fail") {
	    				alert('즐겨찾기 추가에 실패했습니다.\n다시 시도해주세요.');
	    				return false;
	    			} else if (String(data.result) == "remove_likebox_success") {
	    				alert('즐겨찾기에서 제외되었습니다.');
	    				return false;
	    			} else if (String(data.result) == "remove_likebox_fail") {
	    				alert('즐겨찾기 제외에 실패했습니다.\n다시 시도해주세요.');
	    				return false;
	    			}
	    		},
	    		error : function(e) {
	    			alert('error');
	    			console.log(e.responseText);
	    		}
	    	});
	    }

	    function investClick() {
	    	var idx = $('#idx');
	    	var f = document.investForm;

	    	if (idx) {
	    		// location.href='./Invest_beforeAction.cp';
	    		f.submit();
	    	} else {
	    		alert("로그인 후 사용해주세요.");
	    		//location.href='./LoginPage.mb';
	    	}
	    }	    
