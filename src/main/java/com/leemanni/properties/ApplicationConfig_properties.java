package com.leemanni.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationConfig_properties {
	@Value("${admin.name}")
	private String name;
	@Value("${admin.age}")
	private String age;
	@Value("${admin.id}")
	private String id;
	@Value("${admin.pw}")
	private String pw;
	
	@Bean
	public AdminConnection_noneEnv adminConnection_noneEnv() {
		AdminConnection_noneEnv adminConnection_noneEnv = new AdminConnection_noneEnv();
		adminConnection_noneEnv.setName(name);
		adminConnection_noneEnv.setAge(age);
		adminConnection_noneEnv.setId(id);
		adminConnection_noneEnv.setPw(pw);
		return adminConnection_noneEnv;
	}
	
	@Bean
	public PropertySourcesPlaceholderConfigurer configurer() {
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		Resource [] resources = new Resource[2];
		resources[0] = new ClassPathResource("admin.properties");
		resources[1] = new ClassPathResource("admin_sub.properties");
		
		placeholderConfigurer.setLocations(resources);
		return placeholderConfigurer;
	}
}
