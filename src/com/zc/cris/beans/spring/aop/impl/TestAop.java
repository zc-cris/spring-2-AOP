package com.zc.cris.beans.spring.aop.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TestAop {

	
	
	@Test
	void testProxy() {
		//创建ioc容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//获取bean
		People bean = context.getBean(People.class);
		
//		System.out.println(bean); 
//		System.out.println(bean.getClass().getName());
		
		//System.out.println(bean instanceof Chinese);		//false
		
		//使用bean
		bean.eat("筷子");
		bean.say("中文");
	}
	
	
	
	
	
	
}
