package net.company.dto;

import java.util.Date;

public class InvestVO {

	// 유정 InvestVO
	private String cp_idx;
	private String goal_amount;				// 투자 - 목표금액
	private String current_amount;			// 투자 - 현재투자된 금액
	private String min_amount;				// 투자 - 최소금액(1구좌 금액)
	private String balance_stock;			// 잔여구좌
	private Date appl_start_date_time;		// 기업투자 모집 start
	private Date appl_stop_date_time;		// 기업 투자 모집 end
	private String contraction_during;		// 투자계약기간
	private String possible_amount;			// 투자 가능 금액
	private String current_participants;	// 현재 참여 인원
	
	
	public String getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(String cp_idx) {
		this.cp_idx = cp_idx;
	}
	public String getGoal_amount() {
		return goal_amount;
	}
	public void setGoal_amount(String goal_amount) {
		this.goal_amount = goal_amount;
	}
	public String getCurrent_amount() {
		return current_amount;
	}
	public void setCurrent_amount(String current_amount) {
		this.current_amount = current_amount;
	}
	public String getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(String min_amount) {
		this.min_amount = min_amount;
	}
	public String getBalance_stock() {
		return balance_stock;
	}
	public void setBalance_stock(String balance_stock) {
		this.balance_stock = balance_stock;
	}
	public Date getAppl_start_date_time() {
		return appl_start_date_time;
	}
	public void setAppl_start_date_time(Date appl_start_date_time) {
		this.appl_start_date_time = appl_start_date_time;
	}
	public Date getAppl_stop_date_time() {
		return appl_stop_date_time;
	}
	public void setAppl_stop_date_time(Date appl_stop_date_time) {
		this.appl_stop_date_time = appl_stop_date_time;
	}
	public String getContraction_during() {
		return contraction_during;
	}
	public void setContraction_during(String contraction_during) {
		this.contraction_during = contraction_during;
	}
	public String getPossible_amount() {
		return possible_amount;
	}
	public void setPossible_amount(String possible_amount) {
		this.possible_amount = possible_amount;
	}
	public String getCurrent_participants() {
		return current_participants;
	}
	public void setCurrent_participants(String current_participants) {
		this.current_participants = current_participants;
	}
}
