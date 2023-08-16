package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insertSchedule.do")
public class InsertSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String scNo = request.getParameter("scNo");
		String dayInfo = request.getParameter("dayInfo");
		
		String[] scheduleList = request.getParameterValues("scheduleList");
		
		for(int i=0; i<scheduleList.length; i++) {
			
		}
		
	}

}
