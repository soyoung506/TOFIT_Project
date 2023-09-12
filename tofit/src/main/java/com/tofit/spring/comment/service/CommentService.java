package com.tofit.spring.comment.service;

import com.tofit.spring.comment.vo.CommentVO;

public interface CommentService {

	public void insertComment(CommentVO commentVO) throws Exception;
	public void updateComment(CommentVO commentVO) throws Exception;
	public void deleteComment(int commentNo) throws Exception;
	public void removeChildComment(int commuNo) throws Exception;
	public String getCommentId(int commentNo) throws Exception;
}
