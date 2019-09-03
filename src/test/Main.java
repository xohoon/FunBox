package test;

import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;

public class Main {

	public static void main(String[] args) throws Exception {
		
		CompanyDAO companyDAO = new CompanyDAO();
		
		CompanyBean companyBean = companyDAO.getCompanyInfo2(2);
		
		System.out.println(companyBean.getCf_store_images());
		
	}

}
