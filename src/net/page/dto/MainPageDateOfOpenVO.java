package net.page.dto;

public class MainPageDateOfOpenVO {
	private int cp_idx;
	private String banner_image;
	public int getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}
	public String getBanner_image() {
		return banner_image;
	}
	public void setBanner_image(String banner_image) {
		this.banner_image = banner_image;
	}
	@Override
	public String toString() {
		return "MainPageDateOfOpenVO [cp_idx=" + cp_idx + ", banner_image=" + banner_image + "]";
	}
	
	
}
