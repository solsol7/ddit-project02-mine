package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityMGServiceImpl;
import service.CouponMGServiceImpl;
import service.ICommunityMGService;
import service.ICouponMGService;


@WebServlet("/deleteCommunity.do")
public class DeleteCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cmtNo = request.getParameter("cmtNo");
		
		ICommunityMGService service = CommunityMGServiceImpl.getInstance();
		
		service.deleteCommunity(cmtNo);
		
		response.sendRedirect(request.getContextPath()+"/admin/jsp/communityMG.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
