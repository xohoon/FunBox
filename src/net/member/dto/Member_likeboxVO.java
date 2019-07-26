package net.member.dto;

////////// 태훈 - 찜목록 리스트 //////////
public class Member_likeboxVO {
	
	private String like_cp_name;		// 회사이름
	private String cp_monthly_profit;	// 수익률
	private String cp_branch;			// 지점
	private String cp_sector;			// 업종
	private String cp_like_percent;		// 현재 투자률(sql 계산)
	
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
	public String getCp_like_percent() {
		return cp_like_percent;
	}
	public void setCp_like_percent(String cp_like_percent) {
		this.cp_like_percent = cp_like_percent;
	}
	@Override
	public String toString() {
		return "Member_likebox [like_cp_name=" + like_cp_name + ", cp_monthly_profit=" + cp_monthly_profit
				+ ", cp_branch=" + cp_branch + ", cp_sector=" + cp_sector + ", cp_like_percent=" + cp_like_percent
				+ "]";
	}
	
	
}
