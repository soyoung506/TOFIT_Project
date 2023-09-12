package com.tofit.spring.shop.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Component;

@Component("cartsVO")
public class CartsVO {
	
	private int odNum;
	private String id;
	private int pNum;
	private int odCount;
	private int odPrice;
	private int orNum;
	private String pName;
	private int pPrice;
	private String pImg1;
	
	
	
	public CartsVO() {
		
	}


	public int getOdNum() {
		return odNum;
	}


	public void setOdNum(int odNum) {
		this.odNum = odNum;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	public int getOdCount() {
		return odCount;
	}


	public void setOdCount(int odCount) {
		this.odCount = odCount;
	}


	public int getOdPrice() {
		return odPrice;
	}


	public void setOdPrice(int odPrice) {
		this.odPrice = odPrice;
	}


	public int getOrNum() {
		return orNum;
	}


	public void setOrNum(int orNum) {
		this.orNum = orNum;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getpPrice() {
		return pPrice;
	}


	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}


	public String getpImg1() {
		try {
			if(pImg1 != null && pImg1.length() !=0) {
				pImg1=URLDecoder.decode(pImg1, "utf-8");
			}else {
				pImg1=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("CartsVO 이미지1 로딩 중 에러 발생");
		}
		return pImg1;
	}


	public void setpImg1(String pImg1) {
		try {
			if(pImg1 != null && pImg1.length() !=0) {
				pImg1=URLDecoder.decode(pImg1, "utf-8");
			}else {
				pImg1=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("CartsVO 이미지1 저장 중 에러 발생");
		}
		this.pImg1 = pImg1;
	}

	
}
