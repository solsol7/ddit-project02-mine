package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
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

}
