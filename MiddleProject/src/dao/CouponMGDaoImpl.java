package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.CouponVO;
import vo.TourismVO;


public class CouponMGDaoImpl implements ICouponMGDao{

	private static CouponMGDaoImpl dao;
	
	private CouponMGDaoImpl() {}
	
	public static CouponMGDaoImpl getInstance() {
		if(dao==null) dao=new CouponMGDaoImpl();
		return dao;
	}
	
	
	@Override
	public List<CouponVO> getCouponList() {
		SqlSession session = null;
		List<CouponVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("couponMG.getCouponList");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public CouponVO getCoupon(String cp_no) {
		CouponVO vo = new CouponVO();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("couponMG.getCoupon",cp_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return vo;
	}

	@Override
	public int insertCoupon(CouponVO vo) {

		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("couponMG.insertCoupon",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteCoupon(String cp_no) {

		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("couponMG.deleteCoupon",cp_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int getListCount(Map<String, String> map) {
		SqlSession session = null;
		int cnt=0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("couponMG.getListCount",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<CouponVO> selectByPage(Map<String, String> map) {
		SqlSession session = null;
		List<CouponVO> list = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("couponMG.selectByPage",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public CouponVO selectById(String cpNo) {
		CouponVO vo = new CouponVO();
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("couponMG.selectById",cpNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return vo;
	}

}
