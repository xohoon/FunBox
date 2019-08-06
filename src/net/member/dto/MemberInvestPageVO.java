package net.member.dto;

public class MemberInvestPageVO {

	private int mi_idx;
	private int mb_idx;
	private String mi_name;
	private String mi_point;
	private int cp_idx;
	private String mi_hoiling_stock;
	private String mi_stock_value;
	private String mi_monthly_profit;
	private String mi_cumulative_profit;
	private String cp_number;
	private String cp_capital;
	private String cp_add_ch;
	private String cp_name;
	private String cp_manager;	
	private String cf_certificate;
	private String cf_estate_contract;
	private String cf_registration;
	private String cf_financial;
	private String[] cf_financial_arr;
	
	
	
	public String getCf_certificate() {
		return cf_certificate;
	}

	public void setCf_certificate(String cf_certificate) {
		this.cf_certificate = cf_certificate;
	}

	public String getCf_estate_contract() {
		return cf_estate_contract;
	}

	public void setCf_estate_contract(String cf_estate_contract) {
		this.cf_estate_contract = cf_estate_contract;
	}

	public String getCf_registration() {
		return cf_registration;
	}

	public void setCf_registration(String cf_registration) {
		this.cf_registration = cf_registration;
	}

	public String getCf_financial() {
		return cf_financial;
	}

	public void setCf_financial(String cf_financial) {
		this.cf_financial = cf_financial;
		this.cf_financial_arr = this.cf_financial.split(",");
	}

	
	public String[] getCf_financial_arr() {
		return cf_financial_arr;
	}

	public void setCf_financial_arr(String[] cf_financial_arr) {
		this.cf_financial_arr = cf_financial_arr;
	}

	public String getMi_cumulative_profit() {
		return mi_cumulative_profit;
	}

	public void setMi_cumulative_profit(String mi_cumulative_profit) {
		this.mi_cumulative_profit = mi_cumulative_profit;
	}

	public String getCp_manager() {
		return cp_manager;
	}

	public void setCp_manager(String cp_manager) {
		this.cp_manager = cp_manager;
	}

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public int getMi_idx() {
		return mi_idx;
	}

	public void setMi_idx(int mi_idx) {
		this.mi_idx = mi_idx;
	}

	public int getMb_idx() {
		return mb_idx;
	}

	public void setMb_idx(int mb_idx) {
		this.mb_idx = mb_idx;
	}

	public String getMi_monthly_profit() {
		return mi_monthly_profit;
	}

	public void setMi_monthly_profit(String mi_monthly_pofit) {
		this.mi_monthly_profit = mi_monthly_pofit;
	}

	public int getCp_idx() {
		return cp_idx;
	}

	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}

	public String getMi_name() {
		return mi_name;
	}

	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}

	public String getMi_point() {
		return mi_point;
	}

	public void setMi_point(String mi_point) {
		this.mi_point = mi_point;
	}

	public String getMi_hoiling_stock() {
		return mi_hoiling_stock;
	}

	public void setMi_hoiling_stock(String mi_hoiling_stock) {
		this.mi_hoiling_stock = mi_hoiling_stock;
	}

	public String getMi_stock_value() {
		return mi_stock_value;
	}

	public void setMi_stock_value(String mi_stock_value) {
		this.mi_stock_value = mi_stock_value;
	}

	public String getMi_cumulative_pofit() {
		return mi_cumulative_pofit;
	}

	public void setMi_cumulative_pofit(String mi_cumulative_pofit) {
		this.mi_cumulative_pofit = mi_cumulative_pofit;
	}

	public String getMi_reg_date_time() {
		return mi_reg_date_time;
	}

	public void setMi_reg_date_time(String mi_reg_date_time) {
		this.mi_reg_date_time = mi_reg_date_time;
	}

	public String getMi_cancel_date_time() {
		return mi_cancel_date_time;
	}

	public void setMi_cancel_date_time(String mi_cancel_date_time) {
		this.mi_cancel_date_time = mi_cancel_date_time;
	}

	public String getCp_number() {
		return cp_number;
	}

	public void setCp_number(String cp_number) {
		this.cp_number = cp_number;
	}

	public String getCp_capital() {
		return cp_capital;
	}

	public void setCp_capital(String cp_capital) {
		this.cp_capital = cp_capital;
	}

	public String getCp_add_ch() {
		return cp_add_ch;
	}

	public void setCp_add_ch(String cp_add_ch) {
		this.cp_add_ch = cp_add_ch;
	}

	private String mi_cumulative_pofit;
	private String mi_reg_date_time;
	private String mi_cancel_date_time;

	@Override
	public String toString() {
		return "MemberInvestVO [mi_idx=" + mi_idx + ", mb_idx=" + mb_idx + ", mi_name=" + mi_name + ", mi_point="
				+ mi_point + ", cp_idx=" + cp_idx + ", mi_hoiling_stock=" + mi_hoiling_stock + ", mi_stock_value="
				+ mi_stock_value + ", mi_monthly_profit=" + mi_monthly_profit + ", cp_number=" + cp_number
				+ ", cp_capital=" + cp_capital + ", cp_add_ch=" + cp_add_ch + ", cp_name=" + cp_name
				+ ", mi_cumulative_pofit=" + mi_cumulative_pofit + ", mi_reg_date_time=" + mi_reg_date_time
				+ ", mi_cancel_date_time=" + mi_cancel_date_time + "]";
	}

	

	

	
}
