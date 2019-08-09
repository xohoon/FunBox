package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.member.dao.MemberDAO;
import net.member.dto.MemberInvestVO;
import net.member.dto.MemberTransactionVO;
import net.member.dto.MypagePointTransactionVO;

/////// 김윤식 //////// 추가
public class MypageTransAction implements Action {
	String categroyFlag = "";
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		System.out.println("MypageTransAction OK!");
		
		String mb_id = (String)session.getAttribute("id");
		String mb_idx = (String)session.getAttribute("idx");
		String pageNum = request.getParameter("pageNum");// 페이지 번호 / 1
		String category = request.getParameter("category");// 페이지 번호 / 1		
		int pageSize = 10;
		int pageGroupSize = 5; // 페이지 단위 [◀] 1 2 3 4 5 [▶]
		
		
		//로그인 안된 사용자 접근 처리
		if (mb_id == null || mb_idx == null) {
			System.out.println("로그인 안됨");
		}else {
			System.out.println("id : "+mb_id);
			System.out.println("idx : "+mb_idx);
		}
				
		// 페이지 번호 에외처리
		if (pageNum == null) {
			pageNum = "1";
		}
		
		// 카테고리 null 값일때 예외 처리
		try {
			if(category.equals(null) || category == null) {
				category = "1";
				System.out.println("들어오낭?");
			}
		}catch(NullPointerException e) {
			//System.out.println("NullPointerException :" + e);
			category = "1";			
		}
		
		System.out.println("category :" + category);
		
		int currentPage = Integer.parseInt(pageNum);
		System.out.println("currentPage : "+currentPage);
		
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호 / 1
		System.out.println("startRow : "+startRow);
		
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호 / 10
		System.out.println("endRow : "+endRow);
		
		int count = 0;
		int number = 0;
		categroyFlag = category;
		
		// 카테고리별 쿼리문 실행
		if(category.equals("1")) { // 입출금 내역
			System.out.println("MypageTransAction category 1 : OK!");
			
			ArrayList<MemberTransactionVO> transaction = new ArrayList<MemberTransactionVO>();
			MemberDAO member_dao0 = new MemberDAO();
			count = member_dao0.getTranscationListCount(mb_idx);
			System.out.println("해당 DB 글 개수 불러오기" + count);
			
			if(count>0) {
				if (endRow > count) {
					endRow = count;
				}
				MemberDAO member_dao = new MemberDAO();
				transaction = member_dao.getTranscationList(mb_idx, startRow - 1, pageSize);			
				System.out.println("transaction : " + transaction.toString());
				
			}else {
				MemberDAO member_dao = new MemberDAO();
				transaction = member_dao.getTranscationList(mb_idx, startRow - 1, pageSize);
				System.out.println("transaction : " + transaction.toString());
				
			}
			number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
			//페이지그룹의 갯수
			//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
			int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
			//페이지 그룹 번호
			//ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1 이고 '[2][3][4]'의 페이지그룹번호는 2
			//이다.
			int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);
			
			request.setAttribute("currentPage", new Integer(currentPage));
			System.out.println(currentPage); // 
			
			request.setAttribute("startRow", new Integer(startRow));
			System.out.println(startRow); //
			
			request.setAttribute("endRow", new Integer(endRow));
			System.out.println(endRow); //
			
			request.setAttribute("count", new Integer(count));
			System.out.println(count); //
			
			request.setAttribute("pageSize", new Integer(pageSize));
			System.out.println(pageSize); //

			request.setAttribute("number", new Integer(number));
			System.out.println(number); // 
			
			request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
			System.out.println(pageGroupSize); //
			
			request.setAttribute("numPageGroup", new Integer(numPageGroup));
			System.out.println(numPageGroup); // 
			
			request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
			System.out.println(pageGroupCount); // 
			
