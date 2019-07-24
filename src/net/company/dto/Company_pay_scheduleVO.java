package net.company.dto;

public class Company_pay_scheduleVO {
	
	private int cp_idx;
	private String cp_pay_count;
	private String cp_pay_expected_payment_date;
	private String cp_pay_principal;
	private String cp_pay_interest_paid;
	private String cp_pay_fees;
	private String cp_pay_actual_payment_amout;
	private String cp_pay_actual_rate_return;
	
	public int getCp_idx() {
		return cp_idx;
	}

	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
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

	@Override
	public String toString() {
		return "Company_pay_schedule [cp_idx=" + cp_idx + ", cp_pay_count=" + cp_pay_count
				+ ", cp_pay_expected_payment_date=" + cp_pay_expected_payment_date + ", cp_pay_principal="
				+ cp_pay_principal + ", cp_pay_interest_paid=" + cp_pay_interest_paid + ", cp_pay_fees=" + cp_pay_fees
				+ ", cp_pay_actual_payment_amout=" + cp_pay_actual_payment_amout + ", cp_pay_actual_rate_return="
				+ cp_pay_actual_rate_return + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
