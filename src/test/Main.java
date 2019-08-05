package test;

import java.util.ArrayList;

import net.board.dao.BoardDAO;
import net.board.dto.Board_Search_ListVO;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<Board_Search_ListVO> a = boardDAO.getCompanyListScroll(0);
		System.out.println(a);
		
	}

}

