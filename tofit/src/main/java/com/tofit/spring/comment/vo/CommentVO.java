package com.tofit.spring.comment.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("commentVO")
public class CommentVO {
	private int commentNo;
	private String commentID;
	private Date commentDate;
	private String commentContent;
	private int commuNo;
	
	public CommentVO() {
		System.out.println("CommentVo »ý¼º");
	}

	public String getCommentID() {
		return commentID;
	}

	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getCommuNo() {
		return commuNo;
	}

	public void setCommuNo(int commuNo) {
		this.commuNo = commuNo;
	}

	
	
}
