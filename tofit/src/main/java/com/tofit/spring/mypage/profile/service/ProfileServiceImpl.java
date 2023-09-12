package com.tofit.spring.mypage.profile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.mypage.profile.dao.ProfileDAO;
import com.tofit.spring.mypage.profile.vo.BoardVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;



@Service("profileService")
public class ProfileServiceImpl implements ProfileService{
	@Autowired
	private ProfileDAO profileDAO;

	@Override
	public ProfileVO getProfile(String id) throws DataAccessException {
		ProfileVO profile=profileDAO.getProfile(id);
		return profile;
	}

	@Override
	public Map getMyboard(Map pagingMap) throws DataAccessException {
		Map myboardMap=new HashMap();
		List<BoardVO> myboardList=profileDAO.selectMyboard(pagingMap);
		int totalMyboard=profileDAO.getTotalMyboard(pagingMap);
		myboardMap.put("myboardList", myboardList);
		myboardMap.put("totalMyboard", totalMyboard);
		return myboardMap;
	}

	@Override
	public boolean checkUser(ProfileVO profileVO) throws DataAccessException {
		boolean result=Boolean.parseBoolean(profileDAO.checkUser(profileVO));
		return result;
	}

	@Override
	public void modProfile(ProfileVO profileVO) throws DataAccessException {
		profileDAO.modProfile(profileVO);
	}

	@Override
	public void removeUser(String id) throws DataAccessException {
		profileDAO.removeUser(id);
	}
	

}
