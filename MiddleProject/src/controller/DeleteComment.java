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
import vo.TourismVO;


@WebServlet("/deleteComment.do")
public class DeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String cmNo = request.getParameter("cmNo");
		String trNo = request.getParameter("ntNo");
		
		ITourismService trService = TourismServiceImpl.getInstance();
		TourismVO trVo = trService.selectById(trNo);
		
		ICommentService service = CommentServiceImpl.getInstance();
		
		service.deleteComment(cmNo);
		
		request.setAttribute("tourDetail", trVo);
		
		request.getRequestDispatcher("/Mproject/jsp/tourismdetail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
