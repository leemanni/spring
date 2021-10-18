package com.leemanni.useAOP;

public class SimpleVO {
	private String name ;
	private int age ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "SimpleVO [name=" + name + ", age=" + age + "]";
	}
	
	public void simpleMethod() {
		System.out.println("간단하지만 핵심 메소드 입니다.");
	}
	
	
	
}
