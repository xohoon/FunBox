package net.company.dto;

import java.sql.Timestamp;

public class LikeBoxVO {

	private int like_idx;
	private String mb_idx;
	private int cp_idx;
	private String like_cp_name;
	private Timestamp like_cp_date;
	public int getLike_idx() {
		return like_idx;
	}
	public void setLike_idx(int like_idx) {
		this.like_idx = like_idx;
	}
	public String getMb_idx() {
		return mb_idx;
	}
	public void setMb_idx(String mb_idx) {
		this.mb_idx = mb_idx;
	}
	public int getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}
	public String getLike_cp_name() {
		return like_cp_name;
	}
	public void setLike_cp_name(String like_cp_name) {
		this.like_cp_name = like_cp_name;
	}
	public Timestamp getLike_cp_date() {
		return like_cp_date;
	}
	public void setLike_cp_date(Timestamp like_cp_date) {
		this.like_cp_date = like_cp_date;
	}
	
	
}
