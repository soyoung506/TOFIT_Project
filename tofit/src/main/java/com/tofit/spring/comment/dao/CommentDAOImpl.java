package com.tofit.spring.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.vo.CommuVO;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertComment(CommentVO commentVO) throws DataAccessException {
		int commuNo=commentVO.getCommuNo();
		int commentNo=getCommentNo();
		commentVO.setCommentNo(commentNo);
		sqlSession.insert("mapper.comment.insertComment", commentVO);
	}
	
	private int getCommentNo() throws DataAccessException {
		int commentNo=0;
		commentNo=sqlSession.selectOne("mapper.comment.getCommentNo");
		commentNo+=1;
		return commentNo;
	}
	
	@Override
	public void updateComment(CommentVO commentVO) throws DataAccessException {
		sqlSession.update("mapper.comment.updateComment", commentVO);
	}
	
	@Override
	public void deleteComment(int commentNo) throws DataAccessException {
		sqlSession.delete("mapper.comment.deleteComment", commentNo);
	}
	@Override
	public void removeChildComment(int commuNo) throws Exception{
		sqlSession.delete("mapper.comment.removeChildComment", commuNo);
	}

	@Override
	public String getCommentId(int commentNo) throws Exception {
		String commentId=sqlSession.selectOne("mapper.comment.getCommentId", commentNo);
		return commentId;
	}
	
}