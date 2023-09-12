package com.tofit.spring.mypage.profile.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.profile.vo.ProfileVO;


public interface ProfileService {
	public ProfileVO getProfile(String id) throws DataAccessException;
	public Map getMyboard(Map pagingMap) throws DataAccessException;
	public boolean checkUser(ProfileVO profileVO) throws DataAccessException;
	public void modProfile(ProfileVO profileVO) throws DataAccessException;
	public void removeUser(String id) throws DataAccessException;
}
