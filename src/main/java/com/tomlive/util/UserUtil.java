package com.tomlive.util;

import java.util.Date;

public class UserUtil {

	
	 private Integer id;

	    private String pressName;

	    private String pressDescribe;

	    private Date createTime;
	    private String userName;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPressName() {
			return pressName;
		}
		public void setPressName(String pressName) {
			this.pressName = pressName;
		}
		public String getPressDescribe() {
			return pressDescribe;
		}
		public void setPressDescribe(String pressDescribe) {
			this.pressDescribe = pressDescribe;
		}
		public Date getCreateTime() {
			return createTime;
		}
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}

	
}
