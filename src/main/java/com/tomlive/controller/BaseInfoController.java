package com.tomlive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomlive.entity.BaseInfo;
import com.tomlive.service.BaseInfoService;
import com.tomlive.util.JsonUtil;

/**
 * 公司基本信息控制层
 *  @author Xie
 *  @date2020年4月17日
 */
@RequestMapping("baseInfo")
@Controller
public class BaseInfoController {

	
	@Autowired
	private BaseInfoService prBaseInfoService; 
	
	/**
	   * 查看公司基本信息的方法
	 * @return 公司查看成功与否,json格式
	 */
	@RequestMapping("selectAllBaseInfo.json")
	public JsonUtil  selectAllBaseInfo() throws Exception { 
	  BaseInfo baseinfo=	prBaseInfoService.selectAllBaseInfo();
		if(null!=baseinfo) {
			return  new JsonUtil("200", baseinfo, "公司基本信息查看成功");
		}
		return  new JsonUtil("500", null, "公司基本信息查看失败");
	}
	
	
	
	
	
}
