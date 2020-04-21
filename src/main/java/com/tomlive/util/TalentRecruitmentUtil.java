package com.tomlive.util;

import java.util.Date;

public class TalentRecruitmentUtil {

	private Integer  count;
	private String   jobType;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
   

    /**
     * 岗位类型
     */
  

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

  

    private Date creationTime;
    
    private Integer  status;


    private  String   userName;


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

	
}
