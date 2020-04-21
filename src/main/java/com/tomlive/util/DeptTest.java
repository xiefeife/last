package com.tomlive.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.tomlive.entity.User;


public class DeptTest {
	
	public static void main(String[] args) {
		String url="http://localhost:8081";


	 
		//部门添加
		  add();
		
		
	}

	private static void add1( ) {
        
        CloseableHttpClient client = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            client = HttpClients.createDefault();
            httpPost = new HttpPost("http://localhost:8081/system/dept/325423");

            httpPost.addHeader("Content-type","application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json; charset=utf-8");
        //   httpDelete.setEntity(new StringEntity(data));
            httpPost.setEntity(new StringEntity(""));
           CloseableHttpResponse response = client.execute(httpPost);
           HttpEntity entity = response.getEntity();
           result = EntityUtils.toString(entity);

           if (200 == response.getStatusLine().getStatusCode()) {
              System.out.println(result);
           }
      } catch (Exception e) {
         System.out.println(e.getMessage());

       } finally {
           try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       }
      

	}

	/**
	 * 部门添加测试
	 */
	//deptName orderNum  province city  district  fullName  status  parentId
	public static void add() {
			// 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
				CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				// 创建Post请求
				 
				HttpPost httpPost = new HttpPost("http://localhost:8080/tomlive/user/selectUserByCondition");
				User  user=new  User();
				user.setStatus(1);
				// 我这里利用阿里的fastjson，将Object转换为json字符串;
				// (需要导入com.alibaba.fastjson.JSON包)
				String jsonString = JSON.toJSONString(user);
		 
				StringEntity entity = new StringEntity(jsonString, "UTF-8");
		 
				// post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
				httpPost.setEntity(entity);
		 
				httpPost.setHeader("Content-Type", "application/json;charset=utf8");
		 
				// 响应模型
				CloseableHttpResponse response = null;
				try {
					// 由客户端执行(发送)Post请求
					response = httpClient.execute(httpPost);
					// 从响应模型中获取响应实体
					HttpEntity responseEntity = response.getEntity();
		 
					System.out.println("响应状态为:" + response.getStatusLine());
					if (responseEntity != null) {
						System.out.println("响应内容长度为:" + responseEntity.getContentLength());
						System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						// 释放资源
						if (httpClient != null) {
							httpClient.close();
						}
						if (response != null) {
							response.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
	/**
	 * 部门修改
	 */
	//deptName orderNum  province city  district  fullName  status  parentId
	public static void edit() {
			// 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
				CloseableHttpClient httpClient = HttpClientBuilder.create().build();
				// 创建put请求
				
		        HttpPut httpput = new HttpPut("http://localhost:8081/system/dept/edit");  

				// 我这里利用阿里的fastjson，将Object转换为json字符串;
				// (需要导入com.alibaba.fastjson.JSON包)
				//String jsonString = JSON.toJSONString(dept);
		 
				StringEntity entity = new StringEntity("嗯嗯", "UTF-8");
		 
				// post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中
				httpput.setEntity(entity);
		 
				httpput.setHeader("Content-Type", "application/json;charset=utf8");
		 
				// 响应模型
				CloseableHttpResponse response = null;
				try {
					// 由客户端执行(发送)Post请求
					response = httpClient.execute(httpput);
					// 从响应模型中获取响应实体
					HttpEntity responseEntity = response.getEntity();
		 
					System.out.println("响应状态为:" + response.getStatusLine());
					if (responseEntity != null) {
						System.out.println("响应内容长度为:" + responseEntity.getContentLength());
						System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						// 释放资源
						if (httpClient != null) {
							httpClient.close();
						}
						if (response != null) {
							response.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		 
}
