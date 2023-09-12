package com.tofit.spring.mypage.calendar.vo;

import org.springframework.stereotype.Component;

@Component("calendarVO")
public class CalendarVO {
	private int ptNum;
	private String ptDate;
	private String ptTime;
	private int ptPaynum;
	private String id;
	private String coachId;


	public CalendarVO() {
		System.out.println("CalendarVO »ý¼º");
	}
	


	public int getPtNum() {
		return ptNum;
	}


	public void setPtNum(int ptNum) {
		this.ptNum = ptNum;
	}


	public String getPtDate() {
		return ptDate;
	}


	public void setPtDate(String ptDate) {
		this.ptDate = ptDate;
	}


	public String getPtTime() {
		return ptTime;
	}


	public void setPtTime(String ptTime) {
		this.ptTime = ptTime;
	}


	public int getPtPaynum() {
		return ptPaynum;
	}


	public void setPtPaynum(int ptPaynum) {
		this.ptPaynum = ptPaynum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getCoachId() {
		return coachId;
	}

	public void setCoachId(String coachId) {
		this.coachId = coachId;
	}

}
