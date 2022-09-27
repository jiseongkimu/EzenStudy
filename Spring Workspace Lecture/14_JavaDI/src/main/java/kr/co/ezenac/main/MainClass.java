package kr.co.ezenac.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.config.BeanConfigClass;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		
		TestBean1 xml1 = ctx1.getBean("xml1", TestBean1.class);
		System.out.printf("xml1.data1 : %d\n", xml1.getData1());
		System.out.printf("xml1.data2 : %s\n", xml1.getData2());
		System.out.printf("xml1.data3 : %s\n", xml1.getData3());
		
		TestBean1 xml2 = ctx1.getBean("xml2", TestBean1.class);
		System.out.printf("xml2.data1 : %d\n", xml2.getData1());
		System.out.printf("xml2.data2 : %s\n", xml2.getData2());
		System.out.printf("xml2.data3 : %s\n", xml2.getData3());
		
		TestBean1 xml3 = ctx1.getBean("xml3", TestBean1.class);
		System.out.printf("xml3.data1 : %d\n", xml3.getData1());
		System.out.printf("xml3.data2 : %s\n", xml3.getData2());
		System.out.printf("xml3.data3 : %s\n", xml3.getData3());
		
		System.out.println("=====================================================");
		
		ctx1.close();
		
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		TestBean1 java1 = ctx2.getBean("java1", TestBean1.class);
		System.out.printf("java1.data1 : %d\n", java1.getData1());
		System.out.printf("java1.data2 : %s\n", java1.getData2());
		System.out.printf("java1.data3 : %s\n", java1.getData3());
		
		TestBean1 java2 = ctx2.getBean("java2", TestBean1.class);
		System.out.printf("java2.data1 : %d\n", java2.getData1());
		System.out.printf("java2.data2 : %s\n", java2.getData2());
		System.out.printf("java2.data3 : %s\n", java2.getData3());
		
		
		
		ctx2.close();
		
	}
	
}
