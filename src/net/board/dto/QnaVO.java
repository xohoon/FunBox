package net.board.dto;

import java.sql.Date;

public class QnaVO {

	private int idx;
	private String id;
	private String category;	//질문유형선택
	private String name;
	private String email;
	private String mobile;
	private String title;
	private String content;
	private int email_chk;			//이메일 답변 알림 동의:1 미동의:0
	private int mobile_chk;			//문자 답변 알림 동의:1 미동의:0
	private Date reg_date_time;
	private String qna_reply;
	
	
	public String getQna_reply() {
		return qna_reply;
	}
	public void setQna_reply(String qna_reply) {
		this.qna_reply = qna_reply;
	}
	public int getEmail_chk() {
		return email_chk;
	}
	public void setEmail_chk(int email_chk) {
		this.email_chk = email_chk;
	}
	public int getMobile_chk() {
		return mobile_chk;
	}
	public void setMobile_chk(int mobile_chk) {
		this.mobile_chk = mobile_chk;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReg_date_time() {
		return reg_date_time;
	}
	public void setReg_date_time(Date reg_date_time) {
		this.reg_date_time = reg_date_time;
	}
}
