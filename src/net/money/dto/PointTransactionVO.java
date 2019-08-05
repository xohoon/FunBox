package net.money.dto;

import java.util.Date;

public class PointTransactionVO {
	private int po_idx;
	private int po_category;
	private int cp_idx;
	private int tk_idx;
	private String tk_price;
	private String po_amount;
	private String po_content;
	private Date po_date_time;

	public int getPo_idx() {
		return po_idx;
	}

	public void setPo_idx(int po_idx) {
		this.po_idx = po_idx;
	}

	public int getPo_category() {
		return po_category;
	}

	public void setPo_category(int po_category) {
		this.po_category = po_category;
	}

	public int getCp_idx() {
		return cp_idx;
	}

	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}

	public int getTk_idx() {
		return tk_idx;
	}

	public void setTk_idx(int tk_idx) {
		this.tk_idx = tk_idx;
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

	public String getPo_content() {
		return po_content;
	}

	public void setPo_content(String po_content) {
		this.po_content = po_content;
	}

	public Date getPo_date_time() {
		return po_date_time;
	}

	public void setPo_date_time(Date po_date_time) {
		this.po_date_time = po_date_time;
	}

}
