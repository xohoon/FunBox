package net.company.dto;

//// 태훈 - // 투자포인트/구좌 양
public class InvestPointVO {
	
	private String invest_point;
	private String invest_amount;
	
	public String getInvest_point() {
		return invest_point;
	}
	public void setInvest_point(String invest_point) {
		this.invest_point = invest_point;
	}
	public String getInvest_amount() {
		return invest_amount;
	}
	public void setInvest_amount(String invest_amount) {
		this.invest_amount = invest_amount;
	}
	@Override
	public String toString() {
		return "InvestPointVO [invest_point=" + invest_point + ", invest_amount=" + invest_amount + "]";
	}
	
}
