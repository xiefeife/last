package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.User;

public interface UserMapper {

	int deleteByPrimaryKey(Integer id);
	
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
     int  insertSelective(Map<String, String> map); 
     
     
     /**
     * 添加用户查看是否重复
      * @param userName 注册的用户名
      * @return  受影响行数
      */
     User selectUserByUserName(String userName);
     
     
     /**
      * 激活用户
* @param param   数字0或者1
* @return   受影响行数
*/
    Integer activeteUserStatus(Integer id);
     
	/**
	 * 冻结用户
	 * 
	 * @param param 数字0或者1
	 * @return 受影响行数
	 */
	int updateUserStatus(@Param("id") Integer id);

	/**
	 * 修改用户密码的方法
	 * @param password 用户密码
	 * @return
	 */
     int  updateUserPassword(@Param("password")String password,@Param("userName")String userName);
     
     
     /**
                * 根据条件查询用户
      * @return
      */
     List<User> selectUserByCondition(@Param("realName")String realName,
    		 @Param("userName")String userName,@Param("status")Integer status);
     
     
     int updateByPrimaryKey(User record);
     
     /**
      * 根据id查看用户
      * @param id
      * @return
      */
     int  selectByPrimaryKey(Integer id);
     
     List<User> selectAllUser();
     
     Integer  selectUserStatus(Integer id);
     
     int updateUserRealNaem(Map<String, Object> map);
     
     
}