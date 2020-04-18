package com.tomlive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomlive.dao.UserMapper;
import com.tomlive.entity.User;
import com.tomlive.service.UserService;

/**
 * 用户业务逻辑实现类
 * 
 * @author Xie
 * @date2020年4月7日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登录的方法
	 * 
	 * @param userName 用户名
	 * @param password 密码
	 * @return 成功返回对象 失败返回null
	 */
	@Override
	public User login(String userName, String password) {
		User user = userMapper.login(userName, password);
		if (null != user) {
			return user;
		}
		return null;
	}

	/**
	 * 添加用户的方法
	 * @param user 用户对象
	 * @return 添加成功与否
	 */
	@Override
	public boolean insertSelective(User user) {

		int count = userMapper.insertSelective(user);

		return count > 0 ? true : false;
	}

	 /**
	  * 添加用户查看是否重复
	 * @param userName 注册的用户名
	 * @return 成功与否
	 */
	@Override
	public boolean selectUserByUserName(String userName) {
		
	 int  count=  userMapper.selectUserByUserName(userName);
		return count>0?true:false;
	}

	/**
	 * 冻结或激活用户
	 * @param param 数字0或者1
	 * @return 受影响行数
	 */
	@Override
	public boolean updateUserStatus(int param) {
	int count=  	userMapper.updateUserStatus(param);
    return count>0?true:false;
	}

	  /**
	* 根据用户id查看用户状态
	* @param id  被操作用户id
	* @return   成功与否
	*/
	@Override
	public boolean selectStatusById(int id)  {
  	 int count=userMapper.selectStatusById(id);
  	 
		return count>0?true:false;
	}
	 /**
	   *  用户修改密码的方法
	   * @param password   密码
	   * @param id  用户id
	   * @return
	   * @throws Exception
	   */
	@Override
	public boolean updateUserPassword(String password,Integer id) throws Exception {
		int count= userMapper.updateUserPassword(password,id);
		return count>0?true:false;
	}

}
