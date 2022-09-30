package kr.co.ezenac.beans;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope("prototype")
public class TestBean5 {
	
	public TestBean5() {
		System.out.println("TestBean5의 생성자");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init메서드");
	}
}
