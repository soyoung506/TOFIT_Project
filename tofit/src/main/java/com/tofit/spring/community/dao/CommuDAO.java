package com.tofit.spring.community.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.vo.CommuVO;

public interface CommuDAO {

	public List selectAllArticles(Map<String, Integer> pagingMap) throws DataAccessException;
	public int getTotalArticle()  throws DataAccessException;
	public void insertNewCommu(CommuVO commuVO) throws DataAccessException;
	//글 상세 보기
	public CommuVO selectArticle(int commuNo) throws DataAccessException;
	public void updateArticle(CommuVO commuVO) throws DataAccessException;
	public void deleteArticle(int commuNo) throws DataAccessException;
	public void addView(int commuNo) throws DataAccessException;
	public List getCommentList(int commuNo) throws DataAccessException;
}
