package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");

		TestBean bean1 = ctx.getBean("xml1", TestBean.class);
		
		int a1 = bean1.method1();
		System.out.printf("a1 : %d\n", a1);
		
		ctx.close();
	}
}
