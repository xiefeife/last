package com.tomlive.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomlive.dao.PressCenterMapper;
import com.tomlive.entity.PressCenter;
import com.tomlive.service.PressCenterService;

/**
 *      新闻中心业务逻辑层实现类接口
 *  @author Xie
 *  @date2020年4月17日
 */
@Service
@Transactional
public class PressCenterServiceImpl implements  PressCenterService{

	@Autowired
	private PressCenterMapper pressCenterMapper;
	
	@Override
	public List<PressCenter> selectAll() {
		return pressCenterMapper.selectAllPressCenter();
	}

	/**
	 * 选择性的添加新闻中心的方法
	 * 
	 * @param record 想 新闻中心的对象
	 * @return 受影响的行数
	 */
	@Override
	public Boolean insertSelective(PressCenter pressCenter) {
	int  count= pressCenterMapper.insertSelective(pressCenter);
		return  count>0?true:false;
	}

	
	/**
	 * 根据新闻中心对象主键有选择的修改信息
	 * 
	 * @param record 新闻对象主键
	 * @return 成功与否
	 */
	@Override
	public boolean updateByPrimaryKeySelective(PressCenter record) {
	int  count=	           pressCenterMapper.updateByPrimaryKeySelective(record);
		return count>0?true:false;
	}

	/**
	 * 查看新闻中心数量的方法
	 * 
	 * @return
	 */
	@Override
	public int selectPressCenterCount() {
     int  count=		pressCenterMapper.selectPressCenterCount();
		return count;
	}


}
