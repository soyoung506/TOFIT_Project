package com.tofit.spring.mypage.profile.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("profileVO")
public class ProfileVO {
	private String id;
	private String name;
	private String pwd;
	private String email;
	private String nickName;
	private String profileImg;
	private Date joinDate;
	private String address;
	private String phone;
	private String admin;
	
	
	public ProfileVO() {
		System.out.println("ProfileVO 생성");
	}
	
	public ProfileVO(String id, String name, String pwd, String email, String nickName, String profileImg, Date joinDate, String address, String phone) {
		super();
		this.id=id;
		this.name=name;
		this.pwd=pwd;
		this.email=email;
		this.nickName=nickName;
		this.profileImg=profileImg;
		this.joinDate=joinDate;
		this.address=address;
		this.phone=phone;
	}
	
	public ProfileVO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProfileImg() {
		try {
			if(profileImg != null && profileImg.length() !=0) {
				profileImg=URLDecoder.decode(profileImg, "utf-8");
			}else {
				profileImg=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("ProfileVO 이미지 로딩 중 에러 발생");
		}
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		try {
			if(profileImg != null && profileImg.length() !=0) {
				profileImg=URLDecoder.decode(profileImg, "utf-8");
			}else {
				profileImg=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("ProfileVO 이미지 저장 중 에러 발생");
		}
		this.profileImg = profileImg;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	
}
