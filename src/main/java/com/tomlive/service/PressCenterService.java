package com.tomlive.service;

import java.util.List;

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
	 * 
	 * @param record 想 新闻中心的对象
	 * @return 受影响的行数
	 */
	Boolean insertSelective(PressCenter pressCenter);

	/**
	 * 根据新闻中心对象主键有选择的修改信息
	 * 
	 * @param record 新闻对象主键
	 * @return 成功与否
	 */
	boolean updateByPrimaryKeySelective(PressCenter record);

	/**
	 * 查看新闻中心数量的方法
	 * 
	 * @return
	 */
	int selectPressCenterCount();
}
