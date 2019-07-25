package test;

import java.util.ArrayList;

import net.company.dao.CompanyDAO;
import net.company.dto.CompanyListVO;
import net.page.dto.MainPageDateOfOpenVO;
import net.page.dto.MainPageDeadLineVO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDAO companyDAO = new CompanyDAO();
		ArrayList<MainPageDateOfOpenVO> mainPageDateOfOpenVOs = companyDAO.getCompanyDateOfOpen();
		ArrayList<MainPageDeadLineVO> mainPageDeadLineVOs = companyDAO.getCompanyDeadLine();
		try {
			System.out.println(mainPageDeadLineVOs.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

