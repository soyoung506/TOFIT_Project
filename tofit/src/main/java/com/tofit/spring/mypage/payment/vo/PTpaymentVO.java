package com.tofit.spring.mypage.payment.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("ptPaymentVO")
public class PTpaymentVO {
	private int ptPaynum;
	private String cenName;
	private String ptPeriod;
	private int ptCount;
	private String ptPayment;
	private int ptSum;
	private Date ptPaydate;
	private int ptRemain;
	private String ptRefund;
	
	
	
	public PTpaymentVO() {
		System.out.println("PTpaymentVO »ý¼º");
	}


	public PTpaymentVO(int ptPaynum, String cenName, String ptPeriod, int ptCount, String ptPayment, int ptSum,
			Date ptPaydate, int ptRemain) {
		super();
		this.ptPaynum = ptPaynum;
		this.cenName = cenName;
		this.ptPeriod = ptPeriod;
		this.ptCount = ptCount;
		this.ptPayment = ptPayment;
		this.ptSum = ptSum;
		this.ptPaydate = ptPaydate;
		this.ptRemain = ptRemain;
	}


	public int getPtPaynum() {
		return ptPaynum;
	}


	public void setPtPaynum(int ptPaynum) {
		this.ptPaynum = ptPaynum;
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


	public String getPtPayment() {
		return ptPayment;
	}


	public void setPtPayment(String ptPayment) {
		this.ptPayment = ptPayment;
	}


	public int getPtSum() {
		return ptSum;
	}


	public void setPtSum(int ptSum) {
		this.ptSum = ptSum;
	}


	public Date getPtPaydate() {
		return ptPaydate;
	}


	public void setPtPaydate(Date ptPaydate) {
		this.ptPaydate = ptPaydate;
	}


	public int getPtRemain() {
		return ptRemain;
	}


	public void setPtRemain(int ptRemain) {
		this.ptRemain = ptRemain;
	}


	public String getPtRefund() {
		return ptRefund;
	}


	public void setPtRefund(String ptRefund) {
		this.ptRefund = ptRefund;
	}

	

	
}
