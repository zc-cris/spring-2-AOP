package com.zc.cris.beans.spring.aop.impl.xml;

import static org.hamcrest.CoreMatchers.instanceOf;

import org.springframework.stereotype.Component;

public class Chinese implements People{

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public Chinese() {
		super();
		
	}
	public Chinese(String name) {
		super();
		this.name = name;
	}
	@Override
	public void eat(String tool) {
//		System.out.println(this.name+"是一个中国人");
		System.out.println("我用"+tool+"吃饭");
	}

	@Override
	public void say(String language) {
//		System.out.println(this.name+"是一个中国人");
//		int i = 1/0;
		System.out.println("我说"+language);
	}
	
}
