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
import com.tomlive.service.ProductTypeService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;

@CrossOrigin
@ResponseBody
@Controller
@RequestMapping("/productType")
public class ProductTypeController {

	@Autowired
	private   ProductTypeService productTypeService;
	
	
	/**
	 * 查看产所有产品类别
	 * @return
	 */
	@SysLog(description="查看产品类型")
	@RequestMapping(value = "/selectAllProductType", method = RequestMethod.POST)
	public JsonUtil selectAllProductType() {
		System.out.println("**********************************************************");
		List<ProductType> list = productTypeService.selectAllProductType();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");
	}
	
	
	/**
	 * 添加产品类型
	 * @param map
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@SysLog(description="添加产品类型")
	@RequestMapping("/insertSelectProductType")
	public  JsonUtil   insertSelectProductType(@RequestParam Map<String, String> map ) throws IllegalStateException, IOException {
     System.out.println("((((((((((((ProductType"+map);
     //添加产品类型的时候需要把用户的id传到后台
     map.put("userId", map.get("userId"));
     map.put("creationTime",DateUtil.getNowDate() );
     
		boolean  success =productTypeService.insertSelective(map);
		if(success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	/**
	 * 删除产品类别
	 * @param id
	 * @return
	 */
	@SysLog(description="删除产品类别")
	@RequestMapping(value="/deleteProductTypeByPrimaryKey",method = RequestMethod.POST)
	public  JsonUtil deleteProductTypeByPrimaryKey(@RequestParam("id") Integer id) {
	System.out.println("*******id"+id);
		boolean success=	productTypeService.deleteByPrimaryKey(id);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	@SysLog(description="修改产品类别")
	@RequestMapping(value="/updateByPrimaryKeySelective",method = RequestMethod.POST)
	public  JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, Object> map) {
		boolean success=	productTypeService.updateByPrimaryKeySelective(map);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	
	
	
}
