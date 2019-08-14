package test;

import net.company.dao.CompanyDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		
		System.out.println(companyDAO.getUploadDirectory());
	
	}
	
	

}

