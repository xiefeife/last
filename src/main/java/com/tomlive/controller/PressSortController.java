package com.tomlive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.dao.PressSortMapper;
import com.tomlive.entity.PressSort;
import com.tomlive.util.JsonUtil;

@ResponseBody
@Controller
@RequestMapping("pressSort")
public class PressSortController {

	@Autowired
	private PressSortMapper pressSortMapper;

	/**
	  * 查看所有新闻分类的方法
	 * @return
	 */
	@RequestMapping(value="selectAllPressSort.json",method = RequestMethod.POST)
	public  JsonUtil  selectAllPressSort() {
	List<PressSort>	 list=	pressSortMapper.selectAllPressSort();
			if(null!=list) {
				return new JsonUtil("200", list, "查询新闻分类成功");
			}
		return new JsonUtil("500", null, "查询新闻分类失败");
		
		
		
	}

}
