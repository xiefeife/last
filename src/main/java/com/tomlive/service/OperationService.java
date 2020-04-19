package com.tomlive.service;

import java.util.List;

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
}
