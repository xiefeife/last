package com.tomlive.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 生成token和管理token的工具类
 * @author XIE
 *
 * 2020年4月16日
 */
public class TokenMange {
	
	//@Autowired
	//private RedisTemplate<Object, Object> redisTemplate;
	
	/**
	 * 生成一个令牌
	 * @param userId 用户ID
	 * @return 返回令牌
	 */
	public static String creatToken(int userId) {
		//生成一串随机数b104e24b-34ec-458b-88e7-b2841d2b76a7
		UUID uuid=  UUID.randomUUID();
		
		//格式化成1_6a0650ae05de40f2a230c2f71584add3
        String token = userId+"_"+uuid.toString().replaceAll("-", "");
        HttpServletRequest request = null;
        HttpSession session = request.getSession();
        session.setAttribute("token",token);      //设置token,参数token是要设置的具体值
		return token;
	}
	
	/**
	 * 检查token是否正确
	 * @param token 令牌
	 * @return true正确;false失败
	 */
	public boolean checkToken(String token,HttpSession session){
		//解析出userId和uuid
		if(token==null || "".equals(token)){
			return false;
		}
		//将token以_为标准拆分
		String[] arr1 = token.split("_");
		if(arr1.length != 2){
			return false;
		}
		//根据redis进行检查 这里项目小 没使用到redis，放进session中
		if(session.getAttribute(token)!=token) {
			return false;
		}
		return true;
	}

}	

