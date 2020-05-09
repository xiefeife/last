package com.tomlive.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.PressCenter;

/**
 * 新闻中心业务逻辑层接口
 * 
 * @author Xie
 * @date2020年4月17日
 */
public interface PressCenterService {

	List<PressCenter> selectAll();

	/**
	 * 选择性的添加新闻中心的方法
	 * @param record 想 新闻中心的对象
	 * @return 受影响的行数
	 */
	boolean insertSelective(Map<String, String> map);


	/**
	 * 查看新闻中心数量的方法
	 * 
	 * @return
	 */
	int selectPressCenterCount();
	 /**
	  * 删除操作
	  * @param id
	  * @return
	  */
	boolean deleteByPrimaryKey(Integer id);
	
	
	/**
	 * 多条件查看新闻状态
	 * @param map
	 * @return
	 */
	List<PressCenter> selectPressCenterByCondition( Map<String, String> map);
	

	/**
	 * 修改新闻状态
	 * @param map
	 * @return
	 */
	boolean   updateByPrimaryKeySelective(Map<String, String> map);
	
	
	/**
	 * 撤回新闻状态
	 * @param id
	 * @return
	 */
	boolean updatePressCenterStatus(Integer id);
	
	
	/**
	 * 激活新闻状态
	 * @param id
	 * @return
	 */
	boolean  activetePressCenterStatus(Integer id);
	
	/**
	 * 根据主键查找新闻状态
	 * @param id
	 * @return
	 */
	int selectPressCenterStatus(Integer id);
	
}
