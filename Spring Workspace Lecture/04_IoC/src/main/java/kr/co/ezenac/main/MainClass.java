package kr.co.ezenac.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.ezenac.beans.TestBean;

public class MainClass {
	public static void main(String[] args) {
		//BeanFactoryIn();
		//BeanFactoryEx();
		//AppContextIn();
		AppContextEx();
	}
	
	// BeanFactory(deprecated) - 패키지 내부
	public static void BeanFactoryIn() {
		ClassPathResource res = new ClassPathResource("kr/co/ezenac/config/beans.xml");
		
		// bean.xml에서 설정한 객체를 바로 생성하지 않음
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		// getBean()으로 호출해야 생성 가능
		TestBean t1 = factory.getBean("t1", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		// 같은 id로 객체를 생성 -> 이미 존재한다면 새로 생성하지 않음
		TestBean t2 = factory.getBean("t1", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
	}
	// 패키지 외부
	public static void BeanFactoryEx() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		TestBean t1 = factory.getBean("t2", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = factory.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t1);
	}
	
	// ApplicationContext - 패키지 내부
	public static void AppContextIn() {
		// 로딩할 때 객체 생성
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		System.out.printf("ctx :  %s\n", ctx);
		/*
		TestBean t1 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = ctx.getBean("t1", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		*/
		ctx.close();
	}
	
	public static void AppContextEx() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		/*
		TestBean t1 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t1);
		
		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.printf("t2 : %s\n", t2);
		*/
		ctx.close();
	}
}
