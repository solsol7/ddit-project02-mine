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
import vo.CommunityVO;
import vo.CouponVO;


@WebServlet("/communityDetailMG.do")
public class CommunityDetailMG extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cmtNo = request.getParameter("cmtNo");
		
		ICommunityMGService service = CommunityMGServiceImpl.getInstance();
		CommunityVO vo=service.selectById(cmtNo);

		request.setAttribute("communityDetail", vo);
		
		
		request.getRequestDispatcher("/admin/jsp/communityDetailMG.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
