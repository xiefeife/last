package com.tomlive.dao;

import java.util.List;

import com.tomlive.entity.PressSort;

/**
 * 新闻分类表实体类
 *  @author Xie
 *  @date2020年4月17日
 */
public interface PressSortMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PressSort record);

    int insertSelective(PressSort record);

    PressSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PressSort record);

    int updateByPrimaryKey(PressSort record);
    
    /**
             * 查看所有新闻分类的方法
     * @return  新闻分类的集合
     */
    List<PressSort> selectAllPressSort();
    /**
	 * 查看多少产品信息的方法
	 * @return  受影响的行数
	 */
    int selectProductInfoCount();
    
    
}