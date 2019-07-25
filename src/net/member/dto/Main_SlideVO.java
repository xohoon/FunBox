package net.member.dto;

////////// 태훈 추가 - 메인페이지 슬라이드 기업 리스트 //////////
public class Main_SlideVO {

//	private String sl_image;		 기업 이미지
	private String sl_cp_name;		// 기업 이름
	private String sl_cp_branch;	// 기업 지점
	private String sl_cp_content;	// 기업 소개
	/*
	 * public String getSl_image() { return sl_image; } public void
	 * setSl_image(String sl_image) { this.sl_image = sl_image; }
	 */
	public String getSl_cp_name() {
		return sl_cp_name;
	}
	public void setSl_cp_name(String sl_cp_name) {
		this.sl_cp_name = sl_cp_name;
	}
	public String getSl_cp_branch() {
		return sl_cp_branch;
	}
	public void setSl_cp_branch(String sl_cp_branch) {
		this.sl_cp_branch = sl_cp_branch;
	}
	public String getSl_cp_content() {
		return sl_cp_content;
	}
	public void setSl_cp_content(String sl_cp_content) {
		this.sl_cp_content = sl_cp_content;
	}
	@Override
	public String toString() {
		return "Main_SlideVO [sl_cp_name=" + sl_cp_name + ", sl_cp_branch=" + sl_cp_branch
				+ ", sl_cp_content=" + sl_cp_content + "]";
	}
	
	

	
	
	
}
