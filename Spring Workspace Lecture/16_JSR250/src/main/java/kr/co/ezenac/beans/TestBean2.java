/*
 * @PostConstruct
 * 생성자 호출 후 실행
 * 
 * @PreDestroy
 * 소멸자 호출 전 실핼
 * 
 * */

package kr.co.ezenac.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class TestBean2 {
	public TestBean2() {
		System.out.println("TestBean2의 생성자");
	}
	
	@PostConstruct
	public void postCon() {
		System.out.println("TestBean2의 postCon");
	}
	
	public void init2() {
		System.out.println("TestBean2의 init");
	}
	
	@PreDestroy
	public void preDesttory() {
		System.out.println("TestBean2의 preDestroy");
	}
	
	public void destroy2() {
		System.out.println("TestBean2의 destroy");
	}
}
