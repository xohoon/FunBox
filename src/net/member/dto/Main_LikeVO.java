package net.member.dto;

import java.util.Date;

// 태훈 - (추천)인원, 수익율 순서 불러오기
public class Main_LikeVO {
	
	private int lk_cp_idx;						// 기업 식별자
//	private String image;					// 기업 사진
	private String lk_cp_name;				// 기업 이름
	private String lk_cp_sector;			// 기업 업종
	private String lk_cp_branch;			// 기업 지점
	private String lk_cp_percent;			// 투자율
	private String lk_cp_profit;			// 기업 수익율
	private String lk_cp_current_amount;	// 현재 투자
	private String lk_cp_goal_amount;		// 목표 투자
	private Date lk_appl_stop_date_time;
	/*
	 * public String getImage() { return image; } public void setImage(String image)
	 * { this.image = image; }
	 */
	
	public String getLk_cp_name() {
		return lk_cp_name;
	}
	public int getLk_cp_idx() {
		return lk_cp_idx;
	}
	public void setLk_cp_idx(int lk_cp_idx) {
		this.lk_cp_idx = lk_cp_idx;
	}
	public void setLk_cp_name(String lk_cp_name) {
		this.lk_cp_name = lk_cp_name;
	}
	public String getLk_cp_sector() {
		return lk_cp_sector;
	}
	public void setLk_cp_sector(String lk_cp_sector) {
		this.lk_cp_sector = lk_cp_sector;
	}
	public String getLk_cp_branch() {
		return lk_cp_branch;
	}
	public void setLk_cp_branch(String lk_cp_branch) {
		this.lk_cp_branch = lk_cp_branch;
	}
	public String getLk_cp_percent() {
		return lk_cp_percent;
	}
	public void setLk_cp_percent(String lk_cp_percent) {
		this.lk_cp_percent = lk_cp_percent;
	}
	public String getLk_cp_profit() {
		return lk_cp_profit;
	}
	public void setLk_cp_profit(String lk_cp_profit) {
		this.lk_cp_profit = lk_cp_profit;
	}
	public String getLk_cp_current_amount() {
		return lk_cp_current_amount;
	}
	public void setLk_cp_current_amount(String lk_cp_current_amount) {
		this.lk_cp_current_amount = lk_cp_current_amount;
	}
	public String getLk_cp_goal_amount() {
		return lk_cp_goal_amount;
	}
	public void setLk_cp_goal_amount(String lk_cp_goal_amount) {
		this.lk_cp_goal_amount = lk_cp_goal_amount;
	}
	public Date getLk_appl_stop_date_time() {
		return lk_appl_stop_date_time;
	}
	public void setLk_appl_stop_date_time(Date lk_appl_stop_date_time) {
		this.lk_appl_stop_date_time = lk_appl_stop_date_time;
	}
	@Override
	public String toString() {
		return "Main_LikeVO [lk_cp_name=" + lk_cp_name + ", lk_cp_sector=" + lk_cp_sector
				+ ", lk_cp_branch=" + lk_cp_branch + ", lk_cp_percent=" + lk_cp_percent + ", lk_cp_profit="
				+ lk_cp_profit + ", lk_cp_current_amount=" + lk_cp_current_amount + ", lk_cp_goal_amount="
				+ lk_cp_goal_amount + "]";
	}
	
	

}
