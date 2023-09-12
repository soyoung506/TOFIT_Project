package com.tofit.spring.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.admin.dao.AdminDAO;
import com.tofit.spring.admin.vo.FitnessCenterVO;
import com.tofit.spring.admin.vo.PTmembershipVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public List<PTmembershipVO> getPTmembership() throws DataAccessException {
		List<PTmembershipVO> ptList=adminDAO.getPTmembership();
		return ptList;
	}

	@Override
	public List<FitnessCenterVO> getFitnessCenter() throws DataAccessException {
		List<FitnessCenterVO> cenList=adminDAO.getFitnessCenter();
		return cenList;
	}

	@Override
	public List<ProfileVO> getCoach() throws DataAccessException {
		List<ProfileVO> coachList=adminDAO.getCoach();
		return coachList;
	}

	@Override
	public void setDisabledPT(int ptNo) throws DataAccessException {
		adminDAO.setDisabledPT(ptNo);
	}

	@Override
	public void addPTmembership(PTmembershipVO ptVO) throws DataAccessException {
		adminDAO.addPTmembership(ptVO);
	}


}
