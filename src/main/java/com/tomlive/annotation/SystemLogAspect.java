package com.tomlive.annotation;

import java.lang.reflect.Method;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tomlive.entity.Operation;
import com.tomlive.entity.User;
import com.tomlive.service.OperationService;
import com.tomlive.util.DateUtil;
import com.tomlive.util.IpUtil;



//@Aspect    
//@Component  
public class SystemLogAspect {

	    @Resource    
	    private OperationService operationservice;  
	    
	    DateUtil dateUtil=new DateUtil();
	    IpUtil ipUtil=new IpUtil();
	    
	    //本地异常日志记录对象    
	    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);    
	    
	    //Controller层切点    
	    @Pointcut("@annotation(com.tomlive.annotation.SysLog)")    
	     public  void controllerAspect() {    
	    }   
	    
	    /**  
	     * 前置通知 用于拦截Controller层记录用户的操作  
	     *  
	     * @param joinPoint 切点  
	     */    
	     @Before("controllerAspect()")    
	     public  void doBefore(JoinPoint joinPoint) {    
	    
	        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
	        
	        //当前所在用户
	        HttpSession session = request.getSession();
	        User user = (User)session.getAttribute("USER_SESSION");
	        System.out.println(user);
	        
	        //操作地址
	        String requestURI=request.getRequestURI();
	        System.out.println(requestURI);
	        
	        String method = joinPoint.getSignature().getDeclaringTypeName() + 
	                "." + joinPoint.getSignature().getName();
	        String params = ""; 
	        
	        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
	            for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
	           	 params+=joinPoint.getArgs()[i]+";";   
	           }    
	       }    
	         try {    
	            //*========控制台输出=========*//    
	            System.out.println("=====前置通知开始=====");    
	            String operation=getControllerMethodDescription(joinPoint);    
	            System.out.println("请求参数:" + params);
	           
	            Operation op=new Operation();

	            op.setOperationIp(request.getRemoteAddr());//设置请求的ip
	    		op.setOperationTime(dateUtil.createDate());//获取当前操作的时间
	    		
	    		
	    		op.setUserName(user.getUserName());
	    		op.setParam(request.getMethod());//获取请求方法的方式
	    		op.setOperationContent(operation);//获取方法上面注解的描述  
	    		operationservice.insertSelective(op);
	        }  catch (Exception e) {    
	            //记录本地异常日志    
	            logger.error("==前置通知异常==");    
	            logger.error("异常信息:{}", e.getMessage());    
	        }    
	    } 
	    
	    
	    /**  
	     * 获取注解中对方法的描述信息 用于Controller层注解  
	     * @param joinPoint 切点  
	     * @return 方法描述  
	     * @throws Exception  
	     */    
	     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
	        String targetName = joinPoint.getTarget().getClass().getName();    
	        String methodName = joinPoint.getSignature().getName();    
	        Object[] arguments = joinPoint.getArgs();   
	        Class targetClass = Class.forName(targetName);    
	        
	        
	        Method[] methods = targetClass.getMethods();    
	        String description = "";    
	         for (Method method : methods) {    
	             if (method.getName().equals(methodName)) {    
	                Class[] clazzs = method.getParameterTypes();    
	                 if (clazzs.length == arguments.length) {    
	                    description = method.getAnnotation(SysLog. class).description();    
	                     break;    
	                }    
	            }    
	        }    
	         return description;    
	    }
	    
}
