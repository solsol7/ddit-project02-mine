package service;

import java.util.List;
import java.util.Map;

import dao.CouponMGDaoImpl;
import dao.ICouponMGDao;
import vo.CouponVO;

public class CouponMGServiceImpl implements ICouponMGService{

	private static CouponMGServiceImpl service;
	
	private CouponMGServiceImpl() {}
	
	public static CouponMGServiceImpl getInstance() {
		if(service==null) service=new CouponMGServiceImpl();
		return service;
	}
	
	ICouponMGDao dao = CouponMGDaoImpl.getInstance();

	@Override
	public List<CouponVO> getCouponList() {
		return dao.getCouponList();
	}

	@Override
	public CouponVO getCoupon(String cp_no) {
		return dao.getCoupon(cp_no);
	}

	@Override
	public int insertCoupon(CouponVO vo) {
		return dao.insertCoupon(vo);
	}

	@Override
	public int deleteCoupon(String cp_no) {
		return dao.deleteCoupon(cp_no);
	}

	@Override
	public int getListCount(Map<String, String> map) {
		return dao.getListCount(map);
	}

	@Override
	public List<CouponVO> selectByPage(Map<String, String> map) {
		return dao.selectByPage(map);
	}

	@Override
	public CouponVO selectById(String cpNo) {
		return dao.selectById(cpNo);
	}
	
}
