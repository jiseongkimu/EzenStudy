/*
 * BeanConfig @Bean(initMethod="init1", destroyMethod="destroy1")
 * 
 * */
package kr.co.ezenac.beans;

import org.springframework.context.annotation.Bean;

public class TestBean1 {
	public TestBean1() {
		System.out.println("TestBean1의 생성자");
	}
	
	public void init1() {
		System.out.println("TestBean1의 init");
	}
	
	public void destroy1() {
		System.out.println("TestBean1의 destroy");
	}
}
