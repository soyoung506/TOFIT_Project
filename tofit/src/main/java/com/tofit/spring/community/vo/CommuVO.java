package com.tofit.spring.community.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("commuVO")
public class CommuVO {
	private int commuNo;
	private int watch;
	private String title;
	private String content;
	private Date writeDate;
	private String userid;
	
	public CommuVO() {
		System.out.println("CommuVo »ý¼º");
	}

	public CommuVO(int commuNo, int watch, String title, String content, Date writeDate, String userid) {
		super();
		this.commuNo = commuNo;
		this.watch = watch;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
		this.userid = userid;
	}
	
	public int getCommuNo() {
		return commuNo;
	}

	public void setCommuNo(int commuNo) {
		this.commuNo = commuNo;
	}

	public int getWatch() {
		return watch;
	}

	public void setWatch(int watch) {
		this.watch = watch;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
