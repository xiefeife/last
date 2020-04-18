package com.hbb.annotation;


import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import com.tomlive.util.IpUtil;



/**
 *  切面类
 *  @author Xie
 *  @date2020年4月16日
 */
@Aspect       //切面  标注该类是一个注解类  里面可以定义切入点和通知
@Component    //把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
public class LogAspect{
	
	//本地异常日志记录对象    
    private  static  final Logger logger = LoggerFactory.getLogger(LogAspect. class);
    private String requestPath = null ; // 请求地址
    private String userNo = null ; // 用户名
    private Map<?,?> inputParamMap = null ; // 传入参数
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private long startTimeMillis = 0; // 开始时间
    private long endTimeMillis = 0; // 结束时间
    private String remoteAddr;          //请求IP
    private String discription; //方法描述
    
    
    
    IpUtil ipUtil=new IpUtil();
	
    
     //controller层切点    注解拦住
    @Pointcut("@annotation(com.tomlive.annotation.SysLog)")
     public   void  controllerAspect() {
    	 
     }
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     * @param joinPoint 切点  
     */        
    @Before("execution(* com.tomlive.controller..*.*(..))")
    public  void doBeforeInServiceLayer(JoinPoint joinPoint) {
    	startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
    }
    /**
    *
    * @Title：doAfterInServiceLayer
    * @Description: 方法调用后触发
    *  记录结束时间
    * @param joinPoint
    */
   @After("controllerAspect()")
   public void doAfterInServiceLayer(JoinPoint joinPoint) throws IOException {
       endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
       discription = getControllerMethodDescription2(joinPoint);
       if(StringUtils.isBlank(discription)){
           discription = "-";
       }	
       this.printOptLog();
   }

    
   /**
   *
   * @Title：doAround
   * @Description: 环绕触发
   * @param pjp
   * @return
   * @throws Throwable
   */
  @Around("execution(* com.tomlive.	controller..*.*(..))")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
      /**
       * 1.获取request信息
       * 2.根据request获取session
       * 3.从session中取出登录用户信息
       */
      RequestAttributes ra = RequestContextHolder.getRequestAttributes();
      ServletRequestAttributes sra = (ServletRequestAttributes)ra;
      HttpServletRequest request = sra.getRequest();
      userNo = (String) request.getSession().getAttribute("user");
      if(StringUtils.isBlank(userNo)){
          userNo = "-";
      }
      remoteAddr = request.getRemoteAddr();//请求的IP

      if(StringUtils.isBlank(remoteAddr)){
          remoteAddr = "-";
      }
      // 获取输入参数
      inputParamMap = request.getParameterMap();
      // 获取请求地址
      requestPath = request.getRequestURI();
      if(StringUtils.isBlank(requestPath)){
          requestPath = "-";
      }
      // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
      outputParamMap = new HashMap<String, Object>();
      Object result = pjp.proceed();// result的值就是被拦截方法的返回值
      outputParamMap.put("result", result);

      return result;
  }

  /**
   * 获取注解中对方法的描述信息 用于Controller层注解
   *
   * @param joinPoint 切点
   * @return discription
   */
  public static String getControllerMethodDescription2(JoinPoint joinPoint) {
      MethodSignature signature = (MethodSignature) joinPoint.getSignature();
      Method method = signature.getMethod();
      SystemControllerLog controllerLog = method
              .getAnnotation(SystemControllerLog.class);
      String discription = controllerLog.description();
      return discription;
  }
  /**
  *
  * @Title：printOptLog
  * @Description: 输出日志
  * @author shaojian.yu
  * @date 2014年11月2日 下午4:47:09
  */
 private void printOptLog() {
     Gson gson = new Gson(); // 需要用到google的gson解析包
     String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
     String data1 = "用户编号："+userNo+"\r\n"
             +"请求地址:"+requestPath+"\r\n"
             +"请求IP:"+remoteAddr+"\r\n"
             +"方法描述:"+discription+"\r\n"
             +"开始时间:"+optTime+"\r\n"
             +"调用方法时间:"+(endTimeMillis - startTimeMillis)+"ms;"+"\r\n"
             +"参数:"+gson.toJson(inputParamMap)+"\r\n"
             +"返回参数:"+gson.toJson(outputParamMap)+"\r\n";
     logger.error(data1);

    
     try {
         Date now = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
         String logName = sdf.format(now);
         //服务器日志地址 /data/website/zhuohuiclass/cloud/logs/
         File logFile = new File("C:\\Users\\lenovo\\Desktop\\", logName+".txt");
         if (!logFile.exists()) {
             //logFile.mkdirs();
             logFile.createNewFile();
         }
         if(StringUtils.isNoneBlank()){

         }
         //数据分析用 用户编号 IP 方法 时间
         String data =userNo+"\t"+remoteAddr+"\t"+discription+"\t"+optTime+"\t"+"\r\n";
         FileOutputStream out = new FileOutputStream(logFile,true);
         out.write(data.getBytes());
         out.close();
     }catch (Exception e){
 }
 }
}