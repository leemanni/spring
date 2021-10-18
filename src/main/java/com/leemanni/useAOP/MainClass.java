package com.leemanni.useAOP;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
		context.load("classpath:application_context_useAOP.xml");
		
		context.refresh();
		SimpleVO vo = context.getBean("vo", SimpleVO.class);
		vo.simpleMethod();
		System.out.println(vo);
		context.close();
	}
}
