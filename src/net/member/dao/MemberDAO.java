package net.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.member.dto.Main_LikeVO;
import net.member.dto.Main_SlideVO;
import net.member.dto.MemberBean;
import net.member.dto.MemberInvestCompanyVO;
import net.member.dto.MemberInvestPageVO;
import net.member.dto.MemberInvestVO;
import net.member.dto.Member_header;
import net.member.dto.Member_likebox;

public class MemberDAO {

	private static MemberDAO instance;

	// 3.
	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
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

	public MemberDAO() {

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
	// 회원가입 insert
	public boolean insertMember(MemberBean member) {
		String sql = "insert into member(mb_id,mb_pw,mb_pincode,mb_email,mb_name,mb_phone,mb_add_num,mb_add_ch,mb_add_more,mb_add_extra,mb_recommend,agree1,agree2,reg_date_time) values (?,?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getPin());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getName());
			pstmt.setString(6, member.getPh());
			pstmt.setString(7, member.getAdd_num());
			pstmt.setString(8, member.getAdd_ch());
			pstmt.setString(9, member.getAdd_more());
			pstmt.setString(10, member.getAdd_extra());
			pstmt.setString(11, member.getReco());
			pstmt.setInt(12, member.getAgree1());
			pstmt.setInt(13, member.getAgree2());

			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("insertMember 에러: " + ex);
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

	// 회원가입 id 중복체크
	public boolean duplicateIdCheck(String id) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean x = false;

		int cnt = 0;

		try {
			// 쿼리
			String sql = "SELECT count(*) as cnt FROM member WHERE mb_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");

				if (cnt != 0) {
					System.out.println("아이디가 존재합니다.");
					x = true; // 해당 아이디 존재
				}
				return x;
			} else {
				System.out.println("duplicateIdCheck(DAO) 쿼리문 작동 실패");
			}

		} catch (Exception ex) {
			System.out.println("duplicateIdCheck 에러: " + ex);
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

		return false;

	}

	// 회원가입 phone번호 중복체크
	public boolean duplicatePhoneCheck(String ph, String ph2) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		boolean x = false;

		int cnt = 0;

