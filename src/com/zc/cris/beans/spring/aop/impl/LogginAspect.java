package com.zc.cris.beans.spring.aop.impl;

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
import org.springframework.stereotype.Component;

//把该类声明为一个切面：需要把该类放入到ioc容器中，然后再声明为一个切面
@Aspect
@Component
public class LogginAspect {

	// 声明该方法是一个前置通知，在目标方法开始之前执行
	@Before("execution(void com.zc.cris.beans.spring.aop.impl.Chinese.*(String))")
	public void beforeMethod(JoinPoint joinPoint) {
		// 获取方法签名和参数集合
		System.out.println(joinPoint.getSignature().getName() + "-----" + Arrays.asList(joinPoint.getArgs()));
		System.out.println("我是方法的前置通知");
	}

	// 声明该方法是一个后置通知，在目标方法执行后执行（无论目标方法是否发生异常）
	// 且后置通知无法访问目标方法的返回值
	@After("execution(* com.zc.cris.beans.spring.aop.impl.*.*(String))")
	public void afterMethod(JoinPoint joinPoint) {

		System.out.println("我是方法的后置通知");
	}

	// 声明该方法为返回通知：方法正常执行结束后执行的代码
	// 返回 通知是可以访问到方法的返回值的！
	@AfterReturning(value = "execution(public void com.zc.cris.beans.spring.aop.impl.*.*(..))", returning = "result")
	public void afterRetruning(JoinPoint joinPoint, Object result) {

		System.out.println("我是方法的返回通知" + joinPoint.getSignature().getName() + "^^^^"
				+ Arrays.asList(joinPoint.getArgs() + "我是方法的返回值" + result));
	}
	
	//目标方法出现异常才会指定的代码
	//可以访问到异常对象，且可以指定出现特定的异常（NullPointException）才会执行
	@AfterThrowing(value = "execution(public void com.zc.cris.beans.spring.aop.impl.*.*(..))",
			throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Exception e) {
		System.out.println("我是目标方法发生异常才执行的通知："+e.getMessage());
	}
	
	//环绕通知：必须携带 ProceedingJoinPoint 类型的参数
	//环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定目标方法的执行，
	//环绕通知必须要有返回值，返回值其实就是目标方法的返回值
	@Around(value = "execution(public void com.zc.cris.beans.spring.aop.impl.*.*(..))")
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
