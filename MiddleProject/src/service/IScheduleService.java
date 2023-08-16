package service;

import java.util.List;

import vo.ScheduleVO;

public interface IScheduleService {
	
	public List<ScheduleVO> getAllList();
	
	public int insertSchedule(ScheduleVO vo);

	public String getScNo();
}
