package com.zc.cris.beans.spring.aop.impl.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class TestAop {
	
	@Test
	void testProxy() {
		//创建ioc容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.aopXML.xml");
		
		//获取bean
		People bean =  (People) context.getBean("chinese");
		
//		System.out.println(bean); 
		
		//com.sun.proxy.$Proxy11
		System.out.println(bean.getClass().getName());	
		
		//System.out.println(bean instanceof Chinese);		//false
		
		//使用bean
		bean.eat("筷子");
		bean.say("中文");
	}
	
}
