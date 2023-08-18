package service;

import java.util.List;
import java.util.Map;

import vo.CommunityVO;

public interface ICommunityMGService {
public List<CommunityVO> getCommunityList();
	
	public CommunityVO getCommunity(String cmt_no);

	
	public int deleteCommunity(String cmt_no);
	
	public int getListCount(Map<String, String> map);
	
	public List<CommunityVO> selectByPage(Map<String, String> map);
	
	public CommunityVO selectById(String cmt_no);
}
