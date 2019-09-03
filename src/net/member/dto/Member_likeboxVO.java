package net.member.dto;

import java.util.Date;

////////// 태훈 - 찜목록 리스트 //////////
public class Member_likeboxVO {
	
	private String like_cp_name;		// 회사이름
	private String cp_monthly_profit;	// 수익률
	private String cp_branch;			// 지점
	private String cp_sector;			// 업종
	private String cp_like_percent;		// 현재 투자률(sql 계산)
	private int mb_idx;
	private int cp_idx;
	private Date iv_appl_stop_date_time;
	private String cf_alias_thumbnail;
	private String company_image_path;
	
	
	public int getMb_idx() {
		return mb_idx;
	}
	public void setMb_idx(int mb_idx) {
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
	public Date getIv_appl_stop_date_time() {
		return iv_appl_stop_date_time;
	}
	public void setIv_appl_stop_date_time(Date iv_appl_stop_date_time) {
		this.iv_appl_stop_date_time = iv_appl_stop_date_time;
	}
	public String getCf_alias_thumbnail() {
		return cf_alias_thumbnail;
	}
	public void setCf_alias_thumbnail(String cf_alias_thumbnail) {
		this.cf_alias_thumbnail = cf_alias_thumbnail;
	}
	public String getCompany_image_path() {
		return company_image_path;
	}
	public void setCompany_image_path(String company_image_path) {
		this.company_image_path = company_image_path;
	}
	
	
	
}
