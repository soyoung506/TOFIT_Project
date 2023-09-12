package com.tofit.spring.shop.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Component;

@Component("productVO")
public class ProductVO {
	
	private int pNum;
	private String pName;
	private String pOri;
	private String pCon;
	private int pPrice;
	private String pImg1;
	private String pImg2;
	private int pCount;
	
	
	public ProductVO() {
		
	}


	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public String getpOri() {
		return pOri;
	}


	public void setpOri(String pOri) {
		this.pOri = pOri;
	}


	public String getpCon() {
		return pCon;
	}


	public void setpCon(String pCon) {
		this.pCon = pCon;
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
			System.out.println("ProductVO 이미지1 로딩 중 에러 발생");
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
			System.out.println("ProductVO 이미지1 저장 중 에러 발생");
		}
		this.pImg1 = pImg1;
	}


	public String getpImg2() {
		try {
			if(pImg2 != null && pImg2.length() !=0) {
				pImg2=URLDecoder.decode(pImg2, "utf-8");
			}else {
				pImg2=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("ProductVO 이미지2 로딩 중 에러 발생");
		}
		return pImg2;
	}


	public void setpImg2(String pImg2) {
		try {
			if(pImg2 != null && pImg2.length() !=0) {
				pImg2=URLDecoder.decode(pImg2, "utf-8");
			}else {
				pImg2=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("ProductVO 이미지2 저장 중 에러 발생");
		}
		this.pImg2 = pImg2;
	}


	public int getpCount() {
		return pCount;
	}


	public void setpCount(int pCount) {
		this.pCount = pCount;
	}


	
	
}
