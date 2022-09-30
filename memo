**컨테이너** 
객체의 생명주기를 관리하며 생성된 인스턴스(자바 객체)에 추가적인 기능을 제공하는 역할을 한다. 여기서 말하는 자바 객체는 스프링에서는 빈(Bean)이라고 한다.

**IoC**
개발자는 new 연산자, 인터페이스 호출, 팩토리 호출 방식으로 객체를 생성하고 소멸시킬 수 있는데, 스프링 컨테이너가 이 역할을 대신 해준다. 즉 제어 흐름을 외부에서 관리하는 것이다.

또한 객체들 간의 의존 관계를 런타임 과정에서 알아서 만들어 준다. DI는 생성자, setter, @Autowired를 통해 적용한다
(컴포넌트 의존관계 설정(Component dependency resoulution), 설정(Configuration) 및 생명주기(LifeCycle)을 해결하기 위한 디자인 패턴)

이렇게 IoC패턴으로 디자인된 컨테이너를 다음과 같이 말한다.

**IoC 컨테이너(스프링 컨테이너)**
스프링 프레임워크에서 컨테이너의 역할을 수행한다.  인스턴스 생성부터 소멸까지의 인스턴스 생명주기 관리를 개발자가 아닌 컨테이너가 대신 해준다.
객체관리 주체가 프레임워크(Container)가 되기 때문에 개발자는 로직에 집중할 수 있는 장점이 있다.
-   IoC 컨테이너는 객체의 생성을 책임지고, 의존성을 관리한다.
-   POJO의 생성, 초기화, 서비스, 소멸에 대한 권한을 가진다.
-   개발자들이 직접 POJO를 생성할 수 있지만 컨테이너에게 맡긴다.
-   개발자는 비즈니스 로직에 집중할 수 있다.
-   객체 생성 코드가 없으므로 TDD가 용이하다.

> **POJO(Plain Old Java Object)란?** 주로 특정 자바 모델이나 기능, 프레임워크를 따르지 않는 Java Object를 지칭한다.  
Java Bean 객체가 대표적이다.  
ex : getter / setter

BeanFactory와 그걸 상속받은 ApplicationContext 두 개가 있음.

일반적으로 스프링의 IoC 컨테이너는 애플리케이션 컨텍스트를 의미함(요즘엔 DI컨테이너라고 한다?)

**BeanFactory**
deprecated 됐으니 딴 거 써라.
```
// 패키지 내부 : ClassPathResource
ClassPathResource res = new ClassPathResource("kr/co/ezenac/config/beans.xml");
// 패키지 외부 : FileSystemResource
FileSystemResource res = new FileSystemResource("beans.xml");

// 빈 팩토리 생성
XmlBeanFactory factory = new XmlBeanFactory(res);

// Lazy-loading
// 빈 팩토리로 부터 빈을 취득, 이 때 getBean()을 통해서 빈을 인스턴스화 할 수 있다.
TestBean t1 = factory.getBean("t1", TestBean.class);

// 같은 id로 빈을 생성 -> 이미 존재한다면 새로 생성하지 않음
TestBean t2 = factory.getBean("t1", TestBean.class);
```

**ApplicationContext**
BeanFactory를 상속하는 인터페이스
```
// Pre-loading : 모든 빈들과 설정 파일들이 ApplicationContext에 의해 로드 요청이 될 때 인스턴스로 만들어지고 로드된다.
// 패키지 내부
ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
// 패키지 외부
FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");

// 미리 컨테이너에서 만들어진 빈들이 getBean()을 통해 클라이언트로 리턴된다.
TestBean t1 = ctx.getBean("t1", TestBean.class);
```


**bean**
1.인터페이스 구현

    public  class  BookDao  implements  InitializingBean, DisposableBean{
	    @Override  public  void  afterPropertiesSet()  throws Exception{
		// 빈 초기화 시 코드 구현
		}
	    
		@Override  public  void  destroy()  throws Exception{
		// 빈 소멸 시 코드 구현
		}
	}

 

