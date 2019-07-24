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
  <link rel="stylesheet" type="text/css" href="./css/slick.css">
  <link rel="stylesheet" type="text/css" href="./css/slick-theme.css">

  <link href="css/index.css" rel="stylesheet">
  <script src="js/jquery-3.1.1.min.js"></script>
  <script src="js/jquery.bxslider.min.js"></script>

</head>

<body>
  <div id="wrap">
    <header></header>
    <div class="hdbck"></div>
    <div class="toppdng"></div>


    <section id="sec1">
      <div class="inner">
        <div class="regular slider">
          <div>
            <div class="slide slide1">
              <div class="owop"></div>
              <div class="txtbox">
                <h2>바른생선회</h2>
                <h4>해운대점</h4>
                <p>여기는 간딴 기업소개 택스트 자리</p>
              </div>
            </div>
          </div>
          <div>
            <div class="slide slide2">
              <div class="owop"></div>
              <div class="txtbox">
                <h2>바른생선회</h2>
                <h4>해운대점</h4>
                <p>여기는 간딴 기업소개 택스트 자리</p>
              </div>
            </div>
          </div>
          <div>
            <div class="slide slide3">
              <div class="owop"></div>
              <div class="txtbox">
                <h2>바른생선회</h2>
                <h4>해운대점</h4>
                <p>여기는 간딴 기업소개 택스트 자리</p>
              </div>
            </div>
          </div>
        </div>
        <script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
        <script src="./js/slick.min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
          $(document).on('ready', function() {
            $(".regular").slick({
              autoplay: true,
              dots: true,
              infinite: true,
              slidesToShow: 1,
              slidesToScroll: 1
            });
          });
        </script>

        <div class="live_chart">
          <h3>실시간 인기순위</h3>
          <ul>
            <li>
              <span>1</span>&nbsp;
              <a href="#">어나더 미네스</a>
              <span>-</span>
            </li>
            <li>
              <span>2</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>3</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>▲ 4</span>
            </li>
            <li>
              <span>4</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>5</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>6</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>-</span>
            </li>
            <li>
              <span>7</span>&nbsp;
              <a href="#">바른생선회</a>
              <span>▼ 4</span>
            </li>
            <li>
              <span>8</span>&nbsp;
              <a href="#">-</a>
              <span>-</span>
            </li>
            <li>
              <span>9</span>&nbsp;
              <a href="#">-</a>
              <span>-</span>
            </li>
            <li>
              <span>10</span>&nbsp;
              <a href="#">-</a>
              <span>-</span>
            </li>
          </ul>
        </div>
      </div>
    </section>
    <!--여기에 내용 입력-->

    <section id="sec2">
      <div class="inner">
        <div class="corp_box">
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
        <div class="corp_box">
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
        <div class="corp_box">
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
        <div class="corp_box">
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
      </div>
    </section>

    <section id="sec3">
      <div class="inner">
        <div class="inleft">
          <div class="location">
            <h5>지역별 현황</h5>
            <div class="map"></div>
            <ul>
              <li class="local01">서울(10)</li>
              <li class="local02">경기(4)</li>
              <li class="local03">인천(6)</li>
              <li class="local04">강원(2)</li>
              <li class="local05">대전·충청(4)</li>
              <li class="local06">대구(3)</li>
              <li class="local07">부산(24)</li>
              <li class="local08">울산(12)</li>
              <li class="local09">경상(7)</li>
              <li class="local10">광주·전라(4)</li>
              <li class="local11">제주(5)</li>
            </ul>
          </div>
        </div>

        <div class="inright">
          <div class="comingsoon_box">

            <div class="sec3_box1 slider">
              <div>
                <div class="slide slide1">
                  <img src="./img/side_2_portana.jpg" alt="">
                  <div class="cb_inbox">
                    <h4>포르타나 <span>2019. 08. 24 오픈예정</span></h4>
                    <p><span>우리동네 골목대장 감성포차</span> 퇴근하고 매일 가고싶은 분위기 갑 주점</p>
                  </div>
                </div>
              </div>
              <div>
                <div class="slide slide2">
                  <img src="./img/side_2_portana.jpg" alt="">
                  <div class="cb_inbox">
                    <h4>포르타나 <span>2019. 08. 24 오픈예정</span></h4>
                    <p><span>우리동네 골목대장 감성포차</span> 퇴근하고 매일 가고싶은 분위기 갑 주점</p>
                  </div>
                </div>
              </div>
            </div>
            <script src="https://code.jquery.com/jquery-2.2.0.min.js" type="text/javascript"></script>
            <script src="./js/slick.min.js" type="text/javascript" charset="utf-8"></script>
            <script type="text/javascript">
              $(document).on('ready', function() {
                $(".sec3_box1").slick({
                  autoplay: true,
                  dots: true,
                  infinite: true,
                  slidesToShow: 1,
                  slidesToScroll: 1
                });
              });
            </script>
          </div>

          <aritcle class="corp_boxwrap">
            <div class="corp_box">
              <div class="c_img">
                <img src="./img/row3_noodle.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>일반음식점</p>
                <h5>면식가 <span>마감임박</span></h5>
                <p>부산 대연점</p>
              </div>
              <div class="gage">
                <div class="per"><span>95</span>%
                  <ul>
                    <li><span id="days"></span>일</li>
                    <li><span id="hours"></span> :</li>
                    <li><span id="minutes"></span> :</li>
                    <li><span id="seconds"></span></li>
                    <script>
                      $(document).ready(function() {
                        const second = 1000,
                          minute = second * 60,
                          hour = minute * 60,
                          day = hour * 24;

                        let countDown = new Date('June 30, 2019 00:00:00').getTime(),
                          x = setInterval(function() {

                            let now = new Date().getTime(),
                              distance = countDown - now;

                             document.getElementById('days').innerText = Math.floor(distance / (day)),
                              document.getElementById('hours').innerText = Math.floor((distance % (day)) / (hour)),
                              document.getElementById('minutes').innerText = Math.floor((distance % (hour)) / (minute)),
                              document.getElementById('seconds').innerText = Math.floor((distance % (minute)) / second);
                          }, second)
                      });
                    </script>
                  </ul>
                </div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>1</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>10%</span>
              </div>
            </div>
            <div class="corp_box">
              <div class="c_img">
                <img src="./img/row1_anotherminae.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>카페</p>
                <h5>어나더 미네스 <span>마감임박</span></h5>
                <p>부산 남산점</p>
              </div>
              <div class="gage">
                <div class="per"><span>82</span>%
                  <ul>
                    <li><span id="days2"></span>일</li>
                    <li><span id="hours2"></span> :</li>
                    <li><span id="minutes2"></span> :</li>
                    <li><span id="seconds2"></span></li>
                    <script>
                      $(document).ready(function() {
                        const second = 1000,
                          minute = second * 60,
                          hour = minute * 60,
                          day = hour * 24;

                        let countDown = new Date('June 30, 2019 00:00:00').getTime(),
                          x = setInterval(function() {

                            let now = new Date().getTime(),
                              distance = countDown - now;

                            document.getElementById('days2').innerText = Math.floor(distance / (day)),
                              document.getElementById('hours2').innerText = Math.floor((distance % (day)) / (hour)),
                              document.getElementById('minutes2').innerText = Math.floor((distance % (hour)) / (minute)),
                              document.getElementById('seconds2').innerText = Math.floor((distance % (minute)) / second);
                          }, second)
                      });
                    </script>
                  </ul>
                </div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>4</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>7%</span>
              </div>
            </div>
            <div class="corp_box">
              <div class="c_img">
                <img src="./img/row1_anotherminae.jpg" alt="">
              </div>
              <div class="c_txt">
                <p>카페</p>
                <h5>어나더 미네스 <span>마감임박</span></h5>
                <p>부산 남산점</p>
              </div>
              <div class="gage">
                <div class="per"><span>98</span>%
                  <ul>
                    <li><span id="days3"></span>일</li>
                    <li><span id="hours3"></span> :</li>
                    <li><span id="minutes3"></span> :</li>
                    <li><span id="seconds3"></span></li>
                    <script>
                      $(document).ready(function() {
                        const second = 1000,
                          minute = second * 60,
                          hour = minute * 60,
                          day = hour * 24;

                        let countDown = new Date('June 30, 2019 00:00:00').getTime(),
                          x = setInterval(function() {

                            let now = new Date().getTime(),
                              distance = countDown - now;

                            document.getElementById('days3').innerText = Math.floor(distance / (day)),
                              document.getElementById('hours3').innerText = Math.floor((distance % (day)) / (hour)),
                              document.getElementById('minutes3').innerText = Math.floor((distance % (hour)) / (minute)),
                              document.getElementById('seconds3').innerText = Math.floor((distance % (minute)) / second);
                          }, second)
                      });
                    </script>
                  </ul>
                </div>
                <div class="gage_full">
                  <div class="gage_fill"></div>
                </div>
                <div>
                  <span class="p_amt"><span>157,000</span> / <span>200,000</span> P</span>
                  <span class="d_day">D-<span>3</span></span>
                </div>
              </div>
              <div class="reward_per">
                수익률
                <span>9%</span>
              </div>
            </div>
          </aritcle>
        </div>
      </div>
    </section>

    <footer></footer>
  </div>

  <script>
    $(function() {
      $('header').load('./header/header.jsp')
      $('footer').load('./footer/footer.jsp')
      $('.map').load('./company/map.jsp')
    });
    
    $(function() {

      var i = 1;

      setInterval(function() {
        var liheight = $('.live_chart li').height();
        
        $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY(-'+ liheight*4 +'%)');
        setTimeout(function() {
          $('.live_chart li:nth-child(' + i + ') *').fadeOut(0);
          $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY('+ liheight*4 +'%)');

          $('.live_chart li:nth-child(' + i + ') a').text('바뀐 택스트')
          /*변수 값 바꾸는 스크립트를 넣어주시오*/
        }, 800);
        setTimeout(function() {

          $('.live_chart span:contains(▼)').css({
            'color': '#ff9124'
          });
          $('.live_chart span:contains(▲)').css({
            'color': '#73a6d6'
          });
          $('.live_chart li:nth-child(' + i + ') *').fadeIn(0);
          $('.live_chart li:nth-child(' + i + ') *').css('transform', 'translateY(0px)');

          i = i + 1;
          if (i == 11) {
            i = 1;
          }
        }, 1000);

      }, 2000)


      $('.live_chart span:contains(▼)').css({
        'color': '#ff9124'
      });
      $('.live_chart span:contains(▲)').css({
        'color': '#73a6d6'
      });
    });
    //실시간 인기순위

    $(function() {
      $('.gage').each(function() {
        var percent = $(this).find('.per > span').text();

        $(this).find('.gage_fill').animate({
          'width': percent + '%'
        }, 1500);
      });
    });
    //게이지 바

    $(function() {

      $('.location li').hover(function() {
        var classname = $(this).attr('class')
        $('#map .' + classname).css('color', 'ff9124').css('transform', 'scale(1.05)');
      }, function() {
        var classname = $(this).attr('class')
        $('#map .' + classname).css('color', '#73a6d6').css('transform', 'scale(1)');
      });
    });
    //지도
  </script>

</body></html>
