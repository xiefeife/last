package com.tomlive.util;

import java.util.Date;

public class TalentRecruitmentUtil {
	private  Integer id;

	private  Integer typeId;
	private   String realName;
	
	
	
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer  count;
	
    private String typeName;

	private Date creationTime;
    
    private Integer  status;
    
    private Integer talentNumber;
    
    
	public Integer getTalentNumber() {
		return talentNumber;
	}

	public void setTalentNumber(Integer talentNumber) {
		this.talentNumber = talentNumber;
	}

	/**
     * 岗位名称
     */
    private String jobName;

    /**
     * 岗位职责
     */
    private String jobStatement;

    /**
     * 岗位要求
     */
    private String jobRequirement;
    
    
    
    private String  userName;
    
    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

    
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobStatement() {
		return jobStatement;
	}

	public void setJobStatement(String jobStatement) {
		this.jobStatement = jobStatement;
	}

	public String getJobRequirement() {
		return jobRequirement;
	}

	public void setJobRequirement(String jobRequirement) {
		this.jobRequirement = jobRequirement;
	}



	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public TalentRecruitmentUtil() {
		super();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	
}
