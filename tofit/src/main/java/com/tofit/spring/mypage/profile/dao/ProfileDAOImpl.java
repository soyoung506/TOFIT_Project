package com.tofit.spring.mypage.profile.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.mypage.profile.vo.BoardVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;


@Repository("profileDAO")
public class ProfileDAOImpl implements ProfileDAO{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public ProfileVO getProfile(String _id) throws DataAccessException {
		ProfileVO profile=(ProfileVO)sqlSession.selectOne("mapper.profile.getProfile", _id);
		return profile;
	}

	@Override
	public String checkUser(ProfileVO profileVO) throws DataAccessException {
		String result=(String)sqlSession.selectOne("mapper.profile.checkUser", profileVO);
		return result;
	}

	@Override
	public void modProfile(ProfileVO profileVO) throws DataAccessException {
		sqlSession.update("mapper.profile.modProfile", profileVO);
	}

	@Override
	public void removeUser(String id) throws DataAccessException {
		sqlSession.delete("mapper.profile.removeUser", id);
	}

	@Override
	public List<BoardVO> selectMyboard(Map pagingMap) throws DataAccessException {
		List<BoardVO> myboardList=sqlSession.selectList("mapper.profile.selectMyboard", pagingMap);
		return myboardList;
	}

	@Override
	public int getTotalMyboard(Map pagingMap) throws DataAccessException {
		int totCount=(Integer)sqlSession.selectOne("mapper.profile.getTotalMyboard", pagingMap);
		return totCount;
	}


} 




















