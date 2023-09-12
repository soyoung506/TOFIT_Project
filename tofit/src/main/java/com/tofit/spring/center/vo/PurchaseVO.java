package com.tofit.spring.center.vo;

import org.springframework.stereotype.Component;

@Component("purchaseVO")
public class PurchaseVO {
	private int ptNo;
	private String ptPeriod;
	private int ptCount;
	private int ptPrice;
	private String userId;
	private int ptPaynum;
	//외래키들 입력해야하는지 
	

	public PurchaseVO() {
		
	}
	
	

	public PurchaseVO(String ptPeriod, int ptCount, int ptPrice) {
		super();
		this.ptPeriod = ptPeriod;
		this.ptCount = ptCount;
		this.ptPrice = ptPrice;
	}



	public int getPtNo() {
		return ptNo;
	}

	public void setPtNo(int ptNo) {
		this.ptNo = ptNo;
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
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPtPaynum() {
		return ptPaynum;
	}

	public void setPtPaynum(int ptPaynum) {
		this.ptPaynum = ptPaynum;
	}

	
	
}
