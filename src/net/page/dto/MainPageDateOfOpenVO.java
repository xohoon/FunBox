package net.page.dto;

import java.util.Date;

public class MainPageDateOfOpenVO {
	private int cp_idx;
	private String banner_image;
	private String cp_name;
	private String cp_intro_headline;
	private String cp_intro_content;
	private Date cp_open_datetime;

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

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getCp_intro_headline() {
		return cp_intro_headline;
	}

	public void setCp_intro_headline(String cp_intro_headline) {
		this.cp_intro_headline = cp_intro_headline;
	}

	public String getCp_intro_content() {
		return cp_intro_content;
	}

	public void setCp_intro_content(String cp_intro_content) {
		this.cp_intro_content = cp_intro_content;
	}

	public Date getCp_open_datetime() {
		return cp_open_datetime;
	}

	public void setCp_open_datetime(Date cp_open_datetime) {
		this.cp_open_datetime = cp_open_datetime;
	}

	@Override
	public String toString() {
		return "MainPageDateOfOpenVO [cp_idx=" + cp_idx + ", banner_image=" + banner_image + ", cp_name=" + cp_name
				+ ", cp_intro_headline=" + cp_intro_headline + ", cp_intro_content=" + cp_intro_content
				+ ", cp_open_datetime=" + cp_open_datetime + "]";
	}

}
