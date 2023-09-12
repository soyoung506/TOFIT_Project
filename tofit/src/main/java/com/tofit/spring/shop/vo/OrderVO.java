package com.tofit.spring.shop.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("orderVO")
public class OrderVO {
	
	private int orNum;
	private String id;
	private Date orDate;
	private int orTotal;
	private String orResult;
	private String orPhone;
	private String orAddress;
	private String orRequest;
	private String orPayment;
	private String pName;
	private int orCount;
	
	
	public OrderVO() {
		
	}


	public int getOrNum() {
		return orNum;
	}


	public void setOrNum(int orNum) {
		this.orNum = orNum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getOrDate() {
		return orDate;
	}


	public void setOrDate(Date orDate) {
		this.orDate = orDate;
	}


	public int getOrTotal() {
		return orTotal;
	}


	public void setOrTotal(int orTotal) {
		this.orTotal = orTotal;
	}


	public String getOrResult() {
		return orResult;
	}


	public void setOrResult(String orResult) {
		this.orResult = orResult;
	}


	public String getOrPhone() {
		return orPhone;
	}


	public void setOrPhone(String orPhone) {
		this.orPhone = orPhone;
	}


	public String getOrAddress() {
		return orAddress;
	}


	public void setOrAddress(String orAddress) {
		this.orAddress = orAddress;
	}


	public String getOrRequest() {
		return orRequest;
	}


	public void setOrRequest(String orRequest) {
		this.orRequest = orRequest;
	}


	public String getOrPayment() {
		return orPayment;
	}


	public void setOrPayment(String orPayment) {
		this.orPayment = orPayment;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getOrCount() {
		return orCount;
	}


	public void setOrCount(int orCount) {
		this.orCount = orCount;
	}

	
}
