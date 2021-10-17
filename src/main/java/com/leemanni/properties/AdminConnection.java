package com.leemanni.properties;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean{
	private String name;
	private String age;
	private String id;
	private String pw;
	private String name_sub;
	private String age_sub;
	private String id_sub;
	private String pw_sub;
	
	private Environment env;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
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
	
	public String getName_sub() {
		return name_sub;
	}
	public void setName_sub(String name_sub) {
		this.name_sub = name_sub;
	}
	public String getAge_sub() {
		return age_sub;
	}
	public void setAge_sub(String age_sub) {
		this.age_sub = age_sub;
	}
	public String getId_sub() {
		return id_sub;
	}
	public void setId_sub(String id_sub) {
		this.id_sub = id_sub;
	}
	public String getPw_sub() {
		return pw_sub;
	}
	public void setPw_sub(String pw_sub) {
		this.pw_sub = pw_sub;
	}
	public Environment getEnv() {
		return env;
	}
	public void setEnv(Environment env) {
		this.env = env;
	}
	
	@Override
	public String toString() {
		return "AdminConnection [name=" + name + ", age=" + age + ", id=" + id + ", pw=" + pw + ", name_sub=" + name_sub
				+ ", age_sub=" + age_sub + ", id_sub=" + id_sub + ", pw_sub=" + pw_sub + ", env=" + env + "]";
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
		age = env.getProperty("admin.age");
		id= env.getProperty("admin.id");
		pw=env.getProperty("admin.pw");
		name_sub = env.getProperty("admin.name_sub");
		age_sub = env.getProperty("admin.age_sub");
		id_sub= env.getProperty("admin.id_sub");
		pw_sub=env.getProperty("admin.pw_sub");
	}
	
	
}
