package com.tomlive.util;
/**
 * json 工具类
 * @author ZhaoRenDong
 *
 */
public class JsonUtil {
	/**
	 * 用于存放状态码
	 */
	private String code;
	/**
	 * 用于存放信息
	 */
	private String message;
	/**
	 * 用于存放对象
	 */
	private Object info;
	
	public JsonUtil() {
		super();
	}
	public JsonUtil(String code,Object info,String message) {
		super();
		this.code = code;
		this.message = message;
		this.info = info;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}
	

}
