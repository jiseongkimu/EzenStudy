package kr.co.ezenac.beans;

public class TestBean1 {
	public void method1() {
		
		System.out.println("beans.TestBean1.method1()");
		line();
	}
	public void method1(int a1) {
		System.out.println("beans.TestBean1.method1()" + a1);
		line();
	}
	public void method1(String a2) {
		System.out.println("beans.TestBean1.method1()" + a2);
		line();
	}
	public void method1(int a, int b) {
		System.out.println("beans.TestBean1.method1()" + a + " " + b);
		line();
	}
	public void method1(int a1, String a2) {
		System.out.println("beans.TestBean1.method1()" + a1 + " " + a2);
		line();
	}
	public void method2() {
		System.out.println("beans.TestBean1.method2()");
		line();
	}
	public void method3() {
		System.out.println("beans.TestBean1.method3()");
		line();
	}
	public void line() {
		System.out.println("-------------------------------");
	}
}
