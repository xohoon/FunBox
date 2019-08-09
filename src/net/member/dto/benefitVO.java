package net.member.dto;

public class benefitVO {
	
	private String month_benefit;
	private String total_benefit;
	
	public String getMonth_benefit() {
		return month_benefit;
	}
	public void setMonth_benefit(String month_benefit) {
		this.month_benefit = month_benefit;
	}
	public String getTotal_benefit() {
		return total_benefit;
	}
	public void setTotal_benefit(String total_benefit) {
		this.total_benefit = total_benefit;
	}
	
	@Override
	public String toString() {
		return "benefitVO [month_benefit=" + month_benefit + ", total_benefit=" + total_benefit + "]";
	}
	
	
	

}
