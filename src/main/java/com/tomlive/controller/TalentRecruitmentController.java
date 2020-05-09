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

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.tomlive.annotation.SysLog;
import com.tomlive.entity.TalentRecruitment;
import com.tomlive.service.TalentRecruitmentService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("/talentRecruitment")
public class TalentRecruitmentController {

	@Autowired
	private TalentRecruitmentService talentRecruitmentService;

	/**
	 * 查看所有人才招聘信息的方法
	 * @return 成功的json信息
	 */
	@SysLog(description="查看所有岗位")
	@RequestMapping(value = "/selectAllTalentRecruitment", method = RequestMethod.POST)
	public JsonUtil selectAllTalentRecruitment(@RequestParam Map<String, String> map) {
		
		List<TalentRecruitment> list = talentRecruitmentService.selectAllTalentRecruitment();
		System.out.println(list);
		if (null != list) {
			return new JsonUtil("200", list, "查询查看所有人才招聘信息成功");
		}
		return new JsonUtil("500", null, "查询查看所有人才招聘信息失败");
	}
	
	
	/**
	   *    添加岗位招聘的方法
	 * @param talentRecruitment
	 * @return  成功的json格式
	 */
	@SysLog(description="添加岗位方法,马上就发布")
	@RequestMapping(value = "/insertSelectTalentRecruitment", method = RequestMethod.POST)
	public JsonUtil insertSelectTalentRecruitment(
			@RequestParam Map<String, String> map) {
		
		map.put("jobTypeId", map.get("jobTypeId"));
		map.put("status", "1");//添加新闻的状态
		map.put("creationTime", DateUtil.getNowDate() );//添加的时间
		map.put("userId", map.get("userId"));//新闻添加者
		boolean choose = talentRecruitmentService.insertSelective(map);
		if (choose) {
				return new JsonUtil("200", null, "添加人才招聘信息成功");
		}
		return new JsonUtil("500", null, "添加人才招聘信息失败");
	}

	@ResponseBody
	@SysLog(description="根据条件查询")
	@RequestMapping(value="/selectTalentRecruitmentByCondition",method = RequestMethod.POST)
	public  JsonUtil  selectTalentRecruitmentByCondition(@RequestParam Map<String, String> map) {
		
		List<TalentRecruitment> list=  talentRecruitmentService.selectTalentRecruitmentByCondition(map);		
				if(null!=list) {
	          return   new  JsonUtil("200", list, "新闻数量查询成功");
		}
		return   new  JsonUtil("500", null, "新闻数量查询失败");
	}
	
	@SysLog(description="删除岗位招聘信息")
	@RequestMapping(value="deleteTalentRecruitmentByPrimaryKey",method = RequestMethod.POST)
	public  JsonUtil deleteByPrimaryKey(@RequestParam("id") Integer id) {
	 boolean success=	talentRecruitmentService.deleteByPrimaryKey(id);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}

	
	@SysLog(description="查看招聘岗位的总数量")
	@RequestMapping(value="selectAllTalentRecruitmentSum",method = RequestMethod.POST)
	public  JsonUtil selectAllTalentRecruitmentSum() {
	 int count=	talentRecruitmentService.selectAllTalentRecruitmentSum();
		if(0<count){
			return new JsonUtil("200", count, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	
	@SysLog(description="查看每个招聘岗位的数量")
	@RequestMapping(value="/selectAllTalentRecruitmentCount",method = RequestMethod.POST)
	public  JsonUtil selectAllTalentRecruitmentCount() {
	 List<TalentRecruitment> list=	talentRecruitmentService.selectAllTalentRecruitmentCount();
		if(null!=list){
			System.out.println(list);
			return new JsonUtil("200", list, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	/**
	 *添加岗位招聘的方法
	 * @param talentRecruitment
	 * @return  成功的json格式
	 */
	@SysLog(description="添加岗位方法,不发布")
	@RequestMapping(value = "/insertSelectTalentRecruitmentStatus", method = RequestMethod.POST)
	public JsonUtil insertSelectTalentRecruitmentStatus(
			@RequestParam Map<String, String> map) {
		
		map.put("jobTypeId", map.get("jobTypeId"));
		map.put("status", "0");//添加新闻的状态
		map.put("creationTime", DateUtil.getNowDate() );//添加的时间
		map.put("userId", map.get("userId"));//新闻添加者
		boolean choose = talentRecruitmentService.insertSelective(map);
		if (choose) {
				return new JsonUtil("200", null, "添加人才招聘信息成功");
		}
		return new JsonUtil("500", null, "添加人才招聘信息失败");
	}

	
	@SysLog(description = "修改岗位信息,岗位发布")
	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
	public JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, String> map)
			throws UniformInterfaceException, ClientHandlerException, IOException {
		map.put("status", "1");//添加新闻的状态
		boolean success = talentRecruitmentService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	@SysLog(description = "修改岗位信息,岗位保存")
	@RequestMapping(value = "/updateByPrimaryKeyStatus", method = RequestMethod.POST)
	public JsonUtil updateByPrimaryKeyStatus(@RequestParam Map<String, String> map)
			throws UniformInterfaceException, ClientHandlerException, IOException {
	
		map.put("status", "0");//添加新闻的状态
		boolean success = talentRecruitmentService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
}