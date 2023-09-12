package com.tofit.spring.community.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.vo.CommuVO;

@Repository("commuDAO")
public class CommuDAOImpl implements CommuDAO {

	@Autowired
	private SqlSession sqlSession;
		
	@Override
	public List<CommuVO> selectAllArticles(Map<String, Integer> pagingMap) throws DataAccessException{
		List<CommuVO> commuList=sqlSession.selectList("mapper.community.selectAllArticles", pagingMap);
		return commuList;
	}
	
	//전체 글 수 불러오기
	@Override
	public int getTotalArticle() throws DataAccessException {
		int totalArticles=sqlSession.selectOne("mapper.community.getTotalArticle");
		return totalArticles;
	}
	
	//글 상세 보기
		@Override
		public CommuVO selectArticle(int commuNo) throws DataAccessException {
			CommuVO commuVO=(CommuVO)sqlSession.selectOne("mapper.community.selectArticle", commuNo);
			return commuVO;
		}
		
	//글 추가
	@Override
	public void insertNewCommu(CommuVO commuVO) throws DataAccessException {
		int commuNo=selectNewArticleNo();
		commuVO.setCommuNo(commuNo);
		sqlSession.insert("mapper.community.insertArticle", commuVO);
	}
	
	private int selectNewArticleNo() throws DataAccessException {
		int commuNo=0;
		commuNo=sqlSession.selectOne("mapper.community.selectNewArticleNo");
		commuNo+=1;
		return commuNo;
	}
	
	@Override
	public void updateArticle(CommuVO commuVO) throws DataAccessException {
		sqlSession.update("mapper.community.updateArticle", commuVO);
	}
	
	@Override
	public void deleteArticle(int commuNo) throws DataAccessException {
		sqlSession.delete("mapper.community.deleteArticle",commuNo);
	}

	
	 //조회수
	@Override
	public void addView(int commuNo) throws DataAccessException {
		sqlSession.update("mapper.community.addView" ,commuNo);
	}

	//댓글 보기
	@Override
	public List getCommentList(int commuNo) throws DataAccessException {
		List<CommentVO> commentList=sqlSession.selectList("mapper.comment.getCommentList", commuNo);
		return commentList;
	}

	
	
}
		