package net.company.dto;

import java.sql.Timestamp;

public class CompanyVO {
	private int cp_idx;
	private String cp_name;
	private String cp_number;
	private int mb_idx;
	private int iv_idx;
	private int lease_idx;
	private int cf_idx;
	private String cp_manager;
	private String cp_phone;
	private String cp_sector;
	private String cp_add_num;
	private String cp_add_ch;
	private String cp_add_more;
	private String cp_lat;
	private String cp_lng;
	private String cp_add_extra;
	private String cp_capital;
	private Timestamp cp_open_datetime;
	private String cp_avg_monthly_sales;
	private String cp_monthly_profit;
	private Timestamp cp_reg_datetime;
	private Timestamp cp_exit_datetime;
	private String cp_intro_content;
	private String cp_purpose;
	private String cp_point_comment;
	private Timestamp cp_update_datetime;
	private String cp_business_risk;
	private String cp_company_risk;
	private String cp_other_risks;
	private int status;
	private String cp_branch;
	private String cp_intro_headline;
	private boolean cp_recommand;
	private boolean cp_best;
	private boolean cp_open_status;
	
	
	public boolean isCp_open_status() {
		return cp_open_status;
	}
	public void setCp_open_status(boolean cp_open_status) {
		this.cp_open_status = cp_open_status;
	}
	public boolean isCp_recommand() {
		return cp_recommand;
	}
	public void setCp_recommand(boolean cp_recommand) {
		this.cp_recommand = cp_recommand;
	}
	public boolean isCp_best() {
		return cp_best;
	}
	public void setCp_best(boolean cp_best) {
		this.cp_best = cp_best;
	}
	public String getCp_branch() {
		return cp_branch;
	}
	public void setCp_branch(String cp_branch) {
		this.cp_branch = cp_branch;
	}
	public String getCp_intro_headline() {
		return cp_intro_headline;
	}
	public void setCp_intro_headline(String cp_intro_headline) {
		this.cp_intro_headline = cp_intro_headline;
	}
	public int getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getCp_number() {
		return cp_number;
	}
	public void setCp_number(String cp_number) {
		this.cp_number = cp_number;
	}
	public int getMb_idx() {
		return mb_idx;
	}
	public void setMb_idx(int mb_idx) {
		this.mb_idx = mb_idx;
	}
	public int getIv_idx() {
		return iv_idx;
	}
	public void setIv_idx(int iv_idx) {
		this.iv_idx = iv_idx;
	}
	public int getLease_idx() {
		return lease_idx;
	}
	public void setLease_idx(int lease_idx) {
		this.lease_idx = lease_idx;
	}
	public int getCf_idx() {
		return cf_idx;
	}
	public void setCf_idx(int cf_idx) {
		this.cf_idx = cf_idx;
	}
	public String getCp_manager() {
		return cp_manager;
	}
	public void setCp_manager(String cp_manager) {
		this.cp_manager = cp_manager;
	}
	public String getCp_phone() {
		return cp_phone;
	}
	public void setCp_phone(String cp_phone) {
		this.cp_phone = cp_phone;
	}
	public String getCp_sector() {
		return cp_sector;
	}
	public void setCp_sector(String cp_sector) {
		this.cp_sector = cp_sector;
	}
	public String getCp_add_num() {
		return cp_add_num;
	}
	public void setCp_add_num(String cp_add_num) {
		this.cp_add_num = cp_add_num;
	}
	public String getCp_add_ch() {
		return cp_add_ch;
	}
	public void setCp_add_ch(String cp_add_ch) {
		this.cp_add_ch = cp_add_ch;
	}
	public String getCp_add_more() {
		return cp_add_more;
	}
	public void setCp_add_more(String cp_add_more) {
		this.cp_add_more = cp_add_more;
	}
	public String getCp_lat() {
		return cp_lat;
	}
	public void setCp_lat(String cp_lat) {
		this.cp_lat = cp_lat;
	}
	public String getCp_lng() {
		return cp_lng;
	}
	public void setCp_lng(String cp_lng) {
		this.cp_lng = cp_lng;
	}
	public String getCp_add_extra() {
		return cp_add_extra;
	}
	public void setCp_add_extra(String cp_add_extra) {
		this.cp_add_extra = cp_add_extra;
	}
	public String getCp_capital() {
		return cp_capital;
	}
	public void setCp_capital(String cp_capital) {
		this.cp_capital = cp_capital;
	}
	public Timestamp getCp_open_datetime() {
		return cp_open_datetime;
	}
	public void setCp_open_datetime(Timestamp cp_open_datetime) {
		this.cp_open_datetime = cp_open_datetime;
	}
	public String getCp_avg_monthly_sales() {
		return cp_avg_monthly_sales;
	}
	public void setCp_avg_monthly_sales(String cp_avg_monthly_sales) {
		this.cp_avg_monthly_sales = cp_avg_monthly_sales;
	}
	public String getCp_monthly_profit() {
		return cp_monthly_profit;
	}
	public void setCp_monthly_profit(String cp_monthly_profit) {
		this.cp_monthly_profit = cp_monthly_profit;
	}
	public Timestamp getCp_reg_datetime() {
		return cp_reg_datetime;
	}
	public void setCp_reg_datetime(Timestamp cp_reg_datetime) {
		this.cp_reg_datetime = cp_reg_datetime;
	}
	public Timestamp getCp_exit_datetime() {
		return cp_exit_datetime;
	}
	public void setCp_exit_datetime(Timestamp cp_exit_datetime) {
		this.cp_exit_datetime = cp_exit_datetime;
	}
	public String getCp_intro_content() {
		return cp_intro_content;
	}
	public void setCp_intro_content(String cp_intro_content) {
		this.cp_intro_content = cp_intro_content;
	}
	public String getCp_purpose() {
		return cp_purpose;
	}
	public void setCp_purpose(String cp_purpose) {
		this.cp_purpose = cp_purpose;
	}
	public String getCp_point_comment() {
		return cp_point_comment;
	}
	public void setCp_point_comment(String cp_point_comment) {
		this.cp_point_comment = cp_point_comment;
	}
	public Timestamp getCp_update_datetime() {
		return cp_update_datetime;
	}
	public void setCp_update_datetime(Timestamp cp_update_datetime) {
		this.cp_update_datetime = cp_update_datetime;
	}
	public String getCp_business_risk() {
		return cp_business_risk;
	}
	public void setCp_business_risk(String cp_business_risk) {
		this.cp_business_risk = cp_business_risk;
	}
	public String getCp_company_risk() {
		return cp_company_risk;
	}
	public void setCp_company_risk(String cp_company_risk) {
		this.cp_company_risk = cp_company_risk;
	}
	public String getCp_other_risks() {
		return cp_other_risks;
	}
	public void setCp_other_risks(String cp_other_risks) {
		this.cp_other_risks = cp_other_risks;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
