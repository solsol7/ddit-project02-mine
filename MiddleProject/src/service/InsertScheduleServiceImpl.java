package service;

import java.util.List;
import java.util.Map;

import dao.IInsertScheduleDao;
import dao.InsertScheduleDaoImpl;
import vo.ScheduleDetailVO;
import vo.TourismVO;

public class InsertScheduleServiceImpl implements IInsertScheduleService{

	private static IInsertScheduleService service;
	private InsertScheduleServiceImpl() {}
	
	public static IInsertScheduleService getInstance() {
		if(service==null) service=new InsertScheduleServiceImpl();
		return service;
	}
	
	IInsertScheduleDao dao = InsertScheduleDaoImpl.getInstance();
	
	@Override
	public List<TourismVO> searchTourList(Map<String, String> map) {
		return dao.searchTourList(map);
	}

	@Override
	public int insertScheduleDetail(ScheduleDetailVO vo) {
		return dao.insertScheduleDetail(vo);
	}

	@Override
	public TourismVO tourismInfo(String trNo) {
		return dao.tourismInfo(trNo);
	}

}
