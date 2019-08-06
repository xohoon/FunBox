package test;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import net.board.dao.BoardDAO;
import net.board.dto.Board_Search_ListVO;

public class Main {

	public static void main(String[] args) throws Exception {
		
		UUID uid = UUID.randomUUID();
		String str= uid.toString();
		System.out.println(UUID.randomUUID().toString().substring(0,9));
		String a = "greger.txt;";
		System.out.println(a.substring(0,a.length()-1));
	}
	
	public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String category)
			throws Exception {

		UUID uid = UUID.randomUUID();

		String newFileName = uid + "_" + fileName;
		
		return newFileName;
	}

}

