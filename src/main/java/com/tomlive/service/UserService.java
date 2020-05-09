package com.tomlive.service;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	 boolean  insertSelective(Map<String, String> map)throws Exception;
	 
	 
	 /**
	  * 添加用户查看是否重复
	 * @param userName 注册的用户名
	 * @return 成功与否
	 */
    boolean selectUserByUserName(String userName)throws Exception;
    
   /**
      *   用户修改密码的方法
   * @param password   密码
   * @param id  用户id
   * @return
   * @throws Exception
   */
   boolean updateUserPassword(String password,String userName)throws Exception;
   

   /**
          * 根据条件查询用户
    * @return
    */
   List<User> selectUserByCondition(String realName,
  		 String userName,Integer status) throws Exception;

  


   boolean  selectByPrimaryKey(Integer id);
   
   
    boolean  deleteByPrimaryKey(Integer id);
   
   
   List<User> selectAllUser();
   
   
   /**
    * 激活用户
    * @param id
    * @return
    */
   boolean  activeteUserStatus(Integer id);
   /*
    * 冻结用户
    */
   boolean updateUserStatus( Integer id);
   
   /**
    * 根据主键id查看用户
    * @param id
    * @return
    */
   int     selectUserStatus(Integer id);
   
   boolean  updateUserRealNaem(Map<String, Object> map);
   
}
