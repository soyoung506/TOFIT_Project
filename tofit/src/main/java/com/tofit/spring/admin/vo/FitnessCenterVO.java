package com.tofit.spring.admin.vo;

import org.springframework.stereotype.Component;

@Component("fitnessCenterVO")
public class FitnessCenterVO {
	private String cenNumber;
	private String cenName;


	public FitnessCenterVO() {
		System.out.println("FitnessCenterVO »ý¼º");
	}

	
	
	public FitnessCenterVO(String cenNumber, String cenName) {
		super();
		this.cenNumber = cenNumber;
		this.cenName = cenName;
	}



	public String getCenNumber() {
		return cenNumber;
	}


	public void setCenNumber(String cenNumber) {
		this.cenNumber = cenNumber;
	}


	public String getCenName() {
		return cenName;
	}


	public void setCenName(String cenName) {
		this.cenName = cenName;
	}
	
	


}
