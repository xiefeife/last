package com.tomlive.dao;

import java.util.List;

import com.tomlive.entity.Operation;

public interface OperationMapper {
	
    int deleteByPrimaryKey(Integer operationId);

    int insert(Operation record);

    int insertSelective(Operation record);

    Operation selectByPrimaryKey(Integer operationId);

    int updateByPrimaryKeySelective(Operation record);

    int updateByPrimaryKey(Operation record);
    
    /**
     * 查看全部日志的方法
     * @return  
     */
    List<Operation> selectAllOperation();
    
    
}