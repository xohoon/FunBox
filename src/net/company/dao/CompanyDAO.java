package net.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.company.dto.ApplicationVO;
import net.company.dto.CompanyBean;
import net.company.dto.CompanyFileVO;
import net.company.dto.CompanyListVO;
import net.company.dto.Company_pay_scheduleVO;
import net.member.dto.MemberInvestVO;
import net.page.dto.MainPageDateOfOpenVO;
import net.page.dto.MainPageDeadLineVO;

public class CompanyDAO {

	private static CompanyDAO instance;

	// 3.
	public static CompanyDAO getInstance() {
		if (instance == null)
			instance = new CompanyDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	// autoReconnect=true
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public CompanyDAO() {

		try { //
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	////////// 태훈 - 기업신청서 정보 insert //////////
	public boolean insertApp(ApplicationVO company) {
		String sql = "INSERT INTO company_application("
				// application01
				+ "app_cp_name, app_cp_manager, app_cp_hp, app_cp_num, app_cp_ch, app_cp_more, app_cp_extra, app_cp_sector, app_cp_open_date_time, app_cp_prestige, app_cp_deposit, app_cp_monthly, app_cp_status, "
				// application02
				+ "app_cp_goal_amount, app_cp_avg_monthly_profit, app_cp_monthly_profit, app_cp_during, app_cp_inv_min_amount, "
				// application03
				+ "app_cp_introduction, app_cp_purpose, app_cp_point, "
				// application04
				+ "app_cp_registrantion, app_cp_financial, app_cp_estate_contract, app_cp_image1, app_cp_image2, app_cp_image3, app_cp_image4, app_cp_image5, app_cp_other_document1, app_cp_other_document2, app_cp_other_document3, app_cp_other_document4, app_cp_other_document5, app_cp_real_path, mb_idx) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			///// 태훈 /////
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, company.getApp_cp_name());
			pstmt.setString(2, company.getApp_cp_manager());
			pstmt.setString(3, company.getApp_cp_hp());
			pstmt.setString(4, company.getApp_cp_num());
			pstmt.setString(5, company.getApp_cp_ch());
			pstmt.setString(6, company.getApp_cp_more());
			pstmt.setString(7, company.getApp_cp_extra());
			pstmt.setString(8, company.getApp_cp_sector());
			pstmt.setString(9, company.getApp_cp_open_date_time());
			pstmt.setString(10, company.getApp_cp_prestige());
			pstmt.setString(11, company.getApp_cp_deposit());
			pstmt.setString(12, company.getApp_cp_monthly());
			pstmt.setInt(13, company.getApp_cp_status());

			///// 태훈 /////
			pstmt.setString(14, company.getApp_cp_goal_amount());
			pstmt.setString(15, company.getApp_cp_avg_monthly_profit());
			pstmt.setString(16, company.getApp_cp_monthly_profit());
			pstmt.setString(17, company.getApp_cp_during());
			pstmt.setString(18, company.getApp_cp_inv_min_amount());

			///// 유정 /////
			pstmt.setString(19, company.getApp_cp_introduction());
			pstmt.setString(20, company.getApp_cp_purpose());
			pstmt.setString(21, company.getApp_cp_point());

			///// 신규 /////
			pstmt.setString(22, company.getApp_cp_registrantion());
			pstmt.setString(23, company.getApp_cp_financial());
			pstmt.setString(24, company.getApp_cp_estate_contract());
			pstmt.setString(25, company.getApp_cp_image1());
			pstmt.setString(26, company.getApp_cp_image2());
			pstmt.setString(27, company.getApp_cp_image3());
			pstmt.setString(28, company.getApp_cp_image4());
			pstmt.setString(29, company.getApp_cp_image5());
			pstmt.setString(30, company.getApp_cp_other_document1());
			pstmt.setString(31, company.getApp_cp_other_document2());
			pstmt.setString(32, company.getApp_cp_other_document3());
			pstmt.setString(33, company.getApp_cp_other_document4());
			pstmt.setString(34, company.getApp_cp_other_document5());
			pstmt.setString(35, company.getApp_cp_real_path());
			pstmt.setString(36, company.getMb_idx());
			
			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("InsertCompany 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return false;
	}

	// 박신규 가 했어용//////////////////////////
	// 저장될 경로 가져오기
	public String getUploadFilePath(String file_category) {
		String sql = "SELECT CONCAT(file_path,(SELECT file_path FROM file_path WHERE `file_category` = ?)) AS full_path FROM `file_path` WHERE `file_category` ='funbox_path'";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, file_category);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String full_path = rs.getString("full_path");
				return full_path;
			}
		} catch (Exception ex) {
			System.out.println("getUploadFilePath 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}

	// 20190723//
	// compnay_file //
	public String getUploadDirectory(int cp_idx) {
		String sql = "SELECT cf_directory from company_file WHERE cp_idx = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String cf_directory = rs.getString("cf_directory");
				return cf_directory;
			}
		} catch (Exception ex) {
			System.out.println("getUploadFilePath 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}

	// 20190723//
	// compnay_file

	public CompanyFileVO getCompanyFilePath(int cp_idx) {
		String sql = "SELECT concat (cf_directory,cf_registration) as cf_registration, concat (cf_directory,cf_financial) as cf_financial,concat (cf_directory,cf_estate_contract) as cf_estate_contract,concat (cf_directory,cf_certificate) as cf_certificate,  concat (cf_directory,cf_image1) as cf_image1,  concat (cf_directory,cf_image2) as cf_image2,  concat (cf_directory,cf_image3) as cf_image3,  concat (cf_directory,cf_image4) as cf_image4,  concat (cf_directory,cf_image5) as cf_image5,  concat (cf_directory,cf_image6) as cf_image6  FROM company_file where cp_idx = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				CompanyFileVO companyFileVO = new CompanyFileVO();
				companyFileVO.setCf_registration(rs.getString("cf_registration"));
				companyFileVO.setCf_financial(rs.getString("cf_financial"));
				companyFileVO.setCf_estate_contract(rs.getString("cf_estate_contract"));
				companyFileVO.setCf_certificate(rs.getString("cf_certificate"));
				companyFileVO.setCf_image1(rs.getString("cf_image1"));
				companyFileVO.setCf_image2(rs.getString("cf_image2"));
				companyFileVO.setCf_image3(rs.getString("cf_image3"));
				companyFileVO.setCf_image4(rs.getString("cf_image4"));
				companyFileVO.setCf_image5(rs.getString("cf_image5"));
				companyFileVO.setCf_image6(rs.getString("cf_image6"));
				return companyFileVO;
			}
		} catch (Exception ex) {
			System.out.println("getUploadFilePath 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}

	// Main page 에 필요한 오픈예정일 기업 들고오깅 
	public ArrayList<MainPageDateOfOpenVO> getCompanyDateOfOpen() {
		String sql = "select cp_f.cp_idx,cp.cp_name,cp.cp_intro_headline,cp.cp_intro_content,cp.cp_open_datetime,concat(cp_f.cf_directory,cp_f.cf_image6) as cf_image6 from company_file cp_f,company cp where cp.cp_idx = cp_f.cp_idx and cp.cp_open_status = 0 limit 3";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = new ArrayList<MainPageDateOfOpenVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				MainPageDateOfOpenVO mainPageDateOfOpenVO = new MainPageDateOfOpenVO();
				mainPageDateOfOpenVO.setCp_idx(rs.getInt("cp_idx"));
				mainPageDateOfOpenVO.setCp_name(rs.getString("cp_name"));
				mainPageDateOfOpenVO.setCp_intro_headline(rs.getString("cp_intro_headline"));
				mainPageDateOfOpenVO.setCp_intro_content(rs.getString("cp_intro_content"));
				mainPageDateOfOpenVO.setCp_open_datetime(rs.getDate("cp_open_datetime"));
				mainPageDateOfOpenVO.setBanner_image(rs.getString("cf_image6"));
				mainPageDateOfOpenVOs.add(mainPageDateOfOpenVO);

			}

			return mainPageDateOfOpenVOs;

		} catch (Exception ex) {
			System.out.println("getDateOfOpen 에러: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}

		return null;
	}
	
	public ArrayList<MainPageDeadLineVO> getCompanyDeadLine() {
		String sql = "select cp.cp_idx, cp.cp_monthly_profit, cp.cp_sector, cp.cp_name, cp.cp_branch,cp_i.iv_current_amount, cp_i.iv_goal_amount, cp_i.iv_appl_stop_date_time,cp_f.cf_image5,round((iv_current_amount/iv_goal_amount)*100) as persent from company cp, company_file cp_f, company_invest cp_i where cp.cp_open_status = true AND cp.cp_idx = cp_i.cp_idx AND cp.cp_idx = cp_f.cp_idx order by cp_i.iv_appl_stop_date_time asc limit 3";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = new ArrayList<MainPageDeadLineVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				MainPageDeadLineVO mainPageDeadLineVO = new MainPageDeadLineVO();
				mainPageDeadLineVO.setCp_idx(rs.getInt("cp_idx"));
				mainPageDeadLineVO.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				mainPageDeadLineVO.setCp_sector(rs.getString("cp_sector"));
				mainPageDeadLineVO.setCp_name(rs.getString("cp_name"));
				mainPageDeadLineVO.setCp_branch(rs.getString("cp_branch"));
				mainPageDeadLineVO.setIv_current_amount(rs.getString("iv_current_amount"));
				mainPageDeadLineVO.setIv_appl_stop_date_time(rs.getDate("iv_appl_stop_date_time"));
				mainPageDeadLineVO.setIv_goal_amount(rs.getString("iv_goal_amount"));
				mainPageDeadLineVO.setBanner_image(rs.getString("cf_image5"));
				mainPageDeadLineVO.setPersent(rs.getString("persent"));
				mainPageDeadLineVOs.add(mainPageDeadLineVO);

			}

			return mainPageDeadLineVOs;

		} catch (Exception ex) {
			System.out.println("getCompanyDeadLine 에러: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}

		return null;
	}
	// 박신규 끝//////////////////////////

	// 유정 추가 start ////////////////////////////
	// 투자하기 - 모든 기업 정보 불러오기
	public CompanyBean getCompanyInfo(int idx) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CompanyBean company = null;

		try {
			// 쿼리
			String sql = "SELECT " + "A.*, B.*, C.*, D.*, E.* " + "FROM " + "company A, " + "company_file B, "
					+ "company_invest C, " + "company_pay_schedule D, " + "company_pre_revenue E "
					+ "WHERE A.cp_idx = ? AND " + "A.cp_idx = B.cp_idx AND " + "B.cp_idx = C.cp_idx AND "
					+ "C.cp_idx = D.cp_idx AND " + "D.cp_idx = E.cp_idx";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idx);
			rs = pstm.executeQuery();

			if (rs.next()) { // 회원정보를 DTO에 담는다.

				// CompanyVO
				company = new CompanyBean();
				company.setCp_idx(rs.getInt("cp_idx"));
				company.setCp_name(rs.getString("cp_name"));
				company.setCp_number(rs.getString("cp_number"));
				company.setCp_manager(rs.getString("cp_manager"));
				company.setCp_phone(rs.getString("cp_phone"));
				company.setCp_sector(rs.getString("cp_sector"));
				company.setCp_add_num(rs.getString("cp_add_num"));
				company.setCp_add_ch(rs.getString("cp_add_ch"));
				company.setCp_add_more(rs.getString("cp_add_more"));
				company.setCp_branch(rs.getString("cp_branch"));
				company.setCp_intro_headline(rs.getString("cp_intro_headline"));
				company.setCp_lat(rs.getString("cp_lat"));
				company.setCp_lng(rs.getString("cp_lng"));
				company.setCp_add_extra(rs.getString("cp_add_extra"));
				company.setCp_capital(rs.getString("cp_capital"));
				company.setCp_open_datetime(rs.getTimestamp("cp_open_datetime"));
				company.setCp_avg_monthly_sales(rs.getString("cp_avg_monthly_sales"));
				company.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				company.setCp_reg_datetime(rs.getTimestamp("cp_reg_datetime"));
				company.setCp_exit_datetime(rs.getTimestamp("cp_exit_datetime"));
				company.setCp_intro_content(rs.getString("cp_intro_content"));
				company.setCp_purpose(rs.getString("cp_purpose"));
				company.setCp_point_comment(rs.getString("cp_point_comment"));
				company.setCp_update_datetime(rs.getTimestamp("cp_update_datetime"));
				company.setCp_business_risk(rs.getString("cp_business_risk"));
				company.setCp_company_risk(rs.getString("cp_company_risk"));
				company.setCp_other_risks(rs.getString("cp_other_risks"));
				company.setCp_recommand(rs.getBoolean("cp_recommand"));
				company.setCp_best(rs.getBoolean("cp_best"));

				// InvestVO
				company.setIv_goal_amount(rs.getString("iv_goal_amount"));
				company.setIv_current_amount(rs.getString("iv_current_amount"));
				company.setIv_min_amount(rs.getString("iv_min_amount"));
				company.setIv_balance_stock(rs.getString("iv_balance_stock"));
				company.setIv_appl_start_date_time(rs.getTimestamp("iv_appl_start_date_time"));
				company.setIv_appl_stop_date_time(rs.getTimestamp("iv_appl_stop_date_time"));
				company.setIv_contraction_during(rs.getString("iv_contraction_during"));
				company.setIv_possible_amount(rs.getString("iv_possible_amount"));
				company.setIv_current_participants(rs.getString("iv_current_participants"));

				// Company_pay_scheduleVO
				company.setCp_pay_count(rs.getString("cp_pay_count"));
				company.setCp_pay_expected_payment_date(rs.getString("cp_pay_expected_payment_date"));
				company.setCp_pay_principal(rs.getString("cp_pay_principal"));
				company.setCp_pay_interest_paid(rs.getString("cp_pay_interest_paid"));
				company.setCp_pay_fees(rs.getString("cp_pay_fees"));
				company.setCp_pay_actual_payment_amout(rs.getString("cp_pay_actual_payment_amout"));
				company.setCp_pay_actual_rate_return(rs.getString("cp_pay_actual_rate_return"));

				// Company_revenueVO
				company.setCp_pre_sales(rs.getInt("cp_pre_sales"));
				company.setCp_pre_stuff(rs.getInt("cp_pre_stuff"));
				company.setCp_pre_costs_person(rs.getInt("cp_pre_costs_person"));
				company.setCp_pre_lease_expenses(rs.getInt("cp_pre_lease_expenses"));
				company.setCp_pre_operating_expenses(rs.getInt("cp_pre_operating_expenses"));
				company.setCp_pre_net_income(rs.getInt("cp_pre_net_income"));
				company.setCp_pre_cash_dividend_ratio(rs.getInt("cp_pre_cash_dividend_ratio"));
				company.setCp_pre_share(rs.getInt("cp_pre_share"));
				company.setCp_pre_platform(rs.getInt("cp_pre_platform"));
				company.setCp_pre_proceeds(rs.getInt("cp_pre_proceeds"));
				company.setCp_pre_avg_monthly(rs.getInt("cp_pre_avg_monthly"));
				company.setCp_pre_net_profit_ratio(rs.getInt("cp_pre_net_profit_ratio"));
				company.setCp_pre_interest_rate(rs.getInt("cp_pre_interest_rate"));

				// CompanyFileVO
				company.setCf_registration(rs.getString("cf_registration"));
				company.setCf_financial(rs.getString("cf_financial"));
				company.setCf_estate_contract(rs.getString("cf_estate_contract"));
				company.setCf_image1(rs.getString("cf_image1"));
				company.setCf_image2(rs.getString("cf_image2"));
				company.setCf_image3(rs.getString("cf_image3"));
				company.setCf_image4(rs.getString("cf_image4"));
				company.setCf_image5(rs.getString("cf_image5"));
				company.setCf_etc(rs.getString("cf_etc"));

			} else {
				System.out.println("getCompanyInfo(DAO) 쿼리문 작동 실패");
			}

			return company;

		} catch (Exception ex) {
			System.out.println("getCompanyInfo 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return null;
	}

	// 투자하기 - 모든 기업 정보 불러오기
	// 태훈 - 투자하기 필요한 정보 JOIN활용 불러오기
	public CompanyBean getCompanyInfo2(int idx) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CompanyBean company = null;

		try {
			// 쿼리
			String sql = "SELECT *,"
					+ "concat(b.cf_directory,b.cf_image1) as cf_directory_image1,concat(b.cf_directory,b.cf_image2) as cf_directory_image2,concat(b.cf_directory,b.cf_image3) as cf_directory_image3,concat(b.cf_directory,b.cf_image4) as cf_directory_image4,concat(b.cf_directory,b.cf_image5) as cf_directory_image5,concat(b.cf_directory,b.cf_image6) as cf_directory_image6 , c.iv_current_amount/iv_goal_amount*100 "
					+ "FROM company as a " 
					+ "JOIN company_file as b ON a.cp_idx = b.cp_idx AND a.cp_idx = ? "
					+ "JOIN company_invest as c ON a.cp_idx = c.cp_idx "
					+ "JOIN company_lease as d ON a.cp_idx = d.cp_idx "
					+ "JOIN company_pay_schedule as e ON a.cp_idx = e.cp_idx "
					+ "JOIN company_pre_revenue as f ON a.cp_idx = f.cp_idx";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idx);
			rs = pstm.executeQuery();

			if (rs.next()) { // 회원정보를 DTO에 담는다.

				// CompanyVO
				company = new CompanyBean();
				company.setCp_idx(rs.getInt("cp_idx"));
				company.setCp_name(rs.getString("cp_name"));
				company.setCp_number(rs.getString("cp_number"));
				company.setCp_manager(rs.getString("cp_manager"));
				company.setCp_phone(rs.getString("cp_phone"));
				company.setCp_sector(rs.getString("cp_sector"));
				company.setCp_add_num(rs.getString("cp_add_num"));
				company.setCp_add_ch(rs.getString("cp_add_ch"));
				company.setCp_add_more(rs.getString("cp_add_more"));
				company.setCp_branch(rs.getString("cp_branch"));
				company.setCp_intro_headline(rs.getString("cp_intro_headline"));
				company.setCp_lat(rs.getString("cp_lat"));
				company.setCp_lng(rs.getString("cp_lng"));
				company.setCp_add_extra(rs.getString("cp_add_extra"));
				company.setCp_capital(rs.getString("cp_capital"));
				company.setCp_open_datetime(rs.getTimestamp("cp_open_datetime"));
				company.setCp_avg_monthly_sales(rs.getString("cp_avg_monthly_sales"));
				company.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				company.setCp_reg_datetime(rs.getTimestamp("cp_reg_datetime"));
				company.setCp_exit_datetime(rs.getTimestamp("cp_exit_datetime"));
				company.setCp_intro_content(rs.getString("cp_intro_content"));
				company.setCp_purpose(rs.getString("cp_purpose"));
				company.setCp_point_comment(rs.getString("cp_point_comment"));
				company.setCp_update_datetime(rs.getTimestamp("cp_update_datetime"));
				company.setCp_business_risk(rs.getString("cp_business_risk"));
				company.setCp_company_risk(rs.getString("cp_company_risk"));
				company.setCp_other_risks(rs.getString("cp_other_risks"));
				company.setCp_recommand(rs.getBoolean("cp_recommand"));
				company.setCp_best(rs.getBoolean("cp_best"));

				// InvestVO
				// 태훈 추가 - 투자율
				company.setIv_percent(rs.getString("c.iv_current_amount/iv_goal_amount*100"));
				company.setIv_goal_amount(rs.getString("iv_goal_amount"));
				company.setIv_current_amount(rs.getString("iv_current_amount"));
				company.setIv_min_amount(rs.getString("iv_min_amount"));
				company.setIv_balance_stock(rs.getString("iv_balance_stock"));
				company.setIv_appl_start_date_time(rs.getTimestamp("iv_appl_start_date_time"));
				company.setIv_appl_stop_date_time(rs.getTimestamp("iv_appl_stop_date_time"));
				company.setIv_contraction_during(rs.getString("iv_contraction_during"));
				company.setIv_possible_amount(rs.getString("iv_possible_amount"));
				company.setIv_current_participants(rs.getString("iv_current_participants"));

				// Company_pay_scheduleVO
				company.setCp_pay_count(rs.getString("cp_pay_count"));
				company.setCp_pay_expected_payment_date(rs.getString("cp_pay_expected_payment_date"));
				company.setCp_pay_principal(rs.getString("cp_pay_principal"));
				company.setCp_pay_interest_paid(rs.getString("cp_pay_interest_paid"));
				company.setCp_pay_fees(rs.getString("cp_pay_fees"));
				company.setCp_pay_actual_payment_amout(rs.getString("cp_pay_actual_payment_amout"));
				company.setCp_pay_actual_rate_return(rs.getString("cp_pay_actual_rate_return"));

				// Company_revenueVO
				company.setCp_pre_sales(rs.getInt("cp_pre_sales"));
				company.setCp_pre_stuff(rs.getInt("cp_pre_stuff"));
				company.setCp_pre_costs_person(rs.getInt("cp_pre_costs_person"));
				company.setCp_pre_lease_expenses(rs.getInt("cp_pre_lease_expenses"));
				company.setCp_pre_operating_expenses(rs.getInt("cp_pre_operating_expenses"));
				company.setCp_pre_net_income(rs.getInt("cp_pre_net_income"));
				company.setCp_pre_cash_dividend_ratio(rs.getInt("cp_pre_cash_dividend_ratio"));
				company.setCp_pre_share(rs.getInt("cp_pre_share"));
				company.setCp_pre_platform(rs.getInt("cp_pre_platform"));
				company.setCp_pre_proceeds(rs.getInt("cp_pre_proceeds"));
				company.setCp_pre_avg_monthly(rs.getInt("cp_pre_avg_monthly"));
				company.setCp_pre_net_profit_ratio(rs.getInt("cp_pre_net_profit_ratio"));
				company.setCp_pre_interest_rate(rs.getInt("cp_pre_interest_rate"));

				// CompanyFileVO
				company.setCf_registration(rs.getString("cf_registration"));
				company.setCf_financial(rs.getString("cf_financial"));
				company.setCf_estate_contract(rs.getString("cf_estate_contract"));
				company.setCf_image1(rs.getString("cf_directory_image1"));
				company.setCf_image2(rs.getString("cf_directory_image2"));
				company.setCf_image3(rs.getString("cf_directory_image3"));
				company.setCf_image4(rs.getString("cf_directory_image4"));
				company.setCf_image5(rs.getString("cf_directory_image5"));
				company.setCf_image5(rs.getString("cf_directory_image6"));
				company.setCf_etc(rs.getString("cf_etc"));

			} else {
				System.out.println("getCompanyInfo(DAO) 쿼리문 작동 실패");
			}

			return company;

		} catch (Exception ex) {
			System.out.println("getCompanyInfo 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return null;
	}

	// 투자하기 insert
	public boolean MemberInvest(MemberInvestVO member_invest) {
		String sql = "insert into member_invest(mb_idx,mb_id,mi_category,mi_name,mi_branch,mi_point,mi_hoiling_stock,cp_idx,mi_reg_date_time) values (?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member_invest.getMi_idx());
			pstmt.setString(2, member_invest.getMb_id());
			pstmt.setString(3, member_invest.getMi_category());
			pstmt.setString(4, member_invest.getName());
			pstmt.setString(5, member_invest.getMi_branch());
			pstmt.setString(6, member_invest.getPoint());
			pstmt.setString(7, member_invest.getHoiling_stock());
			pstmt.setInt(8, member_invest.getCp_idx());
			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("MemberInvest 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return false;
	}

	//투자현황 - 투자내역 불러오기
	public ArrayList<MemberInvestVO> getInvestment(String id, int startRow, int endRow) {// 시작페이지, 끝 페이지
		String sql = "select mi_category,mi_name,mi_point,mi_reg_date_time,mi_note from member_invest where mb_id=? order by mi_idx desc limit "
								+ startRow + ", " + endRow;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberInvestVO> member_invest_list = new ArrayList<MemberInvestVO>();
		System.out.println("getInvestment 실행 : "+ id);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			
			while(rs.next()) {
				
				MemberInvestVO member_invest = new MemberInvestVO();
				member_invest.setMi_category(rs.getString("mi_category"));
				member_invest.setName(rs.getString("mi_name"));
				member_invest.setPoint(rs.getString("mi_point"));
				member_invest.setMi_reg_date_time(rs.getTimestamp("mi_reg_date_time"));
				member_invest.setMi_note(rs.getString("mi_note"));
				
				member_invest_list.add(member_invest);

			}

			return member_invest_list;
			
		} catch (Exception ex) {
			System.out.println("getInvestment 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return null;
	}

	// 투자 내역 수 구하기
	public int getInvestmentCount(String id) {
		int total = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "select count(*) from member_invest where mb_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				if (conn != null) 
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}
		System.out.println("total: "+total);
		return total;
	}
	// 유정 추가 end ////////////////////////////

	// 김윤식 추가 - 기업리스트
	public ArrayList<CompanyListVO> getCompanyList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CompanyListVO> leftCompanyList = new ArrayList<CompanyListVO>();

		try {

			String sql = "SELECT cp_idx, cp_name,cp_recommand,cp_best FROM company";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyListVO companyListVO = new CompanyListVO();
				companyListVO.setCp_idx(rs.getInt("cp_idx"));
				companyListVO.setCp_name(rs.getString("cp_name"));
				companyListVO.setCp_recommand(rs.getBoolean("cp_recommand"));
				companyListVO.setCp_best(rs.getBoolean("cp_best"));

				leftCompanyList.add(companyListVO);
			}
			return leftCompanyList;

		} catch (Exception ex) {
			System.out.println("getcompanyLsit 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}
	
	/// 윤식 추가 기업 스케줄 리스트 불러오기
	public ArrayList<Company_pay_scheduleVO> getCompanySchedule(int cp_idx) {
		String sql = " select * from company_pay_schedule WHERE cp_idx = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Company_pay_scheduleVO> CompanyScheduleList = new ArrayList<Company_pay_scheduleVO>();
		System.out.println("get Comapnysche cp_idx : " + cp_idx);
		
		try {	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			while (rs.next()) {
				Company_pay_scheduleVO companyscheduleVO = new Company_pay_scheduleVO();
				
				companyscheduleVO.setCp_pay_count(rs.getString("cp_pay_count"));
				companyscheduleVO.setCp_pay_expected_payment_date(rs.getString("cp_pay_expected_payment_date"));
				companyscheduleVO.setCp_pay_principal(rs.getString("cp_pay_principal"));
				companyscheduleVO.setCp_pay_interest_paid(rs.getString("cp_pay_interest_paid"));
				companyscheduleVO.setCp_pay_fees(rs.getString("cp_pay_fees"));
				companyscheduleVO.setCp_pay_actual_payment_amout(rs.getString("cp_pay_actual_payment_amout"));
				companyscheduleVO.setCp_pay_actual_rate_return(rs.getString("cp_pay_actual_rate_return"));
							
				CompanyScheduleList.add(companyscheduleVO);
				
			}
			
			return CompanyScheduleList;

		} catch (Exception ex) {
			System.out.println("getCompanySchedule 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}
				
		return null;
	}

	
	private PreparedStatement setInt(int i, int cp_idx) {
		// TODO Auto-generated method stub
		return null;
	}

}
