package com.tomlive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomlive.dao.OperationMapper;
import com.tomlive.entity.Operation;
import com.tomlive.service.OperationService;

/**
 * 业务逻辑层实现类
 * @author XIE
 * 2020年4月17日
 */
public class OperationServiceImpl implements OperationService{
	@Autowired
	private  OperationMapper  operationMapper;

	
	 /**
     * 查看全部日志的方法
     * @return  
     */
	@Override
	public List<Operation> selectAllOperation() {
		
		return operationMapper.selectAllOperation();
	}
	
	

}
