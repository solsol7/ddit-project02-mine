package dao;

import java.util.List;
import java.util.Map;

import vo.ScheduleDetailVO;
import vo.ScheduleVO;

public interface IScheduleDao {
   
   public List<ScheduleVO> getAllList(String usersNo);
   
   public int insertSchedule(ScheduleVO vo);
   
   public String getScNo();
   
   public List<ScheduleDetailVO> getScheduleDetail(String sc_no);
   
   public int getMaxDay(String sc_no);
   
   public String getTrName(String trNo);

}