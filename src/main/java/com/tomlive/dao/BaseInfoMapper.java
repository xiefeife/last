package com.tomlive.dao;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.tomlive.entity.BaseInfo;

/**
 * 公司基本信息dao层
 *  @author Xie
 *  @date2020年4月17日
 */
public interface BaseInfoMapper {





    int insert(BaseInfo record);

    //自定义添加
    int insertSelective(Map<String, String> map);

    BaseInfo selectByPrimaryKey(Integer id);

    int updateBaseInfo(Map<String, String> map);
    
    int updateByPrimaryKeySelective(Map<String, String> map);

    int updateByPrimaryKey(BaseInfo record);
    
      /**
      * 查看公司基本信息的方法
       * @return 公司对象  
       */
    List<BaseInfo>    selectAllBaseInfo();
    
}