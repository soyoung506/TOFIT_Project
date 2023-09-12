package com.tofit.spring.community.service;

import java.util.List;
import java.util.Map;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.vo.CommuVO;

public interface CommuService {
	//�۸�� ����
	public Map listCommu(Map<String, Integer> pagingMap) throws Exception;
	
	//�� �� ����
	public CommuVO viewArticle(int commuNo) throws Exception;
	
	//�� �߰��ϱ�
	public void addCommu(CommuVO commuVO) throws Exception;
	
	public void modArticle(CommuVO commuVO) throws Exception;
	public void removeArticle(int commuNo) throws Exception;
	public List getCommentList(int commuNo) throws Exception;
	public void addView(int commuNo) throws Exception;
}
