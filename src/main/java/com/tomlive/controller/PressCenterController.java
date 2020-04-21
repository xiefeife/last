package com.tomlive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.entity.PressCenter;
import com.tomlive.service.PressCenterService;
import com.tomlive.util.JsonUtil;

/**
 * 新闻中心控制层
 * 
 * @author Xie
 * @date2020年4月16日
 */
@Controller
@ResponseBody
@RequestMapping("pressCenter")
public class PressCenterController {

	@Autowired
	private PressCenterService pressCenterService;

	/**
	 * 查看所有新闻中心的方法
	 * 
	 * @return 成功与否
	 */
	@SysLog(description="查看所有新闻中心")
	@RequestMapping(value = "selectAllPressCenter", method = RequestMethod.POST)
	public JsonUtil selectAllPressCenter() {
		List<PressCenter> list = pressCenterService.selectAll();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");

	}

	/**
	 * 选择性的添加新闻中心的方法
	 * 
	 * @param pressCenter 新闻中心对象
	 * @return 成功与否
	 */
	@SysLog(description="添加新闻")
	@RequestMapping(value = "insertSelectPressCenter", method = RequestMethod.POST)
	public JsonUtil insertSelectPressCenter(@RequestBody PressCenter pressCenter) {
		boolean choose = pressCenterService.insertSelective(pressCenter);
		if (choose) {
			return new JsonUtil("200", null, "添加新闻中心的方法成功");
		}
		return new JsonUtil("500", null, "添加新闻中心的方法是吧");
	}

	

	/**
	 * 查看新闻中心数量的方法
	 * 
	 * @return
	 */
	//@SysLog(description="查看新闻中心数量")
	@RequestMapping(value="selectPressCenterCount", method = RequestMethod.POST)
	  public  JsonUtil  selectPressCenterCount() {
		  
       int  count=		  pressCenterService.selectPressCenterCount();
		if(0<count) {
			return new   JsonUtil("200", count, "查询新闻中心数量成功");
		}
		return new   JsonUtil("500", null, "查询新闻中心数量失败");
	  }

}
