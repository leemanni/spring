# 💥객체의 생명주기 (LifeCycle)

즉, 객체를 가져와서 사용하는 기능만 부여받는 것이 아니라 다 쓰면 지워주는 역할도 한다. 


콜백 함수들..

```java
//	afterPropertiesSet() 메소드는 bean이 생성(생성자가 실행)된 후 자동으로 실행할 내용을 구현한다.
//	이건 자동으로 싱행되는 콜백 함수다
@Override
public void afterPropertiesSet() throws Exception {
    System.out.println("Greeter is born.");
}

//	destroy() => bean 이 소멸된(DI 컨테이너 에서 close() 메소드가 실행)된 후 자동으로 실행될 내용을
//	구현한다.
@Override
public void destroy() throws Exception {
    System.out.println("I'm gone.");
}
```

💥객체를 사용하는 새로운 방법

```java
// 빈 컨테이너를 만들어 준다.
// 아직 까지 미리 만들어 둔 bean 들이 주입되기 전,
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); 

// bean들의 생성 정보를 넣어준다. 
// 즉, bean 들이 저장된 xml 파일의 위치 를 알려주는 것
// 아직까지 bean들을 가져온 것은 아님
ctx.load("classpath:applicationCTX_dev.xml", "classpath:applicationCTX_run.xml"); // 빈 생성

//load() 에 의해 불러온 <beans> 안의 bean 들 을 읽어들인다.
// 이때 bean 들의 생성자가 실행된다!!!
ctx.refresh();

ctx.getEnvironment().setActiveProfiles("dev"); //환경 설정을 한다
.
.  사용
.

// 사용을 끝낸 bean 을 소멸시킨다.
ctx.close()
```

++ 다른 파일에 bean 들이 있으면 profile 을 이용해서 가져올 수 잇음

profile="dev" ⇒ 이런 식으로 지정한 다음 위의 java 코드를 보면 환경설정을 통해 여러개의 xml 이 있어도 profile 을 지정하면 쉽게 분류 가능

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

자바는 @Annotation 을 활용한다.

@Profile("이름") ⇒ 이런식으로 class 로 만들어서 사용한다.

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
