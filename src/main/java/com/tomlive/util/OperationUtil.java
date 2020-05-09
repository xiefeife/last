package com.tomlive.util;

import java.util.Date;

public class OperationUtil {

	// 日志操作时间
		private Date beginTime;
		// 日志操作内容
		private String operationContent;
		// 日志操作者
	
		private Date endTime;
		
		
		private String operationIp;


		public Date getBeginTime() {
			return beginTime;
		}


		public void setBeginTime(Date beginTime) {
			this.beginTime = beginTime;
		}


		public String getOperationContent() {
			return operationContent;
		}


		public void setOperationContent(String operationContent) {
			this.operationContent = operationContent;
		}


		public Date getEndTime() {
			return endTime;
		}


		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}


		public String getOperationIp() {
			return operationIp;
		}


		public void setOperationIp(String operationIp) {
			this.operationIp = operationIp;
		}
		
		
}
