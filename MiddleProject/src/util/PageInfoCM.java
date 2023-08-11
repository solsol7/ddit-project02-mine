package util;

import java.util.HashMap;
import java.util.Map;

import dao.ITourismDao;
import dao.TourismDaoImpl;
import vo.PageVO;

public class PageInfoCM {
	public static PageVO pageInfo(int currentPage, String sword) {
		
		
		ITourismDao dao = TourismDaoImpl.getInstance();
		Map<String, String> map = new HashMap<String, String>();
		map.put("sword", sword);
		
		int totalList = dao.getListCount(map);	// select한 결과값의 총 레코드 수
		int perList = 10;							// 한 페이지에 몇 개의 리스트 출력할 것인지 정의하는 변수
		PageVO pvo = new PageVO(totalList, perList);

		pvo.setBlockSize(5);						// 이전/다음 사이에 몇 페이지를 출력할 것인지 정의하는 변수
		
		pvo.setCurrentBlock((int)(Math.ceil(currentPage*1.0/pvo.getBlockSize())));
		
		pvo.setStartPage((pvo.getCurrentBlock()-1)*pvo.getBlockSize()+1);
		pvo.setEndPage(pvo.getStartPage()+pvo.getBlockSize()-1);
		if(pvo.getEndPage()>pvo.getTotalPage()) pvo.setEndPage(pvo.getTotalPage());
		
		pvo.setStartIndex((currentPage-1)*pvo.getPerList()+1);
		pvo.setEndIndex(pvo.getStartIndex()+pvo.getPerList()-1);
		if(pvo.getEndIndex()>pvo.getTotalList()) pvo.setEndIndex(pvo.getTotalList());
		
		return pvo;
	}
}
