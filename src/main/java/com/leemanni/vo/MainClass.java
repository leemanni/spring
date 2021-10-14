package com.leemanni.vo;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국내주식 : 1 , 해외주식 : 2 => ");
		int answer= scanner.nextInt();
		String config = "";
		
		if(answer == 1) {
			config = "korea";
		}else if(answer == 2) {
			config = "usa";
		}
		
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:application_context.xml", "classpath:application_context2.xml");
		ctx.refresh();
		UserStockVO vo1 = ctx.getBean("vo1", UserStockVO.class);
		UserStockVO vo2 = ctx.getBean("vo2", UserStockVO.class);
		
		System.out.println(vo1);
		
		ctx.close();
		
		
	}
}
