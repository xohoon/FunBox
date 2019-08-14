package net.board.dto;

import java.util.Date;

// 유정 추가  고객지원 - 공지사항 불러오기
public class NoticeVO {
	private int idx;
	private String title;
	private String content;
	private Date reg_date_time;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	
	@Override
	public String toString() {
		return "NoticeVO [idx=" + idx + ", title=" + title + ", content=" + content + ", reg_date_time=" + reg_date_time
				+ "]";
	}
	
	
	
	
	
}
