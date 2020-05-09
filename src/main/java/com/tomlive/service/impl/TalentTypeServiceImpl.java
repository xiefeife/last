package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomlive.dao.TalentTypeMapper;
import com.tomlive.entity.TalentRecruitment;
import com.tomlive.entity.TalentType;
import com.tomlive.service.TalentTypeService;

@Service
@Transactional
public class TalentTypeServiceImpl implements TalentTypeService{
   
	@Autowired
	private TalentTypeMapper  talentTypeMapper;
	
	/**
	 * 查询全部的岗位类别
	 */
	@Override
	public List<TalentType> selectAllTalentType() {
		// TODO Auto-generated method stub
		return talentTypeMapper.selectAllTalentType();
	}

   /**
    * 添加岗位类别
    */
	@Override
	public boolean insertSelective(Map<String, String> map) {
		// TODO Auto-generated method stub
	int count=	talentTypeMapper.insertSelective(map);
		return count>0?true:false;
	}

	/**
	 * 根据主键删除
	 */
	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int count=	talentTypeMapper.deleteByPrimaryKey(id);
		return count>0?true:false;
	}

	/**
	 * 统计每个岗位的数量
	 */
	@Override
	public List<TalentType> selectTalentTypeCount() {
		// TODO Auto-generated method stub
		
		return talentTypeMapper.selectSizeGroupBy();
	}

	@Override
	public boolean updateByPrimaryKeySelective(Map<String, Object> map) {
     int count=		talentTypeMapper.updateByPrimaryKeySelective(map);
     return count>0?true:false;
	}

}
