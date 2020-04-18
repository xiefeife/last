package com.tomlive.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomlive.dao.TalentRecruitmentMapper;
import com.tomlive.entity.TalentRecruitment;
import com.tomlive.service.TalentRecruitmentService;

@Service
@Transactional
public class TalentRecruitmentServiceImpl implements TalentRecruitmentService{

	@Autowired
	private TalentRecruitmentMapper talentRecruitmentMapper;
	
	
	
	@Override
	public List<TalentRecruitment> selectAllTalentRecruitment() {
		
		return talentRecruitmentMapper.selectAllTalentRecruitment();
	}



	/**
	 * 选择性的添加人才招聘的方法
	 * 
	 * @param record 人才招聘的对象
	 * @return 受影响的行数
	 */
	@Override
	public boolean insertSelective(TalentRecruitment record) {
       int  count= 	talentRecruitmentMapper.insertSelective(record);
       
	  return count>0?true:false;
	}



	/**
	 * 统计岗位招聘的数量
	 * @return 成功与否
	 */
	@Override
	public int selectTalentRecruitmentCount() {
		// TODO Auto-generated method stub
	  	
		return talentRecruitmentMapper.selectTalentRecruitmentCount();
	}


	/**
	 * 统计每个岗位的招聘数量
	 * 
	 * @return
	 */
	@Override
	public List<TalentRecruitment> selectSizeGroupBy() {
		
		return talentRecruitmentMapper.selectSizeGroupBy();
	}
	
	
	

}
