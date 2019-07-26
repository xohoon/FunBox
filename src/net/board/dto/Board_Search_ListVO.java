package net.board.dto;

/// 태훈 추가 - 프렌차이즈 검색 리스트 VO
public class Board_Search_ListVO {
	
	private String search_cp_idx;						// 검색 리스트 기업 식별자
//	private String search_cp_image;					// 검색 리스트 이미지
	private String search_cp_name;					// 검색 리스트 기업 이름
	private String search_cp_sector;				// 검색 리스트 기업 업종
	private String search_cp_branch;				// 검색 리스트 기업 지점
	private String search_cp_profit;				// 검색 리스트 수익율
	private String search_cp_current_amount;		// 검색 리스트 현재 투자
	private String search_cp_goal_amount;			// 검색 리스트 목표 투자
	private String search_cp_percent;				// 검색 리스트 수익율
	
	
	public String getSearch_cp_idx() {
		return search_cp_idx;
	}


	public void setSearch_cp_idx(String search_cp_idx) {
		this.search_cp_idx = search_cp_idx;
	}


	public String getSearch_cp_name() {
		return search_cp_name;
	}


	public void setSearch_cp_name(String search_cp_name) {
		this.search_cp_name = search_cp_name;
	}


	public String getSearch_cp_sector() {
		return search_cp_sector;
	}


	public void setSearch_cp_sector(String search_cp_sector) {
		this.search_cp_sector = search_cp_sector;
	}


	public String getSearch_cp_branch() {
		return search_cp_branch;
	}


	public void setSearch_cp_branch(String search_cp_branch) {
		this.search_cp_branch = search_cp_branch;
	}


	public String getSearch_cp_profit() {
		return search_cp_profit;
	}


	public void setSearch_cp_profit(String search_cp_profit) {
		this.search_cp_profit = search_cp_profit;
	}


	public String getSearch_cp_current_amount() {
		return search_cp_current_amount;
	}


	public void setSearch_cp_current_amount(String search_cp_current_amount) {
		this.search_cp_current_amount = search_cp_current_amount;
	}


	public String getSearch_cp_goal_amount() {
		return search_cp_goal_amount;
	}


	public void setSearch_cp_goal_amount(String search_cp_goal_amount) {
		this.search_cp_goal_amount = search_cp_goal_amount;
	}


	public String getSearch_cp_percent() {
		return search_cp_percent;
	}


	public void setSearch_cp_percent(String search_cp_percent) {
		this.search_cp_percent = search_cp_percent;
	}


	@Override
	public String toString() {
		return "Board_Search_ListVO [search_cp_idx=" + search_cp_idx + ", search_cp_name=" + search_cp_name
				+ ", search_cp_sector=" + search_cp_sector + ", search_cp_branch=" + search_cp_branch
				+ ", search_cp_profit=" + search_cp_profit + ", search_cp_current_amount=" + search_cp_current_amount
				+ ", search_cp_goal_amount=" + search_cp_goal_amount + ", search_cp_percent=" + search_cp_percent + "]";
	}
	

}
