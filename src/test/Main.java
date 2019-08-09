package test;

import net.company.dao.CompanyDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		System.out.println(companyDAO.invest(35, 1, 10,"2"));
		
	}
	
	

}

