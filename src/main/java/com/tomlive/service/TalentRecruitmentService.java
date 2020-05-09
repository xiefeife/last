package com.tomlive.service;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.TalentRecruitment;

public interface TalentRecruitmentService {
	
	List<TalentRecruitment> selectAllTalentRecruitment();
	/**
	 * 添加招聘岗位
	 * @param record
	 * @return
	 */
	boolean insertSelective(Map<String, String> map);

	/**
	 * 根据条件查询岗位
	 * @param jobName
	 * @param jobType
	 * @param endTime
	 * @return
	 */
	List<TalentRecruitment> selectTalentRecruitmentByCondition(Map<String, String> map
	 );
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
  boolean   deleteByPrimaryKey(Integer id);
  
  /**
   * 查看岗位招聘的总数
   * @return
   */
  int  selectAllTalentRecruitmentSum();
  
  /**
   * 每个岗位的招聘数量
   * @return
   */
  List<TalentRecruitment>   selectAllTalentRecruitmentCount();
  
  /**
   * 根据主键有选择的修改岗位信息
   * @param map
   * @return
   */
  boolean  updateByPrimaryKeySelective(Map<String, String> map);
}
