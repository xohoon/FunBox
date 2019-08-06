package net.member.dto;

public class MemberTransactionVO {
	
	private String td_status;
	private String td_to_address;
	private String td_from_address;
	private String td_amount;
	private String td_date_time;
	public String getTd_status() {
		return td_status;
	}
	public void setTd_status(String td_status) {
		this.td_status = td_status;
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
	public String getTd_amount() {
		return td_amount;
	}
	public void setTd_amount(String td_amount) {
		this.td_amount = td_amount;
	}
	public String getTd_date_time() {
		return td_date_time;
	}
	public void setTd_date_time(String td_date_time) {
		this.td_date_time = td_date_time;
	}
	
	@Override
	public String toString() {
		return "MemberTransactionVO [td_status=" + td_status + ", td_to_address=" + td_to_address + ", td_from_address="
				+ td_from_address + ", td_amount=" + td_amount + ", td_date_time=" + td_date_time + "]";
	}
	
		
	
}
