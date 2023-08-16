package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.ScheduleVO;

public class ScheduleDaoImpl implements IScheduleDao{
	
	private static IScheduleDao dao;
	
	private ScheduleDaoImpl() {}
	
	public static IScheduleDao getInstance() {
		if(dao==null) dao = new ScheduleDaoImpl();
		return dao;
	}

	@Override
	public List<ScheduleVO> getAllList() {
		
		SqlSession session = null;
		List<ScheduleVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("schedule.getAllList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}

	@Override
	public int insertSchedule(ScheduleVO vo) {
		
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("schedule.insertSchedule", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public String getScNo() {

		SqlSession session = null;
		String scNo = "";
		
		try {
			session = MybatisUtil.getSqlSession();
			scNo = session.selectOne("schedule.getScNo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return scNo;
	}

}