		try {
			// 쿼리
			String sql = "SELECT count(*) as cnt FROM member WHERE (mb_phone=? or mb_phone=?)";
			pstm = conn.prepareStatement(sql);
			System.out.println("mb_phone : " + ph);
			System.out.println("mb_phone2 : " + ph2);
			pstm.setString(1, ph2);
			pstm.setString(2, ph);

			rs = pstm.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");

				if (cnt != 0) {
					System.out.println("번호가 존재합니다.");
					x = true; // 해당 번호 존재
				}
				System.out.println("사용가능한 번호입니다.");
				return x;
			} else {
				System.out.println("duplicatePhoneCheck(DAO) 쿼리문 작동 실패");
			}

		} catch (Exception ex) {
			System.out.println("duplicatePhoneCheck 에러: " + ex);
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

		return false;

	}

	// 로그인 체크
	public int login_check(MemberBean member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select mb_pw, mb_pincode from member where mb_id=?";
		int result = -1;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("mb_pw").equals(member.getPw())) {
					result = 1; // 아이디와 비밀번호 일치하는 경우
				} else {
					result = 0; // 아이디는 있으나 비밀번호 맞지 않는 경우
				}
			} else {
				result = -1;// 잘못된 정보 또는 관리자가 아닙니다. 아이디가 없는 경우
			}
		} catch (Exception ex) {
			System.out.println("isMember 에러: " + ex);
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

		return result;
	}

	// 아이디찾기 아이디 불러오기
	public String get_MemberId(String name, String phone) {
		String sql = "select mb_id from member where mb_name=? and mb_phone=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_MemberId 실행 : " + phone);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);

			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_id = rs.getString("mb_id");
				return mb_id;
			}

		} catch (Exception ex) {

			System.out.println("get_MemberId 에러: " + ex);

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

	// 비밀번호 찾기 시 아이디 불러와서 존재하는지 여부 확인
	public String get_FindPw(String phone, String id) {
		String sql = "select mb_id from member where mb_phone=? and mb_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_MemberId 실행 : " + phone);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_id = rs.getString("mb_id");
				return mb_id;
			}

		} catch (Exception ex) {

			System.out.println("get_MemberId 에러: " + ex);

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

	// 비밀번호 찾기 시 새 비밀번호 발급
	public boolean setNewPw(String id, String pw) {
		String sql = "update member set mb_pw=? where mb_id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			System.out.println(pstmt);
			return true;
		} catch (Exception ex) {
			System.out.println("setNewPw 에러: " + ex);
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
	}// end

	// 개인 정보 수정 - 회원 정보 가져오기
	public MemberBean getMemberInfo(String id) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MemberBean member = null;

		try {
			// 쿼리
			String sql = "SELECT mb_id,mb_pw,mb_pincode,mb_email,mb_name,mb_phone,mb_add_num,mb_add_ch,mb_add_more,mb_add_extra FROM member WHERE mb_id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rs = pstm.executeQuery();

			if (rs.next()) { // 회원정보를 DTO에 담는다.

				member = new MemberBean();
				member.setId(rs.getString("mb_id"));
				member.setPw(rs.getString("mb_pw"));
				member.setPin(rs.getString("mb_pincode"));
				member.setEmail(rs.getString("mb_email"));
				member.setName(rs.getString("mb_name"));
				member.setPh(rs.getString("mb_phone"));
				member.setAdd_num(rs.getString("mb_add_num"));
				member.setAdd_ch(rs.getString("mb_add_ch"));
				member.setAdd_more(rs.getString("mb_add_more"));
				member.setAdd_extra(rs.getString("mb_add_extra"));

			} else {
				System.out.println("getMemberInfo(DAO) 쿼리문 작동 실패");
			}

			return member;

		} catch (Exception ex) {
			System.out.println("getMemberInfo 에러: " + ex);
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

	// 개인 정보 수정
	public boolean updateMember(MemberBean member) {
		String sql = "update member set mb_email=?,mb_pw=?,mb_pincode=?,mb_phone=?,mb_add_num=?,mb_add_ch=?,mb_add_more=?,mb_add_extra=? where mb_id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getPin());
			pstmt.setString(4, member.getPh());
			pstmt.setString(5, member.getAdd_num());
			pstmt.setString(6, member.getAdd_ch());
			pstmt.setString(7, member.getAdd_more());
			pstmt.setString(8, member.getAdd_extra());
			pstmt.setString(9, member.getId());

			pstmt.executeUpdate();
			System.out.println(pstmt);

			return true;

		} catch (Exception ex) {
			System.out.println("updateMember 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("updateMember 실패 : " + e.getMessage());
			}
		}

		return false;
	}// end

	// tx비밀번호 찾기 시 아이디 불러와서 존재하는지 여부 확인
	public String get_FindTx_id(String id) {
		String sql = "select mb_id from member where mb_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_FindTx_id 실행 : " + id);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_id = rs.getString("mb_id");
				return mb_id;
			}

		} catch (Exception ex) {

			System.out.println("get_FindTx_id 에러: " + ex);

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

	// tx비밀번호 찾기 시 비밀번호 불러와서 존재하는지 여부 확인
	public String get_FindTx_pw(String id, String pw) {
		String sql = "select mb_pw from member where mb_id=? and mb_pw=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_FindTx_pw 실행 : " + id);
		System.out.println("get_FindTx_pw 실행 : " + pw);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_pw = rs.getString("mb_pw");
				return mb_pw;
			}

		} catch (Exception ex) {

			System.out.println("get_FindTx_pw 에러: " + ex);

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

	// tx비밀번호 찾기 시 휴대폰 번호 불러와서 존재하는지 여부 확인
	public String get_FindTx_phone(String id, String phone) {
		String sql = "select mb_phone from member where mb_id=? and mb_phone=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_MemberID 실행 : " + id);
		System.out.println("get_MemberPhone 실행 : " + phone);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_phone = rs.getString("mb_phone");
				return mb_phone;
			}

		} catch (Exception ex) {

			System.out.println("get_MemberPhone 에러: " + ex);

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

	// tx비밀번호 찾기 시 새 비밀번호 발급
	public boolean setNewTx(String id, String tx) {
		String sql = "update member set mb_pincode=? where mb_id=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tx);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			System.out.println(pstmt);
			return true;
		} catch (Exception ex) {
			System.out.println("setNewPw 에러: " + ex);
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
	}// end

	// 회원정보 수정 시 비밀번호 확인
	public String get_Find_pw(String id) {
		String sql = "select mb_pw from member where mb_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_Find_pw 실행 : " + id);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_pw = rs.getString("mb_pw");
				return mb_pw;
			}

		} catch (Exception ex) {

			System.out.println("get_Find_pw 에러: " + ex);

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

	// 회원정보 수정 시 핀코드 확인
	public String get_Find_pin(String id) {
		String sql = "select mb_pincode from member where mb_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("get_Find_pin 실행 : " + id);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			if (rs.next()) {

				String mb_pin = rs.getString("mb_pincode");
				return mb_pin;
			}

		} catch (Exception ex) {

			System.out.println("get_Find_pin 에러: " + ex);

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

	/////////////////////// 유정 추가 end///////////////////////

	////////////////////////////// 태훈추가 start//////////////////////////////
	// 보유 토큰, 포인트, 누적수익
	public Member_header Member_accumulate(String mb_idx) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member_header member = new Member_header();

		try {
			// 쿼리
			String sql = "SELECT a.mb_token, a.mb_point, sum(b.mi_cumulative_profit) " + "FROM member as a "
					+ "JOIN member_invest as b " + "ON a.mb_idx = b.mb_idx " + "WHERE a.mb_idx = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				member.setMb_point(rs.getString("mb_point"));
				member.setMb_token(rs.getString("mb_token"));
				member.setMb_accumulate(rs.getString("sum(b.mi_cumulative_profit)"));
			}
			System.out.println(member.getMb_point() + member.getMb_token() + member.getMb_accumulate());

			return member;
		} catch (Exception ex) {
			System.out.println("coin_transaction ERROR: " + ex);
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

	// session mb_idx
	public String Session_idx(String mb_id) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String mb_idx = null;

		try {
			// 쿼리
			String sql = "SELECT mb_idx FROM member WHERE mb_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			rs = pstmt.executeQuery();
			System.out.println("session DAO>>>>>>>>>" + pstmt);

			if (rs.next()) {
				mb_idx = rs.getString("mb_idx");
			}

			System.out.println("SELECT ERROR>>>>>");
			return mb_idx;

		} catch (Exception ex) {
			System.out.println("coin_transaction ERROR: " + ex);
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

	// 찜목록 리스트
	public List<Member_likebox> LikeboxInfo(String mb_idx) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member_likebox> boxs = new ArrayList<Member_likebox>();

		try {
			// 쿼리 기업 idx필요
			String sql = "SELECT a.like_cp_name, b.cp_monthly_profit, b.cp_branch, b.cp_sector, c.iv_current_amount/c.iv_goal_amount*100 "
					+ "FROM member_likebox as a " 
					+ "JOIN company as b ON a.cp_idx = b.cp_idx AND a.cp_idx = ? "
					+ "JOIN company_invest as c ON b.cp_idx = c.cp_idx";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			while (rs.next()) {
				Member_likebox box = new Member_likebox();

				box.setLike_cp_name(rs.getString("like_cp_name"));
				box.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				box.setCp_branch(rs.getString("cp_branch"));
				box.setCp_sector(rs.getString("cp_sector"));
				// 현재 투자율 계산
				box.setCp_like_percent(rs.getString("c.iv_current_amount/c.iv_goal_amount*100"));

				boxs.add(box);
			}
		} catch (Exception ex) {
			System.out.println("LikeboxInfo ERROR: " + ex);
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
		System.out.println(boxs.toString());
		return boxs;
	}

	// 메인 페이지 슬라이드 기업 리스트
	public List<Main_SlideVO> Main_SlideInfo() throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Main_SlideVO> slidVO = new ArrayList<Main_SlideVO>();

		try {
			// 쿼리 기업 idx필요
			String sql = "SELECT cp_name, cp_branch, cp_intro_content FROM company ORDER BY RAND() LIMIT 3";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			while (rs.next()) {
				Main_SlideVO slide = new Main_SlideVO();
				slide.setSl_cp_content(rs.getString("cp_intro_content"));
				slide.setSl_cp_name(rs.getString("cp_name"));
				slide.setSl_cp_branch(rs.getString("cp_branch"));
				
				slidVO.add(slide);
			}
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
		return slidVO;
	}
	
	// 메인 페이지 추천 기업 리스트
		public List<Main_LikeVO> Main_LikeInfo() throws Exception {

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Main_LikeVO> LikeVO = new ArrayList<Main_LikeVO>();

			try {
				// 쿼리 기업 idx필요
				String sql = "SELECT cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount "
						+ "FROM company as cp, company_invest as cp_iv "
						+ "ORDER BY cp_iv_count DESC, cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100 DESC LIMIT 4";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println(pstmt);

				while (rs.next()) {
					Main_LikeVO like = new Main_LikeVO();
					like.setLk_cp_branch(rs.getString("cp_branch"));
					like.setLk_cp_current_amount(rs.getString("iv_current_amount"));
					like.setLk_cp_goal_amount(rs.getString("iv_goal_amount"));
					like.setLk_cp_name(rs.getString("cp_name"));
					like.setLk_cp_percent(rs.getString("percent"));
					like.setLk_cp_profit(rs.getString("cp_monthly_profit"));
					like.setLk_cp_sector(rs.getString("cp_sector"));
					
					LikeVO.add(like);
				}
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
			return LikeVO;
		}

	////////////////////////////// 태훈추가 end//////////////////////////////

	// 윤식 추가/////////////////////////////////////////////////
	public MemberInvestPageVO getMyPageInvestment(int cp_idx, String id) {
		String sql = "select B.mi_idx AS mi_idx, A.mb_idx AS mb_idx, B.mi_name AS mi_name, B.mi_point AS mi_point, B.cp_idx AS cp_idx, B.mi_hoiling_stock AS mi_hoiling_stock, B.mi_stock_value AS mi_stock_value, B.mi_monthly_profit AS mi_monthly_profit, B.mi_cumulative_profit AS mi_cumulative_profit, C.cp_number AS cp_number,C.cp_name AS cp_name ,C.cp_manager AS cp_manager,C.cp_name AS cp_capital , C.cp_add_ch AS cp_add_ch, cf.cf_certificate AS cf_certificate, cf.cf_estate_contract AS cf_estate_contract, cf.cf_registration AS cf_registration, cf.cf_financial AS cf_financial  from member A, member_invest B, company C,company_file cf WHERE A.mb_idx = B.mb_idx AND B.cp_idx = ? AND A.mb_id = ? AND cf.cp_idx = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("mypageInvest 실행 : " + id);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			pstmt.setString(2, id);
			pstmt.setInt(3, cp_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			if (rs.next()) {
				MemberInvestPageVO memberInvestVO = new MemberInvestPageVO();
				memberInvestVO.setMi_idx(rs.getInt("mi_idx"));
				memberInvestVO.setMb_idx(rs.getInt("mb_idx"));
				memberInvestVO.setMi_name(rs.getString("mi_name"));
				memberInvestVO.setMi_point(rs.getString("mi_point"));
				memberInvestVO.setCp_idx(rs.getInt("cp_idx"));
				memberInvestVO.setMi_hoiling_stock(rs.getString("mi_hoiling_stock"));
				memberInvestVO.setMi_cumulative_profit(rs.getString("mi_cumulative_profit"));
				memberInvestVO.setMi_stock_value(rs.getString("mi_stock_value"));
				memberInvestVO.setMi_monthly_profit(rs.getString("mi_monthly_profit"));
				memberInvestVO.setCp_number(rs.getString("cp_number"));
				memberInvestVO.setCp_capital(rs.getString("cp_capital"));
				memberInvestVO.setCp_add_ch(rs.getString("cp_add_ch"));
				memberInvestVO.setCp_name(rs.getString("cp_name"));
				memberInvestVO.setCp_manager(rs.getString("cp_manager"));
				memberInvestVO.setCf_certificate(rs.getString("cf_certificate"));
				memberInvestVO.setCf_estate_contract(rs.getString("cf_estate_contract"));
				memberInvestVO.setCf_registration(rs.getString("cf_registration"));
				memberInvestVO.setCf_financial(rs.getString("cf_financial"));

				return memberInvestVO;
			}

		} catch (Exception ex) {

			System.out.println("get_Find_pin 에러: " + ex);

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
	// 윤식 END GAME /////////////////////////////////////////////////

	// 박신규 시작~ ///////////////////////////////////////////////////
	// 투자 회사 리스트 뽑깅
	public ArrayList<MemberInvestCompanyVO> getInvestmentCompanyList(String mb_id) {
		String sql = "select cp.cp_idx, cp.cp_name, mi.mb_idx, mi.mb_id from member_invest mi, company cp where mi.cp_idx = cp.cp_idx AND mi.mb_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			rs = pstmt.executeQuery();
			ArrayList<MemberInvestCompanyVO> memberInvestCompanyVOList = new ArrayList<MemberInvestCompanyVO>();
			while (rs.next()) {
				MemberInvestCompanyVO memberInvestCompanyVO = new MemberInvestCompanyVO();
				memberInvestCompanyVO.setCp_idx(rs.getInt("cp_idx"));
				memberInvestCompanyVO.setCp_name(rs.getString("cp_name"));
				memberInvestCompanyVO.setMb_idx(rs.getInt("mb_idx"));
				memberInvestCompanyVO.setMb_id(rs.getString("mb_id"));
				memberInvestCompanyVOList.add(memberInvestCompanyVO);
			}
			return memberInvestCompanyVOList;

		} catch (Exception ex) {

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
	// 박신규 끝~ ///////////////////////////////////////////////////
}
