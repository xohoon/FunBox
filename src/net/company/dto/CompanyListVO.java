package net.company.dto;

public class CompanyListVO {
	
	private int cp_idx;
	private String cp_name;
	
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
	
	@Override
	public String toString() {
		return "CompanyListVO [cp_idx=" + cp_idx + ", cp_name=" + cp_name + "]";
	}
	
}
