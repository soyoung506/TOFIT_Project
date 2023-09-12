package com.tofit.spring.mypage.calendar.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.calendar.vo.CalendarVO;

public interface CalendarService {
	// 회원확인
	public String getUser(String id) throws DataAccessException;
	// 일반회원
	public List<CalendarVO> getReserveInfo(String id) throws DataAccessException;
	public boolean getPTmembership(String id) throws DataAccessException;
	public List<String> getTimes(Map<String, String> dateMap) throws DataAccessException;
	public void addReservation(CalendarVO calendarVO) throws DataAccessException;
	public Map getReserveDetail(Map pagingMap) throws DataAccessException;
	public void cancelRerservation(int ptNum) throws DataAccessException;
	//코치회원
	public List<CalendarVO> getReserveInfoC(String id) throws DataAccessException;
	public List<String> getTimesC(Map<String, String> dateMap) throws DataAccessException;
	public void addReservationC(CalendarVO calendarVO) throws DataAccessException;
	public Map getReserveDetailC(Map pagingMap) throws DataAccessException;
	public void cancelRerservationC(int ptNum) throws DataAccessException;
}
