package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1 : %s\n", xml1);
		
		ctx1.close();
		
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		TestBean1 java1 = ctx2.getBean("java1", TestBean1.class);
		System.out.printf("java1 : %s\n", java1);
		ctx2.close();
		
	}
	
}
