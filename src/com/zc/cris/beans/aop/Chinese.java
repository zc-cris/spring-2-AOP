package com.zc.cris.beans.aop;


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
		System.out.println("我说"+language);
	}
	
}
