package net.company.dto;

public class CompanyListVO {
	
	private int cp_idx;
	private String cp_name;
	private boolean cp_recommand;
	private boolean cp_best;
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
	
	
	
}