			request.setAttribute("category", category);
			request.setAttribute("categroyFlag", categroyFlag);
			request.setAttribute("transaction", transaction);		

					
		}else if(category.equals("2")){
			System.out.println("MypageTransAction category 2 : OK!");
			
			ArrayList<MypagePointTransactionVO> transactionP = new ArrayList<MypagePointTransactionVO>();
			MemberDAO member_dao0 = new MemberDAO();
			count = member_dao0.getPointTranscationCount(mb_idx);
			System.out.println("해당 DB 글 개수 불러오기" + count);
			
			if(count>0) {
				if (endRow > count) {
					endRow = count;
				}
				MemberDAO member_dao = new MemberDAO();
				transactionP = member_dao.getPointTranscationList(mb_idx, startRow - 1, pageSize);			
				System.out.println("pointtransaction : " + transactionP.toString());
				
			}else {
				MemberDAO member_dao = new MemberDAO();
				transactionP = member_dao.getPointTranscationList(mb_idx, startRow - 1, pageSize);
				System.out.println("pointtransaction : " + transactionP.toString());
			}
				
				number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
				//페이지그룹의 갯수
				//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
				int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
				//페이지 그룹 번호
				//ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1 이고 '[2][3][4]'의 페이지그룹번호는 2
				//이다.
				int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);
				
				request.setAttribute("currentPage", new Integer(currentPage));
				System.out.println(currentPage); // 
				
				request.setAttribute("startRow", new Integer(startRow));
				System.out.println(startRow); //
				
				request.setAttribute("endRow", new Integer(endRow));
				System.out.println(endRow); //
				
				request.setAttribute("count", new Integer(count));
				System.out.println(count); //
				
				request.setAttribute("pageSize", new Integer(pageSize));
				System.out.println(pageSize); //

				request.setAttribute("number", new Integer(number));
				System.out.println(number); // 
				
				request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
				System.out.println(pageGroupSize); //
				
				request.setAttribute("numPageGroup", new Integer(numPageGroup));
				System.out.println(numPageGroup); // 
				
				request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
				System.out.println(pageGroupCount); // 
				
				request.setAttribute("category", category);
				request.setAttribute("categroyFlag", categroyFlag);
				request.setAttribute("transactionP", transactionP);	
				
			
		}else if(category.equals("3")){
			System.out.println("MypageTransAction category 3 : OK!");
			
			ArrayList<MemberInvestVO> member_invest_list = null;
			CompanyDAO company_dao = new CompanyDAO();
			count = company_dao.getInvestmentCount(mb_id);// 전체 글의 수 불러오기
			
			if(count>0) {
				if (endRow > count) {
					endRow = count;
				member_invest_list = company_dao.getInvestment(mb_id, startRow - 1, endRow);// 현재 페이지에 해당하는 글 목록불러오기
				}
			}else {
				member_invest_list = company_dao.getInvestment(mb_id, startRow - 1, endRow);
			}

			number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
			// 페이지그룹의 갯수
			// ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.
			int pageGroupCount = count / (pageSize * pageGroupSize) + (count % (pageSize * pageGroupSize) == 0 ? 0 : 1);
			// 페이지 그룹 번호
			// ex) pageGroupSize가 3일 경우 '[1][2][3]'의 페이지그룹번호는 1 이고 '[2][3][4]'의 페이지그룹번호는 2
			// 이다.
			int numPageGroup = (int) Math.ceil((double) currentPage / pageGroupSize);
			
			
			request.setAttribute("currentPage", new Integer(currentPage));
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize));

			request.setAttribute("number", new Integer(number));
			request.setAttribute("pageGroupSize", new Integer(pageGroupSize));
			request.setAttribute("numPageGroup", new Integer(numPageGroup));
			request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
				
			request.setAttribute("category", category);
			request.setAttribute("categroyFlag", categroyFlag);
			request.setAttribute("member_invest_list", member_invest_list);
		}
		
		forward.setRedirect(false);
		forward.setPath("./member/mypage3.jsp");
		return forward;		
	}

}
