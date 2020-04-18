package com.tomlive.entity;

import java.util.Date;

/**
 * 日志实体类
 *  @author Xie
 *  @date2020年4月16日
 */
public class Operation {
    private Integer operationId;

    private Date operationTime;

    private String operationContent;

    private Integer userId;

    private String operationIp;

    private String param;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent == null ? null : operationContent.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOperationIp() {
        return operationIp;
    }

    public void setOperationIp(String operationIp) {
        this.operationIp = operationIp == null ? null : operationIp.trim();
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

	@Override
	public String toString() {
		return "Operation [operationId=" + operationId + ", operationTime=" + operationTime + ", operationContent="
				+ operationContent + ", userId=" + userId + ", operationIp=" + operationIp + ", param=" + param + "]";
	}

	public Operation() {
		super();
	}
    
}