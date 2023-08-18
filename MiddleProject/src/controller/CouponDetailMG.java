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
import vo.CouponVO;
import vo.TourismVO;


@WebServlet("/couponDetailMG.do")
public class CouponDetailMG extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cpNo = request.getParameter("cpNo");
		
		ICouponMGService service = CouponMGServiceImpl.getInstance();
		CouponVO vo=service.selectById(cpNo);

		request.setAttribute("couponDetail", vo);
		
		
		request.getRequestDispatcher("/admin/jsp/couponDetailMG.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
