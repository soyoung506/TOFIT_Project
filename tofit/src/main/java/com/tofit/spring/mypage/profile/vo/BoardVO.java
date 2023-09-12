package com.tofit.spring.mypage.profile.vo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("boardVO")
public class BoardVO {
	private int communo;
	private String title;
	private int watch;
	private int commulike;
	private Date writeDate;
	private String content;
	private String imgFile;
	private String link;
	private String font;
	private int fontSize;
	private String userid;
	
	
	public BoardVO() {
		System.out.println("BoardVO 생성");
	}


	public int getCommuno() {
		return communo;
	}


	public void setCommuno(int communo) {
		this.communo = communo;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getWatch() {
		return watch;
	}


	public void setWatch(int watch) {
		this.watch = watch;
	}


	public int getCommulike() {
		return commulike;
	}


	public void setCommulike(int commulike) {
		this.commulike = commulike;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImgFile() {
		try {
			if(imgFile != null && imgFile.length() !=0) {
				imgFile=URLDecoder.decode(imgFile, "utf-8");
			}else {
				imgFile=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("BoardVO 이미지 로딩 중 에러 발생");
		}
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		try {
			if(imgFile != null && imgFile.length() !=0) {
				imgFile=URLDecoder.decode(imgFile, "utf-8");
			}else {
				imgFile=null;
			}
		}catch (UnsupportedEncodingException e) {
			System.out.println("BoardVO 이미지 저장 중 에러 발생");
		}
		this.imgFile = imgFile;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getFont() {
		return font;
	}


	public void setFont(String font) {
		this.font = font;
	}


	public int getFontSize() {
		return fontSize;
	}


	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}
	


	
}
