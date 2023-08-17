package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IInsertScheduleService;
import service.InsertScheduleServiceImpl;
import vo.ScheduleDetailVO;


@WebServlet("/insertSchedule.do")
public class InsertSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String scNo = request.getParameter("scNo");
		String[] scDtTour = request.getParameterValues("scDtTour");
		
		IInsertScheduleService service = InsertScheduleServiceImpl.getInstance();
		
		String num = "1";
		int order = 1;
		for(int i=0; i<scDtTour.length; i++) {
			
			ScheduleDetailVO vo = new ScheduleDetailVO();
			
			vo.setSc_no(scNo);
			
			String no = (scDtTour[i].split("-"))[0];
			
			if(!no.equals(num)) {
				num=no;
				order=1;
			}
			
			vo.setSc_dt_no(vo.getSc_no()+"_"+no);
			
			vo.setSc_dt_order(order++);
			vo.setSc_dt_tour(scDtTour[i].split("-")[1]);
			
			service.insertScheduleDetail(vo);
		}
		
		response.sendRedirect(request.getContextPath()+"/Mproject/jsp/schedule.jsp");
		
		
	}

}
