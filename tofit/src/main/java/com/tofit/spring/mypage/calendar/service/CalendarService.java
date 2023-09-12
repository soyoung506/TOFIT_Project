package com.tofit.spring.mypage.calendar.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.tofit.spring.mypage.calendar.vo.CalendarVO;

public interface CalendarService {
	// ȸ��Ȯ��
	public String getUser(String id) throws DataAccessException;
	// �Ϲ�ȸ��
	public List<CalendarVO> getReserveInfo(String id) throws DataAccessException;
	public boolean getPTmembership(String id) throws DataAccessException;
	public List<String> getTimes(Map<String, String> dateMap) throws DataAccessException;
	public void addReservation(CalendarVO calendarVO) throws DataAccessException;
	public Map getReserveDetail(Map pagingMap) throws DataAccessException;
	public void cancelRerservation(int ptNum) throws DataAccessException;
	//��ġȸ��
	public List<CalendarVO> getReserveInfoC(String id) throws DataAccessException;
	public List<String> getTimesC(Map<String, String> dateMap) throws DataAccessException;
	public void addReservationC(CalendarVO calendarVO) throws DataAccessException;
	public Map getReserveDetailC(Map pagingMap) throws DataAccessException;
	public void cancelRerservationC(int ptNum) throws DataAccessException;
}
