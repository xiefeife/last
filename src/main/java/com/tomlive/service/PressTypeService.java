package com.tomlive.service;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.PressType;

public interface PressTypeService {

	/**
	 * 查看所有新闻分类业务层接口
	 * @return
	 */
	List<PressType> selectAllPressType();
	
	
	boolean insertSelective(Map<String, String> map);
	boolean   deleteByPrimaryKey(Integer id);
	boolean updateByPrimaryKeySelective(Map<String, Object> map);
	
}
