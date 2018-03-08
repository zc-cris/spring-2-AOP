package com.zc.cris.beans.spring.aop.impl.xml;

import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class LogginAspect {

	
	public void declaredJointPointExpresson() {};
	
	public void beforeMethod(JoinPoint joinPoint) {
		// 获取方法签名和参数集合
		System.out.println(joinPoint.getSignature().getName() + "-----" + Arrays.asList(joinPoint.getArgs()));
		System.out.println("我是方法的前置通知");
	}

	public void afterMethod(JoinPoint joinPoint) {

		System.out.println("我是方法的后置通知");
	}

	public void afterRetruning(JoinPoint joinPoint, Object result) {

		System.out.println("我是方法的返回通知" + joinPoint.getSignature().getName() + "^^^^"
				+ Arrays.asList(joinPoint.getArgs() + "我是方法的返回值" + result));
	}
	
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		System.out.println("我是目标方法发生异常才执行的通知："+e.getMessage());
	}
	
	public Object around(ProceedingJoinPoint pjt) {
		
		Object result = null;
		String methodName = pjt.getSignature().getName();
		
		try {
			//前置通知
			System.out.println("我是环绕通知的前置通知！！！！！");
			
			//执行目标方法
			result = pjt.proceed();
			
			//返回通知
			System.out.println("我是环绕通知的后置通知");
		} catch (Throwable e) {
			//异常通知
			System.out.println("我是环绕通知的异常通知"+e.getMessage());
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("我是环绕通知的后置通知");
		return result;
		
	}

}
