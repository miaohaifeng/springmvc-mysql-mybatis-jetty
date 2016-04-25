///**
// *
// */
//package com.madhoue.dsp.uadata.intercepter;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//
///**
// * Remoting 拦截器
// */
//
//@Component
//@Aspect
//public class RemotingIntercepter {
//
//	final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	private @Value("${remoting.log}") Boolean RemotingLog;
//
//	private static ObjectMapper objectMapper =new ObjectMapper();
//
//	/**
//	 * 设置 切入点
//	 *
//	 */
//	@SuppressWarnings("unused")
//	@Pointcut("execution(* com.madhoue.dsp.uadata..*.*(..))")
//	private void anyMethod() {
//	}
//
//	/**
//	 * 执行前
//	 */
//	@Before("anyMethod()")
//	public void beforeLog(JoinPoint joinPoint) {
//		if (RemotingLog){
//			StringBuffer sb=new StringBuffer();
//			sb.append("调用方法:")
//			  .append(joinPoint.getTarget().getClass().getName())
//			  .append(".")
//			  .append(joinPoint.getSignature().getName());
//			StringBuffer prarms=new StringBuffer();
//			prarms.append("参数:");
//			try {
//				prarms.append(objectMapper.writeValueAsString(joinPoint.getArgs()));
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				prarms.append("异常").append(e.getMessage());
//				e.printStackTrace();
//			}
//			logger.info(sb.toString());
//			logger.info(prarms.toString());
//
//		}
//	}
//
//	/**
//	 * 正常操作
//	 * @param joinPoint
//	 */
//	@AfterReturning(pointcut="anyMethod()")
//	public void doAfterReturning(JoinPoint joinPoint) {
////		SessionHandler.clearCurrent();
//	}
//
//	/**
//	 * 遇到异常操作
//	 */
//	@AfterThrowing(pointcut="anyMethod()",throwing="ex")
//	public void exception(Exception ex){
////		SessionHandler.clearCurrent();
//		logger.error(ex.getMessage());
//	}
//
//
//
//}
