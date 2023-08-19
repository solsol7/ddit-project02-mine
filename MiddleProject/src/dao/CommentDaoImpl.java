package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import service.CommentServiceImpl;
import util.MybatisUtil;
import vo.CommentVO;


public class CommentDaoImpl implements ICommentDao{

	private static CommentDaoImpl dao;
	private CommentDaoImpl() {}
	
	public static CommentDaoImpl getInstance() {
		if(dao==null) dao=new CommentDaoImpl();
		return dao;
	}
	
	@Override
	public List<CommentVO> getCommentList(String nt_no) {
		List<CommentVO> list = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("comment.getCommentList",nt_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public int insertComment(CommentVO vo) {

		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("comment.insertComment",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public String getUserName(String users_no) {
		String userName = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			userName = session.selectOne("comment.getUserName",users_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return userName;
	}

	@Override
	public int deleteComment(String cm_no) {

		int cnt=0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("comment.deleteComment",cm_no);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}
}
