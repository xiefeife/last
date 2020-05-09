package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

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
	public boolean insertSelective(Map<String, String> map) {
       int  count= 	talentRecruitmentMapper.insertSelective(map);
       
	  return count>0?true:false;
	}

	/*
	 * String jobName, String jobType,String beginTime, String endTime
	 */
	@Override
	public List<TalentRecruitment> selectTalentRecruitmentByCondition(Map<String, String> map) {
		
		
		return talentRecruitmentMapper.selectTalentRecruitmentByCondition(map);
	}

	
	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int count=talentRecruitmentMapper.deleteByPrimaryKey(id);
		return count>0?true:false;
	}



	/**
	 * 查看岗位招聘的数量
	 */
	@Override
	public int selectAllTalentRecruitmentSum() {
		// TODO Auto-generated method stub
		
	
		return talentRecruitmentMapper.selectAllTalentRecruitmentSum();
	}



	@Override
	public List<TalentRecruitment>  selectAllTalentRecruitmentCount() {
		// TODO Auto-generated method stub
		return talentRecruitmentMapper.selectAllTalentRecruitmentCount();
	}


	/**
	   * 根据主键有选择的修改岗位信息
	   * @param map
	   * @return
	   */
	@Override
	public boolean updateByPrimaryKeySelective(Map<String, String> map) {
     int  count=talentRecruitmentMapper.updateByPrimaryKeySelective(map);
		return count>0?true:false;
	}
	
	
	

}
