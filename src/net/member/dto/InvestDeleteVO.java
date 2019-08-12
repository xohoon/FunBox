package net.member.dto;


////  태훈 추가  - 철회 하기 기업 정보
public class InvestDeleteVO {
	
	private int mi_idx;
	private String cp_name;
	private String mi_point;
	
	public int getMi_idx() {
		return mi_idx;
	}
	public void setMi_idx(int mi_idx) {
		this.mi_idx = mi_idx;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getMi_point() {
		return mi_point;
	}
	public void setMi_point(String mi_point) {
		this.mi_point = mi_point;
	}
	@Override
	public String toString() {
		return "InvestDeleteVO [mi_idx=" + mi_idx + ", cp_name=" + cp_name + ", mi_point=" + mi_point + "]";
	}

}
