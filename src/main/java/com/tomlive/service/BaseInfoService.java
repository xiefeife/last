package com.tomlive.service;

import com.tomlive.entity.BaseInfo;

/**
    * 公司基本信息业务逻辑层接口
 *  @author Xie
 *  @date2020年4月17日
 */
public interface BaseInfoService {

	
	/**
	   * 查看公司基本信息的方法
	 * @return 公司对象
	 */
    BaseInfo  selectAllBaseInfo() throws Exception;
	
}
