package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.TourismVO;

public class TourismDaoImpl implements ITourismDao{

	private static TourismDaoImpl dao;
	private TourismDaoImpl() {}
	
	public static TourismDaoImpl getInstance() {
		if(dao==null) dao=new TourismDaoImpl();
		return dao;
	}
	
	@Override
	public List<TourismVO> getAllList(String sword) {
		
		SqlSession session = null;
		List<TourismVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("tourism.getAllList",sword);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int getListCount(Map<String, String> map) {
		SqlSession session = null;
		int cnt=0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("tourism.getListCount",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}
	
	

	@Override
	public List<TourismVO> selectByPage(Map<String, String> map) {
		SqlSession session = null;
		List<TourismVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("tourism.selectByPage",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public TourismVO selectById(String trNo) {
		TourismVO vo = new TourismVO();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("tourism.selectById",trNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return vo;
	}

	@Override
	public int insertTourism(TourismVO vo) {
		
		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("tourism.insertTourism",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteTourism(String trNo) {

		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("tourism.deleteTourism",trNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateTourism(TourismVO vo) {
		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("tourism.updateTourism",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateHit(String trNo) {
		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("tourism.updateHit",trNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateGood(String trNo) {
		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("tourism.updateGood",trNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateBad(String trNo) {
		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("tourism.updateBad",trNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int getTRListCount(Map<String, String> map) {
		SqlSession session = null;
		int cnt=0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("tourism.getTRListCount",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

}
