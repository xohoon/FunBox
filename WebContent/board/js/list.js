$(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')

      $('.filter').on('click', function() {
        $('.search_bar').toggleClass('on');
      });
    });

    $(function() {
      $('.view_type_ract').on('click', function() {
    	wideBoxFlag = false;
        $('.view_type span').removeClass('on');
        $(this).addClass('on');
        $('.corp_box').removeClass('wide_box');
      });
      $('.view_type_wide').on('click', function() {
    	  wideBoxFlag = true;
        $('.view_type span').removeClass('on');
        $(this).addClass('on');
        $('.corp_box').addClass('wide_box')
      });
    });
    
    
    $(function() {

      $('.gage').each(function() {
        var percent = $(this).find('.per > span').text();

        $(this).find('.gage_fill').animate({
          'width': percent + '%'
        }, 1500);
      });


      var currentscroll = 0;
      var lastscroll = 0;


      $(window).on('scrollstop', function() {
    	  
    	  $.ajax({
    			type: "POST",
    			url: "./ListSearchAction.bd",
    			dataType: "json", 
    			contentType: "application/x-www-form-urlencoded;charset=utf-8",
    			data: {
    				"page" : current_page,
    				"sector_array": sector_array,
    				"city_array": city_array,
    				"city_status": city_status,
    				"select_value": getSelect,
    				"getKeyword": getKeyword,
    			},
    			success: function(data, idx, val,response) {
    				if(data != null) {
    					var count = 0;
    					companyListHTML = "<div class='boxwrap'>";
    					$.each(data, function(idx, val) {
    						var resultData = {
    								cp_idx: val.cp_idx,
    								cp_name: val.cp_name,
    								cp_percent: val.percent,
    								cp_current: val.cp_current_amount,
    								cp_goal: val.cp_goal_amount,
    								cp_profit: val.cp_monthly_profit,
    								cp_branch: val.cp_branch,
    								cp_sector: val.cp_sector,
    								cp_stop_date_time : val.cp_stop_date_time,
    								thumbnail_image : val.thumbnail_image
    						}
    						count++;
    						makeMoreCompanyListHTML(resultData);
    					});
    					companyListHTML += "</div>";
    					var clonedata = companyListHTML;
    			        
    			        var randomarti = Math.ceil(Math.random() * 6);
    			        var randomnum = (randomarti + 4) * 100;

    			        
    			        var htmlheight = $('html').outerHeight();
    			        var veiwheight = $(window).height();
    			        var trigger = htmlheight - veiwheight - 20;

    			        if (currentscroll < trigger) {
    			          currentscroll = $(window).scrollTop();
    			        }

    			        if (lastscroll = trigger && currentscroll > trigger) {

    			          $('.loader').stop().fadeIn(100);
    			          lastscroll = $(window).scrollTop()

    			          $('.scrolload').stop().append(clonedata)

    			          var foot = $('footer').offset().top;

    			          setTimeout(function() {
    			            $('.scrolload > .boxwrap').addClass('on')
    			            $('.loader').stop().fadeOut(randomnum);

    			            $('.gage').each(function() {
    			              var percent = $(this).find('.per > span').text();

    			              $(this).find('.gage_fill').animate({
    			                'width': percent + '%'
    			              }, 1500);
    			            });
    			          }, randomnum);
    			        }
    					current_page++;
    				}
    				if (count < 8) {
    					$('.moreBtn').off('click');
    					$('.moreBtn').hide();
    					$(window).off('scrollstop');
					}
    			},
    			error: function(request, status, error) {
    				/*
    				console.log("request>>"+request);
    				console.log("status>>"+status);
    				console.log("error>>" +error);
    				*/
    			}
    		});
      });

      $('.moreBtn').on('click', function() {
    	  $.ajax({
    			type: "POST",
    			url: "./ListSearchAction.bd",
    			dataType: "json", 
    			contentType: "application/x-www-form-urlencoded;charset=utf-8",
    			data: {
    				"page" : current_page,
    				"sector_array": sector_array,
    				"city_array": city_array,
    				"city_status": city_status,
    				"select_value": getSelect,
    				"getKeyword": getKeyword,
    			},
    			success: function(data, idx, val,response) {
    				if(data != null) {
    					var count = 0;
    					companyListHTML = "<div class='boxwrap'>";
    					$.each(data, function(idx, val) {
    						var resultData = {
    								cp_idx: val.cp_idx,
    								cp_name: val.cp_name,
    								cp_percent: val.percent,
    								cp_current: val.cp_current_amount,
    								cp_goal: val.cp_goal_amount,
    								cp_profit: val.cp_monthly_profit,
    								cp_branch: val.cp_branch,
    								cp_sector: val.cp_sector,
    								cp_stop_date_time : val.cp_stop_date_time,
    								thumbnail_image : val.thumbnail_image
    						}
    						count++;
    						makeMoreCompanyListHTML(resultData);
    					});
    					companyListHTML += "</div>";
    					var clonedata = companyListHTML;         
    			        var randomarti = Math.ceil(Math.random() * 6)
    			        var randomnum = (randomarti + 4) * 100
    			        $('.loader').stop().fadeIn(100);
    			        $('.scrolload').stop().append(clonedata)

    			        setTimeout(function() {
    			          $('.scrolload > .boxwrap').addClass('on')
    			          $('.loader').stop().fadeOut(randomnum);

    			          $('.gage').each(function() {
    			            var percent = $(this).find('.per > span').text();

    			            $(this).find('.gage_fill').animate({
    			              'width': percent + '%'
    			            }, 1500);
    			          });
    			        }, randomnum);
    					current_page++;
    				}
    				if (count < 8) {
    					$('.moreBtn').off('click');
    					$('.moreBtn').hide();
    					$(window).off('scrollstop');
					}
    			},
    			error: function(request, status, error) {
    				/*
    				console.log("request>>"+request);
    				console.log("status>>"+status);
    				console.log("error>>" +error);
    				*/
    			}
    			
    		});    	
      });

    });
    
   
