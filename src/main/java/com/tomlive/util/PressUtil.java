package com.tomlive.util;

import java.util.Date;

public class PressUtil {

	private  Integer id;
	
	
    private Integer talentNumber;
    private String typeName;
private  String  realName;


    public String getRealName() {
	return realName;
}


public void setRealName(String realName) {
	this.realName = realName;
}


	private String photo;

    private String title;
    
    private Date createTime;
   private String particulars;

	private String  userName;
   private String pressName;

   private String pressDescribe;
   
   private Integer status;
   
   
   private  Integer pressTypeId;
  
    
    public String getUserName() {
	return userName;
}
    

public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


public void setUserName(String userName) {
	this.userName = userName;
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

    
    
    
    
    public Integer getPressTypeId() {
		return pressTypeId;
	}

	public void setPressTypeId(Integer pressTypeId) {
		this.pressTypeId = pressTypeId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTalentNumber() {
		return talentNumber;
	}

	public void setTalentNumber(Integer talentNumber) {
		this.talentNumber = talentNumber;
	}


	public String getTypeName() {
		return typeName;
	}


	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	 


}
