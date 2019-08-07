package net.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.MypagePointTransactionVO;

/////// 김윤식 //////// 추가
public class PointTransAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		String mb_id = (String)session.getAttribute("id");
		String mb_idx = (String)session.getAttribute("idx");
		ArrayList<MypagePointTransactionVO> transaction = new ArrayList<MypagePointTransactionVO>();
		
		int pageSize = 10;
		int pageGroupSize = 5; // 페이지 단위 [◀] 1 2 3 4 5 [▶]
		String pageNum = request.getParameter("pageNum");// 페이지 번호 / 1
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		System.out.println("currentPage : "+currentPage);
		
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호 / 1
		System.out.println("startRow : "+startRow);
		
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호 / 10
		System.out.println("endRow : "+endRow);
		
		int count = 0;
		int number = 0;
		
		MemberDAO member_dao0 = new MemberDAO();
		count = member_dao0.getPointTranscationCount(mb_idx);
		
		System.out.println("해당 DB 글 개수 불러오기" + count);
		System.out.println("id"+mb_id);
		System.out.println("idx"+mb_idx);
		
		if (mb_id == null || mb_idx == null) {
			//로그인 안된 사용자 접근 처리
			System.out.println("로그인 안됨");
		}
		
		if(count>0) {
			if (endRow > count) {
				endRow = count;
			}
			MemberDAO member_dao = new MemberDAO();
			transaction = member_dao.getPointTranscationList(mb_idx, startRow - 1, pageSize);			
			System.out.println("pointtransaction : " + transaction.toString());
			
		}else {
			MemberDAO member_dao = new MemberDAO();
			transaction = member_dao.getPointTranscationList(mb_idx, startRow - 1, pageSize);
			System.out.println("pointtransaction : " + transaction.toString());
			
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
		
		request.setAttribute("transaction", transaction);	
		
		forward.setRedirect(false);
		forward.setPath("./member/mypage2_2.jsp");
		
		return forward;
	}

}
