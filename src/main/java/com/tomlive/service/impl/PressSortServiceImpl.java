package com.tomlive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tomlive.dao.PressSortMapper;
import com.tomlive.entity.PressSort;
import com.tomlive.service.PressSortService;

public class PressSortServiceImpl implements PressSortService{

	@Autowired
	private  PressSortMapper  pressSortMapper;
	
	
	@Override
	public List<PressSort> selectAllPressSort() {
		// TODO Auto-generated method stub
		return pressSortMapper.selectAllPressSort();
	}

}
