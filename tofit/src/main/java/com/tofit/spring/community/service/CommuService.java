package com.tofit.spring.community.service;

import java.util.List;
import java.util.Map;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.vo.CommuVO;

public interface CommuService {
	//글목록 보기
	public Map listCommu(Map<String, Integer> pagingMap) throws Exception;
	
	//글 상세 보기
	public CommuVO viewArticle(int commuNo) throws Exception;
	
	//글 추가하기
	public void addCommu(CommuVO commuVO) throws Exception;
	
	public void modArticle(CommuVO commuVO) throws Exception;
	public void removeArticle(int commuNo) throws Exception;
	public List getCommentList(int commuNo) throws Exception;
	public void addView(int commuNo) throws Exception;
}
