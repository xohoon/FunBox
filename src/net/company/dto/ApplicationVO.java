package net.company.dto;

import java.util.ArrayList;

public class ApplicationVO {

	// 태훈 application01
	private String mb_idx;
	private String app_cp_name;
	private String app_cp_manager;
	private String app_cp_hp;
	private String app_cp_num;
	private String app_cp_ch;
	private String app_cp_more;
	private String app_cp_extra;
	private String app_cp_sector;
	private String app_cp_open_date_time;
	private String app_cp_prestige;
	private String app_cp_deposit;
	private String app_cp_monthly;
	private int app_cp_status;

	// 태훈 application02
	private String app_cp_goal_amount;
	private String app_cp_avg_monthly_profit;
	private String app_cp_monthly_profit;
	private String app_cp_during;
	private String app_cp_inv_min_amount;

	// 유정 application03
	private String app_cp_introduction;
	private String app_cp_purpose;
	private String app_cp_point;

	// 신규 application04
	private String app_cp_registrantion;
	private String app_cp_financial;
	private String app_cp_estate_contract;
	private String app_cp_image1;
	private String app_cp_image2;
	private String app_cp_image3;
	private String app_cp_image4;
	private String app_cp_image5;
	private String app_cp_other_document1;
	private String app_cp_other_document2;
	private String app_cp_other_document3;
	private String app_cp_other_document4;
	private String app_cp_other_document5;

	private String app_cp_alias_registrantion;
	private String app_cp_alias_financial;
	private String app_cp_alias_estate_contract;
	private String app_cp_alias_image1;
	private String app_cp_alias_image2;
	private String app_cp_alias_image3;
	private String app_cp_alias_image4;
	private String app_cp_alias_image5;
	private String app_cp_alias_other_document1;
	private String app_cp_alias_other_document2;
	private String app_cp_alias_other_document3;
	private String app_cp_alias_other_document4;
	private String app_cp_alias_other_document5;

	private String app_cp_real_path;
	private String app_cp_folder;
	
	public String getMb_idx() {
		return mb_idx;
	}

	public void setMb_idx(String mb_idx) {
		this.mb_idx = mb_idx;
	}

	public int getApp_cp_status() {
		return app_cp_status;
	}

	public void setApp_cp_status(int app_cp_status) {
		this.app_cp_status = app_cp_status;
	}

	public String getApp_cp_name() {
		return app_cp_name;
	}

	public void setApp_cp_name(String app_cp_name) {
		this.app_cp_name = app_cp_name;
	}

	public String getApp_cp_manager() {
		return app_cp_manager;
	}

	public void setApp_cp_manager(String app_cp_manager) {
		this.app_cp_manager = app_cp_manager;
	}

	public String getApp_cp_hp() {
		return app_cp_hp;
	}

	public void setApp_cp_hp(String app_cp_hp) {
		this.app_cp_hp = app_cp_hp;
	}

	public String getApp_cp_num() {
		return app_cp_num;
	}

	public void setApp_cp_num(String app_cp_num) {
		this.app_cp_num = app_cp_num;
	}

	public String getApp_cp_ch() {
		return app_cp_ch;
	}

	public void setApp_cp_ch(String app_cp_ch) {
		this.app_cp_ch = app_cp_ch;
	}

	public String getApp_cp_more() {
		return app_cp_more;
	}

	public void setApp_cp_more(String app_cp_more) {
		this.app_cp_more = app_cp_more;
	}

	public String getApp_cp_extra() {
		return app_cp_extra;
	}

	public void setApp_cp_extra(String app_cp_extra) {
		this.app_cp_extra = app_cp_extra;
	}

	public String getApp_cp_sector() {
		return app_cp_sector;
	}

	public void setApp_cp_sector(String app_cp_sector) {
		this.app_cp_sector = app_cp_sector;
	}

	public String getApp_cp_open_date_time() {
		return app_cp_open_date_time;
	}

	public void setApp_cp_open_date_time(String app_cp_open_date_time) {
		this.app_cp_open_date_time = app_cp_open_date_time;
	}

	public String getApp_cp_prestige() {
		return app_cp_prestige;
	}

	public void setApp_cp_prestige(String app_cp_prestige) {
		this.app_cp_prestige = app_cp_prestige;
	}

	public String getApp_cp_deposit() {
		return app_cp_deposit;
	}

	public void setApp_cp_deposit(String app_cp_deposit) {
		this.app_cp_deposit = app_cp_deposit;
	}

	public String getApp_cp_monthly() {
		return app_cp_monthly;
	}

	public void setApp_cp_monthly(String app_cp_monthly) {
		this.app_cp_monthly = app_cp_monthly;
	}

	public String getApp_cp_goal_amount() {
		return app_cp_goal_amount;
	}

