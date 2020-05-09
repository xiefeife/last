package com.tomlive.util;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class UploadFile {
	
	public   static  final String PATH="http://39.106.50.89:80/tomlive/imgs/";
     
	/**
	 * 文件上传
	 * @param file
	 * @return
	 * @throws UniformInterfaceException
	 * @throws ClientHandlerException
	 * @throws IOException
	 */
    public  static String upload(@RequestParam("file")MultipartFile file) throws UniformInterfaceException, ClientHandlerException, IOException {

    	//获取文件存储绝对路径
    	String path1="C:\\Program Files\\Java\\tomcat-tomlive\\tomlive\\imgs";
    	//获取上传文件的原名称
    	 String fileName = file.getOriginalFilename(); 
    	 
    	 String  str=fileName.substring(fileName.lastIndexOf("."));
    	 
    	String uuid = UUID.randomUUID().toString().replace("-","")+str;
    	File f=new File(path1,uuid);
    	String endPath=PATH+uuid;
    	
        file.transferTo(f);
    	
    	return endPath;
    	
    }
     
     
}

//String path="http://39.106.50.89:8011/images/"; 
// //获取上传文件的原始名称
// String fileName = file.getOriginalFilename(); 
// //路径加上原来的名称192.168.31.105/imgs
// 
//String encodeFileName = URLEncoder.encode(fileName,"UTF-8");
// 
////防止文件重复
//String uuid = UUID.randomUUID().toString().replace("-","");
//fileName = path+uuid + "-" + encodeFileName;
// 
//  //创建客户端对象
//Client client = Client.create();
////和图片服务器进行连接
//WebResource webResource = client.resource(path+fileName);
////上传文件
//webResource.put(file.getBytes());
