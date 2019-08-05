package net.money.dto;

import java.util.Date;

public class TokenDepositVO {
	private int td_idx;
	private int mb_idx;
	private String td_to_address;
	private String td_from_address;
	private String td_tx_hash;
	private String td_amount;
	private int td_status;
	private Date td_date_time;
	private Date td_accept_date_time;
	private Date td_cancel_date_time;
	public int getTd_idx() {
		return td_idx;
	}
	public void setTd_idx(int td_idx) {
		this.td_idx = td_idx;
	}
	public int getMb_idx() {
		return mb_idx;
	}
	public void setMb_idx(int mb_idx) {
		this.mb_idx = mb_idx;
	}
	public String getTd_to_address() {
		return td_to_address;
	}
	public void setTd_to_address(String td_to_address) {
		this.td_to_address = td_to_address;
	}
	public String getTd_from_address() {
		return td_from_address;
	}
	public void setTd_from_address(String td_from_address) {
		this.td_from_address = td_from_address;
	}
	public String getTd_tx_hash() {
		return td_tx_hash;
	}
	public void setTd_tx_hash(String td_tx_hash) {
		this.td_tx_hash = td_tx_hash;
	}
	public String getTd_amount() {
		return td_amount;
	}
	public void setTd_amount(String td_amount) {
		this.td_amount = td_amount;
	}
	public int getTd_status() {
		return td_status;
	}
	public void setTd_status(int td_status) {
		this.td_status = td_status;
	}
	public Date getTd_date_time() {
		return td_date_time;
	}
	public void setTd_date_time(Date td_date_time) {
		this.td_date_time = td_date_time;
	}
	public Date getTd_accept_date_time() {
		return td_accept_date_time;
	}
	public void setTd_accept_date_time(Date td_accept_date_time) {
		this.td_accept_date_time = td_accept_date_time;
	}
	public Date getTd_cancel_date_time() {
		return td_cancel_date_time;
	}
	public void setTd_cancel_date_time(Date td_cancel_date_time) {
		this.td_cancel_date_time = td_cancel_date_time;
	}
	
	
}