	public void setApp_cp_goal_amount(String app_cp_goal_amount) {
		this.app_cp_goal_amount = app_cp_goal_amount;
	}

	public String getApp_cp_avg_monthly_profit() {
		return app_cp_avg_monthly_profit;
	}

	public void setApp_cp_avg_monthly_profit(String app_cp_avg_monthly_profit) {
		this.app_cp_avg_monthly_profit = app_cp_avg_monthly_profit;
	}

	public String getApp_cp_monthly_profit() {
		return app_cp_monthly_profit;
	}

	public void setApp_cp_monthly_profit(String app_cp_monthly_profit) {
		this.app_cp_monthly_profit = app_cp_monthly_profit;
	}

	public String getApp_cp_during() {
		return app_cp_during;
	}

	public void setApp_cp_during(String app_cp_during) {
		this.app_cp_during = app_cp_during;
	}

	public String getApp_cp_inv_min_amount() {
		return app_cp_inv_min_amount;
	}

	public void setApp_cp_inv_min_amount(String app_cp_inv_min_amount) {
		this.app_cp_inv_min_amount = app_cp_inv_min_amount;
	}

	public String getApp_cp_introduction() {
		return app_cp_introduction;
	}

	public void setApp_cp_introduction(String app_cp_introduction) {
		this.app_cp_introduction = app_cp_introduction;
	}

	public String getApp_cp_purpose() {
		return app_cp_purpose;
	}

	public void setApp_cp_purpose(String app_cp_purpose) {
		this.app_cp_purpose = app_cp_purpose;
	}

	public String getApp_cp_point() {
		return app_cp_point;
	}

	public void setApp_cp_point(String app_cp_point) {
		this.app_cp_point = app_cp_point;
	}

	public String getApp_cp_registrantion() {
		return app_cp_registrantion;
	}

	public void setApp_cp_registrantion(String app_cp_registrantion) {
		this.app_cp_registrantion = app_cp_registrantion;
	}

	public String getApp_cp_financial() {
		return app_cp_financial;
	}

	public void setApp_cp_financial(String app_cp_financial) {
		this.app_cp_financial = app_cp_financial;
	}

	public String getApp_cp_estate_contract() {
		return app_cp_estate_contract;
	}

	public void setApp_cp_estate_contract(String app_cp_estate_contract) {
		this.app_cp_estate_contract = app_cp_estate_contract;
	}

	public String getApp_cp_image1() {
		return app_cp_image1;
	}

	public void setApp_cp_image1(String app_cp_image1) {
		this.app_cp_image1 = app_cp_image1;
	}

	public String getApp_cp_image2() {
		return app_cp_image2;
	}

	public void setApp_cp_image2(String app_cp_image2) {
		this.app_cp_image2 = app_cp_image2;
	}

	public String getApp_cp_image3() {
		return app_cp_image3;
	}

	public void setApp_cp_image3(String app_cp_image3) {
		this.app_cp_image3 = app_cp_image3;
	}

	public String getApp_cp_image4() {
		return app_cp_image4;
	}

	public void setApp_cp_image4(String app_cp_image4) {
		this.app_cp_image4 = app_cp_image4;
	}

	public String getApp_cp_image5() {
		return app_cp_image5;
	}

	public void setApp_cp_image5(String app_cp_image5) {
		this.app_cp_image5 = app_cp_image5;
	}

	public void setApp_cp_images(ArrayList<String> list) {
		this.app_cp_image1 = list.get(0);
		this.app_cp_image2 = list.get(1);
		this.app_cp_image3 = list.get(2);
		this.app_cp_image4 = list.get(3);
		this.app_cp_image5 = list.get(4);
	}

	public String getApp_cp_other_document1() {
		return app_cp_other_document1;
	}

	public void setApp_cp_other_document1(String app_cp_other_document1) {
		this.app_cp_other_document1 = app_cp_other_document1;
	}

	public void setApp_cp_other_documents(ArrayList<String> list) {
		this.app_cp_other_document1 = list.get(0);
		this.app_cp_other_document2 = list.get(1);
		this.app_cp_other_document3 = list.get(2);
		this.app_cp_other_document4 = list.get(3);
		this.app_cp_other_document5 = list.get(4);
	}

	public String getApp_cp_other_document2() {
		return app_cp_other_document2;
	}

	public void setApp_cp_other_document2(String app_cp_other_document2) {
		this.app_cp_other_document2 = app_cp_other_document2;
	}

	public String getApp_cp_other_document3() {
		return app_cp_other_document3;
	}

	public void setApp_cp_other_document3(String app_cp_other_document3) {
		this.app_cp_other_document3 = app_cp_other_document3;
	}

	public String getApp_cp_other_document4() {
		return app_cp_other_document4;
	}

