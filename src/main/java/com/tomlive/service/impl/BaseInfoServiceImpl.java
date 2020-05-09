package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.tomlive.dao.BaseInfoMapper;
import com.tomlive.entity.BaseInfo;
import com.tomlive.service.BaseInfoService;
/**
     *     公司基本信息业务逻辑层实现类接口
 *  @author Xie
 *  @date2020年4月17日
 */
@Transactional
@Service
public class BaseInfoServiceImpl implements BaseInfoService{

	@Autowired
	private  BaseInfoMapper  baseInfoMapper;

	
	/**
	   * 查看公司基本信息的方法
	 * @return 公司对象
	 */
	@Override
	public List<BaseInfo> selectAllBaseInfo() {
		
		return baseInfoMapper.selectAllBaseInfo();
	}


	@Override
	public boolean updateByPrimaryKeySelective(Map<String, String> map) {
		int count =            baseInfoMapper.updateByPrimaryKeySelective(map);
		return count>0?true:false;
	}


	@Override
	public boolean insertSelective(Map<String, String> map) {
		int count =  baseInfoMapper.insertSelective(map);
		return count>0?true:false;
	}


	@Override
	public boolean updateBaseInfo(Map<String, String> map) {
		int count =	baseInfoMapper.updateBaseInfo(map);
		return count>0?true:false;
	}
}
