package test;

import java.util.ArrayList;

import net.company.dao.CompanyDAO;
import net.company.dto.CompanyListVO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDAO companyDAO = new CompanyDAO();
		ArrayList<CompanyListVO> companyListVO = companyDAO.getCompanyList();
		try {
			System.out.println(companyListVO.get(0).isCp_recommand());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
