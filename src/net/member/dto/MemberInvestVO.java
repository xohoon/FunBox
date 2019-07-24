package net.member.dto;

public class MemberInvestVO {
	
	private int mi_idx;
	private int mi_id;
	private String mb_id;
	private String name;
	private String point;
	private int cp_idx;
	private String hoiling_stock;
	private String mi_stock_value;
	private String mi_monthly_pofit;
	private String mi_branch;
	
	public int getMi_idx() {
		return mi_idx;
	}
	public void setMi_idx(int mi_idx) {
		this.mi_idx = mi_idx;
	}
	public int getMi_id() {
		return mi_id;
	}
	public void setMi_id(int mi_id) {
		this.mi_id = mi_id;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public int getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}
	public String getHoiling_stock() {
		return hoiling_stock;
	}
	public void setHoiling_stock(String hoiling_stock) {
		this.hoiling_stock = hoiling_stock;
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
	public String getMi_branch() {
		return mi_branch;
	}
	public void setMi_branch(String mi_branch) {
		this.mi_branch = mi_branch;
	}

	private String mi_cumulative_pofit;
	private String mi_reg_date_time;
	private String mi_cancel_date_time;

	@Override
	public String toString() {
		return "MemberInvest [mi_idx=" + mi_idx + ", mi_id=" + mi_id + ", name=" + name + ", point=" + point
				+ ", cp_idx=" + cp_idx + ", hoiling_stock=" + hoiling_stock + ", mi_stock_value=" + mi_stock_value
				+ ", mi_monthly_pofit=" + mi_monthly_pofit + ", mi_cumulative_pofit=" + mi_cumulative_pofit
				+ ", mi_reg_date_time=" + mi_reg_date_time + ", mi_cancel_date_time=" + mi_cancel_date_time + "]";
	}
	
	

}
