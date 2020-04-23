package com.tomlive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomlive.dao.OperationMapper;
import com.tomlive.entity.Operation;
import com.tomlive.service.OperationService;

/**
 * 业务逻辑层实现类
 * @author XIE
 * 2020年4月17日
 */
@Service
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


	/**
	 * 添加日志的方法
	 * @param operation   日志对象
	 * @return  成功与否
	 */
	@Override
	public boolean insertSelective(Operation operation) {
		int   count   = operationMapper.insertSelective(operation);
		return count>0?true:false;
	}



	/**
	 * 根据条件查看日志信息
	 * @param operationIp
	 * @param operationContent
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	@Override
	public List<Operation> selectOperationByCondition(String operationIp, String operationContent, String beginTime,
			String endTime) {
		
	     List<Operation> list   =operationMapper.selectOperationByCondition(operationIp, operationContent, beginTime, endTime);
    if(null!=list) {
    	return list;
    }
	
	return 	null;
	}
	
	
	
	

	
	

}
