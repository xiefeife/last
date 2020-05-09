package com.tomlive.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tomlive.annotation.SysLog;
import com.tomlive.dao.UserMapper;
import com.tomlive.entity.User;
import com.tomlive.service.UserService;
import com.tomlive.util.DateUtil;
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
@RequestMapping("/user")
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
	 * @RequestParam("userName") String userName, @RequestParam("password") String
	 * password
	 * 
	 * @RequestBody User 用户对象实体类 适用于前端请求的json格式 mvc自动把参数转换成实体类对象
	 */
	@SysLog(description = "用户登录")
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public JsonUtil login(@RequestParam("userName") String userName, @RequestParam("password") String password,
			HttpSession session) throws Exception {
		User user = userService.login(userName, password);

		if (null != user) {
			
			if (user.getStatus() == 1) {
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
	@RequestMapping("/insertSelectUser")
	public JsonUtil insertSelectUser(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("注册的用户是map" + map);
		boolean choose = userService.selectUserByUserName(map.get("userName"));
		if (choose) {
			return new JsonUtil("201", null, "此账号已经注册");
		}
		// User user = new User(DateUtil.createDate(), userName, password, realName, 1);
		map.put("createTime", DateUtil.getNowDate());
		map.put("status", "1");
		boolean swith = userService.insertSelective(map);
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
	@SysLog(description = "修改用户状态")
	@RequestMapping("updateUserStatus")
	public JsonUtil updateUserStatus(@RequestParam("id") Integer id) throws Exception {
		// 根据传来的id查看这个用户的状态
		int number = userService.selectUserStatus(id);
		// 返回的是1 2
		if (2 == number) {// 激活用户
			boolean success = userService.activeteUserStatus(id);
			if (success) {
				return new JsonUtil("200", null, "激活成功");
			}
			// 如果返回的是1
		} else if (1 == number) {// 冻结用户
			boolean success = userService.updateUserStatus(id);
			if (success) {
				return new JsonUtil("201", null, "冻结成功");
			}
		}
		return new JsonUtil("500", null, "状态修改失败");
	}

	/**
	 * 根据条件查询用户
	 * 
	 * @param userName
	 * @param realName
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@SysLog(description = "条件查询用户")
	@RequestMapping(value = "selectUserByCondition", method = RequestMethod.POST)
	public JsonUtil selectUserByCondition(@RequestParam(value = "userName", required = false) String userName,
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "status", required = false) Integer status) throws Exception {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&status" + status);
		List<User> list = userService.selectUserByCondition(realName, userName, status);
		if (null != list) {
			return new JsonUtil("200", list, "条件查询用户成功");
		}
		return new JsonUtil("500", null, "条件查询用户失败");
	}

	/**
	 * 修改用户密码
	 * 
	 * @param password
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@SysLog(description = "修改用户密码")
	@RequestMapping(value = "updateUserPassword")
	public JsonUtil updateUserPassword(@RequestParam("password") String password,
			@RequestParam("userName") String userName) throws Exception {
		boolean choose = userService.updateUserPassword(password, userName);
		if (choose) {
			return new JsonUtil("200", null, "修改密码成功");
		}
		return new JsonUtil("500", null, "修改密码失败");
	}

	/**
	 * 查看所有用户
	 * 
	 * @return
	 */
	@SysLog(description = "/查看所有用户")
	@RequestMapping("/selectAllUser")
	public JsonUtil selectAllUser() {
		List<User> list = userService.selectAllUser();
		if (null != list) {
			return new JsonUtil("200", list, "查询所有用户成功");
		}
		return new JsonUtil("500", null, "查询所有用户失败");
	}

	@SysLog(description = "删除用户信息")
	@RequestMapping(value = "deleteUserByPrimaryKey", method = RequestMethod.POST)
	public JsonUtil deleteByPrimaryKey(@RequestParam("id") Integer id) {
		boolean success = userService.deleteByPrimaryKey(id);
		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}

	@SysLog(description = "修改用户状态")
	@RequestMapping("/updateUserRealNaem")
	public JsonUtil updateUserRealNaem(@RequestParam Map<String, Object> map) throws Exception {

		boolean success = userService.updateUserRealNaem(map);

		if (success) {
			return new JsonUtil("200", null, "成功");
		}
		return new JsonUtil("500", null, "失败");
	}

}