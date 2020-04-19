package com.tomlive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.entity.ProductInfo;
import com.tomlive.service.ProductInfoService;
import com.tomlive.util.JsonUtil;
@ResponseBody
@Controller
@RequestMapping("productInfo")
public class ProductInfoController {

	@Autowired
	private ProductInfoService productInfoService;

	/**
	 * 查看全部产品信息详情的方法
	 * @return
	 */
	@SysLog(description="查看产品详情")
	@RequestMapping(value = "selectAllProductInfo", method = RequestMethod.POST)
	public JsonUtil selectAllProductInfo() {
		List<ProductInfo> list = productInfoService.selectAllProductInfo();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");

	}
	
	/**
	 * 有选择的添加产品信息的方法
	 * @param productInfo
	 * @return
	 */
	@SysLog(description="添加产品详情")
	@RequestMapping(value="insertSelectProductInfo",method = RequestMethod.POST)
	public JsonUtil  insertSelectProductInfo(@RequestParam ProductInfo  productInfo) {
		
 	boolean   choose= productInfoService.insertSelective(productInfo);
 		if(choose) {
 			return   new JsonUtil("200", null, "添加产品信息成功");
 		}
 		return   new JsonUtil("500", null, "添加产品信息失败");
	}

	/**
	 * 查看多少产品信息的方法
	 * @return  受影响的行数
	 */
	@SysLog(description="查看产品数量")
	@RequestMapping(value="selectProductInfoCount",method = RequestMethod.POST)
	public JsonUtil   selectProductInfoCount() {
	int  count= 	productInfoService.selectProductInfoCount();
	if(0<count) {
		return new JsonUtil("200", count, "产品数量查询成功");
	}
	 return new JsonUtil("500", null, "产品数量查询失败");
		
	}
	
	
}
