package net.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.board.dto.Board_Search_ListVO;
import net.board.dto.FaqVO;
import net.board.dto.NoticeVO;
import net.board.dto.QnaVO;

public class BoardDAO {

	private static BoardDAO instance;

	// 3.
	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public BoardDAO() {

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

	/////////////////////// 유정 추가 start///////////////////////
	// 1:1 문의내역 - 문의등록 insert
	public boolean insertQna(QnaVO qna) {
		String sql = "insert into qna(id,category,name,email,mobile,title,content,email_chk,mobile_chk,reg_date_time) values (?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qna.getId());
			pstmt.setString(2, qna.getCategory());
			pstmt.setString(3, qna.getName());
			pstmt.setString(4, qna.getEmail());
			pstmt.setString(5, qna.getMobile());
			pstmt.setString(6, qna.getTitle());
			pstmt.setString(7, qna.getContent());
			pstmt.setInt(8, qna.getEmail_chk());
			pstmt.setInt(9, qna.getMobile_chk());

			result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("insertQna 에러: " + ex);
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

	// 총 qna 리스트 수 출력 함수
	public int qnaCount(String id) {

		String sql = "select * from qna where id =?";
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("qnaCount 에러: " + ex);
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

		return 0;

	}

	// 총 faq 리스트 수 출력 함수
	public int faqCount(String category) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "select * from faq where category = ?";

		try {
			if (category.equals("0")) {
				sql = "select * from faq ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category);
				rs = pstmt.executeQuery();
			}

			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("faqCount 에러: " + ex);
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
		return 0;
	}

	public int noticeCount() {
		String sql = "select * from notice";
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("noticeCount 에러: " + ex);
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

		return 0;

	}

	// 1:1 문의내역 - 문의 리스트 가져오기
	public List<QnaVO> getQnaList(String id, int startRow, int pageSize) throws Exception {// 시작페이지, 끝 페이지
		String sql = "SELECT idx,category,title,content,reg_date_time,qna_reply FROM qna WHERE id = ? order by idx desc limit "
				+ startRow + ", " + pageSize;

		List<QnaVO> qna_list = new ArrayList<QnaVO>();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			// 쿼리
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();

			while (rs.next()) { // 1:1문의 리스트를 DTO에 담는다.
				QnaVO qna = new QnaVO();

				qna.setIdx(rs.getInt("idx"));
				qna.setCategory(rs.getString("category"));
				qna.setTitle(rs.getString("title"));
				qna.setContent(rs.getString("content"));
				qna.setReg_date_time(rs.getDate("reg_date_time"));
				qna.setQna_reply(rs.getString("qna_reply"));
				qna_list.add(qna);

			}
			return qna_list;

		} catch (Exception ex) {
			System.out.println("getQnaList 에러: " + ex);
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


	// 고객지원 - 공지사항 불러오기
	public ArrayList<NoticeVO> getNotice(int startRow, int pageSize) throws Exception {
		String sql = "select idx,title,content,reg_date_time from notice order by reg_date_time desc limit " + startRow +","+ pageSize;
		ArrayList<NoticeVO> notice_list = new ArrayList<NoticeVO>();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				NoticeVO notice = new NoticeVO();

				notice.setIdx(rs.getInt("idx"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setReg_date_time(rs.getDate("reg_date_time"));
				notice_list.add(notice);
			}
			return notice_list;

		} catch (Exception ex) {

			System.out.println("getNotice 에러: " + ex);
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

	// 윤식추가 쿼리문 통일
	// 고객지원 - FAQ 불러오기
	public ArrayList<FaqVO> getFaq(String category, int startRow, int pageSize) throws Exception {
		ArrayList<FaqVO> faq_list = new ArrayList<FaqVO>();
		// 0을 넣었을때 다른 sql 구문이 돌수 있게 하자
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select title,content from faq where category=? order by reg_date_time desc limit " + startRow
				+ ", " + pageSize;

		try {
			if (category.equals("0")) {
				sql = "select * from faq order by reg_date_time desc limit " + startRow + "," + pageSize;
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} else {
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, category);
				rs = pstm.executeQuery();
			}

			while (rs.next()) {
				FaqVO faq = new FaqVO();
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				faq_list.add(faq);
			}
			return faq_list;

		} catch (Exception ex) {

			System.out.println("getFaq 에러: " + ex);
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

	// 윤식 추가
	// FAQ 검색기능 count
	public int searchFaqCount(String keyword, int category) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;

		try {// 실행
			String sql = "select title,content,category from faq ";

			if (keyword != null && !keyword.equals("") && category != 0) {
				sql += "WHERE title LIKE '%" + keyword.trim() + "%' and category=? order by reg_date_time desc";
			} else {// 모든 레코드 검색
				sql += "WHERE title LIKE '%" + keyword.trim()
						+ "%' and (category=? or 1 or 2 or 3) order by reg_date_time desc";
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();
			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("searchFaqCount: " + ex);
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
		return 0;
	}

	public ArrayList<FaqVO> searchFaq(String keyword, int category, int startRow, int pageSize) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FaqVO> faq_list = new ArrayList<FaqVO>();

		try {// 실행
			String sql = "select title,content,category from faq ";

			if (keyword != null && !keyword.equals("") && category != 0) {
				sql += "WHERE title LIKE '%" + keyword.trim() + "%' and category=? order by reg_date_time desc limit "
						+ startRow + "," + pageSize;
			} else {// 모든 레코드 검색
				sql += "WHERE title LIKE '%" + keyword.trim()
						+ "%' and (category=? or 1 or 2 or 3) order by reg_date_time desc limit " + startRow + ","
						+ pageSize;
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				FaqVO faq = new FaqVO();

				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));

				faq_list.add(faq);
			}
		} catch (Exception ex) {
			System.out.println("searchFaq ERROR: " + ex);
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
		return faq_list;
	}

	/////////////////////// 유정 추가 end///////////////////////

	//////////////////// 태훈 추가 start ////////////////////////

	// 태훈 - 기업 리스트(전체 리스트 가져오기)
	public ArrayList<Board_Search_ListVO> ListInfo() throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board_Search_ListVO> Search_list = new ArrayList<Board_Search_ListVO>();

		try {
			String sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount "
					+ "FROM company as cp, company_invest as cp_iv " + "WHERE cp.cp_idx = cp_iv.cp_idx "
					+ "ORDER BY cp_reg_datetime DESC";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board_Search_ListVO listVO = new Board_Search_ListVO();

				listVO.setSearch_cp_branch(rs.getString("cp_branch"));
				listVO.setSearch_cp_current_amount(rs.getString("iv_current_amount"));
				listVO.setSearch_cp_goal_amount(rs.getString("iv_goal_amount"));
				listVO.setSearch_cp_idx(rs.getString("cp_idx"));
				listVO.setSearch_cp_name(rs.getString("cp_name"));
				listVO.setSearch_cp_percent(rs.getString("percent"));
				listVO.setSearch_cp_profit(rs.getString("cp_monthly_profit"));
				listVO.setSearch_cp_sector(rs.getString("cp_sector"));

				Search_list.add(listVO);
			}
			return Search_list;

		} catch (Exception ex) {
			System.out.println("Board_Search_ListVO ERROR: " + ex);
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

	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray Search_ListInfo(List<String> list_all, String select_value, int page,String getKeyword) throws Exception {
		if (page < 0) {
			return null;
		}
		int n = 8 * page;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		JSONArray jsonArr = new JSONArray();

		int pstmt_num = 0;

		//String nothing = "검색어없음";
		boolean searchWordFlag = false;
		
		/*
		 * for (int i = 0; i < list_all.size(); i++) { if
		 * (list_all.get(i).equals(nothing)) { list_all.remove(i); AndFlag = false;
		 * break; } }
		 */
		
		if (!getKeyword.equals("")) {
			searchWordFlag = true;
		}

		try {
			// 쪼인해도되고안해도되고
			String sql = "SELECT cp.cp_recommand_count, cp.cp_overdue_status, cp.cp_revenue_distribution_status, cp.cp_add_ch, cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount, cp.cp_reg_datetime, cp_iv.iv_appl_stop_date_time,  CONCAT((SELECT file_path FROM file_path WHERE idx = 2),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 3),cf.cf_alias_thumbnail) as thumbnail_image FROM company as cp JOIN company_invest as cp_iv ON cp.cp_idx = cp_iv.cp_idx JOIN company_file as cf ON cp.cp_idx = cf.cp_idx ";

			if (list_all != null) {				
				for (int i = 0; i < list_all.size(); i++) {
					if(i == 0) {
						if(list_all.get(i).equals("10") || list_all.get(i).equals("11") || list_all.get(i).equals("12")) {
							sql += "WHERE (CONCAT(cp.cp_funding_status) LIKE ? ";
						}
						if(list_all.get(i).equals("21") || list_all.get(i).equals("22")) {
							sql += "WHERE (CONCAT(cp.cp_revenue_distribution_status) LIKE ? ";
							
						}
						if(list_all.get(i).equals("30")) {
							sql += "WHERE (CONCAT(cp.cp_overdue_status) LIKE ? ";
						}
						if(!list_all.get(i).equals("10") && !list_all.get(i).equals("11") && !list_all.get(i).equals("12")
								 && !list_all.get(i).equals("21") && !list_all.get(i).equals("22") && !list_all.get(i).equals("30")) {
							sql += "WHERE (CONCAT(cp.cp_sector, cp.cp_add_ch, cp.cp_branch) LIKE ? ";
						}
					} else if(i != 0){
						if(list_all.get(i).equals("10") || list_all.get(i).equals("11") || list_all.get(i).equals("12")) {
							sql += "OR CONCAT(cp.cp_funding_status) LIKE ? ";
						}
						if(list_all.get(i).equals("21") || list_all.get(i).equals("22")) {
							sql += "OR CONCAT(cp.cp_revenue_distribution_status) LIKE ? ";
						}
						if(list_all.get(i).equals("30")) {
							sql += "OR CONCAT(cp.cp_overdue_status) LIKE ? ";
						}
						if(!list_all.get(i).equals("10") && !list_all.get(i).equals("11") && !list_all.get(i).equals("12")
								 && !list_all.get(i).equals("21") && !list_all.get(i).equals("22") && !list_all.get(i).equals("30")) {
							sql += "OR CONCAT(cp.cp_sector, cp.cp_add_ch, cp.cp_branch) LIKE ? ";
						}
					}
				}
				if (list_all.size() > 0) {
					sql += ") ";
				}
				if (searchWordFlag) {
					sql += " AND cp.cp_name LIKE ? ";
				}
				if (select_value.equals("1")) {
					sql += "ORDER BY cp.cp_recommand_count DESC";
				} else if (select_value.equals("2")) {
					sql += "ORDER BY cp.cp_monthly_profit DESC";
				} else {
					sql += "ORDER BY cp.cp_reg_datetime DESC";
				}
			} else {
				if (select_value.equals("1")) {
					sql += "ORDER BY cp.cp_recommand_count DESC";
				} else if (select_value.equals("2")) {
					sql += "ORDER BY cp.cp_monthly_profit DESC";
				} else {
					sql += "ORDER BY cp.cp_reg_datetime DESC";
				}
			}
			sql += " limit ?, 8";
			pstmt = conn.prepareStatement(sql);
			if (list_all != null) {
				int i = 0;
				for (i = 0; i < list_all.size(); i++) {
					pstmt.setString(i + 1, "%" + list_all.get(i) + "%");
				}
				if (searchWordFlag) {
					pstmt.setString(i+1,"%"+getKeyword+"%");
					pstmt.setInt(i + 2, n);
				}else {
					pstmt.setInt(i + 1, n);
				}
				
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("cp_branch", rs.getString("cp_branch"));
				jsonObj.put("cp_current_amount", rs.getString("iv_current_amount"));
				jsonObj.put("cp_goal_amount", rs.getString("iv_goal_amount"));
				jsonObj.put("cp_idx", rs.getString("cp_idx"));
				jsonObj.put("cp_name", rs.getString("cp_name"));
				jsonObj.put("percent", rs.getString("percent"));
				jsonObj.put("cp_monthly_profit", rs.getString("cp_monthly_profit"));
				jsonObj.put("cp_sector", rs.getString("cp_sector"));
				jsonObj.put("cp_stop_date_time", rs.getString("iv_appl_stop_date_time"));
				jsonObj.put("thumbnail_image", rs.getString("thumbnail_image"));
				jsonArr.add(jsonObj);
			}
			return jsonArr;

		} catch (Exception ex) {
			System.out.println("검색 ERROR: " + ex);
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

	//////////////////// 태훈 추가 end //////////////////////////
	//////////////////// 신규 추가 start //////////////////////////

	// 스크롤 - 전체 보기
	public ArrayList<Board_Search_ListVO> getCompanyListScroll(int page) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board_Search_ListVO> Search_list = new ArrayList<Board_Search_ListVO>();

		try {
			String sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount FROM company as cp, company_invest as cp_iv WHERE cp.cp_idx = cp_iv.cp_idx ORDER BY cp_reg_datetime DESC LIMIT ?, 8";

			if (page < 0) {
				return null;
			}
			int n = 8 * page;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, n);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board_Search_ListVO listVO = new Board_Search_ListVO();

				listVO.setSearch_cp_branch(rs.getString("cp_branch"));
				listVO.setSearch_cp_current_amount(rs.getString("iv_current_amount"));
				listVO.setSearch_cp_goal_amount(rs.getString("iv_goal_amount"));
				listVO.setSearch_cp_idx(rs.getString("cp_idx"));
				listVO.setSearch_cp_name(rs.getString("cp_name"));
				listVO.setSearch_cp_percent(rs.getString("percent"));
				listVO.setSearch_cp_profit(rs.getString("cp_monthly_profit"));
				listVO.setSearch_cp_sector(rs.getString("cp_sector"));

				Search_list.add(listVO);
			}
			return Search_list;

		} catch (Exception ex) {
			System.out.println("getCompanyListScroll ERROR: " + ex);
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

	//////////////////// 신규 추가 end //////////////////////////
}
