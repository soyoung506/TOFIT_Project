package com.tofit.spring.comment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tofit.spring.comment.dao.CommentDAO;
import com.tofit.spring.comment.vo.CommentVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public void insertComment(CommentVO commentVO) throws Exception {
		commentDAO.insertComment(commentVO);
	}
	
	@Override
	public void updateComment(CommentVO commentVO) throws Exception  {
		commentDAO.updateComment(commentVO);
	}
	
	@Override
	public void deleteComment(int commentNo) throws Exception {
		commentDAO.deleteComment(commentNo);
	}
	
	@Override
	public void removeChildComment(int commuNo) throws Exception{
		commentDAO.removeChildComment(commuNo);
	}

	@Override
	public String getCommentId(int commentNo) throws Exception {
		String commentId=commentDAO.getCommentId(commentNo);
		return commentId;
	}
}
