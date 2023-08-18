package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommunityMGServiceImpl;
import service.CouponMGServiceImpl;
import service.ICommunityMGService;
import service.ICouponMGService;
import util.PageInfoCMT;
import util.PageInfoCP;
import vo.CommunityVO;
import vo.CouponVO;
import vo.PageVO;


@WebServlet("/communityMG.do")
public class CommunityMG extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sword = request.getParameter("sword");
		String cpage = request.getParameter("cpage");
		
		int currentPage = 1;
		if(cpage!=null) {
			currentPage = Integer.parseInt(cpage);
		}
		
		PageVO pvo = PageInfoCMT.pageInfo(currentPage, sword);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("startIndex", String.valueOf(pvo.getStartIndex()));
		map.put("endIndex", String.valueOf(pvo.getEndIndex()));
		map.put("sword", sword);
		
		ICommunityMGService service = CommunityMGServiceImpl.getInstance();
		
		List<CommunityVO> list = service.selectByPage(map);
		
		request.setAttribute("couponList", list);
		request.setAttribute("sp", pvo.getStartPage());
		request.setAttribute("ep", pvo.getEndPage());
		request.setAttribute("tp", pvo.getTotalPage());
		request.setAttribute("size", pvo.getBlockSize());
		
		request.getRequestDispatcher("/Mproject/view/communityMGview.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
