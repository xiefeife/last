package com.tomlive.entity;

import java.util.Date;

public class TalentRecruitment {
    private Integer id;

    private String jobCategory;

    private String jobName;

    private String jobStatement;

    private String jobRequirement;

    private Integer userId;

    private Date creationTime;
    
    private Integer  status;
    

    public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory == null ? null : jobCategory.trim();
    }

    public String getjobName() {
        return jobName;
    }

    public void setjobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobStatement() {
        return jobStatement;
    }

    public void setJobStatement(String jobStatement) {
        this.jobStatement = jobStatement == null ? null : jobStatement.trim();
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement == null ? null : jobRequirement.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}