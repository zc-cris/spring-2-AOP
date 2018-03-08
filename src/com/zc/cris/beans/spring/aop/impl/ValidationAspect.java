package com.zc.cris.beans.spring.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//使用 @Order(1) 注解指定切面的优先级，数字越小，优先级越高
@Order(1)
@Aspect
@Component
public class ValidationAspect {
	
	@Before(value = "com.zc.cris.beans.spring.aop.impl.LogginAspect.declaredJointPointExpresson()")
	public void validate(JoinPoint joinPoint) {
		
		System.out.println("------- validation-----"+ Arrays.asList(joinPoint.getArgs()));
	}
}
