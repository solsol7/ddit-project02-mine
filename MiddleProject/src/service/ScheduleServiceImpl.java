package service;

import java.util.List;

import dao.IScheduleDao;
import dao.ScheduleDaoImpl;
import vo.ScheduleVO;

public class ScheduleServiceImpl implements IScheduleService{
	
	private IScheduleDao dao;
	
	private ScheduleServiceImpl() {
		dao = ScheduleDaoImpl.getInstance();
	}
	
	private static IScheduleService service;
	
	public static IScheduleService getInstance() {
		if(service==null) service = new ScheduleServiceImpl();
		return service;
	}

	@Override
	public List<ScheduleVO> getAllList() {
		return dao.getAllList();
	}

	@Override
	public int insertSchedule(ScheduleVO vo) {
		return dao.insertSchedule(vo);
	}

	@Override
	public String getScNo() {
		return dao.getScNo();
	}

}
