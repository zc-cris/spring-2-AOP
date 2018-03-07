package com.zc.cris.beans.aop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestAop {

	
	
	@Test
	void testProxy() {
		
		Chinese chinese = new Chinese("老爹");
		
		People peopleProxy = new PeopleProxy(chinese).getPeopleProxy();
		peopleProxy.eat("大米");
		peopleProxy.say("中文");
	}
	
	
	
	
	
	@Test
	void test() {
		
		People people = new Chinese("cris");
		people.eat("筷子");
		people.say("中文");
		
	}
	
}
