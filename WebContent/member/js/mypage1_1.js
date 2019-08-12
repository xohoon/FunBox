        $(function() {
          var h = $('.cor_info').height() + 32 ;
          var winW = $(window).width();
          var liOff = $('.cor_info').offset().top;
          var liOffs = liOff * 1 + 56
          if (winW > 1200) {
            $('.list').height(h);
          } else {
            $('.list').height(400);
            $('.list').offset({
              top: liOff
            })
          }
        });
        $('.list_show').on('click', function() {
          $('.list').toggleClass('on');
          if ($(this).text() == '투자리스트보기') {
            $(this).text('닫기');
          } else if ($(this).text() == '닫기') {
            $(this).text('투자리스트보기');
          }
        });
        $(function() {
          $(".rep").mousewheel(function(event, delta) {
            this.scrollLeft -= (delta * 100);
            event.preventDefault();
          });
        });