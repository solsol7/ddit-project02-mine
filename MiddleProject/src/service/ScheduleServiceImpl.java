package service;

import java.util.List;
import java.util.Map;

import dao.IScheduleDao;
import dao.ScheduleDaoImpl;
import vo.ScheduleDetailVO;
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
   public List<ScheduleVO> getAllList(String usersNo) {
      return dao.getAllList(usersNo);
   }

   @Override
   public int insertSchedule(ScheduleVO vo) {
      return dao.insertSchedule(vo);
   }

   @Override
   public String getScNo() {
      return dao.getScNo();
   }

   @Override
   public List<ScheduleDetailVO> getScheduleDetail(String sc_no) {
      return dao.getScheduleDetail(sc_no);
   }

   @Override
   public int getMaxDay(String sc_no) {
      return dao.getMaxDay(sc_no);
   }

   @Override
   public String getTrName(String trNo) {
      return dao.getTrName(trNo);
   }
   

}
