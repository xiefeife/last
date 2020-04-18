package com.tomlive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public BaseInfo selectAllBaseInfo() {
		
		return baseInfoMapper.selectAllBaseInfo();
	}
}
