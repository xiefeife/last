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
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.fastjson.JSON;
import com.tomlive.annotation.SysLog;
import com.tomlive.entity.ProductInfo;
import com.tomlive.service.ProductInfoService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;
import com.tomlive.util.UploadFile;
@CrossOrigin
@ResponseBody
@Controller
@RequestMapping("/productInfo")
public class ProductInfoController {

	@Autowired
	private ProductInfoService productInfoService;

	/**
	 * 查看全部产品信息详情的方法
	 * @return
	 */
	@SysLog(description="产品列表")
	@RequestMapping(value = "/selectAllProductInfo", method = RequestMethod.POST)
	public JsonUtil selectAllProductInfo() {
		System.out.println("**********************************************************");
		
		List<ProductInfo> list = productInfoService.selectAllProductInfo();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");
	}
	
	/**
	 * 查看多少产品信息的方法
	 * @return  受影响的行数
	 */
	@SysLog(description="查看产品分组数量")
	@RequestMapping(value="selectProductInfoCount",method = RequestMethod.POST)
	public JsonUtil   selectProductInfoCount() {
	int  count= 	productInfoService.selectProductInfoCount();
	if(0<count) {
		return new JsonUtil("200", count, "产品数量查询成功");
	}
	 return new JsonUtil("500", null, "产品数量查询失败");
	}
	
	/**
	 * 根据条件查看产品数量
	 * @param name
	 * @param productType
	 * @param beginTime
	 * @param endTime
	 * @param status
	 * @return
	 */
	@SysLog(description="根据条件查询产品")
	@RequestMapping(value="selectProductInfoByCondition",method = RequestMethod.POST)
	public JsonUtil  selectProductInfoByCondition(@RequestParam Map<String, String> map) {
		List<ProductInfo>	list= productInfoService.selectProductInfoByCondition(map);
		System.out.println(map.get("productTypeId"));
		if(null!=list) {
			return new JsonUtil("200", list, "产品数量查询成功");
		}
		return new JsonUtil("500", null, "产品数量查询失败");
		
	}
	
	/**
	 * 删除产品信息
	 * @param id
	 * @return
	 */
	@SysLog(description="删除产品信息")
	@RequestMapping(value="/deleteProductInfoByPrimaryKey",method = RequestMethod.POST)
	public  JsonUtil deleteByPrimaryKey(@RequestParam("id") Integer id) {
	 boolean success=	productInfoService.deleteByPrimaryKey(id);
		if(success){
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	/**
	 * 选择性的添加产品信息的方法 其中包含图片的上传
	 * 
	 * @param pressCenter 新闻中心对象
	 * @return 成功与否
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@SysLog(description = "添加产品信息")
	@RequestMapping(value = "/insertSelectProductInfo", consumes = "multipart/form-data")
	public JsonUtil insertSelectProductInfo(@RequestParam Map<String, String> map,
			@RequestParam("file") MultipartFile file,
			@RequestParam("productParameters") MultipartFile productParameters,
			@RequestParam("productExternal") MultipartFile productExternal) throws IllegalStateException, IOException {
		
		
		map.put("productExternal", UploadFile.upload(productExternal));// 照片地址
		map.put("productParameters", UploadFile.upload(productParameters));// 照片地址
		
		
		map.put("photo", UploadFile.upload(file));// 照片地址
		map.put("status", "1");//0 表示未发布  1表示发布
		map.put("creationTime", DateUtil.getNowDate());// 创建时间
		map.put("userId", map.get("userId"));// 获得当前添加人
		boolean choose = productInfoService.insertSelective(map);
		
		if (choose) {
			return new JsonUtil("200", null, "添加产品信息的方法成功");
		}
		return new JsonUtil("500", null, "添加产品信息的方法失败");
	}
	
	
	
	/***
	 * 
	 * @param map
	 * @param file
	 * @param productParameters
	 * @param productExternal
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@SysLog(description = "添加产品,走的保存")
	@RequestMapping(value = "/insertSelectProductInfo1", consumes = "multipart/form-data")
	public JsonUtil insertSelectProductInfo1(@RequestParam Map<String, String> map,
			@RequestParam("file") MultipartFile file,
			@RequestParam("productParameters") MultipartFile productParameters,
			@RequestParam("productExternal") MultipartFile productExternal) throws IllegalStateException, IOException {
		
		
		
		map.put("productExternal", UploadFile.upload(productParameters));// 照片地址
		map.put("productParameters", UploadFile.upload(productExternal));// 照片地址
		map.put("photo", UploadFile.upload(file));// 照片地址
		map.put("status", "0");//0 表示未发布  1表示发布
		map.put("creationTime", DateUtil.getNowDate());// 创建时间
		map.put("userId", map.get("userId"));// 获得当前添加人
		boolean choose = productInfoService.insertSelective(map);
		
		if (choose) {
			return new JsonUtil("200", null, "添加产品信息的方法成功");
		}
		return new JsonUtil("500", null, "添加产品信息的方法失败");
	}
	/**
	 * 修改产品状态
	 * 
	 * @param id 产品的id
	 * @return 修改成功与否
	 * @throws Exception
	 */
	@SysLog(description = "修改产品状态")
	@RequestMapping("/updateProductInfoStatus")
	public JsonUtil updateProductInfoStatus(@RequestParam("id") Integer id) throws Exception {
		// 根据传来的id查看这个用户的状态
		
		int number = productInfoService.selectProductInfoStatus(id);
		System.out.println(")))))))))))))前端传来的新闻的状态" + number);
		// 返回的是1 2
		if (0 == number) {// 激活
			boolean success = productInfoService.activeteProductInfoStatus(id);
			if (success) {
				return new JsonUtil("200", null, "激活成功");
			}
			// 如果返回的是1
		} else if (1 == number) {// 冻结
			boolean success = productInfoService.updateProductInfoStatus(id);
			if (success) {
				return new JsonUtil("201", null, "冻结成功");
			}
		}
		return new JsonUtil("500", null, "状态修改失败");
	}
	
	
	@SysLog(description = "修改产品信息,带图片修改")
	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
	public JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, String> map,
			@RequestParam("file") MultipartFile file)
			throws  IOException {
		System.out.println("%%%%%%%%%%%%%%map" + map);
		System.out.println("file" + file);
		
		
		map.put("photo", UploadFile.upload(file));
		map.put("status", "1");//0 表示未发布  1表示发布
		boolean success = productInfoService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	
	@SysLog(description = "修改产品信息,不带图片修改")
	@RequestMapping(value = "/updateByPrimaryKeySelective1", method = RequestMethod.POST)
	public JsonUtil updateByPrimaryKeySelective1(@RequestParam Map<String, String> map)
			throws  IOException {
		System.out.println("%%%%%%%%%%%%%%map" + map);
		map.put("status", "1");//0 表示未发布  1表示发布
		boolean success = productInfoService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
}
