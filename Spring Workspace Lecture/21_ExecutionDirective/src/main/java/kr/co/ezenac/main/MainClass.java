package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");

		TestBean1 xml1 = ctx.getBean("xml1", TestBean1.class);
		
		xml1.method1();
		xml1.method1(100);
		xml1.method1("문자열1");
		xml1.method1(100, 200);
		xml1.method1(300, "문자열1");
		
		ctx.close();
	}
}
