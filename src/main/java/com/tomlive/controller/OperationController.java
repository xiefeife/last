package com.tomlive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.dao.OperationMapper;
import com.tomlive.util.JsonUtil;

/**
 *   日志控制层
 * @author XIE
 *
 * 2020年4月17日
 */
@ResponseBody
@Controller
@RequestMapping(value="operation",method = RequestMethod.POST)
public class OperationController {

	@Autowired
	private  OperationMapper  operationMapper;
	
	
	@RequestMapping(value="selectAllOperation.json")
	public JsonUtil  selectAllOperation() {
		       
		
		return null;
		
	}
	
	
}