2.스프링 xml 설정

    <bean id="아이디" class="클래스"/>
    
id : 스프링 bean이 인식하는 식별자
class : 객체를 생성할 클래스
- lazy-init : 싱글톤인 경우 xml을 로딩할 때 객체 생성 여부를 설정한다. (true : 객체를 가져올 때 = getBean() 호출 시 생성)
- scope : 객체 범위 설정
	- singleton(default) : 객체를 하나만 생성해서 사용
	- prototype : 객체를 가져올 때마다 생성

destroy는  init의 역순(stack)

**constructor-arg**
생성자의 가변인자에 값을 할당한다.
```
<bean id="아이디" class="클래스">
    <constructor-arg value="값"/>
    <constructor-arg ref="참조값"/>
</bean>
```
value : 원시형 데이터
ref : 참조형 데이터(bean으로 생성한 객체의 id)

**property**
필드, 클래스 변수나 인스턴스 변수를 의미하며 setter 메서드를 이용해 값을 할당한다. 따라서 setter가 없으면 사용할 수 없다.
```
1. body가 있는 경우
<bean id="아이디" class="클래스">
    <property name="변수명">
        <value type="클래스_타입">값</value>
        <ref bean="참조값"/>
    </property>
</bean>

2. body가 없는 경우
<bean id="아이디" class="클래스">
    <property name="변수명" value="값"/>
    <property name="변수명" ref="참조값"/>
</bean>
```


**BeanPostProcessor**
Bean 객체를 정의할 때 ini-method 속성을 정의하면 객체가 생성될 때 자동으로 호출된다.
이때 BeanPostProcessor 인터페이스를 구현하면 해당 Bean 객체의 init 메소드 호출을 block하고 다른 메소드를 호출할 수 있다. init-method가 없어도 호출됨

postProcessBeforeInitialization : init-method에 지정된 메소드가 호출되기 전에 호출됨
postProcessAferInitialization : ini-method에 지정된 메소드가 호출된 후에 호출됨
```
package kr.co.ezenac.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("before");
		System.out.println("beanName = " + beanName);
		
		switch(beanName) {
		case "t1" : 
			System.out.println("id : t1");
			break;
		case "t2" : 
			System.out.println("id : t2");
		}

		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("after");
		System.out.println("beanName = " + beanName);
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	

}

```

```
<bean id="t1" class="kr.co.ezenac.beans.TestBean1"
	lazy-init="true" init-method="bean1_init"></bean>
		
<bean id="t2" class="kr.co.ezenac.beans.TestBean2"
	lazy-init="true" init-method="bean2_init"></bean>
<bean class="kr.co.ezenac.processor.TestBeanPostProcessor"></bean>
</beans>
```
메인 결과 :
TestBean2의 생성자
before // before
beanName = t2  // before
id : t2
TestBean2의 init // init
after // after
beanName = t2 // after



**의존성 주입(Dependency Injection)**
Bean객체를 생성할 때 Bean 객체가 관리할 값이나 객체를 주입하는 걸 의미함. 객체 생성 후 Bean 객체가 가질 기본값을 자바 코드로 설정하는 것이 아닌 Bean을 정의한 xml에서 정의하는 개념. 생성자 매개변수의 순서를 지켜야함. index 쓰면 무관
- value : 기본 자료형 값과 문자열 값을 설정
- ref : 객체를 설정
- type : 저장할 값의 타입
- index : 지정된 값을 주입할 생성자의 매개변수 인덱스

```
index
<bean id="obj7"
	class="kr.co.ezenac.beans.TestBean1"
	lazy-init="true">
		<constructor-arg value="44.44" type="double" index="1"></constructor-arg>
		<constructor-arg value="Spring" type="java.lang.String" index="2"></constructor-arg>
		<constructor-arg value="200" index="0"></constructor-arg>
	</bean>
```

