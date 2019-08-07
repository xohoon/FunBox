package net.member.dto;

public class MypagePointTransactionVO {
	
	private String po_category;
	private String po_amount;
	private String po_date_time;
	private String tk_amount;
	public String getPo_category() {
		return po_category;
	}
	public void setPo_category(String po_category) {
		this.po_category = po_category;
	}
	public String getPo_amount() {
		return po_amount;
	}
	public void setPo_amount(String po_amount) {
		this.po_amount = po_amount;
	}
	public String getPo_date_time() {
		return po_date_time;
	}
	public void setPo_date_time(String po_date_time) {
		this.po_date_time = po_date_time;
	}
	public String getTk_amount() {
		return tk_amount;
	}
	public void setTk_amount(String tk_amount) {
		this.tk_amount = tk_amount;
	}
	@Override
	public String toString() {
		return "PointTransactionVO [po_category=" + po_category + ", po_amount=" + po_amount + ", po_date_time="
				+ po_date_time + ", tk_amount=" + tk_amount + "]";
	}
	
	
}
