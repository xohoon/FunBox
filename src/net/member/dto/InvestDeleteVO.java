package net.member.dto;


////  태훈 추가  - 철회 하기 기업 정보
public class InvestDeleteVO {
	
	private int mi_idx;
	private String mi_name;
	private String mi_point;
	private int cp_dix;
	
	
	public int getCp_dix() {
		return cp_dix;
	}
	public void setCp_dix(int cp_dix) {
		this.cp_dix = cp_dix;
	}
	public String getMi_name() {
		return mi_name;
	}
	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}
	public int getMi_idx() {
		return mi_idx;
	}
	public void setMi_idx(int mi_idx) {
		this.mi_idx = mi_idx;
	}
	public String getMi_point() {
		return mi_point;
	}
	public void setMi_point(String mi_point) {
		this.mi_point = mi_point;
	}
	@Override
	public String toString() {
		return "InvestDeleteVO [mi_idx=" + mi_idx + ", mi_name=" + mi_name + ", mi_point=" + mi_point + ", cp_dix="
				+ cp_dix + "]";
	}

}
