package service;

import java.util.List;
import java.util.Map;

import vo.CouponVO;

public interface ICouponMGService {
	public List<CouponVO> getCouponList();
	
	public CouponVO getCoupon(String cp_no);
	
	public int insertCoupon(CouponVO vo);
	
	public int deleteCoupon(String cp_no);
	
	public int getListCount(Map<String, String> map);
	
	public List<CouponVO> selectByPage(Map<String, String> map);
	
	public CouponVO selectById(String cpNo);
}
