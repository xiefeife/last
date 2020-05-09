package com.tomlive.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.dao.PressTypeMapper;
import com.tomlive.entity.PressType;
import com.tomlive.service.PressTypeService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;

/**
 * 新闻分类控制层
 *  @author Xie
 *  @date2020年4月23日
 */
@ResponseBody
@Controller
@RequestMapping("/pressType")
public class PressTypeController {

	@Autowired
	private PressTypeService pressTypeService;

	/**
	  * 查看所有新闻分类的方法
	 * @return
	 */
	@SysLog(description="查看所有新闻类别的方法")
	@RequestMapping(value="/selectAllPressType",method = RequestMethod.POST)
	public  JsonUtil  selectAllPressType() {
	List<PressType>	 list=	pressTypeService.selectAllPressType();
			if(null!=list) {
				return new JsonUtil("200", list, "查询新闻分类成功");
			}
		return new JsonUtil("500", null, "查询新闻分类失败");
	}

	@SysLog(description="添加新闻类型")
	@RequestMapping("/insertSelectProductType")
	public  JsonUtil   insertSelectProductType(@RequestParam Map<String, String> map ) throws IllegalStateException, IOException {
     System.out.println("((((((((((((ProductType"+map);
     map.put("userId", map.get("userId"));
     map.put("createTime",DateUtil.getNowDate() );
     map.put("pressDescribe", "这是描述");
		boolean  success =pressTypeService.insertSelective(map);
		if(success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	/**
	   * 删除新闻版块
	 * @param id
	 * @return
	 */
	@SysLog(description="删除")
	@RequestMapping(value="/deleteProductTypeByPrimaryKey",method = RequestMethod.POST)
	public  JsonUtil deleteProductTypeByPrimaryKey(@RequestParam("id") Integer id) {
	System.out.println("*******id"+id);
		boolean success=pressTypeService.deleteByPrimaryKey(id);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	@SysLog(description="修改产品类别")
	@RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.POST)
	public  JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, Object> map) {
		boolean success=	pressTypeService.updateByPrimaryKeySelective(map);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	
}
