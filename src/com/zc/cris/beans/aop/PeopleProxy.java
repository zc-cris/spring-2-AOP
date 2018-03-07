package com.zc.cris.beans.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class PeopleProxy {

	private People target = null;

	public PeopleProxy(People people) {
		this.target = people;
	}


	// 获取代理对象的方法
	public People getPeopleProxy() {
		
		People proxy = null;
		
		// 当前代理对象由哪个类加载器来进行加载
		ClassLoader loader = this.target.getClass().getClassLoader();
		
		// 代理对象的类型，即实现的接口的类，主要是为了确定被代理对象有哪些方法
		Class[] interfaces = new Class[] { People.class };

		// 当调用代理对象的方法时，应该如何执行
		InvocationHandler handler = new InvocationHandler() {
			/*
			 * proxy：被返回的代理对象，一般情况下，不建议在invoke方法里面使用这个对象 method：正在被调用的方法对象 args：调用方法时，传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// 强烈不建议在invoke方法里面使用proxy这个代理对象，否则很容易出现 statckOverFlow 异常
				// System.out.println(proxy.toString());

				// 日志
				System.out.println("我是一个中国人");

				// 执行方法的返回值
				Object result = null;
				try {
					//方法的前置通知
					
					result = method.invoke(target, args);
					
					//方法的返回通知,可以访问到方法的返回值
				} catch (Exception e) {
					e.printStackTrace();
					//异常通知，可以访问到方法出现的异常
				}
				
				//方法的后置通知，因为方法可能会出现异常，所以不会访问到目标方法的返回值

				// 日志
				System.out.println(method.getName() + "======" + Arrays.asList(args));

				return result;
			}
		};

		//创建代理对象并返回
		proxy =  (People) Proxy.newProxyInstance(loader, interfaces, handler);
		return proxy;
	}

}
