/*
 * @Autowired
 * 필드의 타입과 같은 bean을 찾아 bean클래스에서 자동 주입, 타입이 같으면 같은 주소값을 가짐
 * 
 * */
package kr.co.ezenac.beans;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBean4 {
	@Autowired
	private DataBean1 data1;
	@Autowired
	private DataBean2 data2;
	
	
	public DataBean1 getData1() {
		return data1;
	}
	
	
	public DataBean2 getData2() {
		return data2;
	}
	
	
}
