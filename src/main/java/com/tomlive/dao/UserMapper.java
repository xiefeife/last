package com.tomlive.dao;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.User;

public interface UserMapper {

	int deleteByPrimaryKey(String user);
	
	  /**
	     * 用户登录的方法
	  * @param userName    用户名
	  * @param password    密码
	  * @return 成功返回对象  失败返回null
	  */
     User login(@Param("userName")String userName,@Param("password")String password);

     /**
                  * 添加用户的方法
      * @param user  用户对象
      * @return   受影响的行数
      */
     int  insertSelective(User user); 
     
     
     /**
     * 添加用户查看是否重复
      * @param userName 注册的用户名
      * @return  受影响行数
      */
     int selectUserByUserName(String userName);
     
     /**
      * 冻结或激活用户
      * @param param   数字0或者1
      * @return   受影响行数
      */
     int updateUserStatus(int param );
     
     /**
      * 根据用户id查看用户状态
      * @param id  被操作用户id
      * @return   受影响行数
      */
     int  selectStatusById(int id);

	/**
	 * 修改用户密码的方法
	 * 
	 * @param password 用户密码
	 * @return
	 */
     int  updateUserPassword(String password,Integer id);
     
     int updateByPrimaryKey(User record);
}