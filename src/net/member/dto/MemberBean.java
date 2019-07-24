package net.member.dto;

import java.sql.Timestamp;

public class MemberBean {
	
	private int idx;
	private String id;
	private String pw;
	private String pin;
	private String email;
	private String name;
	private String ph;
	private String add_num;		//우편번호
	private String add_ch;		//주소
	private String add_more;	//상세주소
	private String add_extra;	//상세주소
	private String reco;
	private int agree1;			//마케팅 정보수집 및 활용 약관 동의:1 미동의:0
	private int agree2;			//이벤트 및 뉴스레터 수신 동의:1 미동의:0
	private Timestamp reg_date_time;
	
	public int getAgree1() {
		return agree1;
	}
	public void setAgree1(int agree1) {
		this.agree1 = agree1;
	}
	public int getAgree2() {
		return agree2;
	}
	public void setAgree2(int agree2) {
		this.agree2 = agree2;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getAdd_num() {
		return add_num;
	}
	public void setAdd_num(String add_num) {
		this.add_num = add_num;
	}
	public String getAdd_ch() {
		return add_ch;
	}
	public void setAdd_ch(String add_ch) {
		this.add_ch = add_ch;
	}
	public String getAdd_more() {
		return add_more;
	}
	public void setAdd_more(String add_more) {
		this.add_more = add_more;
	}
	public String getAdd_extra() {
		return add_extra;
	}
	public void setAdd_extra(String add_extra) {
		this.add_extra = add_extra;
	}
	public String getReco() {
		return reco;
	}
	public void setReco(String reco) {
		this.reco = reco;
	}
	public Timestamp getReg_date_time() {
		return reg_date_time;
	}
	public void setReg_date_time(Timestamp reg_date_time) {
		this.reg_date_time = reg_date_time;
	}
	
}
