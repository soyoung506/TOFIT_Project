package com.tofit.spring.center.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Component;

@Component("centerVO")
public class CenterVO {
	
	private String cenNumber;
	private String cenName;
	private String cenAddress;
	private String cenTel;
	private String thumbnail;
	private String cenTime;
	private String city;
	
	
	
	
	
	public CenterVO() {
		
	}





	public CenterVO(String cenName, String cenAddress, String cenTel, String thumbnail, String cenTime, String city) {
		super();
		this.cenName = cenName;
		this.cenAddress = cenAddress;
		this.cenTel = cenTel;
		this.thumbnail = thumbnail;
		this.cenTime = cenTime;
		this.city = city;
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





	public String getCenAddress() {
		return cenAddress;
	}





	public void setCenAddress(String cenAddress) {
		this.cenAddress = cenAddress;
	}





	public String getCenTel() {
		return cenTel;
	}





	public void setCenTel(String cenTel) {
		this.cenTel = cenTel;
	}





	public String getThumbnail() {
		try {
			if(thumbnail != null && thumbnail.length() !=0 ) {
				thumbnail = URLDecoder.decode(thumbnail,"utf-8");
			}else {
				thumbnail = null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("이미지 로딩중 에러");
			
		}
		return thumbnail;
	}





	public void setThumbnail(String thumbnail) {
		try {
			if(thumbnail != null && thumbnail.length() !=0 ) {
				this.thumbnail =  URLDecoder.decode(thumbnail,"utf-8");
			}else {
				thumbnail = null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("이미지 저장중 에러!");
		}
	}





	public String getCenTime() {
		return cenTime;
	}





	public void setCenTime(String cenTime) {
		this.cenTime = cenTime;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}
	
	
}
