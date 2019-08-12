package net.member.dto;

public class MemberInvestCompanyVO {
	private int mi_idx;
	private int cp_idx;
	private String cp_name;
	private int mb_idx;
	private String mb_id;
	private String cp_funding_status;
	
	
	public int getMi_idx() {
		return mi_idx;
	}
	public void setMi_idx(int mi_idx) {
		this.mi_idx = mi_idx;
	}
	public String getCp_funding_status() {
		return cp_funding_status;
	}
	public void setCp_funding_status(String cp_funding_status) {
		this.cp_funding_status = cp_funding_status;
	}
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
	public int getMb_idx() {
		return mb_idx;
	}
	public void setMb_idx(int mb_idx) {
		this.mb_idx = mb_idx;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	@Override
	public String toString() {
		return "MemberInvestCompanyVO [cp_idx=" + cp_idx + ", cp_name=" + cp_name + ", mb_idx=" + mb_idx + ", mb_id="
				+ mb_id + ", cp_funding_status=" + cp_funding_status + "]";
	}
	
	
	
}
