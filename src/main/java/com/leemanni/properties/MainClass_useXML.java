package com.leemanni.properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass_useXML {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:admin_application_context_useXML.xml");
		context.refresh();
		AdminConnection_noneEnv admin = context.getBean("admin", AdminConnection_noneEnv.class);
		AdminConnection_noneEnv admin_sub = context.getBean("admin_sub", AdminConnection_noneEnv.class);
		
		System.out.println(admin);
		System.out.println(admin_sub);
		
		context.close();
		
		
	}
}
