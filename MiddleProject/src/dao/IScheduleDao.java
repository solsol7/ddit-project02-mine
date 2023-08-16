package dao;

import java.util.List;

import vo.ScheduleVO;

public interface IScheduleDao {
	
	public List<ScheduleVO> getAllList();
	
	public int insertSchedule(ScheduleVO vo);
	
	public String getScNo();

}
