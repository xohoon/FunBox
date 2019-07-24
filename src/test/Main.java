package test;

import net.company.dao.CompanyDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDAO companyDAO = new CompanyDAO();
		try {
			System.out.println(companyDAO.getCompanyInfo2(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
