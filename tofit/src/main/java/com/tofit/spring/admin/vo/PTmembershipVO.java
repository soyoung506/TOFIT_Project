package com.tofit.spring.admin.vo;

import org.springframework.stereotype.Component;

@Component("ptMembershipVO")
public class PTmembershipVO {
	private int ptNo;
	private String fkCenNumber;
	private String cenName;
	private String ptCoach;
	private String name;
	private String ptPeriod;
	private int ptCount;
	private int ptPrice;
	private String centerMembership;


	public PTmembershipVO() {
		System.out.println("PTmembershipVO »ý¼º");
	}


	public int getPtNo() {
		return ptNo;
	}


	public void setPtNo(int ptNo) {
		this.ptNo = ptNo;
	}


	public String getFkCenNumber() {
		return fkCenNumber;
	}


	public void setFkCenNumber(String fkCenNumber) {
		this.fkCenNumber = fkCenNumber;
	}


	public String getCenName() {
		return cenName;
	}


	public void setCenName(String cenName) {
		this.cenName = cenName;
	}


	public String getPtCoach() {
		return ptCoach;
	}


	public void setPtCoach(String ptCoach) {
		this.ptCoach = ptCoach;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public int getPtPrice() {
		return ptPrice;
	}


	public void setPtPrice(int ptPrice) {
		this.ptPrice = ptPrice;
	}


	public String getCenterMembership() {
		return centerMembership;
	}


	public void setCenterMembership(String centerMembership) {
		this.centerMembership = centerMembership;
	}
	
	


}
