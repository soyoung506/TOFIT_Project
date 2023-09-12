package com.tofit.spring.admin.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.admin.vo.FitnessCenterVO;
import com.tofit.spring.admin.vo.PTmembershipVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;

public interface AdminService {
	public List<PTmembershipVO> getPTmembership() throws DataAccessException;
	public List<FitnessCenterVO> getFitnessCenter() throws DataAccessException;
	public List<ProfileVO> getCoach() throws DataAccessException;
	public void setDisabledPT (int ptNo) throws DataAccessException;
	public void addPTmembership (PTmembershipVO ptVO) throws DataAccessException;
}
