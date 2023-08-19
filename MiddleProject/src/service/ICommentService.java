package service;

import java.util.List;

import vo.CommentVO;

public interface ICommentService {
	public List<CommentVO> getCommentList(String nt_no);
	
	public int insertComment(CommentVO vo);
	
	public String getUserName(String users_no);
	
	public int deleteComment(String cm_no);
}
