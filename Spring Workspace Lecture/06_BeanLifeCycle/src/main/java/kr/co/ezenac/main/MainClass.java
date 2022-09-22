package kr.co.ezenac.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.ezenac.beans.TestBean1;
import kr.co.ezenac.beans.TestBean2;
import kr.co.ezenac.beans.TestBean3;
import kr.co.ezenac.beans.TestBean4;

public class MainClass {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/ezenac/config/beans.xml");
		
		TestBean1 t1 = ctx.getBean("test1", TestBean1.class);
		TestBean2 t2 = ctx.getBean("test2", TestBean2.class);
		TestBean3 t3 = ctx.getBean("test3", TestBean3.class);
		TestBean4 t4 = ctx.getBean("test4", TestBean4.class);
		System.out.printf("t1(lazy-init=true init-method=bean1_init) : %s\n", t1);
		System.out.printf("t2(lazy-init=true init-method=bean2_init destroy-method=bean2_destroy) : %s\n", t2);
		System.out.printf("t3(lazy-init=true init-method=x,default destroy-method=x, default) : %s\n", t3);
		System.out.printf("t4(lazy-init=true init-method=bean1_init) : %s\n", t4);
		
		ctx.close(); // destroy가 호출됨
	}
}
