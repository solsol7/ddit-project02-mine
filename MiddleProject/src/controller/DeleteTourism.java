package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ITourismService;
import service.TourismServiceImpl;
import vo.TourismVO;


@WebServlet("/deleteTourism.do")
public class DeleteTourism extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String trNo = request.getParameter("trNo");
		
		ITourismService service = TourismServiceImpl.getInstance();
		
		service.deleteTourism(trNo);
		
		response.sendRedirect(request.getContextPath()+"/admin/jsp/tourismMG.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
