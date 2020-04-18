package com.tomlive.dao;

import java.util.List;

import com.tomlive.entity.PressCenter;
/**
 *       新闻中心dao层接�?
 *  @author Xie
 *  @date2020�?4�?17�?
 */
public interface PressCenterMapper {
 
   /** 
            * 选择性的添加新闻中心的方�?
    * @param record �? 新闻中心的对�?
    * @return   受影响的行数
    */
    int insertSelective(PressCenter record);

   

    /**
               * 根据新闻中心对象主键修改信息
     * @param record  新闻对象主键 
     * @return  受影响行�?
     */
    int updateByPrimaryKeySelective(PressCenter record);


    int updateByPrimaryKey(PressCenter record);
    
    /**
                * 查看所有新闻中心的方法
     * @return
     */
    List<PressCenter> selectAllPressCenter();
    
    /**
               * 查看新闻中心数量的方法
     * @return
     */
    int selectPressCenterCount();
}