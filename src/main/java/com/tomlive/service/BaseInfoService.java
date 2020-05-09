package com.tomlive.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

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
	List<BaseInfo>  selectAllBaseInfo() throws Exception;
	
    boolean  updateByPrimaryKeySelective(Map<String, String> map);
    
    boolean insertSelective(Map<String, String> map);
    
    boolean  updateBaseInfo(Map<String, String> map);
    
}
