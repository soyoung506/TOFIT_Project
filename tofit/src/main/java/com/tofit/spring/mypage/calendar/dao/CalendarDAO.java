package com.tofit.spring.mypage.calendar.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.calendar.vo.CalendarVO;
import com.tofit.spring.mypage.calendar.vo.ReservationVO;

public interface CalendarDAO {
	// 회원확인
	public String getUser(String id) throws DataAccessException;
	// 일반회원
	public List<CalendarVO> getReserveInfo(String _id) throws DataAccessException;
	public String getPTmembership(String id) throws DataAccessException;
	public List<String> getTimes(Map<String, String> dateMap) throws DataAccessException;
	public void addReservation(CalendarVO calendarVO) throws DataAccessException;
	public List<ReservationVO> getReserveDetail(Map pagingMap) throws DataAccessException;
	public int getSelectedTotal(Map pagingMap) throws DataAccessException;
	public void cancelRerservation(int ptNum) throws DataAccessException;
	// 코치
	public List<CalendarVO> getReserveInfoC(String _id) throws DataAccessException;
	public List<String> getTimesC(Map<String, String> dateMap) throws DataAccessException;
	public void addReservationC(CalendarVO calendarVO) throws DataAccessException;
	public List<ReservationVO> getReserveDetailC(Map pagingMap) throws DataAccessException;
	public void cancelRerservationC(int ptNum) throws DataAccessException;
}
