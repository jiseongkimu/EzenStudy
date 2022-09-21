package kr.co.ezanac.main;

import kr.co.ezenac.beans.HelloWorldEn;
import kr.co.ezenac.beans.HelloWorldKo;

public class MainClass {
	public static void main(String[] args) {
		HelloWorldEn hello1 = new HelloWorldEn();
		callMethod(hello1);
		
		HelloWorldEn hello2 = new HelloWorldEn();
		callMethod(hello2);
	}
	
	public static void callMethod(HelloWorldEn hello) {
		hello.sayHello();
	}
	
	public static void callMethod(HelloWorldKo hello) {
		hello.sayHello();
	}
}
