$(".msImg").bxSlider({
	auto : true,
	pause : 2000,
	speed : 800
});

 $(function() {
     $('.gage').each(function(){
        var percent = $(this).find('span').text() + '%'
        
         $(this).find('div').animate({
           'width': percent
         }, 2000)
      });
    });


$(".more2").click(function(){ 
	$(".more2").toggleClass("close");
	$(".f_more").slideToggle(400);
});  

$(".more").click(function(){ 
	$(".more2").toggleClass("close");
	$(".f_more").slideToggle(400);
});  

$(".search").click(function(){ 
	$(".this").toggleClass("show");
}); 


$(document).ready(function(){
  $(".search-button").click(function(){
    $(".search-wrapper").toggleClass("is-active");
  });
});


$(document).ready(function(){
const second = 1000,
      minute = second * 60,
      hour = minute * 60,
      day = hour * 24;

let countDown = new Date('Sep 30, 2019 00:00:00').getTime(),
    x = setInterval(function() {

      let now = new Date().getTime(),
          distance = countDown - now;

         document.getElementById('days').innerText = Math.floor(distance / (day)),
        document.getElementById('hours').innerText = Math.floor((distance % (day)) / (hour)),
        document.getElementById('minutes').innerText = Math.floor((distance % (hour)) / (minute)),
        document.getElementById('seconds').innerText = Math.floor((distance % (minute)) / second);
      
      //do something later when date is reached
      //if (distance < 0) {
      //  clearInterval(x);
      //  'IT'S MY BIRTHDAY!;
      //}

    }, second)


});

$(document).ready(function(){
const second = 1000,
      minute = second * 60,
      hour = minute * 60,
      day = hour * 24;

let countDown = new Date('Sep 27, 2019 00:00:00').getTime(),
    x = setInterval(function() {

      let now = new Date().getTime(),
          distance = countDown - now;

        document.getElementById('days2').innerText = Math.floor(distance / (day)),
        document.getElementById('hours2').innerText = Math.floor((distance % (day)) / (hour)),
        document.getElementById('minutes2').innerText = Math.floor((distance % (hour)) / (minute)),
        document.getElementById('seconds2').innerText = Math.floor((distance % (minute)) / second);
      
      //do something later when date is reached
      //if (distance < 0) {
      //  clearInterval(x);
      //  'IT'S MY BIRTHDAY!;
      //}

    }, second)


});