package net.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import net.company.dto.ApplicationVO;
import net.company.dto.CompanyBean;
import net.company.dto.CompanyFileVO;
import net.company.dto.CompanyListVO;
import net.company.dto.Company_pay_scheduleVO;
import net.company.dto.CompnayApplicationFilePath;
import net.company.dto.LikeBoxVO;
import net.member.dto.Main_LikeVO;
import net.member.dto.Main_SlideVO;
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
				+ "app_cp_registrantion, app_cp_financial, app_cp_estate_contract, app_cp_image1, app_cp_image2, app_cp_image3, app_cp_image4, app_cp_image5, app_cp_other_document1, app_cp_other_document2, app_cp_other_document3, app_cp_other_document4, app_cp_other_document5, app_cp_alias_registrantion,app_cp_alias_financial, app_cp_alias_estate_contract, app_cp_alias_image1, app_cp_alias_image2, app_cp_alias_image3, app_cp_alias_image4, app_cp_alias_image5, app_cp_alias_other_document1, app_cp_alias_other_document2, app_cp_alias_other_document3, app_cp_alias_other_document4, app_cp_alias_other_document5, app_cp_folder,mb_idx) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?  )";
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

			pstmt.setString(35, company.getApp_cp_alias_registrantion());
			pstmt.setString(36, company.getApp_cp_alias_financial());
			pstmt.setString(37, company.getApp_cp_alias_estate_contract());
			pstmt.setString(38, company.getApp_cp_alias_image1());
			pstmt.setString(39, company.getApp_cp_alias_image2());
			pstmt.setString(40, company.getApp_cp_alias_image3());
			pstmt.setString(41, company.getApp_cp_alias_image4());
			pstmt.setString(42, company.getApp_cp_alias_image5());
			pstmt.setString(43, company.getApp_cp_alias_other_document1());
			pstmt.setString(44, company.getApp_cp_alias_other_document2());
			pstmt.setString(45, company.getApp_cp_alias_other_document3());
			pstmt.setString(46, company.getApp_cp_alias_other_document4());
			pstmt.setString(47, company.getApp_cp_alias_other_document5());

			pstmt.setString(48, company.getApp_cp_folder());
			pstmt.setString(49, company.getMb_idx());

			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("insertApp 에러: " + ex);
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
	public Boolean getUploadFilePath(CompnayApplicationFilePath companyApplicationFilePath,String companyFolder) {
		String sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 1),? ,(SELECT file_path FROM file_path WHERE idx = 3)) AS app_cp_image_path,CONCAT((SELECT file_path FROM file_path WHERE idx = 1), ?,(SELECT file_path FROM file_path WHERE idx = 4)) AS app_cp_file_path";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, companyFolder);
			pstmt.setString(2, companyFolder);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				companyApplicationFilePath.setApp_cp_file_path(rs.getString("app_cp_image_path"));
				companyApplicationFilePath.setApp_cp_image_path(rs.getString("app_cp_file_path"));
				return true;
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

		return false;
	}

	// 20190723//
	// compnay_file //
	public String getFileDirectory(int cp_idx) {
		String sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 2), (SELECT cf_folder FROM company_file WHERE cp_idx = ?),(SELECT file_path FROM file_path WHERE idx = 4)) AS company_file_folder";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String company_file_folder = rs.getString("company_file_folder");
				return company_file_folder;
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
				companyFileVO.setCf_store_image(rs.getString("cf_store_image"));
				companyFileVO.setCf_alias_store_image(rs.getString("cf_alias_store_image"));
				companyFileVO.setCf_corporation_banner(rs.getString("cf_corporation_banner"));
				companyFileVO.setCf_alias_corporation_banner(rs.getString("cf_alias_corporation_banner"));
				companyFileVO.setCf_corporation_icon(rs.getString("cf_corporation_icon"));
				companyFileVO.setCf_alias_corporation_icon(rs.getString("cf_alias_corporation_icon"));
				companyFileVO.setCf_invest_image(rs.getString("cf_invest_image"));
				companyFileVO.setCf_alias_invest_image(rs.getString("cf_alias_invest_image"));
				companyFileVO.setCf_folder(rs.getString("cf_folder"));
				companyFileVO.setCf_business_plan_images(rs.getString("cf_business_plan_images"));
				companyFileVO.setCf_alias_business_plan_images(rs.getString("cf_alias_business_plan_images"));
				companyFileVO.setCf_ect_files(rs.getString("cf_ect_files"));
				companyFileVO.setCf_alias_etc_files(rs.getString("cf_alias_etc_files"));
				companyFileVO.setCf_thumbnail(rs.getString("cf_thumbnail"));
				companyFileVO.setCf_alias_thumbnail(rs.getString("cf_alias_thumbnail"));
				companyFileVO.setCf_pr_background(rs.getString("cf_pr_background"));
				companyFileVO.setCf_alias_pr_background(rs.getString("cf_alias_pr_background"));
				companyFileVO.setCf_funding_contract(rs.getString("cf_funding_contract"));
				companyFileVO.setCf_alias_funding_contract(rs.getString("cf_alias_funding_contract"));
				companyFileVO.setCf_business_plan(rs.getString("cf_business_plan"));
				companyFileVO.setCf_alias_business_plan(rs.getString("cf_alias_business_plan"));
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

	// 메인 페이지 추천 기업 리스트
	public boolean getMainRecommandedCompanyList(List<Main_LikeVO> mainRecommandedCompanyList,boolean auto_status) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			String sql = "";
			
			if (auto_status) {
				sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount, cp_iv.iv_appl_stop_date_time, concat(cp_f.cf_directory,cp_f.cf_image1) as thumbnail_image, cp.cp_recommand_count FROM company as cp, company_invest as cp_iv, company_file as cp_f WHERE cp_iv.iv_appl_stop_date_time > now() AND cp.cp_idx = cp_iv.cp_idx AND cp_f.cp_idx = cp.cp_idx AND cp.cp_recommand = 1 ORDER BY cp.cp_recommand_count DESC, cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100 DESC LIMIT 4";
			}else {
				sql = "SELECT * FROM recommended_company";
			} 

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Main_LikeVO mainRecommandedCompany = new Main_LikeVO();
				mainRecommandedCompany.setLk_cp_branch(rs.getString("cp_branch"));
				mainRecommandedCompany.setLk_cp_current_amount(rs.getString("iv_current_amount"));
				mainRecommandedCompany.setLk_cp_goal_amount(rs.getString("iv_goal_amount"));
				mainRecommandedCompany.setLk_cp_name(rs.getString("cp_name"));
				mainRecommandedCompany.setLk_cp_percent(rs.getString("percent"));
				mainRecommandedCompany.setLk_cp_profit(rs.getString("cp_monthly_profit"));
				mainRecommandedCompany.setLk_cp_sector(rs.getString("cp_sector"));
				mainRecommandedCompany.setLk_cp_idx(rs.getInt("cp_idx"));
				mainRecommandedCompany.setLk_appl_stop_date_time(rs.getDate("iv_appl_stop_date_time"));
				mainRecommandedCompany.setThumbnail_image(rs.getString("thumbnail_image"));
				mainRecommandedCompanyList.add(mainRecommandedCompany);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("Main_SlideInfo ERROR: " + ex);
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

	public boolean getMainBanner1(List<Main_SlideVO> mainBanner1List, boolean auto_status) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "";

			if (auto_status) {
				sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_branch, cp.cp_intro_content, concat(cp_f.cf_folder,(SELECT file_path FROM file_path WHERE idx = 3),cp_f.cf_pr_background) as banner_image FROM company as cp, company_file as cp_f, file_path as p ORDER BY RAND() LIMIT 3";
			} else {
				sql = "SELECT * FROM am_banner_1";
			}

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Main_SlideVO mainBanner1 = new Main_SlideVO();
				mainBanner1.setSl_cp_content(rs.getString("cp_intro_content"));
				mainBanner1.setSl_cp_name(rs.getString("cp_name"));
				mainBanner1.setSl_cp_branch(rs.getString("cp_branch"));
				mainBanner1.setSl_cp_idx(rs.getInt("cp_idx"));
				mainBanner1.setBanner_image(rs.getString("banner_image"));
				mainBanner1List.add(mainBanner1);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getMainBanner1 ERROR: " + ex);
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
	
	public boolean getMainBanner2(List<MainPageDateOfOpenVO> mainBanner2List, boolean auto_status) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "";

			if (auto_status) {
				sql = "select cp_f.cp_idx,cp.cp_name,cp.cp_intro_headline,cp.cp_intro_content,cp.cp_open_datetime,concat(cp_f.cf_folder,(SELECT file_path FROM file_path WHERE idx = 3),cp_f.cf_pr_background) as banner_image from company_file cp_f,company cp where cp.cp_idx = cp_f.cp_idx and cp.cp_open_status = 0 limit 3";
			} else {
				sql = "SELECT * FROM am_banner_2";
			}

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MainPageDateOfOpenVO mainBanner2 = new MainPageDateOfOpenVO();
				mainBanner2.setCp_idx(rs.getInt("cp_idx"));
				mainBanner2.setCp_name(rs.getString("cp_name"));
				mainBanner2.setCp_intro_headline(rs.getString("cp_intro_headline"));
				mainBanner2.setCp_intro_content(rs.getString("cp_intro_content"));
				mainBanner2.setCp_open_datetime(rs.getDate("cp_open_datetime"));
				mainBanner2.setBanner_image(rs.getString("banner_image"));
				mainBanner2List.add(mainBanner2);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getMainBanner2 ERROR: " + ex);
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
	
	public ArrayList<MainPageDeadLineVO> getCompanyDeadLine() {
		String sql = "SELECT cp_idx, cp_monthly_profit, cp_sector, cp_name, cp_branch, iv_current_amount, appl_stop_date_time, iv_goal_amount, thumbnail_image, persent FROM admin_deadLine";
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
				mainPageDeadLineVO.setIv_appl_stop_date_time(rs.getDate("appl_stop_date_time"));
				mainPageDeadLineVO.setIv_goal_amount(rs.getString("iv_goal_amount"));
				mainPageDeadLineVO.setThumbnail_image(rs.getString("thumbnail_image"));
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

	// 대망의 포로시저 ~~~
	// 기업 투자하깅~
	public boolean invest(int _mb_idx, int _cp_idx, String _cp_name, int _po_amount, String _mi_hoiling_stock) {
		CallableStatement cstmt = null;
		int result = 0;
		ResultSet rs = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("call INVEST(?,?,?,?,?,?)");
			cstmt.setInt(1, _mb_idx);
			cstmt.setInt(2, _cp_idx);
			cstmt.setString(3, _cp_name);
			cstmt.setInt(4, _po_amount);
			cstmt.setString(5, _mi_hoiling_stock);
			cstmt.registerOutParameter(6, java.sql.Types.INTEGER);
			cstmt.execute();
			result = cstmt.getInt("@RESULT");
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("invest 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return false;
	}

	// 박신규 끝//////////////////////////

	// 유정 추가 start ////////////////////////////
	// 투자하기 - 모든 기업 정보 불러오기
	// 태훈 - 투자하기 필요한 정보 JOIN활용 불러오기
	public CompanyBean getCompanyInfo2(int idx) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CompanyBean company = null;

		try {
			// 쿼리
			String sql = "SELECT *,(iv_current_amount/iv_goal_amount*100) AS percent, CONCAT((SELECT file_path FROM file_path WHERE idx = 2),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 4)) AS company_file_path ,CONCAT((SELECT file_path FROM file_path WHERE idx = 2),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 3)) AS company_image_path  FROM company cp JOIN company_invest cp_iv ON cp.cp_idx = cp_iv.cp_idx JOIN company_pay_schedule cp_pay ON cp.cp_idx = cp_pay.cp_idx JOIN company_pre_revenue cp_rev ON cp.cp_idx = cp_rev.cp_idx JOIN company_file cf ON cp.cp_idx = cf.cp_idx WHERE cp.cp_idx = ? AND cp_iv.cp_idx = cp.cp_idx AND cp_pay.cp_idx = cp.cp_idx AND cp_rev.cp_idx = cp.cp_idx AND cf.cp_idx = cp.cp_idx";
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
				company.setCp_open_datetime(rs.getDate("cp_open_datetime"));
				company.setCp_avg_monthly_sales(rs.getString("cp_avg_monthly_sales"));
				company.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				company.setCp_reg_datetime(rs.getDate("cp_reg_datetime"));
				company.setCp_exit_datetime(rs.getDate("cp_exit_datetime"));
				company.setCp_intro_content(rs.getString("cp_intro_content"));
				company.setCp_purpose(rs.getString("cp_purpose"));
				//company.setCp_point_comment(rs.getString("cp_point_comment"));
				company.setCp_update_datetime(rs.getDate("cp_update_datetime"));
				company.setCp_business_risk(rs.getString("cp_business_risk"));
				company.setCp_company_risk(rs.getString("cp_company_risk"));
				company.setCp_other_risks(rs.getString("cp_other_risks"));
				company.setCp_recommand(rs.getBoolean("cp_recommand"));
				company.setCp_best(rs.getBoolean("cp_best"));

				// InvestVO
				// 태훈 추가 - 투자율
				company.setIv_percent(rs.getString("percent"));
				company.setIv_goal_amount(rs.getString("iv_goal_amount"));
				company.setIv_current_amount(rs.getString("iv_current_amount"));
				company.setIv_min_amount(rs.getString("iv_min_amount"));
				company.setIv_balance_stock(rs.getString("iv_balance_stock"));
				company.setIv_appl_start_date_time(rs.getDate("iv_appl_start_date_time"));
				company.setIv_appl_stop_date_time(rs.getDate("iv_appl_stop_date_time"));
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
				company.setCf_store_images(rs.getString("cf_store_images"));
				company.setCf_alias_store_images(rs.getString("cf_alias_store_images"));
				company.setCf_corporation_icon(rs.getString("cf_corporation_icon"));
				company.setCf_alias_corporation_icon(rs.getString("cf_alias_corporation_icon"));
				company.setCf_invest_image(rs.getString("cf_invest_image"));
				company.setCf_alias_invest_image(rs.getString("cf_alias_invest_image"));
				company.setCf_folder(rs.getString("cf_folder"));
				company.setCf_business_plan_images(rs.getString("cf_business_plan_images"));
				company.setCf_alias_business_plan_images(rs.getString("cf_alias_business_plan_images"));
				company.setCf_etc_files(rs.getString("cf_etc_files"));
				company.setCf_alias_etc_files(rs.getString("cf_alias_etc_files"));
				company.setCf_thumbnail(rs.getString("cf_thumbnail"));
				company.setCf_alias_thumbnail(rs.getString("cf_alias_thumbnail"));
				company.setCf_pr_background(rs.getString("cf_pr_background"));
				company.setCf_alias_pr_background(rs.getString("cf_alias_pr_background"));
				company.setCf_funding_contract(rs.getString("cf_funding_contract"));
				company.setCf_alias_funding_contract(rs.getString("cf_alias_funding_contract"));
				company.setCf_business_plan(rs.getString("cf_business_plan"));
				company.setCf_alias_business_plan(rs.getString("cf_alias_business_plan"));
				
				//파일 경로들
				company.setCompany_file_path(rs.getString("company_file_path"));
				company.setCompany_image_path(rs.getString("company_image_path"));

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
		String sql = "insert into member_invest(mb_idx,mb_id,mi_category,mi_name,mi_branch,mi_point,mi_hoiling_stock,cp_idx,mi_reg_date_time) values (?,?,?,?,?,?,?,?,now())";
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

	// 투자현황 - 투자내역 불러오기
	public ArrayList<MemberInvestVO> getInvestment(String id, int startRow, int endRow) {// 시작페이지, 끝 페이지
		String sql = "select mi_category,mi_name,mi_point,mi_reg_date_time,mi_note from member_invest where mb_id=? order by mi_idx desc limit "
				+ startRow + ", " + endRow;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberInvestVO> member_invest_list = new ArrayList<MemberInvestVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			while (rs.next()) {

				MemberInvestVO member_invest = new MemberInvestVO();
				member_invest.setMi_category(rs.getString("mi_category"));
				member_invest.setName(rs.getString("mi_name"));
				member_invest.setPoint(rs.getString("mi_point"));
				member_invest.setMi_reg_date_time(rs.getDate("mi_reg_date_time"));
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
				} catch (SQLException ex) {
				}
		}
		System.out.println("total: " + total);
		return total;
	}

	// 즐겨찾기 insert
	public boolean insertLikeBox(LikeBoxVO likebox) {
		String sql = "insert into member_likebox (mb_idx,cp_idx,like_cp_name,like_cp_date) values (?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, likebox.getMb_idx());
			pstmt.setInt(2, likebox.getCp_idx());
			pstmt.setString(3, likebox.getLike_cp_name());

			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("insertLikeBox 에러: " + ex);
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

	// 즐겨찾기 delete
	public boolean deleteLikeBox(int cp_idx, String mb_idx) {
		String sql = "delete from member_likebox where cp_idx=? and mb_idx=?";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			pstmt.setString(2, mb_idx);

			result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("deleteLikeBox 에러: " + ex);
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

	// 즐겨찾기한 기업 수 - 찜한 기업 addClass('on') 되도록 하기
	public int getLikeBoxCount(String mb_idx, int cp_idx) {
		int total = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "select count(*) from member_likebox where mb_idx=? and cp_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			pstmt.setInt(2, cp_idx);
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
				} catch (SQLException ex) {
				}
		}
		return total;
	}
	// 유정 추가 end ////////////////////////////

	// 김윤식 추가 - 기업리스트
	public ArrayList<CompanyListVO> getCompanyList() {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CompanyListVO> leftCompanyList = new ArrayList<CompanyListVO>();

		try {

			String sql = "SELECT cp_idx, cp_name,cp_recommand,cp_best FROM company ORDER BY cp_recommand DESC ,cp_best DESC";
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

	public boolean getAllAutoStatus(List<Boolean> autoStatusList) {
		String sql = "SELECT aas_auto_status FROM admin_am_setting";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				autoStatusList.add(rs.getBoolean("aas_auto_status"));
				i++;
			}
			return true;

		} catch (Exception ex) {
			System.out.println("getAllAutoStatus 에러: " + ex);
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
		return false;
	}

}

