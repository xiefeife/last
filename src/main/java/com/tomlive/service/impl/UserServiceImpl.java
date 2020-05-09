package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
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
	public boolean insertSelective(Map<String, String> map) {

		int count = userMapper.insertSelective(map);

		return count > 0 ? true : false;
	}

	 /**
	  * 添加用户查看是否重复
	 * @param userName 注册的用户名
	 * @return 成功与否
	 */
	@Override
	public boolean selectUserByUserName(String userName) {
		
	User user=  userMapper.selectUserByUserName(userName);
	if (null != user) {
		return true;
	    }
	return false;
	}



	
	 /**
	   *  用户修改密码的方法
	   * @param password   密码
	   * @param id  用户id
	   * @return
	   * @throws Exception
	   */
	@Override
	public boolean updateUserPassword(String password,String userName)  {
		int count= userMapper.updateUserPassword(password,userName);
		return count>0?true:false;
	}


    /**
         * 根据条件查询用户
     * @return
     */
	@Override
	public List<User> selectUserByCondition(String realName,
   		 String userName,Integer status) {
		
		return userMapper.selectUserByCondition( realName,
	    		 userName, status);
	}

	/**
	 * 根据id查看用户
	 */
	@Override
	public boolean selectByPrimaryKey(Integer id) {
	int  count=	   userMapper.selectByPrimaryKey(id);
		return count>0?true:false;
	}
	/**
	 * 查看全部用户
	 */
	@Override
	public List<User> selectAllUser() {
	              
		return userMapper.selectAllUser();
	}

	/**
	 * 激活用户
	 */
	@Override
	public boolean activeteUserStatus(Integer id) {
	int  count=  userMapper.activeteUserStatus(id);
		return count>0?true:false;
	}

	
	/**
	 *     冻结用户
	 * @param param 数字0或者1
	 * @return 受影响行数
	 */
	@Override
	public boolean updateUserStatus(Integer id) {
		int  count=		userMapper.updateUserStatus(id);
			
		return count>0?true:false;
		
	}

	@Override
	public int selectUserStatus(Integer id) {
	int  number= userMapper.selectUserStatus(id);
    return  number;
	
	}

	@Override
	public boolean deleteByPrimaryKey(Integer id) {
	 int count=	userMapper.deleteByPrimaryKey(id);
	 
		return count>0?true:false;
	}

	@Override
	public boolean updateUserRealNaem(Map<String, Object> map) {
		
	int count=	userMapper.updateUserRealNaem(map);
		
	return count>0?true:false;
	}
}
