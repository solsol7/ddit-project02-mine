package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ITourismService;
import service.TourismServiceImpl;


@WebServlet("/tourismGood.do")
public class TourismGood extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String trNo = request.getParameter("trNo");
		String trGb = request.getParameter("gb");
		
		ITourismService service = TourismServiceImpl.getInstance();
		
		if(trGb.equals("good_ico")) {
			service.updateGood(trNo);
		}else if(trGb.equals("bad_ico")) {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
