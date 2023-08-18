package dao;

import java.util.List;
import java.util.Map;

import vo.TourismVO;

public interface ITourismDao {
	public List<TourismVO> getAllList(String sword);
	
	public int getListCount(Map<String, String> map);
	
	public int getTRListCount(Map<String, String> map);
	
	public List<TourismVO> selectByPage(Map<String, String> map);
	
	public TourismVO selectById(String trNo);
	
	public int insertTourism(TourismVO vo);
	
	public int deleteTourism(String trNo);
	
	public int updateTourism(TourismVO vo);
	
	public int updateHit(String trNo);
	
	public int updateGood(String trNo);

	public int updateBad(String trNo);
	
}
