package net.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.board.dto.Board_Search_ListVO;
import net.board.dto.FaqVO;
import net.board.dto.NoticeVO;
import net.board.dto.QnaReplyVO;
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
	//autoReconnect=true
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
	
	///////////////////////유정 추가 start///////////////////////
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
			System.out.println(pstmt);
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
	public int qnaCount() {
		String sql = "select * from qna";
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			/*
			 * while(rs.next()){ count = rs.getRow(); }
			 */

			/*
			 * rs = pstmt.executeQuery(sql); if(rs.next()) { count = rs.getInt(1); }
			 */

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
	
	
	
	// 1:1 문의내역 - 문의 리스트 가져오기
	public List<QnaVO> getQnaList(String id, int startRow, int pageSize) throws Exception {// 시작페이지, 끝 페이지
		String sql = "SELECT idx,category,title,content,reg_date_time FROM qna WHERE id = ? order by idx desc limit " + startRow + ", " + pageSize;
		
		List<QnaVO> qna_list = new ArrayList<QnaVO>();
		PreparedStatement pstm = null; 
		ResultSet rs = null;

		try {
			// 쿼리
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();

			while (rs.next()) {	// 1:1문의 리스트를 DTO에 담는다.
				QnaVO qna = new QnaVO();
				
				qna.setIdx(rs.getInt("idx"));
		 		qna.setCategory(rs.getString("category"));
		 		qna.setTitle(rs.getString("title"));
		 		qna.setContent(rs.getString("content"));
		 		qna.setReg_date_time(rs.getTimestamp("reg_date_time"));
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
	
		
	
	// 1:1 문의내역 - 답변 가져오기
		public List<QnaReplyVO> getQnaReply(int idx) throws Exception {
			String sql = "select idx,content,reg_date_time from qna_reply where idx = ?";
			
			List<QnaReplyVO> qna_reply_list = new ArrayList<QnaReplyVO>();
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, idx);
				rs = pstm.executeQuery();

				if(rs.next()) {
					QnaReplyVO qna_reply = new QnaReplyVO();
					
					qna_reply.setIdx(rs.getInt("idx"));
					qna_reply.setContent(rs.getString("content"));
					qna_reply.setReg_date_time(rs.getTimestamp("reg_date_time"));
					qna_reply_list.add(qna_reply);
				}
				return qna_reply_list;
				

			} catch (Exception ex) {
				
				System.out.println("getQnaReply 에러: " + ex);
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
		public ArrayList<NoticeVO> getNotice() throws Exception {
			String sql = "select idx,title,content,reg_date_time from notice order by reg_date_time desc";
			
			ArrayList<NoticeVO> notice_list = new ArrayList<NoticeVO>();
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();

				while(rs.next()) {
					NoticeVO notice = new NoticeVO();
					
					notice.setIdx(rs.getInt("idx"));
					notice.setTitle(rs.getString("title"));
					notice.setContent(rs.getString("content"));
					notice.setReg_date_time(rs.getTimestamp("reg_date_time"));
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
		
		
		// 고객지원 - FAQ 불러오기
		public ArrayList<FaqVO> getFaq(int category) throws Exception {
			String sql = "select title,content from faq where category=? order by reg_date_time desc;";
			
			ArrayList<FaqVO> faq_list = new ArrayList<FaqVO>();
			PreparedStatement pstm = null;
			ResultSet rs = null;

			try {
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, category);
				rs = pstm.executeQuery();

				while(rs.next()) {
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

	///////////////////////유정 추가 end///////////////////////
		
	//////////////////// 태훈 추가 start ////////////////////////
		
	// 태훈 - 기업 리스트(전체 리스트 가져오기)
	public ArrayList<Board_Search_ListVO> Search_ListInfo() throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board_Search_ListVO> Search_list = new ArrayList<Board_Search_ListVO>();

		try {
			String sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount "
					+ "FROM company as cp, company_invest as cp_iv "
					+ "WHERE cp.cp_idx = cp_iv.cp_idx "
					+ "ORDER BY cp_reg_datetime DESC";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

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
			
		} catch (Exception ex) {
			System.out.println("Board_Search_ListVO ERROR: " + ex);
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
		return Search_list;
	}
	//////////////////// 태훈 추가 end //////////////////////////
}
