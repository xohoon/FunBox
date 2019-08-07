package test;

import java.util.ArrayList;
import java.util.UUID;

import net.member.dao.MemberDAO;
import net.member.dto.MemberInvestCompanyVO;
import net.member.dto.MemberInvestPageVO;

public class Main {

	public static void main(String[] args) throws Exception {
		//String sql = "SELECT cp.cp_recommand_count, cp.cp_overdue_status, cp.cp_revenue_distribution_status, cp.cp_add_ch, cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount, cp.cp_reg_datetime, cp_iv.iv_appl_stop_date_time FROM company as cp JOIN company_invest as cp_iv ON cp.cp_idx = cp_iv.cp_idx WHERE CONCAT(cp.cp_sector, cp.cp_add_ch, cp.cp_branch) LIKE '%양식%' OR CONCAT(cp.cp_sector, cp.cp_add_ch, cp.cp_branch) LIKE '%중식%'";
		
		
		ArrayList<String> sqlList = new ArrayList<String>();
		
		sqlList.add("SELECT cp.cp_recommand_count, cp.cp_overdue_status, cp.cp_revenue_distribution_status, cp.cp_add_ch, cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount, cp.cp_reg_datetime, cp_iv.iv_appl_stop_date_time "
					+ "FROM company as cp " + "JOIN company_invest as cp_iv ON cp.cp_idx = cp_iv.cp_idx ");
		
		sqlList.add("WHERE CONCAT(cp.cp_sector, cp.cp_add_ch, cp.cp_branch) LIKE ? ");
		sqlList.add("OR CONCAT(cp.cp_overdue_status) LIKE ? ");
		
		sqlList.add(1, "AND cp.cp_name LIKE ? (");
		
		String realSql = "";
		
		for (String sql : sqlList) {
			realSql += sql;
		}
		
		System.out.print(realSql);
	}
	
	

}

