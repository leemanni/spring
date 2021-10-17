package com.leemanni.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean{
	private String name;
	private int age;
	private String id;
	private String pw;
	
	private Environment env;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "AdminConnection [name=" + name + ", age=" + age + ", id=" + id + ", pw=" + pw + "]";
	}
	@Override
	public void setEnvironment(Environment environment) {
		env = environment;
		System.out.println("환경설정을 주입합니다.");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("properties 정보를 객체에 주입합니다.");
		name = env.getProperty("admin.name");
		age = Integer.parseInt(env.getProperty("admin.age"));
		id= env.getProperty("admin.id");
		pw=env.getProperty("admin.pw");
	}
	
	
}
