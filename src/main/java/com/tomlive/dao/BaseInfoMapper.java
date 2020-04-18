package com.tomlive.dao;

import java.util.List;

import com.tomlive.entity.BaseInfo;

/**
 * 公司基本信息dao层
 *  @author Xie
 *  @date2020年4月17日
 */
public interface BaseInfoMapper {





    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    BaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);
    
      /**
                      * 查看公司基本信息的方法
       * @return 公司对象  
       */
      BaseInfo  selectAllBaseInfo();
    
}