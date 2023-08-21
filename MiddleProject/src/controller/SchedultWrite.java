package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IScheduleService;
import service.ScheduleServiceImpl;
import vo.ScheduleVO;


@WebServlet("/schedultWrite.do")
public class SchedultWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		// SCHEDULE 테이블에 insert
		ScheduleVO vo = new ScheduleVO();
		
		vo.setSc_title(request.getParameter("scName"));
		vo.setSc_sdate(request.getParameter("sDate"));
		vo.setSc_edate(request.getParameter("eDate"));	
		vo.setUsers_no(request.getParameter("usersNo"));
		
		IScheduleService service = ScheduleServiceImpl.getInstance();
		
		String scNo = service.getScNo();
		
		vo.setSc_no(scNo);
		
		System.out.println(vo.toString());
		
		int res = service.insertSchedule(vo);

		request.setAttribute("scheduleVO", vo);		

		request.getRequestDispatcher("/Mproject/jsp/insertSchedule.jsp").forward(request, response);

		
		//-----------------------------------------------------------------------------------------------------	
		
		
	}

}
