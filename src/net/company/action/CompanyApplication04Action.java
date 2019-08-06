package net.company.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.ApplicationVO;

// 박신규 - CompanyFileUploadAction
// 유정 수정 - 변수 추가 및 수정, alert 추가 
public class CompanyApplication04Action implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); // 한글처리
		boolean result = false;
		HttpSession session = request.getSession();

		System.out.println("CompanyApplication04Action");

		// page1 파라미터값
		String idx = (String) session.getAttribute("idx");
		String app_cp_name = request.getParameter("name");
		String app_cp_manager = request.getParameter("manager");
		String app_cp_hp = request.getParameter("phone");
		String app_cp_num = request.getParameter("num");
		String app_cp_ch = request.getParameter("ch");
		String app_cp_more = request.getParameter("more");
		String app_cp_extra = request.getParameter("extra");
		String app_cp_sector = request.getParameter("sector");
		String app_cp_open_date_time = request.getParameter("open_datetime");
		String app_cp_prestige = request.getParameter("prestige");
		String app_cp_deposit = request.getParameter("deposit");
		String app_cp_monthly = request.getParameter("monthly");
		int app_cp_status = Integer.parseInt(request.getParameter("status"));

		// page2 파라미터값
		String app_cp_goal_amount = request.getParameter("goal_amount");
		String app_cp_avg_monthly_profit = request.getParameter("avg_monthly_profit");
		String app_cp_monthly_profit = request.getParameter("monthly_profit");
		String app_cp_during = request.getParameter("during");
		String app_cp_inv_min_amount = request.getParameter("inv_min_amount");

		// page3 파라미터값
		String app_cp_introduction = request.getParameter("app_cp_introduction");
		String app_cp_purpose = request.getParameter("app_cp_purpose");
		String app_cp_point = request.getParameter("app_cp_point");

		// page4 파라미터값

		// 날짜변환 기능
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String now = format.format(date);

		// 이전 페이지 데이터 받아오기
		// CompanyVO company = (CompanyVO)request.getAttribute("company");
		ApplicationVO company = new ApplicationVO();

		// 폴더이름 변수
		String company_path = app_cp_manager + "_" + app_cp_name + "_" + now;
		// data 접근 객체 생성
		CompanyDAO companyDAO1 = new CompanyDAO();
		// company 기본경로 + 폴더 이름 -> 폴더 경로에 파일삽입위해서
		String real_path = companyDAO1.getUploadFilePath("company_path") + "/" + company_path;

		// 파일디렉토리
		File fileSaveDir = new File(real_path);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		// 받아온 파일들을 담는 ArrayList
		ArrayList<String> app_cp_image_list = new ArrayList<String>();
		ArrayList<String> app_cp_document_list = new ArrayList<String>();
		ArrayList<String> app_cp_alias_image_list = new ArrayList<String>();
		ArrayList<String> app_cp_alias_document_list = new ArrayList<String>();

		// view 에서 들고온 파일들을 VO에 저장하는 단계
		int image_count = 0;
		int document_count = 0;
		for (Part part : request.getParts()) {
			if (part.getContentType() != null) {
				String fileName = extractFileName(part);
				String alias = UUID.randomUUID().toString().substring(0, 9);
				String fileFormat = getFileFormat(part);
				switch (part.getName()) {
				case "app_cp_registrantion":
					company.setApp_cp_registrantion(fileName);
					company.setApp_cp_alias_registrantion(alias + "app_cp_registrantion"+fileFormat);
					//System.out.println(real_path + "/" + alias+"app_cp_registrantion"+fileFormat);
					part.write(real_path + "/" + alias+"app_cp_registrantion"+fileFormat);
					break;
				case "app_cp_financial":
					company.setApp_cp_financial(fileName);
					company.setApp_cp_financial(alias + "app_cp_financial"+fileFormat);
					//System.out.println(real_path + "/" + alias+"app_cp_financial"+fileFormat);
					part.write(real_path + "/" + alias+"app_cp_financial"+fileFormat);
					break;
				case "app_cp_estate_contract":
					company.setApp_cp_estate_contract(fileName);
					company.setApp_cp_alias_estate_contract(alias + "app_cp_estate_contract"+fileFormat);
					//System.out.println(real_path + "/" + alias+"app_cp_estate_contract"+fileFormat);
					part.write(real_path + "/" + alias+"app_cp_estate_contract"+fileFormat);
					break;
				case "app_cp_images":
					image_count++;
					app_cp_image_list.add(fileName);
					app_cp_alias_image_list.add(alias + "app_cp_image"+ image_count+fileFormat);
					//System.out.println(real_path + "/" + alias+"app_cp_image"+image_count+fileFormat);
					part.write(real_path + "/" + alias+"app_cp_image"+image_count+fileFormat);
					break;
				case "app_cp_other_documents":
					document_count++;
					app_cp_document_list.add(fileName);
					app_cp_alias_document_list.add(alias + "app_cp_other_document" + document_count+fileFormat);
					//System.out.println(real_path + "/" + alias+"app_cp_other_document"+document_count+fileFormat);
					part.write(real_path + "/" + alias+"app_cp_other_document"+document_count+fileFormat);
					break;
				default:
					break;
				}
				
				/*if (!fileName.equals("")) {
					// part.write(real_path + "/" + fileName);
					// part.write(real_path + "/" + fileName);
				}*/
			}
		}

		// 빈 파일들에 null 을 넣어준다.
		for (int i = app_cp_image_list.size(); i < 5; i++) {
			app_cp_image_list.add(null);
		}
		for (int i = app_cp_alias_image_list.size(); i < 5; i++) {
			app_cp_alias_image_list.add(null);
		}
		for (int i = app_cp_document_list.size(); i < 5; i++) {
			app_cp_document_list.add(null);
		}
		for (int i = app_cp_alias_document_list.size(); i < 5; i++) {
			app_cp_alias_document_list.add(null);
		}

		// page1 company에 데이터 추가
		company.setApp_cp_name(app_cp_name);
		company.setApp_cp_manager(app_cp_manager);
		company.setApp_cp_hp(app_cp_hp);
		company.setApp_cp_num(app_cp_num);
		company.setApp_cp_ch(app_cp_ch);
		company.setApp_cp_more(app_cp_more);
		company.setApp_cp_extra(app_cp_extra);
		company.setApp_cp_sector(app_cp_sector);
		company.setApp_cp_open_date_time(app_cp_open_date_time);
		company.setApp_cp_prestige(app_cp_prestige);
		company.setApp_cp_deposit(app_cp_deposit);
		company.setApp_cp_monthly(app_cp_monthly);
		company.setApp_cp_status(app_cp_status);
		company.setMb_idx(idx);

		// page2 company에 데이터 추가
		company.setApp_cp_goal_amount(app_cp_goal_amount);
		company.setApp_cp_avg_monthly_profit(app_cp_avg_monthly_profit);
		company.setApp_cp_monthly_profit(app_cp_monthly_profit);
		company.setApp_cp_during(app_cp_during);
		company.setApp_cp_inv_min_amount(app_cp_inv_min_amount);

		// page3 company에 데이터 추가
		company.setApp_cp_introduction(app_cp_introduction);
		company.setApp_cp_purpose(app_cp_purpose);
		company.setApp_cp_point(app_cp_point);

		// page4 company에 데이터 추가
		company.setApp_cp_images(app_cp_image_list);
		company.setApp_cp_alias_images(app_cp_alias_image_list);
		company.setApp_cp_other_documents(app_cp_image_list);
		company.setApp_cp_alias_other_documents(app_cp_alias_document_list);
		company.setApp_cp_real_path(real_path);

		CompanyDAO companyDAO2 = new CompanyDAO();

		result = companyDAO2.insertApp(company);

		// return null;
		if (result == false) {
			System.out.println("기업신청 실패");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('기업신청에 실패했습니다.\n다시 시도해주세요.');");
			out.println("location.href='./Application1.cp';");
			out.println("</script>");
			out.close();

			return null;
		}

		System.out.println("기업신청 성공");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('기업신청이 완료되었습니다.');");
		out.println("location.href='./Index.mb';");
		out.println("</script>");
		out.close();

		return null;
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "NULL";
	}

	private String getFileFormat(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return "." + s.substring(s.lastIndexOf(".") + 1,s.length()-1);
			}
		}
		return "";
	}

}
