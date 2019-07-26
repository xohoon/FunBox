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
		String real_path = companyDAO.getUploadFilePath("company_path") + "/" + "sssssss";
		try {
			System.out.println(real_path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

