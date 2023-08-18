package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.ScheduleDetailVO;
import vo.TourismVO;

public class InsertScheduleDaoImpl implements IInsertScheduleDao{

	private static IInsertScheduleDao dao;
	private InsertScheduleDaoImpl() {}
	
	public static IInsertScheduleDao getInstance() {
		if(dao==null) dao=new InsertScheduleDaoImpl();
		return dao;
	}
	
	@Override
	public List<TourismVO> searchTourList(Map<String, String> map) {
		SqlSession session = null;
		List<TourismVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("insertSchedule.searchTourList",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int insertScheduleDetail(ScheduleDetailVO vo) {
		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("insertSchedule.insertScheduleDetail",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public TourismVO tourismInfo(String trNo) {
		SqlSession session = null;
		TourismVO vo = new TourismVO();
		
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("insertSchedule.tourismInfo",trNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return vo;
	}

}
