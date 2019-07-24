package net.board.dto;

import java.sql.Timestamp;

public class QnaReplyVO {

	private int idx;
	private String content;
	private Timestamp reg_date_time;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getReg_date_time() {
		return reg_date_time;
	}
	public void setReg_date_time(Timestamp reg_date_time) {
		this.reg_date_time = reg_date_time;
	}
}
