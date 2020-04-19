package com.tomlive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.dao.OperationMapper;
import com.tomlive.entity.Operation;
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
	
	/**
	 * 查看全部日志的方法
	 * @return
	 */
	@SysLog(description="查看全部日志")
	@RequestMapping(value="selectAllOperation.json")
	public JsonUtil  selectAllOperation() {
	     List<Operation> list=    operationMapper.selectAllOperation();
	 	    if(null!=list) {
	 	    	return new JsonUtil("200", list, "查看全部日志成功");
	 	    }
		 return new JsonUtil("500", null, "查看全部日志失败");
		
	}
	
	
}
