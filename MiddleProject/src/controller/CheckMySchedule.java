package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IScheduleService;
import service.ScheduleServiceImpl;
import vo.ScheduleDetailVO;


@WebServlet("/checkMySchedule.do")
public class CheckMySchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String scNo = request.getParameter("scNo");
		
		IScheduleService service = ScheduleServiceImpl.getInstance();
		
		int maxDay = service.getMaxDay(scNo);
		
		List<ScheduleDetailVO> vo = service.getScheduleDetail(scNo);	
		
		List<List<String>> allList = new ArrayList<List<String>>();
		List<String> list = new ArrayList<String>();
		
		List<List<String>> allNoList = new ArrayList<List<String>>();
		List<String> noList = new ArrayList<String>();
		
		for(int i=0; i<vo.size(); i++) {
			int no = vo.get(i).getSc_dt_order();
			if(no==1 && i!=0) {
				allList.add(list);
				allNoList.add(noList);
				
				list = new ArrayList<String>();
				noList = new ArrayList<String>();
			}
			list.add(service.getTrName(vo.get(i).getSc_dt_tour()));
			noList.add(vo.get(i).getSc_dt_tour());
			
		}
		allList.add(list);
		allNoList.add(noList);
		
		
		request.setAttribute("scNo", vo);
		
		request.setAttribute("maxDay", maxDay);
		
		request.setAttribute("trNameList", allList);
		
		request.setAttribute("trNoList", allNoList);
		
		request.getRequestDispatcher("/Mproject/jsp/checkMySchedule.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
