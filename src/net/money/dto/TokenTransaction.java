package net.money.dto;

import java.util.Date;

public class TokenTransaction {
	private int tk_idx;
	private String tk_category;
	private int po_idx;
	private String tk_amount;
	private String tk_price;
	private String po_amount;
	private String tk_content;
	private Date tk_date_time;

	public int getTk_idx() {
		return tk_idx;
	}

	public void setTk_idx(int tk_idx) {
		this.tk_idx = tk_idx;
	}

	public String getTk_category() {
		return tk_category;
	}

	public void setTk_category(String tk_category) {
		this.tk_category = tk_category;
	}

	public int getPo_idx() {
		return po_idx;
	}

	public void setPo_idx(int po_idx) {
		this.po_idx = po_idx;
	}

	public String getTk_amount() {
		return tk_amount;
	}

	public void setTk_amount(String tk_amount) {
		this.tk_amount = tk_amount;
	}

	public String getTk_price() {
		return tk_price;
	}

	public void setTk_price(String tk_price) {
		this.tk_price = tk_price;
	}

	public String getPo_amount() {
		return po_amount;
	}

	public void setPo_amount(String po_amount) {
		this.po_amount = po_amount;
	}

	public String getTk_content() {
		return tk_content;
	}

	public void setTk_content(String tk_content) {
		this.tk_content = tk_content;
	}

	public Date getTk_date_time() {
		return tk_date_time;
	}

	public void setTk_date_time(Date tk_date_time) {
		this.tk_date_time = tk_date_time;
	}

}
