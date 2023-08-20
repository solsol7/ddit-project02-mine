package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IScheduleService;
import service.ScheduleServiceImpl;
import vo.PageVO;
import vo.ScheduleVO;


@WebServlet("/scheduleList.do")
public class ScheduleList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		IScheduleService service = ScheduleServiceImpl.getInstance();
		
		String usersNo = request.getParameter("usersNo");
		
		List<ScheduleVO> list = service.getAllList(usersNo);
		
		request.setAttribute("scheduleList", list);
				
		request.getRequestDispatcher("/Mproject/view/scheduleview.jsp").forward(request, response);
		
		
	}



}
