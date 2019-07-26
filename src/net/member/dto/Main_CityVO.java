package net.member.dto;


// 태훈 - 메인페이지 도시별 count
public class Main_CityVO {
	
	private String seoul;					// 서울 count
	private String busan;					// 부산 count
	private String gyeonggi;				// 경기도 count
	private String incheon;					// 인천 count
	private String gangwon;					// 강원 count
	private String daejeonNchungcheong;		// 대전, 충청 count
	private String daegu;					// 대구 count
	private String ulsan;					// 울산 count
	private String gyeongsang;				// 경상 count
	private String gwangjuNjeonla;			// 광주, 전라 count
	private String jeju;					// 제주 count
	
	public String getSeoul() {
		return seoul;
	}
	public void setSeoul(String seoul) {
		this.seoul = seoul;
	}
	public String getBusan() {
		return busan;
	}
	public void setBusan(String busan) {
		this.busan = busan;
	}
	public String getGyeonggi() {
		return gyeonggi;
	}
	public void setGyeonggi(String gyeonggi) {
		this.gyeonggi = gyeonggi;
	}
	public String getIncheon() {
		return incheon;
	}
	public void setIncheon(String incheon) {
		this.incheon = incheon;
	}
	public String getGangwon() {
		return gangwon;
	}
	public void setGangwon(String gangwon) {
		this.gangwon = gangwon;
	}
	public String getDaejeonNchungcheong() {
		return daejeonNchungcheong;
	}
	public void setDaejeonNchungcheong(String daejeonNchungcheong) {
		this.daejeonNchungcheong = daejeonNchungcheong;
	}
	public String getDaegu() {
		return daegu;
	}
	public void setDaegu(String daegu) {
		this.daegu = daegu;
	}
	public String getUlsan() {
		return ulsan;
	}
	public void setUlsan(String ulsan) {
		this.ulsan = ulsan;
	}
	public String getGyeongsang() {
		return gyeongsang;
	}
	public void setGyeongsang(String gyeongsang) {
		this.gyeongsang = gyeongsang;
	}
	public String getGwangjuNjeonla() {
		return gwangjuNjeonla;
	}
	public void setGwangjuNjeonla(String gwangjuNjeonla) {
		this.gwangjuNjeonla = gwangjuNjeonla;
	}
	public String getJeju() {
		return jeju;
	}
	public void setJeju(String jeju) {
		this.jeju = jeju;
	}
	@Override
	public String toString() {
		return "Main_CityVO [seoul=" + seoul + ", busan=" + busan + ", gyeonggi=" + gyeonggi + ", incheon=" + incheon
				+ ", gangwon=" + gangwon + ", daejeonNchungcheong=" + daejeonNchungcheong + ", daegu=" + daegu
				+ ", ulsan=" + ulsan + ", gyeongsang=" + gyeongsang + ", gwangjuNjeonla=" + gwangjuNjeonla + ", jeju="
				+ jeju + "]";
	}
	
	

}
