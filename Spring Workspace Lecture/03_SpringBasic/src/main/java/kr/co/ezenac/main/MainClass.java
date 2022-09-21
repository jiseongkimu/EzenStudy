package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.HelloWorld;

public class MainClass {
	public static void main(String[] args) {
		// ApplicationContext : 스프링 컨테이너. BeanFactory 인터페이스의 하위 인터페이스.
		// ClassPath에 위치한 xml 파일을 읽어 설정 정보를 로딩, root로부터 경로를 지정함
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		
		// beans.xml에 정의한 bean 객체 주소값을 가져온다.
		HelloWorld hello1 = (HelloWorld)ctx.getBean("hello");
		callMethod(hello1);
		
		// beans.xml 없이 바로 지정
		HelloWorld hello2 = ctx.getBean("hello", HelloWorld.class);
		callMethod(hello2);
		ctx.close();
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
