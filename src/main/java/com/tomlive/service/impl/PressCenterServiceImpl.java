package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomlive.dao.PressCenterMapper;
import com.tomlive.entity.PressCenter;
import com.tomlive.service.PressCenterService;

/**
 * 新闻中心业务逻辑层实现类接口
 * 
 * @author Xie
 * @date2020年4月17日
 */
@Service
@Transactional
public class PressCenterServiceImpl implements PressCenterService {

	@Autowired
	private PressCenterMapper pressCenterMapper;

	@Override
	public List<PressCenter> selectAll() {
		return pressCenterMapper.selectAllPressCenter();
	}


	/**
	 * 查看新闻中心数量的方法
	 * 
	 * @return
	 */
	@Override
	public int selectPressCenterCount() {
		int count = pressCenterMapper.selectPressCenterCount();
		return count;
	}

	@Override
	public List<PressCenter> selectPressCenterByCondition(Map<String, String> map) {
		List<PressCenter> list = pressCenterMapper.selectPressCenterByCondition(map);
		if (null != list) {
			return list;
		}

		return null;
	}

	/**
	 * 有选择的添加新闻
	 */
	@Override
	public boolean insertSelective(Map<String, String> map) {

		int count = pressCenterMapper.insertSelective(map);
		if (0 < count) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int count = pressCenterMapper.deleteByPrimaryKey(id);
		return count > 0 ? true : false;
	}

	/**
	 * 根据主键有选择性的修改
	 */
	@Override
	public boolean updateByPrimaryKeySelective(Map<String, String> map) {
		
		int count = pressCenterMapper.updateByPrimaryKeySelective(map);
		return count > 0 ? true : false;
	}

	@Override
	public boolean updatePressCenterStatus(Integer id) {
		int count =pressCenterMapper.updatePressCenterStatus(id);
		return count > 0 ? true : false;
	}

	@Override
	public boolean activetePressCenterStatus(Integer id) {
		int count =pressCenterMapper.activetePressCenterStatus(id);
		return count > 0 ? true : false;
	}

	@Override
	public int selectPressCenterStatus(Integer id) {
		// TODO Auto-generated method stub
		return pressCenterMapper.selectPressCenterStatus(id);
	}

}
