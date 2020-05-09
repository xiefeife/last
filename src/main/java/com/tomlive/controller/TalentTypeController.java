package com.tomlive.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.entity.ProductType;
import com.tomlive.entity.TalentRecruitment;
import com.tomlive.entity.TalentType;
import com.tomlive.service.TalentRecruitmentService;
import com.tomlive.service.TalentTypeService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;
@ResponseBody
@CrossOrigin
@Controller
@RequestMapping("/talentType")
/**
 * 岗位类型控制层
 * @author XIE
 *
 * 2020年4月25日
 */
public class TalentTypeController {

	@Autowired
	private TalentTypeService talentTypeService;
	
	
	@SysLog(description="查看岗位类型")
	@RequestMapping(value = "/selectAllTalentType", method = RequestMethod.POST)
	public JsonUtil selectAllProductType() {
		System.out.println("**********************************************************");
		List<TalentType> list = talentTypeService.selectAllTalentType();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");
	}
	
	
	@SysLog(description="添加岗位类型")
	@RequestMapping("/insertSelectTalentType")
	public  JsonUtil   insertSelectTalentType(@RequestParam Map<String, String> map ) throws IllegalStateException, IOException {
     map.put("userId",map.get("userId"));
     map.put("creationTime",DateUtil.getNowDate() );
     map.put("param", "备注");
		boolean  success =talentTypeService.insertSelective(map);
		if(success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	
	
	@SysLog(description="删除")
	@RequestMapping(value="/deleteTalentTypeByPrimaryKey",method = RequestMethod.POST)
	public  JsonUtil deleteTalentTypeByPrimaryKey(@RequestParam("id") Integer id) {
	System.out.println("*******id"+id);
		boolean success=	talentTypeService.deleteByPrimaryKey(id);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	/**
	 * 统计每个岗位招聘的数量
	 * @return 成功与否
	 */
	@SysLog(description="每个岗位类型招聘的数量")
	@RequestMapping("/selectTalentTypeCount")
	public JsonUtil selectTalentRecruitmentCount() {
		
	List<TalentType> list=	talentTypeService.selectTalentTypeCount();
		if(null!=list) {
			return   new  JsonUtil("200", list, "岗位招聘数量查询成功");
		}
		return   new  JsonUtil("500", null, "岗位招聘数量查询失败");
	}
	
	

	/**
	 * 统计每个岗位招聘的数量
	 * @return 成功与否
	 */
	@SysLog(description="每个岗位类型招聘的数量")
	@RequestMapping("/updateByPrimaryKeySelective")
	public JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, Object> map) {
		
	boolean success=	talentTypeService.updateByPrimaryKeySelective(map);
		if(success) {
			return   new  JsonUtil("200", null, "成功");
		}
		return   new  JsonUtil("500", null, "失败");
	}
	
	
	
}
