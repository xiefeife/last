package com.tomlive.service;

import java.util.List;

import com.tomlive.entity.TalentRecruitment;

public interface TalentRecruitmentService {
	
	List<TalentRecruitment> selectAllTalentRecruitment();
	boolean insertSelective(TalentRecruitment record);

	/**
	 * 统计岗位招聘的数量
	 * 
	 * @return 成功与否
	 */
	int  selectTalentRecruitmentCount();
	
	/**
	 * 统计每个岗位的招聘数量
	 * 
	 * @return
	 */
	List<TalentRecruitment> selectSizeGroupBy();
}
