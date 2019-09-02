package test;

import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * CompanyDAO companyDAO = new CompanyDAO(); CompnayApplicationFilePath
		 * companyApplicationFilePath = new CompnayApplicationFilePath();
		 * System.out.println(companyDAO.getUploadFilePath(companyApplicationFilePath,
		 * "fdsfdssd/"));
		 * System.out.println(companyApplicationFilePath.getApp_cp_file_path());
		 */
		String path = "C:\\upload\\folder"; //폴더 경로
		File Folder = new File(path);

		// 해당 디렉토리가 없을경우 디렉토리를 생성합니다.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //폴더 생성합니다.
			    System.out.println("폴더가 생성되었습니다.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("이미 폴더가 생성되어 있습니다.");
		}
	}
	
	

}

