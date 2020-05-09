package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
    int insertSelective(Map<String, String> record);
   

    /**
               * 根据新闻中心对象主键修改信息
     * @param record  新闻对象主键 
     * @return  受影响行�?
     */
    int updateByPrimaryKeySelective(PressCenter record);


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
       
         /**
                    *   撤回新闻
          * @param id
          * @return
          */
    int updatePressCenterStatus(Integer id);
    
    
    /**
     * 发布新闻
     * @param id
     * @return
     */
    int  activetePressCenterStatus(Integer id);
    
    /**
     * 根据id查看新闻状态
     * @param id
     * @return
     */
    int selectPressCenterStatus(Integer id);
     /**
      * 根据条件查看新闻的方法
      * @param title
      * @param plate
      * @param beginTime
      * @param endTime
      * @param userName
      * @return
      */
    List<PressCenter> selectPressCenterByCondition(Map<String, String> map);
    
    
    int deleteByPrimaryKey(Integer id);
   
     
     /**
                  * 修改新闻详情的方法
      * @param map
      * @return
      */
    int   updateByPrimaryKeySelective(Map<String, String> map);
    		
}