# π₯κ°μ²΄μ μλͺμ£ΌκΈ° (LifeCycle)

μ¦, κ°μ²΄λ₯Ό κ°μ Έμμ μ¬μ©νλ κΈ°λ₯λ§ λΆμ¬λ°λ κ²μ΄ μλλΌ λ€ μ°λ©΄ μ§μμ£Όλ μ­ν λ νλ€. 


μ½λ°± ν¨μλ€..

```java
//	afterPropertiesSet() λ©μλλ beanμ΄ μμ±(μμ±μκ° μ€ν)λ ν μλμΌλ‘ μ€νν  λ΄μ©μ κ΅¬ννλ€.
//	μ΄κ±΄ μλμΌλ‘ μ±νλλ μ½λ°± ν¨μλ€
@Override
public void afterPropertiesSet() throws Exception {
    System.out.println("Greeter is born.");
}

//	destroy() => bean μ΄ μλ©Έλ(DI μ»¨νμ΄λ μμ close() λ©μλκ° μ€ν)λ ν μλμΌλ‘ μ€νλ  λ΄μ©μ
//	κ΅¬ννλ€.
@Override
public void destroy() throws Exception {
    System.out.println("I'm gone.");
}
```

π₯κ°μ²΄λ₯Ό μ¬μ©νλ μλ‘μ΄ λ°©λ²

```java
// λΉ μ»¨νμ΄λλ₯Ό λ§λ€μ΄ μ€λ€.
// μμ§ κΉμ§ λ―Έλ¦¬ λ§λ€μ΄ λ bean λ€μ΄ μ£ΌμλκΈ° μ ,
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); 

// beanλ€μ μμ± μ λ³΄λ₯Ό λ£μ΄μ€λ€. 
// μ¦, bean λ€μ΄ μ μ₯λ xml νμΌμ μμΉ λ₯Ό μλ €μ£Όλ κ²
// μμ§κΉμ§ beanλ€μ κ°μ Έμ¨ κ²μ μλ
ctx.load("classpath:applicationCTX_dev.xml", "classpath:applicationCTX_run.xml"); // λΉ μμ±

//load() μ μν΄ λΆλ¬μ¨ <beans> μμ bean λ€ μ μ½μ΄λ€μΈλ€.
// μ΄λ bean λ€μ μμ±μκ° μ€νλλ€!!!
ctx.refresh();

ctx.getEnvironment().setActiveProfiles("dev"); //νκ²½ μ€μ μ νλ€
.
.  μ¬μ©
.

// μ¬μ©μ λλΈ bean μ μλ©Έμν¨λ€.
ctx.close()
```

++ λ€λ₯Έ νμΌμ bean λ€μ΄ μμΌλ©΄ profile μ μ΄μ©ν΄μ κ°μ Έμ¬ μ μμ

profile="dev" β μ΄λ° μμΌλ‘ μ§μ ν λ€μ μμ java μ½λλ₯Ό λ³΄λ©΄ νκ²½μ€μ μ ν΅ν΄ μ¬λ¬κ°μ xml μ΄ μμ΄λ profile μ μ§μ νλ©΄ μ½κ² λΆλ₯ κ°λ₯

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd"
	profile="dev"
	>
	<!-- profile="dev" -->
	<bean id="serverInfo" class="com.koreait.springProfile1_xml.ServerInfo">
		<property name="ipNumber" value="localhost"></property>
		<property name="protNumber" value="9090"></property>
	</bean>

</beans>
```

μλ°λ @Annotation μ νμ©νλ€.

@Profile("μ΄λ¦") β μ΄λ°μμΌλ‘ class λ‘ λ§λ€μ΄μ μ¬μ©νλ€.

```java
@Configuration
@Profile("run")
public class ApplicationConfigRun {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIpNumber("192.608.172.100");
		info.setProtNumber("8080");
		return info;
	}
}
```
