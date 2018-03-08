package com.zc.cris.beans.spring.aop.impl.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class ValidationAspect {
	
	public void validate(JoinPoint joinPoint) {
		System.out.println("------- validation-----"+ Arrays.asList(joinPoint.getArgs()));
	}
}
