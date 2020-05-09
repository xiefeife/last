package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.TalentRecruitment;
import com.tomlive.entity.TalentType;

public interface TalentTypeMapper {
	
	/**
	 * 根据主键id删除岗位类别
	 * @param id
	 * @return
	 */
	  int deleteByPrimaryKey(Integer id);
	  
	  
	  
	  int insertSelective(Map<String, String> map);

	    /**
	       * 统计每个岗位的招聘数量
	     * @return
	     */
	 List<TalentType> selectSizeGroupBy();
	  
    
     List<TalentType> selectAllTalentType();
     
     
     int  updateByPrimaryKeySelective(Map<String, Object> map);
}