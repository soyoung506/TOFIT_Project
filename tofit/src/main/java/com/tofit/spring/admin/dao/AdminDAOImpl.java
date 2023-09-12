package com.tofit.spring.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.admin.vo.FitnessCenterVO;
import com.tofit.spring.admin.vo.PTmembershipVO;
import com.tofit.spring.mypage.profile.vo.ProfileVO;

@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PTmembershipVO> getPTmembership() throws DataAccessException {
		List<PTmembershipVO> ptList=sqlSession.selectList("mapper.admin.getPTmembership");
		return ptList;
	}

	@Override
	public List<FitnessCenterVO> getFitnessCenter() throws DataAccessException {
		List<FitnessCenterVO> cenList=sqlSession.selectList("mapper.admin.getFitnessCenter");
		return cenList;
	}

	@Override
	public List<ProfileVO> getCoach() throws DataAccessException {
		List<ProfileVO> coachList=sqlSession.selectList("mapper.admin.getCoach");
		return coachList;
	}

	@Override
	public void setDisabledPT(int ptNo) throws DataAccessException {
		sqlSession.update("mapper.admin.setDisabledPT", ptNo);
	}

	@Override
	public void addPTmembership(PTmembershipVO ptVO) throws DataAccessException {
		int ptNo=0;
		ptNo=sqlSession.selectOne("mapper.admin.getPtNumber");
		ptNo+=1;
		ptVO.setPtNo(ptNo);
		sqlSession.insert("mapper.admin.addPTmembership", ptVO);
	}
	
} 




















