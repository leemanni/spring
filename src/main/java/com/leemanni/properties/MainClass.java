package com.leemanni.properties;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {
	public static void main(String[] args) {
		
//		빈 DI 컨테이너 생성
//		ConfigurableApplicationContext context = new GenericXmlApplicationContext();
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		
//		환경설정 정보 넣기
		ConfigurableEnvironment env = context.getEnvironment();
		
//		properties 정보 저장소 만들기
		MutablePropertySources mps = env.getPropertySources();
		
//		properties 정보 넣기
//		방법은 4가지 , 1. first   2. last   3. brefore   4. after
		try {
			// ResourcePropertySource 익명객체 생성자에 properties 위치 전달
			mps.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println("name : " + env.getProperty("admin.name"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
//		
//		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) context;
		context.load("classpath:admin_application_context.xml");
		
		context.refresh();
		AdminConnection adminConnection = context.getBean("admin", AdminConnection.class);
		System.out.println(adminConnection);
	}
}
