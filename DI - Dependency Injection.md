# 💥의존성 주입
 (DI - Dependency Injection)

## 객체를 따로 관리한다.

## 객체를 따로 관리하는 법

- XML 에서 객체를 보관하는 법
- java에서 객체를 보관하는 법

위의 두가지 방법이 있지만 xml 에서 주로 보관하고 사용한다.

---

### XML 에서 객체를 보관

<beans> ~ </beans> 사이에 만들면 돼

그 사이에 개별적인 객체를 

<bean> ~ <bean> 사이에 만든다.

id		=> 생성할 bean 의 이름
class	=> bean을 생성할 클래스 이름을 풀 패키지 이름을 적는다.

💥객체를 저장하는 법

1. 멤버 변수 - 기본 

<property name="firstNum" value="12"/> ⇒ 멤버 변수 선언, 아래 테그처럼  방법은 2 가지가 있다.

1. 멤버 변수 - 배열
    
    아래 hobbies 처럼 <list> 테그를 활용한다.
    

```xml
<bean id="myCalculator" class="com.koreait.springDI1_xml_setter.MyCalculator">
	<property name="firstNum" value="12"/>
	<property name="secondNum">
	 	  	<value>4</value>
 	</property>
	<property name="hobbies">
			<list>
				<value>코딩</value>
				<value>조깅</value>
				<value>독서</value>
				<value>유튜브 시청</value>
				<value>축구</value>
			</list>
		</property>
</bean>
<!-- MyCalculator 타입의 myCalculator 객체 생성 -->
```

1. 생성자를 통한 멤버변수 초기화

<constructor-arg> 테그를 이용해서 초기화 시킬 데이터를 전달 할 수 있다.

<property> 테그는 name 속성에서 setter 를 실행할 멤버의 이름을 지정하므로 초기화 시키는 순서가

중요하지 않지만 <constructor-arg> 테그로 생성자를 이용해서 초기화 시킬 경우에는 생성자 인수의
개수, 순서 가 매우 중요하다. 반드시 일치 시켜줘야함.

```xml
<bean id="student" class="com.koreait.springDI3_xml_construntor.Student">
		<constructor-arg>
			<value>이우주</value>
		</constructor-arg>		
		<constructor-arg value="11"/>		
		<constructor-arg value="4"/>		
		<constructor-arg value="3"/>		
	</bean>
```

💥객체를 사용하는 법 ⇒ bean 을 읽어오기

아무리 객체들을 xml 에서 저장했지만 저장소에서 사용할 수 없다.

1. AbstractApplicationContext 타입의 객체를 GenericXmlApplicationContext 로 할당해서 사용

AbstractApplicationContext 의 추상 클래스가 GenericXmlApplicationContext의 부모 클래스라 이런 식으로 사용가능

```java
AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application_ctx.xml");
```

new GenericXmlApplicationContext("xml 파일 주소");

⇒ 이렇게 까지 작업이 진행됐으면 해당 링크의 xml 파일 안에 담아 둔 객체들의 생성자가 생성된다.

그 뒤 getBean() 메소드를 사용해서 각 클래스 타입별로 담아준 뒤 사용하면 된다.

```java
MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
//  getBean("xml 파일에서 선언한 bean 의 id", 클래스명.class)
```

---

### JAVA 에서 객체를 보관

⇒ @Annotation 을 사용한다.

```java
@Configuration		// 이 클래스는 DI 설정에 사용되는 클래스임을 스프림에게 알려준다.
public class ApplicationConfig {
// 이 영역은 xml 의 <beans> ~ </beans> 와 같은 역할을 한다고 볼 수 있다.
}
```

빈 생성하기

@Bean ⇒ 어노테이션 명시

클래스명 클래스 이름{ } 형식으로 작성 하고 루프 안에 클래스를 생성하고 멤버 변수들을 초기화 시킨 후 해당 객체를 리턴한다.

```java
@Configuration		
public class ApplicationConfig {
		@Bean
			public Student student() {
				Student student = new Student();
				student.setName("한지민");
				student.setAge(38);
				ArrayList<String> hobbies = new ArrayList<String>();
				hobbies.add("등산");
				hobbies.add("바둑");
				hobbies.add("조깅");
				student.setGradeNum(5);
				student.setHobbies(hobbies);
				return student;
	}
}

```

사용하기

AnnotationConfigApplicationContext  클래스를 생성하고

bean 객체를 저장한 클래스.class 를 인수로 넘겨서 객체로 할당하면 끝~

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
Student student =  context.getBean("student", Student.class);
```

---

## 둘 다 사용해서 bean(객체) 를 사용할 때

각자 만든다

xml 따로 

java 따로

bean 객체를 만든 뒤 사용

하지만 결국엔 한곳에 모아두어야 한다. 

방법은 2가지 

1. java로 몰아둔다 ⇒ 똑같이 annotation 을 이용한다.
@ImportResource("xml 파일 위치") 을 활용
    
    java 안에서 생성할 bean은 그 전에 사용한 방법을 이용한다.
    

```java
@ImportResource("classpath:application_ctx.xml") // => xml 파일에서 만들어둔 bean 객체들을 가져온다.
@Configuration		
public class ApplicationConfig {
	
	@Bean
	public Student student2() {
		Student student2= new Student("김태연", 33, 12, 23);
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("등산");
		hobbies.add("바둑");
		hobbies.add("조깅");
		student2.setHobbies(hobbies);
		return student2;
	}

}
```

1. xml 로 모아둔다.

<context:annotation-config/> ⇒ 테그를 활용한다.

<bean class="com.koreait.springDI7_xml_in_java.ApplicationConfig"></bean>

java 파일에서 설정한 메소드 이름이 id 역할을 하므로 bean테그에서 정의하는 id는 의미가 없다.

```xml
<beans>
	<!-- java 에서 저장한 bean을 긁어온다. -->
	<context:annotation-config/>
	<bean class="com.koreait.springDI7_xml_in_java.ApplicationConfig"></bean>

<!-- xml 에서 bean저장 -->
	<bean id="student" class="com.koreait.springDI7_xml_in_java.Student">
		<constructor-arg value="한지민"></constructor-arg>
		<constructor-arg value="39"></constructor-arg>
		<constructor-arg value="12"></constructor-arg>
		<constructor-arg value="3"></constructor-arg>
		<property name="hobbies">
			<list>
				<value>연기</value>
				<value>먹기</value>
				<value>운동하기</value>
			</list>
		</property>
	</bean>
</beans>
```