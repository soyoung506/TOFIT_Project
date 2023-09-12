package com.tofit.spring.community.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.comment.vo.CommentVO;
import com.tofit.spring.community.dao.CommuDAO;
import com.tofit.spring.community.vo.CommuVO;

@Service("commuService")
public class CommuServiceImpl implements CommuService {
	@Autowired
	private CommuDAO commuDAO;
	
	@Override
	public Map listCommu(Map<String, Integer> pagingMap) throws DataAccessException{
		Map articleMap = new HashMap();
		List<CommuVO> commuList = commuDAO.selectAllArticles(pagingMap);
		int totalArticles=commuDAO.getTotalArticle();
		articleMap.put("commuList", commuList);
		articleMap.put("totalArticles", totalArticles);		
		return articleMap;
	}
	
	//글 상세 보기 
	@Override
	public CommuVO viewArticle(int commuNo) throws DataAccessException {
		CommuVO commuVO = (CommuVO)commuDAO.selectArticle(commuNo);
		return commuVO;
	}	
	
	//글 추가
	@Override
	public void addCommu(CommuVO commuVO) throws DataAccessException {
		commuDAO.insertNewCommu(commuVO);
	}

	@Override
	public void modArticle(CommuVO commuVO) throws DataAccessException {
		commuDAO.updateArticle(commuVO);
	}
	@Override
	public void removeArticle(int commuNo) throws DataAccessException{
		/*List<Integer> articleNoList=commuDAO.selectRemovedArticles(commuNo);
		commuDAO.deleteArticle(commuNo); 
		return articleNoList;*/
		commuDAO.deleteArticle(commuNo);
	} 
	@Override
	public List getCommentList(int commuNo) throws DataAccessException{
		List<CommentVO> commentList=commuDAO.getCommentList(commuNo);
		return commentList;
	}
	@Override
	public void addView(int commuNo) throws DataAccessException{
		commuDAO.addView(commuNo);
	}
}
