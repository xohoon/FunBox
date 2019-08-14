package net.filedownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.company.dao.CompanyDAO;

public class CompanyFileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CompanyFileDownload() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ① 파일명 가져오기
		String fileName = request.getParameter("filename");
		//int cp_idx = Integer.parseInt(request.getParameter("cp_idx"));
		CompanyDAO compnayDao = new CompanyDAO();
		
		// ② 경로 가져오기
		String saveDir = compnayDao.getUploadDirectory();
		
		//local 경로
		//String saveDir = "C:/Users/user/Desktop/download_test";
		
		
		File file = new File(saveDir + fileName);
		// ③ MIMETYPE 설정하기
		String mimeType = getServletContext().getMimeType(file.toString());
		if (mimeType == null) {
			response.setContentType("application/octet-stream");
		}

		// ④ 다운로드용 파일명을 설정
		String downName = null;
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) {
			downName = new String(fileName.getBytes("UTF-8"), "8859_1");
		} else {
			downName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}

		// ⑤ 무조건 다운로드하도록 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + downName + "\";");

		// ⑥ 요청된 파일을 읽어서 클라이언트쪽으로 저장한다.
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			ServletOutputStream servletOutputStream = response.getOutputStream();

			byte b[] = new byte[1024];
			int data = 0;

			while ((data = (fileInputStream.read(b, 0, b.length))) != -1) {
				servletOutputStream.write(b, 0, data);
			}

			servletOutputStream.flush();
			servletOutputStream.close();
			fileInputStream.close();
		}catch(Exception e  ) {
			System.out.println(e+"잘못된 파일 다운로드 접근");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
