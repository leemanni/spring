# π₯μμ‘΄μ± μ£Όμ
 (DI - Dependency Injection)

## κ°μ²΄λ₯Ό λ°λ‘ κ΄λ¦¬νλ€.

## κ°μ²΄λ₯Ό λ°λ‘ κ΄λ¦¬νλ λ²

- XML μμ κ°μ²΄λ₯Ό λ³΄κ΄νλ λ²
- javaμμ κ°μ²΄λ₯Ό λ³΄κ΄νλ λ²

μμ λκ°μ§ λ°©λ²μ΄ μμ§λ§ xml μμ μ£Όλ‘ λ³΄κ΄νκ³  μ¬μ©νλ€.

---

### XML μμ κ°μ²΄λ₯Ό λ³΄κ΄

<beans> ~ </beans> μ¬μ΄μ λ§λ€λ©΄ λΌ

κ·Έ μ¬μ΄μ κ°λ³μ μΈ κ°μ²΄λ₯Ό 

<bean> ~ <bean> μ¬μ΄μ λ§λ λ€.

id		=> μμ±ν  bean μ μ΄λ¦
class	=> beanμ μμ±ν  ν΄λμ€ μ΄λ¦μ ν ν¨ν€μ§ μ΄λ¦μ μ λλ€.

π₯κ°μ²΄λ₯Ό μ μ₯νλ λ²

1. λ©€λ² λ³μ - κΈ°λ³Έ 

<property name="firstNum" value="12"/> β λ©€λ² λ³μ μ μΈ, μλ νκ·Έμ²λΌ  λ°©λ²μ 2 κ°μ§κ° μλ€.

1. λ©€λ² λ³μ - λ°°μ΄
    
    μλ hobbies μ²λΌ <list> νκ·Έλ₯Ό νμ©νλ€.
    

```xml
<bean id="myCalculator" class="com.koreait.springDI1_xml_setter.MyCalculator">
	<property name="firstNum" value="12"/>
	<property name="secondNum">
	 	  	<value>4</value>
 	</property>
	<property name="hobbies">
			<list>
				<value>μ½λ©</value>
				<value>μ‘°κΉ</value>
				<value>λμ</value>
				<value>μ νλΈ μμ²­</value>
				<value>μΆκ΅¬</value>
			</list>
		</property>
</bean>
<!-- MyCalculator νμμ myCalculator κ°μ²΄ μμ± -->
```

1. μμ±μλ₯Ό ν΅ν λ©€λ²λ³μ μ΄κΈ°ν

<constructor-arg> νκ·Έλ₯Ό μ΄μ©ν΄μ μ΄κΈ°ν μν¬ λ°μ΄ν°λ₯Ό μ λ¬ ν  μ μλ€.

<property> νκ·Έλ name μμ±μμ setter λ₯Ό μ€νν  λ©€λ²μ μ΄λ¦μ μ§μ νλ―λ‘ μ΄κΈ°ν μν€λ μμκ°

μ€μνμ§ μμ§λ§ <constructor-arg> νκ·Έλ‘ μμ±μλ₯Ό μ΄μ©ν΄μ μ΄κΈ°ν μν¬ κ²½μ°μλ μμ±μ μΈμμ
κ°μ, μμ κ° λ§€μ° μ€μνλ€. λ°λμ μΌμΉ μμΌμ€μΌν¨.

```xml
<bean id="student" class="com.koreait.springDI3_xml_construntor.Student">
		<constructor-arg>
			<value>μ΄μ°μ£Ό</value>
		</constructor-arg>		
		<constructor-arg value="11"/>		
		<constructor-arg value="4"/>		
		<constructor-arg value="3"/>		
	</bean>
```

π₯κ°μ²΄λ₯Ό μ¬μ©νλ λ² β bean μ μ½μ΄μ€κΈ°

μλ¬΄λ¦¬ κ°μ²΄λ€μ xml μμ μ μ₯νμ§λ§ μ μ₯μμμ μ¬μ©ν  μ μλ€.

1. AbstractApplicationContext νμμ κ°μ²΄λ₯Ό GenericXmlApplicationContext λ‘ ν λΉν΄μ μ¬μ©

AbstractApplicationContext μ μΆμ ν΄λμ€κ° GenericXmlApplicationContextμ λΆλͺ¨ ν΄λμ€λΌ μ΄λ° μμΌλ‘ μ¬μ©κ°λ₯

```java
AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:application_ctx.xml");
```

new GenericXmlApplicationContext("xml νμΌ μ£Όμ");

β μ΄λ κ² κΉμ§ μμμ΄ μ§νλμΌλ©΄ ν΄λΉ λ§ν¬μ xml νμΌ μμ λ΄μ λ κ°μ²΄λ€μ μμ±μκ° μμ±λλ€.

