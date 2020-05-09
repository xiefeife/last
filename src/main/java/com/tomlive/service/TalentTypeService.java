package com.tomlive.service;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.TalentType;

public interface TalentTypeService {
	
	
	    List<TalentType> selectAllTalentType();
	    
	    boolean insertSelective(Map<String, String> map);
	    
		boolean   deleteByPrimaryKey(Integer id);
		
		/**
		 * 统计每个岗位招聘的数量
		 * @return
		 */
		List<TalentType> selectTalentTypeCount();
		
		boolean  updateByPrimaryKeySelective(Map<String, Object> map);
}
