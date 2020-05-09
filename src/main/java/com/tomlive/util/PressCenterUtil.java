package com.tomlive.util;

import java.util.Date;

import com.tomlive.entity.PressType;

public class PressCenterUtil {
	private String title;
	private String userName;

	private Date  beginTime;
	private Date  endTime;
	private String presssort;
	
	
	
	
	
	public String getPresssort() {
		return presssort;
	}
	public void setPresssort(String presssort) {
		this.presssort = presssort;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
