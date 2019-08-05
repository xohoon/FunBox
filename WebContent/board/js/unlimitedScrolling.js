/*var companyListHTML = "<div class='boxwrap'>";
companyListHTML += "<div class='corp_box' onclick='location.href='./CorporationAction.cp?cp_idx=4''><div class='c_img'><img src='./img/row1_anotherminae.jpg' alt=''></div><div class='c_txt'><p>양식</p><h5>애쁠 <span>추천</span></h5><p>삼성점</p></div><div class='gage'><div class='per'><span>14</span>%</div><div class='gage_full'><div class='gage_fill' style='overflow: hidden; width: 2.155%;'><span></span>	                  </div></div><div><span class='p_amt'><span>700,000</span> / <span> 5,000,000 </span> P</span><span class='d_day'>D-<span>27</span></span></div></div><div class='reward_per'>수익률<span>12%</span></div></div>";
companyListHTML += "</div>";*/
/*var companyListHTML = "";
var count = 0;*/
/*function makeMoreCompanyListHTML(){
	companyListHTML = "<div class='boxwrap'>";
	for (var i = 0; i < 8; i++) {
		count++;
		companyListHTML += "<div class='corp_box' onclick='location.href='./CorporationAction.cp?cp_idx=4''><div class='c_img'><img src='./img/row1_anotherminae.jpg' alt=''></div><div class='c_txt'><p>양식</p><h5>애쁠 <span>추천</span></h5><p>삼성점</p></div><div class='gage'><div class='per'><span>14</span>%</div><div class='gage_full'><div class='gage_fill' style='overflow: hidden; width: 2.155%;'><span></span>	                  </div></div><div><span class='p_amt'><span>700,000</span> / <span> 5,000,000 </span> P</span><span class='d_day'>D-<span>27</span></span></div></div><div class='reward_per'>수익률<span>"+count+"%</span></div></div>";
	}
	companyListHTML += "</div>";
};*/


/*function makeMoreCompanyListHTML(resultData){	
	companyListHTML += "<div class='corp_box' onclick='location.href='./CorporationAction.cp?cp_idx="+resultData.cp_idx+"'><div class='c_img'><img src='./img/row1_anotherminae.jpg' alt=''></div><div class='c_txt'><p>"+resultData.cp_sector+"</p><h5>"+resultData.cp_name+" <span>추천</span></h5><p>"+resultData.cp_branch+"</p></div><div class='gage'><div class='per'><span>"+resultData.cp_percent+"</span>%</div><div class='gage_full'><div class='gage_fill' style='overflow: hidden; width: 2.155%;'><span></span></div></div><div><span class='p_amt'><span>"+resultData.cp_current+"</span> / <span>"+resultData.cp_goal+"</span> P</span><span class='d_day'>D-<span>27</span></span></div></div><div class='reward_per'>수익률<span>"+resultData.cp_profit+"%</span></div></div>";
};*/

function makeMoreCompanyListHTML2() {
	$.ajax({
		url : $('#contextPath').val() + "/member/login",
		method : "POST",
		data : {
			id : $("input[name=id]").val(),
			pw : $("input[name=pw]").val(),
			tx_pw : $("input[name=tx_pw]").val()
		},
		type : "json"
	}).done(function(resultData) {
		switch (resultData.result) {
		case 0:
			alert(resultData.message + $('#loginId').val());
			location.href = $('#contextPath').val();
			break;
		case 1:
			alert(resultData.message);
			break;
		case 2:
			alert(resultData.message);
			break;
		default:
			break;
		}
	}).fail(function() {
	}).always(function() {
	});
}