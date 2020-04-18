package com.tomlive.service;
import com.tomlive.entity.User;
/**
 *  用户业务逻辑层接口
 *  @author Xie
 *  @date2020年4月7日
 */

public interface UserService {
	 /**
	        * 用户登录的方法
	  * @param userName   用户名
	  * @param password    密码
	  * @return 成功返回对象  失败返回null
	  */
	 User login(String userName,String password) throws Exception;

     /**
                  * 添加用户的方法
      * @param user  用户对象
      * @return   添加成功与否
      */
	 boolean  insertSelective(User  user)throws Exception;
	 
	 
	 /**
	  * 添加用户查看是否重复
	 * @param userName 注册的用户名
	 * @return 成功与否
	 */
    boolean selectUserByUserName(String userName)throws Exception;
    
	/**
	 * 冻结或激活用户
	 * @param param 数字0或者1
	 * @return 受影响行数
	 */
  boolean updateUserStatus(int param )throws Exception;

	/**
	   * 根据用户id查看用户状态
	 * @param id 被操作用户id
	 * @return   成功与否
	 */
   boolean  selectStatusById(int id)throws Exception;
   
  /**
   *   用户修改密码的方法
   * @param password   密码
   * @param id  用户id
   * @return
   * @throws Exception
   */
   boolean updateUserPassword(String password,Integer id)throws Exception;
}
