package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.ScheduleDetailVO;
import vo.ScheduleVO;

public class ScheduleDaoImpl implements IScheduleDao{
   
   private static IScheduleDao dao;
   
   private ScheduleDaoImpl() {}
   
   public static IScheduleDao getInstance() {
      if(dao==null) dao = new ScheduleDaoImpl();
      return dao;
   }

   @Override
   public List<ScheduleVO> getAllList(String usersNo) {
      
      SqlSession session = null;
      List<ScheduleVO> list = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         list = session.selectList("schedule.getAllList", usersNo);
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

   @Override
   public List<ScheduleDetailVO> getScheduleDetail(String sc_no) {
      
      SqlSession session = null;
      List<ScheduleDetailVO> list = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         list = session.selectList("schedule.getScheduleDetail", sc_no);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      
      return list;
   }

   @Override
   public int getMaxDay(String sc_no) {
      
      SqlSession session = null;
      int cnt = 0;
      
      try {
         session = MybatisUtil.getSqlSession();
         cnt = session.selectOne("schedule.getMaxDay", sc_no);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      
      return cnt;
   }

   @Override
   public String getTrName(String trNo) {
      
      SqlSession session = null;
      String trName = null;
      
      try {
         session = MybatisUtil.getSqlSession();
         trName = session.selectOne("schedule.getTrName", trNo);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(session!=null) session.close();
      }
      
      return trName;
   }

}

