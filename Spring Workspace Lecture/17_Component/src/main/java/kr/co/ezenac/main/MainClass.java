package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans2.TestBean3;
import kr.co.ezenac.beans2.TestBean4;
import kr.co.ezenac.beans3.TestBean5;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		
		System.out.println("------------------------------------------------------------------");
		TestBean1 xml1 = ctx1.getBean(TestBean1.class);
		TestBean2 xml2 = ctx1.getBean("xml2", TestBean2.class);
		TestBean2 xml3 = ctx1.getBean("xml3", TestBean2.class);
		TestBean3 xml4 = ctx1.getBean(TestBean3.class);
		TestBean2 xml5 = ctx1.getBean("xml5", TestBean2.class);
		TestBean4 xml100 = ctx1.getBean("xml100", TestBean4.class);
		TestBean4 xml200 = ctx1.getBean("xml200", TestBean4.class);
		
		System.out.printf("xml1 : %s\n", xml1);
		System.out.printf("xml2 : %s\n", xml2);
		System.out.printf("xml3 : %s\n", xml3);
		System.out.printf("xml4 : %s\n", xml4);
		System.out.printf("xml5 : %s\n", xml5);
		System.out.printf("xml100 : %s\n", xml100);
		System.out.printf("xml200 : %s\n", xml200);
		
		System.out.println("------------------------------------------------------------------");
		
		TestBean5 xml500 = ctx1.getBean(TestBean5.class);
		System.out.printf("xml500 : %s\n", xml500);
		
		ctx1.close();
		
		System.out.println("==================================================================");
		
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		TestBean1 java1 = ctx2.getBean(TestBean1.class);
		TestBean2 java2 = ctx2.getBean("java2", TestBean2.class);
		TestBean2 java3 = ctx2.getBean("java3", TestBean2.class);
		TestBean3 java4 = ctx2.getBean("testBean3", TestBean3.class);
		TestBean4 java5 = ctx2.getBean("bean4", TestBean4.class);
		TestBean4 java100 = ctx2.getBean("java100", TestBean4.class);
		TestBean4 java200 = ctx2.getBean("java200", TestBean4.class);
		
		System.out.printf("java1 : %s\n", java1);
		System.out.printf("java2 : %s\n", java2);
		System.out.printf("java3 : %s\n", java3);
		System.out.printf("java4 : %s\n", java4);
		System.out.printf("java5 : %s\n", java5);
		System.out.printf("java100 : %s\n", java100);
		System.out.printf("java200 : %s\n", java200);
		
		ctx2.close();

	}

}

