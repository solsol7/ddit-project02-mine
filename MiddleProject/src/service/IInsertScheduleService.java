package service;

import java.util.List;
import java.util.Map;

import vo.TourismVO;

public interface IInsertScheduleService {
	public List<TourismVO> searchTourList(Map<String, String> map);
}
