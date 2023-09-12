package com.tofit.spring.mypage.calendar.vo;

import org.springframework.stereotype.Component;

@Component("reservationVO")
public class ReservationVO {
	private int ptNum;
	private String cenName;
	private String ptPeriod;
	private int ptCount;
	private String ptDate;
	private String ptTime;
	
	
	public ReservationVO() {
		System.out.println("ReservationVO »ý¼º");
	}


	public int getPtNum() {
		return ptNum;
	}


	public void setPtNum(int ptNum) {
		this.ptNum = ptNum;
	}


	public String getCenName() {
		return cenName;
	}


	public void setCenName(String cenName) {
		this.cenName = cenName;
	}


	public String getPtPeriod() {
		return ptPeriod;
	}


	public void setPtPeriod(String ptPeriod) {
		this.ptPeriod = ptPeriod;
	}


	public int getPtCount() {
		return ptCount;
	}


	public void setPtCount(int ptCount) {
		this.ptCount = ptCount;
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

	


	
}