```
생성자 주입
1. 생성자 태그에 직접 주입
<bean id="test2"
	class="kr.co.ezenac.beans.TestBean2"
	lazy-init="true">
	<constructor-arg>
		<bean class="kr.co.ezenac.beans.DataBean"></bean>
	</constructor-arg>
	<constructor-arg>
		<bean class="kr.co.ezenac.beans.DataBean"></bean>
	</constructor-arg>
</bean>
	
2. 따로 생성 후 참조하여 주입
<bean id="data_bean" class="kr.co.ezenac.beans.DataBean" scope="prototype"></bean>
<bean id="obj9" class="kr.co.ezenac.beans.TestBean2" lazy-init="true">
	<constructor-arg ref="data_bean"></constructor-arg>
	<constructor-arg ref="data_bean"></constructor-arg>
</bean>
```

Setter 메소드를 통한 주입
Bean을 정의할 때 Bean 객체가 가지고 있을 기본값을 생성자가 아닌 Setter를 통해 주입할 수 있다.
- name : 데이터를 주입할 프로퍼티의 이름
- value : 기본 자료형 및 문자열
- ref : 객체의 주소값

```
<!-- 1. 따로 bean 생성 후 ref 태그로 참조하여 주입 -->
	<bean id="data_bean" class="kr.co.ezenac.beans.DataBean" scope="prototype"></bean>
	<bean id="t1"
		class="kr.co.ezenac.beans.TestBean">
		<property name="data1" value="100"></property>
		<property name="data2" value="11.11"></property>
		<property name="data3" value="true"></property>
		<property name="data4" value="ㅎㅇ"></property>
		<!-- 2. property 태그 안에서 직접 생성하여 주입 -->
		<property name="data5"><bean class="kr.co.ezenac.beans.DataBean"></bean></property>
		<!-- 1 -->
		<property name="data6" ref="data_bean"></property>
	</bean>
```

**List**
선언
```private List<String> list1;```

xml
```
<bean id="t1" class="kr.co.ezenac.beans.TestBean">
	<property name="list1">
		<list>
			<value>목록1</value>
			<value>목록2</value>
			<value>목록3</value>
		</list>
	</property>
</bean>
```

메인에서 출력
```
ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		
TestBean t1 = ctx.getBean("t1", TestBean.class);
List<String> list1 = t1.getList1();
for(String i : list1) {
	System.out.printf("getList1 : %s\n",i);
}
```

ref를 이용한 bean 참조
```
<property name="list3">
	<list>
		<bean class="kr.co.ezenac.beans.DataBean"></bean>
		<bean class="kr.co.ezenac.beans.DataBean"></bean>
		<ref bean="data_bean"></ref>
	</list>
	</property>
</bean>
<bean id="data_bean" class="kr.co.ezenac.beans.DataBean"></bean>
```
bean을 직접 주입하면 새로운 객체를 생성하지만, ref는 새로운 객체를 생성하지 않고 하나의 객체를 계속해서 참조한다.
만약 scope 속성에 prototype을 추가하면 새로운 객체를 생성하여 참조한다.


객체를 주입할 때 자동으로 주입 될 수 있도록 설정할 수 있다. 이름, 타입, 생성자를 통해 auto wire라는 키워드를 사용한다.
byName : 빈 객체의 프로퍼티 이름과 정의된 빈의 이름이 같은 것을 찾아 주입
byType : 빈 객체의 프로퍼티 타입과 정의된 빈의 이름이 같은 것을 찾아 주입
같은 타입의 빈이 두 개 있으면 오류
constructor : 생성자의 매개 변수 타입과 정의된 빈의 타입이 일치할 경우 주입된다.
같은 타입의 빈이 두 개 있으면 오류


**Java 코드를 활용한 Bean 등록**

**@Configuration**
해당 클래스가 xml을 대체하는 설정 파일임을 알려준다. 해당 클래스를 설정 파일로 설정하고 ```@ComponentScan```을 통해 ```basePackages```를 설정해준다.
(해당 클래스(AppContext)를 스프링 설정 클래스로 지정
스프링은 객체를 생성하고 초기화하는 기능을 제공)

