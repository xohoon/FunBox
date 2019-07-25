<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <title></title>

  <!--[if lt IE 9]>
      <script src="./js/html5.js"></script>
   <![endif]-->
  <link href="css/common.css" rel="stylesheet" type="text/css">
  <link href="css/list.css" rel="stylesheet">

  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.scrollstop.js"></script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>

    <section id="sec1">
      <div class="inner">
        <article class="search_bar">
          <div class="view_type">
            <span class="view_type_ract on"></span>
            <span class="view_type_wide"></span>
          </div>

          <div class="search">
            <input type="search" placeholder="추천 키워드 '바른생선회'">
            <input type="button" value="검색">
          </div>

          <div class="list_set">
            <select>
              <option>등록순</option>
              <option>추천순</option>
              <option>수익순</option>
            </select>
          </div>

          <div class="filter">
            <div></div>
            <div></div>
          </div>
          <div class="f_list">
            <form>
              <div class="f_list_type1">
                <h2>업종</h2>
                <span>
                  <input type="checkbox" id="con1_all">
                  <label for="con1_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_1">
                  <label for="con1_1">조건1</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_2">
                  <label for="con1_2">조건2</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_3">
                  <label for="con1_3">조건3</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_4">
                  <label for="con1_4">조건4</label>
                </span>
                <span>
                  <input type="checkbox" id="con1_5">
                  <label for="con1_5">조건5</label>
                </span>
              </div>

              <div class="f_list_type2">
                <h2>지역</h2>
                <span>
                  <input type="checkbox" id="con2_all">
                  <label for="con2_all">서울</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_1">
                  <label for="con2_1">경기</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_2">
                  <label for="con2_2">인천</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_3">
                  <label for="con2_3">강원</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_4">
                  <label for="con2_4">대전/충천</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_5">
                  <label for="con2_5">대구</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_6">
                  <label for="con2_6">부산</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_7">
                  <label for="con2_7">울산</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_8">
                  <label for="con2_8">경상</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_8">
                  <label for="con2_8">광주/전라</label>
                </span>
                <span>
                  <input type="checkbox" id="con2_8">
                  <label for="con2_8">제주</label>
                </span>
              </div>

              <div class="f_list_type3">
                <h2>현황</h2>
                <span>
                  <input type="checkbox" id="con3_all">
                  <label for="con3_all">전체</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_1">
                  <label for="con3_1">조건1</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_2">
                  <label for="con3_2">조건2</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_3">
                  <label for="con3_3">조건3</label>
                </span>
                <span>
                  <input type="checkbox" id="con3_4">
                  <label for="con3_4">조건4</label>
                </span>
              </div>
            </form>
          </div>
        </article>
      </div>
    </section>

    <section id="sec2">
      <div class="inner">
        <div class="mom_box">
          <div class="boxwrap">

            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row1_anotherminae.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>카페</p>
                <h5>어나더 미네스 <span>추천</span></h5>
                <p>부산 남산점</p>
              </div>
              <div class="gage">
                <div class="per"><span>87</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>
            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row1_soinsoo.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>주점</p>
                <h5>소인수분해 <span>추천</span></h5>
                <p>부산 금사점</p>
              </div>
              <div class="gage">
                <div class="per"><span>43</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>
            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row2_moon.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>일반음식점</p>
                <h5>문 토스트 <span>추천</span></h5>
                <p>부산 해운대점</p>
              </div>
              <div class="gage">
                <div class="per"><span>82</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>
            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row2_myeonchaeum.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>일반음식점</p>
                <h5>면채움 <span>추천</span></h5>
                <p>부산 광안점</p>
              </div>
              <div class="gage">
                <div class="per"><span>31</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>


            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row1_soinsoo.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>주점</p>
                <h5>소인수분해 <span>추천</span></h5>
                <p>부산 금사점</p>
              </div>
              <div class="gage">
                <div class="per"><span>43</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>

            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row2_myeonchaeum.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>일반음식점</p>
                <h5>면채움 <span>추천</span></h5>
                <p>부산 광안점</p>
              </div>
              <div class="gage">
                <div class="per"><span>31</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>
            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row1_anotherminae.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>카페</p>
                <h5>어나더 미네스 <span>추천</span></h5>
                <p>부산 남산점</p>
              </div>
              <div class="gage">
                <div class="per"><span>87</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>
            <div class="corp_box" onclick="location.href='./CorporationAction.cp'">
              <div class="c_img">
                <img src="./img/row2_moon.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>일반음식점</p>
                <h5>문 토스트 <span>추천</span></h5>
                <p>부산 해운대점</p>
              </div>
              <div class="gage">
                <div class="per"><span>82</span>%</div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>27</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>5%</span>
              </div>
            </div>

          </div>
        </div>

        <div class="scrolload">
          <div class="loader">
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
            <div class="circle"></div>
          </div>
        </div>

        <button class="moreBtn">더보기 <span>▼</span></button>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <footer></footer>
  </div>
  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')

      $('.filter').on('click', function() {
        $('.search_bar').toggleClass('on');
      });
    });

    $(function() {
      $('.view_type_ract').on('click', function() {
        $('.view_type span').removeClass('on');
        $(this).addClass('on');
        $('.corp_box').removeClass('wide_box')
      });
      $('.view_type_wide').on('click', function() {
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
        var randomarti = Math.ceil(Math.random() * 6)
        var randomnum = (randomarti + 4) * 100
        var clonedata = $('.mom_box').html();
        var htmlheight = $('html').outerHeight();
        var veiwheight = $(window).height();
        var trigger = htmlheight - veiwheight - 20

        if (currentscroll < trigger) {
          currentscroll = $(window).scrollTop();
        }
        //alert(lastscroll)

        if (lastscroll = trigger && currentscroll > trigger) {

          $('.loader').stop().fadeIn(100);
          lastscroll = $(window).scrollTop()

          $('.scrolload').stop().append(clonedata)

          var foot = $('footer').offset().top

          /*
          var movingpoint = foot - veiwheight * 1.3

          $('html').stop().animate({
            scrollTop: movingpoint
          }, 0)          
          */

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
      });

      $('.moreBtn').on('click', function() {
        var randomarti = Math.ceil(Math.random() * 6)
        var randomnum = (randomarti + 4) * 100
        var clonedata = $('.mom_box').html();

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
      });

    });
  </script>
</body></html>
