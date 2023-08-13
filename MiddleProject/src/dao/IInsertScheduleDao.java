package dao;

import java.util.List;
import java.util.Map;

import vo.TourismVO;

public interface IInsertScheduleDao {
	public List<TourismVO> searchTourList(Map<String, String> map);
}
