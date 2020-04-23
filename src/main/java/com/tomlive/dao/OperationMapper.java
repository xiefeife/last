package com.tomlive.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    
    

	/**
	 * 根据条件查看日志信息
	 * @param operationIp
	 * @param operationContent
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
    List<Operation>  selectOperationByCondition(@Param("operationIp") String operationIp,
    		@Param("operationContent") String operationContent,@Param("beginTime") String beginTime,
    		@Param("endTime") String endTime);
    
    
}