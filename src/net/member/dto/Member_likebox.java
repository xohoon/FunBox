package net.member.dto;

public class Member_likebox {
	
	private String like_cp_name;
	private String cp_monthly_profit;
	private String cp_branch;
	private String cp_sector;
	private String iv_goal_amount;
	private String iv_current_amount;
	public String getLike_cp_name() {
		return like_cp_name;
	}
	public void setLike_cp_name(String like_cp_name) {
		this.like_cp_name = like_cp_name;
	}
	public String getCp_monthly_profit() {
		return cp_monthly_profit;
	}
	public void setCp_monthly_profit(String cp_monthly_profit) {
		this.cp_monthly_profit = cp_monthly_profit;
	}
	public String getCp_branch() {
		return cp_branch;
	}
	public void setCp_branch(String cp_branch) {
		this.cp_branch = cp_branch;
	}
	public String getCp_sector() {
		return cp_sector;
	}
	public void setCp_sector(String cp_sector) {
		this.cp_sector = cp_sector;
	}
	public String getIv_goal_amount() {
		return iv_goal_amount;
	}
	public void setIv_goal_amount(String iv_goal_amount) {
		this.iv_goal_amount = iv_goal_amount;
	}
	public String getIv_current_amount() {
		return iv_current_amount;
	}
	public void setIv_current_amount(String iv_current_amount) {
		this.iv_current_amount = iv_current_amount;
	}
	@Override
	public String toString() {
		return "Member_likebox [like_cp_name=" + like_cp_name + ", cp_monthly_profit=" + cp_monthly_profit
				+ ", cp_branch=" + cp_branch + ", cp_sector=" + cp_sector + ", iv_goal_amount=" + iv_goal_amount
				+ ", iv_current_amount=" + iv_current_amount + "]";
	}
	
	
	
	
}
