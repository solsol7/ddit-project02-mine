package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import service.CommunityMGServiceImpl;
import util.MybatisUtil;
import vo.CommunityVO;
import vo.CouponVO;

public class CommunityMGDaoImpl implements ICommunityMGDao{
	
	private static CommunityMGDaoImpl dao;
	
	private CommunityMGDaoImpl() {}
	
	public static CommunityMGDaoImpl getInstance() {
		if(dao==null) dao=new CommunityMGDaoImpl();
		return dao;
	}
		

	@Override
	public List<CommunityVO> getCommunityList() {
		SqlSession session = null;
		List<CommunityVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("communityMG.getCommunityList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public CommunityVO getCommunity(String cmt_no) {
		CommunityVO vo = new CommunityVO();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("communityMG.getCommunity",cmt_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return vo;
	}

	@Override
	public int deleteCommunity(String cmt_no) {

		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("communityMG.deleteCommunity",cmt_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int getListCount(Map<String, String> map) {
		SqlSession session = null;
		int cnt=0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("communityMG.getListCount",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<CommunityVO> selectByPage(Map<String, String> map) {
		SqlSession session = null;
		List<CommunityVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("communityMG.selectByPage",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public CommunityVO selectById(String cmt_no) {
		CommunityVO vo = new CommunityVO();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("communityMG.selectById",cmt_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return vo;
	}

}
