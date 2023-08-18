package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CouponMGServiceImpl;
import service.ICouponMGService;
import service.ITourismService;
import service.TourismServiceImpl;


@WebServlet("/deleteCoupon.do")
public class DeleteCoupon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cpNo = request.getParameter("cpNo");
		
		ICouponMGService service = CouponMGServiceImpl.getInstance();
		
		service.deleteCoupon(cpNo);
		
		response.sendRedirect(request.getContextPath()+"/admin/jsp/couponMG.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
