package net.company.dto;

import java.sql.Timestamp;
import java.util.Date;

public class CompanyBean {

	// 유정 추가
	// 투자하기 뷰에서 select할 때 모든 기업 관련 정보 한번에 가져오는 빈
	
	// CompanyVO
	private int cp_idx;
	private String cp_name;
	private String cp_number;
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
	
	// InvestVO
	// 태훈 추가
	private String iv_percent;					// 현재 투자율
	private String iv_goal_amount;				// 투자 - 목표금액
	private String iv_current_amount;			// 투자 - 현재투자된 금액
	private String iv_min_amount;				// 투자 - 최소금액(1구좌 금액)
	private String iv_balance_stock;			// 잔여구좌
	private Date iv_appl_start_date_time;		// 기업투자 모집 start
	private Date iv_appl_stop_date_time;		// 기업 투자 모집 end
	private String iv_contraction_during;		// 투자계약기간
	private String iv_possible_amount;			// 투자 가능 금액
	private String iv_current_participants;		// 현재 참여 인원
	
	// Company_pay_scheduleVO
	private String cp_pay_count;
	private String cp_pay_expected_payment_date;
	private String cp_pay_principal;
	private String cp_pay_interest_paid;
	private String cp_pay_fees;
	private String cp_pay_actual_payment_amout;
	private String cp_pay_actual_rate_return;
	
	// Company_revenueVO
	private int cp_pre_sales;
	private int cp_pre_stuff;
	private int cp_pre_costs_person;
	private int cp_pre_lease_expenses;
	private int cp_pre_operating_expenses;
	private int cp_pre_net_income;
	private int cp_pre_cash_dividend_ratio;
	private int cp_pre_share;
	private int cp_pre_platform;
	private int cp_pre_proceeds;
	private int cp_pre_avg_monthly;
	private int cp_pre_net_profit_ratio;
	private int cp_pre_interest_rate;
	
	// CompanyFileVO
	private String cf_registration;
	private String cf_financial;
	private String cf_estate_contract;
	private String cf_image1;
	private String cf_image2;
	private String cf_image3;
	private String cf_image4;
	private String cf_image5;
	private String cf_etc;
	// 20190723추가//
	private String cf_certificate;
	private String cf_image6;
	private String cp_branch;
	private String cp_intro_headline;
	
	
	
