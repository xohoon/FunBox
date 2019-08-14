package test;

import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;

public class Main {

	public static void main(String[] args) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		
		System.out.println(companyDAO.getUploadDirectory());
	
	}
	
	

}

