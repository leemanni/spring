package com.leemanni.useAOP;

import org.aspectj.lang.ProceedingJoinPoint;

public class ConnectAOP {
	public void before() {
		System.out.println("LogAOP => before()");
		System.out.println("***************************************");
	}
	
	public void afterReturning() {
		System.out.println("LogAOP => afterReturning()");
		System.out.println("***************************************");
	}
	
	public void afterThrowing() {
		System.out.println("LogAOP => afterThrowing()");
		System.out.println("***************************************");
	}
	public void after() {
		System.out.println("LogAOP => after()");
		System.out.println("***************************************");
	}
	
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("around() 메소드 실행");
		try {
			System.out.println("around() 메소드 ing....");
			Thread.sleep(1000);
			System.out.println("around() 메소드 ing.......");
			Object object = joinPoint.proceed();
			return object;
		} finally {
			System.out.println("around() 메소드 end");
		}
	}
}
