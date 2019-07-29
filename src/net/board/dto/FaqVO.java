package net.board.dto;

import java.util.Date;


// 유정 추가 - 고객지원 FAQ
public class FaqVO {
	private int idx;
	private int category; //faq 구분(1:입출금, 2:투자, 3:기타)
	private String title;
	private String content;
	private Date reg_date_time;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
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
