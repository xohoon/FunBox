package net.member.dto;

public class Member_headerVO {
	
	private String mb_token;
	private String mb_point;
	private String mb_accumulate;
	
	public String getMb_token() {
		return mb_token;
	}
	public void setMb_token(String mb_token) {
		this.mb_token = mb_token;
	}
	public String getMb_point() {
		return mb_point;
	}
	public void setMb_point(String mb_point) {
		this.mb_point = mb_point;
	}
	public String getMb_accumulate() {
		return mb_accumulate;
	}
	public void setMb_accumulate(String mb_accumulate) {
		this.mb_accumulate = mb_accumulate;
	}
	@Override
	public String toString() {
		return "Member_header [mb_token=" + mb_token + ", mb_point=" + mb_point + ", mb_accumulate=" + mb_accumulate
				+ "]";
	}
	
	
	

}
