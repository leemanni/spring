package com.leemanni.vo;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application_context.xml");
		
		ArrayList<UserStockVO> stocks = new ArrayList<UserStockVO>();
		UserStockVO vo1 = ctx.getBean("vo1", UserStockVO.class);
		UserStockVO vo2 = ctx.getBean("vo2", UserStockVO.class);
		stocks.add(vo1);
		stocks.add(vo2);
		UserStockList userStockList = new UserStockList(stocks);
//		System.out.println(userStockList.toString());
	}
}