	public void setApp_cp_other_document4(String app_cp_other_document4) {
		this.app_cp_other_document4 = app_cp_other_document4;
	}

	public String getApp_cp_other_document5() {
		return app_cp_other_document5;
	}

	public void setApp_cp_other_document5(String app_cp_other_document5) {
		this.app_cp_other_document5 = app_cp_other_document5;
	}

	public String getApp_cp_alias_registrantion() {
		return app_cp_alias_registrantion;
	}

	public void setApp_cp_alias_registrantion(String app_cp_alias_registrantion) {
		this.app_cp_alias_registrantion = app_cp_alias_registrantion;
	}

	public String getApp_cp_alias_financial() {
		return app_cp_alias_financial;
	}

	public void setApp_cp_alias_financial(String app_cp_alias_financial) {
		this.app_cp_alias_financial = app_cp_alias_financial;
	}

	public String getApp_cp_alias_estate_contract() {
		return app_cp_alias_estate_contract;
	}

	public void setApp_cp_alias_estate_contract(String app_cp_alias_estate_contract) {
		this.app_cp_alias_estate_contract = app_cp_alias_estate_contract;
	}

	public String getApp_cp_alias_image1() {
		return app_cp_alias_image1;
	}

	public void setApp_cp_alias_image1(String app_cp_alias_image1) {
		this.app_cp_alias_image1 = app_cp_alias_image1;
	}

	public String getApp_cp_alias_image2() {
		return app_cp_alias_image2;
	}

	public void setApp_cp_alias_image2(String app_cp_alias_image2) {
		this.app_cp_alias_image2 = app_cp_alias_image2;
	}

	public String getApp_cp_alias_image3() {
		return app_cp_alias_image3;
	}

	public void setApp_cp_alias_image3(String app_cp_alias_image3) {
		this.app_cp_alias_image3 = app_cp_alias_image3;
	}

	public String getApp_cp_alias_image4() {
		return app_cp_alias_image4;
	}

	public void setApp_cp_alias_image4(String app_cp_alias_image4) {
		this.app_cp_alias_image4 = app_cp_alias_image4;
	}

	public String getApp_cp_alias_image5() {
		return app_cp_alias_image5;
	}

	public void setApp_cp_alias_image5(String app_cp_alias_image5) {
		this.app_cp_alias_image5 = app_cp_alias_image5;
	}
	
	public void setApp_cp_alias_images(ArrayList<String> list) {
		this.app_cp_alias_image1 = list.get(0);
		this.app_cp_alias_image2 = list.get(1);
		this.app_cp_alias_image3 = list.get(2);
		this.app_cp_alias_image4 = list.get(3);
		this.app_cp_alias_image5 = list.get(4);
	}

	public String getApp_cp_alias_other_document1() {
		return app_cp_alias_other_document1;
	}

	public void setApp_cp_alias_other_document1(String app_cp_alias_other_document1) {
		this.app_cp_alias_other_document1 = app_cp_alias_other_document1;
	}

	public String getApp_cp_alias_other_document2() {
		return app_cp_alias_other_document2;
	}

	public void setApp_cp_alias_other_document2(String app_cp_alias_other_document2) {
		this.app_cp_alias_other_document2 = app_cp_alias_other_document2;
	}

	public String getApp_cp_alias_other_document3() {
		return app_cp_alias_other_document3;
	}

	public void setApp_cp_alias_other_document3(String app_cp_alias_other_document3) {
		this.app_cp_alias_other_document3 = app_cp_alias_other_document3;
	}

	public String getApp_cp_alias_other_document4() {
		return app_cp_alias_other_document4;
	}

	public void setApp_cp_alias_other_document4(String app_cp_alias_other_document4) {
		this.app_cp_alias_other_document4 = app_cp_alias_other_document4;
	}

	public String getApp_cp_alias_other_document5() {
		return app_cp_alias_other_document5;
	}

	public void setApp_cp_alias_other_document5(String app_cp_alias_other_document5) {
		this.app_cp_alias_other_document5 = app_cp_alias_other_document5;
	}
	
	public void setApp_cp_alias_other_documents(ArrayList<String> list) {
		this.app_cp_alias_other_document1 = list.get(0);
		this.app_cp_alias_other_document2 = list.get(1);
		this.app_cp_alias_other_document3 = list.get(2);
		this.app_cp_alias_other_document4 = list.get(3);
		this.app_cp_alias_other_document5 = list.get(4);
	}


	public String getApp_cp_real_path() {
		return app_cp_real_path;
	}

	public void setApp_cp_real_path(String app_cp_real_path) {
		this.app_cp_real_path = app_cp_real_path;
	}

	public String getApp_cp_folder() {
		return app_cp_folder;
	}

	public void setApp_cp_folder(String app_cp_folder) {
		this.app_cp_folder = app_cp_folder;
	}
	


}
