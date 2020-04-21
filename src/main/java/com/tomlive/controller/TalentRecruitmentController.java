package com.tomlive.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.entity.TalentRecruitment;
import com.tomlive.service.TalentRecruitmentService;
import com.tomlive.util.JsonUtil;

@Controller
@ResponseBody
@RequestMapping("talentRecruitment")
public class TalentRecruitmentController {

	@Autowired
	private TalentRecruitmentService talentRecruitmentService;

	/**
	 * 查看所有人才招聘信息的方法
	 * @return 成功的json信息
	 */
	@SysLog(description="查看所有新闻中心")
	@RequestMapping(value = "selectAllTalentRecruitment", method = RequestMethod.POST)
	public JsonUtil selectAllTalentRecruitment() {
		List<TalentRecruitment> list = talentRecruitmentService.selectAllTalentRecruitment();
		if (null != list) {
			return new JsonUtil("200", list, "查询查看所有人才招聘信息成功");
		}
		return new JsonUtil("500", null, "查询查看所有人才招聘信息失败");
	}
	/**
	   * 添加岗位招聘的方法
	 * @param talentRecruitment
	 * @return  成功的json格式
	 */
	@RequestMapping(value = "insertSelect", method = RequestMethod.POST)
	public JsonUtil insertSelectTalentRecruitment(
			@PathVariable("talentRecruitment") TalentRecruitment talentRecruitment) {
	    
		System.out.println("进入添加人才招聘的方法");
		boolean choose = talentRecruitmentService.insertSelective(talentRecruitment);
		if (choose) {
				return new JsonUtil("200", null, "添加人才招聘信息成功");
		}
		return new JsonUtil("500", null, "添加人才招聘信息失败");
	}
	
	/**
	 * 统计岗位招聘的数量
	 * @return 成功与否
	 */
	//@SysLog(description="查看新闻中心的次数")
	@RequestMapping("selectTalentRecruitmentCount")
	public JsonUtil selectTalentRecruitmentCount() {
		
	int count=	talentRecruitmentService.selectTalentRecruitmentCount();
		if(0<count) {
			return   new  JsonUtil("200", count, "岗位招聘数量查询成功");
		}
		return   new  JsonUtil("500", null, "岗位招聘数量查询失败");
	}

	
	/**
	 * 统计每个岗位的招聘数量
	 * @return
	 */
	@RequestMapping(value="selectSizeGroupBy",method = RequestMethod.POST)
	public JsonUtil selectSizeGroupBy() {
		
		List<TalentRecruitment> list=	talentRecruitmentService.selectSizeGroupBy();
		if(null!=list) {
          return   new  JsonUtil("200", list, "每个岗位招聘数量查询成功");
	}
		return   new  JsonUtil("500", null, "每个岗位招聘数量查询失败");
}
}