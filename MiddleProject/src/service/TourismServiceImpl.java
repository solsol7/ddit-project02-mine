package service;

import java.util.List;
import java.util.Map;

import dao.ITourismDao;
import dao.TourismDaoImpl;
import vo.PageVO;
import vo.TourismVO;

public class TourismServiceImpl implements ITourismService{


	private static TourismServiceImpl service;
	private TourismServiceImpl() {}
	
	public static TourismServiceImpl getInstance() {
		if(service==null) service=new TourismServiceImpl();
		return service;
	}
	
	ITourismDao dao = TourismDaoImpl.getInstance();
	
	@Override
	public List<TourismVO> getAllList(String sword) {
		return dao.getAllList(sword);
	}

	@Override
	public int getListCount(Map<String, String> map) {
		return dao.getListCount(map);
	}

	@Override
	public List<TourismVO> selectByPage(Map<String, String> map) {
		return dao.selectByPage(map);
	}

	@Override
	public TourismVO selectById(String trNo) {
		return dao.selectById(trNo);
	}

	@Override
	public int insertTourism(TourismVO vo) {
		return dao.insertTourism(vo);
	}

	@Override
	public int deleteTourism(String trNo) {
		return dao.deleteTourism(trNo);
	}

	@Override
	public int updateTourism(TourismVO vo) {
		return dao.updateTourism(vo);
	}

	@Override
	public int updateHit(String trNo) {
		return dao.updateHit(trNo);
	}

	@Override
	public int updateGood(String trNo) {
		return dao.updateGood(trNo);
	}

	@Override
	public int updateBad(String trNo) {
		return dao.updateBad(trNo);
	}

	@Override
	public int getTRListCount(Map<String, String> map) {
		return dao.getTRListCount(map);
	}



}