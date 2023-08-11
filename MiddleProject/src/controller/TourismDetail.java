package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.ITourismService;
import service.TourismServiceImpl;
import vo.TourismVO;


@WebServlet("/tourismDetail.do")
public class TourismDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String trNo = request.getParameter("trNo");
		
		ITourismService service = TourismServiceImpl.getInstance();
		TourismVO vo=service.selectById(trNo);
		service.updateHit(trNo);
		
		vo.setTr_hit(String.valueOf((Integer.parseInt(vo.getTr_hit())+1)));
		
		request.setAttribute("tourDetail", vo);
		
		
		request.getRequestDispatcher("/Mproject/jsp/tourismdetail.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