**@ComponentScan**
빈으로 등록 될 클래스(```@Controller```, ```@Service```, ```@Component```, ```@Repository``` 어노테이션을 적용한 클래스)를 스캔하여 등록해준다.
```@Controller```나 ```@Service```는 ```@Component```를 포함하고 있다.

**ComponentScan 동작 과정**
ConfigurationClassParser 가 Configuration 클래스를 파싱한다.
```@Configuration``` 어노테이션 클래스를 파싱하는 것이다.
                   ⬇
ComponentScan 설정을 파싱한다.
base-package 에 설정한 패키지를 기준으로
ComponentScanAnnotationParser가 스캔하기 위한 설정을 파싱한다.
                   ⬇
base-package 설정을 바탕으로 모든 클래스를 로딩한다.
                   ⬇
ClassLoader가 로딩한 클래스들을 BeanDefinition으로 정의한다.
생성할 빈의 대한 정의를 하는 것이다.
                   ⬇
생성할 빈에 대한 정의를 토대로 빈을 생성한다.

**@Bean**
bean 객체를 정의할 때 사용.
메서드의 이름이 bean의 이름이 된다(xml에서 id)
@Bean(name=이름) : bean의 이름을 새로 정의
@Lazy : lazi-init
@Scope : bean의 scope
@Primary : primary

main
AnnotationConfigApplicationContext
AppContext에 정의한 @Bean 설정 정보를 읽어와 해당 객체를 생성, 초기화한다.

init, destroy메서드
객체가 생성되거나 소멸될 때

javaDI
bean에 대한 주입은 생성자를 직접 호출하거나 setter 메서드를 직접 호출하여 값을 주입한다.


220929

1. Bean으로 만들 클래스 생성
2. ```@Configuration``` 클래스에서 ```@Bean```을 통해 메서드 설정
3. 메인에서 컨테이너를 통해 초기화 및 생성, ```getBean()```으로 
참조

**기존 BeanConfigClass의 어노테이션을 통한 init, destroy**
```@Bean(initMethod="init1", destroyMethod="destroy1")```

스프링에서 기본으로 제공되지는 않지만 자바 플랫폼 공통 어노테이션인 JSR-250을 라이브러리 추가를 통해 적용할 수 있으며 다음과 같은 기능을 Bean클래스에서 직접 사용할 수 있다.

**@postConstruct**
생성자 호출 후 자동으로 호출될 함수를 지정한다.

**preDestroy**
객체 소멸 전 자동으로 호출될 함수를 지정한다.

**@Resource**
Bean의 이름을 통해 주입한다.

**@Autowired**
bean의 타입을 통해 bean클래스에서 자동 주입, 타입이 같으면 같은 주소값을 가짐
```
@Autowired
private DataBean1 data1;
@Autowired
private DataBean2 data2;
```

220930
@Bean을 통해 설정했던 주입과 동일한 방식을 이용
@Autowired : 타입을 통한 자동 주입
@Qualifier : 이름을 통한 자동 주입
생성자의 경우 타입과 같은 Bean을 찾아 자동 주입
Component를 이용한 자동 주입 설정

AOP(Aspect Oriented Programming) : 관점 지향 프로그래밍
하나의 프로그램을 관점이라는 논리적인 단위로 나누어 관리하는 개념
메서드 호출을 관심사로 설정하여 aop개념을 이해한다

Spring AOP 용어
Joint Point : 모듈이 삽입되어 동작하게 되는 특정위치(메서드 호출)
Point Cut : 다양한 조인트 포인트 중에 어떤 것을 사용할지 선택
Advice : 조인트 포인트에 삽입되어 동작할 수 있는 코드
Weaving : Advice를 핵심 로직 코드에 적용하는 것
Aspect : Point cut + Advice

Spring AOP Advice 종류
before : 메서드 호출전에 동작
after-returning : 예외없이 호출된 메서드의 동작이 완료되면 동작
after : 예외 발생 여부에 관계없이 호출된 메서드의 동작이 완료되면 동작
after-throwing : 호출된 메서드 동작 중 예외가 발생했을 때
around : 메서드 호출 전과 후에 동작

