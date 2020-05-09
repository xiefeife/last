package com.tomlive.entity;

import java.util.Date;

public class TalentRecruitment {
    private Integer id;

    /**
     * 岗位类型
     */
    private TalentType talentType;

    private Integer talentNumber;


   

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

    private User user;

    private Date creationTime;
    
    private Integer  status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public TalentType getTalentType() {
		return talentType;
	}

	public void setTalentType(TalentType talentType) {
		this.talentType = talentType;
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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public TalentRecruitment() {
		super();
	}

	 public Integer getTalentNumber() {
			return talentNumber;
		}

		public void setTalentNumber(Integer talentNumber) {
			this.talentNumber = talentNumber;
		}
    

}