package com.tofit.spring.mypage.calendar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.tofit.spring.mypage.calendar.dao.CalendarDAO;
import com.tofit.spring.mypage.calendar.vo.CalendarVO;
import com.tofit.spring.mypage.calendar.vo.ReservationVO;

@Service("calendarService")
public class CalendarServiceImpl implements CalendarService{
	@Autowired
	private CalendarDAO calendarDAO;
	
	@Override
	public String getUser(String id) throws DataAccessException {
		String user=calendarDAO.getUser(id);
		return user;
	}

	@Override
	public List<CalendarVO> getReserveInfo(String id) throws DataAccessException {
		List<CalendarVO> reserveList=calendarDAO.getReserveInfo(id);
		return reserveList;
	}

	@Override
	public boolean getPTmembership(String id) throws DataAccessException {
		boolean result=Boolean.parseBoolean(calendarDAO.getPTmembership(id));
		return result;
	}

	@Override
	public List<String> getTimes(Map<String, String> dateMap) throws DataAccessException {
		List<String> disabledTimes=calendarDAO.getTimes(dateMap);
		return disabledTimes;
	}

	@Override
	public void addReservation(CalendarVO calendarVO) throws DataAccessException {
		calendarDAO.addReservation(calendarVO);
	}

	@Override
	public Map getReserveDetail(Map pagingMap) throws DataAccessException {
		Map reserveMap=new HashMap();
		List<ReservationVO> reserveList=calendarDAO.getReserveDetail(pagingMap);
		int selectedTotal=calendarDAO.getSelectedTotal(pagingMap);
		reserveMap.put("reserveList", reserveList);
		reserveMap.put("selectedTotal", selectedTotal);
		return reserveMap;
	}

	@Override
	public void cancelRerservation(int ptNum) throws DataAccessException {
		calendarDAO.cancelRerservation(ptNum);
	}

	//코치회원
	@Override
	public List<CalendarVO> getReserveInfoC(String id) throws DataAccessException {
		List<CalendarVO> reserveList=calendarDAO.getReserveInfoC(id);
		return reserveList;
	}

	@Override
	public List<String> getTimesC(Map<String, String> dateMap) throws DataAccessException {
		List<String> disabledTimes=calendarDAO.getTimesC(dateMap);
		return disabledTimes;
	}

	@Override
	public void addReservationC(CalendarVO calendarVO) throws DataAccessException {
		calendarDAO.addReservationC(calendarVO);
		
	}

	@Override
	public Map getReserveDetailC(Map pagingMap) throws DataAccessException {
		Map reserveMap=new HashMap();
		List<ReservationVO> reserveList=calendarDAO.getReserveDetailC(pagingMap);
		int selectedTotal=calendarDAO.getSelectedTotal(pagingMap);
		reserveMap.put("reserveList", reserveList);
		reserveMap.put("selectedTotal", selectedTotal);
		return reserveMap;
	}

	@Override
	public void cancelRerservationC(int ptNum) throws DataAccessException {
		calendarDAO.cancelRerservationC(ptNum);
	}

}
