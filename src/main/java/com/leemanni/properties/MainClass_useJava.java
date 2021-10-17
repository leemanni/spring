package com.leemanni.properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass_useJava {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig_properties.class);
		
		
		AdminConnection_noneEnv admin = context.getBean(AdminConnection_noneEnv.class);
		System.out.println(admin);
		context.close();
		
		
	}
}
