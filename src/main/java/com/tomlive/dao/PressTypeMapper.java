package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.PressType;

/**
 * 新闻分类表实体类
 *  @author Xie
 *  @date2020年4月17日
 */
public interface PressTypeMapper {
	
    int deleteByPrimaryKey(Integer id);



    int insertSelective(Map<String, String> map);


    
    /**
    * 查看所有新闻分类的方法
     * @return  新闻分类的集合
     */
    List<PressType> selectAllPressType();
    
    int updateByPrimaryKeySelective(Map<String, Object> map);
    
    
    
}