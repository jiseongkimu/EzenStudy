package kr.co.ezenac.beans;

public class TestBean1 {
	public TestBean1() {
		System.out.println("TestBean1의 생성자");
	}
	
	public void init() {
		System.out.println("TestBean1의 init");
	}
	
	public void destroy() {
		System.out.println("TestBean1의 destroy");
	}
}
