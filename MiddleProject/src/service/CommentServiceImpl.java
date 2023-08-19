package service;

import java.util.List;

import dao.CommentDaoImpl;
import dao.ICommentDao;
import dao.ITourismDao;
import dao.TourismDaoImpl;
import vo.CommentVO;

public class CommentServiceImpl implements ICommentService{


	private static CommentServiceImpl service;
	private CommentServiceImpl() {}
	
	public static CommentServiceImpl getInstance() {
		if(service==null) service=new CommentServiceImpl();
		return service;
	}
	
	ICommentDao dao = CommentDaoImpl.getInstance();
	
	
	@Override
	public List<CommentVO> getCommentList(String nt_no) {
		return dao.getCommentList(nt_no);
	}

	@Override
	public int insertComment(CommentVO vo) {
		return dao.insertComment(vo);
	}

	@Override
	public String getUserName(String users_no) {
		return dao.getUserName(users_no);
	}

	@Override
	public int deleteComment(String cm_no) {
		return dao.deleteComment(cm_no);
	}

}
