package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		// 패키지는 다르나 클래스 이름이 같은 경우? 패키지까지 입력
		TestBean1 xml1 = ctx.getBean("xml1", TestBean1.class);
		TestBean2 xml2 = ctx.getBean("xml2", TestBean2.class);
		kr.co.ezenac.beans2.TestBean1 xml3 = ctx.getBean("xml3", kr.co.ezenac.beans2.TestBean1.class);
		
		xml1.method1();
		xml1.method1(100);
		xml1.method1("문자열1");
		xml1.method1(100, 200);
		xml1.method1(300, "문자열1");
		xml1.method2();
		xml1.method3();
		
		
		xml2.method1();
		
		xml3.method1();
		ctx.close();
	}
}
