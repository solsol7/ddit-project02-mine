package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentServiceImpl;
import service.ICommentService;
import service.ITourismService;
import service.TourismServiceImpl;
import vo.CommentVO;
import vo.TourismVO;


@WebServlet("/insertComment.do")
public class InsertComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String trNo = request.getParameter("ntNo");
		ITourismService trService = TourismServiceImpl.getInstance();
		TourismVO trVo = trService.selectById(trNo);
		
		CommentVO vo = new CommentVO();
		
		vo.setCm_con(request.getParameter("content"));
		vo.setNt_no(request.getParameter("ntNo"));
		
		
		String userNo = request.getParameter("userNo");
		if(userNo.equals("MG_23_001")) {
			vo.setMg_no(userNo);
		}else {
			vo.setUsers_no(userNo);
		}

		ICommentService service = CommentServiceImpl.getInstance();
		String userName =service.getUserName(userNo);
		vo.setUsers_name(userName);
		

		service.insertComment(vo);
		
		request.setAttribute("tourDetail", trVo);
		
		request.getRequestDispatcher("/Mproject/jsp/tourismdetail.jsp").forward(request, response);
		
		
	}

}
