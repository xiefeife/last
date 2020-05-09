package com.tomlive.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tomlive.entity.BaseInfo;
import com.tomlive.service.BaseInfoService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;
import com.tomlive.util.UploadFile;

/**
 * 公司基本信息控制层
 * 
 * @author Xie
 * @date2020年4月17日
 */
@CrossOrigin
@ResponseBody
@RequestMapping("/baseInfo")
@Controller
public class BaseInfoController {

	@Autowired
	private BaseInfoService prBaseInfoService;

	/**
	 * 查看公司基本信息的方法
	 * 
	 * @return 公司查看成功与否,json格式
	 */
	@RequestMapping("/selectAllBaseInfo")
	public JsonUtil selectAllBaseInfo() throws Exception {
		List<BaseInfo> list = prBaseInfoService.selectAllBaseInfo();
		if (null != list) {
			return new JsonUtil("200", list, "公司基本信息查看成功");
		}
		return new JsonUtil("500", null, "公司基本信息查看失败");
	}



	@RequestMapping( "/upload2")
	public JsonUtil updateByPrimaryKeySelective(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("(((((((((((((((map" + map);
		 map.put("creationTime", DateUtil.getNowDate());// 创建时间
		boolean success = prBaseInfoService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "公司基本信息保存成功");
		}
		return new JsonUtil("500", null, "公司基本信息保存失败");
	}
	
//	String fileName = companyPhilosophy.getOriginalFilename();
//	String end = path + fileName;
//	WebResource webResource = client.resource(path + fileName);
//	webResource.put(companyPhilosophy.getBytes());
//
//	String fileName2 = companyDevelopment.getOriginalFilename();
//	String end2 = path + fileName2;
//	Client client2 = Client.create();
//	WebResource webResource2 = client2.resource(path + fileName);
//	webResource2.put(companyDevelopment.getBytes());
	
	
	//这个是companyDevelopment的接口
	@RequestMapping( "/companyDevelopment")
	public JsonUtil companyDevelopment(@RequestParam Map<String, String> map,
			@RequestParam("companyDevelopment") MultipartFile companyDevelopment
			) throws Exception {
		System.out.println("(((((((((((((((map" + map);
		 map.put("companyDevelopment", UploadFile.upload(companyDevelopment));
		 map.put("creationTime", DateUtil.getNowDate());// 创建时间
		boolean success = prBaseInfoService.updateByPrimaryKeySelective(map);
		if (success) {
			return new JsonUtil("200", null, "公司基本信息保存成功");
		}
		return new JsonUtil("500", null, "公司基本信息保存失败");
	}
	
	
	
	//这个是companyPhilosophy的接口
		@RequestMapping( "/companyPhilosophy")
		public JsonUtil companyPhilosophy(@RequestParam Map<String, String> map,
				@RequestParam("companyPhilosophy") MultipartFile companyPhilosophy
				) throws Exception {
			System.out.println("(((((((((((((((map" + map);
			
			 map.put("companyPhilosophy", UploadFile.upload(companyPhilosophy));
			 map.put("creationTime", DateUtil.getNowDate());// 创建时间
			 
			boolean success = prBaseInfoService.updateByPrimaryKeySelective(map);
			if (success) {
				return new JsonUtil("200", null, "公司基本信息保存成功");
			}
			return new JsonUtil("500", null, "公司基本信息保存失败");
		}
	
	
		//这个是companyAptitude的接口
		@RequestMapping( "/companyAptitude")
		public JsonUtil companyAptitude(@RequestParam Map<String, String> map,
				@RequestParam("companyAptitude") MultipartFile[] companyAptitude
				) throws Exception {
			Client client = Client.create();
			String path = "http://39.106.50.89:8011/images/";
			System.out.println(companyAptitude);
	     List<String> list=new ArrayList<String>();
	    for (MultipartFile file : companyAptitude) {
	      //原始的文件名
	    String originalFilename = file.getOriginalFilename();
	     //绝对路径（另一台服务器文件路径）
	     String fullPath=path+originalFilename;
	     list.add(fullPath+",");
	     //将文件传入文件服务器
	     WebResource webResource1 = client.resource(fullPath);
	      webResource1.put(file.getBytes());
	    }
	    String end1="";
	    for(int i = 0;i < list.size(); i ++){
	    	end1+=list.get(i);
	        System.out.println(list.get(i));
	    }
	         map.put("companyAptitude", end1);
			 map.put("creationTime", DateUtil.getNowDate());// 创建时间
			boolean success = prBaseInfoService.updateByPrimaryKeySelective(map);
			if (success) {
				return new JsonUtil("200", null, "公司基本信息保存成功");
			}
			return new JsonUtil("500", null, "公司基本信息保存失败");
		}
	
	
	
	
	
	
}
