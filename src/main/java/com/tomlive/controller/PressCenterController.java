package com.tomlive.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.tomlive.annotation.SysLog;
import com.tomlive.entity.PressCenter;
import com.tomlive.entity.User;
import com.tomlive.service.PressCenterService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.JsonUtil;

/**
 * 新闻中心控制层
 * 
 * @author Xie
 * @date2020年4月16日
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping("pressCenter")
public class PressCenterController {

	@Autowired
	private PressCenterService pressCenterService;

	/**
	 * 查看所有新闻中心的方法
	 * 
	 * @return 成功与否
	 */
	@SysLog(description="查看所有新闻中心")
	@RequestMapping(value = "selectAllPressCenter", method = RequestMethod.POST)
	public JsonUtil selectAllPressCenter() {
		List<PressCenter> list = pressCenterService.selectAll();
		if (null != list) {
			return new JsonUtil("200", list, "查询成功");
		}
		return new JsonUtil("500", null, "查询失败");

	}

	
	/**
	 * 选择性的添加新闻中心的方法
	 * 其中包含图片的上传
	 * @param pressCenter 新闻中心对象
	 * @return 成功与否
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@SysLog(description="添加新闻")
	@RequestMapping(value = "insertSelectPressCenter",consumes = "multipart/form-data")
	public JsonUtil insertSelectPressCenter(@RequestParam("title") String title,
			@RequestParam("content") String content,
			@RequestParam(value="particulars",required = false) String particulars,
			MultipartFile upload,
			HttpServletRequest req) throws IllegalStateException, IOException {
		System.out.println("****************title"+title);
		System.out.println("****************content"+content);
		System.out.println("****************particulars"+particulars);
		System.out.println("****************upload"+upload);
		
		
		
		User  user=(User)req.getSession().getAttribute("user_session");
		//文件上传的服务器路径
	    String path="http://39.106.50.89:8011/images/";
	    
	    
	    // 获取上传的文件名称，并结合存放路径，构建新的文件名称
	    String fileName =  upload.getOriginalFilename();
		
	    
	  //URLEncoder的导包语句为  import java.net.URLEncoder;
	    String encodeFileName = URLEncoder.encode(fileName,"UTF-8");
	    
	    
        //创建客户端对象
		Client client = Client.create();
		
		//与服务器进行连接	
		  WebResource resource = client.resource(path + encodeFileName);
		
		 resource.put(upload.getBytes());
		
		 String end=path+fileName;
		 
		 DateUtil dateUtil = new DateUtil();
		 PressCenter pr=new PressCenter(end, title, user, dateUtil.createDate(), null, null, 1, content);
			
		 boolean choose = pressCenterService.insertSelective(pr);
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
	@SysLog(description="查看新闻中心数量")
	@RequestMapping(value="selectPressCenterCount", method = RequestMethod.POST)
	  public  JsonUtil  selectPressCenterCount() {
		  
       int  count=		  pressCenterService.selectPressCenterCount();
		if(0<count) {
			return new   JsonUtil("200", count, "查询新闻中心数量成功");
		}
		return new   JsonUtil("500", null, "查询新闻中心数量失败");
	  }

}
