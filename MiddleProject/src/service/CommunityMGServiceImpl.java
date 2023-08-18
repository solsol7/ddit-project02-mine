package service;

import java.util.List;
import java.util.Map;

import dao.CommunityMGDaoImpl;
import dao.CouponMGDaoImpl;
import dao.ICommunityMGDao;
import dao.ICouponMGDao;
import vo.CommunityVO;

public class CommunityMGServiceImpl implements ICommunityMGService{
	private static CommunityMGServiceImpl service;
	
	private CommunityMGServiceImpl() {}
	
	public static CommunityMGServiceImpl getInstance() {
		if(service==null) service=new CommunityMGServiceImpl();
		return service;
	}
	
	ICommunityMGDao dao = CommunityMGDaoImpl.getInstance();
	
	@Override
	public List<CommunityVO> getCommunityList() {
		return dao.getCommunityList();
	}

	@Override
	public CommunityVO getCommunity(String cmt_no) {
		return dao.getCommunity(cmt_no);
	}

	@Override
	public int deleteCommunity(String cmt_no) {
		return dao.deleteCommunity(cmt_no);
	}

	@Override
	public int getListCount(Map<String, String> map) {
		return dao.getListCount(map);
	}

	@Override
	public List<CommunityVO> selectByPage(Map<String, String> map) {
		return dao.selectByPage(map);
	}

	@Override
	public CommunityVO selectById(String cmt_no) {
		return dao.selectById(cmt_no);
	}

}
