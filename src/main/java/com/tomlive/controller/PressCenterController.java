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

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.tomlive.annotation.SysLog;
import com.tomlive.entity.PressCenter;
import com.tomlive.service.PressCenterService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;
import com.tomlive.util.UploadFile;

/**
 * 新闻中心控制层
 * 
 * @author Xie
 * @date2020年4月16日
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("/pressCenter")
public class PressCenterController {

	@Autowired
	private PressCenterService pressCenterService;

	/**
	 * 查看所有新闻中心的方法
	 * 
	 * @return 成功与否
	 */
	@SysLog(description = "查看所有新闻中心")
	@RequestMapping(value = "selectAllPressCenter", method = RequestMethod.POST)
	public JsonUtil selectAllPressCenter() {
		List<PressCenter> list = pressCenterService.selectAll();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");

	}

	/**
	 * 选择性的添加新闻中心的方法 其中包含图片的上传
	 * 
	 * @param pressCenter 新闻中心对象
	 * @return 成功与否
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@SysLog(description = "添加新闻,带图片")
	@RequestMapping(value = "/insertSelectPressCenter", consumes = "multipart/form-data")
	public JsonUtil insertSelectPressCenter(@RequestParam Map<String, String> map,
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
	  
		map.put("photo", UploadFile.upload(file));// 照片地址
		map.put("status", "1");// 新闻状态
		map.put("creationTime", DateUtil.getNowDate());// 创建时间
		map.put("TypeId", map.get("pressTypeId"));// 新闻版块 分类
		map.put("userId", map.get("userId"));// 获得当前添加人
		map.put("particulars", map.get("particulars"));
		boolean choose = pressCenterService.insertSelective(map);
		if (choose) {
			return new JsonUtil("200", null, "添加新闻中心的方法成功");
		}
		return new JsonUtil("500", null, "添加新闻中心的方法是吧");
	}
	
	/**
	 * 选择性的添加新闻中心的方法 其中不包含图片的上传
	 * @param pressCenter 新闻中心对象
	 * @return 成功与否
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@SysLog(description = "添加新闻")
	@RequestMapping(value = "/noIssueSelectPressCenter", consumes = "multipart/form-data")
	public JsonUtil noIssueSelectPressCenter(@RequestParam Map<String, String> map, 
			@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("@@@@@@@@@@@@@@@@@@map" + map);
	
		
		map.put("photo", UploadFile.upload(file));// 照片地址
		map.put("status", "0");// 新闻状态
		map.put("creationTime", DateUtil.getNowDate());// 创建时间
		map.put("pressTypeId", map.get("pressTypeId"));// 新闻版块 分类
		map.put("userId", map.get("userId"));// 获得当前添加人
		boolean choose = pressCenterService.insertSelective(map);
		if (choose) {
			return new JsonUtil("200", null, "添加新闻中心的方法成功");
		}

		return new JsonUtil("500", null, "添加新闻中心的方法是吧");
	}
	
	/**
	 * 查看新闻中心数量的方法
	 * 
	 * @return
	 */
	@SysLog(description = "查看新闻中心数量")
	@RequestMapping(value = "selectPressCenterCount", method = RequestMethod.POST)
	public JsonUtil selectPressCenterCount() {
		int count = pressCenterService.selectPressCenterCount();
		if (0 < count) {
			return new JsonUtil("200", count, "查询新闻中心数量成功");
		}
		return new JsonUtil("500", null, "查询新闻中心数量失败");
	}
	
	@SysLog(description = "根据条件查看新闻")
	@RequestMapping(value = "selectPressCenterByCondition", method = RequestMethod.POST)
	public JsonUtil selectPressCenterByCondition(@RequestParam Map<String, String> map) {

		List<PressCenter> list = pressCenterService.selectPressCenterByCondition(map);
		if (null != list) {
			return new JsonUtil("200", list, "查询新闻中心数量成功");
		}
		return new JsonUtil("500", null, "查询新闻中心数量失败");
	}

	@SysLog(description = "删除新闻信息")
	@RequestMapping(value = "/deletePressCenterByPrimaryKey", method = RequestMethod.POST)
	public JsonUtil deleteByPrimaryKey(@RequestParam("id") Integer id) {
		boolean success = pressCenterService.deleteByPrimaryKey(id);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}

	
	
	@SysLog(description = "修改新闻信息,带文件上传")
	@RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.POST)
	public JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, String> map,
			@RequestParam("file") MultipartFile file)
			throws UniformInterfaceException, ClientHandlerException, IOException {
	
		
		map.put("photo", UploadFile.upload(file));// 照片地址
		map.put("status", "1");// 新闻状态
		map.put("creationTime", DateUtil.getNowDate());// 创建时间
		map.put("pressTypeId", map.get("pressTypeId"));// 新闻版块 分类
		map.put("userId", map.get("userId"));// 获得当前添加人
		boolean success = pressCenterService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}
	/**
	 * 修改新闻信息 不带文件上传
	 * @param map
	 * @return
	 * @throws UniformInterfaceException
	 * @throws ClientHandlerException
	 * @throws IOException
	 */
	@SysLog(description = "修改新闻信息不带文件上传")
	@RequestMapping(value = "/updateNoFile", method = RequestMethod.POST)
	public JsonUtil updateNoFile(@RequestParam Map<String, String> map)
			throws UniformInterfaceException, ClientHandlerException, IOException {
		map.put("status", "1");// 新闻状态
		map.put("creationTime", DateUtil.getNowDate());// 创建时间
		map.put("pressTypeId", map.get("pressTypeId"));// 新闻版块 分类
		map.put("userId", map.get("userId"));// 获得当前添加人
		boolean success = pressCenterService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}

	
	/**
	 * 修改用户状态
	 * 
	 * @param id 用户的id
	 * @return 修改成功与否
	 * @throws Exception
	 */
	@SysLog(description = "修改状态")
	@RequestMapping("/updatePressCenterStatus")
	public JsonUtil updatePressCenterStatus(@RequestParam("id") Integer id) throws Exception {
		// 根据传来的id查看这个用户的状态
		int number = pressCenterService.selectPressCenterStatus(id);
		System.out.println(")))))))))))))前端传来的新闻的状态" + number);
		// 返回的是1 2
		if (0 == number) {// 激活
			boolean success = pressCenterService.activetePressCenterStatus(id);
			if (success) {
				return new JsonUtil("200", null, "激活成功");
			}
			// 如果返回的是1
		} else if (1 == number) {// 冻结
			boolean success = pressCenterService.updatePressCenterStatus(id);
			if (success) {
				return new JsonUtil("201", null, "冻结成功");
			}
		}
		return new JsonUtil("500", null, "状态修改失败");
	}

	
	
	
}
