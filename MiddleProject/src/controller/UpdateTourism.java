package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ITourismService;
import service.TourismServiceImpl;
import vo.TourismVO;

@MultipartConfig
@WebServlet("/updateTourism.do")
public class UpdateTourism extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String trNo = request.getParameter("trNo");
		
		ITourismService service = TourismServiceImpl.getInstance();
		
		TourismVO vo = service.selectById(trNo);
		
		request.setAttribute("tourismDetail", vo);
		
		request.getRequestDispatcher("/admin/jsp/updateTourism.jsp").forward(request, response);
		
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
		
		System.out.println("trCon=========>"+vo.getTr_con());
		
		ITourismService service = TourismServiceImpl.getInstance();
		int cnt = service.updateTourism(vo);
		
		response.sendRedirect(request.getContextPath()+"/admin/jsp/tourismMG.jsp");

	}

}
