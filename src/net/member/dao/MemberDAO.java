package net.member.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import net.member.dto.InvestDeleteVO;
import net.member.dto.Main_CityVO;
import net.member.dto.Main_LikeVO;
import net.member.dto.Main_SlideVO;
import net.member.dto.MemberBean;
import net.member.dto.MemberInvestCompanyVO;
import net.member.dto.MemberInvestPageVO;
import net.member.dto.MemberIplog;
import net.member.dto.MemberTransactionVO;
import net.member.dto.Member_headerVO;
import net.member.dto.Member_likeboxVO;
import net.member.dto.MypagePointTransactionVO;
import net.member.dto.benefitVO;

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
	
	
	// 펀딩 철회하기
	public boolean deleteInvest(int mb_idx, int cp_idx, int mi_idx) {
		String sql = "delete from member_invest where mb_idx=? and cp_idx=? and mi_idx = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_idx);
			pstmt.setInt(2, cp_idx);
			pstmt.setInt(3, mi_idx);

			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("deleteInvest 에러: " + ex);
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

	/////////////////////// 유정 추가 end///////////////////////

	////////////////////////////// 태훈추가 start//////////////////////////////
	
	// 보유 토큰, 포인트, 누적수익
	public Member_headerVO Member_accumulate(String mb_idx) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member_headerVO member = new Member_headerVO();

		try {
			// 쿼리
			String sql = "SELECT a.mb_token, a.mb_point, sum(b.mi_cumulative_profit) "
					+ "FROM member as a "
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
	public List<Member_likeboxVO> LikeboxInfo(String mb_idx) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member_likeboxVO> boxs = new ArrayList<Member_likeboxVO>();
		try {
			// 쿼리 멤버 idx필요
			String sql = "SELECT a.mb_idx, a.cp_idx, a.like_cp_name, b.cp_monthly_profit, b.cp_branch, b.cp_sector, concat(cf.cf_directory,cf.cf_image1) as cf_directory_image, round((c.iv_current_amount/c.iv_goal_amount*100)) as  percent "
					+ "FROM member_likebox as a " 
					+ "JOIN company as b ON a.cp_idx = b.cp_idx AND a.mb_idx = ? "
					+ "JOIN company_file as cf ON b.cp_idx = cf.cp_idx "
					+ "JOIN company_invest as c ON b.cp_idx = c.cp_idx";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			while (rs.next()) {
				Member_likeboxVO box = new Member_likeboxVO();

				box.setMb_idx(rs.getInt("mb_idx"));
				box.setCp_idx(rs.getInt("cp_idx"));
				box.setLike_cp_name(rs.getString("like_cp_name"));
				box.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				box.setCp_branch(rs.getString("cp_branch"));
				box.setCp_sector(rs.getString("cp_sector"));
				box.setCf_image(rs.getString("cf_directory_image"));
				// 현재 투자율 계산
				box.setCp_like_percent(rs.getString("percent"));

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
			String sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_branch, cp.cp_intro_content, concat(cp_f.cf_directory,cp_f.cf_image2) as banner_image FROM company as cp, company_file as cp_f ORDER BY RAND() LIMIT 3";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);

			while (rs.next()) {
				Main_SlideVO slide = new Main_SlideVO();
				slide.setSl_cp_content(rs.getString("cp_intro_content"));
				slide.setSl_cp_name(rs.getString("cp_name"));
				slide.setSl_cp_branch(rs.getString("cp_branch"));
				slide.setSl_cp_idx(rs.getInt("cp_idx"));
				slide.setBanner_image(rs.getString("banner_image"));
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
				String sql = "SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount, cp_iv.iv_appl_stop_date_time, concat(cp_f.cf_directory,cp_f.cf_image1) as thumbnail_image "
						+ "FROM company as cp, company_invest as cp_iv, company_file as cp_f "
						+ "WHERE cp.cp_idx = cp_iv.cp_idx "
						+ "ORDER BY cp_iv_count DESC, cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100 DESC LIMIT 4";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Main_LikeVO like = new Main_LikeVO();
					like.setLk_cp_branch(rs.getString("cp_branch"));
					like.setLk_cp_current_amount(rs.getString("iv_current_amount"));
					like.setLk_cp_goal_amount(rs.getString("iv_goal_amount"));
					like.setLk_cp_name(rs.getString("cp_name"));
					like.setLk_cp_percent(rs.getString("percent"));
					like.setLk_cp_profit(rs.getString("cp_monthly_profit"));
					like.setLk_cp_sector(rs.getString("cp_sector"));
					like.setLk_cp_idx(rs.getInt("cp_idx"));
					like.setLk_appl_stop_date_time(rs.getDate("iv_appl_stop_date_time"));
					like.setThumbnail_image(rs.getString("thumbnail_image"));
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
		
		// 메인페이지에 지역별로  기업 count
		public Main_CityVO Main_CityInfo() throws Exception {
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Main_CityVO cityVO = new Main_CityVO();

			try {
				// 쿼리
				String sql = "SELECT BusanCity.busan, SeoulCity.seoul, GyeonggiCity.gyeonggi, IncheonCity.incheon, GangwonCity.gangwon, DaeguCity.daegu, UlsanCity.ulsan, GyeongsangCity.gyeongsang, JejuCity.jeju, DaejeonCity.daejeon+ChungcheongCity.chungcheong as daejeonNchungcheong, GwangjuCity.gwangju+JeonlaCity.jeonla as gwangjuNjeonla "
						+ "FROM"
						+ "(SELECT count(*) busan FROM company WHERE left(`cp_add_ch`, 2) = \"부산\") BusanCity, "
						+ "(SELECT count(*) seoul FROM company WHERE left(`cp_add_ch`, 2) = \"서울\") SeoulCity, "
						+ "(SELECT count(*) gyeonggi FROM company WHERE left(`cp_add_ch`, 2) = \"경기\") GyeonggiCity, "
						+ "(SELECT count(*) incheon FROM company WHERE left(`cp_add_ch`, 2) = \"인천\") IncheonCity, "
						+ "(SELECT count(*) gangwon FROM company WHERE left(`cp_add_ch`, 2) = \"강원\") GangwonCity, "
						+ "(SELECT count(*) daegu FROM company WHERE left(`cp_add_ch`, 2) = \"대구\") DaeguCity, "
						+ "(SELECT count(*) ulsan FROM company WHERE left(`cp_add_ch`, 2) = \"울산\") UlsanCity, "
						+ "(SELECT count(*) gyeongsang FROM company WHERE left(`cp_add_ch`, 2) = \"경상\") GyeongsangCity, "
						+ "(SELECT count(*) jeju FROM company WHERE left(`cp_add_ch`, 2) = \"제주\") JejuCity, "
						+ "(SELECT count(*) daejeon FROM company WHERE left(`cp_add_ch`, 2) = \"대전\") DaejeonCity, "
						+ "(SELECT count(*) chungcheong FROM company WHERE left(`cp_add_ch`, 2) = \"충청\") ChungcheongCity, "
						+ "(SELECT count(*) gwangju FROM company WHERE left(`cp_add_ch`, 2) = \"광주\") GwangjuCity, "
						+ "(SELECT count(*) jeonla FROM company WHERE left(`cp_add_ch`, 2) = \"전라\") JeonlaCity";

				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println(pstmt);

				if (rs.next()) {
					cityVO.setSeoul(rs.getString("seoul"));
					cityVO.setBusan(rs.getString("busan"));
					cityVO.setGyeonggi(rs.getString("gyeonggi"));
					cityVO.setIncheon(rs.getString("incheon"));
					cityVO.setGangwon(rs.getString("gangwon"));
					cityVO.setDaejeonNchungcheong(rs.getString("daejeonNchungcheong"));
					cityVO.setDaegu(rs.getString("daegu"));
					cityVO.setUlsan(rs.getString("ulsan"));
					cityVO.setGyeongsang(rs.getString("gyeongsang"));
					cityVO.setGwangjuNjeonla(rs.getString("gwangjuNjeonla"));
					cityVO.setJeju(rs.getString("jeju"));
				}

				return cityVO;
			} catch (Exception ex) {
				System.out.println("Main_CityInfo ERROR: " + ex);
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
		
		// 태훈 - 기업 투자 현황 페에지 제어 // 신규수정
		public int Member_Invest_check(int mb_idx) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = -1;

			try {
				String sql = "SELECT mi_idx FROM member_invest WHERE mb_idx = ? ORDER BY mi_reg_date_time DESC";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mb_idx);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					result = rs.getInt("mi_idx");
				}
			} catch (Exception ex) {
				System.out.println("Member_Invest_check 에러: " + ex);
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
	
		
		// 태훈 추가 - 실시간 즐겨찾기 순서 AJAX 및 수동 자동 제어
		public int getSelectKey() {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int select_key = 0;
	
			try {
				String sql = "SELECT cp_select_key FROM realtime_select_key";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
	
				if (rs.next()) {
					if (rs.getInt("cp_select_key") == 1) {
						select_key = 1; 
					} else if (rs.getInt("cp_select_key") == 2){
						select_key = 2;
					}
				} else {
					select_key = 0;
				}
			} catch (Exception ex) {
				System.out.println("getSelectKey 에러: " + ex);
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				/*
				 * if (conn != null) conn.close();
				 */
				} catch (Exception e) {
					System.out.println("연결 해제 실패: " + e.getMessage());
				}
			}
	
			return select_key;
		}
		
		// 탑10 SQL
		@SuppressWarnings({ "unchecked", "unused" })
		public JSONArray getRealList(int select_key) throws Exception {
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			JSONArray jsonArr = new JSONArray();
			
			try {
				// 쪼인해도되고안해도되고
				String sql = "SELECT cp_name, cp_idx "
						+ "FROM company "
						+ "ORDER BY cp_recommand_count DESC limit 10";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					JSONObject jsonObj = new JSONObject();
					jsonObj.put("cp_name", rs.getString("cp_name"));
					jsonObj.put("cp_idx", rs.getString("cp_idx"));
					
					jsonArr.add(jsonObj);
				}
				System.out.println(">>>json"+jsonArr);
				return jsonArr;
				
			} catch (Exception ex) {
				System.out.println("getRealList ERROR: " + ex);
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
		
		// 태훈 추가 - 자산관리 토큰 입금
		public int Token_Deposit(String token_sum, String token_wallet, String token_hash, String session_idx, String bar) throws Exception{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;

			try {
				String sql = "INSERT INTO token_deposit(mb_idx, td_to_address, td_from_address, td_tx_hash, td_amount, td_status, td_date_time)"
						+ "VALUES(?, ?, ?, ?, ?, 0, now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, session_idx);
				pstmt.setString(2, token_wallet);
				pstmt.setString(3, bar);
				pstmt.setString(4, token_hash);
				pstmt.setString(5, token_sum);
				result = pstmt.executeUpdate();

				if (result != 0) {
					result = 1;
					return result;
				}else {
					result = 0;
				}
			} catch (Exception ex) {
				System.out.println("Token_Deposit 에러: " + ex);
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
		
		
		// 태훈 추가 - 자산관리 토큰 출금
		public int Token_Withdraw(String token_sum, String token_wallet, String session_idx, String bar) throws Exception{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int result = 0;
				
			try {
				String sql = "INSERT INTO token_withdraw(mb_idx, td_to_address, td_from_address, td_amount, td_status, td_date_time) "
						+ "VALUES(?, ?, ?, ?, 0, now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, session_idx);
				pstmt.setString(2, bar);
				pstmt.setString(3, token_wallet);
				pstmt.setString(4, token_sum);
				result = pstmt.executeUpdate();
				
				if (result != 0) {
					result = 1;
					return result;
				}else {
					result = 0;
				}
			} catch (Exception ex) {
				System.out.println("Token_Withdraw 에러: " + ex);
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
		
		// 태훈 추가 - 자산관리 포인트 충전
		public int Point_Deposit(String point_sum, String session_idx) throws Exception{
			ResultSet rs = null;
			int result = 0;
			CallableStatement cstmt = null;
			String re_point = point_sum.replaceAll(",", "");
			try {
				cstmt = (CallableStatement)conn.prepareCall("call POINT_CHARGE(?,?,?)");
				cstmt.setString(1, session_idx);
				cstmt.setString(2, re_point);
				cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
				
				cstmt.execute();
				result = cstmt.getInt("@RESULT");

				if (result != 0) {
					result = 1;
					return result;
				}else {
					result = 0;
				}
			} catch (Exception ex) {
				System.out.println("Token_Deposit 에러: " + ex);
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

			return result;
		}
		
		// 태훈 추가 - 자산관리 포인트 환전
		public int Point_Withdraw(String point_sum, String session_idx) throws Exception{
			CallableStatement cstmt = null;
			ResultSet rs = null;
			int result = 0;
			String new_point = point_sum.replaceAll(",", "");
					
			try {
				cstmt = conn.prepareCall("{call POINT_EXCHANGE(?,?,?)}");
				cstmt.setString(1, session_idx);
				cstmt.setString(2, new_point);
				cstmt.registerOutParameter(3, java.sql.Types.INTEGER);
				
				cstmt.execute();
				result = cstmt.getInt("@RESULT");
				
				if (result == 1) {
					result = 1;	// 환전신청 성공
					return result;
				}else {	// result가 -1 or 0이면
					result = 0;
				}
			} catch (Exception ex) {
				System.out.println("Point_Withdraw 에러: " + ex);
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

			return result;
		}
		
		
		public List<InvestDeleteVO> InvestDeleteInfo(int cp_idx, int mb_idx, int mi_idx) throws Exception {

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<InvestDeleteVO> DeleteList = new ArrayList<InvestDeleteVO>();

			try {
				String sql = "SELECT mi_name, mi_point, mi_idx "
						+ "FROM member_invest "
						+ "WHERE cp_idx = ? AND mi_idx = ? AND mi_idx = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cp_idx);
				pstmt.setInt(2, mb_idx);
				pstmt.setInt(3, mi_idx);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					InvestDeleteVO DeleteVO = new InvestDeleteVO();
					DeleteVO.setCp_name(rs.getString("mi_name"));
					DeleteVO.setMi_point(rs.getString("mi_point"));
					DeleteVO.setMi_idx(rs.getInt("mi_idx"));
					DeleteList.add(DeleteVO);
				}
				return DeleteList;
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
			return null;
		}
	////////////////////////////// 태훈추가 end//////////////////////////////

	// 윤식 추가/////////////////////////////////////////////////
	public MemberInvestPageVO getMyPageInvestment(int cp_idx, int mb_idx) {
		
		String sql = "select mb_iv.mi_idx, mb.mb_idx,mb_iv.mi_point, mb_iv.cp_idx, mb_iv.mi_hoiling_stock, mb_iv.mi_stock_value, mb_iv.mi_monthly_profit, mb_iv.mi_cumulative_profit, mb_iv.mi_hoiling_stock, mb_iv.mi_monthly_profit, mb_iv.mi_cumulative_profit, cp.cp_number,cp.cp_name,cp.cp_manager ,cp.cp_name, cp.cp_add_ch, cp_capital, cp_f.cf_certificate, cp_f.cf_estate_contract, cp_f.cf_registration, cp_f.cf_financial from member mb, member_invest mb_iv, company cp,company_file cp_f where cp.cp_idx = mb_iv.cp_idx AND mb.mb_idx = mb_iv.mb_idx AND cp_f.cp_idx = mb_iv.cp_idx AND mb.mb_idx = ? AND mb_iv.cp_idx = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_idx);
			pstmt.setInt(2, cp_idx);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				MemberInvestPageVO memberInvestVO = new MemberInvestPageVO();
				memberInvestVO.setMi_idx(rs.getInt("mi_idx"));
				memberInvestVO.setMb_idx(rs.getInt("mb_idx"));
				//memberInvestVO.setMi_name(rs.getString("mi_name"));
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
			System.out.println("getMyPageInvestment 에러: " + ex);
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
	public ArrayList<MemberInvestCompanyVO> getInvestmentCompanyList(int mb_idx) {
		String sql = "select cp.cp_idx,cp.cp_name, cp.cp_funding_status,mi.mi_idx from member_invest mi, company cp where mi.cp_idx = cp.cp_idx AND mi.mb_idx = ? ORDER BY mi_reg_date_time DESC;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_idx);
			rs = pstmt.executeQuery();
			ArrayList<MemberInvestCompanyVO> memberInvestCompanyVOList = new ArrayList<MemberInvestCompanyVO>();
			while (rs.next()) {
				MemberInvestCompanyVO memberInvestCompanyVO = new MemberInvestCompanyVO();
				memberInvestCompanyVO.setMi_idx(rs.getInt("mi_idx"));
				memberInvestCompanyVO.setCp_idx(rs.getInt("cp_idx"));
				memberInvestCompanyVO.setCp_name(rs.getString("cp_name"));
				memberInvestCompanyVO.setCp_funding_status(rs.getString("cp_funding_status"));
				
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
	
	public boolean insertMemberLoginLog(MemberIplog memberIplog) {
		String sql = "INSERT INTO member_iplog(ip, id, date, content) VALUES (?,?,now(),?)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberIplog.getIp());
			pstmt.setString(2, memberIplog.getId());
			pstmt.setString(3, memberIplog.getContent());
			result = pstmt.executeUpdate();
			

			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("MemberLoginLog 에러: " + ex);
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
	//////////////김윤식 추가 마이페이지 3 거래내역 가져오기 ///////////////////
	public ArrayList<MemberTransactionVO> getTranscationList(String mb_idx, int startRow, int pageSize) {
		String sql = "SELECT td_to_address, td_from_address, td_amount, td_status, td_date_time FROM token_deposit WHERE mb_idx = ? UNION " 
					 +"SELECT td_to_address, td_from_address, td_amount, td_status, td_date_time FROM token_withdraw WHERE mb_idx = ? ORDER BY td_date_time DESC limit " + startRow +","+ pageSize; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("mb idx : " + mb_idx);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			pstmt.setString(2, mb_idx);
			rs = pstmt.executeQuery();
			
			ArrayList<MemberTransactionVO> membertransactionList = new ArrayList<MemberTransactionVO>();	
			
			while (rs.next()) {
				
				MemberTransactionVO membertransaction = new MemberTransactionVO();
			
				membertransaction.setTd_to_address(rs.getString("td_to_address"));
				membertransaction.setTd_from_address(rs.getString("td_from_address"));
				membertransaction.setTd_amount(rs.getString("td_amount"));
				membertransaction.setTd_status(rs.getString("td_status"));
				membertransaction.setTd_date_time(rs.getString("td_date_time"));
				membertransactionList.add(membertransaction);
								
			}
			
			return membertransactionList;					

		} catch (Exception ex) {
			System.out.println("getTranscationList 에러: " + ex);	
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
	////////// 입출금 내역 count ///////////
	public int getTranscationListCount(String mb_idx) {
		
	String sql = "SELECT td_to_address, td_from_address, td_amount, td_status, td_date_time FROM token_deposit WHERE mb_idx = ? UNION " 
			 +"SELECT td_to_address, td_from_address, td_amount, td_status, td_date_time FROM token_withdraw WHERE mb_idx = ? ORDER BY td_date_time DESC"; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count = 0;
	
	System.out.println("mb idx : " + mb_idx);

		try {
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			pstmt.setString(2, mb_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("getTranscationListCount 에러: " + ex);
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
	
	//////////////김윤식 추가 포인트 거래내역 가져오기 ///////////////////
	public ArrayList<MypagePointTransactionVO> getPointTranscationList(String mb_idx, int startRow, int pageSize) {
		String sql = "SELECT A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B WHERE A.tk_idx = B.tk_idx AND A.mb_idx = ? AND A.po_category = 2 UNION SELECT A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B WHERE A.tk_idx = B.tk_idx AND A.mb_idx = ? AND A.po_category = 3 ORDER BY po_date_time limit " + startRow + "," + pageSize; 
					
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("mb idx : " + mb_idx);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			pstmt.setString(2, mb_idx);
			rs = pstmt.executeQuery();
			
			ArrayList<MypagePointTransactionVO> pointtransactionList = new ArrayList<MypagePointTransactionVO>();	
			
			while (rs.next()) {
				
				MypagePointTransactionVO pointtransaction = new MypagePointTransactionVO();
			
				pointtransaction.setPo_category(rs.getString("po_category"));
				pointtransaction.setPo_amount(rs.getString("po_amount"));
				pointtransaction.setPo_date_time(rs.getString("po_date_time"));
				pointtransaction.setTk_amount(rs.getString("tk_amount"));
				pointtransactionList.add(pointtransaction);
								
			}
			
			return pointtransactionList;					

		} catch (Exception ex) {
			System.out.println("getTranscationList 에러: " + ex);	
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
		
	//////////포인트 내역 count ///////////
	public int getPointTranscationCount(String mb_idx) {
		
		String sql = "SELECT A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B WHERE A.tk_idx = B.tk_idx AND A.mb_idx = ? AND A.po_category = 2 UNION SELECT A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B WHERE A.tk_idx = B.tk_idx AND A.mb_idx = ? AND A.po_category = 3 ORDER BY po_date_time"; 
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int count = 0;
	
	System.out.println("mb idx : " + mb_idx);
	
		try {
		//	if (category.equals("0")) {
		//		sql = "select * from faq ";
		//		pstmt = conn.prepareStatement(sql);
		//		rs = pstmt.executeQuery();
		//	} else {
		//		pstmt = conn.prepareStatement(sql);
		//		pstmt.setString(1, category);
		//		rs = pstmt.executeQuery();
		//	}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			pstmt.setString(2, mb_idx);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			rs.last();
	
			count = rs.getRow();
	
			rs.beforeFirst();
	
			return count;
	
		} catch (Exception ex) {
			System.out.println("getTranscationListCount 에러: " + ex);
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
	
		//////////////김윤식 추가 당월, 누적 수익 가져오기 ///////////////////
		public benefitVO benefit(String mb_idx) {
		String sql = "SELECT SUM(mi_monthly_profit) AS month, SUM(mi_cumulative_profit) AS total FROM `member_invest` WHERE mb_idx = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("mb idx : " + mb_idx);
				
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_idx);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				benefitVO benefitArr = new benefitVO();
				benefitArr.setMonth_benefit(rs.getString("month"));
				benefitArr.setTotal_benefit(rs.getString("total"));								
				return benefitArr;							
			}
			
							
		} catch (Exception ex) {
			System.out.println("benefit 에러: " + ex);	
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
		
	//String sql = "INSERT INTO point_transaction(po_category,cp_idx, tk_idx, tk_price, po_amount, po_content, po_date_time) VALUES (2,1,1,100,?,?,now())";
	//String sql = "INSERT INTO token_transaction(tk_category, po_idx, tk_amount, tk_price, po_amount, tk_content, tk_date_time) VALUES (3,1,?,10,?,'비고',now())";
	//String sql = "UPDATE member SET mb_point = mb_point + ?, mb_token = mb_token - ? WHERE mb_idx = ?";
	// 박신규 끝~ ///////////////////////////////////////////////////
}
