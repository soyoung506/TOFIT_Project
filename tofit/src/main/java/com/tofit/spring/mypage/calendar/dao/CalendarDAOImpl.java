package com.tofit.spring.mypage.calendar.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tofit.spring.mypage.calendar.vo.CalendarVO;
import com.tofit.spring.mypage.calendar.vo.ReservationVO;

@Repository("calendarDAO")
public class CalendarDAOImpl implements CalendarDAO{
	@Autowired
	private SqlSession sqlSession;

	// 회원 확인
	@Override
	public String getUser(String id) throws DataAccessException {
		String user=sqlSession.selectOne("mapper.calendar.getUser", id);
		return user;
	}

	// 일반회원
	@Override
	public List<CalendarVO> getReserveInfo(String _id) throws DataAccessException {
		List<CalendarVO> reserveList=sqlSession.selectList("mapper.calendar.getReserveInfo", _id);
		return reserveList;
	}

	@Override
	public String getPTmembership(String id) throws DataAccessException {
		String result=(String)sqlSession.selectOne("mapper.calendar.getPTmembership", id);
		return result;
	}

	@Override
	public List<String> getTimes(Map<String, String> dateMap) throws DataAccessException {
		int ptPaynum=sqlSession.selectOne("mapper.calendar.getTimes_PT", dateMap);
		String coachId=sqlSession.selectOne("mapper.calendar.getTimes_Coach", ptPaynum);
		dateMap.put("coachId", coachId);
		List<String> disabledTimes=sqlSession.selectList("mapper.calendar.getTimes_schedule", dateMap);
		return disabledTimes;
	}
	
	private int getPTNum() {
		int ptNum=0;
		ptNum=sqlSession.selectOne("mapper.calendar.getPTNum");
		ptNum+=1;
		return ptNum;
	}

	@Override
	public void addReservation(CalendarVO calendarVO) throws DataAccessException {
		int ptNum=getPTNum();
		System.out.println(ptNum);
		calendarVO.setPtNum(ptNum);
		int ptPaynum=sqlSession.selectOne("mapper.calendar.addReservation_PT", calendarVO);
		String coachId=sqlSession.selectOne("mapper.calendar.addReservation_Coach", ptPaynum);
		calendarVO.setPtPaynum(ptPaynum);
		calendarVO.setCoachId(coachId);
		sqlSession.insert("mapper.calendar.addReservation_add", calendarVO);
		sqlSession.update("mapper.calendar.addReservation_ptRemain", ptPaynum);
	}

	@Override
	public List<ReservationVO> getReserveDetail(Map pagingMap)
			throws DataAccessException {
		List<ReservationVO> reserveList=sqlSession.selectList("mapper.calendar.getReserveDetail", pagingMap);
		return reserveList;
	}

	@Override
	public int getSelectedTotal(Map pagingMap) throws DataAccessException {
		int totCount=0;
		totCount=sqlSession.selectOne("mapper.calendar.getSelectedTotal", pagingMap);
		return totCount;
	}

	@Override
	public void cancelRerservation(int ptNum) throws DataAccessException {
		sqlSession.update("mapper.calendar.cancelRerservation_ptRemain", ptNum);
		sqlSession.delete("mapper.calendar.cancelRerservation_cancel", ptNum);
	}

	// 코치회원
	@Override
	public List<CalendarVO> getReserveInfoC(String _id) throws DataAccessException {
		List<CalendarVO> reserveList=sqlSession.selectList("mapper.calendar.getReserveInfoC", _id);
		return reserveList;
	}

	@Override
	public List<String> getTimesC(Map<String, String> dateMap)
			throws DataAccessException {
		List<String> disabledTimes=sqlSession.selectList("mapper.calendar.getTimesC", dateMap);
		return disabledTimes;
	}

	@Override
	public void addReservationC(CalendarVO calendarVO) throws DataAccessException {
		int ptNum=getPTNum();
		calendarVO.setPtNum(ptNum);
		sqlSession.insert("mapper.calendar.addReservationC", calendarVO);
	}

	@Override
	public List<ReservationVO> getReserveDetailC(Map pagingMap)
			throws DataAccessException {
		List<ReservationVO> reserveList=sqlSession.selectList("mapper.calendar.getReserveDetailC", pagingMap);
		return reserveList;
	}

	@Override
	public void cancelRerservationC(int ptNum) throws DataAccessException {
		sqlSession.delete("mapper.calendar.cancelRerservation_cancel", ptNum);
	}
	
	
	
		
} 




















