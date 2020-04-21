package com.tomlive.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.dao.UserMapper;
import com.tomlive.entity.User;
import com.tomlive.service.UserService;
import com.tomlive.util.JsonUtil;
import com.tomlive.util.TokenMange;

/**
 * 用户实体类控制层
 * 
 * @author Xie
 * @date2020年4月16日
 */
@ResponseBody
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 用户登录的方法
	 * 
	 * @param userName 用户名
	 * @param password 密码
	 * @return 成功返回对象 失败返回null
	 * @throws Exception
	 */
	/*
	 * @RequestParam 适用于前端请求数据是字符串格式
	 * 
	 * @RequestBody User 用户对象实体类 适用于前端请求的json格式 mvc自动把参数转换成实体类对象
	 */
	@SysLog(description = "用户登录")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public JsonUtil login(@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpSession session) throws Exception {
		User user = userService.login(userName, password);
		
		if (null != user) {
			if (0 != user.getStatus()) {
				session.setAttribute("user_session", user);
				System.err.println("前端传输过来的用户是" + user);
				UUID uuid = UUID.randomUUID();

				// 格式化成1_6a0650ae05de40f2a230c2f71584add3
				String token = user.getId() + "_" + uuid.toString().replaceAll("-", "");
				session.setAttribute("token", token);
				System.out.println("++++++++++++++" + token);
				return new JsonUtil("200", user, token);
			}
			return new JsonUtil("400", null, "用户冻结,无法登录");
		}
		return new JsonUtil("500", null, "用户名或密码错误");
	}

	/**
	 * 添加用户的方法
	 * 
	 * @param user 用户对象
	 * @return 添加成功与否
	 * @throws Exception
	 */
	@SysLog(description = "添加用户")
	@RequestMapping("insertSelectUser")
	public JsonUtil insertSelectUser(@RequestParam String userName, @RequestParam String password,
			@RequestParam String realName) throws Exception {
		boolean choose = userService.selectUserByUserName(userName);
		if (choose) {
			return new JsonUtil("201", null, "此账号已经注册");
		}
		User user = new User(userName, password, realName, 1);
		boolean swith = userService.insertSelective(user);
		if (swith) {
			return new JsonUtil("200", null, "用户添加成功");
		}
		return new JsonUtil("500", null, "用户添加失败");
	}

	/**
	 * 修改用户状态
	 * 
	 * @param id 用户的id
	 * @return 修改成功与否
	 * @throws Exception
	 */
	//@SysLog(description = "修改用户状态")
	@RequestMapping("updateUserStatus")
	public JsonUtil updateUserStatus(@RequestParam("id") Integer id) throws Exception {
		if (null != id && 1 == id) {
			boolean choose = userService.updateUserStatus(0);
			if (choose) {
				return new JsonUtil("200", null, "用户冻结成功");
			}
			return new JsonUtil("500", null, "用户冻结失败");
		}
		return new JsonUtil("500", null, "未知原因,修改失败");
	}

	/*
	 * ServletRequestAttributes attributes = (ServletRequestAttributes)
	 * RequestContextHolder.getRequestAttributes(); HttpServletRequest request =
	 * attributes.getRequest(); String token=request.getHeader("token");
	 */

	//@SysLog(description = "条件查询用户")
	@RequestMapping(value="selectUserByCondition",method =RequestMethod.POST)
	public JsonUtil selectUserByCondition(@RequestParam(value="userName",required = false) String userName, @RequestParam(value="realName",required = false) String  realName,
			@RequestParam(value="status",required = false) Integer status) throws Exception {
		List<User>     list   =userService.selectUserByCondition();
		if(null!=list) {
			return   new JsonUtil("200", list, "条件查询用户成功");
		}
		return   new JsonUtil("200", list, "条件查询用户成功");
	}

	//@SysLog(description = "修改用户密码")
	@RequestMapping(value="updateUserPassword")
	public JsonUtil  updateUserPassword(@RequestParam("password") String password,@RequestParam("userName") String userName) throws Exception {
		  boolean  choose= userService.updateUserPassword(password, userName);
		      if(choose) {
	           return  new JsonUtil("200", null, "修改密码成功");
		      }
		return  new JsonUtil("500", null, "修改密码失败");
	}
	
	
	
	
}