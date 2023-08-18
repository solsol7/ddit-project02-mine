package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.IInsertScheduleService;
import service.ITourismService;
import service.InsertScheduleServiceImpl;
import service.TourismServiceImpl;
import vo.TourismVO;



@WebServlet("/scheduleTourismInfo.do")
public class ScheduleTourismInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String trNo = request.getParameter("trNo");
		
		IInsertScheduleService service = InsertScheduleServiceImpl.getInstance();
		
		TourismVO vo = service.tourismInfo(trNo);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(vo);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
