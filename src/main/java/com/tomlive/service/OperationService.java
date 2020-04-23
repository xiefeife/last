package com.tomlive.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.Operation;

/**
 * 日志业务层接口
 * @author XIE
 *
 * 2020年4月17日
 */
public interface OperationService {

	 /**
     * 查看全部日志的方法
     * @return  
     */
	List<Operation> selectAllOperation();
	
	/**
	 * 添加日志的方法
	 * @param operation   日志对象
	 * @return  成功与否
	 */
	boolean insertSelective(Operation operation);
	
	
	
	
	/**
	 * 根据条件查看日志信息
	 * @param operationIp
	 * @param operationContent
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<Operation> selectOperationByCondition(String operationIp,
	String operationContent,String beginTime,
	String endTime);
	
	
}
