package test;

import java.util.ArrayList;
import java.util.UUID;

import net.member.dao.MemberDAO;
import net.member.dto.MemberInvestCompanyVO;
import net.member.dto.MemberInvestPageVO;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayList<MemberInvestCompanyVO> arrayList;
		MemberDAO memberDAO = new MemberDAO();
		arrayList = memberDAO.getInvestmentCompanyList("funbox");
		System.out.println(arrayList.get(0).getCp_name());
		System.out.println(arrayList.get(1).getCp_name());
	}
	
	public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String category)
			throws Exception {

		UUID uid = UUID.randomUUID();

		String newFileName = uid + "_" + fileName;
		
		return newFileName;
	}

}

