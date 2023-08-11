package controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import service.ITourismService;
import service.TourismServiceImpl;
import vo.TourismVO;

@MultipartConfig
@WebServlet("/insertTourism.do")
public class InsertTourism extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/admin/jsp/insertTourism.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		TourismVO vo = new TourismVO();
		
		vo.setTr_no(request.getParameter("trNo"));
		vo.setTr_name(request.getParameter("trName"));
		vo.setTr_addr(request.getParameter("trAddr"));
		vo.setTr_tel(request.getParameter("trTel"));
		vo.setTr_lat(request.getParameter("trLat"));
		vo.setTr_long(request.getParameter("trLong"));
		vo.setOrigin_file_name(request.getParameter("tr_origin_file_name"));
		vo.setTr_con(request.getParameter("trCon"));

		
		// 파일 upload 시작
		
		String uploadPath = "d:/d_other/MProjectFiles";
		
		File file = new File(uploadPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		String fileName = "";
		for(Part part : request.getParts()) {
			
			fileName = extractFileName(part);
			
			if(!"".equals(fileName)) {
				vo.setOrigin_file_name(fileName);
				String saveFileName = UUID.randomUUID().toString();
				vo.setSave_file_name(saveFileName);
				
				try {
					part.write(uploadPath + File.separator + saveFileName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		// 파일 upload 끝
		
		ITourismService service = TourismServiceImpl.getInstance();
		int cnt = service.insertTourism(vo);
		
		response.sendRedirect(request.getContextPath()+"/admin/jsp/tourismMG.jsp");
	}
	
	//Part구조 안에서 파일명을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = "";
		
		String conDisposition = part.getHeader("content-disposition");
		String[] items = conDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		return fileName;
	}

}


