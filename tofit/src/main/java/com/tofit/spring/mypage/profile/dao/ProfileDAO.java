package com.tofit.spring.mypage.profile.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.profile.vo.BoardVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;


public interface ProfileDAO {
	public ProfileVO getProfile(String _id) throws DataAccessException;
	public String checkUser(ProfileVO profileVO) throws DataAccessException;
	public void modProfile(ProfileVO profileVO) throws DataAccessException;
	public void removeUser(String id) throws DataAccessException;
	public List<BoardVO> selectMyboard(Map pagingMap) throws DataAccessException;
	public int getTotalMyboard(Map pagingMap) throws DataAccessException;
}
