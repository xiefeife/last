package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomlive.dao.PressTypeMapper;
import com.tomlive.entity.PressType;
import com.tomlive.service.PressTypeService;

@Service
@Transactional
public class PressTypeServiceImpl implements PressTypeService {

	@Autowired
	private PressTypeMapper pressTypeMapper;

	@Override
	public List<PressType> selectAllPressType() {
		// TODO Auto-generated method stub
		return pressTypeMapper.selectAllPressType();
	}

	@Override
	public boolean insertSelective(Map<String, String> map) {
		// TODO Auto-generated method stub
		int count = pressTypeMapper.insertSelective(map);
		return count > 0 ? true : false;
	}

	/**
	 * 删除语句
	 */
	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int count = pressTypeMapper.deleteByPrimaryKey(id);
		return count > 0 ? true : false;
	}

	@Override
	public boolean updateByPrimaryKeySelective(Map<String, Object> map) {
	 int count=	pressTypeMapper.updateByPrimaryKeySelective(map);
	 return count > 0 ? true : false;
	}

}