	public String getIv_percent() {
		return iv_percent;
	}
	public void setIv_percent(String iv_percent) {
		this.iv_percent = iv_percent;
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
	public String getCf_certificate() {
		return cf_certificate;
	}
	public void setCf_certificate(String cf_certificate) {
		this.cf_certificate = cf_certificate;
	}
	public String getCf_image6() {
		return cf_image6;
	}
	public void setCf_image6(String cf_image6) {
		this.cf_image6 = cf_image6;
	}
	public String getCp_pay_count() {
		return cp_pay_count;
	}
	public void setCp_pay_count(String cp_pay_count) {
		this.cp_pay_count = cp_pay_count;
	}
	public String getCp_pay_expected_payment_date() {
		return cp_pay_expected_payment_date;
	}
	public void setCp_pay_expected_payment_date(String cp_pay_expected_payment_date) {
		this.cp_pay_expected_payment_date = cp_pay_expected_payment_date;
	}
	public String getCp_pay_principal() {
		return cp_pay_principal;
	}
	public void setCp_pay_principal(String cp_pay_principal) {
		this.cp_pay_principal = cp_pay_principal;
	}
	public String getCp_pay_interest_paid() {
		return cp_pay_interest_paid;
	}
	public void setCp_pay_interest_paid(String cp_pay_interest_paid) {
		this.cp_pay_interest_paid = cp_pay_interest_paid;
	}
	public String getCp_pay_fees() {
		return cp_pay_fees;
	}
	public void setCp_pay_fees(String cp_pay_fees) {
		this.cp_pay_fees = cp_pay_fees;
	}
	public String getCp_pay_actual_payment_amout() {
		return cp_pay_actual_payment_amout;
	}
	public void setCp_pay_actual_payment_amout(String cp_pay_actual_payment_amout) {
		this.cp_pay_actual_payment_amout = cp_pay_actual_payment_amout;
	}
	public String getCp_pay_actual_rate_return() {
		return cp_pay_actual_rate_return;
	}
	public void setCp_pay_actual_rate_return(String cp_pay_actual_rate_return) {
		this.cp_pay_actual_rate_return = cp_pay_actual_rate_return;
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
	public String getIv_min_amount() {
		return iv_min_amount;
	}
	public void setIv_min_amount(String iv_min_amount) {
		this.iv_min_amount = iv_min_amount;
	}
	public String getIv_balance_stock() {
		return iv_balance_stock;
	}
	public void setIv_balance_stock(String iv_balance_stock) {
		this.iv_balance_stock = iv_balance_stock;
	}
	public Date getIv_appl_start_date_time() {
		return iv_appl_start_date_time;
	}
	public void setIv_appl_start_date_time(Date iv_appl_start_date_time) {
		this.iv_appl_start_date_time = iv_appl_start_date_time;
	}
	public Date getIv_appl_stop_date_time() {
		return iv_appl_stop_date_time;
	}
	public void setIv_appl_stop_date_time(Date iv_appl_stop_date_time) {
		this.iv_appl_stop_date_time = iv_appl_stop_date_time;
	}
	public String getIv_contraction_during() {
		return iv_contraction_during;
	}
	public void setIv_contraction_during(String iv_contraction_during) {
		this.iv_contraction_during = iv_contraction_during;
	}
	public String getIv_possible_amount() {
		return iv_possible_amount;
	}
	public void setIv_possible_amount(String iv_possible_amount) {
		this.iv_possible_amount = iv_possible_amount;
	}
	public String getIv_current_participants() {
		return iv_current_participants;
	}
	public void setIv_current_participants(String iv_current_participants) {
		this.iv_current_participants = iv_current_participants;
	}
	public int getCp_pre_sales() {
		return cp_pre_sales;
	}
	public void setCp_pre_sales(int cp_pre_sales) {
		this.cp_pre_sales = cp_pre_sales;
	}
	public int getCp_pre_stuff() {
		return cp_pre_stuff;
	}
	public void setCp_pre_stuff(int cp_pre_stuff) {
		this.cp_pre_stuff = cp_pre_stuff;
	}
	public int getCp_pre_costs_person() {
		return cp_pre_costs_person;
	}
	public void setCp_pre_costs_person(int cp_pre_costs_person) {
		this.cp_pre_costs_person = cp_pre_costs_person;
	}
	public int getCp_pre_lease_expenses() {
		return cp_pre_lease_expenses;
	}
	public void setCp_pre_lease_expenses(int cp_pre_lease_expenses) {
		this.cp_pre_lease_expenses = cp_pre_lease_expenses;
	}
	public int getCp_pre_operating_expenses() {
		return cp_pre_operating_expenses;
	}
	public void setCp_pre_operating_expenses(int cp_pre_operating_expenses) {
		this.cp_pre_operating_expenses = cp_pre_operating_expenses;
	}
	public int getCp_pre_net_income() {
		return cp_pre_net_income;
	}
	public void setCp_pre_net_income(int cp_pre_net_income) {
		this.cp_pre_net_income = cp_pre_net_income;
	}
	public int getCp_pre_cash_dividend_ratio() {
		return cp_pre_cash_dividend_ratio;
	}
	public void setCp_pre_cash_dividend_ratio(int cp_pre_cash_dividend_ratio) {
		this.cp_pre_cash_dividend_ratio = cp_pre_cash_dividend_ratio;
	}
	public int getCp_pre_share() {
		return cp_pre_share;
	}
	public void setCp_pre_share(int cp_pre_share) {
		this.cp_pre_share = cp_pre_share;
	}
	public int getCp_pre_platform() {
		return cp_pre_platform;
	}
	public void setCp_pre_platform(int cp_pre_platform) {
		this.cp_pre_platform = cp_pre_platform;
	}
	public int getCp_pre_proceeds() {
		return cp_pre_proceeds;
	}
	public void setCp_pre_proceeds(int cp_pre_proceeds) {
		this.cp_pre_proceeds = cp_pre_proceeds;
	}
	public int getCp_pre_avg_monthly() {
		return cp_pre_avg_monthly;
	}
	public void setCp_pre_avg_monthly(int cp_pre_avg_monthly) {
		this.cp_pre_avg_monthly = cp_pre_avg_monthly;
	}
	public int getCp_pre_net_profit_ratio() {
		return cp_pre_net_profit_ratio;
	}
	public void setCp_pre_net_profit_ratio(int cp_pre_net_profit_ratio) {
		this.cp_pre_net_profit_ratio = cp_pre_net_profit_ratio;
	}
	public int getCp_pre_interest_rate() {
		return cp_pre_interest_rate;
	}
	public void setCp_pre_interest_rate(int cp_pre_interest_rate) {
		this.cp_pre_interest_rate = cp_pre_interest_rate;
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
	}
	public String getCf_estate_contract() {
		return cf_estate_contract;
	}
	public void setCf_estate_contract(String cf_estate_contract) {
		this.cf_estate_contract = cf_estate_contract;
	}
	public String getCf_image1() {
		return cf_image1;
	}
	public void setCf_image1(String cf_image1) {
		this.cf_image1 = cf_image1;
	}
	public String getCf_image2() {
		return cf_image2;
	}
	public void setCf_image2(String cf_image2) {
		this.cf_image2 = cf_image2;
	}
	public String getCf_image3() {
		return cf_image3;
	}
	public void setCf_image3(String cf_image3) {
		this.cf_image3 = cf_image3;
	}
	public String getCf_image4() {
		return cf_image4;
	}
	public void setCf_image4(String cf_image4) {
		this.cf_image4 = cf_image4;
	}
	public String getCf_image5() {
		return cf_image5;
	}
	public void setCf_image5(String cf_image5) {
		this.cf_image5 = cf_image5;
	}
	public String getCf_etc() {
		return cf_etc;
	}
	public void setCf_etc(String cf_etc) {
		this.cf_etc = cf_etc;
	}
	@Override
	public String toString() {
		return "CompanyBean [cp_idx=" + cp_idx + ", cp_name=" + cp_name + ", cp_number=" + cp_number + ", cp_manager="
				+ cp_manager + ", cp_phone=" + cp_phone + ", cp_sector=" + cp_sector + ", cp_add_num=" + cp_add_num
				+ ", cp_add_ch=" + cp_add_ch + ", cp_add_more=" + cp_add_more + ", cp_lat=" + cp_lat + ", cp_lng="
				+ cp_lng + ", cp_add_extra=" + cp_add_extra + ", cp_capital=" + cp_capital + ", cp_open_datetime="
				+ cp_open_datetime + ", cp_avg_monthly_sales=" + cp_avg_monthly_sales + ", cp_monthly_profit="
				+ cp_monthly_profit + ", cp_reg_datetime=" + cp_reg_datetime + ", cp_exit_datetime=" + cp_exit_datetime
				+ ", cp_intro_content=" + cp_intro_content + ", cp_purpose=" + cp_purpose + ", cp_point_comment="
				+ cp_point_comment + ", cp_update_datetime=" + cp_update_datetime + ", cp_business_risk="
				+ cp_business_risk + ", cp_company_risk=" + cp_company_risk + ", cp_other_risks=" + cp_other_risks
				+ ", iv_percent=" + iv_percent + ", iv_goal_amount=" + iv_goal_amount + ", iv_current_amount="
				+ iv_current_amount + ", iv_min_amount=" + iv_min_amount + ", iv_balance_stock=" + iv_balance_stock
				+ ", iv_appl_start_date_time=" + iv_appl_start_date_time + ", iv_appl_stop_date_time="
				+ iv_appl_stop_date_time + ", iv_contraction_during=" + iv_contraction_during + ", iv_possible_amount="
				+ iv_possible_amount + ", iv_current_participants=" + iv_current_participants + ", cp_pay_count="
				+ cp_pay_count + ", cp_pay_expected_payment_date=" + cp_pay_expected_payment_date
				+ ", cp_pay_principal=" + cp_pay_principal + ", cp_pay_interest_paid=" + cp_pay_interest_paid
				+ ", cp_pay_fees=" + cp_pay_fees + ", cp_pay_actual_payment_amout=" + cp_pay_actual_payment_amout
				+ ", cp_pay_actual_rate_return=" + cp_pay_actual_rate_return + ", cp_pre_sales=" + cp_pre_sales
				+ ", cp_pre_stuff=" + cp_pre_stuff + ", cp_pre_costs_person=" + cp_pre_costs_person
				+ ", cp_pre_lease_expenses=" + cp_pre_lease_expenses + ", cp_pre_operating_expenses="
				+ cp_pre_operating_expenses + ", cp_pre_net_income=" + cp_pre_net_income
				+ ", cp_pre_cash_dividend_ratio=" + cp_pre_cash_dividend_ratio + ", cp_pre_share=" + cp_pre_share
				+ ", cp_pre_platform=" + cp_pre_platform + ", cp_pre_proceeds=" + cp_pre_proceeds
				+ ", cp_pre_avg_monthly=" + cp_pre_avg_monthly + ", cp_pre_net_profit_ratio=" + cp_pre_net_profit_ratio
				+ ", cp_pre_interest_rate=" + cp_pre_interest_rate + ", cf_registration=" + cf_registration
				+ ", cf_financial=" + cf_financial + ", cf_estate_contract=" + cf_estate_contract + ", cf_image1="
				+ cf_image1 + ", cf_image2=" + cf_image2 + ", cf_image3=" + cf_image3 + ", cf_image4=" + cf_image4
				+ ", cf_image5=" + cf_image5 + ", cf_etc=" + cf_etc + ", cf_certificate=" + cf_certificate
				+ ", cf_image6=" + cf_image6 + ", cp_branch=" + cp_branch + ", cp_intro_headline=" + cp_intro_headline
				+ "]";
	}
	
	
	
}