κ·Έ λ€ getBean() λ©μλλ₯Ό μ¬μ©ν΄μ κ° ν΄λμ€ νμλ³λ‘ λ΄μμ€ λ€ μ¬μ©νλ©΄ λλ€.

```java
MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
//  getBean("xml νμΌμμ μ μΈν bean μ id", ν΄λμ€λͺ.class)
```

---

### JAVA μμ κ°μ²΄λ₯Ό λ³΄κ΄

β @Annotation μ μ¬μ©νλ€.

```java
@Configuration		// μ΄ ν΄λμ€λ DI μ€μ μ μ¬μ©λλ ν΄λμ€μμ μ€νλ¦Όμκ² μλ €μ€λ€.
public class ApplicationConfig {
// μ΄ μμ­μ xml μ <beans> ~ </beans> μ κ°μ μ­ν μ νλ€κ³  λ³Ό μ μλ€.
}
```

λΉ μμ±νκΈ°

@Bean β μ΄λΈνμ΄μ λͺμ

ν΄λμ€λͺ ν΄λμ€ μ΄λ¦{ } νμμΌλ‘ μμ± νκ³  λ£¨ν μμ ν΄λμ€λ₯Ό μμ±νκ³  λ©€λ² λ³μλ€μ μ΄κΈ°ν μν¨ ν ν΄λΉ κ°μ²΄λ₯Ό λ¦¬ν΄νλ€.

```java
@Configuration		
public class ApplicationConfig {
		@Bean
			public Student student() {
				Student student = new Student();
				student.setName("νμ§λ―Ό");
				student.setAge(38);
				ArrayList<String> hobbies = new ArrayList<String>();
				hobbies.add("λ±μ°");
				hobbies.add("λ°λ");
				hobbies.add("μ‘°κΉ");
				student.setGradeNum(5);
				student.setHobbies(hobbies);
				return student;
	}
}

```

μ¬μ©νκΈ°

AnnotationConfigApplicationContext  ν΄λμ€λ₯Ό μμ±νκ³ 

bean κ°μ²΄λ₯Ό μ μ₯ν ν΄λμ€.class λ₯Ό μΈμλ‘ λκ²¨μ κ°μ²΄λ‘ ν λΉνλ©΄ λ~

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
Student student =  context.getBean("student", Student.class);
```

---

## λ λ€ μ¬μ©ν΄μ bean(κ°μ²΄) λ₯Ό μ¬μ©ν  λ

κ°μ λ§λ λ€

xml λ°λ‘ 

java λ°λ‘

bean κ°μ²΄λ₯Ό λ§λ  λ€ μ¬μ©

νμ§λ§ κ²°κ΅­μ νκ³³μ λͺ¨μλμ΄μΌ νλ€. 

λ°©λ²μ 2κ°μ§ 

1. javaλ‘ λͺ°μλλ€ β λκ°μ΄ annotation μ μ΄μ©νλ€.
@ImportResource("xml νμΌ μμΉ") μ νμ©
    
    java μμμ μμ±ν  beanμ κ·Έ μ μ μ¬μ©ν λ°©λ²μ μ΄μ©νλ€.
    

```java
@ImportResource("classpath:application_ctx.xml") // => xml νμΌμμ λ§λ€μ΄λ bean κ°μ²΄λ€μ κ°μ Έμ¨λ€.
@Configuration		
public class ApplicationConfig {
	
	@Bean
	public Student student2() {
		Student student2= new Student("κΉνμ°", 33, 12, 23);
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("λ±μ°");
		hobbies.add("λ°λ");
		hobbies.add("μ‘°κΉ");
		student2.setHobbies(hobbies);
		return student2;
	}

}
```

1. xml λ‘ λͺ¨μλλ€.

<context:annotation-config/> β νκ·Έλ₯Ό νμ©νλ€.

<bean class="com.koreait.springDI7_xml_in_java.ApplicationConfig"></bean>

java νμΌμμ μ€μ ν λ©μλ μ΄λ¦μ΄ id μ­ν μ νλ―λ‘ beanνκ·Έμμ μ μνλ idλ μλ―Έκ° μλ€.

```xml
<beans>
	<!-- java μμ μ μ₯ν beanμ κΈμ΄μ¨λ€. -->
	<context:annotation-config/>
	<bean class="com.koreait.springDI7_xml_in_java.ApplicationConfig"></bean>

<!-- xml μμ beanμ μ₯ -->
	<bean id="student" class="com.koreait.springDI7_xml_in_java.Student">
		<constructor-arg value="νμ§λ―Ό"></constructor-arg>
		<constructor-arg value="39"></constructor-arg>
		<constructor-arg value="12"></constructor-arg>
		<constructor-arg value="3"></constructor-arg>
		<property name="hobbies">
			<list>
				<value>μ°κΈ°</value>
				<value>λ¨ΉκΈ°</value>
				<value>μ΄λνκΈ°</value>
			</list>
		</property>
	</bean>
</beans>
```